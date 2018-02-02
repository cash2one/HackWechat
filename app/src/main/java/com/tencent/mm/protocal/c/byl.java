package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class byl extends a {
    public String fon;
    public String nje;
    public String wYG;
    public long wYH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYG == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nje == null) {
                throw new b("Not all required fields were included: Content");
            } else {
                if (this.wYG != null) {
                    aVar.g(1, this.wYG);
                }
                if (this.fon != null) {
                    aVar.g(2, this.fon);
                }
                if (this.nje != null) {
                    aVar.g(3, this.nje);
                }
                aVar.S(4, this.wYH);
                return 0;
            }
        } else if (i == 1) {
            if (this.wYG != null) {
                r0 = e.a.a.b.b.a.h(1, this.wYG) + 0;
            } else {
                r0 = 0;
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
            }
            if (this.nje != null) {
                r0 += e.a.a.b.b.a.h(3, this.nje);
            }
            return r0 + e.a.a.a.R(4, this.wYH);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wYG == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nje != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byl com_tencent_mm_protocal_c_byl = (byl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_byl.wYG = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_byl.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_byl.nje = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_byl.wYH = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
