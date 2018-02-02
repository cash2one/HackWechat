package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bzu extends a {
    public String bhd;
    public String lOX;
    public String lOY;
    public String pes;
    public String rfu;
    public String seA;
    public String seB;
    public String seF;
    public String seG;
    public String sez;
    public String tnm;
    public String tnn;
    public String tno;
    public String tnp;
    public long tnq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.tnm != null) {
                aVar.g(1, this.tnm);
            }
            if (this.tnn != null) {
                aVar.g(2, this.tnn);
            }
            if (this.tno != null) {
                aVar.g(3, this.tno);
            }
            if (this.tnp != null) {
                aVar.g(4, this.tnp);
            }
            aVar.S(5, this.tnq);
            if (this.seF != null) {
                aVar.g(6, this.seF);
            }
            if (this.lOX != null) {
                aVar.g(7, this.lOX);
            }
            if (this.lOY != null) {
                aVar.g(8, this.lOY);
            }
            if (this.rfu != null) {
                aVar.g(9, this.rfu);
            }
            if (this.sez != null) {
                aVar.g(10, this.sez);
            }
            if (this.seA != null) {
                aVar.g(11, this.seA);
            }
            if (this.seB != null) {
                aVar.g(12, this.seB);
            }
            if (this.bhd != null) {
                aVar.g(13, this.bhd);
            }
            if (this.pes != null) {
                aVar.g(14, this.pes);
            }
            if (this.seG == null) {
                return 0;
            }
            aVar.g(15, this.seG);
            return 0;
        } else if (i == 1) {
            if (this.tnm != null) {
                r0 = e.a.a.b.b.a.h(1, this.tnm) + 0;
            } else {
                r0 = 0;
            }
            if (this.tnn != null) {
                r0 += e.a.a.b.b.a.h(2, this.tnn);
            }
            if (this.tno != null) {
                r0 += e.a.a.b.b.a.h(3, this.tno);
            }
            if (this.tnp != null) {
                r0 += e.a.a.b.b.a.h(4, this.tnp);
            }
            r0 += e.a.a.a.R(5, this.tnq);
            if (this.seF != null) {
                r0 += e.a.a.b.b.a.h(6, this.seF);
            }
            if (this.lOX != null) {
                r0 += e.a.a.b.b.a.h(7, this.lOX);
            }
            if (this.lOY != null) {
                r0 += e.a.a.b.b.a.h(8, this.lOY);
            }
            if (this.rfu != null) {
                r0 += e.a.a.b.b.a.h(9, this.rfu);
            }
            if (this.sez != null) {
                r0 += e.a.a.b.b.a.h(10, this.sez);
            }
            if (this.seA != null) {
                r0 += e.a.a.b.b.a.h(11, this.seA);
            }
            if (this.seB != null) {
                r0 += e.a.a.b.b.a.h(12, this.seB);
            }
            if (this.bhd != null) {
                r0 += e.a.a.b.b.a.h(13, this.bhd);
            }
            if (this.pes != null) {
                r0 += e.a.a.b.b.a.h(14, this.pes);
            }
            if (this.seG != null) {
                r0 += e.a.a.b.b.a.h(15, this.seG);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzu com_tencent_mm_protocal_c_bzu = (bzu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bzu.tnm = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bzu.tnn = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bzu.tno = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bzu.tnp = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bzu.tnq = aVar3.Avy.rz();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bzu.seF = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bzu.lOX = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bzu.lOY = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bzu.rfu = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bzu.sez = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bzu.seA = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bzu.seB = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bzu.bhd = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bzu.pes = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bzu.seG = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
