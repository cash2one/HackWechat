package com.tencent.mm.plugin.g.a.b.a;

import com.tencent.mm.plugin.g.a.b.h;

public class e extends a {
    static final String TAG = e.class.getName();
    public static final String kzi = h.kya;
    public static final String kzj = h.kyb;
    public static final String kzk = h.kyc;
    public static final String kzl = h.kyd;
    public byte kzm;
    public byte kzn;
    public byte kzo;
    public byte kzp;
    public byte[] kzq;
    public int kzr;
    public byte kzs;
    public byte kzt;
    public byte[] kzu;

    public e() {
        this.kyq = null;
        this.kyr = 8;
        this.kxJ = 16;
        this.kzm = (byte) 0;
        this.kzn = (byte) 0;
        this.kzo = (byte) 0;
        this.kzp = (byte) 0;
        this.kzq = new byte[]{(byte) 0, (byte) 0};
        this.kzr = -1;
        this.kzs = (byte) 0;
        this.kzt = (byte) 0;
        this.kzu = null;
    }

    public final byte[] ars() {
        if (this.kyq.equalsIgnoreCase(kzi)) {
            Object obj = new byte[3];
            System.arraycopy(Byte.valueOf(this.kzm), 0, obj, 0, 1);
            System.arraycopy(Byte.valueOf(this.kzn), 0, obj, 1, 1);
            System.arraycopy(Byte.valueOf(this.kzo), 0, obj, 2, 1);
            return obj;
        } else if (this.kyq.equalsIgnoreCase(kzj)) {
            r0 = new byte[1];
            System.arraycopy(Byte.valueOf(this.kzp), 0, r0, 0, 1);
            return r0;
        } else if (!this.kyq.equalsIgnoreCase(kzl)) {
            return null;
        } else {
            r0 = new byte[this.kzr];
            byte b = (byte) ((this.kzr >> 8) & 255);
            System.arraycopy(Byte.valueOf((byte) (this.kzr & 255)), 0, r0, 0, 1);
            System.arraycopy(Byte.valueOf(b), 0, r0, 1, 1);
            System.arraycopy(Byte.valueOf(this.kzs), 0, r0, 2, 1);
            if (this.kzr <= 3) {
                return r0;
            }
            System.arraycopy(this.kzu, 0, r0, 3, this.kzr - 3);
            return r0;
        }
    }
}
