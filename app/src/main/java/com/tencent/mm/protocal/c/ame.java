package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ame extends bcv {
    public String fFm;
    public String fqD;
    public String signature;
    public String url;
    public String wsE;
    public String wsG;
    public String wsH;
    public b wsI;
    public int wsJ;
    public LinkedList<ams> wsN = new LinkedList();

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
            if (this.fFm != null) {
                aVar.g(3, this.fFm);
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
            aVar.d(11, 8, this.wsN);
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
            if (this.fFm != null) {
                r0 += e.a.a.b.b.a.h(3, this.fFm);
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
            return (r0 + e.a.a.a.fR(10, this.wsJ)) + e.a.a.a.c(11, 8, this.wsN);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wsN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            ame com_tencent_mm_protocal_c_ame = (ame) objArr[1];
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
                        com_tencent_mm_protocal_c_ame.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ame.url = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ame.fFm = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ame.wsE = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ame.fqD = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ame.wsG = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ame.signature = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ame.wsH = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ame.wsI = aVar3.cJD();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ame.wsJ = aVar3.Avy.ry();
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new ams();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.wsN.add(fdVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
