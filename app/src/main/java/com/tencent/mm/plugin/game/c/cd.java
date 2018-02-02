package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class cd extends a {
    public String desc;
    public String haH;
    public String niU;
    public String niV;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.haH != null) {
                aVar.g(2, this.haH);
            }
            if (this.niU != null) {
                aVar.g(3, this.niU);
            }
            if (this.desc != null) {
                aVar.g(4, this.desc);
            }
            if (this.niV == null) {
                return 0;
            }
            aVar.g(5, this.niV);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.haH != null) {
                r0 += e.a.a.b.b.a.h(2, this.haH);
            }
            if (this.niU != null) {
                r0 += e.a.a.b.b.a.h(3, this.niU);
            }
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(4, this.desc);
            }
            if (this.niV != null) {
                r0 += e.a.a.b.b.a.h(5, this.niV);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            cd cdVar = (cd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdVar.title = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cdVar.haH = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cdVar.niU = aVar3.Avy.readString();
                    return 0;
                case 4:
                    cdVar.desc = aVar3.Avy.readString();
                    return 0;
                case 5:
                    cdVar.niV = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
