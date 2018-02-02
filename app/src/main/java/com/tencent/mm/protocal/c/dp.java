package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class dp extends a {
    public String fon;
    public String nfp;
    public String vIN;
    public String vIO;
    public dq vIP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIP == null) {
                throw new b("Not all required fields were included: ArtisIcon");
            }
            if (this.nfp != null) {
                aVar.g(1, this.nfp);
            }
            if (this.fon != null) {
                aVar.g(2, this.fon);
            }
            if (this.vIN != null) {
                aVar.g(3, this.vIN);
            }
            if (this.vIO != null) {
                aVar.g(4, this.vIO);
            }
            if (this.vIP == null) {
                return 0;
            }
            aVar.fW(5, this.vIP.bke());
            this.vIP.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.nfp != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfp) + 0;
            } else {
                r0 = 0;
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
            }
            if (this.vIN != null) {
                r0 += e.a.a.b.b.a.h(3, this.vIN);
            }
            if (this.vIO != null) {
                r0 += e.a.a.b.b.a.h(4, this.vIO);
            }
            if (this.vIP != null) {
                r0 += e.a.a.a.fT(5, this.vIP.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vIP != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ArtisIcon");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dp dpVar = (dp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dpVar.nfp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    dpVar.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    dpVar.vIN = aVar3.Avy.readString();
                    return 0;
                case 4:
                    dpVar.vIO = aVar3.Avy.readString();
                    return 0;
                case 5:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a dqVar = new dq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dqVar.a(aVar4, dqVar, a.a(aVar4))) {
                        }
                        dpVar.vIP = dqVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
