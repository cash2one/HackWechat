package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class tr extends a {
    public String wbI;
    public LinkedList<String> wbJ = new LinkedList();
    public boolean wbK;
    public String wbx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wbx == null) {
                throw new b("Not all required fields were included: LoginUrl");
            }
            if (this.wbx != null) {
                aVar.g(1, this.wbx);
            }
            if (this.wbI != null) {
                aVar.g(2, this.wbI);
            }
            aVar.d(3, 1, this.wbJ);
            aVar.al(4, this.wbK);
            return 0;
        } else if (i == 1) {
            if (this.wbx != null) {
                r0 = e.a.a.b.b.a.h(1, this.wbx) + 0;
            } else {
                r0 = 0;
            }
            if (this.wbI != null) {
                r0 += e.a.a.b.b.a.h(2, this.wbI);
            }
            return (r0 + e.a.a.a.c(3, 1, this.wbJ)) + (e.a.a.b.b.a.dX(4) + 1);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wbJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wbx != null) {
                return 0;
            }
            throw new b("Not all required fields were included: LoginUrl");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            tr trVar = (tr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    trVar.wbx = aVar3.Avy.readString();
                    return 0;
                case 2:
                    trVar.wbI = aVar3.Avy.readString();
                    return 0;
                case 3:
                    trVar.wbJ.add(aVar3.Avy.readString());
                    return 0;
                case 4:
                    trVar.wbK = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
