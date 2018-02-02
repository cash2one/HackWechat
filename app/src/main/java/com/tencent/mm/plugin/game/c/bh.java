package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.fe;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bh extends bdf {
    public e nfh;
    public String nhS;
    public LinkedList<x> nhT = new LinkedList();
    public ct nhU;
    public ce nhV;
    public cb nhW;
    public dm nhX;
    public LinkedList<y> nhY = new LinkedList();
    public dt nhZ;
    public cd nia;
    public ca nib;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.nfh == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.nhS == null) {
                throw new b("Not all required fields were included: BackGroundURL");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.nfh != null) {
                    aVar.fW(2, this.nfh.bke());
                    this.nfh.a(aVar);
                }
                if (this.nhS != null) {
                    aVar.g(3, this.nhS);
                }
                aVar.d(4, 8, this.nhT);
                if (this.nhU != null) {
                    aVar.fW(5, this.nhU.bke());
                    this.nhU.a(aVar);
                }
                if (this.nhV != null) {
                    aVar.fW(7, this.nhV.bke());
                    this.nhV.a(aVar);
                }
                if (this.nhW != null) {
                    aVar.fW(8, this.nhW.bke());
                    this.nhW.a(aVar);
                }
                if (this.nhX != null) {
                    aVar.fW(9, this.nhX.bke());
                    this.nhX.a(aVar);
                }
                aVar.d(10, 8, this.nhY);
                if (this.nhZ != null) {
                    aVar.fW(11, this.nhZ.bke());
                    this.nhZ.a(aVar);
                }
                if (this.nia != null) {
                    aVar.fW(12, this.nia.bke());
                    this.nia.a(aVar);
                }
                if (this.nib == null) {
                    return 0;
                }
                aVar.fW(13, this.nib.bke());
                this.nib.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfh != null) {
                r0 += e.a.a.a.fT(2, this.nfh.bke());
            }
            if (this.nhS != null) {
                r0 += e.a.a.b.b.a.h(3, this.nhS);
            }
            r0 += e.a.a.a.c(4, 8, this.nhT);
            if (this.nhU != null) {
                r0 += e.a.a.a.fT(5, this.nhU.bke());
            }
            if (this.nhV != null) {
                r0 += e.a.a.a.fT(7, this.nhV.bke());
            }
            if (this.nhW != null) {
                r0 += e.a.a.a.fT(8, this.nhW.bke());
            }
            if (this.nhX != null) {
                r0 += e.a.a.a.fT(9, this.nhX.bke());
            }
            r0 += e.a.a.a.c(10, 8, this.nhY);
            if (this.nhZ != null) {
                r0 += e.a.a.a.fT(11, this.nhZ.bke());
            }
            if (this.nia != null) {
                r0 += e.a.a.a.fT(12, this.nia.bke());
            }
            if (this.nib != null) {
                r0 += e.a.a.a.fT(13, this.nib.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.nhT.clear();
            this.nhY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.nfh == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.nhS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BackGroundURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bh bhVar = (bh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bhVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new e();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bhVar.nfh = feVar;
                    }
                    return 0;
                case 3:
                    bhVar.nhS = aVar3.Avy.readString();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new x();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bhVar.nhT.add(feVar);
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ct();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bhVar.nhU = feVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ce();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bhVar.nhV = feVar;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new cb();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bhVar.nhW = feVar;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new dm();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bhVar.nhX = feVar;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new y();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bhVar.nhY.add(feVar);
                    }
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new dt();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bhVar.nhZ = feVar;
                    }
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new cd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bhVar.nia = feVar;
                    }
                    return 0;
                case 13:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ca();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bhVar.nib = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
