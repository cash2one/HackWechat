package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class sk extends a {
    public int ktM;
    public String nfT;
    public String vIR;
    public int waA;
    public String waB;
    public String waC;
    public String waD;
    public String waE;
    public String waF;
    public int waG;
    public LinkedList<avh> waH = new LinkedList();
    public String waI;
    public String waJ;
    public String waK;
    public sj waL;
    public awy waM;
    public String war;
    public String was;
    public String wat;
    public String wau;
    public int wav;
    public int waw;
    public int wax;
    public LinkedList<bdo> way = new LinkedList();
    public String waz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIR != null) {
                aVar.g(1, this.vIR);
            }
            if (this.nfT != null) {
                aVar.g(2, this.nfT);
            }
            if (this.war != null) {
                aVar.g(3, this.war);
            }
            if (this.was != null) {
                aVar.g(4, this.was);
            }
            if (this.wat != null) {
                aVar.g(5, this.wat);
            }
            if (this.wau != null) {
                aVar.g(6, this.wau);
            }
            aVar.fU(7, this.wav);
            aVar.fU(8, this.waw);
            aVar.fU(9, this.wax);
            aVar.d(10, 8, this.way);
            if (this.waz != null) {
                aVar.g(11, this.waz);
            }
            aVar.fU(12, this.waA);
            if (this.waB != null) {
                aVar.g(13, this.waB);
            }
            if (this.waC != null) {
                aVar.g(14, this.waC);
            }
            if (this.waD != null) {
                aVar.g(15, this.waD);
            }
            if (this.waE != null) {
                aVar.g(16, this.waE);
            }
            if (this.waF != null) {
                aVar.g(17, this.waF);
            }
            aVar.fU(18, this.waG);
            aVar.d(19, 8, this.waH);
            aVar.fU(20, this.ktM);
            if (this.waI != null) {
                aVar.g(21, this.waI);
            }
            if (this.waJ != null) {
                aVar.g(22, this.waJ);
            }
            if (this.waK != null) {
                aVar.g(23, this.waK);
            }
            if (this.waL != null) {
                aVar.fW(24, this.waL.bke());
                this.waL.a(aVar);
            }
            if (this.waM == null) {
                return 0;
            }
            aVar.fW(25, this.waM.bke());
            this.waM.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vIR != null) {
                r0 = e.a.a.b.b.a.h(1, this.vIR) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfT);
            }
            if (this.war != null) {
                r0 += e.a.a.b.b.a.h(3, this.war);
            }
            if (this.was != null) {
                r0 += e.a.a.b.b.a.h(4, this.was);
            }
            if (this.wat != null) {
                r0 += e.a.a.b.b.a.h(5, this.wat);
            }
            if (this.wau != null) {
                r0 += e.a.a.b.b.a.h(6, this.wau);
            }
            r0 = (((r0 + e.a.a.a.fR(7, this.wav)) + e.a.a.a.fR(8, this.waw)) + e.a.a.a.fR(9, this.wax)) + e.a.a.a.c(10, 8, this.way);
            if (this.waz != null) {
                r0 += e.a.a.b.b.a.h(11, this.waz);
            }
            r0 += e.a.a.a.fR(12, this.waA);
            if (this.waB != null) {
                r0 += e.a.a.b.b.a.h(13, this.waB);
            }
            if (this.waC != null) {
                r0 += e.a.a.b.b.a.h(14, this.waC);
            }
            if (this.waD != null) {
                r0 += e.a.a.b.b.a.h(15, this.waD);
            }
            if (this.waE != null) {
                r0 += e.a.a.b.b.a.h(16, this.waE);
            }
            if (this.waF != null) {
                r0 += e.a.a.b.b.a.h(17, this.waF);
            }
            r0 = ((r0 + e.a.a.a.fR(18, this.waG)) + e.a.a.a.c(19, 8, this.waH)) + e.a.a.a.fR(20, this.ktM);
            if (this.waI != null) {
                r0 += e.a.a.b.b.a.h(21, this.waI);
            }
            if (this.waJ != null) {
                r0 += e.a.a.b.b.a.h(22, this.waJ);
            }
            if (this.waK != null) {
                r0 += e.a.a.b.b.a.h(23, this.waK);
            }
            if (this.waL != null) {
                r0 += e.a.a.a.fT(24, this.waL.bke());
            }
            if (this.waM != null) {
                r0 += e.a.a.a.fT(25, this.waM.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.way.clear();
            this.waH.clear();
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
            sk skVar = (sk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    skVar.vIR = aVar3.Avy.readString();
                    return 0;
                case 2:
                    skVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 3:
                    skVar.war = aVar3.Avy.readString();
                    return 0;
                case 4:
                    skVar.was = aVar3.Avy.readString();
                    return 0;
                case 5:
                    skVar.wat = aVar3.Avy.readString();
                    return 0;
                case 6:
                    skVar.wau = aVar3.Avy.readString();
                    return 0;
                case 7:
                    skVar.wav = aVar3.Avy.ry();
                    return 0;
                case 8:
                    skVar.waw = aVar3.Avy.ry();
                    return 0;
                case 9:
                    skVar.wax = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        skVar.way.add(com_tencent_mm_protocal_c_bdo);
                    }
                    return 0;
                case 11:
                    skVar.waz = aVar3.Avy.readString();
                    return 0;
                case 12:
                    skVar.waA = aVar3.Avy.ry();
                    return 0;
                case 13:
                    skVar.waB = aVar3.Avy.readString();
                    return 0;
                case 14:
                    skVar.waC = aVar3.Avy.readString();
                    return 0;
                case 15:
                    skVar.waD = aVar3.Avy.readString();
                    return 0;
                case 16:
                    skVar.waE = aVar3.Avy.readString();
                    return 0;
                case 17:
                    skVar.waF = aVar3.Avy.readString();
                    return 0;
                case 18:
                    skVar.waG = aVar3.Avy.ry();
                    return 0;
                case 19:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new avh();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        skVar.waH.add(com_tencent_mm_protocal_c_bdo);
                    }
                    return 0;
                case 20:
                    skVar.ktM = aVar3.Avy.ry();
                    return 0;
                case 21:
                    skVar.waI = aVar3.Avy.readString();
                    return 0;
                case 22:
                    skVar.waJ = aVar3.Avy.readString();
                    return 0;
                case 23:
                    skVar.waK = aVar3.Avy.readString();
                    return 0;
                case 24:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new sj();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        skVar.waL = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 25:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new awy();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        skVar.waM = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
