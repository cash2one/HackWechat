package d.a.a;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bq.a {
    public String Avb;
    public String Avc;
    public int Avd;
    public e Ave;
    public String url;
    public String wme;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Avb != null) {
                aVar.g(1, this.Avb);
            }
            if (this.Avc != null) {
                aVar.g(2, this.Avc);
            }
            aVar.fU(3, this.Avd);
            if (this.url != null) {
                aVar.g(4, this.url);
            }
            if (this.Ave != null) {
                aVar.fW(5, this.Ave.bke());
                this.Ave.a(aVar);
            }
            if (this.wme == null) {
                return 0;
            }
            aVar.g(6, this.wme);
            return 0;
        } else if (i == 1) {
            if (this.Avb != null) {
                r0 = e.a.a.b.b.a.h(1, this.Avb) + 0;
            } else {
                r0 = 0;
            }
            if (this.Avc != null) {
                r0 += e.a.a.b.b.a.h(2, this.Avc);
            }
            r0 += e.a.a.a.fR(3, this.Avd);
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(4, this.url);
            }
            if (this.Ave != null) {
                r0 += e.a.a.a.fT(5, this.Ave.bke());
            }
            if (this.wme != null) {
                r0 += e.a.a.b.b.a.h(6, this.wme);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aVar4.Avb = aVar3.Avy.readString();
                    return 0;
                case 2:
                    aVar4.Avc = aVar3.Avy.readString();
                    return 0;
                case 3:
                    aVar4.Avd = aVar3.Avy.ry();
                    return 0;
                case 4:
                    aVar4.url = aVar3.Avy.readString();
                    return 0;
                case 5:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a eVar = new e();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar5, eVar, com.tencent.mm.bq.a.a(aVar5))) {
                        }
                        aVar4.Ave = eVar;
                    }
                    return 0;
                case 6:
                    aVar4.wme = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
