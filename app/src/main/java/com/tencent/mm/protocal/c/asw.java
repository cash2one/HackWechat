package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class asw extends a {
    public String path;
    public int type;
    public String username;
    public int vOv;
    public String wAF;
    public String wAG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            if (this.wAF != null) {
                aVar.g(2, this.wAF);
            }
            if (this.wAG != null) {
                aVar.g(3, this.wAG);
            }
            if (this.path != null) {
                aVar.g(4, this.path);
            }
            aVar.fU(5, this.vOv);
            aVar.fU(6, this.type);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                r0 = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            if (this.wAF != null) {
                r0 += e.a.a.b.b.a.h(2, this.wAF);
            }
            if (this.wAG != null) {
                r0 += e.a.a.b.b.a.h(3, this.wAG);
            }
            if (this.path != null) {
                r0 += e.a.a.b.b.a.h(4, this.path);
            }
            return (r0 + e.a.a.a.fR(5, this.vOv)) + e.a.a.a.fR(6, this.type);
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
            asw com_tencent_mm_protocal_c_asw = (asw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_asw.username = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asw.wAF = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asw.wAG = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asw.path = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asw.vOv = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_asw.type = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
