package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bme extends a {
    public String hdo;
    public int hdp;
    public String hdq;
    public String hdr;
    public String hds;
    public String hdt;
    public String hdu;
    public String hdv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.hdo != null) {
                aVar.g(1, this.hdo);
            }
            aVar.fU(2, this.hdp);
            if (this.hdr != null) {
                aVar.g(3, this.hdr);
            }
            if (this.hds != null) {
                aVar.g(4, this.hds);
            }
            if (this.hdq != null) {
                aVar.g(5, this.hdq);
            }
            if (this.hdt != null) {
                aVar.g(6, this.hdt);
            }
            if (this.hdu != null) {
                aVar.g(7, this.hdu);
            }
            if (this.hdv == null) {
                return 0;
            }
            aVar.g(8, this.hdv);
            return 0;
        } else if (i == 1) {
            if (this.hdo != null) {
                r0 = e.a.a.b.b.a.h(1, this.hdo) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.hdp);
            if (this.hdr != null) {
                r0 += e.a.a.b.b.a.h(3, this.hdr);
            }
            if (this.hds != null) {
                r0 += e.a.a.b.b.a.h(4, this.hds);
            }
            if (this.hdq != null) {
                r0 += e.a.a.b.b.a.h(5, this.hdq);
            }
            if (this.hdt != null) {
                r0 += e.a.a.b.b.a.h(6, this.hdt);
            }
            if (this.hdu != null) {
                r0 += e.a.a.b.b.a.h(7, this.hdu);
            }
            if (this.hdv != null) {
                r0 += e.a.a.b.b.a.h(8, this.hdv);
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
            bme com_tencent_mm_protocal_c_bme = (bme) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bme.hdo = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bme.hdp = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bme.hdr = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bme.hds = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bme.hdq = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bme.hdt = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bme.hdu = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bme.hdv = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
