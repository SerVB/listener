#include "myStepper.h"
#include "myServo.h"

/* Азимут: */
const int cHOR_STEP_DELAY           = 10;            // Время поворота шаговика на один шаг/полушаг в мс
const int cHOR_MAX_STEPS_ONE_DIR    = 600;           // Максимальное кол-во шагов/полушагов шаговика в одну сторону (защита от перекручивания проводов)
const int cHOR_PINS[]               = {3, 5, 6, 11}; // Пины подключения шаговика
const int cHOR_STEPS_PER_REVOLUTION = 400;           // Количество шагов/полушагов шаговика на один оборот

myStepper horStepper(cHOR_STEPS_PER_REVOLUTION,      // Объект шаговика
                     cHOR_MAX_STEPS_ONE_DIR,
                     cHOR_STEP_DELAY,
                     cHOR_PINS[0], cHOR_PINS[1], cHOR_PINS[2], cHOR_PINS[3]);
/* Конец азимута */

/* Высота: */
const int cVER_PIN   = 13;   // Пин подключения серво
const int cVER_DELAY = 15;   // Время поворота серво на один градус в мс

myServo verServo(cVER_DELAY, // Объект серво
                 cVER_PIN);
/* Конец высоты */

const int cSENSOR_PIN = A0; // Пин аналогового датчика

boolean printed = false; // Напечатан ли призыв к отправке данных компьютером

/* Полученная с ПК задача: */
int horReadBegin;
int horReadEnd;
int horReadAc;

bool horUnitDeg;    // В градусах ли посланы координаты по азимуту
bool horAcUnitDeg;  // В градусах ли послан шаг по азимуту

int verDegBegin;
int verDegEnd;
int verDegAc;

int numOfRep;       // Количество повторов
int movingType;     // Тип обхода сектора

int waitBeforeMeas; // Задержка перед каждым измерением
int sensorType;     // Параметры сенсора
/* Конец задачи */

/* Сконвертированная задача: */
int horStepBegin;
int horStepEnd;
int horStepAc;
/* Конец сконвертированной задачи */

String (*meas)(void); // Указатель на нужный метод сканирования

/* Для ИК датчика: */
#include <Wire.h>             // I2C library, required for MLX90614
#include <SparkFunMLX90614.h> // SparkFunMLX90614 Arduino library
IRTherm therm;                // Create an IRTherm object to interact with throughout

float tempFrom = -50.0; // Минимальная температура, все что ниже будет приравнено к минимуму
float tempTo   =  50.0; // Максимальная температура, аналогично выше

const double cDOUBLE_MULTYPLIER = 100.0; // Множитель
/* Для ИК датчика */

/**
 * Паркует установку: устанавливает серво в позицию deg и блокирует установку.
 */
inline void parking(int deg) {
  Serial.println("=park= To " + String(deg) + "degs;"); // "Начало парковки"
  verServo.toDeg(deg);                                  // Переместить серво
  Serial.println("=park= Park successful!;");           // "Парковка завершена"
  
  while(true) {}                                        // Заблокировать установку
}

/**
 * Возвращает измерение с аналога: усредняет значения аналога за 20 мс.
 */
inline int measAnalog20() {
  unsigned long long sum = 0;                 // Сумма значений
  unsigned long long numOfMes = 0;            // Количество измерений
  unsigned long startms = millis();           // Время начала измерений
  
  while (millis() - startms < 20) {           // Сбор данных в течение 20 мс
    sum += analogRead(cSENSOR_PIN);           // Учесть значение с датчика
    numOfMes++;                               // Увеличить кол-во выполненных измерений
  }
  
  float ans = (0.0 + sum) / (0.0 + numOfMes); // Рассчитать результат
  return round(ans);                          // Вернуть округленный результат
}

/**
 * Возращает строку измерения с аналога: усредняет значения аналога за 20 мс.
 * Измерение с ИК-датчика принимается равным за -4200.
 */
inline String meas0() {
  delay(waitBeforeMeas);                 // Сделать задержку перед измерениями
  
  return String(measAnalog20()) + " -4200"; // Вернуть строку измерения
}

