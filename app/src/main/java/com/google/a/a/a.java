package com.google.a.a;

import com.tencent.wcdb.FileUtils;

public final class a {
    private int bfH;
    private int bfI;
    private int bfJ;
    private int bfK;
    private int bfL = Integer.MAX_VALUE;
    private int bfM;
    private int bfN = 64;
    private int bfO = 67108864;
    private final byte[] buffer;
    private int bufferSize;

    public final int rx() {
        if ((this.bfJ == this.bufferSize ? 1 : 0) != 0) {
            this.bfK = 0;
            return 0;
        }
        this.bfK = ry();
        if (this.bfK != 0) {
            return this.bfK;
        }
        throw d.rG();
    }

    public final void dO(int i) {
        if (this.bfK != i) {
            throw d.rH();
        }
    }

    public final boolean dP(int i) {
        switch (g.ea(i)) {
            case 0:
                ry();
                return true;
            case 1:
                rC();
                rC();
                rC();
                rC();
                rC();
                rC();
                rC();
                rC();
                return true;
            case 2:
                dU(ry());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                rC();
                rC();
                rC();
                rC();
                return true;
            default:
                throw d.rI();
        }
        int rx;
        do {
            rx = rx();
            if (rx != 0) {
            }
            dO(g.aG(g.eb(i), 4));
            return true;
        } while (dP(rx));
        dO(g.aG(g.eb(i), 4));
        return true;
    }

    public final String readString() {
        int ry = ry();
        if (ry > this.bufferSize - this.bfJ || ry <= 0) {
            return new String(dT(ry), "UTF-8");
        }
        String str = new String(this.buffer, this.bfJ, ry, "UTF-8");
        this.bfJ = ry + this.bfJ;
        return str;
    }

    public final void a(e eVar) {
        int ry = ry();
        if (this.bfM >= this.bfN) {
            throw d.rJ();
        }
        ry = dQ(ry);
        this.bfM++;
        eVar.a(this);
        dO(0);
        this.bfM--;
        dR(ry);
    }

    public final byte[] readBytes() {
        int ry = ry();
        if (ry > this.bufferSize - this.bfJ || ry <= 0) {
            return dT(ry);
        }
        Object obj = new byte[ry];
        System.arraycopy(this.buffer, this.bfJ, obj, 0, ry);
        this.bfJ = ry + this.bfJ;
        return obj;
    }

    public final int ry() {
        byte rC = rC();
        if (rC >= (byte) 0) {
            return rC;
        }
        int i = rC & 127;
        byte rC2 = rC();
        if (rC2 >= (byte) 0) {
            return i | (rC2 << 7);
        }
        i |= (rC2 & 127) << 7;
        rC2 = rC();
        if (rC2 >= (byte) 0) {
            return i | (rC2 << 14);
        }
        i |= (rC2 & 127) << 14;
        rC2 = rC();
        if (rC2 >= (byte) 0) {
            return i | (rC2 << 21);
        }
        i |= (rC2 & 127) << 21;
        rC2 = rC();
        i |= rC2 << 28;
        if (rC2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (rC() >= (byte) 0) {
                return i;
            }
        }
        throw d.rF();
    }

    public final long rz() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte rC = rC();
            j |= ((long) (rC & 127)) << i;
            if ((rC & FileUtils.S_IWUSR) == 0) {
                return j;
            }
        }
        throw d.rF();
    }

    a(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.bfH = 0;
        this.bufferSize = i2 + 0;
        this.bfJ = 0;
    }

    public final int dQ(int i) {
        if (i < 0) {
            throw d.rE();
        }
        int i2 = this.bfJ + i;
        int i3 = this.bfL;
        if (i2 > i3) {
            throw d.rD();
        }
        this.bfL = i2;
        rA();
        return i3;
    }

    private void rA() {
        this.bufferSize += this.bfI;
        int i = this.bufferSize;
        if (i > this.bfL) {
            this.bfI = i - this.bfL;
            this.bufferSize -= this.bfI;
            return;
        }
        this.bfI = 0;
    }

    public final void dR(int i) {
        this.bfL = i;
        rA();
    }

    public final int rB() {
        if (this.bfL == Integer.MAX_VALUE) {
            return -1;
        }
        return this.bfL - this.bfJ;
    }

    public final int getPosition() {
        return this.bfJ - this.bfH;
    }

    public final void dS(int i) {
        if (i > this.bfJ - this.bfH) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.bfJ - this.bfH));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.bfJ = this.bfH + i;
        }
    }

    private byte rC() {
        if (this.bfJ == this.bufferSize) {
            throw d.rD();
        }
        byte[] bArr = this.buffer;
        int i = this.bfJ;
        this.bfJ = i + 1;
        return bArr[i];
    }

    private byte[] dT(int i) {
        if (i < 0) {
            throw d.rE();
        } else if (this.bfJ + i > this.bfL) {
            dU(this.bfL - this.bfJ);
            throw d.rD();
        } else if (i <= this.bufferSize - this.bfJ) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.bfJ, obj, 0, i);
            this.bfJ += i;
            return obj;
        } else {
            throw d.rD();
        }
    }

    private void dU(int i) {
        if (i < 0) {
            throw d.rE();
        } else if (this.bfJ + i > this.bfL) {
            dU(this.bfL - this.bfJ);
            throw d.rD();
        } else if (i <= this.bufferSize - this.bfJ) {
            this.bfJ += i;
        } else {
            throw d.rD();
        }
    }
}
