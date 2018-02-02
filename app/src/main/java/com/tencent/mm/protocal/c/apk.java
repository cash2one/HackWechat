package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class apk extends a {
    public String type;
    public int vUI;
    public String wws;
    public String wwt;
    public String wwu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wws != null) {
                aVar.g(1, this.wws);
            }
            if (this.wwt != null) {
                aVar.g(2, this.wwt);
            }
            if (this.type != null) {
                aVar.g(3, this.type);
            }
            aVar.fU(4, this.vUI);
            if (this.wwu == null) {
                return 0;
            }
            aVar.g(5, this.wwu);
            return 0;
        } else if (i == 1) {
            if (this.wws != null) {
                r0 = e.a.a.b.b.a.h(1, this.wws) + 0;
            } else {
                r0 = 0;
            }
            if (this.wwt != null) {
                r0 += e.a.a.b.b.a.h(2, this.wwt);
            }
            if (this.type != null) {
                r0 += e.a.a.b.b.a.h(3, this.type);
            }
            r0 += e.a.a.a.fR(4, this.vUI);
            if (this.wwu != null) {
                r0 += e.a.a.b.b.a.h(5, this.wwu);
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
            apk com_tencent_mm_protocal_c_apk = (apk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_apk.wws = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apk.wwt = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apk.type = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apk.vUI = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_apk.wwu = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
