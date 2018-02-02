package com.tencent.smtt.export.external.interfaces;

public enum IX5WebSettings$TextSize {
    SMALLEST(50),
    SMALLER(75),
    NORMAL(100),
    LARGER(125),
    LARGEST(150);
    
    int value;

    private IX5WebSettings$TextSize(int i) {
        this.value = i;
    }
}
