package com.google.android.exoplayer2.i;

import android.util.Pair;
import com.tencent.wcdb.FileUtils;

public final class c {
    private static final byte[] aBW = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    private static final int[] aBX = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] aBY = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> h(byte[] bArr) {
        i iVar = new i(bArr);
        int c = c(iVar);
        int d = d(iVar);
        int cT = iVar.cT(4);
        if (c == 5 || c == 29) {
            d = d(iVar);
            if (c(iVar) == 22) {
                cT = iVar.cT(4);
            }
        }
        int i = aBY[cT];
        a.am(i != -1);
        return Pair.create(Integer.valueOf(d), Integer.valueOf(i));
    }

    public static byte[] t(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & FileUtils.S_IWUSR) | ((i3 << 3) & 120))};
    }

    public static byte[] i(byte[] bArr, int i, int i2) {
        Object obj = new byte[(aBW.length + i2)];
        System.arraycopy(aBW, 0, obj, 0, aBW.length);
        System.arraycopy(bArr, i, obj, aBW.length, i2);
        return obj;
    }

    private static int c(i iVar) {
        int cT = iVar.cT(5);
        if (cT == 31) {
            return iVar.cT(6) + 32;
        }
        return cT;
    }

    private static int d(i iVar) {
        int cT = iVar.cT(4);
        if (cT == 15) {
            return iVar.cT(24);
        }
        a.am(cT < 13);
        return aBX[cT];
    }
}
