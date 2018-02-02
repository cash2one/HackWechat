package d.a.a;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class d extends a {
    public String Avk;
    public String Avl;
    public String Avm;
    public String Avn;
    public String Avo;
    public int Avp;
    public c Avq;
    public b Avr;
    public b Avs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Avk != null) {
                aVar.g(1, this.Avk);
            }
            if (this.Avl != null) {
                aVar.g(2, this.Avl);
            }
            if (this.Avm != null) {
                aVar.g(3, this.Avm);
            }
            if (this.Avn != null) {
                aVar.g(4, this.Avn);
            }
            if (this.Avo != null) {
                aVar.g(5, this.Avo);
            }
            aVar.fU(6, this.Avp);
            if (this.Avq != null) {
                aVar.fW(7, this.Avq.bke());
                this.Avq.a(aVar);
            }
            if (this.Avr != null) {
                aVar.b(8, this.Avr);
            }
            if (this.Avs == null) {
                return 0;
            }
            aVar.b(9, this.Avs);
            return 0;
        } else if (i == 1) {
            if (this.Avk != null) {
                r0 = e.a.a.b.b.a.h(1, this.Avk) + 0;
            } else {
                r0 = 0;
            }
            if (this.Avl != null) {
                r0 += e.a.a.b.b.a.h(2, this.Avl);
            }
            if (this.Avm != null) {
                r0 += e.a.a.b.b.a.h(3, this.Avm);
            }
            if (this.Avn != null) {
                r0 += e.a.a.b.b.a.h(4, this.Avn);
            }
            if (this.Avo != null) {
                r0 += e.a.a.b.b.a.h(5, this.Avo);
            }
            r0 += e.a.a.a.fR(6, this.Avp);
            if (this.Avq != null) {
                r0 += e.a.a.a.fT(7, this.Avq.bke());
            }
            if (this.Avr != null) {
                r0 += e.a.a.a.a(8, this.Avr);
            }
            if (this.Avs != null) {
                r0 += e.a.a.a.a(9, this.Avs);
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
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.Avk = aVar3.Avy.readString();
                    return 0;
                case 2:
                    dVar.Avl = aVar3.Avy.readString();
                    return 0;
                case 3:
                    dVar.Avm = aVar3.Avy.readString();
                    return 0;
                case 4:
                    dVar.Avn = aVar3.Avy.readString();
                    return 0;
                case 5:
                    dVar.Avo = aVar3.Avy.readString();
                    return 0;
                case 6:
                    dVar.Avp = aVar3.Avy.ry();
                    return 0;
                case 7:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a cVar = new c();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        dVar.Avq = cVar;
                    }
                    return 0;
                case 8:
                    dVar.Avr = aVar3.cJD();
                    return 0;
                case 9:
                    dVar.Avs = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
