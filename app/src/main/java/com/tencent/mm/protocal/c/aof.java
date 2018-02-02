package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class aof extends a {
    public String fon;
    public int ktN;
    public String oPA;
    public bdn oPB;
    public String oPt;
    public float oPu;
    public int oPv;
    public LinkedList<Integer> oPw = new LinkedList();
    public int oPx;
    public LinkedList<bdo> oPy = new LinkedList();
    public float oPz;
    public String wvn;
    public bdn wvo;
    public int wvp;
    public int wvq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.oPt != null) {
                aVar.g(1, this.oPt);
            }
            if (this.fon != null) {
                aVar.g(2, this.fon);
            }
            aVar.m(3, this.oPu);
            aVar.fU(4, this.oPv);
            aVar.c(5, this.oPw);
            aVar.fU(6, this.oPx);
            aVar.d(7, 8, this.oPy);
            aVar.m(8, this.oPz);
            if (this.oPA != null) {
                aVar.g(9, this.oPA);
            }
            aVar.fU(10, this.ktN);
            if (this.oPB != null) {
                aVar.fW(11, this.oPB.bke());
                this.oPB.a(aVar);
            }
            if (this.wvn != null) {
                aVar.g(12, this.wvn);
            }
            if (this.wvo != null) {
                aVar.fW(13, this.wvo.bke());
                this.wvo.a(aVar);
            }
            aVar.fU(14, this.wvp);
            aVar.fU(15, this.wvq);
            return 0;
        } else if (i == 1) {
            if (this.oPt != null) {
                r0 = e.a.a.b.b.a.h(1, this.oPt) + 0;
            } else {
                r0 = 0;
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
            }
            r0 = (((((r0 + (e.a.a.b.b.a.dX(3) + 4)) + e.a.a.a.fR(4, this.oPv)) + e.a.a.a.b(5, this.oPw)) + e.a.a.a.fR(6, this.oPx)) + e.a.a.a.c(7, 8, this.oPy)) + (e.a.a.b.b.a.dX(8) + 4);
            if (this.oPA != null) {
                r0 += e.a.a.b.b.a.h(9, this.oPA);
            }
            r0 += e.a.a.a.fR(10, this.ktN);
            if (this.oPB != null) {
                r0 += e.a.a.a.fT(11, this.oPB.bke());
            }
            if (this.wvn != null) {
                r0 += e.a.a.b.b.a.h(12, this.wvn);
            }
            if (this.wvo != null) {
                r0 += e.a.a.a.fT(13, this.wvo.bke());
            }
            return (r0 + e.a.a.a.fR(14, this.wvp)) + e.a.a.a.fR(15, this.wvq);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.oPw.clear();
            this.oPy.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            aof com_tencent_mm_protocal_c_aof = (aof) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aof.oPt = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aof.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aof.oPu = aVar3.Avy.readFloat();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aof.oPv = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aof.oPw = new e.a.a.a.a(aVar3.cJD().oz, unknownTagHandler).cJA();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aof.oPx = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aof.oPy.add(com_tencent_mm_protocal_c_bdo);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aof.oPz = aVar3.Avy.readFloat();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aof.oPA = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aof.ktN = aVar3.Avy.ry();
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aof.oPB = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aof.wvn = aVar3.Avy.readString();
                    return 0;
                case 13:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aof.wvo = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aof.wvp = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aof.wvq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