/**
 * Возвращает измерение с ИК-датчика: усредняет значения датчика за 20 мс.
 */
inline double measIr20() {
  double sum = 0.0;                 // Сумма значений
  unsigned long long numOfMes = 0;  // Количество измерений
  unsigned long startms = millis(); // Время начала измерений
  
  while (millis() - startms < 20) { // Сбор данных в течение 20 мс
    if (therm.read()) {             // Если данные считываются
      sum += therm.object();        // Учесть данные с датчика
      numOfMes++;                   // Увеличить кол-во выполненных измерений
    }
  }
  
  return sum / numOfMes;            // Вернуть результат
}

/**
 * Домножает значение ИК-датчика и возвращает округленный результат.
 * Следует использовать для конвертации значения ИК-датчика перед отправкой компьютеру.
 */
inline int irToInt(double irValue) {
  irValue *= cDOUBLE_MULTYPLIER; // Домножить результат
  return round(irValue);         // Вернуть округленный результат
}

/**
 * Возвращает строку измерения с ИК-датчика: усредняет значения датчика за 20 мс.
 * Измерение с аналога принимается равным за -42.
 */
inline String meas1() {
  delay(waitBeforeMeas);                       // Сделать задержку перед измерениями
  
  return "-42 " + String(irToInt(measIr20())); // Вернуть строку измерения
}

#define cNUM_OF_ATTEMPTS 5 // Количество попыток получить одно измерение
/**
 * Возвращает измерение с ИК-датчика: делается одно измерение.
 * Измерение с аналога принимается равным за -42.
 */
inline double measIrSingle() {
  double res = 0.0;                                     // Результат измерения
  int counter = 0;                                      // Счетчик попыток
  
  while (!therm.read() && counter < cNUM_OF_ATTEMPTS) { // Сделать несколько попыток считать измерение
    delay(1);                                           // Подождать между попытками
    counter++;                                          // Увеличить счетчик
  }
  
  if (counter != cNUM_OF_ATTEMPTS)                      // Если измерение считано
    res = therm.object();                               // Получить измерение

  return res;                                           // Вернуть результат
}

/**
 * Возвращает строку измерения с ИК-датчика: делается одно измерение.
 * Измерение с аналога принимается равным за -42.
 */
inline String meas2() {
  delay(waitBeforeMeas);                           // Сделать задержку перед измерениями
  
  return "-42 " + String(irToInt(measIrSingle())); // Вернуть строку измерения
}

/**
 * Сканирование с преобладающим движением по вертикали, всегда в одну сторону.
 */
inline void makeVerMovingSlow() {
  int horSteps = abs(horStepBegin - horStepEnd) / horStepAc + 1;
  int verSteps = abs(verDegBegin - verDegEnd) / verDegAc + 1;
  long numOfMeas = long(horSteps) * verSteps;
  long curMeas = 1;
  int hor = horStepBegin;
  int ver = verDegBegin;
  int horDelta = (horStepBegin > horStepEnd) ? -horStepAc : horStepAc;
  int verDelta = (verDegBegin > verDegEnd) ? -verDegAc : verDegAc;
  while ((horStepBegin <= hor && hor <= horStepEnd) || (horStepEnd <= hor && hor <= horStepBegin)) {
    while ((verDegBegin <= ver && ver <= verDegEnd) || (verDegEnd <= ver && ver <= verDegBegin)) {
      horStepper.toStep(hor);
      verServo.toDeg(ver);
      Serial.println("===m=== Measure #" + String(curMeas) + " of " + String(numOfMeas) + " (" + hor + " steps," + ver + " degs)=" + meas() + ", time: " + millis() + ";");
      ver += verDelta;
      curMeas++;
    }
    ver = verDegBegin;
    hor += horDelta;
  }
  if (curMeas - 1 != numOfMeas)
    Serial.println("Error in makeVerMoving!;");
}

/**
 * Сканирование с преобладающим движением по вертикали.
 */
