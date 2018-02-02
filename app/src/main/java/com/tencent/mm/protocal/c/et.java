package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class et extends a {
    public String fAf;
    public String sLg;
    public String sLi;
    public String sLj;
    public String sLk;
    public eu vKA;
    public String vKl;
    public String vKm;
    public String vKn;
    public String vKo;
    public String vKp;
    public String vKq;
    public String vKr;
    public String vKs;
    public String vKt;
    public long vKu;
    public int vKv;
    public String vKw;
    public String vKx;
    public String vKy;
    public String vKz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vKl != null) {
                aVar.g(1, this.vKl);
            }
            if (this.vKm != null) {
                aVar.g(2, this.vKm);
            }
            if (this.vKn != null) {
                aVar.g(3, this.vKn);
            }
            if (this.vKo != null) {
                aVar.g(4, this.vKo);
            }
            if (this.vKp != null) {
                aVar.g(5, this.vKp);
            }
            if (this.vKq != null) {
                aVar.g(6, this.vKq);
            }
            if (this.vKr != null) {
                aVar.g(7, this.vKr);
            }
            if (this.vKs != null) {
                aVar.g(8, this.vKs);
            }
            if (this.fAf != null) {
                aVar.g(9, this.fAf);
            }
            if (this.vKt != null) {
                aVar.g(10, this.vKt);
            }
            if (this.sLi != null) {
                aVar.g(11, this.sLi);
            }
            if (this.sLk != null) {
                aVar.g(12, this.sLk);
            }
            if (this.sLj != null) {
                aVar.g(13, this.sLj);
            }
            aVar.S(14, this.vKu);
            aVar.fU(15, this.vKv);
            if (this.vKw != null) {
                aVar.g(16, this.vKw);
            }
            if (this.vKx != null) {
                aVar.g(17, this.vKx);
            }
            if (this.vKy != null) {
                aVar.g(18, this.vKy);
            }
            if (this.sLg != null) {
                aVar.g(19, this.sLg);
            }
            if (this.vKz != null) {
                aVar.g(20, this.vKz);
            }
            if (this.vKA == null) {
                return 0;
            }
            aVar.fW(21, this.vKA.bke());
            this.vKA.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vKl != null) {
                r0 = e.a.a.b.b.a.h(1, this.vKl) + 0;
            } else {
                r0 = 0;
            }
            if (this.vKm != null) {
                r0 += e.a.a.b.b.a.h(2, this.vKm);
            }
            if (this.vKn != null) {
                r0 += e.a.a.b.b.a.h(3, this.vKn);
            }
            if (this.vKo != null) {
                r0 += e.a.a.b.b.a.h(4, this.vKo);
            }
            if (this.vKp != null) {
                r0 += e.a.a.b.b.a.h(5, this.vKp);
            }
            if (this.vKq != null) {
                r0 += e.a.a.b.b.a.h(6, this.vKq);
            }
            if (this.vKr != null) {
                r0 += e.a.a.b.b.a.h(7, this.vKr);
            }
            if (this.vKs != null) {
                r0 += e.a.a.b.b.a.h(8, this.vKs);
            }
            if (this.fAf != null) {
                r0 += e.a.a.b.b.a.h(9, this.fAf);
            }
            if (this.vKt != null) {
                r0 += e.a.a.b.b.a.h(10, this.vKt);
            }
            if (this.sLi != null) {
                r0 += e.a.a.b.b.a.h(11, this.sLi);
            }
            if (this.sLk != null) {
                r0 += e.a.a.b.b.a.h(12, this.sLk);
            }
            if (this.sLj != null) {
                r0 += e.a.a.b.b.a.h(13, this.sLj);
            }
            r0 = (r0 + e.a.a.a.R(14, this.vKu)) + e.a.a.a.fR(15, this.vKv);
            if (this.vKw != null) {
                r0 += e.a.a.b.b.a.h(16, this.vKw);
            }
            if (this.vKx != null) {
                r0 += e.a.a.b.b.a.h(17, this.vKx);
            }
            if (this.vKy != null) {
                r0 += e.a.a.b.b.a.h(18, this.vKy);
            }
            if (this.sLg != null) {
                r0 += e.a.a.b.b.a.h(19, this.sLg);
            }
            if (this.vKz != null) {
                r0 += e.a.a.b.b.a.h(20, this.vKz);
            }
            if (this.vKA != null) {
                r0 += e.a.a.a.fT(21, this.vKA.bke());
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
            et etVar = (et) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    etVar.vKl = aVar3.Avy.readString();
                    return 0;
                case 2:
                    etVar.vKm = aVar3.Avy.readString();
                    return 0;
                case 3:
                    etVar.vKn = aVar3.Avy.readString();
                    return 0;
                case 4:
                    etVar.vKo = aVar3.Avy.readString();
                    return 0;
                case 5:
                    etVar.vKp = aVar3.Avy.readString();
                    return 0;
                case 6:
                    etVar.vKq = aVar3.Avy.readString();
                    return 0;
                case 7:
                    etVar.vKr = aVar3.Avy.readString();
                    return 0;
                case 8:
                    etVar.vKs = aVar3.Avy.readString();
                    return 0;
                case 9:
                    etVar.fAf = aVar3.Avy.readString();
                    return 0;
                case 10:
                    etVar.vKt = aVar3.Avy.readString();
                    return 0;
                case 11:
                    etVar.sLi = aVar3.Avy.readString();
                    return 0;
                case 12:
                    etVar.sLk = aVar3.Avy.readString();
                    return 0;
                case 13:
                    etVar.sLj = aVar3.Avy.readString();
                    return 0;
                case 14:
                    etVar.vKu = aVar3.Avy.rz();
                    return 0;
                case 15:
                    etVar.vKv = aVar3.Avy.ry();
                    return 0;
                case 16:
                    etVar.vKw = aVar3.Avy.readString();
                    return 0;
                case 17:
                    etVar.vKx = aVar3.Avy.readString();
                    return 0;
                case 18:
                    etVar.vKy = aVar3.Avy.readString();
                    return 0;
                case 19:
                    etVar.sLg = aVar3.Avy.readString();
                    return 0;
                case 20:
                    etVar.vKz = aVar3.Avy.readString();
                    return 0;
                case 21:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a euVar = new eu();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = euVar.a(aVar4, euVar, a.a(aVar4))) {
                        }
                        etVar.vKA = euVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
