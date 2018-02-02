package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bqt extends bcv {
    public String ngo;
    public int ngq;
    public String vFC;
    public String vFD;
    public String vFE;
    public bdo vGX;
    public bdo vGY;
    public String vHc;
    public int vIB;
    public int vIC;
    public int vID;
    public String vQA;
    public int vQB;
    public int vQC;
    public int vQD;
    public int vWK;
    public bdn vXz;
    public String vZL;
    public String vZq;
    public int wKA;
    public int wOp;
    public bdo wSf;
    public String wSg;
    public String wSh;
    public int wSi;
    public int wSj;
    public String wSk;
    public int wSl;
    public int wSm;
    public int wSn;
    public int wac;
    public int wmj;
    public String wrT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wSf == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.vGX == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vGY == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.wSf != null) {
                    aVar.fW(2, this.wSf.bke());
                    this.wSf.a(aVar);
                }
                if (this.vGX != null) {
                    aVar.fW(3, this.vGX.bke());
                    this.vGX.a(aVar);
                }
                if (this.vGY != null) {
                    aVar.fW(4, this.vGY.bke());
                    this.vGY.a(aVar);
                }
                aVar.fU(5, this.vIB);
                aVar.fU(6, this.vIC);
                aVar.fU(7, this.vID);
                if (this.vXz != null) {
                    aVar.fW(8, this.vXz.bke());
                    this.vXz.a(aVar);
                }
                aVar.fU(9, this.ngq);
                if (this.vHc != null) {
                    aVar.g(10, this.vHc);
                }
                aVar.fU(11, this.wmj);
                aVar.fU(12, this.vWK);
                aVar.fU(13, this.wOp);
                if (this.vZq != null) {
                    aVar.g(14, this.vZq);
                }
                if (this.wSg != null) {
                    aVar.g(15, this.wSg);
                }
                if (this.wSh != null) {
                    aVar.g(16, this.wSh);
                }
                if (this.vQA != null) {
                    aVar.g(17, this.vQA);
                }
                aVar.fU(18, this.vQB);
                aVar.fU(19, this.wSi);
                aVar.fU(20, this.wSj);
                if (this.wSk != null) {
                    aVar.g(21, this.wSk);
                }
                aVar.fU(22, this.wSl);
                aVar.fU(23, this.wSm);
                aVar.fU(24, this.wSn);
                if (this.wrT != null) {
                    aVar.g(25, this.wrT);
                }
                aVar.fU(26, this.wac);
                if (this.vZL != null) {
                    aVar.g(27, this.vZL);
                }
                aVar.fU(28, this.vQC);
                aVar.fU(29, this.vQD);
                aVar.fU(30, this.wKA);
                if (this.ngo != null) {
                    aVar.g(31, this.ngo);
                }
                if (this.vFE != null) {
                    aVar.g(32, this.vFE);
                }
                if (this.vFD != null) {
                    aVar.g(33, this.vFD);
                }
                if (this.vFC == null) {
                    return 0;
                }
                aVar.g(34, this.vFC);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wSf != null) {
                r0 += e.a.a.a.fT(2, this.wSf.bke());
            }
            if (this.vGX != null) {
                r0 += e.a.a.a.fT(3, this.vGX.bke());
            }
            if (this.vGY != null) {
                r0 += e.a.a.a.fT(4, this.vGY.bke());
            }
            r0 = ((r0 + e.a.a.a.fR(5, this.vIB)) + e.a.a.a.fR(6, this.vIC)) + e.a.a.a.fR(7, this.vID);
            if (this.vXz != null) {
                r0 += e.a.a.a.fT(8, this.vXz.bke());
            }
            r0 += e.a.a.a.fR(9, this.ngq);
            if (this.vHc != null) {
                r0 += e.a.a.b.b.a.h(10, this.vHc);
            }
            r0 = ((r0 + e.a.a.a.fR(11, this.wmj)) + e.a.a.a.fR(12, this.vWK)) + e.a.a.a.fR(13, this.wOp);
            if (this.vZq != null) {
                r0 += e.a.a.b.b.a.h(14, this.vZq);
            }
            if (this.wSg != null) {
                r0 += e.a.a.b.b.a.h(15, this.wSg);
            }
            if (this.wSh != null) {
                r0 += e.a.a.b.b.a.h(16, this.wSh);
            }
            if (this.vQA != null) {
                r0 += e.a.a.b.b.a.h(17, this.vQA);
            }
            r0 = ((r0 + e.a.a.a.fR(18, this.vQB)) + e.a.a.a.fR(19, this.wSi)) + e.a.a.a.fR(20, this.wSj);
            if (this.wSk != null) {
                r0 += e.a.a.b.b.a.h(21, this.wSk);
            }
            r0 = ((r0 + e.a.a.a.fR(22, this.wSl)) + e.a.a.a.fR(23, this.wSm)) + e.a.a.a.fR(24, this.wSn);
            if (this.wrT != null) {
                r0 += e.a.a.b.b.a.h(25, this.wrT);
            }
            r0 += e.a.a.a.fR(26, this.wac);
            if (this.vZL != null) {
                r0 += e.a.a.b.b.a.h(27, this.vZL);
            }
            r0 = ((r0 + e.a.a.a.fR(28, this.vQC)) + e.a.a.a.fR(29, this.vQD)) + e.a.a.a.fR(30, this.wKA);
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(31, this.ngo);
            }
            if (this.vFE != null) {
                r0 += e.a.a.b.b.a.h(32, this.vFE);
            }
            if (this.vFD != null) {
                r0 += e.a.a.b.b.a.h(33, this.vFD);
            }
            if (this.vFC != null) {
                r0 += e.a.a.b.b.a.h(34, this.vFC);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wSf == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.vGX == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vGY == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.vXz != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqt com_tencent_mm_protocal_c_bqt = (bqt) objArr[1];
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
                        com_tencent_mm_protocal_c_bqt.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqt.wSf = fdVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqt.vGX = fdVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqt.vGY = fdVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bqt.vIB = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bqt.vIC = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bqt.vID = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bqt.vXz = fdVar;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bqt.ngq = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bqt.vHc = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bqt.wmj = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bqt.vWK = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bqt.wOp = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bqt.vZq = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bqt.wSg = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bqt.wSh = aVar3.Avy.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bqt.vQA = aVar3.Avy.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bqt.vQB = aVar3.Avy.ry();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bqt.wSi = aVar3.Avy.ry();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_bqt.wSj = aVar3.Avy.ry();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bqt.wSk = aVar3.Avy.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bqt.wSl = aVar3.Avy.ry();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_bqt.wSm = aVar3.Avy.ry();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_bqt.wSn = aVar3.Avy.ry();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_bqt.wrT = aVar3.Avy.readString();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_bqt.wac = aVar3.Avy.ry();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_bqt.vZL = aVar3.Avy.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_bqt.vQC = aVar3.Avy.ry();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_bqt.vQD = aVar3.Avy.ry();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_bqt.wKA = aVar3.Avy.ry();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_bqt.ngo = aVar3.Avy.readString();
                    return 0;
                case 32:
                    com_tencent_mm_protocal_c_bqt.vFE = aVar3.Avy.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_bqt.vFD = aVar3.Avy.readString();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_bqt.vFC = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
