package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class als extends bcv {
    public String fqD;
    public String nfn;
    public String scope;
    public String signature;
    public String url;
    public String wsE;
    public String wsG;
    public String wsH;
    public b wsI;
    public int wsJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.nfn != null) {
                aVar.g(3, this.nfn);
            }
            if (this.wsE != null) {
                aVar.g(4, this.wsE);
            }
            if (this.fqD != null) {
                aVar.g(5, this.fqD);
            }
            if (this.wsG != null) {
                aVar.g(6, this.wsG);
            }
            if (this.signature != null) {
                aVar.g(7, this.signature);
            }
            if (this.wsH != null) {
                aVar.g(8, this.wsH);
            }
            if (this.wsI != null) {
                aVar.b(9, this.wsI);
            }
            aVar.fU(10, this.wsJ);
            if (this.scope == null) {
                return 0;
            }
            aVar.g(11, this.scope);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(2, this.url);
            }
            if (this.nfn != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfn);
            }
            if (this.wsE != null) {
                r0 += e.a.a.b.b.a.h(4, this.wsE);
            }
            if (this.fqD != null) {
                r0 += e.a.a.b.b.a.h(5, this.fqD);
            }
            if (this.wsG != null) {
                r0 += e.a.a.b.b.a.h(6, this.wsG);
            }
            if (this.signature != null) {
                r0 += e.a.a.b.b.a.h(7, this.signature);
            }
            if (this.wsH != null) {
                r0 += e.a.a.b.b.a.h(8, this.wsH);
            }
            if (this.wsI != null) {
                r0 += e.a.a.a.a(9, this.wsI);
            }
            r0 += e.a.a.a.fR(10, this.wsJ);
            if (this.scope != null) {
                r0 += e.a.a.b.b.a.h(11, this.scope);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            als com_tencent_mm_protocal_c_als = (als) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_als.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_als.url = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_als.nfn = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_als.wsE = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_als.fqD = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_als.wsG = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_als.signature = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_als.wsH = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_als.wsI = aVar3.cJD();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_als.wsJ = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_als.scope = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
