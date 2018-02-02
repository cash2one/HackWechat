package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class byj extends a {
    public String gfV;
    public String ksZ;
    public int vHT;
    public String vXI;
    public String wYA;
    public String wYB;
    public String wYC;
    public String wYD;
    public String wYE;
    public String wYz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYz == null) {
                throw new b("Not all required fields were included: LocalNodeId");
            }
            if (this.wYz != null) {
                aVar.g(1, this.wYz);
            }
            if (this.ksZ != null) {
                aVar.g(2, this.ksZ);
            }
            if (this.wYA != null) {
                aVar.g(3, this.wYA);
            }
            if (this.gfV != null) {
                aVar.g(4, this.gfV);
            }
            if (this.wYB != null) {
                aVar.g(5, this.wYB);
            }
            if (this.vXI != null) {
                aVar.g(6, this.vXI);
            }
            if (this.wYC != null) {
                aVar.g(7, this.wYC);
            }
            if (this.wYD != null) {
                aVar.g(8, this.wYD);
            }
            if (this.wYE != null) {
                aVar.g(9, this.wYE);
            }
            aVar.fU(10, this.vHT);
            return 0;
        } else if (i == 1) {
            if (this.wYz != null) {
                r0 = e.a.a.b.b.a.h(1, this.wYz) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksZ != null) {
                r0 += e.a.a.b.b.a.h(2, this.ksZ);
            }
            if (this.wYA != null) {
                r0 += e.a.a.b.b.a.h(3, this.wYA);
            }
            if (this.gfV != null) {
                r0 += e.a.a.b.b.a.h(4, this.gfV);
            }
            if (this.wYB != null) {
                r0 += e.a.a.b.b.a.h(5, this.wYB);
            }
            if (this.vXI != null) {
                r0 += e.a.a.b.b.a.h(6, this.vXI);
            }
            if (this.wYC != null) {
                r0 += e.a.a.b.b.a.h(7, this.wYC);
            }
            if (this.wYD != null) {
                r0 += e.a.a.b.b.a.h(8, this.wYD);
            }
            if (this.wYE != null) {
                r0 += e.a.a.b.b.a.h(9, this.wYE);
            }
            return r0 + e.a.a.a.fR(10, this.vHT);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wYz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: LocalNodeId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byj com_tencent_mm_protocal_c_byj = (byj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_byj.wYz = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_byj.ksZ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_byj.wYA = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_byj.gfV = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_byj.wYB = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_byj.vXI = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_byj.wYC = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_byj.wYD = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_byj.wYE = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_byj.vHT = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
