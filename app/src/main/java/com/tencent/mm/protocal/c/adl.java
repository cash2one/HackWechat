package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class adl extends bcv {
    public int Height;
    public int Width;
    public String lOo;
    public float vQt;
    public float vQu;
    public int wmc;
    public int wmd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.m(2, this.vQt);
            aVar.m(3, this.vQu);
            aVar.fU(4, this.Width);
            aVar.fU(5, this.Height);
            if (this.lOo != null) {
                aVar.g(6, this.lOo);
            }
            aVar.fU(7, this.wmc);
            aVar.fU(8, this.wmd);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + (e.a.a.b.b.a.dX(2) + 4)) + (e.a.a.b.b.a.dX(3) + 4)) + e.a.a.a.fR(4, this.Width)) + e.a.a.a.fR(5, this.Height);
            if (this.lOo != null) {
                r0 += e.a.a.b.b.a.h(6, this.lOo);
            }
            return (r0 + e.a.a.a.fR(7, this.wmc)) + e.a.a.a.fR(8, this.wmd);
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
            adl com_tencent_mm_protocal_c_adl = (adl) objArr[1];
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
                        com_tencent_mm_protocal_c_adl.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adl.vQt = aVar3.Avy.readFloat();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adl.vQu = aVar3.Avy.readFloat();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adl.Width = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adl.Height = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_adl.lOo = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_adl.wmc = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_adl.wmd = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
