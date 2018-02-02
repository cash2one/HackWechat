package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bre extends bcv {
    public String nko;
    public String nkp;
    public int rYW;
    public String vWC;
    public bsx vWD;
    public brd vWF;
    public bdn vXz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vWD == null) {
                throw new b("Not all required fields were included: VoiceAttr");
            } else if (this.vWF == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.vWC != null) {
                    aVar.g(2, this.vWC);
                }
                if (this.vWD != null) {
                    aVar.fW(3, this.vWD.bke());
                    this.vWD.a(aVar);
                }
                if (this.vWF != null) {
                    aVar.fW(4, this.vWF.bke());
                    this.vWF.a(aVar);
                }
                if (this.vXz != null) {
                    aVar.fW(5, this.vXz.bke());
                    this.vXz.a(aVar);
                }
                aVar.fU(6, this.rYW);
                if (this.nkp != null) {
                    aVar.g(7, this.nkp);
                }
                if (this.nko == null) {
                    return 0;
                }
                aVar.g(8, this.nko);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vWC != null) {
                r0 += e.a.a.b.b.a.h(2, this.vWC);
            }
            if (this.vWD != null) {
                r0 += e.a.a.a.fT(3, this.vWD.bke());
            }
            if (this.vWF != null) {
                r0 += e.a.a.a.fT(4, this.vWF.bke());
            }
            if (this.vXz != null) {
                r0 += e.a.a.a.fT(5, this.vXz.bke());
            }
            r0 += e.a.a.a.fR(6, this.rYW);
            if (this.nkp != null) {
                r0 += e.a.a.b.b.a.h(7, this.nkp);
            }
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(8, this.nko);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vWD == null) {
                throw new b("Not all required fields were included: VoiceAttr");
            } else if (this.vWF == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.vXz != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bre com_tencent_mm_protocal_c_bre = (bre) objArr[1];
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
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bre.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bre.vWC = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bsx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bre.vWD = fdVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new brd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bre.vWF = fdVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bre.vXz = fdVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bre.rYW = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bre.nkp = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bre.nko = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
