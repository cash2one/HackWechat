package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class bze extends a {
    public int rYW;
    public String vPA;
    public String vZU;
    public String wYG;
    public String weY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYG == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.weY == null) {
                throw new b("Not all required fields were included: Text");
            } else if (this.vZU == null) {
                throw new b("Not all required fields were included: MD5");
            } else if (this.vPA == null) {
                throw new b("Not all required fields were included: ProductId");
            } else {
                if (this.wYG != null) {
                    aVar.g(1, this.wYG);
                }
                if (this.weY != null) {
                    aVar.g(2, this.weY);
                }
                if (this.vZU != null) {
                    aVar.g(3, this.vZU);
                }
                if (this.vPA != null) {
                    aVar.g(4, this.vPA);
                }
                aVar.fU(5, this.rYW);
                return 0;
            }
        } else if (i == 1) {
            if (this.wYG != null) {
                r0 = e.a.a.b.b.a.h(1, this.wYG) + 0;
            } else {
                r0 = 0;
            }
            if (this.weY != null) {
                r0 += e.a.a.b.b.a.h(2, this.weY);
            }
            if (this.vZU != null) {
                r0 += e.a.a.b.b.a.h(3, this.vZU);
            }
            if (this.vPA != null) {
                r0 += e.a.a.b.b.a.h(4, this.vPA);
            }
            return r0 + e.a.a.a.fR(5, this.rYW);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wYG == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.weY == null) {
                throw new b("Not all required fields were included: Text");
            } else if (this.vZU == null) {
                throw new b("Not all required fields were included: MD5");
            } else if (this.vPA != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ProductId");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bze com_tencent_mm_protocal_c_bze = (bze) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bze.wYG = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bze.weY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bze.vZU = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bze.vPA = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bze.rYW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
