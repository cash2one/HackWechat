package com.tencent.magicbrush.handler.a;

public enum j$a {
    NORMAL(0),
    BOLD(1),
    ITALIC(2),
    BOLD_ITALIC(3);
    
    int boq;

    private j$a(int i) {
        this.boq = i;
    }

    public static j$a f(boolean z, boolean z2) {
        if (z && z2) {
            return BOLD_ITALIC;
        }
        if (z) {
            return ITALIC;
        }
        if (z2) {
            return BOLD;
        }
        return NORMAL;
    }
}
