package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bum extends bcv {
    public int vWK;
    public String wFM;
    public int wFq;
    public int wOO;
    public but wUm;
    public but wUn;
    public long wUq;
    public int wVl;
    public int wVw;
    public LinkedList<bdo> wVx = new LinkedList();
    public int wVy;
    public int wbh;
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wUm == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.wUn == null) {
                throw new b("Not all required fields were included: CapInfo");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.wFM != null) {
                    aVar.g(2, this.wFM);
                }
                aVar.fU(3, this.wVw);
                aVar.d(4, 8, this.wVx);
                if (this.wUm != null) {
                    aVar.fW(6, this.wUm.bke());
                    this.wUm.a(aVar);
                }
                if (this.wUn != null) {
                    aVar.fW(7, this.wUn.bke());
                    this.wUn.a(aVar);
                }
                aVar.fU(8, this.vWK);
                aVar.fU(9, this.wOO);
                aVar.fU(10, this.wbh);
                aVar.S(11, this.wbi);
                aVar.fU(12, this.wVl);
                aVar.S(13, this.wUq);
                aVar.fU(14, this.wVy);
                aVar.fU(15, this.wFq);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wFM != null) {
                r0 += e.a.a.b.b.a.h(2, this.wFM);
            }
            r0 = (r0 + e.a.a.a.fR(3, this.wVw)) + e.a.a.a.c(4, 8, this.wVx);
            if (this.wUm != null) {
                r0 += e.a.a.a.fT(6, this.wUm.bke());
            }
            if (this.wUn != null) {
                r0 += e.a.a.a.fT(7, this.wUn.bke());
            }
            return (((((((r0 + e.a.a.a.fR(8, this.vWK)) + e.a.a.a.fR(9, this.wOO)) + e.a.a.a.fR(10, this.wbh)) + e.a.a.a.R(11, this.wbi)) + e.a.a.a.fR(12, this.wVl)) + e.a.a.a.R(13, this.wUq)) + e.a.a.a.fR(14, this.wVy)) + e.a.a.a.fR(15, this.wFq);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wVx.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wUm == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.wUn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CapInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bum com_tencent_mm_protocal_c_bum = (bum) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bum.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bum.wFM = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bum.wVw = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bum.wVx.add(fdVar);
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new but();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bum.wUm = fdVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new but();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bum.wUn = fdVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bum.vWK = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bum.wOO = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bum.wbh = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bum.wbi = aVar3.Avy.rz();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bum.wVl = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bum.wUq = aVar3.Avy.rz();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bum.wVy = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bum.wFq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
