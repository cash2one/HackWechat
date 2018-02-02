package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class nw extends bdf {
    public int ktm;
    public btc vWE;
    public brd vWF;
    public baa vWG;
    public int vWH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vWE == null) {
                throw new b("Not all required fields were included: TransRes");
            } else if (this.vWF == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.vWG == null) {
                throw new b("Not all required fields were included: QueryCtx");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                aVar.fU(2, this.ktm);
                if (this.vWE != null) {
                    aVar.fW(3, this.vWE.bke());
                    this.vWE.a(aVar);
                }
                if (this.vWF != null) {
                    aVar.fW(4, this.vWF.bke());
                    this.vWF.a(aVar);
                }
                if (this.vWG != null) {
                    aVar.fW(5, this.vWG.bke());
                    this.vWG.a(aVar);
                }
                aVar.fU(6, this.vWH);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.ktm);
            if (this.vWE != null) {
                r0 += e.a.a.a.fT(3, this.vWE.bke());
            }
            if (this.vWF != null) {
                r0 += e.a.a.a.fT(4, this.vWF.bke());
            }
            if (this.vWG != null) {
                r0 += e.a.a.a.fT(5, this.vWG.bke());
            }
            return r0 + e.a.a.a.fR(6, this.vWH);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vWE == null) {
                throw new b("Not all required fields were included: TransRes");
            } else if (this.vWF == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.vWG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: QueryCtx");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nw nwVar = (nw) objArr[1];
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
                        nwVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    nwVar.ktm = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new btc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        nwVar.vWE = feVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new brd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        nwVar.vWF = feVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new baa();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        nwVar.vWG = feVar;
                    }
                    return 0;
                case 6:
                    nwVar.vWH = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
