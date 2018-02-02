package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class qz extends a {
    public String desc;
    public String peD;
    public String title;
    public String url;
    public LinkedList<String> vZa = new LinkedList();
    public String vZb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            aVar.d(4, 1, this.vZa);
            if (this.peD != null) {
                aVar.g(5, this.peD);
            }
            if (this.vZb == null) {
                return 0;
            }
            aVar.g(6, this.vZb);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(2, this.url);
            }
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(3, this.desc);
            }
            r0 += e.a.a.a.c(4, 1, this.vZa);
            if (this.peD != null) {
                r0 += e.a.a.b.b.a.h(5, this.peD);
            }
            if (this.vZb != null) {
                r0 += e.a.a.b.b.a.h(6, this.vZb);
            }
            return r0;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vZa.clear();
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
            qz qzVar = (qz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qzVar.title = aVar3.Avy.readString();
                    return 0;
                case 2:
                    qzVar.url = aVar3.Avy.readString();
                    return 0;
                case 3:
                    qzVar.desc = aVar3.Avy.readString();
                    return 0;
                case 4:
                    qzVar.vZa.add(aVar3.Avy.readString());
                    return 0;
                case 5:
                    qzVar.peD = aVar3.Avy.readString();
                    return 0;
                case 6:
                    qzVar.vZb = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
