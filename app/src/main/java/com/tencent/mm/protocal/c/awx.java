package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class awx extends a {
    public String niZ;
    public String pbi;
    public String pbk;
    public int pbl;
    public String pbm;
    public int pbn;
    public String pbo;
    public int pbp;
    public int pbq;
    public String pbs;
    public String pbt;
    public String pbu;
    public String pbv;
    public int wEa;
    public String wEm;
    public String wEn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pbi != null) {
                aVar.g(1, this.pbi);
            }
            aVar.fU(2, this.wEa);
            if (this.pbk != null) {
                aVar.g(3, this.pbk);
            }
            aVar.fU(4, this.pbl);
            if (this.pbm != null) {
                aVar.g(5, this.pbm);
            }
            aVar.fU(6, this.pbn);
            if (this.pbo != null) {
                aVar.g(7, this.pbo);
            }
            aVar.fU(8, this.pbp);
            aVar.fU(9, this.pbq);
            if (this.niZ != null) {
                aVar.g(11, this.niZ);
            }
            if (this.pbs != null) {
                aVar.g(12, this.pbs);
            }
            if (this.pbt != null) {
                aVar.g(13, this.pbt);
            }
            if (this.pbu != null) {
                aVar.g(14, this.pbu);
            }
            if (this.pbv != null) {
                aVar.g(15, this.pbv);
            }
            if (this.wEm != null) {
                aVar.g(18, this.wEm);
            }
            if (this.wEn == null) {
                return 0;
            }
            aVar.g(19, this.wEn);
            return 0;
        } else if (i == 1) {
            if (this.pbi != null) {
                r0 = e.a.a.b.b.a.h(1, this.pbi) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wEa);
            if (this.pbk != null) {
                r0 += e.a.a.b.b.a.h(3, this.pbk);
            }
            r0 += e.a.a.a.fR(4, this.pbl);
            if (this.pbm != null) {
                r0 += e.a.a.b.b.a.h(5, this.pbm);
            }
            r0 += e.a.a.a.fR(6, this.pbn);
            if (this.pbo != null) {
                r0 += e.a.a.b.b.a.h(7, this.pbo);
            }
            r0 = (r0 + e.a.a.a.fR(8, this.pbp)) + e.a.a.a.fR(9, this.pbq);
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(11, this.niZ);
            }
            if (this.pbs != null) {
                r0 += e.a.a.b.b.a.h(12, this.pbs);
            }
            if (this.pbt != null) {
                r0 += e.a.a.b.b.a.h(13, this.pbt);
            }
            if (this.pbu != null) {
                r0 += e.a.a.b.b.a.h(14, this.pbu);
            }
            if (this.pbv != null) {
                r0 += e.a.a.b.b.a.h(15, this.pbv);
            }
            if (this.wEm != null) {
                r0 += e.a.a.b.b.a.h(18, this.wEm);
            }
            if (this.wEn != null) {
                r0 += e.a.a.b.b.a.h(19, this.wEn);
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
            awx com_tencent_mm_protocal_c_awx = (awx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_awx.pbi = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awx.wEa = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awx.pbk = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awx.pbl = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_awx.pbm = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_awx.pbn = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_awx.pbo = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_awx.pbp = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_awx.pbq = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_awx.niZ = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_awx.pbs = aVar3.Avy.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_awx.pbt = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_awx.pbu = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_awx.pbv = aVar3.Avy.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_awx.wEm = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_awx.wEn = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
