package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bcy extends a {
    public int vQa;
    public int vgO;
    public int wFj;
    public bdb wJb;
    public bda wJc;
    public int wJd;
    public String wJe;
    public int wJf;
    public int wJg;
    public int wJh;
    public int wlp;
    public int wrD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wJe == null) {
                throw new b("Not all required fields were included: SampleId");
            }
            aVar.fU(1, this.wFj);
            if (this.wJb != null) {
                aVar.fW(2, this.wJb.bke());
                this.wJb.a(aVar);
            }
            if (this.wJc != null) {
                aVar.fW(3, this.wJc.bke());
                this.wJc.a(aVar);
            }
            aVar.fU(4, this.wlp);
            aVar.fU(5, this.wJd);
            if (this.wJe != null) {
                aVar.g(6, this.wJe);
            }
            aVar.fU(7, this.vQa);
            aVar.fU(8, this.wJf);
            aVar.fU(9, this.vgO);
            aVar.fU(10, this.wJg);
            aVar.fU(11, this.wJh);
            aVar.fU(12, this.wrD);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wFj) + 0;
            if (this.wJb != null) {
                r0 += e.a.a.a.fT(2, this.wJb.bke());
            }
            if (this.wJc != null) {
                r0 += e.a.a.a.fT(3, this.wJc.bke());
            }
            r0 = (r0 + e.a.a.a.fR(4, this.wlp)) + e.a.a.a.fR(5, this.wJd);
            if (this.wJe != null) {
                r0 += e.a.a.b.b.a.h(6, this.wJe);
            }
            return (((((r0 + e.a.a.a.fR(7, this.vQa)) + e.a.a.a.fR(8, this.wJf)) + e.a.a.a.fR(9, this.vgO)) + e.a.a.a.fR(10, this.wJg)) + e.a.a.a.fR(11, this.wJh)) + e.a.a.a.fR(12, this.wrD);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SampleId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bcy com_tencent_mm_protocal_c_bcy = (bcy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdb;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bcy.wFj = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdb = new bdb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdb.a(aVar4, com_tencent_mm_protocal_c_bdb, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcy.wJb = com_tencent_mm_protocal_c_bdb;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdb = new bda();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdb.a(aVar4, com_tencent_mm_protocal_c_bdb, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcy.wJc = com_tencent_mm_protocal_c_bdb;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bcy.wlp = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bcy.wJd = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bcy.wJe = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bcy.vQa = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bcy.wJf = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bcy.vgO = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bcy.wJg = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bcy.wJh = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bcy.wrD = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
