package d.a.a;

import com.tencent.mm.bq.a;

public final class e extends a {
    public String wDr;
    public String wDs;
    public int wDt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wDr != null) {
                aVar.g(1, this.wDr);
            }
            if (this.wDs != null) {
                aVar.g(2, this.wDs);
            }
            aVar.fU(3, this.wDt);
            return 0;
        } else if (i == 1) {
            if (this.wDr != null) {
                r0 = e.a.a.b.b.a.h(1, this.wDr) + 0;
            } else {
                r0 = 0;
            }
            if (this.wDs != null) {
                r0 += e.a.a.b.b.a.h(2, this.wDs);
            }
            return r0 + e.a.a.a.fR(3, this.wDt);
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
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.wDr = aVar3.Avy.readString();
                    return 0;
                case 2:
                    eVar.wDs = aVar3.Avy.readString();
                    return 0;
                case 3:
                    eVar.wDt = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
