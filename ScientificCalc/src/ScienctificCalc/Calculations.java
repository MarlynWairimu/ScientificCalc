package ScienctificCalc;

import javax.swing.*;

public abstract class Calculations {

    public abstract void addToInput(String s) ;




    public abstract void addToInput(double d);
    public abstract void evaluateExpression();
    public abstract void clearEntry();
    public abstract void memoryClear();

    public abstract void memoryRecall();
    public abstract void memoryStore();
    public abstract void memoryAdd();
    public abstract void memorySubtract();
    public abstract double eval(String str);
}


