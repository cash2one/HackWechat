package com.google.android.exoplayer2;

import java.io.IOException;

public final class e extends Exception {
    public final int acB;
    public final int type;

    public static e a(Exception exception, int i) {
        return new e(1, exception, i);
    }

    public static e a(IOException iOException) {
        return new e(0, iOException, -1);
    }

    static e b(RuntimeException runtimeException) {
        return new e(2, runtimeException, -1);
    }

    private e(int i, Throwable th, int i2) {
        super(null, th);
        this.type = i;
        this.acB = i2;
    }
}
