package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ake extends a {
    public String pHq;
    public int state;
    public String title;
    public String vPj;
    public String wrp;
    public long wrq;
    public String wrr;
    public String wrs;
    public String wrt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPj != null) {
                aVar.g(1, this.vPj);
            }
            aVar.fU(2, this.state);
            if (this.title != null) {
                aVar.g(3, this.title);
            }
            if (this.wrp != null) {
                aVar.g(4, this.wrp);
            }
            aVar.S(5, this.wrq);
            if (this.wrr != null) {
                aVar.g(6, this.wrr);
            }
            if (this.pHq != null) {
                aVar.g(7, this.pHq);
            }
            if (this.wrs != null) {
                aVar.g(8, this.wrs);
            }
            if (this.wrt == null) {
                return 0;
            }
            aVar.g(9, this.wrt);
            return 0;
        } else if (i == 1) {
            if (this.vPj != null) {
                r0 = e.a.a.b.b.a.h(1, this.vPj) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.state);
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(3, this.title);
            }
            if (this.wrp != null) {
                r0 += e.a.a.b.b.a.h(4, this.wrp);
            }
            r0 += e.a.a.a.R(5, this.wrq);
            if (this.wrr != null) {
                r0 += e.a.a.b.b.a.h(6, this.wrr);
            }
            if (this.pHq != null) {
                r0 += e.a.a.b.b.a.h(7, this.pHq);
            }
            if (this.wrs != null) {
                r0 += e.a.a.b.b.a.h(8, this.wrs);
            }
            if (this.wrt != null) {
                r0 += e.a.a.b.b.a.h(9, this.wrt);
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
            ake com_tencent_mm_protocal_c_ake = (ake) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ake.vPj = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ake.state = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ake.title = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ake.wrp = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ake.wrq = aVar3.Avy.rz();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ake.wrr = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ake.pHq = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ake.wrs = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ake.wrt = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
