package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class cj extends a {
    public String fon;
    public String nje;
    public LinkedList<String> njf = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.nje != null) {
                aVar.g(2, this.nje);
            }
            aVar.d(3, 1, this.njf);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.nje != null) {
                r0 += e.a.a.b.b.a.h(2, this.nje);
            }
            return r0 + e.a.a.a.c(3, 1, this.njf);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.njf.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            cj cjVar = (cj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cjVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cjVar.nje = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cjVar.njf.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
