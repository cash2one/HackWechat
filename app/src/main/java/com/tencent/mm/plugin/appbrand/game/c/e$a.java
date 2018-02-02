package com.tencent.mm.plugin.appbrand.game.c;

enum e$a {
    FPS(1),
    CPU(2),
    MEM(3),
    DRAW_CALL(4),
    TRIANGLE(5),
    VERTEX(6),
    NATIVE_MEM(101),
    DALVIK_MEM(102),
    OTHER_MEM(103),
    MEM_DELTA(104);
    
    int iYZ;

    private e$a(int i) {
        this.iYZ = i;
    }
}
