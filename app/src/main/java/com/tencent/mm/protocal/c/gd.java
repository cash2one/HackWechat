package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class gd extends a {
    public String ksY;
    public int vJU;
    public String vLs;
    public String vLx;
    public arp vLy;
    public ajr vLz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vJU);
            if (this.vLx != null) {
                aVar.g(2, this.vLx);
            }
            if (this.vLy != null) {
                aVar.fW(3, this.vLy.bke());
                this.vLy.a(aVar);
            }
            if (this.vLs != null) {
                aVar.g(4, this.vLs);
            }
            if (this.ksY != null) {
                aVar.g(5, this.ksY);
            }
            if (this.vLz != null) {
                aVar.fW(6, this.vLz.bke());
                this.vLz.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vJU) + 0;
            if (this.vLx != null) {
                r0 += e.a.a.b.b.a.h(2, this.vLx);
            }
            if (this.vLy != null) {
                r0 += e.a.a.a.fT(3, this.vLy.bke());
            }
            if (this.vLs != null) {
                r0 += e.a.a.b.b.a.h(4, this.vLs);
            }
            if (this.ksY != null) {
                r0 += e.a.a.b.b.a.h(5, this.ksY);
            }
            if (this.vLz != null) {
                return r0 + e.a.a.a.fT(6, this.vLz.bke());
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
            gd gdVar = (gd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_arp;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    gdVar.vJU = aVar3.Avy.ry();
                    return 0;
                case 2:
                    gdVar.vLx = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_arp = new arp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arp.a(aVar4, com_tencent_mm_protocal_c_arp, a.a(aVar4))) {
                        }
                        gdVar.vLy = com_tencent_mm_protocal_c_arp;
                    }
                    return 0;
                case 4:
                    gdVar.vLs = aVar3.Avy.readString();
                    return 0;
                case 5:
                    gdVar.ksY = aVar3.Avy.readString();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_arp = new ajr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arp.a(aVar4, com_tencent_mm_protocal_c_arp, a.a(aVar4))) {
                        }
                        gdVar.vLz = com_tencent_mm_protocal_c_arp;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
