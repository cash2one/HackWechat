package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class asc extends a {
    public axa wzt;
    public String wzx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wzx == null) {
                throw new b("Not all required fields were included: ContactUsername");
            } else if (this.wzt == null) {
                throw new b("Not all required fields were included: PhoneNumListInfo");
            } else {
                if (this.wzx != null) {
                    aVar.g(1, this.wzx);
                }
                if (this.wzt == null) {
                    return 0;
                }
                aVar.fW(2, this.wzt.bke());
                this.wzt.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wzx != null) {
                r0 = e.a.a.b.b.a.h(1, this.wzx) + 0;
            } else {
                r0 = 0;
            }
            if (this.wzt != null) {
                r0 += e.a.a.a.fT(2, this.wzt.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wzx == null) {
                throw new b("Not all required fields were included: ContactUsername");
            } else if (this.wzt != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: PhoneNumListInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asc com_tencent_mm_protocal_c_asc = (asc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_asc.wzx = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_axa = new axa();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_axa.a(aVar4, com_tencent_mm_protocal_c_axa, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asc.wzt = com_tencent_mm_protocal_c_axa;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
