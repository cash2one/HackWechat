package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class aka extends a {
    public fc wrd;
    public jt wre;
    public aqx wrf;
    public bmc wrg;
    public bed wrh;
    public on wri;
    public vw wrj;
    public wm wrk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wrd != null) {
                aVar.fW(1, this.wrd.bke());
                this.wrd.a(aVar);
            }
            if (this.wre != null) {
                aVar.fW(2, this.wre.bke());
                this.wre.a(aVar);
            }
            if (this.wrf != null) {
                aVar.fW(3, this.wrf.bke());
                this.wrf.a(aVar);
            }
            if (this.wrg != null) {
                aVar.fW(4, this.wrg.bke());
                this.wrg.a(aVar);
            }
            if (this.wrh != null) {
                aVar.fW(6, this.wrh.bke());
                this.wrh.a(aVar);
            }
            if (this.wri != null) {
                aVar.fW(7, this.wri.bke());
                this.wri.a(aVar);
            }
            if (this.wrj != null) {
                aVar.fW(8, this.wrj.bke());
                this.wrj.a(aVar);
            }
            if (this.wrk == null) {
                return 0;
            }
            aVar.fW(9, this.wrk.bke());
            this.wrk.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wrd != null) {
                r0 = e.a.a.a.fT(1, this.wrd.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wre != null) {
                r0 += e.a.a.a.fT(2, this.wre.bke());
            }
            if (this.wrf != null) {
                r0 += e.a.a.a.fT(3, this.wrf.bke());
            }
            if (this.wrg != null) {
                r0 += e.a.a.a.fT(4, this.wrg.bke());
            }
            if (this.wrh != null) {
                r0 += e.a.a.a.fT(6, this.wrh.bke());
            }
            if (this.wri != null) {
                r0 += e.a.a.a.fT(7, this.wri.bke());
            }
            if (this.wrj != null) {
                r0 += e.a.a.a.fT(8, this.wrj.bke());
            }
            if (this.wrk != null) {
                r0 += e.a.a.a.fT(9, this.wrk.bke());
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
            aka com_tencent_mm_protocal_c_aka = (aka) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a fcVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fcVar = new fc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fcVar.a(aVar4, fcVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aka.wrd = fcVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fcVar = new jt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fcVar.a(aVar4, fcVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aka.wre = fcVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fcVar = new aqx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fcVar.a(aVar4, fcVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aka.wrf = fcVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fcVar = new bmc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fcVar.a(aVar4, fcVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aka.wrg = fcVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fcVar = new bed();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fcVar.a(aVar4, fcVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aka.wrh = fcVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fcVar = new on();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fcVar.a(aVar4, fcVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aka.wri = fcVar;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fcVar = new vw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fcVar.a(aVar4, fcVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aka.wrj = fcVar;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fcVar = new wm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fcVar.a(aVar4, fcVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aka.wrk = fcVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
