package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adz extends bdf {
    public String nfX;
    public int vDW;
    public String vEm;
    public String vPs;
    public String weY;
    public bdn wlO;
    public String wlX;
    public int wlY;
    public int wmv;
    public LinkedList<avf> wmw = new LinkedList();
    public int wmx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wlO == null) {
                throw new b("Not all required fields were included: Buff");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                aVar.fU(2, this.wmv);
                aVar.d(3, 8, this.wmw);
                aVar.fU(4, this.vDW);
                aVar.fU(5, this.wmx);
                if (this.wlO != null) {
                    aVar.fW(6, this.wlO.bke());
                    this.wlO.a(aVar);
                }
                if (this.nfX != null) {
                    aVar.g(7, this.nfX);
                }
                if (this.wlX != null) {
                    aVar.g(8, this.wlX);
                }
                if (this.weY != null) {
                    aVar.g(9, this.weY);
                }
                if (this.vEm != null) {
                    aVar.g(10, this.vEm);
                }
                aVar.fU(11, this.wlY);
                if (this.vPs == null) {
                    return 0;
                }
                aVar.g(12, this.vPs);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + e.a.a.a.fR(2, this.wmv)) + e.a.a.a.c(3, 8, this.wmw)) + e.a.a.a.fR(4, this.vDW)) + e.a.a.a.fR(5, this.wmx);
            if (this.wlO != null) {
                r0 += e.a.a.a.fT(6, this.wlO.bke());
            }
            if (this.nfX != null) {
                r0 += e.a.a.b.b.a.h(7, this.nfX);
            }
            if (this.wlX != null) {
                r0 += e.a.a.b.b.a.h(8, this.wlX);
            }
            if (this.weY != null) {
                r0 += e.a.a.b.b.a.h(9, this.weY);
            }
            if (this.vEm != null) {
                r0 += e.a.a.b.b.a.h(10, this.vEm);
            }
            r0 += e.a.a.a.fR(11, this.wlY);
            if (this.vPs != null) {
                r0 += e.a.a.b.b.a.h(12, this.vPs);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wmw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wlO != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Buff");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adz com_tencent_mm_protocal_c_adz = (adz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adz.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adz.wmv = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new avf();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adz.wmw.add(feVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adz.vDW = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adz.wmx = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adz.wlO = feVar;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_adz.nfX = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_adz.wlX = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_adz.weY = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_adz.vEm = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_adz.wlY = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_adz.vPs = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