inline void makeVerMoving() {
  int horSteps = abs(horStepBegin - horStepEnd) / horStepAc + 1;
  int verSteps = abs(verDegBegin - verDegEnd) / verDegAc + 1;
  long numOfMeas = long(horSteps) * verSteps;
  long curMeas = 1;
  int hor = horStepBegin;
  int ver = verDegBegin;
  int horDelta = (horStepBegin > horStepEnd) ? -horStepAc : horStepAc;
  int verDelta = (verDegBegin > verDegEnd) ? -verDegAc : verDegAc;
  while ((horStepBegin <= hor && hor <= horStepEnd) || (horStepEnd <= hor && hor <= horStepBegin)) {
    while ((verDegBegin <= ver && ver <= verDegEnd) || (verDegEnd <= ver && ver <= verDegBegin)) {
      horStepper.toStep(hor);
      verServo.toDeg(ver);
      Serial.println("===m=== Measure #" + String(curMeas) + " of " + String(numOfMeas) + " (" + hor + " steps," + ver + " degs)=" + meas() + ", time: " + millis() + ";");
      ver += verDelta;
      curMeas++;
    }
    verDelta *= -1;
    ver += verDelta;
    hor += horDelta;
  }
  if (curMeas - 1 != numOfMeas)
    Serial.println("Error in makeVerMoving!;");
}

/**
 * Сканирование с преобладающим движением по горизонтали, всегда в одну сторону.
 */
inline void makeHorMovingSlow() {
  int horSteps = abs(horStepBegin - horStepEnd) / horStepAc + 1;
  int verSteps = abs(verDegBegin - verDegEnd) / verDegAc + 1;
  long numOfMeas = long(horSteps) * verSteps;
  long curMeas = 1;
  int hor = horStepBegin;
  int ver = verDegBegin;
  int horDelta = (horStepBegin > horStepEnd) ? -horStepAc : horStepAc;
  int verDelta = (verDegBegin > verDegEnd) ? -verDegAc : verDegAc;
  while ((verDegBegin <= ver && ver <= verDegEnd) || (verDegEnd <= ver && ver <= verDegBegin)) {
    while ((horStepBegin <= hor && hor <= horStepEnd) || (horStepEnd <= hor && hor <= horStepBegin)) {
      horStepper.toStep(hor);
      verServo.toDeg(ver);
      Serial.println("===m=== Measure #" + String(curMeas) + " of " + String(numOfMeas) + " (" + hor + " steps," + ver + " degs)=" + meas() + ", time: " + millis() + ";");
      hor += horDelta;
      curMeas++;
    }
    hor = horStepBegin;
    ver += verDelta;
  }
  if (curMeas - 1 != numOfMeas)
    Serial.println("Error in makeHorMoving!;");
}

/**
 * Сканирование с преобладающим движением по горизонтали.
 */
inline void makeHorMoving() {
  int horSteps = abs(horStepBegin - horStepEnd) / horStepAc + 1;
  int verSteps = abs(verDegBegin - verDegEnd) / verDegAc + 1;
  long numOfMeas = long(horSteps) * verSteps;
  long curMeas = 1;
  int hor = horStepBegin;
  int ver = verDegBegin;
  int horDelta = (horStepBegin > horStepEnd) ? -horStepAc : horStepAc;
  int verDelta = (verDegBegin > verDegEnd) ? -verDegAc : verDegAc;
  while ((verDegBegin <= ver && ver <= verDegEnd) || (verDegEnd <= ver && ver <= verDegBegin)) {
    while ((horStepBegin <= hor && hor <= horStepEnd) || (horStepEnd <= hor && hor <= horStepBegin)) {
      horStepper.toStep(hor);
      verServo.toDeg(ver);
      Serial.println("===m=== Measure #" + String(curMeas) + " of " + String(numOfMeas) + " (" + hor + " steps," + ver + " degs)=" + meas() + ", time: " + millis() + ";");
      hor += horDelta;
      curMeas++;
    }
    horDelta *= -1;
    hor += horDelta;
    ver += verDelta;
  }
  if (curMeas - 1 != numOfMeas)
    Serial.println("Error in makeHorMoving!;");
}

/**
 * Сканирование.
 */
