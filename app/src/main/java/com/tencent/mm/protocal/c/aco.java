package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aco extends a {
    public String oZC;
    public String path;
    public String peR;
    public String title;
    public int type;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.oZC != null) {
                aVar.g(1, this.oZC);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            aVar.fU(3, this.type);
            if (this.peR != null) {
                aVar.g(4, this.peR);
            }
            if (this.username != null) {
                aVar.g(5, this.username);
            }
            if (this.path == null) {
                return 0;
            }
            aVar.g(6, this.path);
            return 0;
        } else if (i == 1) {
            if (this.oZC != null) {
                r0 = e.a.a.b.b.a.h(1, this.oZC) + 0;
            } else {
                r0 = 0;
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(2, this.title);
            }
            r0 += e.a.a.a.fR(3, this.type);
            if (this.peR != null) {
                r0 += e.a.a.b.b.a.h(4, this.peR);
            }
            if (this.username != null) {
                r0 += e.a.a.b.b.a.h(5, this.username);
            }
            if (this.path != null) {
                r0 += e.a.a.b.b.a.h(6, this.path);
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
            aco com_tencent_mm_protocal_c_aco = (aco) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aco.oZC = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aco.title = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aco.type = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aco.peR = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aco.username = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aco.path = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
