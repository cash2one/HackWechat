package com.google.android.gms.c;

import com.tencent.wcdb.FileUtils;

public final class aw {
    int aZP;
    int aZQ;
    private int aZR;
    int aZS;
    private int aZT;
    private int aZU = Integer.MAX_VALUE;
    private int aZV;
    private int aZW = 64;
    private int aZX = 67108864;
    final byte[] buffer;

    aw(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.aZP = 0;
        this.aZQ = i2 + 0;
        this.aZS = 0;
    }

    private void dA(int i) {
        if (i < 0) {
            throw bd.qm();
        } else if (this.aZS + i > this.aZU) {
            dA(this.aZU - this.aZS);
            throw bd.ql();
        } else if (i <= this.aZQ - this.aZS) {
            this.aZS += i;
        } else {
            throw bd.ql();
        }
    }

    private void qd() {
        this.aZQ += this.aZR;
        int i = this.aZQ;
        if (i > this.aZU) {
            this.aZR = i - this.aZU;
            this.aZQ -= this.aZR;
            return;
        }
        this.aZR = 0;
    }

    private byte qf() {
        if (this.aZS == this.aZQ) {
            throw bd.ql();
        }
        byte[] bArr = this.buffer;
        int i = this.aZS;
        this.aZS = i + 1;
        return bArr[i];
    }

    public final void a(be beVar) {
        int qa = qa();
        if (this.aZV >= this.aZW) {
            throw bd.qr();
        }
        qa = dw(qa);
        this.aZV++;
        beVar.a(this);
        du(0);
        this.aZV--;
        dx(qa);
    }

    public final void du(int i) {
        if (this.aZT != i) {
            throw bd.qp();
        }
    }

    public final boolean dv(int i) {
        switch (bh.dJ(i)) {
            case 0:
                qa();
                return true;
            case 1:
                qc();
                return true;
            case 2:
                dA(qa());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                qb();
                return true;
            default:
                throw bd.qq();
        }
        int pX;
        do {
            pX = pX();
            if (pX != 0) {
            }
            du(bh.az(bh.dK(i), 4));
            return true;
        } while (dv(pX));
        du(bh.az(bh.dK(i), 4));
        return true;
    }

    public final int dw(int i) {
        if (i < 0) {
            throw bd.qm();
        }
        int i2 = this.aZS + i;
        int i3 = this.aZU;
        if (i2 > i3) {
            throw bd.ql();
        }
        this.aZU = i2;
        qd();
        return i3;
    }

    public final void dx(int i) {
        this.aZU = i;
        qd();
    }

    public final void dy(int i) {
        if (i > this.aZS - this.aZP) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.aZS - this.aZP));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.aZS = this.aZP + i;
        }
    }

    public final byte[] dz(int i) {
        if (i < 0) {
            throw bd.qm();
        } else if (this.aZS + i > this.aZU) {
            dA(this.aZU - this.aZS);
            throw bd.ql();
        } else if (i <= this.aZQ - this.aZS) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.aZS, obj, 0, i);
            this.aZS += i;
            return obj;
        } else {
            throw bd.ql();
        }
    }

    public final int getPosition() {
        return this.aZS - this.aZP;
    }

    public final int pX() {
        if ((this.aZS == this.aZQ ? 1 : 0) != 0) {
            this.aZT = 0;
            return 0;
        }
        this.aZT = qa();
        if (this.aZT != 0) {
            return this.aZT;
        }
        throw bd.qo();
    }

    public final long pY() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte qf = qf();
            j |= ((long) (qf & 127)) << i;
            if ((qf & FileUtils.S_IWUSR) == 0) {
                return j;
            }
        }
        throw bd.qn();
    }

    public final boolean pZ() {
        return qa() != 0;
    }

    public final int qa() {
        byte qf = qf();
        if (qf >= (byte) 0) {
            return qf;
        }
        int i = qf & 127;
        byte qf2 = qf();
        if (qf2 >= (byte) 0) {
            return i | (qf2 << 7);
        }
        i |= (qf2 & 127) << 7;
        qf2 = qf();
        if (qf2 >= (byte) 0) {
            return i | (qf2 << 14);
        }
        i |= (qf2 & 127) << 14;
        qf2 = qf();
        if (qf2 >= (byte) 0) {
            return i | (qf2 << 21);
        }
        i |= (qf2 & 127) << 21;
        qf2 = qf();
        i |= qf2 << 28;
        if (qf2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (qf() >= (byte) 0) {
                return i;
            }
        }
        throw bd.qn();
    }

    public final int qb() {
        return (((qf() & 255) | ((qf() & 255) << 8)) | ((qf() & 255) << 16)) | ((qf() & 255) << 24);
    }

    public final long qc() {
        byte qf = qf();
        byte qf2 = qf();
        return ((((((((((long) qf2) & 255) << 8) | (((long) qf) & 255)) | ((((long) qf()) & 255) << 16)) | ((((long) qf()) & 255) << 24)) | ((((long) qf()) & 255) << 32)) | ((((long) qf()) & 255) << 40)) | ((((long) qf()) & 255) << 48)) | ((((long) qf()) & 255) << 56);
    }

    public final int qe() {
        if (this.aZU == Integer.MAX_VALUE) {
            return -1;
        }
        return this.aZU - this.aZS;
    }

    public final String readString() {
        int qa = qa();
        if (qa > this.aZQ - this.aZS || qa <= 0) {
            return new String(dz(qa), "UTF-8");
        }
        String str = new String(this.buffer, this.aZS, qa, "UTF-8");
        this.aZS = qa + this.aZS;
        return str;
    }
}
