package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adg extends bdf {
    public int wgv;
    public String wgw;
    public String wgx;
    public int wgy;
    public String wgz;
    public String wlE;
    public String wlF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            if (this.wlE != null) {
                aVar.g(2, this.wlE);
            }
            aVar.fU(3, this.wgv);
            if (this.wgw != null) {
                aVar.g(4, this.wgw);
            }
            if (this.wgx != null) {
                aVar.g(5, this.wgx);
            }
            aVar.fU(6, this.wgy);
            if (this.wgz != null) {
                aVar.g(7, this.wgz);
            }
            if (this.wlF == null) {
                return 0;
            }
            aVar.g(8, this.wlF);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wlE != null) {
                r0 += e.a.a.b.b.a.h(2, this.wlE);
            }
            r0 += e.a.a.a.fR(3, this.wgv);
            if (this.wgw != null) {
                r0 += e.a.a.b.b.a.h(4, this.wgw);
            }
            if (this.wgx != null) {
                r0 += e.a.a.b.b.a.h(5, this.wgx);
            }
            r0 += e.a.a.a.fR(6, this.wgy);
            if (this.wgz != null) {
                r0 += e.a.a.b.b.a.h(7, this.wgz);
            }
            if (this.wlF != null) {
                r0 += e.a.a.b.b.a.h(8, this.wlF);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adg com_tencent_mm_protocal_c_adg = (adg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adg.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adg.wlE = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adg.wgv = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adg.wgw = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_adg.wgx = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_adg.wgy = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_adg.wgz = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_adg.wlF = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
