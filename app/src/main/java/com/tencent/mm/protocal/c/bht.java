package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bht extends bdf {
    public int vLj;
    public float wAj;
    public int wLo;
    public bdn wLp;
    public bdn wLq;
    public bdn wLr;
    public bdn wLs;
    public bdn wLt;
    public int wLu;
    public int wLv;
    public String wLw;
    public bdn wmV;
    public bdn wmW;
    public bdn wmX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wLp == null) {
                throw new b("Not all required fields were included: SongName");
            } else if (this.wLq == null) {
                throw new b("Not all required fields were included: SongSinger");
            } else if (this.wmW == null) {
                throw new b("Not all required fields were included: SongAlbum");
            } else if (this.wmX == null) {
                throw new b("Not all required fields were included: SongAlbumUrl");
            } else if (this.wLr == null) {
                throw new b("Not all required fields were included: SongWifiUrl");
            } else if (this.wLs == null) {
                throw new b("Not all required fields were included: SongWapLinkUrl");
            } else if (this.wLt == null) {
                throw new b("Not all required fields were included: SongWebUrl");
            } else if (this.wmV == null) {
                throw new b("Not all required fields were included: SongLyric");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                aVar.fU(2, this.vLj);
                aVar.fU(3, this.wLo);
                aVar.m(4, this.wAj);
                if (this.wLp != null) {
                    aVar.fW(5, this.wLp.bke());
                    this.wLp.a(aVar);
                }
                if (this.wLq != null) {
                    aVar.fW(6, this.wLq.bke());
                    this.wLq.a(aVar);
                }
                if (this.wmW != null) {
                    aVar.fW(7, this.wmW.bke());
                    this.wmW.a(aVar);
                }
                if (this.wmX != null) {
                    aVar.fW(8, this.wmX.bke());
                    this.wmX.a(aVar);
                }
                if (this.wLr != null) {
                    aVar.fW(9, this.wLr.bke());
                    this.wLr.a(aVar);
                }
                if (this.wLs != null) {
                    aVar.fW(10, this.wLs.bke());
                    this.wLs.a(aVar);
                }
                if (this.wLt != null) {
                    aVar.fW(11, this.wLt.bke());
                    this.wLt.a(aVar);
                }
                if (this.wmV != null) {
                    aVar.fW(12, this.wmV.bke());
                    this.wmV.a(aVar);
                }
                aVar.fU(13, this.wLu);
                aVar.fU(14, this.wLv);
                if (this.wLw == null) {
                    return 0;
                }
                aVar.g(15, this.wLw);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.fR(2, this.vLj)) + e.a.a.a.fR(3, this.wLo)) + (e.a.a.b.b.a.dX(4) + 4);
            if (this.wLp != null) {
                r0 += e.a.a.a.fT(5, this.wLp.bke());
            }
            if (this.wLq != null) {
                r0 += e.a.a.a.fT(6, this.wLq.bke());
            }
            if (this.wmW != null) {
                r0 += e.a.a.a.fT(7, this.wmW.bke());
            }
            if (this.wmX != null) {
                r0 += e.a.a.a.fT(8, this.wmX.bke());
            }
            if (this.wLr != null) {
                r0 += e.a.a.a.fT(9, this.wLr.bke());
            }
            if (this.wLs != null) {
                r0 += e.a.a.a.fT(10, this.wLs.bke());
            }
            if (this.wLt != null) {
                r0 += e.a.a.a.fT(11, this.wLt.bke());
            }
            if (this.wmV != null) {
                r0 += e.a.a.a.fT(12, this.wmV.bke());
            }
            r0 = (r0 + e.a.a.a.fR(13, this.wLu)) + e.a.a.a.fR(14, this.wLv);
            if (this.wLw != null) {
                r0 += e.a.a.b.b.a.h(15, this.wLw);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wLp == null) {
                throw new b("Not all required fields were included: SongName");
            } else if (this.wLq == null) {
                throw new b("Not all required fields were included: SongSinger");
            } else if (this.wmW == null) {
                throw new b("Not all required fields were included: SongAlbum");
            } else if (this.wmX == null) {
                throw new b("Not all required fields were included: SongAlbumUrl");
            } else if (this.wLr == null) {
                throw new b("Not all required fields were included: SongWifiUrl");
            } else if (this.wLs == null) {
                throw new b("Not all required fields were included: SongWapLinkUrl");
            } else if (this.wLt == null) {
                throw new b("Not all required fields were included: SongWebUrl");
            } else if (this.wmV != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SongLyric");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bht com_tencent_mm_protocal_c_bht = (bht) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bht.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bht.vLj = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bht.wLo = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bht.wAj = aVar3.Avy.readFloat();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bht.wLp = feVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bht.wLq = feVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bht.wmW = feVar;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bht.wmX = feVar;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bht.wLr = feVar;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bht.wLs = feVar;
                    }
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bht.wLt = feVar;
                    }
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bht.wmV = feVar;
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bht.wLu = aVar3.Avy.ry();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bht.wLv = aVar3.Avy.ry();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bht.wLw = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
