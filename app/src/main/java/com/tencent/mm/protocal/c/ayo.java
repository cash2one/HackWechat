package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ayo extends bcv {
    public bdo wFI;
    public bdo wFJ;
    public bdo wFK;
    public int wFL;
    public long wFs;
    public int wbh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wFI == null) {
                throw new b("Not all required fields were included: ClientReport");
            } else if (this.wFJ == null) {
                throw new b("Not all required fields were included: ChannelReport");
            } else if (this.wFK == null) {
                throw new b("Not all required fields were included: EngineReport");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.wFI != null) {
                    aVar.fW(2, this.wFI.bke());
                    this.wFI.a(aVar);
                }
                if (this.wFJ != null) {
                    aVar.fW(3, this.wFJ.bke());
                    this.wFJ.a(aVar);
                }
                if (this.wFK != null) {
                    aVar.fW(4, this.wFK.bke());
                    this.wFK.a(aVar);
                }
                aVar.fU(5, this.wbh);
                aVar.S(6, this.wFs);
                aVar.fU(7, this.wFL);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wFI != null) {
                r0 += e.a.a.a.fT(2, this.wFI.bke());
            }
            if (this.wFJ != null) {
                r0 += e.a.a.a.fT(3, this.wFJ.bke());
            }
            if (this.wFK != null) {
                r0 += e.a.a.a.fT(4, this.wFK.bke());
            }
            return ((r0 + e.a.a.a.fR(5, this.wbh)) + e.a.a.a.R(6, this.wFs)) + e.a.a.a.fR(7, this.wFL);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wFI == null) {
                throw new b("Not all required fields were included: ClientReport");
            } else if (this.wFJ == null) {
                throw new b("Not all required fields were included: ChannelReport");
            } else if (this.wFK != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: EngineReport");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayo com_tencent_mm_protocal_c_ayo = (ayo) objArr[1];
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
                        com_tencent_mm_protocal_c_ayo.wIV = fdVar;
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
                        com_tencent_mm_protocal_c_ayo.wFI = fdVar;
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
                        com_tencent_mm_protocal_c_ayo.wFJ = fdVar;
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
                        com_tencent_mm_protocal_c_ayo.wFK = fdVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ayo.wbh = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ayo.wFs = aVar3.Avy.rz();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ayo.wFL = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
