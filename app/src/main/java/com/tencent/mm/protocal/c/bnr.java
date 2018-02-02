package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bnr extends a {
    public String aAM;
    public String pKH;
    public String value;
    public LinkedList<String> wQz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.aAM == null) {
                throw new b("Not all required fields were included: key");
            } else if (this.value == null) {
                throw new b("Not all required fields were included: value");
            } else {
                if (this.aAM != null) {
                    aVar.g(1, this.aAM);
                }
                if (this.value != null) {
                    aVar.g(2, this.value);
                }
                if (this.pKH != null) {
                    aVar.g(3, this.pKH);
                }
                aVar.d(4, 1, this.wQz);
                return 0;
            }
        } else if (i == 1) {
            if (this.aAM != null) {
                r0 = e.a.a.b.b.a.h(1, this.aAM) + 0;
            } else {
                r0 = 0;
            }
            if (this.value != null) {
                r0 += e.a.a.b.b.a.h(2, this.value);
            }
            if (this.pKH != null) {
                r0 += e.a.a.b.b.a.h(3, this.pKH);
            }
            return r0 + e.a.a.a.c(4, 1, this.wQz);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wQz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.aAM == null) {
                throw new b("Not all required fields were included: key");
            } else if (this.value != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: value");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnr com_tencent_mm_protocal_c_bnr = (bnr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bnr.aAM = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bnr.value = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bnr.pKH = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bnr.wQz.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
