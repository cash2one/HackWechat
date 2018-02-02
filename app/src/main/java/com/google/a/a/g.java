package com.google.a.a;

public final class g {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int[] bfR = new int[0];
    public static final long[] bfS = new long[0];
    public static final float[] bfT = new float[0];
    public static final double[] bfU = new double[0];
    public static final boolean[] bfV = new boolean[0];
    public static final byte[][] bfW = new byte[0][];
    public static final byte[] bfX = new byte[0];

    static int ea(int i) {
        return i & 7;
    }

    public static int eb(int i) {
        return i >>> 3;
    }

    static int aG(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean a(a aVar, int i) {
        return aVar.dP(i);
    }

    public static final int b(a aVar, int i) {
        int i2 = 1;
        int position = aVar.getPosition();
        aVar.dP(i);
        while (aVar.rx() == i) {
            aVar.dP(i);
            i2++;
        }
        aVar.dS(position);
        return i2;
    }
}
