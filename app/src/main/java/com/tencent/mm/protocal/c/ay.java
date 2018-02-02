package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ay extends a {
    public String nfn;
    public String ngg;
    public String niZ;
    public String vFU;
    public String vFV;
    public String vFW;
    public String vFX;
    public String vFY;
    public String vFZ;
    public cbw vGa;
    public String vGb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfn != null) {
                aVar.g(1, this.nfn);
            }
            if (this.vFU != null) {
                aVar.g(2, this.vFU);
            }
            if (this.vFV != null) {
                aVar.g(3, this.vFV);
            }
            if (this.ngg != null) {
                aVar.g(4, this.ngg);
            }
            if (this.niZ != null) {
                aVar.g(5, this.niZ);
            }
            if (this.vFW != null) {
                aVar.g(6, this.vFW);
            }
            if (this.vFX != null) {
                aVar.g(7, this.vFX);
            }
            if (this.vFY != null) {
                aVar.g(8, this.vFY);
            }
            if (this.vFZ != null) {
                aVar.g(9, this.vFZ);
            }
            if (this.vGa != null) {
                aVar.fW(10, this.vGa.bke());
                this.vGa.a(aVar);
            }
            if (this.vGb == null) {
                return 0;
            }
            aVar.g(11, this.vGb);
            return 0;
        } else if (i == 1) {
            if (this.nfn != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfn) + 0;
            } else {
                r0 = 0;
            }
            if (this.vFU != null) {
                r0 += e.a.a.b.b.a.h(2, this.vFU);
            }
            if (this.vFV != null) {
                r0 += e.a.a.b.b.a.h(3, this.vFV);
            }
            if (this.ngg != null) {
                r0 += e.a.a.b.b.a.h(4, this.ngg);
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(5, this.niZ);
            }
            if (this.vFW != null) {
                r0 += e.a.a.b.b.a.h(6, this.vFW);
            }
            if (this.vFX != null) {
                r0 += e.a.a.b.b.a.h(7, this.vFX);
            }
            if (this.vFY != null) {
                r0 += e.a.a.b.b.a.h(8, this.vFY);
            }
            if (this.vFZ != null) {
                r0 += e.a.a.b.b.a.h(9, this.vFZ);
            }
            if (this.vGa != null) {
                r0 += e.a.a.a.fT(10, this.vGa.bke());
            }
            if (this.vGb != null) {
                r0 += e.a.a.b.b.a.h(11, this.vGb);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ay ayVar = (ay) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ayVar.nfn = aVar3.Avy.readString();
                    return 0;
                case 2:
                    ayVar.vFU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ayVar.vFV = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ayVar.ngg = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ayVar.niZ = aVar3.Avy.readString();
                    return 0;
                case 6:
                    ayVar.vFW = aVar3.Avy.readString();
                    return 0;
                case 7:
                    ayVar.vFX = aVar3.Avy.readString();
                    return 0;
                case 8:
                    ayVar.vFY = aVar3.Avy.readString();
                    return 0;
                case 9:
                    ayVar.vFZ = aVar3.Avy.readString();
                    return 0;
                case 10:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_cbw = new cbw();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_cbw.a(aVar4, com_tencent_mm_protocal_c_cbw, a.a(aVar4))) {
                        }
                        ayVar.vGa = com_tencent_mm_protocal_c_cbw;
                    }
                    return 0;
                case 11:
                    ayVar.vGb = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
