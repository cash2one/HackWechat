package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bky extends bcv {
    public int ktN;
    public String ngo;
    public String vGQ;
    public int vIB;
    public int vIC;
    public String vIO;
    public bdn vKf;
    public int vWK;
    public String vZU;
    public bos wEF;
    public int wOp;
    public int wOq;
    public int wya;
    public int wyb;
    public int wzw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vKf == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.ktN);
            aVar.fU(3, this.vIC);
            aVar.fU(4, this.vIB);
            if (this.vKf != null) {
                aVar.fW(5, this.vKf.bke());
                this.vKf.a(aVar);
            }
            if (this.vGQ != null) {
                aVar.g(6, this.vGQ);
            }
            aVar.fU(7, this.wya);
            aVar.fU(8, this.wyb);
            if (this.vIO != null) {
                aVar.g(9, this.vIO);
            }
            aVar.fU(10, this.wOp);
            aVar.fU(11, this.vWK);
            if (this.wEF != null) {
                aVar.fW(12, this.wEF.bke());
                this.wEF.a(aVar);
            }
            if (this.ngo != null) {
                aVar.g(13, this.ngo);
            }
            aVar.fU(14, this.wzw);
            if (this.vZU != null) {
                aVar.g(15, this.vZU);
            }
            aVar.fU(16, this.wOq);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.fR(2, this.ktN)) + e.a.a.a.fR(3, this.vIC)) + e.a.a.a.fR(4, this.vIB);
            if (this.vKf != null) {
                r0 += e.a.a.a.fT(5, this.vKf.bke());
            }
            if (this.vGQ != null) {
                r0 += e.a.a.b.b.a.h(6, this.vGQ);
            }
            r0 = (r0 + e.a.a.a.fR(7, this.wya)) + e.a.a.a.fR(8, this.wyb);
            if (this.vIO != null) {
                r0 += e.a.a.b.b.a.h(9, this.vIO);
            }
            r0 = (r0 + e.a.a.a.fR(10, this.wOp)) + e.a.a.a.fR(11, this.vWK);
            if (this.wEF != null) {
                r0 += e.a.a.a.fT(12, this.wEF.bke());
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(13, this.ngo);
            }
            r0 += e.a.a.a.fR(14, this.wzw);
            if (this.vZU != null) {
                r0 += e.a.a.b.b.a.h(15, this.vZU);
            }
            return r0 + e.a.a.a.fR(16, this.wOq);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vKf != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bky com_tencent_mm_protocal_c_bky = (bky) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bky.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bky.ktN = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bky.vIC = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bky.vIB = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bky.vKf = fdVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bky.vGQ = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bky.wya = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bky.wyb = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bky.vIO = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bky.wOp = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bky.vWK = aVar3.Avy.ry();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bos();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bky.wEF = fdVar;
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bky.ngo = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bky.wzw = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bky.vZU = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bky.wOq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
