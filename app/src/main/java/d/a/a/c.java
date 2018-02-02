package d.a.a;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class c extends a {
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
            if (this.wme != null) {
                aVar.g(4, this.wme);
            }
            if (this.url != null) {
                aVar.g(5, this.url);
            }
            if (this.Ave == null) {
                return 0;
            }
            aVar.fW(6, this.Ave.bke());
            this.Ave.a(aVar);
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
            if (this.wme != null) {
                r0 += e.a.a.b.b.a.h(4, this.wme);
            }
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(5, this.url);
            }
            if (this.Ave != null) {
                r0 += e.a.a.a.fT(6, this.Ave.bke());
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cVar.Avb = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cVar.Avc = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cVar.Avd = aVar3.Avy.ry();
                    return 0;
                case 4:
                    cVar.wme = aVar3.Avy.readString();
                    return 0;
                case 5:
                    cVar.url = aVar3.Avy.readString();
                    return 0;
                case 6:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        cVar.Ave = eVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
