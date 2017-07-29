#include "myStepper.h"
#include <Arduino.h>
const int cNUM_OF_STEPS = 8;                      // Полушаговый режим
const bool cSTEPS[cNUM_OF_STEPS][4] = {{1,0,0,0}, // Полушаговый режим
                                       {1,1,0,0},
                                       {0,1,0,0},
                                       {0,1,1,0},
                                       {0,0,1,0},
                                       {0,0,1,1},
                                       {0,0,0,1},
                                       {1,0,0,1}};
//const int cNUM_OF_STEPS = 4;                      // Полношаговый режим
//const bool cSTEPS[cNUM_OF_STEPS][4] = {{1,0,0,0}, // Полношаговый режим
//                                       {0,1,0,0},
//                                       {0,0,1,0},
//                                       {0,0,0,1}};                                                         
  
myStepper::myStepper(const int cSTEPS_PER_REVLUTION,
                     const int cMAX_POSITION,
                     const int cDELAY,
                     const int cPIN_0, const int cPIN_1, const int cPIN_2, const int cPIN_3):
                     cMAX_POS(cMAX_POSITION),              // Максимальное кол-во шагов/полушагов шаговика в одну сторону (защита от перекручивания проводов)
                     cSTEPS_PER_REV(cSTEPS_PER_REVLUTION), // Количество шагов/полушагов шаговика на один оборот
                     cDEL(cDELAY),                         // Время поворота шаговика на один шаг/полушаг в мс
                     cPINS({cPIN_0,cPIN_1,cPIN_2,cPIN_3})  // Пины подключения шаговика
                     {}

void myStepper::init() {                 // Инициализация объекта myStepper
  for(int j = 0; j < 4; j++) {           // Для каждого пина:
    pinMode(cPINS[j],OUTPUT);            // Установка пина выходным
    digitalWrite(cPINS[j],cSTEPS[0][j]); // Установка сигнала в начальную позицию
  }
  pos = 0;                               // Установка начальной позиции в нуль
}

void myStepper::doSteps(int steps) {         // Сделать steps шагов
  const char cDELTA = (steps >= 0) ? 1 : -1; // Если шаги положительны, делать по одному шагу в положительную сторону, иначе делать по одному шагу в отрицательную сторону
  int newPins[4];          // Новые пины
  if(steps < 0) {          // Если необходимо движение в обратном направлении
    newPins[0] = cPINS[3]; // Присваивание пинов в обратном порядке
    newPins[1] = cPINS[2];
    newPins[2] = cPINS[1];
    newPins[3] = cPINS[0];
    steps *= -1;           // Количество необходимых шагов положительно
  }
  else {                   // Иначе движение в обычную сторону
    newPins[0] = cPINS[0]; // Копирование пинов
    newPins[1] = cPINS[1];
    newPins[2] = cPINS[2];
    newPins[3] = cPINS[3];
  }
  for(int i = 0; i < steps; i++) {   // Пошаговое выполнение шагов
    pos += cDELTA;                   // Изменение текущей позиции
    int cond = pos % cNUM_OF_STEPS;  // Состояние портов
    if(cond < 0)                     // Если остаток отрицателен
      cond += cNUM_OF_STEPS;         // Делание его положительным
    for(int j = 0; j < 4; j++)       // Присвоение каждому пину состояния
      digitalWrite(cPINS[j],cSTEPS[cond][j]);
    delay(cDEL);                     // Задержка чтобы шаговик успел повернуться на один шаг
  }
}
  
void myStepper::toStep(const int cTO_STEP) {
  if(abs(cTO_STEP) > cMAX_POS) { // Если запрошенная позиция больше максимальной позиции (накрутится ли провод?)
    if(cTO_STEP >= 0)            // то перейти на максимальную позицию
      doSteps(cMAX_POS - pos);
    else                         
      doSteps(-cMAX_POS - pos);
    Serial.println("Error! The horizontal step " + String(cTO_STEP) +
                   " can't be reach because of the maximum step is set to " +
                   String(cMAX_POS) + ".\nNow moved to step " +
                   String(pos) + ".");
  }
  else                       // иначе
    doSteps(cTO_STEP - pos); // перейти на запрошенную позицию
}

void myStepper::toDeg(const int cTO_DEG) {
  toStep(cTO_DEG * cSTEPS_PER_REV / 360);
}

int myStepper::getPosStep() {
  return pos;
}

