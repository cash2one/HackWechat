package com.google.android.gms.c;

public final class bh {
    public static final int[] bam = new int[0];
    public static final long[] ban = new long[0];
    public static final float[] bao = new float[0];
    public static final double[] bap = new double[0];
    public static final boolean[] baq = new boolean[0];
    public static final String[] bar = new String[0];
    public static final byte[][] bas = new byte[0][];
    public static final byte[] bat = new byte[0];

    static int az(int i, int i2) {
        return (i << 3) | i2;
    }

    public static final int b(aw awVar, int i) {
        int i2 = 1;
        int position = awVar.getPosition();
        awVar.dv(i);
        while (awVar.pX() == i) {
            awVar.dv(i);
            i2++;
        }
        awVar.dy(position);
        return i2;
    }

    static int dJ(int i) {
        return i & 7;
    }

    public static int dK(int i) {
        return i >>> 3;
    }
}
