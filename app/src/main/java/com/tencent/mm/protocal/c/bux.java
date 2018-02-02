package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bux extends bcv {
    public double vNO;
    public double vNP;
    public int vWK;
    public long wWw;
    public bdo wWx;
    public bdo wWy;
    public int wWz;
    public int wbh;
    public long wbi;
    public LinkedList<bll> wlt = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wWx == null) {
                throw new b("Not all required fields were included: NetName");
            } else if (this.wWy == null) {
                throw new b("Not all required fields were included: WifiName");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                aVar.S(2, this.wWw);
                aVar.S(3, this.wbi);
                aVar.fU(4, this.vWK);
                if (this.wWx != null) {
                    aVar.fW(5, this.wWx.bke());
                    this.wWx.a(aVar);
                }
                if (this.wWy != null) {
                    aVar.fW(6, this.wWy.bke());
                    this.wWy.a(aVar);
                }
                aVar.b(7, this.vNO);
                aVar.b(8, this.vNP);
                aVar.fU(9, this.wbh);
                aVar.fU(10, this.wWz);
                aVar.d(11, 8, this.wlt);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.R(2, this.wWw)) + e.a.a.a.R(3, this.wbi)) + e.a.a.a.fR(4, this.vWK);
            if (this.wWx != null) {
                r0 += e.a.a.a.fT(5, this.wWx.bke());
            }
            if (this.wWy != null) {
                r0 += e.a.a.a.fT(6, this.wWy.bke());
            }
            return ((((r0 + (e.a.a.b.b.a.dX(7) + 8)) + (e.a.a.b.b.a.dX(8) + 8)) + e.a.a.a.fR(9, this.wbh)) + e.a.a.a.fR(10, this.wWz)) + e.a.a.a.c(11, 8, this.wlt);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wlt.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wWx == null) {
                throw new b("Not all required fields were included: NetName");
            } else if (this.wWy != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: WifiName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bux com_tencent_mm_protocal_c_bux = (bux) objArr[1];
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
                        com_tencent_mm_protocal_c_bux.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bux.wWw = aVar3.Avy.rz();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bux.wbi = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bux.vWK = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bux.wWx = fdVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bux.wWy = fdVar;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bux.vNO = aVar3.Avy.readDouble();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bux.vNP = aVar3.Avy.readDouble();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bux.wbh = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bux.wWz = aVar3.Avy.ry();
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bll();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bux.wlt.add(fdVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
