package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aqm extends bcv {
    public int ngq;
    public String nhE;
    public String pbP;
    public int vQq;
    public int vQr;
    public int wmj;
    public String wxi;
    public String wxj;
    public String wxk;
    public int wxl;
    public bdn wxm;
    public int wxn;
    public int wxo;
    public int wxp;
    public int wxq;
    public bdn wxr;
    public int wxs;
    public int wxt;
    public int wxu;
    public int wxv;
    public int wxw;
    public String wxx;
    public String wxy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wxm == null) {
                throw new b("Not all required fields were included: DataBuffer");
            } else if (this.wxr == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.wxi != null) {
                    aVar.g(2, this.wxi);
                }
                if (this.wxj != null) {
                    aVar.g(3, this.wxj);
                }
                if (this.wxk != null) {
                    aVar.g(4, this.wxk);
                }
                aVar.fU(5, this.ngq);
                aVar.fU(6, this.wxl);
                if (this.wxm != null) {
                    aVar.fW(7, this.wxm.bke());
                    this.wxm.a(aVar);
                }
                aVar.fU(8, this.wxn);
                aVar.fU(9, this.wxo);
                aVar.fU(10, this.wxp);
                aVar.fU(11, this.wxq);
                if (this.wxr != null) {
                    aVar.fW(12, this.wxr.bke());
                    this.wxr.a(aVar);
                }
                aVar.fU(13, this.wxs);
                aVar.fU(14, this.wxt);
                aVar.fU(15, this.wxu);
                aVar.fU(16, this.wxv);
                aVar.fU(17, this.wmj);
                aVar.fU(18, this.wxw);
                if (this.nhE != null) {
                    aVar.g(19, this.nhE);
                }
                if (this.pbP != null) {
                    aVar.g(20, this.pbP);
                }
                aVar.fU(21, this.vQr);
                aVar.fU(22, this.vQq);
                if (this.wxx != null) {
                    aVar.g(23, this.wxx);
                }
                if (this.wxy == null) {
                    return 0;
                }
                aVar.g(24, this.wxy);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wxi != null) {
                r0 += e.a.a.b.b.a.h(2, this.wxi);
            }
            if (this.wxj != null) {
                r0 += e.a.a.b.b.a.h(3, this.wxj);
            }
            if (this.wxk != null) {
                r0 += e.a.a.b.b.a.h(4, this.wxk);
            }
            r0 = (r0 + e.a.a.a.fR(5, this.ngq)) + e.a.a.a.fR(6, this.wxl);
            if (this.wxm != null) {
                r0 += e.a.a.a.fT(7, this.wxm.bke());
            }
            r0 = (((r0 + e.a.a.a.fR(8, this.wxn)) + e.a.a.a.fR(9, this.wxo)) + e.a.a.a.fR(10, this.wxp)) + e.a.a.a.fR(11, this.wxq);
            if (this.wxr != null) {
                r0 += e.a.a.a.fT(12, this.wxr.bke());
            }
            r0 = (((((r0 + e.a.a.a.fR(13, this.wxs)) + e.a.a.a.fR(14, this.wxt)) + e.a.a.a.fR(15, this.wxu)) + e.a.a.a.fR(16, this.wxv)) + e.a.a.a.fR(17, this.wmj)) + e.a.a.a.fR(18, this.wxw);
            if (this.nhE != null) {
                r0 += e.a.a.b.b.a.h(19, this.nhE);
            }
            if (this.pbP != null) {
                r0 += e.a.a.b.b.a.h(20, this.pbP);
            }
            r0 = (r0 + e.a.a.a.fR(21, this.vQr)) + e.a.a.a.fR(22, this.vQq);
            if (this.wxx != null) {
                r0 += e.a.a.b.b.a.h(23, this.wxx);
            }
            if (this.wxy != null) {
                r0 += e.a.a.b.b.a.h(24, this.wxy);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wxm == null) {
                throw new b("Not all required fields were included: DataBuffer");
            } else if (this.wxr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqm com_tencent_mm_protocal_c_aqm = (aqm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqm.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqm.wxi = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqm.wxj = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqm.wxk = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqm.ngq = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqm.wxl = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqm.wxm = fdVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aqm.wxn = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aqm.wxo = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aqm.wxp = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aqm.wxq = aVar3.Avy.ry();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqm.wxr = fdVar;
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aqm.wxs = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aqm.wxt = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aqm.wxu = aVar3.Avy.ry();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aqm.wxv = aVar3.Avy.ry();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aqm.wmj = aVar3.Avy.ry();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_aqm.wxw = aVar3.Avy.ry();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aqm.nhE = aVar3.Avy.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_aqm.pbP = aVar3.Avy.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aqm.vQr = aVar3.Avy.ry();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_aqm.vQq = aVar3.Avy.ry();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_aqm.wxx = aVar3.Avy.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_aqm.wxy = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
