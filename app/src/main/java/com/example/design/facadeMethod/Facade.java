package com.example.design.facadeMethod;

public class Facade {
    private SubSystem01 obj01 = new SubSystem01();
    private SubSystem02 obj02 = new SubSystem02();
    private SubSystem03 obj03 = new SubSystem03();

    public void method() {
        obj01.method01();
        obj02.method02();
        obj03.method03();
    }
}
