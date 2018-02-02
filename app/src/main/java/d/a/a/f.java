package d.a.a;

import com.tencent.mm.bq.a;

public final class f extends a {
    public String Avt;
    public String Avu;
    public String Avv;
    public String Avw;
    public String Avx;
    public String peY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.peY != null) {
                aVar.g(1, this.peY);
            }
            if (this.Avt != null) {
                aVar.g(2, this.Avt);
            }
            if (this.Avu != null) {
                aVar.g(3, this.Avu);
            }
            if (this.Avv != null) {
                aVar.g(4, this.Avv);
            }
            if (this.Avw != null) {
                aVar.g(5, this.Avw);
            }
            if (this.Avx == null) {
                return 0;
            }
            aVar.g(6, this.Avx);
            return 0;
        } else if (i == 1) {
            if (this.peY != null) {
                r0 = e.a.a.b.b.a.h(1, this.peY) + 0;
            } else {
                r0 = 0;
            }
            if (this.Avt != null) {
                r0 += e.a.a.b.b.a.h(2, this.Avt);
            }
            if (this.Avu != null) {
                r0 += e.a.a.b.b.a.h(3, this.Avu);
            }
            if (this.Avv != null) {
                r0 += e.a.a.b.b.a.h(4, this.Avv);
            }
            if (this.Avw != null) {
                r0 += e.a.a.b.b.a.h(5, this.Avw);
            }
            if (this.Avx != null) {
                r0 += e.a.a.b.b.a.h(6, this.Avx);
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
            f fVar = (f) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fVar.peY = aVar3.Avy.readString();
                    return 0;
                case 2:
                    fVar.Avt = aVar3.Avy.readString();
                    return 0;
                case 3:
                    fVar.Avu = aVar3.Avy.readString();
                    return 0;
                case 4:
                    fVar.Avv = aVar3.Avy.readString();
                    return 0;
                case 5:
                    fVar.Avw = aVar3.Avy.readString();
                    return 0;
                case 6:
                    fVar.Avx = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
