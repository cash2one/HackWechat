package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class kg extends a {
    public String code;
    public int status;
    public int vQX;
    public int vQY;
    public LinkedList<kt> vQZ = new LinkedList();
    public LinkedList<kt> vRa = new LinkedList();
    public LinkedList<kt> vRb = new LinkedList();
    public LinkedList<String> vRc = new LinkedList();
    public int vRd;
    public int vRe;
    public LinkedList<oq> vRf = new LinkedList();
    public long vRg;
    public int vRh;
    public String vRi;
    public oq vRj;
    public LinkedList<av> vRk = new LinkedList();
    public oq vRl;
    public oq vRm;
    public oq vRn;
    public ra vRo;
    public String vRp;
    public oq vRq;
    public String vRr;
    public oq vRs;
    public boolean vRt;
    public boolean vRu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.status);
            aVar.fU(2, this.vQX);
            aVar.fU(3, this.vQY);
            aVar.d(4, 8, this.vQZ);
            aVar.d(5, 8, this.vRa);
            aVar.d(6, 8, this.vRb);
            aVar.d(7, 1, this.vRc);
            aVar.fU(8, this.vRd);
            if (this.code != null) {
                aVar.g(9, this.code);
            }
            aVar.fU(10, this.vRe);
            aVar.d(11, 8, this.vRf);
            aVar.S(12, this.vRg);
            aVar.fU(13, this.vRh);
            if (this.vRi != null) {
                aVar.g(14, this.vRi);
            }
            if (this.vRj != null) {
                aVar.fW(15, this.vRj.bke());
                this.vRj.a(aVar);
            }
            aVar.d(16, 8, this.vRk);
            if (this.vRl != null) {
                aVar.fW(17, this.vRl.bke());
                this.vRl.a(aVar);
            }
            if (this.vRm != null) {
                aVar.fW(18, this.vRm.bke());
                this.vRm.a(aVar);
            }
            if (this.vRn != null) {
                aVar.fW(19, this.vRn.bke());
                this.vRn.a(aVar);
            }
            if (this.vRo != null) {
                aVar.fW(20, this.vRo.bke());
                this.vRo.a(aVar);
            }
            if (this.vRp != null) {
                aVar.g(21, this.vRp);
            }
            if (this.vRq != null) {
                aVar.fW(22, this.vRq.bke());
                this.vRq.a(aVar);
            }
            if (this.vRr != null) {
                aVar.g(23, this.vRr);
            }
            if (this.vRs != null) {
                aVar.fW(24, this.vRs.bke());
                this.vRs.a(aVar);
            }
            aVar.al(25, this.vRt);
            aVar.al(26, this.vRu);
            return 0;
        } else if (i == 1) {
            r0 = (((((((e.a.a.a.fR(1, this.status) + 0) + e.a.a.a.fR(2, this.vQX)) + e.a.a.a.fR(3, this.vQY)) + e.a.a.a.c(4, 8, this.vQZ)) + e.a.a.a.c(5, 8, this.vRa)) + e.a.a.a.c(6, 8, this.vRb)) + e.a.a.a.c(7, 1, this.vRc)) + e.a.a.a.fR(8, this.vRd);
            if (this.code != null) {
                r0 += e.a.a.b.b.a.h(9, this.code);
            }
            r0 = (((r0 + e.a.a.a.fR(10, this.vRe)) + e.a.a.a.c(11, 8, this.vRf)) + e.a.a.a.R(12, this.vRg)) + e.a.a.a.fR(13, this.vRh);
            if (this.vRi != null) {
                r0 += e.a.a.b.b.a.h(14, this.vRi);
            }
            if (this.vRj != null) {
                r0 += e.a.a.a.fT(15, this.vRj.bke());
            }
            r0 += e.a.a.a.c(16, 8, this.vRk);
            if (this.vRl != null) {
                r0 += e.a.a.a.fT(17, this.vRl.bke());
            }
            if (this.vRm != null) {
                r0 += e.a.a.a.fT(18, this.vRm.bke());
            }
            if (this.vRn != null) {
                r0 += e.a.a.a.fT(19, this.vRn.bke());
            }
            if (this.vRo != null) {
                r0 += e.a.a.a.fT(20, this.vRo.bke());
            }
            if (this.vRp != null) {
                r0 += e.a.a.b.b.a.h(21, this.vRp);
            }
            if (this.vRq != null) {
                r0 += e.a.a.a.fT(22, this.vRq.bke());
            }
            if (this.vRr != null) {
                r0 += e.a.a.b.b.a.h(23, this.vRr);
            }
            if (this.vRs != null) {
                r0 += e.a.a.a.fT(24, this.vRs.bke());
            }
            return (r0 + (e.a.a.b.b.a.dX(25) + 1)) + (e.a.a.b.b.a.dX(26) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vQZ.clear();
            this.vRa.clear();
            this.vRb.clear();
            this.vRc.clear();
            this.vRf.clear();
            this.vRk.clear();
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
            kg kgVar = (kg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a ktVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    kgVar.status = aVar3.Avy.ry();
                    return 0;
                case 2:
                    kgVar.vQX = aVar3.Avy.ry();
                    return 0;
                case 3:
                    kgVar.vQY = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ktVar = new kt();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kgVar.vQZ.add(ktVar);
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ktVar = new kt();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kgVar.vRa.add(ktVar);
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ktVar = new kt();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kgVar.vRb.add(ktVar);
                    }
                    return 0;
                case 7:
                    kgVar.vRc.add(aVar3.Avy.readString());
                    return 0;
                case 8:
                    kgVar.vRd = aVar3.Avy.ry();
                    return 0;
                case 9:
                    kgVar.code = aVar3.Avy.readString();
                    return 0;
                case 10:
                    kgVar.vRe = aVar3.Avy.ry();
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ktVar = new oq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kgVar.vRf.add(ktVar);
                    }
                    return 0;
                case 12:
                    kgVar.vRg = aVar3.Avy.rz();
                    return 0;
                case 13:
                    kgVar.vRh = aVar3.Avy.ry();
                    return 0;
                case 14:
                    kgVar.vRi = aVar3.Avy.readString();
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ktVar = new oq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kgVar.vRj = ktVar;
                    }
                    return 0;
                case 16:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ktVar = new av();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kgVar.vRk.add(ktVar);
                    }
                    return 0;
                case 17:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ktVar = new oq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kgVar.vRl = ktVar;
                    }
                    return 0;
                case 18:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ktVar = new oq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kgVar.vRm = ktVar;
                    }
                    return 0;
                case 19:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ktVar = new oq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kgVar.vRn = ktVar;
                    }
                    return 0;
                case 20:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ktVar = new ra();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kgVar.vRo = ktVar;
                    }
                    return 0;
                case 21:
                    kgVar.vRp = aVar3.Avy.readString();
                    return 0;
                case 22:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ktVar = new oq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kgVar.vRq = ktVar;
                    }
                    return 0;
                case 23:
                    kgVar.vRr = aVar3.Avy.readString();
                    return 0;
                case 24:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        ktVar = new oq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ktVar.a(aVar4, ktVar, a.a(aVar4))) {
                        }
                        kgVar.vRs = ktVar;
                    }
                    return 0;
                case 25:
                    kgVar.vRt = aVar3.cJC();
                    return 0;
                case 26:
                    kgVar.vRu = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
