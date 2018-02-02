package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class r extends a {
    public String ngf;
    public String ngg;
    public String ngh;
    public ej ngi;
    public int ngj;
    public int ngk;
    public String ngl;
    public int ngm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ngf == null) {
                throw new b("Not all required fields were included: DownloadURL");
            }
            if (this.ngf != null) {
                aVar.g(1, this.ngf);
            }
            if (this.ngg != null) {
                aVar.g(2, this.ngg);
            }
            if (this.ngh != null) {
                aVar.g(4, this.ngh);
            }
            if (this.ngi != null) {
                aVar.fW(5, this.ngi.bke());
                this.ngi.a(aVar);
            }
            aVar.fU(6, this.ngj);
            aVar.fU(7, this.ngk);
            if (this.ngl != null) {
                aVar.g(8, this.ngl);
            }
            aVar.fU(9, this.ngm);
            return 0;
        } else if (i == 1) {
            if (this.ngf != null) {
                r0 = e.a.a.b.b.a.h(1, this.ngf) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngg != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngg);
            }
            if (this.ngh != null) {
                r0 += e.a.a.b.b.a.h(4, this.ngh);
            }
            if (this.ngi != null) {
                r0 += e.a.a.a.fT(5, this.ngi.bke());
            }
            r0 = (r0 + e.a.a.a.fR(6, this.ngj)) + e.a.a.a.fR(7, this.ngk);
            if (this.ngl != null) {
                r0 += e.a.a.b.b.a.h(8, this.ngl);
            }
            return r0 + e.a.a.a.fR(9, this.ngm);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ngf != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DownloadURL");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    rVar.ngf = aVar3.Avy.readString();
                    return 0;
                case 2:
                    rVar.ngg = aVar3.Avy.readString();
                    return 0;
                case 4:
                    rVar.ngh = aVar3.Avy.readString();
                    return 0;
                case 5:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a ejVar = new ej();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ejVar.a(aVar4, ejVar, a.a(aVar4))) {
                        }
                        rVar.ngi = ejVar;
                    }
                    return 0;
                case 6:
                    rVar.ngj = aVar3.Avy.ry();
                    return 0;
                case 7:
                    rVar.ngk = aVar3.Avy.ry();
                    return 0;
                case 8:
                    rVar.ngl = aVar3.Avy.readString();
                    return 0;
                case 9:
                    rVar.ngm = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
