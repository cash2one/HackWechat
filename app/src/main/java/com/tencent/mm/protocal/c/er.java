package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class er extends a {
    public int ktN;
    public int vGW;
    public bdo vGX;
    public bdo vGY;
    public bdo vGZ;
    public String vHU;
    public String vHc;
    public long vHe;
    public int vKa;
    public int vKb;
    public int vKc;
    public LinkedList<bdo> vKd = new LinkedList();
    public LinkedList<bdp> vKe = new LinkedList();
    public bdn vKf;
    public int vKg;
    public int vKh;
    public int vKi;
    public long vKj;
    public int vKk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vGX == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vGY == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.vGZ == null) {
                throw new b("Not all required fields were included: Content");
            } else {
                aVar.fU(1, this.ktN);
                if (this.vHU != null) {
                    aVar.g(2, this.vHU);
                }
                if (this.vGX != null) {
                    aVar.fW(3, this.vGX.bke());
                    this.vGX.a(aVar);
                }
                if (this.vGY != null) {
                    aVar.fW(4, this.vGY.bke());
                    this.vGY.a(aVar);
                }
                if (this.vGZ != null) {
                    aVar.fW(5, this.vGZ.bke());
                    this.vGZ.a(aVar);
                }
                aVar.fU(6, this.vKa);
                aVar.fU(7, this.vKb);
                if (this.vHc != null) {
                    aVar.g(8, this.vHc);
                }
                aVar.fU(9, this.vGW);
                aVar.fU(10, this.vKc);
                aVar.d(11, 8, this.vKd);
                aVar.d(12, 8, this.vKe);
                if (this.vKf != null) {
                    aVar.fW(13, this.vKf.bke());
                    this.vKf.a(aVar);
                }
                aVar.fU(14, this.vKg);
                aVar.fU(15, this.vKh);
                aVar.S(16, this.vHe);
                aVar.fU(17, this.vKi);
                aVar.S(18, this.vKj);
                aVar.fU(19, this.vKk);
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.ktN) + 0;
            if (this.vHU != null) {
                r0 += e.a.a.b.b.a.h(2, this.vHU);
            }
            if (this.vGX != null) {
                r0 += e.a.a.a.fT(3, this.vGX.bke());
            }
            if (this.vGY != null) {
                r0 += e.a.a.a.fT(4, this.vGY.bke());
            }
            if (this.vGZ != null) {
                r0 += e.a.a.a.fT(5, this.vGZ.bke());
            }
            r0 = (r0 + e.a.a.a.fR(6, this.vKa)) + e.a.a.a.fR(7, this.vKb);
            if (this.vHc != null) {
                r0 += e.a.a.b.b.a.h(8, this.vHc);
            }
            r0 = (((r0 + e.a.a.a.fR(9, this.vGW)) + e.a.a.a.fR(10, this.vKc)) + e.a.a.a.c(11, 8, this.vKd)) + e.a.a.a.c(12, 8, this.vKe);
            if (this.vKf != null) {
                r0 += e.a.a.a.fT(13, this.vKf.bke());
            }
            return (((((r0 + e.a.a.a.fR(14, this.vKg)) + e.a.a.a.fR(15, this.vKh)) + e.a.a.a.R(16, this.vHe)) + e.a.a.a.fR(17, this.vKi)) + e.a.a.a.R(18, this.vKj)) + e.a.a.a.fR(19, this.vKk);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vKd.clear();
            this.vKe.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vGX == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vGY == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.vGZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            er erVar = (er) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    erVar.ktN = aVar3.Avy.ry();
                    return 0;
                case 2:
                    erVar.vHU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        erVar.vGX = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        erVar.vGY = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        erVar.vGZ = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 6:
                    erVar.vKa = aVar3.Avy.ry();
                    return 0;
                case 7:
                    erVar.vKb = aVar3.Avy.ry();
                    return 0;
                case 8:
                    erVar.vHc = aVar3.Avy.readString();
                    return 0;
                case 9:
                    erVar.vGW = aVar3.Avy.ry();
                    return 0;
                case 10:
                    erVar.vKc = aVar3.Avy.ry();
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
                        erVar.vKd.add(com_tencent_mm_protocal_c_bdo);
                    }
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdp();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        erVar.vKe.add(com_tencent_mm_protocal_c_bdo);
                    }
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
                        erVar.vKf = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 14:
                    erVar.vKg = aVar3.Avy.ry();
                    return 0;
                case 15:
                    erVar.vKh = aVar3.Avy.ry();
                    return 0;
                case 16:
                    erVar.vHe = aVar3.Avy.rz();
                    return 0;
                case 17:
                    erVar.vKi = aVar3.Avy.ry();
                    return 0;
                case 18:
                    erVar.vKj = aVar3.Avy.rz();
                    return 0;
                case 19:
                    erVar.vKk = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
