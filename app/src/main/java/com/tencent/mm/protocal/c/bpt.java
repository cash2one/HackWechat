package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bpt extends bcv {
    public int aAk;
    public int scene;
    public String username;
    public int vOu;
    public int wRA;
    public int wRB;
    public String wRC;
    public int wRz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.scene);
            aVar.fU(3, this.wRz);
            aVar.fU(4, this.vOu);
            aVar.fU(5, this.wRA);
            aVar.fU(6, this.wRB);
            if (this.username != null) {
                aVar.g(7, this.username);
            }
            aVar.fU(8, this.aAk);
            if (this.wRC == null) {
                return 0;
            }
            aVar.g(9, this.wRC);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + e.a.a.a.fR(2, this.scene)) + e.a.a.a.fR(3, this.wRz)) + e.a.a.a.fR(4, this.vOu)) + e.a.a.a.fR(5, this.wRA)) + e.a.a.a.fR(6, this.wRB);
            if (this.username != null) {
                r0 += e.a.a.b.b.a.h(7, this.username);
            }
            r0 += e.a.a.a.fR(8, this.aAk);
            if (this.wRC != null) {
                r0 += e.a.a.b.b.a.h(9, this.wRC);
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
            bpt com_tencent_mm_protocal_c_bpt = (bpt) objArr[1];
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
                        com_tencent_mm_protocal_c_bpt.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bpt.scene = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bpt.wRz = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bpt.vOu = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bpt.wRA = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bpt.wRB = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bpt.username = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bpt.aAk = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bpt.wRC = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
