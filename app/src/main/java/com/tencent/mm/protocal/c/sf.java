package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class sf extends a {
    public int fgt;
    public String fon;
    public String nfT;
    public String nfe;
    public String vIR;
    public se wag;
    public String wai;
    public String waj;
    public int wak;
    public String wal;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wag == null) {
                throw new b("Not all required fields were included: BannerImg");
            }
            if (this.wag != null) {
                aVar.fW(1, this.wag.bke());
                this.wag.a(aVar);
            }
            if (this.fon != null) {
                aVar.g(2, this.fon);
            }
            if (this.wai != null) {
                aVar.g(3, this.wai);
            }
            aVar.fU(4, this.fgt);
            if (this.waj != null) {
                aVar.g(5, this.waj);
            }
            aVar.fU(6, this.wak);
            if (this.nfT != null) {
                aVar.g(7, this.nfT);
            }
            if (this.nfe != null) {
                aVar.g(8, this.nfe);
            }
            if (this.vIR != null) {
                aVar.g(9, this.vIR);
            }
            if (this.wal == null) {
                return 0;
            }
            aVar.g(10, this.wal);
            return 0;
        } else if (i == 1) {
            if (this.wag != null) {
                r0 = e.a.a.a.fT(1, this.wag.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
            }
            if (this.wai != null) {
                r0 += e.a.a.b.b.a.h(3, this.wai);
            }
            r0 += e.a.a.a.fR(4, this.fgt);
            if (this.waj != null) {
                r0 += e.a.a.b.b.a.h(5, this.waj);
            }
            r0 += e.a.a.a.fR(6, this.wak);
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(7, this.nfT);
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(8, this.nfe);
            }
            if (this.vIR != null) {
                r0 += e.a.a.b.b.a.h(9, this.vIR);
            }
            if (this.wal != null) {
                r0 += e.a.a.b.b.a.h(10, this.wal);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wag != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BannerImg");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sf sfVar = (sf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a seVar = new se();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = seVar.a(aVar4, seVar, a.a(aVar4))) {
                        }
                        sfVar.wag = seVar;
                    }
                    return 0;
                case 2:
                    sfVar.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    sfVar.wai = aVar3.Avy.readString();
                    return 0;
                case 4:
                    sfVar.fgt = aVar3.Avy.ry();
                    return 0;
                case 5:
                    sfVar.waj = aVar3.Avy.readString();
                    return 0;
                case 6:
                    sfVar.wak = aVar3.Avy.ry();
                    return 0;
                case 7:
                    sfVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 8:
                    sfVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 9:
                    sfVar.vIR = aVar3.Avy.readString();
                    return 0;
                case 10:
                    sfVar.wal = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
