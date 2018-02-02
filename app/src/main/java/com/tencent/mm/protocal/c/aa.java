package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class aa extends bcv {
    public String SSID;
    public String URL;
    public String vDT;
    public String vDU;
    public String vDV;
    public int vDW;
    public LinkedList<cn> vDX = new LinkedList();
    public int vDY;
    public String vDZ;
    public int vEa;
    public String vEb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.URL != null) {
                aVar.g(2, this.URL);
            }
            if (this.SSID != null) {
                aVar.g(3, this.SSID);
            }
            if (this.vDT != null) {
                aVar.g(4, this.vDT);
            }
            if (this.vDU != null) {
                aVar.g(5, this.vDU);
            }
            if (this.vDV != null) {
                aVar.g(6, this.vDV);
            }
            aVar.fU(7, this.vDW);
            aVar.d(8, 8, this.vDX);
            aVar.fU(9, this.vDY);
            if (this.vDZ != null) {
                aVar.g(10, this.vDZ);
            }
            aVar.fU(11, this.vEa);
            if (this.vEb == null) {
                return 0;
            }
            aVar.g(12, this.vEb);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.URL != null) {
                r0 += e.a.a.b.b.a.h(2, this.URL);
            }
            if (this.SSID != null) {
                r0 += e.a.a.b.b.a.h(3, this.SSID);
            }
            if (this.vDT != null) {
                r0 += e.a.a.b.b.a.h(4, this.vDT);
            }
            if (this.vDU != null) {
                r0 += e.a.a.b.b.a.h(5, this.vDU);
            }
            if (this.vDV != null) {
                r0 += e.a.a.b.b.a.h(6, this.vDV);
            }
            r0 = ((r0 + e.a.a.a.fR(7, this.vDW)) + e.a.a.a.c(8, 8, this.vDX)) + e.a.a.a.fR(9, this.vDY);
            if (this.vDZ != null) {
                r0 += e.a.a.b.b.a.h(10, this.vDZ);
            }
            r0 += e.a.a.a.fR(11, this.vEa);
            if (this.vEb != null) {
                r0 += e.a.a.b.b.a.h(12, this.vEb);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vDX.clear();
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
            aa aaVar = (aa) objArr[1];
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
                        aaVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    aaVar.URL = aVar3.Avy.readString();
                    return 0;
                case 3:
                    aaVar.SSID = aVar3.Avy.readString();
                    return 0;
                case 4:
                    aaVar.vDT = aVar3.Avy.readString();
                    return 0;
                case 5:
                    aaVar.vDU = aVar3.Avy.readString();
                    return 0;
                case 6:
                    aaVar.vDV = aVar3.Avy.readString();
                    return 0;
                case 7:
                    aaVar.vDW = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new cn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        aaVar.vDX.add(fdVar);
                    }
                    return 0;
                case 9:
                    aaVar.vDY = aVar3.Avy.ry();
                    return 0;
                case 10:
                    aaVar.vDZ = aVar3.Avy.readString();
                    return 0;
                case 11:
                    aaVar.vEa = aVar3.Avy.ry();
                    return 0;
                case 12:
                    aaVar.vEb = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
