package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class akl extends a {
    public int wrE;
    public ako wrF;
    public akn wrG;
    public akm wrH;
    public akk wrI;
    public akp wrJ;
    public akq wrK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wrE);
            if (this.wrF != null) {
                aVar.fW(2, this.wrF.bke());
                this.wrF.a(aVar);
            }
            if (this.wrG != null) {
                aVar.fW(3, this.wrG.bke());
                this.wrG.a(aVar);
            }
            if (this.wrH != null) {
                aVar.fW(4, this.wrH.bke());
                this.wrH.a(aVar);
            }
            if (this.wrI != null) {
                aVar.fW(5, this.wrI.bke());
                this.wrI.a(aVar);
            }
            if (this.wrJ != null) {
                aVar.fW(6, this.wrJ.bke());
                this.wrJ.a(aVar);
            }
            if (this.wrK != null) {
                aVar.fW(7, this.wrK.bke());
                this.wrK.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wrE) + 0;
            if (this.wrF != null) {
                r0 += e.a.a.a.fT(2, this.wrF.bke());
            }
            if (this.wrG != null) {
                r0 += e.a.a.a.fT(3, this.wrG.bke());
            }
            if (this.wrH != null) {
                r0 += e.a.a.a.fT(4, this.wrH.bke());
            }
            if (this.wrI != null) {
                r0 += e.a.a.a.fT(5, this.wrI.bke());
            }
            if (this.wrJ != null) {
                r0 += e.a.a.a.fT(6, this.wrJ.bke());
            }
            if (this.wrK != null) {
                return r0 + e.a.a.a.fT(7, this.wrK.bke());
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
            akl com_tencent_mm_protocal_c_akl = (akl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_ako;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_akl.wrE = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ako = new ako();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ako.a(aVar4, com_tencent_mm_protocal_c_ako, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akl.wrF = com_tencent_mm_protocal_c_ako;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ako = new akn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ako.a(aVar4, com_tencent_mm_protocal_c_ako, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akl.wrG = com_tencent_mm_protocal_c_ako;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ako = new akm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ako.a(aVar4, com_tencent_mm_protocal_c_ako, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akl.wrH = com_tencent_mm_protocal_c_ako;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ako = new akk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ako.a(aVar4, com_tencent_mm_protocal_c_ako, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akl.wrI = com_tencent_mm_protocal_c_ako;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ako = new akp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ako.a(aVar4, com_tencent_mm_protocal_c_ako, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akl.wrJ = com_tencent_mm_protocal_c_ako;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_ako = new akq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ako.a(aVar4, com_tencent_mm_protocal_c_ako, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akl.wrK = com_tencent_mm_protocal_c_ako;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
