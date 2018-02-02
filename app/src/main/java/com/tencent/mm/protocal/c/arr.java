package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class arr extends a {
    public rd wzy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wzy == null) {
                throw new b("Not all required fields were included: DisturbSetting");
            } else if (this.wzy == null) {
                return 0;
            } else {
                aVar.fW(1, this.wzy.bke());
                this.wzy.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wzy != null) {
                r0 = e.a.a.a.fT(1, this.wzy.bke()) + 0;
            } else {
                r0 = 0;
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wzy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DisturbSetting");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arr com_tencent_mm_protocal_c_arr = (arr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a rdVar = new rd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = rdVar.a(aVar4, rdVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arr.wzy = rdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
