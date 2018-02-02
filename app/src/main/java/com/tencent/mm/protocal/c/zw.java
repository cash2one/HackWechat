package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class zw extends bdf {
    public jp vSD;
    public jp vSE;
    public jp vSF;
    public bdn vSG;
    public bdn vSH;
    public jp vSI;
    public int vSJ;
    public jo vSK;
    public jo vSL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vSD == null) {
                throw new b("Not all required fields were included: DnsInfo");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.vSD != null) {
                    aVar.fW(2, this.vSD.bke());
                    this.vSD.a(aVar);
                }
                if (this.vSE != null) {
                    aVar.fW(3, this.vSE.bke());
                    this.vSE.a(aVar);
                }
                if (this.vSF != null) {
                    aVar.fW(4, this.vSF.bke());
                    this.vSF.a(aVar);
                }
                if (this.vSG != null) {
                    aVar.fW(5, this.vSG.bke());
                    this.vSG.a(aVar);
                }
                if (this.vSH != null) {
                    aVar.fW(6, this.vSH.bke());
                    this.vSH.a(aVar);
                }
                if (this.vSI != null) {
                    aVar.fW(7, this.vSI.bke());
                    this.vSI.a(aVar);
                }
                aVar.fU(8, this.vSJ);
                if (this.vSK != null) {
                    aVar.fW(9, this.vSK.bke());
                    this.vSK.a(aVar);
                }
                if (this.vSL == null) {
                    return 0;
                }
                aVar.fW(10, this.vSL.bke());
                this.vSL.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vSD != null) {
                r0 += e.a.a.a.fT(2, this.vSD.bke());
            }
            if (this.vSE != null) {
                r0 += e.a.a.a.fT(3, this.vSE.bke());
            }
            if (this.vSF != null) {
                r0 += e.a.a.a.fT(4, this.vSF.bke());
            }
            if (this.vSG != null) {
                r0 += e.a.a.a.fT(5, this.vSG.bke());
            }
            if (this.vSH != null) {
                r0 += e.a.a.a.fT(6, this.vSH.bke());
            }
            if (this.vSI != null) {
                r0 += e.a.a.a.fT(7, this.vSI.bke());
            }
            r0 += e.a.a.a.fR(8, this.vSJ);
            if (this.vSK != null) {
                r0 += e.a.a.a.fT(9, this.vSK.bke());
            }
            if (this.vSL != null) {
                r0 += e.a.a.a.fT(10, this.vSL.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vSD != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DnsInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zw zwVar = (zw) objArr[1];
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
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        zwVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new jp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        zwVar.vSD = feVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new jp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        zwVar.vSE = feVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new jp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        zwVar.vSF = feVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        zwVar.vSG = feVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        zwVar.vSH = feVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new jp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        zwVar.vSI = feVar;
                    }
                    return 0;
                case 8:
                    zwVar.vSJ = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new jo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        zwVar.vSK = feVar;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new jo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        zwVar.vSL = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
