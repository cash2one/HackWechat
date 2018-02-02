package com.google.android.gms.c;

import java.util.Arrays;
import org.xwalk.core.R$styleable;

public final class av$a$a extends ay<av$a$a> {
    private static volatile av$a$a[] aZz;
    public a aZA;
    public int type;

    public static final class a extends ay<a> {
        public byte[] aZB;
        public String aZC;
        public double aZD;
        public float aZE;
        public long aZF;
        public int aZG;
        public int aZH;
        public boolean aZI;
        public com.google.android.gms.c.av.a[] aZJ;
        public av$a$a[] aZK;
        public String[] aZL;
        public long[] aZM;
        public float[] aZN;
        public long aZO;

        public a() {
            this.aZB = bh.bat;
            this.aZC = "";
            this.aZD = 0.0d;
            this.aZE = 0.0f;
            this.aZF = 0;
            this.aZG = 0;
            this.aZH = 0;
            this.aZI = false;
            this.aZJ = com.google.android.gms.c.av.a.pV();
            this.aZK = av$a$a.pW();
            this.aZL = bh.bar;
            this.aZM = bh.ban;
            this.aZN = bh.bao;
            this.aZO = 0;
            this.aZZ = null;
            this.bak = -1;
        }

        public final /* synthetic */ be a(aw awVar) {
            while (true) {
                int pX = awVar.pX();
                int qa;
                Object obj;
                int dw;
                switch (pX) {
                    case 0:
                        break;
                    case 10:
                        byte[] dz;
                        qa = awVar.qa();
                        if (qa > awVar.aZQ - awVar.aZS || qa <= 0) {
                            dz = awVar.dz(qa);
                        } else {
                            dz = new byte[qa];
                            System.arraycopy(awVar.buffer, awVar.aZS, dz, 0, qa);
                            awVar.aZS = qa + awVar.aZS;
                        }
                        this.aZB = dz;
                        continue;
                    case 18:
                        this.aZC = awVar.readString();
                        continue;
                    case 25:
                        this.aZD = Double.longBitsToDouble(awVar.qc());
                        continue;
                    case 37:
                        this.aZE = Float.intBitsToFloat(awVar.qb());
                        continue;
                    case 40:
                        this.aZF = awVar.pY();
                        continue;
                    case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.aZG = awVar.qa();
                        continue;
                    case 56:
                        pX = awVar.qa();
                        this.aZH = (-(pX & 1)) ^ (pX >>> 1);
                        continue;
                    case 64:
                        this.aZI = awVar.pZ();
                        continue;
                    case 74:
                        qa = bh.b(awVar, 74);
                        pX = this.aZJ == null ? 0 : this.aZJ.length;
                        obj = new com.google.android.gms.c.av.a[(qa + pX)];
                        if (pX != 0) {
                            System.arraycopy(this.aZJ, 0, obj, 0, pX);
                        }
                        while (pX < obj.length - 1) {
                            obj[pX] = new com.google.android.gms.c.av.a();
                            awVar.a(obj[pX]);
                            awVar.pX();
                            pX++;
                        }
                        obj[pX] = new com.google.android.gms.c.av.a();
                        awVar.a(obj[pX]);
                        this.aZJ = obj;
                        continue;
                    case 82:
                        qa = bh.b(awVar, 82);
                        pX = this.aZK == null ? 0 : this.aZK.length;
                        obj = new av$a$a[(qa + pX)];
                        if (pX != 0) {
                            System.arraycopy(this.aZK, 0, obj, 0, pX);
                        }
                        while (pX < obj.length - 1) {
                            obj[pX] = new av$a$a();
                            awVar.a(obj[pX]);
                            awVar.pX();
                            pX++;
                        }
                        obj[pX] = new av$a$a();
                        awVar.a(obj[pX]);
                        this.aZK = obj;
                        continue;
                    case 90:
                        qa = bh.b(awVar, 90);
                        pX = this.aZL == null ? 0 : this.aZL.length;
                        obj = new String[(qa + pX)];
                        if (pX != 0) {
                            System.arraycopy(this.aZL, 0, obj, 0, pX);
                        }
                        while (pX < obj.length - 1) {
                            obj[pX] = awVar.readString();
                            awVar.pX();
                            pX++;
                        }
                        obj[pX] = awVar.readString();
                        this.aZL = obj;
                        continue;
                    case 96:
                        qa = bh.b(awVar, 96);
                        pX = this.aZM == null ? 0 : this.aZM.length;
                        obj = new long[(qa + pX)];
                        if (pX != 0) {
                            System.arraycopy(this.aZM, 0, obj, 0, pX);
                        }
                        while (pX < obj.length - 1) {
                            obj[pX] = awVar.pY();
                            awVar.pX();
                            pX++;
                        }
                        obj[pX] = awVar.pY();
                        this.aZM = obj;
                        continue;
                    case 98:
                        dw = awVar.dw(awVar.qa());
                        qa = awVar.getPosition();
                        pX = 0;
                        while (awVar.qe() > 0) {
                            awVar.pY();
                            pX++;
                        }
                        awVar.dy(qa);
                        qa = this.aZM == null ? 0 : this.aZM.length;
                        Object obj2 = new long[(pX + qa)];
                        if (qa != 0) {
                            System.arraycopy(this.aZM, 0, obj2, 0, qa);
                        }
                        while (qa < obj2.length) {
                            obj2[qa] = awVar.pY();
                            qa++;
                        }
                        this.aZM = obj2;
                        awVar.dx(dw);
                        continue;
                    case 104:
                        this.aZO = awVar.pY();
                        continue;
                    case 114:
                        pX = awVar.qa();
                        qa = awVar.dw(pX);
                        dw = pX / 4;
                        pX = this.aZN == null ? 0 : this.aZN.length;
                        Object obj3 = new float[(dw + pX)];
                        if (pX != 0) {
                            System.arraycopy(this.aZN, 0, obj3, 0, pX);
                        }
                        while (pX < obj3.length) {
                            obj3[pX] = Float.intBitsToFloat(awVar.qb());
                            pX++;
                        }
                        this.aZN = obj3;
                        awVar.dx(qa);
                        continue;
                    case 117:
                        qa = bh.b(awVar, 117);
                        pX = this.aZN == null ? 0 : this.aZN.length;
                        obj = new float[(qa + pX)];
                        if (pX != 0) {
                            System.arraycopy(this.aZN, 0, obj, 0, pX);
                        }
                        while (pX < obj.length - 1) {
                            obj[pX] = Float.intBitsToFloat(awVar.qb());
                            awVar.pX();
                            pX++;
                        }
                        obj[pX] = Float.intBitsToFloat(awVar.qb());
                        this.aZN = obj;
                        continue;
                    default:
                        if (!a(awVar, pX)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(ax axVar) {
            int i = 0;
            if (!Arrays.equals(this.aZB, bh.bat)) {
                byte[] bArr = this.aZB;
                axVar.ay(1, 2);
                axVar.dE(bArr.length);
                axVar.l(bArr);
            }
            if (!this.aZC.equals("")) {
                axVar.e(2, this.aZC);
            }
            if (Double.doubleToLongBits(this.aZD) != Double.doubleToLongBits(0.0d)) {
                double d = this.aZD;
                axVar.ay(3, 1);
                long doubleToLongBits = Double.doubleToLongBits(d);
                axVar.dC(((int) doubleToLongBits) & 255);
                axVar.dC(((int) (doubleToLongBits >> 8)) & 255);
                axVar.dC(((int) (doubleToLongBits >> 16)) & 255);
                axVar.dC(((int) (doubleToLongBits >> 24)) & 255);
                axVar.dC(((int) (doubleToLongBits >> 32)) & 255);
                axVar.dC(((int) (doubleToLongBits >> 40)) & 255);
                axVar.dC(((int) (doubleToLongBits >> 48)) & 255);
                axVar.dC(((int) (doubleToLongBits >> 56)) & 255);
            }
            if (Float.floatToIntBits(this.aZE) != Float.floatToIntBits(0.0f)) {
                axVar.d(4, this.aZE);
            }
            if (this.aZF != 0) {
                axVar.h(5, this.aZF);
            }
            if (this.aZG != 0) {
                axVar.aw(6, this.aZG);
            }
            if (this.aZH != 0) {
                int i2 = this.aZH;
                axVar.ay(7, 0);
                axVar.dE(ax.dG(i2));
            }
            if (this.aZI) {
                axVar.m(8, this.aZI);
            }
            if (this.aZJ != null && this.aZJ.length > 0) {
                for (be beVar : this.aZJ) {
                    if (beVar != null) {
                        axVar.a(9, beVar);
                    }
                }
            }
            if (this.aZK != null && this.aZK.length > 0) {
                for (be beVar2 : this.aZK) {
                    if (beVar2 != null) {
                        axVar.a(10, beVar2);
                    }
                }
            }
            if (this.aZL != null && this.aZL.length > 0) {
                for (String str : this.aZL) {
                    if (str != null) {
                        axVar.e(11, str);
                    }
                }
            }
            if (this.aZM != null && this.aZM.length > 0) {
                for (long h : this.aZM) {
                    axVar.h(12, h);
                }
            }
            if (this.aZO != 0) {
                axVar.h(13, this.aZO);
            }
            if (this.aZN != null && this.aZN.length > 0) {
                while (i < this.aZN.length) {
                    axVar.d(14, this.aZN[i]);
                    i++;
                }
            }
            super.a(axVar);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!Arrays.equals(this.aZB, aVar.aZB)) {
                return false;
            }
            if (this.aZC == null) {
                if (aVar.aZC != null) {
                    return false;
                }
            } else if (!this.aZC.equals(aVar.aZC)) {
                return false;
            }
            return (Double.doubleToLongBits(this.aZD) == Double.doubleToLongBits(aVar.aZD) && Float.floatToIntBits(this.aZE) == Float.floatToIntBits(aVar.aZE) && this.aZF == aVar.aZF && this.aZG == aVar.aZG && this.aZH == aVar.aZH && this.aZI == aVar.aZI && bc.equals(this.aZJ, aVar.aZJ) && bc.equals(this.aZK, aVar.aZK) && bc.equals(this.aZL, aVar.aZL) && bc.equals(this.aZM, aVar.aZM) && bc.equals(this.aZN, aVar.aZN) && this.aZO == aVar.aZO) ? a(aVar) : false;
        }

        public final int hashCode() {
            int hashCode = (this.aZC == null ? 0 : this.aZC.hashCode()) + ((Arrays.hashCode(this.aZB) + 527) * 31);
            long doubleToLongBits = Double.doubleToLongBits(this.aZD);
            return (((((((((((((((this.aZI ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.aZE)) * 31) + ((int) (this.aZF ^ (this.aZF >>> 32)))) * 31) + this.aZG) * 31) + this.aZH) * 31)) * 31) + bc.hashCode(this.aZJ)) * 31) + bc.hashCode(this.aZK)) * 31) + bc.hashCode(this.aZL)) * 31) + bc.hashCode(this.aZM)) * 31) + bc.hashCode(this.aZN)) * 31) + ((int) (this.aZO ^ (this.aZO >>> 32)))) * 31) + qg();
        }

        protected final int pw() {
            int i;
            int i2 = 0;
            int pw = super.pw();
            if (!Arrays.equals(this.aZB, bh.bat)) {
                byte[] bArr = this.aZB;
                pw += (bArr.length + ax.dF(bArr.length)) + ax.dD(1);
            }
            if (!this.aZC.equals("")) {
                pw += ax.f(2, this.aZC);
            }
            if (Double.doubleToLongBits(this.aZD) != Double.doubleToLongBits(0.0d)) {
                pw += ax.dD(3) + 8;
            }
            if (Float.floatToIntBits(this.aZE) != Float.floatToIntBits(0.0f)) {
                pw += ax.dD(4) + 4;
            }
            if (this.aZF != 0) {
                pw += ax.i(5, this.aZF);
            }
            if (this.aZG != 0) {
                pw += ax.ax(6, this.aZG);
            }
            if (this.aZH != 0) {
                pw += ax.dF(ax.dG(this.aZH)) + ax.dD(7);
            }
            if (this.aZI) {
                pw += ax.dD(8) + 1;
            }
            if (this.aZJ != null && this.aZJ.length > 0) {
                i = pw;
                for (be beVar : this.aZJ) {
                    if (beVar != null) {
                        i += ax.b(9, beVar);
                    }
                }
                pw = i;
            }
            if (this.aZK != null && this.aZK.length > 0) {
                i = pw;
                for (be beVar2 : this.aZK) {
                    if (beVar2 != null) {
                        i += ax.b(10, beVar2);
                    }
                }
                pw = i;
            }
            if (this.aZL != null && this.aZL.length > 0) {
                int i3 = 0;
                int i4 = 0;
                for (String str : this.aZL) {
                    if (str != null) {
                        i4++;
                        i3 += ax.bb(str);
                    }
                }
                pw = (pw + i3) + (i4 * 1);
            }
            if (this.aZM != null && this.aZM.length > 0) {
                i = 0;
                while (i2 < this.aZM.length) {
                    i += ax.aa(this.aZM[i2]);
                    i2++;
                }
                pw = (pw + i) + (this.aZM.length * 1);
            }
            if (this.aZO != 0) {
                pw += ax.i(13, this.aZO);
            }
            return (this.aZN == null || this.aZN.length <= 0) ? pw : (pw + (this.aZN.length * 4)) + (this.aZN.length * 1);
        }
    }

    public av$a$a() {
        this.type = 1;
        this.aZA = null;
        this.aZZ = null;
        this.bak = -1;
    }

    public static av$a$a[] pW() {
        if (aZz == null) {
            synchronized (bc.baj) {
                if (aZz == null) {
                    aZz = new av$a$a[0];
                }
            }
        }
        return aZz;
    }

    public final /* synthetic */ be a(aw awVar) {
        while (true) {
            int pX = awVar.pX();
            switch (pX) {
                case 0:
                    break;
                case 8:
                    pX = awVar.qa();
                    switch (pX) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                            this.type = pX;
                            break;
                        default:
                            continue;
                    }
                case 18:
                    if (this.aZA == null) {
                        this.aZA = new a();
                    }
                    awVar.a(this.aZA);
                    continue;
                default:
                    if (!a(awVar, pX)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public final void a(ax axVar) {
        axVar.aw(1, this.type);
        if (this.aZA != null) {
            axVar.a(2, this.aZA);
        }
        super.a(axVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof av$a$a)) {
            return false;
        }
        av$a$a com_google_android_gms_c_av_a_a = (av$a$a) obj;
        if (this.type != com_google_android_gms_c_av_a_a.type) {
            return false;
        }
        if (this.aZA == null) {
            if (com_google_android_gms_c_av_a_a.aZA != null) {
                return false;
            }
        } else if (!this.aZA.equals(com_google_android_gms_c_av_a_a.aZA)) {
            return false;
        }
        return a(com_google_android_gms_c_av_a_a);
    }

    public final int hashCode() {
        return (((this.aZA == null ? 0 : this.aZA.hashCode()) + ((this.type + 527) * 31)) * 31) + qg();
    }

    protected final int pw() {
        int pw = super.pw() + ax.ax(1, this.type);
        return this.aZA != null ? pw + ax.b(2, this.aZA) : pw;
    }
}
