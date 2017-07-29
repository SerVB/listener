#include "myStepper.h"
#include "myServo.h"

const int cHOR_STEP_DELAY           = 10;            // Время поворота шаговика на один шаг/полушаг в мс
const int cHOR_MAX_STEPS_ONE_DIR    = 600;           // Максимальное кол-во шагов/полушагов шаговика в одну сторону (защита от перекручивания проводов)
const int cHOR_PINS[]               = {3, 5, 6, 11}; // Пины подключения шаговика
const int cHOR_STEPS_PER_REVOLUTION = 400;           // Количество шагов/полушагов шаговика на один оборот

myStepper horStepper(cHOR_STEPS_PER_REVOLUTION,
                     cHOR_MAX_STEPS_ONE_DIR,
                     cHOR_STEP_DELAY,
                     cHOR_PINS[0], cHOR_PINS[1], cHOR_PINS[2], cHOR_PINS[3]);



const int cVER_PIN   = 13; // Пин подключения серво
const int cVER_DELAY = 15; // Время поворота серво на один градус в мс

myServo verServo(cVER_DELAY,
                 cVER_PIN);



const int cSENSOR_PIN = A0; // Пин датчика
const int cNUM_OF_MES = 100;

//const long cMAX_MES_PER_REP = long(5) * 1000;

boolean printed  = false; // Напечатан ли призыв к вводу?

int horReadBegin;
int horReadEnd;
int horReadAc;
bool horUnitDeg;
bool horAcUnitDeg;
int verDegBegin;
int verDegEnd;
int verDegAc;
int numOfRep;
int movingType;

int waitBeforeMeas, sensorType;

int (*meas)(void);

int horStepBegin;
int horStepEnd;
int horStepAc;

float tempFrom = -50.0; // Минимальная температура, все что ниже будет приравнено к минимуму
float tempTo   =  50.0; // Мксимальная температура, аналогично выше

/* Для ИК датчика: */
#include <Wire.h> // I2C library, required for MLX90614
#include <SparkFunMLX90614.h> // SparkFunMLX90614 Arduino library
IRTherm therm; // Create an IRTherm object to interact with throughout
/* Для ИК датчика */

inline void parking(int deg) {
  Serial.println("=park=" + String(deg) + ";");
  verServo.toDeg(deg);
  Serial.println("=park= Park successful!;");
  while(true) {}
}

inline int meas0() { // Сделать и вывести измерение на аналоге
  delay(waitBeforeMeas);
  unsigned long long sum = 0;
  unsigned long startms = millis();
  unsigned long long numOfMes = 0;
  while (millis() - startms < 20) { // Сбор данных в течение 20 мс
    sum += analogRead(cSENSOR_PIN);
    numOfMes++;
  }
  float ans = (0.0 + sum) / (0.0 + numOfMes);
  return round(ans);
}

inline int meas1() { // Сделать и вывести измерение на ИК, усреднить
  delay(waitBeforeMeas);
  double sum = 0.0;
  unsigned long startms = millis();
  int numOfMes = 0;
  while (millis() - startms < 20) { // Сбор данных в течение 20 мс
    if (therm.read()) {
      sum += therm.object();
      numOfMes++;
    }
  }
  Serial.println("=debug= sum = " + String(sum) + ", num = " + String(numOfMes) + ";");
  sum /= numOfMes;

  sum = map(sum, tempFrom, tempTo, 0.0, 1023.0);
  Serial.println("=debug= sum mapped = " + String(sum) +";");
//  sum -= tempFrom;
//  sum *= 1023.0/(tempTo - tempFrom);
  if (sum < 0.0)
    sum = 0.0;
  else if (sum > 1023.0)
    sum = 1023.0;
  return round(sum);
}

