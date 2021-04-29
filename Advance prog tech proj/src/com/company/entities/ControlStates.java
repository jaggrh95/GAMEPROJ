package com.company.entities;

public abstract class ControlStates
{
    private boolean space = false;
    private boolean left = false;
    private boolean right = false;
    private boolean ctrl = false;


    public boolean isSpace() {
        return space;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isCtrl() {
        return ctrl;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setSpace(boolean space) {
        this.space = space;
    }
    public void setControl(boolean ctrl)
    {
        this.ctrl = ctrl;
    }
}
