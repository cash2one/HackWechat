package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class bns extends a {
    public String fel;
    public String fpb;
    public int jIM;
    public String nBo;
    public String nBq;
    public String nBr;
    public String nBs;
    public String nwc;
    public String title;
    public int versionCode;
    public String wQA;
    public String wQB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nBq == null) {
                throw new b("Not all required fields were included: patchId");
            } else if (this.nBr == null) {
                throw new b("Not all required fields were included: newApkMd5");
            } else if (this.nBs == null) {
                throw new b("Not all required fields were included: oldApkMd5");
            } else if (this.title == null) {
                throw new b("Not all required fields were included: title");
            } else if (this.wQB == null) {
                throw new b("Not all required fields were included: okBtn");
            } else if (this.nwc == null) {
                throw new b("Not all required fields were included: cancelBtn");
            } else if (this.fel == null) {
                throw new b("Not all required fields were included: patchMd5");
            } else {
                if (this.nBq != null) {
                    aVar.g(1, this.nBq);
                }
                if (this.wQA != null) {
                    aVar.g(2, this.wQA);
                }
                aVar.fU(3, this.jIM);
                if (this.nBr != null) {
                    aVar.g(4, this.nBr);
                }
                if (this.nBs != null) {
                    aVar.g(5, this.nBs);
                }
                if (this.title != null) {
                    aVar.g(6, this.title);
                }
                if (this.fpb != null) {
                    aVar.g(7, this.fpb);
                }
                if (this.wQB != null) {
                    aVar.g(8, this.wQB);
                }
                if (this.nwc != null) {
                    aVar.g(9, this.nwc);
                }
                if (this.nBo != null) {
                    aVar.g(10, this.nBo);
                }
                if (this.fel != null) {
                    aVar.g(11, this.fel);
                }
                aVar.fU(12, this.versionCode);
                return 0;
            }
        } else if (i == 1) {
            if (this.nBq != null) {
                r0 = e.a.a.b.b.a.h(1, this.nBq) + 0;
            } else {
                r0 = 0;
            }
            if (this.wQA != null) {
                r0 += e.a.a.b.b.a.h(2, this.wQA);
            }
            r0 += e.a.a.a.fR(3, this.jIM);
            if (this.nBr != null) {
                r0 += e.a.a.b.b.a.h(4, this.nBr);
            }
            if (this.nBs != null) {
                r0 += e.a.a.b.b.a.h(5, this.nBs);
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(6, this.title);
            }
            if (this.fpb != null) {
                r0 += e.a.a.b.b.a.h(7, this.fpb);
            }
            if (this.wQB != null) {
                r0 += e.a.a.b.b.a.h(8, this.wQB);
            }
            if (this.nwc != null) {
                r0 += e.a.a.b.b.a.h(9, this.nwc);
            }
            if (this.nBo != null) {
                r0 += e.a.a.b.b.a.h(10, this.nBo);
            }
            if (this.fel != null) {
                r0 += e.a.a.b.b.a.h(11, this.fel);
            }
            return r0 + e.a.a.a.fR(12, this.versionCode);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nBq == null) {
                throw new b("Not all required fields were included: patchId");
            } else if (this.nBr == null) {
                throw new b("Not all required fields were included: newApkMd5");
            } else if (this.nBs == null) {
                throw new b("Not all required fields were included: oldApkMd5");
            } else if (this.title == null) {
                throw new b("Not all required fields were included: title");
            } else if (this.wQB == null) {
                throw new b("Not all required fields were included: okBtn");
            } else if (this.nwc == null) {
                throw new b("Not all required fields were included: cancelBtn");
            } else if (this.fel != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: patchMd5");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bns com_tencent_mm_protocal_c_bns = (bns) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bns.nBq = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bns.wQA = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bns.jIM = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bns.nBr = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bns.nBs = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bns.title = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bns.fpb = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bns.wQB = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bns.nwc = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bns.nBo = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bns.fel = aVar3.Avy.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bns.versionCode = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
