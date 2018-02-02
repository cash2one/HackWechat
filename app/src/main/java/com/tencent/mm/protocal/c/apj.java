package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;

public final class apj extends a {
    public String fFm;
    public String vUF;
    public int vYZ;
    public String wvZ;
    public String wwa;
    public String wwb;
    public String wwc;
    public int wwd;
    public int wwe;
    public String wwf;
    public int wwg;
    public int wwh;
    public String wwi;
    public int wwj;
    public int wwk;
    public String wwl;
    public int wwm;
    public int wwn;
    public String wwo;
    public String wwp;
    public String wwq;
    public String wwr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fFm != null) {
                aVar.g(1, this.fFm);
            }
            if (this.wvZ != null) {
                aVar.g(20, this.wvZ);
            }
            if (this.wwa != null) {
                aVar.g(21, this.wwa);
            }
            if (this.wwb != null) {
                aVar.g(22, this.wwb);
            }
            if (this.wwc != null) {
                aVar.g(23, this.wwc);
            }
            if (this.vUF != null) {
                aVar.g(31, this.vUF);
            }
            aVar.fU(32, this.wwd);
            aVar.fU(33, this.wwe);
            if (this.wwf != null) {
                aVar.g(34, this.wwf);
            }
            aVar.fU(35, this.wwg);
            aVar.fU(36, this.wwh);
            if (this.wwi != null) {
                aVar.g(37, this.wwi);
            }
            aVar.fU(38, this.wwj);
            aVar.fU(39, this.wwk);
            if (this.wwl != null) {
                aVar.g(41, this.wwl);
            }
            aVar.fU(200, this.wwm);
            aVar.fU(201, this.wwn);
            aVar.fU(202, this.vYZ);
            if (this.wwo != null) {
                aVar.g(203, this.wwo);
            }
            if (this.wwp != null) {
                aVar.g(d.CTRL_INDEX, this.wwp);
            }
            if (this.wwq != null) {
                aVar.g(g.CTRL_INDEX, this.wwq);
            }
            if (this.wwr == null) {
                return 0;
            }
            aVar.g(b.CTRL_INDEX, this.wwr);
            return 0;
        } else if (i == 1) {
            if (this.fFm != null) {
                r0 = e.a.a.b.b.a.h(1, this.fFm) + 0;
            } else {
                r0 = 0;
            }
            if (this.wvZ != null) {
                r0 += e.a.a.b.b.a.h(20, this.wvZ);
            }
            if (this.wwa != null) {
                r0 += e.a.a.b.b.a.h(21, this.wwa);
            }
            if (this.wwb != null) {
                r0 += e.a.a.b.b.a.h(22, this.wwb);
            }
            if (this.wwc != null) {
                r0 += e.a.a.b.b.a.h(23, this.wwc);
            }
            if (this.vUF != null) {
                r0 += e.a.a.b.b.a.h(31, this.vUF);
            }
            r0 = (r0 + e.a.a.a.fR(32, this.wwd)) + e.a.a.a.fR(33, this.wwe);
            if (this.wwf != null) {
                r0 += e.a.a.b.b.a.h(34, this.wwf);
            }
            r0 = (r0 + e.a.a.a.fR(35, this.wwg)) + e.a.a.a.fR(36, this.wwh);
            if (this.wwi != null) {
                r0 += e.a.a.b.b.a.h(37, this.wwi);
            }
            r0 = (r0 + e.a.a.a.fR(38, this.wwj)) + e.a.a.a.fR(39, this.wwk);
            if (this.wwl != null) {
                r0 += e.a.a.b.b.a.h(41, this.wwl);
            }
            r0 = ((r0 + e.a.a.a.fR(200, this.wwm)) + e.a.a.a.fR(201, this.wwn)) + e.a.a.a.fR(202, this.vYZ);
            if (this.wwo != null) {
                r0 += e.a.a.b.b.a.h(203, this.wwo);
            }
            if (this.wwp != null) {
                r0 += e.a.a.b.b.a.h(d.CTRL_INDEX, this.wwp);
            }
            if (this.wwq != null) {
                r0 += e.a.a.b.b.a.h(g.CTRL_INDEX, this.wwq);
            }
            if (this.wwr != null) {
                r0 += e.a.a.b.b.a.h(b.CTRL_INDEX, this.wwr);
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
            apj com_tencent_mm_protocal_c_apj = (apj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_apj.fFm = aVar3.Avy.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_apj.wvZ = aVar3.Avy.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_apj.wwa = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_apj.wwb = aVar3.Avy.readString();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_apj.wwc = aVar3.Avy.readString();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_apj.vUF = aVar3.Avy.readString();
                    return 0;
                case 32:
                    com_tencent_mm_protocal_c_apj.wwd = aVar3.Avy.ry();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_apj.wwe = aVar3.Avy.ry();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_apj.wwf = aVar3.Avy.readString();
                    return 0;
                case 35:
                    com_tencent_mm_protocal_c_apj.wwg = aVar3.Avy.ry();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_apj.wwh = aVar3.Avy.ry();
                    return 0;
                case 37:
                    com_tencent_mm_protocal_c_apj.wwi = aVar3.Avy.readString();
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_apj.wwj = aVar3.Avy.ry();
                    return 0;
                case 39:
                    com_tencent_mm_protocal_c_apj.wwk = aVar3.Avy.ry();
                    return 0;
                case 41:
                    com_tencent_mm_protocal_c_apj.wwl = aVar3.Avy.readString();
                    return 0;
                case 200:
                    com_tencent_mm_protocal_c_apj.wwm = aVar3.Avy.ry();
                    return 0;
                case 201:
                    com_tencent_mm_protocal_c_apj.wwn = aVar3.Avy.ry();
                    return 0;
                case 202:
                    com_tencent_mm_protocal_c_apj.vYZ = aVar3.Avy.ry();
                    return 0;
                case 203:
                    com_tencent_mm_protocal_c_apj.wwo = aVar3.Avy.readString();
                    return 0;
                case d.CTRL_INDEX /*204*/:
                    com_tencent_mm_protocal_c_apj.wwp = aVar3.Avy.readString();
                    return 0;
                case g.CTRL_INDEX /*205*/:
                    com_tencent_mm_protocal_c_apj.wwq = aVar3.Avy.readString();
                    return 0;
                case b.CTRL_INDEX /*206*/:
                    com_tencent_mm_protocal_c_apj.wwr = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
