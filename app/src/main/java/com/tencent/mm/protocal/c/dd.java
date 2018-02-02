package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class dd extends a {
    public String ngo;
    public int vDW;
    public int vIn;
    public int vIo;
    public di vIp;
    public dc vIq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ngo == null) {
                throw new b("Not all required fields were included: AppId");
            }
            aVar.fU(1, this.vDW);
            if (this.ngo != null) {
                aVar.g(2, this.ngo);
            }
            aVar.fU(3, this.vIn);
            aVar.fU(4, this.vIo);
            if (this.vIp != null) {
                aVar.fW(5, this.vIp.bke());
                this.vIp.a(aVar);
            }
            if (this.vIq != null) {
                aVar.fW(6, this.vIq.bke());
                this.vIq.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vDW) + 0;
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            r0 = (r0 + e.a.a.a.fR(3, this.vIn)) + e.a.a.a.fR(4, this.vIo);
            if (this.vIp != null) {
                r0 += e.a.a.a.fT(5, this.vIp.bke());
            }
            if (this.vIq != null) {
                return r0 + e.a.a.a.fT(6, this.vIq.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ngo != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dd ddVar = (dd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a diVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ddVar.vDW = aVar3.Avy.ry();
                    return 0;
                case 2:
                    ddVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ddVar.vIn = aVar3.Avy.ry();
                    return 0;
                case 4:
                    ddVar.vIo = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        diVar = new di();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = diVar.a(aVar4, diVar, a.a(aVar4))) {
                        }
                        ddVar.vIp = diVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        diVar = new dc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = diVar.a(aVar4, diVar, a.a(aVar4))) {
                        }
                        ddVar.vIq = diVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
