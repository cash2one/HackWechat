package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aqw extends a {
    public String hvC;
    public int hvt;
    public String hvu;
    public String hvv;
    public String hvw;
    public int hvx;
    public int vXS;
    public bdo vYO;
    public bdo vYw;
    public bdo vYx;
    public bdo wsB;
    public int wvf;
    public String wvg;
    public int wyG;
    public bdo wyH;
    public bdo wyI;
    public bdo wyJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vYO == null) {
                throw new b("Not all required fields were included: MemberName");
            } else if (this.wsB == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.vYw == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.vYx == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.wyH == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.wyI == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.wyJ == null) {
                throw new b("Not all required fields were included: RemarkQuanPin");
            } else {
                if (this.vYO != null) {
                    aVar.fW(1, this.vYO.bke());
                    this.vYO.a(aVar);
                }
                aVar.fU(2, this.wyG);
                if (this.wsB != null) {
                    aVar.fW(3, this.wsB.bke());
                    this.wsB.a(aVar);
                }
                if (this.vYw != null) {
                    aVar.fW(4, this.vYw.bke());
                    this.vYw.a(aVar);
                }
                if (this.vYx != null) {
                    aVar.fW(5, this.vYx.bke());
                    this.vYx.a(aVar);
                }
                aVar.fU(6, this.hvt);
                if (this.wyH != null) {
                    aVar.fW(9, this.wyH.bke());
                    this.wyH.a(aVar);
                }
                if (this.wyI != null) {
                    aVar.fW(10, this.wyI.bke());
                    this.wyI.a(aVar);
                }
                if (this.wyJ != null) {
                    aVar.fW(11, this.wyJ.bke());
                    this.wyJ.a(aVar);
                }
                aVar.fU(12, this.vXS);
                if (this.hvu != null) {
                    aVar.g(13, this.hvu);
                }
                if (this.hvv != null) {
                    aVar.g(14, this.hvv);
                }
                if (this.hvw != null) {
                    aVar.g(15, this.hvw);
                }
                aVar.fU(16, this.hvx);
                aVar.fU(17, this.wvf);
                if (this.wvg != null) {
                    aVar.g(18, this.wvg);
                }
                if (this.hvC == null) {
                    return 0;
                }
                aVar.g(19, this.hvC);
                return 0;
            }
        } else if (i == 1) {
            if (this.vYO != null) {
                r0 = e.a.a.a.fT(1, this.vYO.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wyG);
            if (this.wsB != null) {
                r0 += e.a.a.a.fT(3, this.wsB.bke());
            }
            if (this.vYw != null) {
                r0 += e.a.a.a.fT(4, this.vYw.bke());
            }
            if (this.vYx != null) {
                r0 += e.a.a.a.fT(5, this.vYx.bke());
            }
            r0 += e.a.a.a.fR(6, this.hvt);
            if (this.wyH != null) {
                r0 += e.a.a.a.fT(9, this.wyH.bke());
            }
            if (this.wyI != null) {
                r0 += e.a.a.a.fT(10, this.wyI.bke());
            }
            if (this.wyJ != null) {
                r0 += e.a.a.a.fT(11, this.wyJ.bke());
            }
            r0 += e.a.a.a.fR(12, this.vXS);
            if (this.hvu != null) {
                r0 += e.a.a.b.b.a.h(13, this.hvu);
            }
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(14, this.hvv);
            }
            if (this.hvw != null) {
                r0 += e.a.a.b.b.a.h(15, this.hvw);
            }
            r0 = (r0 + e.a.a.a.fR(16, this.hvx)) + e.a.a.a.fR(17, this.wvf);
            if (this.wvg != null) {
                r0 += e.a.a.b.b.a.h(18, this.wvg);
            }
            if (this.hvC != null) {
                r0 += e.a.a.b.b.a.h(19, this.hvC);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vYO == null) {
                throw new b("Not all required fields were included: MemberName");
            } else if (this.wsB == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.vYw == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.vYx == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.wyH == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.wyI == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.wyJ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RemarkQuanPin");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqw com_tencent_mm_protocal_c_aqw = (aqw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqw.vYO = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqw.wyG = aVar3.Avy.ry();
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
                        com_tencent_mm_protocal_c_aqw.wsB = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqw.vYw = com_tencent_mm_protocal_c_bdo;
                    }
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
                        com_tencent_mm_protocal_c_aqw.vYx = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqw.hvt = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqw.wyH = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqw.wyI = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqw.wyJ = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aqw.vXS = aVar3.Avy.ry();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aqw.hvu = aVar3.Avy.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aqw.hvv = aVar3.Avy.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aqw.hvw = aVar3.Avy.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aqw.hvx = aVar3.Avy.ry();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aqw.wvf = aVar3.Avy.ry();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_aqw.wvg = aVar3.Avy.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aqw.hvC = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
