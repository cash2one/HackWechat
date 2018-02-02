package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class avs extends a {
    public String fDI;
    public String fyY;
    public String sNy;
    public long sOK;
    public long sOL;
    public long sOM;
    public int sON;
    public int sOO;
    public long sOP;
    public String sUr;
    public String title;
    public String type;
    public String url;
    public String wDp;
    public String wDq;
    public String wDr;
    public String wDs;
    public int wDt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.g(1, this.url);
            }
            if (this.fyY != null) {
                aVar.g(2, this.fyY);
            }
            if (this.fDI != null) {
                aVar.g(3, this.fDI);
            }
            if (this.sUr != null) {
                aVar.g(4, this.sUr);
            }
            if (this.wDp != null) {
                aVar.g(5, this.wDp);
            }
            if (this.wDq != null) {
                aVar.g(6, this.wDq);
            }
            if (this.type != null) {
                aVar.g(7, this.type);
            }
            if (this.title != null) {
                aVar.g(8, this.title);
            }
            aVar.S(9, this.sOK);
            aVar.S(10, this.sOL);
            if (this.sNy != null) {
                aVar.g(11, this.sNy);
            }
            aVar.S(12, this.sOM);
            aVar.fU(13, this.sON);
            aVar.fU(14, this.sOO);
            if (this.wDr != null) {
                aVar.g(15, this.wDr);
            }
            if (this.wDs != null) {
                aVar.g(16, this.wDs);
            }
            aVar.S(17, this.sOP);
            aVar.fU(18, this.wDt);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                r0 = e.a.a.b.b.a.h(1, this.url) + 0;
            } else {
                r0 = 0;
            }
            if (this.fyY != null) {
                r0 += e.a.a.b.b.a.h(2, this.fyY);
            }
            if (this.fDI != null) {
                r0 += e.a.a.b.b.a.h(3, this.fDI);
            }
            if (this.sUr != null) {
                r0 += e.a.a.b.b.a.h(4, this.sUr);
            }
            if (this.wDp != null) {
                r0 += e.a.a.b.b.a.h(5, this.wDp);
            }
            if (this.wDq != null) {
                r0 += e.a.a.b.b.a.h(6, this.wDq);
            }
            if (this.type != null) {
                r0 += e.a.a.b.b.a.h(7, this.type);
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(8, this.title);
            }
            r0 = (r0 + e.a.a.a.R(9, this.sOK)) + e.a.a.a.R(10, this.sOL);
            if (this.sNy != null) {
                r0 += e.a.a.b.b.a.h(11, this.sNy);
            }
            r0 = ((r0 + e.a.a.a.R(12, this.sOM)) + e.a.a.a.fR(13, this.sON)) + e.a.a.a.fR(14, this.sOO);
            if (this.wDr != null) {
                r0 += e.a.a.b.b.a.h(15, this.wDr);
            }
            if (this.wDs != null) {
                r0 += e.a.a.b.b.a.h(16, this.wDs);
            }
            return (r0 + e.a.a.a.R(17, this.sOP)) + e.a.a.a.fR(18, this.wDt);
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
            avs com_tencent_mm_protocal_c_avs = (avs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_avs.url = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avs.fyY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avs.fDI = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avs.sUr = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avs.wDp = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avs.wDq = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_avs.type = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_avs.title = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_avs.sOK = aVar3.Avy.rz();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_avs.sOL = aVar3.Avy.rz();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_avs.sNy = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_avs.sOM = aVar3.Avy.rz();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_avs.sON = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_avs.sOO = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_avs.wDr = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_avs.wDs = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_avs.sOP = aVar3.Avy.rz();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_avs.wDt = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
