package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class alg extends bcv {
    public String vYi;
    public String wsv;
    public LinkedList<String> wsw = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vYi == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.wsv == null) {
                throw new b("Not all required fields were included: bizchat_name");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.vYi != null) {
                    aVar.g(2, this.vYi);
                }
                if (this.wsv != null) {
                    aVar.g(3, this.wsv);
                }
                aVar.d(4, 1, this.wsw);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vYi != null) {
                r0 += e.a.a.b.b.a.h(2, this.vYi);
            }
            if (this.wsv != null) {
                r0 += e.a.a.b.b.a.h(3, this.wsv);
            }
            return r0 + e.a.a.a.c(4, 1, this.wsw);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wsw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vYi == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.wsv != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bizchat_name");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            alg com_tencent_mm_protocal_c_alg = (alg) objArr[1];
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
                        com_tencent_mm_protocal_c_alg.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alg.vYi = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alg.wsv = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alg.wsw.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
