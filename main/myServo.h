#ifndef myServo_h
#define myServo_h

#include <Servo.h>

class myServo {
  private:
    Servo servo;    // Объект Servo
    const int cPIN; // Время поворота серво на один градус в мс
    const int cDEL; // Пин подключения серво
    int pos;        // Текущая позиция серво
    
  public:
    myServo(const int, const int); // Конструктор объекта myServo
    void init();                   // Инициализация объекта myServo
    void toDeg(const int);         // Движение на заданный угол
    int getPosDeg();               // Возврат текущей позиции
};

#endif
