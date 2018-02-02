package com.google.android.gms.c;

import org.xwalk.core.R$styleable;

public final class b$a extends ay<b$a> {
    private static volatile b$a[] aWa;
    public String aWb;
    public b$a[] aWc;
    public b$a[] aWd;
    public b$a[] aWe;
    public String aWf;
    public String aWg;
    public long aWh;
    public boolean aWi;
    public b$a[] aWj;
    public int[] aWk;
    public boolean aWl;
    public int type;

    public b$a() {
        this.type = 1;
        this.aWb = "";
        this.aWc = pv();
        this.aWd = pv();
        this.aWe = pv();
        this.aWf = "";
        this.aWg = "";
        this.aWh = 0;
        this.aWi = false;
        this.aWj = pv();
        this.aWk = bh.bam;
        this.aWl = false;
        this.aZZ = null;
        this.bak = -1;
    }

    private static b$a[] pv() {
        if (aWa == null) {
            synchronized (bc.baj) {
                if (aWa == null) {
                    aWa = new b$a[0];
                }
            }
        }
        return aWa;
    }

    public final /* synthetic */ be a(aw awVar) {
        while (true) {
            int pX = awVar.pX();
            int b;
            Object obj;
            int i;
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
                            this.type = pX;
                            break;
                        default:
                            continue;
                    }
                case 18:
                    this.aWb = awVar.readString();
                    continue;
                case 26:
                    b = bh.b(awVar, 26);
                    pX = this.aWc == null ? 0 : this.aWc.length;
                    obj = new b$a[(b + pX)];
                    if (pX != 0) {
                        System.arraycopy(this.aWc, 0, obj, 0, pX);
                    }
                    while (pX < obj.length - 1) {
                        obj[pX] = new b$a();
                        awVar.a(obj[pX]);
                        awVar.pX();
                        pX++;
                    }
                    obj[pX] = new b$a();
                    awVar.a(obj[pX]);
                    this.aWc = obj;
                    continue;
                case 34:
                    b = bh.b(awVar, 34);
                    pX = this.aWd == null ? 0 : this.aWd.length;
                    obj = new b$a[(b + pX)];
                    if (pX != 0) {
                        System.arraycopy(this.aWd, 0, obj, 0, pX);
                    }
                    while (pX < obj.length - 1) {
                        obj[pX] = new b$a();
                        awVar.a(obj[pX]);
                        awVar.pX();
                        pX++;
                    }
                    obj[pX] = new b$a();
                    awVar.a(obj[pX]);
                    this.aWd = obj;
                    continue;
                case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                    b = bh.b(awVar, 42);
                    pX = this.aWe == null ? 0 : this.aWe.length;
                    obj = new b$a[(b + pX)];
                    if (pX != 0) {
                        System.arraycopy(this.aWe, 0, obj, 0, pX);
                    }
                    while (pX < obj.length - 1) {
                        obj[pX] = new b$a();
                        awVar.a(obj[pX]);
                        awVar.pX();
                        pX++;
                    }
                    obj[pX] = new b$a();
                    awVar.a(obj[pX]);
                    this.aWe = obj;
                    continue;
                case 50:
                    this.aWf = awVar.readString();
                    continue;
                case 58:
                    this.aWg = awVar.readString();
                    continue;
                case 64:
                    this.aWh = awVar.pY();
                    continue;
                case 72:
                    this.aWl = awVar.pZ();
                    continue;
                case 80:
                    int b2 = bh.b(awVar, 80);
                    Object obj2 = new int[b2];
                    i = 0;
                    b = 0;
                    while (i < b2) {
                        if (i != 0) {
                            awVar.pX();
                        }
                        int qa = awVar.qa();
                        switch (qa) {
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
                            case 16:
                            case 17:
                                pX = b + 1;
                                obj2[b] = qa;
                                break;
                            default:
                                pX = b;
                                break;
                        }
                        i++;
                        b = pX;
                    }
                    if (b != 0) {
                        pX = this.aWk == null ? 0 : this.aWk.length;
                        if (pX != 0 || b != obj2.length) {
                            Object obj3 = new int[(pX + b)];
                            if (pX != 0) {
                                System.arraycopy(this.aWk, 0, obj3, 0, pX);
                            }
                            System.arraycopy(obj2, 0, obj3, pX, b);
                            this.aWk = obj3;
                            break;
                        }
                        this.aWk = obj2;
                        break;
                    }
                    continue;
                case 82:
                    i = awVar.dw(awVar.qa());
                    b = awVar.getPosition();
                    pX = 0;
                    while (awVar.qe() > 0) {
                        switch (awVar.qa()) {
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
                            case 16:
                            case 17:
                                pX++;
                                break;
                            default:
                                break;
                        }
                    }
                    if (pX != 0) {
                        awVar.dy(b);
                        b = this.aWk == null ? 0 : this.aWk.length;
                        Object obj4 = new int[(pX + b)];
                        if (b != 0) {
                            System.arraycopy(this.aWk, 0, obj4, 0, b);
                        }
                        while (awVar.qe() > 0) {
                            int qa2 = awVar.qa();
                            switch (qa2) {
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
                                case 16:
                                case 17:
                                    pX = b + 1;
                                    obj4[b] = qa2;
                                    b = pX;
                                    break;
                                default:
                                    break;
                            }
                        }
                        this.aWk = obj4;
                    }
                    awVar.dx(i);
                    continue;
                case 90:
                    b = bh.b(awVar, 90);
                    pX = this.aWj == null ? 0 : this.aWj.length;
                    obj = new b$a[(b + pX)];
                    if (pX != 0) {
                        System.arraycopy(this.aWj, 0, obj, 0, pX);
                    }
                    while (pX < obj.length - 1) {
                        obj[pX] = new b$a();
                        awVar.a(obj[pX]);
                        awVar.pX();
                        pX++;
                    }
                    obj[pX] = new b$a();
                    awVar.a(obj[pX]);
                    this.aWj = obj;
                    continue;
                case 96:
                    this.aWi = awVar.pZ();
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
        axVar.aw(1, this.type);
        if (!this.aWb.equals("")) {
            axVar.e(2, this.aWb);
        }
        if (this.aWc != null && this.aWc.length > 0) {
            for (be beVar : this.aWc) {
                if (beVar != null) {
                    axVar.a(3, beVar);
                }
            }
        }
        if (this.aWd != null && this.aWd.length > 0) {
            for (be beVar2 : this.aWd) {
                if (beVar2 != null) {
                    axVar.a(4, beVar2);
                }
            }
        }
        if (this.aWe != null && this.aWe.length > 0) {
            for (be beVar22 : this.aWe) {
                if (beVar22 != null) {
                    axVar.a(5, beVar22);
                }
            }
        }
        if (!this.aWf.equals("")) {
            axVar.e(6, this.aWf);
        }
        if (!this.aWg.equals("")) {
            axVar.e(7, this.aWg);
        }
        if (this.aWh != 0) {
            axVar.h(8, this.aWh);
        }
        if (this.aWl) {
            axVar.m(9, this.aWl);
        }
        if (this.aWk != null && this.aWk.length > 0) {
            for (int aw : this.aWk) {
                axVar.aw(10, aw);
            }
        }
        if (this.aWj != null && this.aWj.length > 0) {
            while (i < this.aWj.length) {
                be beVar3 = this.aWj[i];
                if (beVar3 != null) {
                    axVar.a(11, beVar3);
                }
                i++;
            }
        }
        if (this.aWi) {
            axVar.m(12, this.aWi);
        }
        super.a(axVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b$a)) {
            return false;
        }
        b$a com_google_android_gms_c_b_a = (b$a) obj;
        if (this.type != com_google_android_gms_c_b_a.type) {
            return false;
        }
        if (this.aWb == null) {
            if (com_google_android_gms_c_b_a.aWb != null) {
                return false;
            }
        } else if (!this.aWb.equals(com_google_android_gms_c_b_a.aWb)) {
            return false;
        }
        if (!bc.equals(this.aWc, com_google_android_gms_c_b_a.aWc) || !bc.equals(this.aWd, com_google_android_gms_c_b_a.aWd) || !bc.equals(this.aWe, com_google_android_gms_c_b_a.aWe)) {
            return false;
        }
        if (this.aWf == null) {
            if (com_google_android_gms_c_b_a.aWf != null) {
                return false;
            }
        } else if (!this.aWf.equals(com_google_android_gms_c_b_a.aWf)) {
            return false;
        }
        if (this.aWg == null) {
            if (com_google_android_gms_c_b_a.aWg != null) {
                return false;
            }
        } else if (!this.aWg.equals(com_google_android_gms_c_b_a.aWg)) {
            return false;
        }
        return (this.aWh == com_google_android_gms_c_b_a.aWh && this.aWi == com_google_android_gms_c_b_a.aWi && bc.equals(this.aWj, com_google_android_gms_c_b_a.aWj) && bc.equals(this.aWk, com_google_android_gms_c_b_a.aWk) && this.aWl == com_google_android_gms_c_b_a.aWl) ? a((ay) com_google_android_gms_c_b_a) : false;
    }

    public final int hashCode() {
        int i = 1231;
        int i2 = 0;
        int hashCode = ((this.aWf == null ? 0 : this.aWf.hashCode()) + (((((((((this.aWb == null ? 0 : this.aWb.hashCode()) + ((this.type + 527) * 31)) * 31) + bc.hashCode(this.aWc)) * 31) + bc.hashCode(this.aWd)) * 31) + bc.hashCode(this.aWe)) * 31)) * 31;
        if (this.aWg != null) {
            i2 = this.aWg.hashCode();
        }
        hashCode = ((((((this.aWi ? 1231 : 1237) + ((((hashCode + i2) * 31) + ((int) (this.aWh ^ (this.aWh >>> 32)))) * 31)) * 31) + bc.hashCode(this.aWj)) * 31) + bc.hashCode(this.aWk)) * 31;
        if (!this.aWl) {
            i = 1237;
        }
        return ((hashCode + i) * 31) + qg();
    }

    protected final int pw() {
        int i;
        int i2 = 0;
        int pw = super.pw() + ax.ax(1, this.type);
        if (!this.aWb.equals("")) {
            pw += ax.f(2, this.aWb);
        }
        if (this.aWc != null && this.aWc.length > 0) {
            i = pw;
            for (be beVar : this.aWc) {
                if (beVar != null) {
                    i += ax.b(3, beVar);
                }
            }
            pw = i;
        }
        if (this.aWd != null && this.aWd.length > 0) {
            i = pw;
            for (be beVar2 : this.aWd) {
                if (beVar2 != null) {
                    i += ax.b(4, beVar2);
                }
            }
            pw = i;
        }
        if (this.aWe != null && this.aWe.length > 0) {
            i = pw;
            for (be beVar22 : this.aWe) {
                if (beVar22 != null) {
                    i += ax.b(5, beVar22);
                }
            }
            pw = i;
        }
        if (!this.aWf.equals("")) {
            pw += ax.f(6, this.aWf);
        }
        if (!this.aWg.equals("")) {
            pw += ax.f(7, this.aWg);
        }
        if (this.aWh != 0) {
            pw += ax.i(8, this.aWh);
        }
        if (this.aWl) {
            pw += ax.dD(9) + 1;
        }
        if (this.aWk != null && this.aWk.length > 0) {
            int i3 = 0;
            for (int dB : this.aWk) {
                i3 += ax.dB(dB);
            }
            pw = (pw + i3) + (this.aWk.length * 1);
        }
        if (this.aWj != null && this.aWj.length > 0) {
            while (i2 < this.aWj.length) {
                be beVar3 = this.aWj[i2];
                if (beVar3 != null) {
                    pw += ax.b(11, beVar3);
                }
                i2++;
            }
        }
        return this.aWi ? pw + (ax.dD(12) + 1) : pw;
    }
}
