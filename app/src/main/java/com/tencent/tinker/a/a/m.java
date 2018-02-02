package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;
import com.tencent.tinker.a.a.k.1;

public final class m {
    protected final a Aff;
    public int Afg;
    private int Afh;
    private int type;

    public m(a aVar, int i) {
        this.type = -1;
        this.Aff = aVar;
        this.type = i;
    }

    public m(k kVar, int i) {
        this(new 1(kVar), i);
    }

    public final int cGE() {
        if (this.type == -1) {
            int readByte = this.Aff.readByte() & 255;
            this.type = readByte & 31;
            this.Afh = (readByte & 224) >> 5;
        }
        return this.type;
    }

    public final int cGF() {
        If(28);
        this.type = -1;
        return o.b(this.Aff);
    }

    public final int cGG() {
        If(29);
        this.type = -1;
        this.Afg = o.b(this.Aff);
        return o.b(this.Aff);
    }

    public final int cGH() {
        return o.b(this.Aff);
    }

    public final byte readByte() {
        If(0);
        this.type = -1;
        return (byte) l.a(this.Aff, this.Afh);
    }

    public final short readShort() {
        If(2);
        this.type = -1;
        return (short) l.a(this.Aff, this.Afh);
    }

    public final char readChar() {
        If(3);
        this.type = -1;
        return (char) l.a(this.Aff, this.Afh, false);
    }

    public final int readInt() {
        If(4);
        this.type = -1;
        return l.a(this.Aff, this.Afh);
    }

    public final long readLong() {
        If(6);
        this.type = -1;
        a aVar = this.Aff;
        int i = this.Afh;
        long j = 0;
        for (int i2 = i; i2 >= 0; i2--) {
            j = (j >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return j >> ((7 - i) * 8);
    }

    public final float readFloat() {
        If(16);
        this.type = -1;
        return Float.intBitsToFloat(l.a(this.Aff, this.Afh, true));
    }

    public final double readDouble() {
        If(17);
        this.type = -1;
        a aVar = this.Aff;
        long j = 0;
        for (int i = this.Afh; i >= 0; i--) {
            j = (j >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return Double.longBitsToDouble(j);
    }

    public final int cGI() {
        If(23);
        this.type = -1;
        return l.a(this.Aff, this.Afh, false);
    }

    public final int cGJ() {
        If(24);
        this.type = -1;
        return l.a(this.Aff, this.Afh, false);
    }

    public final int cGK() {
        If(25);
        this.type = -1;
        return l.a(this.Aff, this.Afh, false);
    }

    public final int cGL() {
        If(27);
        this.type = -1;
        return l.a(this.Aff, this.Afh, false);
    }

    public final int cGM() {
        If(26);
        this.type = -1;
        return l.a(this.Aff, this.Afh, false);
    }

    public final void cGN() {
        If(30);
        this.type = -1;
    }

    public final boolean readBoolean() {
        If(31);
        this.type = -1;
        return this.Afh != 0;
    }

    public final void skipValue() {
        int i = 0;
        int cGF;
        switch (cGE()) {
            case 0:
                readByte();
                return;
            case 2:
                readShort();
                return;
            case 3:
                readChar();
                return;
            case 4:
                readInt();
                return;
            case 6:
                readLong();
                return;
            case 16:
                readFloat();
                return;
            case 17:
                readDouble();
                return;
            case 23:
                cGI();
                return;
            case 24:
                cGJ();
                return;
            case 25:
                cGK();
                return;
            case 26:
                cGM();
                return;
            case 27:
                cGL();
                return;
            case 28:
                cGF = cGF();
                while (i < cGF) {
                    skipValue();
                    i++;
                }
                return;
            case 29:
                cGF = cGG();
                while (i < cGF) {
                    o.b(this.Aff);
                    skipValue();
                    i++;
                }
                return;
            case 30:
                cGN();
                return;
            case 31:
                readBoolean();
                return;
            default:
                throw new j("Unexpected type: " + Integer.toHexString(this.type));
        }
    }

    private void If(int i) {
        if (cGE() != i) {
            throw new IllegalStateException(String.format("Expected %x but was %x", new Object[]{Integer.valueOf(i), Integer.valueOf(cGE())}));
        }
    }
}
