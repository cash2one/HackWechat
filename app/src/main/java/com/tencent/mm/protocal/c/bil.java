package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bil extends a {
    public String liO;
    public String odw;
    public String odx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.odw != null) {
                aVar.g(1, this.odw);
            }
            if (this.odx != null) {
                aVar.g(2, this.odx);
            }
            if (this.liO == null) {
                return 0;
            }
            aVar.g(3, this.liO);
            return 0;
        } else if (i == 1) {
            if (this.odw != null) {
                r0 = e.a.a.b.b.a.h(1, this.odw) + 0;
            } else {
                r0 = 0;
            }
            if (this.odx != null) {
                r0 += e.a.a.b.b.a.h(2, this.odx);
            }
            if (this.liO != null) {
                r0 += e.a.a.b.b.a.h(3, this.liO);
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
            bil com_tencent_mm_protocal_c_bil = (bil) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bil.odw = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bil.odx = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bil.liO = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
