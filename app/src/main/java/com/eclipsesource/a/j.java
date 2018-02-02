package com.eclipsesource.a;

public final class j extends RuntimeException {
    private final int column;
    private final int line;
    private final int offset;

    j(String str, int i, int i2, int i3) {
        super(str + " at " + i2 + ":" + i3);
        this.offset = i;
        this.line = i2;
        this.column = i3;
    }
}
