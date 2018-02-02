package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public class cbv extends a {
    public String ksU;
    public String nfT;
    public String ngC;
    public String ngo;
    public String niZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ngo == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.niZ == null) {
                throw new b("Not all required fields were included: AppName");
            } else if (this.ksU == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.nfT == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else {
                if (this.ngo != null) {
                    aVar.g(1, this.ngo);
                }
                if (this.niZ != null) {
                    aVar.g(2, this.niZ);
                }
                if (this.ksU != null) {
                    aVar.g(3, this.ksU);
                }
                if (this.nfT != null) {
                    aVar.g(4, this.nfT);
                }
                if (this.ngC == null) {
                    return 0;
                }
                aVar.g(5, this.ngC);
                return 0;
            }
        } else if (i == 1) {
            if (this.ngo != null) {
                r0 = e.a.a.b.b.a.h(1, this.ngo) + 0;
            } else {
                r0 = 0;
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(2, this.niZ);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(3, this.ksU);
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfT);
            }
            if (this.ngC != null) {
                r0 += e.a.a.b.b.a.h(5, this.ngC);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ngo == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.niZ == null) {
                throw new b("Not all required fields were included: AppName");
            } else if (this.ksU == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.nfT != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: IconUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbv com_tencent_mm_protocal_c_cbv = (cbv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_cbv.ngo = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_cbv.niZ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_cbv.ksU = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_cbv.nfT = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_cbv.ngC = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
