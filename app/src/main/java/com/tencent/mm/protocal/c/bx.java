package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bx extends a {
    public int ngq;
    public int pbl;
    public long vHe;
    public int vHf;
    public bdo vHg;
    public int vHh;
    public bdo vHi;
    public int vHj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHg == null) {
                throw new b("Not all required fields were included: ChatRoomId");
            } else if (this.vHi == null) {
                throw new b("Not all required fields were included: DigestContent");
            } else {
                if (this.vHg != null) {
                    aVar.fW(1, this.vHg.bke());
                    this.vHg.a(aVar);
                }
                aVar.S(2, this.vHe);
                aVar.fU(3, this.vHf);
                aVar.fU(4, this.pbl);
                aVar.fU(5, this.vHh);
                if (this.vHi != null) {
                    aVar.fW(6, this.vHi.bke());
                    this.vHi.a(aVar);
                }
                aVar.fU(7, this.vHj);
                aVar.fU(8, this.ngq);
                return 0;
            }
        } else if (i == 1) {
            if (this.vHg != null) {
                r0 = e.a.a.a.fT(1, this.vHg.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + e.a.a.a.R(2, this.vHe)) + e.a.a.a.fR(3, this.vHf)) + e.a.a.a.fR(4, this.pbl)) + e.a.a.a.fR(5, this.vHh);
            if (this.vHi != null) {
                r0 += e.a.a.a.fT(6, this.vHi.bke());
            }
            return (r0 + e.a.a.a.fR(7, this.vHj)) + e.a.a.a.fR(8, this.ngq);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vHg == null) {
                throw new b("Not all required fields were included: ChatRoomId");
            } else if (this.vHi != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DigestContent");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bx bxVar = (bx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        bxVar.vHg = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 2:
                    bxVar.vHe = aVar3.Avy.rz();
                    return 0;
                case 3:
                    bxVar.vHf = aVar3.Avy.ry();
                    return 0;
                case 4:
                    bxVar.pbl = aVar3.Avy.ry();
                    return 0;
                case 5:
                    bxVar.vHh = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        bxVar.vHi = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 7:
                    bxVar.vHj = aVar3.Avy.ry();
                    return 0;
                case 8:
                    bxVar.ngq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
