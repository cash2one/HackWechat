package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class zp extends bcv {
    public String data;
    public int pK;
    public String vYi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vYi == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.data == null) {
                throw new b("Not all required fields were included: data");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.vYi != null) {
                    aVar.g(2, this.vYi);
                }
                aVar.fU(3, this.pK);
                if (this.data == null) {
                    return 0;
                }
                aVar.g(4, this.data);
                return 0;
            }
        } else if (i == 1) {
            int fT;
            if (this.wIV != null) {
                fT = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                fT = 0;
            }
            if (this.vYi != null) {
                fT += e.a.a.b.b.a.h(2, this.vYi);
            }
            fT += e.a.a.a.fR(3, this.pK);
            if (this.data != null) {
                fT += e.a.a.b.b.a.h(4, this.data);
            }
            return fT;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (int a = bcv.a(aVar2); a > 0; a = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cJE();
                }
            }
            if (this.vYi == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (r0 != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zp zpVar = (zp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        zpVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    zpVar.vYi = aVar3.Avy.readString();
                    return 0;
                case 3:
                    zpVar.pK = aVar3.Avy.ry();
                    return 0;
                case 4:
                    zpVar.data = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
