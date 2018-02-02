package com.google.a.a;

import com.tencent.wcdb.FileUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class b {
    final int asN;
    private final byte[] buffer;
    int position = 0;

    public static class a extends IOException {
        a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    b(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.asN = i2 + 0;
    }

    public final void j(int i, long j) {
        aF(i, 0);
        ad(j);
    }

    public final void k(int i, long j) {
        aF(i, 0);
        ad(j);
    }

    public final void aB(int i, int i2) {
        aF(i, 0);
        if (i2 >= 0) {
            dY(i2);
        } else {
            ad((long) i2);
        }
    }

    public final void g(int i, String str) {
        aF(i, 2);
        byte[] bytes = str.getBytes("UTF-8");
        dY(bytes.length);
        o(bytes);
    }

    public final void a(int i, e eVar) {
        aF(i, 2);
        if (eVar.bfQ < 0) {
            eVar.rK();
        }
        dY(eVar.bfQ);
        eVar.a(this);
    }

    public final void a(int i, byte[] bArr) {
        aF(i, 2);
        dY(bArr.length);
        o(bArr);
    }

    public final void aC(int i, int i2) {
        aF(i, 0);
        dY(i2);
    }

    public static int l(int i, long j) {
        return dX(i) + ae(j);
    }

    public static int m(int i, long j) {
        return dX(i) + ae(j);
    }

    public static int aD(int i, int i2) {
        return dX(i) + dV(i2);
    }

    public static int h(int i, String str) {
        return dX(i) + bm(str);
    }

    public static int b(int i, e eVar) {
        int dX = dX(i);
        int rK = eVar.rK();
        return dX + (rK + dZ(rK));
    }

    public static int b(int i, byte[] bArr) {
        return dX(i) + (dZ(bArr.length) + bArr.length);
    }

    public static int aE(int i, int i2) {
        return dX(i) + dZ(i2);
    }

    public static int dV(int i) {
        if (i >= 0) {
            return dZ(i);
        }
        return 10;
    }

    public static int bm(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + dZ(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    private void dW(int i) {
        byte b = (byte) i;
        if (this.position == this.asN) {
            throw new a(this.position, this.asN);
        }
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b;
    }

    private void o(byte[] bArr) {
        int length = bArr.length;
        if (this.asN - this.position >= length) {
            System.arraycopy(bArr, 0, this.buffer, this.position, length);
            this.position = length + this.position;
            return;
        }
        throw new a(this.position, this.asN);
    }

    private void aF(int i, int i2) {
        dY(g.aG(i, i2));
    }

    private static int dX(int i) {
        return dZ(g.aG(i, 0));
    }

    private void dY(int i) {
        while ((i & -128) != 0) {
            dW((i & 127) | FileUtils.S_IWUSR);
            i >>>= 7;
        }
        dW(i);
    }

    public static int dZ(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    private void ad(long j) {
        while ((-128 & j) != 0) {
            dW((((int) j) & 127) | FileUtils.S_IWUSR);
            j >>>= 7;
        }
        dW((int) j);
    }

    private static int ae(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }
}
