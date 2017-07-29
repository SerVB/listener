#ifndef myStepper_h
#define myStepper_h

class myStepper {
  private:
    int pos;
    const int cMAX_POS;
    const int cSTEPS_PER_REV;
    const int cDEL;
    const int cPINS[4];
    void doSteps(int);
    
  public:
    myStepper(const int, const int, const int, const int, const int, const int, const int);
    void init();
    void toStep(int);
    void toDeg(int);
    int getPosStep();
};
#endif
