package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ry extends a {
    public int ktN;
    public String nko;
    public String vHc;
    public int vIB;
    public int vIC;
    public String vZU;
    public bdn vZV;
    public String vZW;
    public String vZX;
    public String vZY;
    public int vZZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vZV == null) {
                throw new b("Not all required fields were included: EmojiBuffer");
            }
            if (this.vZU != null) {
                aVar.g(1, this.vZU);
            }
            aVar.fU(2, this.vIC);
            aVar.fU(3, this.vIB);
            if (this.vZV != null) {
                aVar.fW(4, this.vZV.bke());
                this.vZV.a(aVar);
            }
            aVar.fU(5, this.ktN);
            if (this.nko != null) {
                aVar.g(6, this.nko);
            }
            if (this.vZW != null) {
                aVar.g(7, this.vZW);
            }
            if (this.vZX != null) {
                aVar.g(8, this.vZX);
            }
            if (this.vZY != null) {
                aVar.g(9, this.vZY);
            }
            if (this.vHc != null) {
                aVar.g(10, this.vHc);
            }
            aVar.fU(11, this.vZZ);
            return 0;
        } else if (i == 1) {
            if (this.vZU != null) {
                r0 = e.a.a.b.b.a.h(1, this.vZU) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.vIC)) + e.a.a.a.fR(3, this.vIB);
            if (this.vZV != null) {
                r0 += e.a.a.a.fT(4, this.vZV.bke());
            }
            r0 += e.a.a.a.fR(5, this.ktN);
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(6, this.nko);
            }
            if (this.vZW != null) {
                r0 += e.a.a.b.b.a.h(7, this.vZW);
            }
            if (this.vZX != null) {
                r0 += e.a.a.b.b.a.h(8, this.vZX);
            }
            if (this.vZY != null) {
                r0 += e.a.a.b.b.a.h(9, this.vZY);
            }
            if (this.vHc != null) {
                r0 += e.a.a.b.b.a.h(10, this.vHc);
            }
            return r0 + e.a.a.a.fR(11, this.vZZ);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vZV != null) {
                return 0;
            }
            throw new b("Not all required fields were included: EmojiBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ry ryVar = (ry) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ryVar.vZU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    ryVar.vIC = aVar3.Avy.ry();
                    return 0;
                case 3:
                    ryVar.vIB = aVar3.Avy.ry();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bdn = new bdn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        ryVar.vZV = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 5:
                    ryVar.ktN = aVar3.Avy.ry();
                    return 0;
                case 6:
                    ryVar.nko = aVar3.Avy.readString();
                    return 0;
                case 7:
                    ryVar.vZW = aVar3.Avy.readString();
                    return 0;
                case 8:
                    ryVar.vZX = aVar3.Avy.readString();
                    return 0;
                case 9:
                    ryVar.vZY = aVar3.Avy.readString();
                    return 0;
                case 10:
                    ryVar.vHc = aVar3.Avy.readString();
                    return 0;
                case 11:
                    ryVar.vZZ = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
