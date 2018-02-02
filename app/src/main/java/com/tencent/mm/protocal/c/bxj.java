package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bxj extends bcv {
    public int ktN;
    public int vNW;
    public String vPs;
    public int wFj;
    public int wYd;
    public int wYe = 2;
    public double wYf;
    public double wYg;
    public String wYh;
    public String wYi;
    public String wYj;
    public String wYk;
    public int wYl;
    public String wYm;
    public String wkq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wkq != null) {
                aVar.g(2, this.wkq);
            }
            aVar.fU(3, this.vNW);
            aVar.fU(4, this.wYd);
            if (this.vPs != null) {
                aVar.g(5, this.vPs);
            }
            aVar.fU(6, this.wYe);
            aVar.b(7, this.wYf);
            aVar.b(8, this.wYg);
            aVar.fU(9, this.ktN);
            aVar.fU(10, this.wFj);
            if (this.wYh != null) {
                aVar.g(99, this.wYh);
            }
            if (this.wYi != null) {
                aVar.g(100, this.wYi);
            }
            if (this.wYj != null) {
                aVar.g(101, this.wYj);
            }
            if (this.wYk != null) {
                aVar.g(102, this.wYk);
            }
            aVar.fU(103, this.wYl);
            if (this.wYm == null) {
                return 0;
            }
            aVar.g(104, this.wYm);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wkq != null) {
                r0 += e.a.a.b.b.a.h(2, this.wkq);
            }
            r0 = (r0 + e.a.a.a.fR(3, this.vNW)) + e.a.a.a.fR(4, this.wYd);
            if (this.vPs != null) {
                r0 += e.a.a.b.b.a.h(5, this.vPs);
            }
            r0 = ((((r0 + e.a.a.a.fR(6, this.wYe)) + (e.a.a.b.b.a.dX(7) + 8)) + (e.a.a.b.b.a.dX(8) + 8)) + e.a.a.a.fR(9, this.ktN)) + e.a.a.a.fR(10, this.wFj);
            if (this.wYh != null) {
                r0 += e.a.a.b.b.a.h(99, this.wYh);
            }
            if (this.wYi != null) {
                r0 += e.a.a.b.b.a.h(100, this.wYi);
            }
            if (this.wYj != null) {
                r0 += e.a.a.b.b.a.h(101, this.wYj);
            }
            if (this.wYk != null) {
                r0 += e.a.a.b.b.a.h(102, this.wYk);
            }
            r0 += e.a.a.a.fR(103, this.wYl);
            if (this.wYm != null) {
                r0 += e.a.a.b.b.a.h(104, this.wYm);
            }
            return r0;
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
            bxj com_tencent_mm_protocal_c_bxj = (bxj) objArr[1];
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
                        com_tencent_mm_protocal_c_bxj.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bxj.wkq = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bxj.vNW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bxj.wYd = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bxj.vPs = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bxj.wYe = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bxj.wYf = aVar3.Avy.readDouble();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bxj.wYg = aVar3.Avy.readDouble();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bxj.ktN = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bxj.wFj = aVar3.Avy.ry();
                    return 0;
                case 99:
                    com_tencent_mm_protocal_c_bxj.wYh = aVar3.Avy.readString();
                    return 0;
                case 100:
                    com_tencent_mm_protocal_c_bxj.wYi = aVar3.Avy.readString();
                    return 0;
                case 101:
                    com_tencent_mm_protocal_c_bxj.wYj = aVar3.Avy.readString();
                    return 0;
                case 102:
                    com_tencent_mm_protocal_c_bxj.wYk = aVar3.Avy.readString();
                    return 0;
                case 103:
                    com_tencent_mm_protocal_c_bxj.wYl = aVar3.Avy.ry();
                    return 0;
                case 104:
                    com_tencent_mm_protocal_c_bxj.wYm = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
