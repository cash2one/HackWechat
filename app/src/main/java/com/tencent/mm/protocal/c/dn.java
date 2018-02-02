package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class dn extends a {
    public String frP;
    public String hIF;
    public String vIL;
    public LinkedList<String> vIM = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIL == null) {
                throw new b("Not all required fields were included: roomname");
            }
            if (this.vIL != null) {
                aVar.g(1, this.vIL);
            }
            if (this.frP != null) {
                aVar.g(2, this.frP);
            }
            if (this.hIF != null) {
                aVar.g(3, this.hIF);
            }
            aVar.d(4, 1, this.vIM);
            return 0;
        } else if (i == 1) {
            if (this.vIL != null) {
                r0 = e.a.a.b.b.a.h(1, this.vIL) + 0;
            } else {
                r0 = 0;
            }
            if (this.frP != null) {
                r0 += e.a.a.b.b.a.h(2, this.frP);
            }
            if (this.hIF != null) {
                r0 += e.a.a.b.b.a.h(3, this.hIF);
            }
            return r0 + e.a.a.a.c(4, 1, this.vIM);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vIM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vIL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: roomname");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dn dnVar = (dn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dnVar.vIL = aVar3.Avy.readString();
                    return 0;
                case 2:
                    dnVar.frP = aVar3.Avy.readString();
                    return 0;
                case 3:
                    dnVar.hIF = aVar3.Avy.readString();
                    return 0;
                case 4:
                    dnVar.vIM.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
