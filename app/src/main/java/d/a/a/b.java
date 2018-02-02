package d.a.a;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class b extends a {
    public int Avf;
    public int Avg;
    public int Avh;
    public d Avi;
    public String Avj;
    public String vZA;
    public String wbs;
    public LinkedList<f> wbt = new LinkedList();
    public int wbu;
    public a wbv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.wbt);
            aVar.fU(2, this.Avf);
            if (this.vZA != null) {
                aVar.g(3, this.vZA);
            }
            aVar.fU(4, this.wbu);
            if (this.wbv != null) {
                aVar.fW(5, this.wbv.bke());
                this.wbv.a(aVar);
            }
            if (this.wbs != null) {
                aVar.g(6, this.wbs);
            }
            aVar.fU(7, this.Avg);
            aVar.fU(8, this.Avh);
            if (this.Avi != null) {
                aVar.fW(9, this.Avi.bke());
                this.Avi.a(aVar);
            }
            if (this.Avj != null) {
                aVar.g(10, this.Avj);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.c(1, 8, this.wbt) + 0) + e.a.a.a.fR(2, this.Avf);
            if (this.vZA != null) {
                r0 += e.a.a.b.b.a.h(3, this.vZA);
            }
            r0 += e.a.a.a.fR(4, this.wbu);
            if (this.wbv != null) {
                r0 += e.a.a.a.fT(5, this.wbv.bke());
            }
            if (this.wbs != null) {
                r0 += e.a.a.b.b.a.h(6, this.wbs);
            }
            r0 = (r0 + e.a.a.a.fR(7, this.Avg)) + e.a.a.a.fR(8, this.Avh);
            if (this.Avi != null) {
                r0 += e.a.a.a.fT(9, this.Avi.bke());
            }
            if (this.Avj != null) {
                return r0 + e.a.a.b.b.a.h(10, this.Avj);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wbt.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a fVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fVar = new f();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fVar.a(aVar4, fVar, a.a(aVar4))) {
                        }
                        bVar.wbt.add(fVar);
                    }
                    return 0;
                case 2:
                    bVar.Avf = aVar3.Avy.ry();
                    return 0;
                case 3:
                    bVar.vZA = aVar3.Avy.readString();
                    return 0;
                case 4:
                    bVar.wbu = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fVar = new a();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fVar.a(aVar4, fVar, a.a(aVar4))) {
                        }
                        bVar.wbv = fVar;
                    }
                    return 0;
                case 6:
                    bVar.wbs = aVar3.Avy.readString();
                    return 0;
                case 7:
                    bVar.Avg = aVar3.Avy.ry();
                    return 0;
                case 8:
                    bVar.Avh = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fVar = new d();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fVar.a(aVar4, fVar, a.a(aVar4))) {
                        }
                        bVar.Avi = fVar;
                    }
                    return 0;
                case 10:
                    bVar.Avj = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
