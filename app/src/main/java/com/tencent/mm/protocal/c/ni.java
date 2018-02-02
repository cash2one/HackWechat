package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ni extends bdf {
    public int lOr;
    public String lOs;
    public String token;
    public awg vWo;
    public String vzI;

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
            aVar.fU(2, this.lOr);
            if (this.lOs != null) {
                aVar.g(3, this.lOs);
            }
            if (this.token != null) {
                aVar.g(4, this.token);
            }
            if (this.vWo != null) {
                aVar.fW(5, this.vWo.bke());
                this.vWo.a(aVar);
            }
            if (this.vzI == null) {
                return 0;
            }
            aVar.g(6, this.vzI);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.lOr);
            if (this.lOs != null) {
                r0 += e.a.a.b.b.a.h(3, this.lOs);
            }
            if (this.token != null) {
                r0 += e.a.a.b.b.a.h(4, this.token);
            }
            if (this.vWo != null) {
                r0 += e.a.a.a.fT(5, this.vWo.bke());
            }
            if (this.vzI != null) {
                r0 += e.a.a.b.b.a.h(6, this.vzI);
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
            ni niVar = (ni) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        niVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    niVar.lOr = aVar3.Avy.ry();
                    return 0;
                case 3:
                    niVar.lOs = aVar3.Avy.readString();
                    return 0;
                case 4:
                    niVar.token = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new awg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        niVar.vWo = feVar;
                    }
                    return 0;
                case 6:
                    niVar.vzI = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
