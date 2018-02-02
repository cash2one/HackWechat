package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bw extends a {
    public int ktm;
    public int ngq;
    public int pbl;
    public int vGW;
    public bdo vGX;
    public bdo vGY;
    public bdo vGZ;
    public int vHa;
    public bdn vHb;
    public String vHc;
    public String vHd;
    public long vHe;
    public int vHf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vGX == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vGY == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.vGZ == null) {
                throw new b("Not all required fields were included: Content");
            } else if (this.vHb == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                aVar.fU(1, this.vGW);
                if (this.vGX != null) {
                    aVar.fW(2, this.vGX.bke());
                    this.vGX.a(aVar);
                }
                if (this.vGY != null) {
                    aVar.fW(3, this.vGY.bke());
                    this.vGY.a(aVar);
                }
                aVar.fU(4, this.ngq);
                if (this.vGZ != null) {
                    aVar.fW(5, this.vGZ.bke());
                    this.vGZ.a(aVar);
                }
                aVar.fU(6, this.ktm);
                aVar.fU(7, this.vHa);
                if (this.vHb != null) {
                    aVar.fW(8, this.vHb.bke());
                    this.vHb.a(aVar);
                }
                aVar.fU(9, this.pbl);
                if (this.vHc != null) {
                    aVar.g(10, this.vHc);
                }
                if (this.vHd != null) {
                    aVar.g(11, this.vHd);
                }
                aVar.S(12, this.vHe);
                aVar.fU(13, this.vHf);
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vGW) + 0;
            if (this.vGX != null) {
                r0 += e.a.a.a.fT(2, this.vGX.bke());
            }
            if (this.vGY != null) {
                r0 += e.a.a.a.fT(3, this.vGY.bke());
            }
            r0 += e.a.a.a.fR(4, this.ngq);
            if (this.vGZ != null) {
                r0 += e.a.a.a.fT(5, this.vGZ.bke());
            }
            r0 = (r0 + e.a.a.a.fR(6, this.ktm)) + e.a.a.a.fR(7, this.vHa);
            if (this.vHb != null) {
                r0 += e.a.a.a.fT(8, this.vHb.bke());
            }
            r0 += e.a.a.a.fR(9, this.pbl);
            if (this.vHc != null) {
                r0 += e.a.a.b.b.a.h(10, this.vHc);
            }
            if (this.vHd != null) {
                r0 += e.a.a.b.b.a.h(11, this.vHd);
            }
            return (r0 + e.a.a.a.R(12, this.vHe)) + e.a.a.a.fR(13, this.vHf);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vGX == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vGY == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.vGZ == null) {
                throw new b("Not all required fields were included: Content");
            } else if (this.vHb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bw bwVar = (bw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bwVar.vGW = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        bwVar.vGX = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        bwVar.vGY = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 4:
                    bwVar.ngq = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        bwVar.vGZ = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 6:
                    bwVar.ktm = aVar3.Avy.ry();
                    return 0;
                case 7:
                    bwVar.vHa = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        bwVar.vHb = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 9:
                    bwVar.pbl = aVar3.Avy.ry();
                    return 0;
                case 10:
                    bwVar.vHc = aVar3.Avy.readString();
                    return 0;
                case 11:
                    bwVar.vHd = aVar3.Avy.readString();
                    return 0;
                case 12:
                    bwVar.vHe = aVar3.Avy.rz();
                    return 0;
                case 13:
                    bwVar.vHf = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
