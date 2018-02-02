package com.tencent.smtt.export.external.interfaces;

public enum IX5WebSettings$ZoomDensity {
    FAR(150),
    MEDIUM(100),
    CLOSE(75);
    
    int value;

    private IX5WebSettings$ZoomDensity(int i) {
        this.value = i;
    }
}
