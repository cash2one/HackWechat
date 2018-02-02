package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ep extends a {
    public String ID;
    public int vJU;
    public bdn vJV;
    public String vJW;
    public int vJX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJV == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            }
            aVar.fU(1, this.vJU);
            if (this.vJV != null) {
                aVar.fW(2, this.vJV.bke());
                this.vJV.a(aVar);
            }
            if (this.vJW != null) {
                aVar.g(3, this.vJW);
            }
            aVar.fU(4, this.vJX);
            if (this.ID != null) {
                aVar.g(5, this.ID);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vJU) + 0;
            if (this.vJV != null) {
                r0 += e.a.a.a.fT(2, this.vJV.bke());
            }
            if (this.vJW != null) {
                r0 += e.a.a.b.b.a.h(3, this.vJW);
            }
            r0 += e.a.a.a.fR(4, this.vJX);
            if (this.ID != null) {
                return r0 + e.a.a.b.b.a.h(5, this.ID);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vJV != null) {
                return 0;
            }
            throw new b("Not all required fields were included: QRCodeBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ep epVar = (ep) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    epVar.vJU = aVar3.Avy.ry();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bdn = new bdn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdn.a(aVar4, com_tencent_mm_protocal_c_bdn, a.a(aVar4))) {
                        }
                        epVar.vJV = com_tencent_mm_protocal_c_bdn;
                    }
                    return 0;
                case 3:
                    epVar.vJW = aVar3.Avy.readString();
                    return 0;
                case 4:
                    epVar.vJX = aVar3.Avy.ry();
                    return 0;
                case 5:
                    epVar.ID = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
