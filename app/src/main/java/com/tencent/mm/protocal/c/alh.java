package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class alh extends bdf {
    public String vNq;
    public bah vNw;
    public String vYj;
    public String vYk;
    public int vYl;
    public wj vYm;
    public hq vYn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vNw == null) {
                throw new b("Not all required fields were included: qy_base_resp");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.vNw != null) {
                    aVar.fW(2, this.vNw.bke());
                    this.vNw.a(aVar);
                }
                if (this.vNq != null) {
                    aVar.g(3, this.vNq);
                }
                aVar.fU(4, this.vYl);
                if (this.vYm != null) {
                    aVar.fW(5, this.vYm.bke());
                    this.vYm.a(aVar);
                }
                if (this.vYn != null) {
                    aVar.fW(6, this.vYn.bke());
                    this.vYn.a(aVar);
                }
                if (this.vYj != null) {
                    aVar.g(7, this.vYj);
                }
                if (this.vYk == null) {
                    return 0;
                }
                aVar.g(8, this.vYk);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vNw != null) {
                r0 += e.a.a.a.fT(2, this.vNw.bke());
            }
            if (this.vNq != null) {
                r0 += e.a.a.b.b.a.h(3, this.vNq);
            }
            r0 += e.a.a.a.fR(4, this.vYl);
            if (this.vYm != null) {
                r0 += e.a.a.a.fT(5, this.vYm.bke());
            }
            if (this.vYn != null) {
                r0 += e.a.a.a.fT(6, this.vYn.bke());
            }
            if (this.vYj != null) {
                r0 += e.a.a.b.b.a.h(7, this.vYj);
            }
            if (this.vYk != null) {
                r0 += e.a.a.b.b.a.h(8, this.vYk);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vNw != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: qy_base_resp");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            alh com_tencent_mm_protocal_c_alh = (alh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alh.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bah();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alh.vNw = feVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alh.vNq = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alh.vYl = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new wj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alh.vYm = feVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new hq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alh.vYn = feVar;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_alh.vYj = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_alh.vYk = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