inline void scan() {
  if (!printed) { // Приветствие не напечатано?
    Serial.println("===r=== Ready! Request waiting;");
    printed = true; // Пометка напечатанным
  }
  while (Serial.available() > 0) {
    horReadBegin = Serial.parseInt();
    horReadEnd   = Serial.parseInt();
    horReadAc    = Serial.parseInt();

    horUnitDeg   = (Serial.parseInt() == 1) ? true : false;
    horAcUnitDeg = (Serial.parseInt() == 1) ? true : false;

    verDegBegin = Serial.parseInt();
    verDegEnd   = Serial.parseInt();
    verDegAc    = Serial.parseInt();

    numOfRep    = Serial.parseInt();
    movingType  = Serial.parseInt();

    waitBeforeMeas = Serial.parseInt();
    sensorType = Serial.parseInt();

    if (Serial.read() == '\n') {
      if(movingType == 4) {
        parking(verDegBegin);
      }
      
      switch (sensorType) {
        case 0:
          meas = &meas0;
          break;
        case 1:
          meas = &meas1;
          break;
        default:
          meas = &meas2;
          break;
      }

	  /* Перевод из градусов в шаги для горизонтального серво: */
      if (horUnitDeg) {
        horStepBegin = int(long(horReadBegin) * long(cHOR_STEPS_PER_REVOLUTION) / 360);
        horStepEnd   = int(long(horReadEnd)   * long(cHOR_STEPS_PER_REVOLUTION) / 360);
      }
      else {
        horStepBegin = horReadBegin;
        horStepEnd   = horReadEnd;
      }
      if (horAcUnitDeg)
        horStepAc = int(long(horReadAc) * long(cHOR_STEPS_PER_REVOLUTION) / 360);
      else
        horStepAc = horReadAc;
      if (horStepAc <= 0) // Если шаг <= 0, сделать его минимальным (= 1)
        horStepAc = 1;
      if (verDegAc <= 0)
        verDegAc = 1;

      Serial.println("===s=== Scanned:From:To:Accuracy;");
      delay(10);
      String horUnit = (horUnitDeg) ? "degs:" : "steps:";
      String horAcUnit = (horAcUnitDeg) ? "degs;" : "steps;";
      Serial.println("===s=== Hor:" + String(horReadBegin) + horUnit + String(horReadEnd) + horUnit + String(horReadAc) + horAcUnit);
      delay(10);
      Serial.println("===s=== Ver:" + String(verDegBegin)  + "degs:"  + String(verDegEnd)  + "degs:"  + String(verDegAc)  + "degs;");
      delay(10);

      Serial.println("===v=== Moving:From:To:Accuracy;");
      delay(10);
      Serial.println("===v=== Hor:" + String(horStepBegin) + "steps:" + String(horStepEnd) + "steps:" + String(horStepAc) + "steps;");
      delay(10);
      Serial.println("===v=== Ver:" + String(verDegBegin)  + "degs:"  + String(verDegEnd)  + "degs:"  + String(verDegAc)  + "degs;");
      delay(10);

      printed = false;

      void (*makeMoving)(void);
      switch (movingType) {
        case 0:
          makeMoving = &makeVerMoving;
          break;
        case 1:
          makeMoving = &makeHorMoving;
          break;
        case 2:
          makeMoving = &makeVerMovingSlow;
          break;
        default:
          makeMoving = &makeHorMovingSlow;
          break;
      }

      for (int i = 0; i < numOfRep; i++) {
        Serial.println("===p=== Repeatition " + String(i + 1) + " of " + String(numOfRep) + ";");
        makeMoving();
        Serial.println("===e=== End of repeatition;");
      }
      horStepper.toStep(0);
      verServo.toDeg(90);
    }
  }
}

void setup() {
  Serial.begin(long(250) * 1000);
  pinMode(cSENSOR_PIN, INPUT_PULLUP); // Попытка использовать подтягивающий резистор Arduino
  /* Для горизонтального шаговика: */
  horStepper.init();
  /* Для вертикального серво: */
  verServo.init();
  /* Для ИК датчика: */
  therm.begin(); // Initialize thermal IR sensor
  therm.setUnit(TEMP_C);
}

void loop() {
  scan();
}
