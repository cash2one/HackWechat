package com.tencent.mm.plugin.g.a.b.a;

import com.tencent.mm.plugin.g.a.b.h;
import com.tencent.mm.sdk.platformtools.x;

public class b extends a {
    static final String TAG = b.class.getName();
    public static String kys = h.kym;
    public static String kyt = h.kyn;
    public static String kyu = h.kyo;
    b kyA;
    a kyB;
    int kyC;
    private final int kyv;
    private final int kyw;
    private final int kyx;
    private final int kyy;
    private final int kyz;

    private class b {
        public boolean kyD = false;
        public int kyF = 0;
        public int kyG = 0;
        public int kyH = 0;
        public c kyI = new c();
        final /* synthetic */ b kyJ;
        public double kyK = 0.0d;
        public double kyL = 0.0d;
        public double kyM = 0.0d;

        public b(b bVar) {
            this.kyJ = bVar;
        }
    }

    public b() {
        this.kyv = 1;
        this.kyw = 2;
        this.kyx = 4;
        this.kyy = 8;
        this.kyz = 16;
        this.kyq = null;
        this.kyr = 2;
        this.kxJ = 8;
        this.kyA = null;
    }

    static double G(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & 65280;
        int i3 = (i2 >> 12) - 16;
        int i4 = i2 & 3840;
        int i5 = (bArr[i] & 255) + (65280 & i4);
        double pow = ((double) i5) * Math.pow(10.0d, (double) i3);
        x.d(TAG, "hbyte=" + i2 + " hvalue=" + i4 + " value=" + i5 + " exp=" + i3);
        return pow;
    }

    public final byte[] ars() {
        return null;
    }
}
