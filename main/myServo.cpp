#include "myServo.h"
#include <Arduino.h>

myServo::myServo(const int cDELAY,
                 const int cPIN0):
                 cDEL(cDELAY), // Время поворота серво на один градус в мс
                 cPIN(cPIN0)   // Пин подключения серво
                 {}
  

void myServo::init() { // Инициализация объекта myServo
  servo.attach(cPIN);  // Привязка пина
  pos = 90;            // Установка начальной позиции на 90 градусов
  servo.write(pos);    // Поворот серво в начальную позицию
}

void myServo::toDeg(const int cTO_DEG) { // Движение на заданный угол
  servo.write(cTO_DEG);                  // Поворот серво в нужную позицию
  delay(abs(cTO_DEG-pos) * cDEL);        // Ожидание остановки серво
  pos = cTO_DEG;                         // Запись текущей позиции в переменную
}

int myServo::getPosDeg() { // Возврат текущей позиции
  return pos;
}
