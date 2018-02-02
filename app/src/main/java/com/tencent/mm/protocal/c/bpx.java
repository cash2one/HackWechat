package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bpx extends bcv {
    public String ksU;
    public int ktN;
    public String ngo;
    public int vHT;
    public int vIB;
    public int vIC;
    public int vID;
    public bdn vXz;
    public String vZU;
    public String wRD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.ngo != null) {
                aVar.g(2, this.ngo);
            }
            aVar.fU(3, this.vHT);
            if (this.wRD != null) {
                aVar.g(4, this.wRD);
            }
            if (this.ksU != null) {
                aVar.g(5, this.ksU);
            }
            aVar.fU(6, this.vIB);
            aVar.fU(7, this.vIC);
            aVar.fU(8, this.vID);
            if (this.vXz != null) {
                aVar.fW(9, this.vXz.bke());
                this.vXz.a(aVar);
            }
            aVar.fU(10, this.ktN);
            if (this.vZU == null) {
                return 0;
            }
            aVar.g(11, this.vZU);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            r0 += e.a.a.a.fR(3, this.vHT);
            if (this.wRD != null) {
                r0 += e.a.a.b.b.a.h(4, this.wRD);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(5, this.ksU);
            }
            r0 = ((r0 + e.a.a.a.fR(6, this.vIB)) + e.a.a.a.fR(7, this.vIC)) + e.a.a.a.fR(8, this.vID);
            if (this.vXz != null) {
                r0 += e.a.a.a.fT(9, this.vXz.bke());
            }
            r0 += e.a.a.a.fR(10, this.ktN);
            if (this.vZU != null) {
                r0 += e.a.a.b.b.a.h(11, this.vZU);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vXz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpx com_tencent_mm_protocal_c_bpx = (bpx) objArr[1];
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
                        com_tencent_mm_protocal_c_bpx.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bpx.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bpx.vHT = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bpx.wRD = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bpx.ksU = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bpx.vIB = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bpx.vIC = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bpx.vID = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bpx.vXz = fdVar;
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bpx.ktN = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bpx.vZU = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
