package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class na extends bcv {
    public String vVL;
    public String vVM;
    public String vVN;
    public String vVO;
    public String vVP;
    public long vVQ;
    public String vVR;
    public String vVS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vVL != null) {
                aVar.g(2, this.vVL);
            }
            if (this.vVM != null) {
                aVar.g(3, this.vVM);
            }
            if (this.vVN != null) {
                aVar.g(4, this.vVN);
            }
            if (this.vVO != null) {
                aVar.g(5, this.vVO);
            }
            if (this.vVP != null) {
                aVar.g(6, this.vVP);
            }
            aVar.S(7, this.vVQ);
            if (this.vVR != null) {
                aVar.g(8, this.vVR);
            }
            if (this.vVS == null) {
                return 0;
            }
            aVar.g(9, this.vVS);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vVL != null) {
                r0 += e.a.a.b.b.a.h(2, this.vVL);
            }
            if (this.vVM != null) {
                r0 += e.a.a.b.b.a.h(3, this.vVM);
            }
            if (this.vVN != null) {
                r0 += e.a.a.b.b.a.h(4, this.vVN);
            }
            if (this.vVO != null) {
                r0 += e.a.a.b.b.a.h(5, this.vVO);
            }
            if (this.vVP != null) {
                r0 += e.a.a.b.b.a.h(6, this.vVP);
            }
            r0 += e.a.a.a.R(7, this.vVQ);
            if (this.vVR != null) {
                r0 += e.a.a.b.b.a.h(8, this.vVR);
            }
            if (this.vVS != null) {
                r0 += e.a.a.b.b.a.h(9, this.vVS);
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
            na naVar = (na) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        naVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    naVar.vVL = aVar3.Avy.readString();
                    return 0;
                case 3:
                    naVar.vVM = aVar3.Avy.readString();
                    return 0;
                case 4:
                    naVar.vVN = aVar3.Avy.readString();
                    return 0;
                case 5:
                    naVar.vVO = aVar3.Avy.readString();
                    return 0;
                case 6:
                    naVar.vVP = aVar3.Avy.readString();
                    return 0;
                case 7:
                    naVar.vVQ = aVar3.Avy.rz();
                    return 0;
                case 8:
                    naVar.vVR = aVar3.Avy.readString();
                    return 0;
                case 9:
                    naVar.vVS = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