inline int meas2() { // Сделать и вывести измерение на ИК, сразу
  delay(waitBeforeMeas);
  // Сделать измерения пять раз - попытка подождать больше
//  while (!therm.read())
//  {
//    delay(1);
//  }
//  while (!therm.read())
//  {
//    delay(1);
//  }
//  while (!therm.read())
//  {
//    delay(1);
//  }
//  while (!therm.read())
//  {
//    delay(1);
//  }
//  while (!therm.read())
//  {
//    delay(1);
//  }
  while (!therm.read())
    delay(1);
  float res = therm.object();
  Serial.println("=debug= res = " + String(res) + ";");
  res = map(res, tempFrom, tempTo, 0.0, 1023.0);
//  res -= tempFrom;
//  res *= 1023.0/(tempTo - tempFrom);
  if (res < 0.0)
    res = 0.0;
  else if (res > 1023.0)
    res = 1023.0;

  return round(res);
}

//inline int meas1() { // Сделать и вывести измерение на ИК, усреднить
//  delay(waitBeforeMeas);
//  double sum = 0.0;
//  unsigned long startms = millis();
//  int numOfMes = 0;
//  while (millis() - startms < 20) { // Сбор данных в течение 20 мс
//    if (therm.read()) {
//      sum += therm.object();
//      numOfMes++;
//    }
//  }
//  sum /= numOfMes;
//
//  sum += 50.0;
//  sum *= 10.0;
//  if (sum < 0.0)
//    sum = 0.0;
//  else if (sum > 1023.0)
//    sum = 1023.0;
//  return round(sum);
//}
//
//inline int meas2() { // Сделать и вывести измерение на ИК, сразу
//  delay(waitBeforeMeas);
//  // Сделать измерения пять раз - попытка подождать больше
//  while (!therm.read())
//  {
//    delay(1);
//  }
//  while (!therm.read())
//  {
//    delay(1);
//  }
//  while (!therm.read())
//  {
//    delay(1);
//  }
//  while (!therm.read())
//  {
//    delay(1);
//  }
//  while (!therm.read())
//  {
//    delay(1);
//  }
//
//  float res = therm.object();
//  res += 50.0;
//  res *= 10.0;
//  if (res < 0.0)
//    res = 0.0;
//  else if (res > 1023.0)
//    res = 1023.0;
//
//  return round(res);
//}

inline void makeVerMovingSlow() { // Сканирование с преобладающим движением по вертикали, всегда в одну сторону
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
      int measToPrint = meas();
      Serial.println("===m=== Measure #" + String(curMeas) + " of " + String(numOfMeas) + " (" + hor + " steps," + ver + " degs)=" + measToPrint + ", time: " + millis() + ";");
      ver += verDelta;
      curMeas++;
    }
    ver = verDegBegin;
    hor += horDelta;
  }
  if (curMeas - 1 != numOfMeas)
    Serial.println("Error in makeVerMoving!;");
}

inline void makeVerMoving() { // Сканирование с преобладающим движением по вертикали
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
      int measToPrint = meas();
      Serial.println("===m=== Measure #" + String(curMeas) + " of " + String(numOfMeas) + " (" + hor + " steps," + ver + " degs)=" + measToPrint + ", time: " + millis() + ";");
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

inline void makeHorMovingSlow() { // Сканирование с преобладающим движением по горизонтали
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
      int measToPrint = meas();
      Serial.println("===m=== Measure #" + String(curMeas) + " of " + String(numOfMeas) + " (" + hor + " steps," + ver + " degs)=" + measToPrint + ", time: " + millis() + ";");
      hor += horDelta;
      curMeas++;
    }
    hor = horStepBegin;
    ver += verDelta;
  }
  if (curMeas - 1 != numOfMeas)
    Serial.println("Error in makeHorMoving!;");
}

inline void makeHorMoving() { // Сканирование с преобладающим движением по горизонтали
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
      int measToPrint = meas();
      Serial.println("===m=== Measure #" + String(curMeas) + " of " + String(numOfMeas) + " (" + hor + " steps," + ver + " degs)=" + measToPrint + ", time: " + millis() + ";");
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

inline void scan() { // Сканирование
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

    tempFrom = Serial.parseFloat();
    tempTo   = Serial.parseFloat();

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

      if (horUnitDeg) { /* Перевод из градусов в шаги для горизонтального серво: */
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
