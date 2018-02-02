package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aw extends a {
    public String ngs;
    public LinkedList<String> nhs = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ngs == null) {
                throw new b("Not all required fields were included: Detail");
            }
            if (this.ngs != null) {
                aVar.g(2, this.ngs);
            }
            aVar.d(3, 1, this.nhs);
            return 0;
        } else if (i == 1) {
            if (this.ngs != null) {
                r0 = e.a.a.b.b.a.h(2, this.ngs) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.c(3, 1, this.nhs);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.nhs.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ngs != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Detail");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aw awVar = (aw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    awVar.ngs = aVar3.Avy.readString();
                    return 0;
                case 3:
                    awVar.nhs.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
