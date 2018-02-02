package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ala extends a {
    public int fom;
    public int wsc;
    public int wsd;
    public int wse;
    public int wsf;
    public int wsg;
    public int wsh;
    public int wsi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wsc);
            aVar.fU(2, this.fom);
            aVar.fU(3, this.wsd);
            aVar.fU(4, this.wse);
            aVar.fU(5, this.wsf);
            aVar.fU(6, this.wsg);
            aVar.fU(7, this.wsh);
            aVar.fU(8, this.wsi);
            return 0;
        } else if (i == 1) {
            return (((((((e.a.a.a.fR(1, this.wsc) + 0) + e.a.a.a.fR(2, this.fom)) + e.a.a.a.fR(3, this.wsd)) + e.a.a.a.fR(4, this.wse)) + e.a.a.a.fR(5, this.wsf)) + e.a.a.a.fR(6, this.wsg)) + e.a.a.a.fR(7, this.wsh)) + e.a.a.a.fR(8, this.wsi);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                ala com_tencent_mm_protocal_c_ala = (ala) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_ala.wsc = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_ala.fom = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_ala.wsd = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_ala.wse = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_ala.wsf = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_ala.wsg = aVar3.Avy.ry();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_ala.wsh = aVar3.Avy.ry();
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_ala.wsi = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
