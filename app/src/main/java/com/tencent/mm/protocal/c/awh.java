package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class awh extends a {
    public String desc;
    public String kJP;
    public String name;
    public String sAa;
    public String sAb;
    public String sAc;
    public int szZ;
    public String title;
    public bbn wDY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.g(1, this.name);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            if (this.kJP != null) {
                aVar.g(4, this.kJP);
            }
            aVar.fU(5, this.szZ);
            if (this.sAa != null) {
                aVar.g(6, this.sAa);
            }
            if (this.sAb != null) {
                aVar.g(7, this.sAb);
            }
            if (this.sAc != null) {
                aVar.g(8, this.sAc);
            }
            if (this.wDY == null) {
                return 0;
            }
            aVar.fW(9, this.wDY.bke());
            this.wDY.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                r0 = e.a.a.b.b.a.h(1, this.name) + 0;
            } else {
                r0 = 0;
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(2, this.title);
            }
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(3, this.desc);
            }
            if (this.kJP != null) {
                r0 += e.a.a.b.b.a.h(4, this.kJP);
            }
            r0 += e.a.a.a.fR(5, this.szZ);
            if (this.sAa != null) {
                r0 += e.a.a.b.b.a.h(6, this.sAa);
            }
            if (this.sAb != null) {
                r0 += e.a.a.b.b.a.h(7, this.sAb);
            }
            if (this.sAc != null) {
                r0 += e.a.a.b.b.a.h(8, this.sAc);
            }
            if (this.wDY != null) {
                r0 += e.a.a.a.fT(9, this.wDY.bke());
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
            awh com_tencent_mm_protocal_c_awh = (awh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_awh.name = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awh.title = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awh.desc = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awh.kJP = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_awh.szZ = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_awh.sAa = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_awh.sAb = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_awh.sAc = aVar3.Avy.readString();
                    return 0;
                case 9:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bbn = new bbn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bbn.a(aVar4, com_tencent_mm_protocal_c_bbn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awh.wDY = com_tencent_mm_protocal_c_bbn;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
