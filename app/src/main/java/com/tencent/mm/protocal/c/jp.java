package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class jp extends a {
    public int lOd;
    public int vPZ;
    public int vQa;
    public int vQb;
    public int vQc;
    public LinkedList<bdo> vQd = new LinkedList();
    public String vQe;
    public bdn vQf;
    public int vQg;
    public int vQh;
    public LinkedList<bdo> vQi = new LinkedList();
    public LinkedList<jq> vQj = new LinkedList();
    public LinkedList<jq> vQk = new LinkedList();
    public int vQl;
    public int vQm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQf == null) {
                throw new b("Not all required fields were included: AuthKey");
            }
            aVar.fU(1, this.vPZ);
            aVar.fU(2, this.lOd);
            aVar.fU(3, this.vQa);
            aVar.fU(4, this.vQb);
            aVar.fU(5, this.vQc);
            aVar.d(6, 8, this.vQd);
            if (this.vQe != null) {
                aVar.g(7, this.vQe);
            }
            if (this.vQf != null) {
                aVar.fW(8, this.vQf.bke());
                this.vQf.a(aVar);
            }
            aVar.fU(9, this.vQg);
            aVar.fU(10, this.vQh);
            aVar.d(11, 8, this.vQi);
            aVar.d(12, 8, this.vQj);
            aVar.d(13, 8, this.vQk);
            aVar.fU(14, this.vQl);
            aVar.fU(15, this.vQm);
            return 0;
        } else if (i == 1) {
            r0 = (((((e.a.a.a.fR(1, this.vPZ) + 0) + e.a.a.a.fR(2, this.lOd)) + e.a.a.a.fR(3, this.vQa)) + e.a.a.a.fR(4, this.vQb)) + e.a.a.a.fR(5, this.vQc)) + e.a.a.a.c(6, 8, this.vQd);
            if (this.vQe != null) {
                r0 += e.a.a.b.b.a.h(7, this.vQe);
            }
            if (this.vQf != null) {
                r0 += e.a.a.a.fT(8, this.vQf.bke());
            }
            return ((((((r0 + e.a.a.a.fR(9, this.vQg)) + e.a.a.a.fR(10, this.vQh)) + e.a.a.a.c(11, 8, this.vQi)) + e.a.a.a.c(12, 8, this.vQj)) + e.a.a.a.c(13, 8, this.vQk)) + e.a.a.a.fR(14, this.vQl)) + e.a.a.a.fR(15, this.vQm);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vQd.clear();
            this.vQi.clear();
            this.vQj.clear();
            this.vQk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vQf != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AuthKey");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jp jpVar = (jp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jpVar.vPZ = aVar3.Avy.ry();
                    return 0;
                case 2:
                    jpVar.lOd = aVar3.Avy.ry();
                    return 0;
                case 3:
                    jpVar.vQa = aVar3.Avy.ry();
                    return 0;
                case 4:
                    jpVar.vQb = aVar3.Avy.ry();
                    return 0;
                case 5:
                    jpVar.vQc = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        jpVar.vQd.add(com_tencent_mm_protocal_c_bdo);
                    }
                    return 0;
                case 7:
                    jpVar.vQe = aVar3.Avy.readString();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        jpVar.vQf = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 9:
                    jpVar.vQg = aVar3.Avy.ry();
                    return 0;
                case 10:
                    jpVar.vQh = aVar3.Avy.ry();
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        jpVar.vQi.add(com_tencent_mm_protocal_c_bdo);
                    }
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new jq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        jpVar.vQj.add(com_tencent_mm_protocal_c_bdo);
                    }
                    return 0;
                case 13:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new jq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        jpVar.vQk.add(com_tencent_mm_protocal_c_bdo);
                    }
                    return 0;
                case 14:
                    jpVar.vQl = aVar3.Avy.ry();
                    return 0;
                case 15:
                    jpVar.vQm = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
