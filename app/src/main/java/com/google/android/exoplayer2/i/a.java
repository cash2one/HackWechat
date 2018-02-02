package com.google.android.exoplayer2.i;

public final class a {
    public static void am(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int as(int i, int i2) {
        if (i >= 0 && i < i2) {
            return i;
        }
        throw new IndexOutOfBoundsException();
    }

    public static void an(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void c(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static <T> T Y(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
