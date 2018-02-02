package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bbt extends bcv {
    public bdn vMi;
    public String wIb;
    public String wIc;
    public String wiX;
    public long wiY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.S(2, this.wiY);
            if (this.wIb != null) {
                aVar.g(3, this.wIb);
            }
            if (this.wIc != null) {
                aVar.g(4, this.wIc);
            }
            if (this.wiX != null) {
                aVar.g(5, this.wiX);
            }
            if (this.vMi == null) {
                return 0;
            }
            aVar.fW(6, this.vMi.bke());
            this.vMi.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.R(2, this.wiY);
            if (this.wIb != null) {
                r0 += e.a.a.b.b.a.h(3, this.wIb);
            }
            if (this.wIc != null) {
                r0 += e.a.a.b.b.a.h(4, this.wIc);
            }
            if (this.wiX != null) {
                r0 += e.a.a.b.b.a.h(5, this.wiX);
            }
            if (this.vMi != null) {
                r0 += e.a.a.a.fT(6, this.vMi.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbt com_tencent_mm_protocal_c_bbt = (bbt) objArr[1];
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
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbt.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbt.wiY = aVar3.Avy.rz();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbt.wIb = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bbt.wIc = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bbt.wiX = aVar3.Avy.readString();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbt.vMi = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
