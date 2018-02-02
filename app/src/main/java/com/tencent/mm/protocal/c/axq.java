package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class axq extends bdf {
    public String content;
    public String kLA;
    public boolean kMh;
    public int status;
    public String vER;
    public String vES;
    public String wEG;
    public String wEH;
    public String wEI;
    public String wEJ;
    public String wEK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            if (this.vER != null) {
                aVar.g(2, this.vER);
            }
            if (this.vES != null) {
                aVar.g(3, this.vES);
            }
            aVar.fU(4, this.status);
            if (this.content != null) {
                aVar.g(5, this.content);
            }
            if (this.kLA != null) {
                aVar.g(6, this.kLA);
            }
            if (this.wEG != null) {
                aVar.g(7, this.wEG);
            }
            aVar.al(8, this.kMh);
            if (this.wEH != null) {
                aVar.g(9, this.wEH);
            }
            if (this.wEI != null) {
                aVar.g(10, this.wEI);
            }
            if (this.wEJ != null) {
                aVar.g(11, this.wEJ);
            }
            if (this.wEK == null) {
                return 0;
            }
            aVar.g(12, this.wEK);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vER != null) {
                r0 += e.a.a.b.b.a.h(2, this.vER);
            }
            if (this.vES != null) {
                r0 += e.a.a.b.b.a.h(3, this.vES);
            }
            r0 += e.a.a.a.fR(4, this.status);
            if (this.content != null) {
                r0 += e.a.a.b.b.a.h(5, this.content);
            }
            if (this.kLA != null) {
                r0 += e.a.a.b.b.a.h(6, this.kLA);
            }
            if (this.wEG != null) {
                r0 += e.a.a.b.b.a.h(7, this.wEG);
            }
            r0 += e.a.a.b.b.a.dX(8) + 1;
            if (this.wEH != null) {
                r0 += e.a.a.b.b.a.h(9, this.wEH);
            }
            if (this.wEI != null) {
                r0 += e.a.a.b.b.a.h(10, this.wEI);
            }
            if (this.wEJ != null) {
                r0 += e.a.a.b.b.a.h(11, this.wEJ);
            }
            if (this.wEK != null) {
                r0 += e.a.a.b.b.a.h(12, this.wEK);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axq com_tencent_mm_protocal_c_axq = (axq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axq.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axq.vER = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axq.vES = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axq.status = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axq.content = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axq.kLA = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axq.wEG = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axq.kMh = aVar3.cJC();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_axq.wEH = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_axq.wEI = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_axq.wEJ = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_axq.wEK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
