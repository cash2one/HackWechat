package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class tx extends bcv {
    public String fWp;
    public String fWq;
    public String lOX;
    public String wbT;
    public String wbU;
    public long wbV;
    public double wbW;
    public double wbX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.lOX != null) {
                aVar.g(2, this.lOX);
            }
            if (this.fWq != null) {
                aVar.g(3, this.fWq);
            }
            if (this.fWp != null) {
                aVar.g(4, this.fWp);
            }
            if (this.wbT != null) {
                aVar.g(5, this.wbT);
            }
            if (this.wbU != null) {
                aVar.g(6, this.wbU);
            }
            aVar.S(7, this.wbV);
            aVar.b(8, this.wbW);
            aVar.b(9, this.wbX);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.lOX != null) {
                r0 += e.a.a.b.b.a.h(2, this.lOX);
            }
            if (this.fWq != null) {
                r0 += e.a.a.b.b.a.h(3, this.fWq);
            }
            if (this.fWp != null) {
                r0 += e.a.a.b.b.a.h(4, this.fWp);
            }
            if (this.wbT != null) {
                r0 += e.a.a.b.b.a.h(5, this.wbT);
            }
            if (this.wbU != null) {
                r0 += e.a.a.b.b.a.h(6, this.wbU);
            }
            return ((r0 + e.a.a.a.R(7, this.wbV)) + (e.a.a.b.b.a.dX(8) + 8)) + (e.a.a.b.b.a.dX(9) + 8);
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
            tx txVar = (tx) objArr[1];
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
                        txVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    txVar.lOX = aVar3.Avy.readString();
                    return 0;
                case 3:
                    txVar.fWq = aVar3.Avy.readString();
                    return 0;
                case 4:
                    txVar.fWp = aVar3.Avy.readString();
                    return 0;
                case 5:
                    txVar.wbT = aVar3.Avy.readString();
                    return 0;
                case 6:
                    txVar.wbU = aVar3.Avy.readString();
                    return 0;
                case 7:
                    txVar.wbV = aVar3.Avy.rz();
                    return 0;
                case 8:
                    txVar.wbW = aVar3.Avy.readDouble();
                    return 0;
                case 9:
                    txVar.wbX = aVar3.Avy.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
