package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class blq extends a {
    public int hOF;
    public long hOG;
    public int hOH;
    public int hOI;
    public int hOJ;
    public int opType;
    public String wPg;
    public String wPh;
    public String wPi;
    public String wPj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wPg == null) {
                throw new b("Not all required fields were included: StatusDesc1");
            } else if (this.wPh == null) {
                throw new b("Not all required fields were included: StatusDesc2");
            } else if (this.wPi == null) {
                throw new b("Not all required fields were included: DataFlowSourceInfo");
            } else if (this.wPj == null) {
                throw new b("Not all required fields were included: DataFlowResultInfo");
            } else {
                aVar.fU(1, this.opType);
                aVar.fU(2, this.hOJ);
                aVar.fU(3, this.hOF);
                aVar.S(4, this.hOG);
                aVar.fU(5, this.hOH);
                aVar.fU(6, this.hOI);
                if (this.wPg != null) {
                    aVar.g(7, this.wPg);
                }
                if (this.wPh != null) {
                    aVar.g(8, this.wPh);
                }
                if (this.wPi != null) {
                    aVar.g(9, this.wPi);
                }
                if (this.wPj != null) {
                    aVar.g(10, this.wPj);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = (((((e.a.a.a.fR(1, this.opType) + 0) + e.a.a.a.fR(2, this.hOJ)) + e.a.a.a.fR(3, this.hOF)) + e.a.a.a.R(4, this.hOG)) + e.a.a.a.fR(5, this.hOH)) + e.a.a.a.fR(6, this.hOI);
            if (this.wPg != null) {
                r0 += e.a.a.b.b.a.h(7, this.wPg);
            }
            if (this.wPh != null) {
                r0 += e.a.a.b.b.a.h(8, this.wPh);
            }
            if (this.wPi != null) {
                r0 += e.a.a.b.b.a.h(9, this.wPi);
            }
            if (this.wPj != null) {
                return r0 + e.a.a.b.b.a.h(10, this.wPj);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wPg == null) {
                throw new b("Not all required fields were included: StatusDesc1");
            } else if (this.wPh == null) {
                throw new b("Not all required fields were included: StatusDesc2");
            } else if (this.wPi == null) {
                throw new b("Not all required fields were included: DataFlowSourceInfo");
            } else if (this.wPj != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DataFlowResultInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            blq com_tencent_mm_protocal_c_blq = (blq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_blq.opType = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_blq.hOJ = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_blq.hOF = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_blq.hOG = aVar3.Avy.rz();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_blq.hOH = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_blq.hOI = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_blq.wPg = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_blq.wPh = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_blq.wPi = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_blq.wPj = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
