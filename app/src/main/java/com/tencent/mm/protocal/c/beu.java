package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class beu extends bdf {
    public ajr vLR;
    public ajs vLS;
    public String vLx;
    public arp vLy;
    public int wKf;
    public ce wKg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vLy == null) {
                throw new b("Not all required fields were included: Contact");
            } else if (this.vLR == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.vLS == null) {
                throw new b("Not all required fields were included: HardDeviceAttr");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.vLy != null) {
                    aVar.fW(2, this.vLy.bke());
                    this.vLy.a(aVar);
                }
                if (this.vLR != null) {
                    aVar.fW(3, this.vLR.bke());
                    this.vLR.a(aVar);
                }
                if (this.vLS != null) {
                    aVar.fW(4, this.vLS.bke());
                    this.vLS.a(aVar);
                }
                if (this.vLx != null) {
                    aVar.g(5, this.vLx);
                }
                aVar.fU(6, this.wKf);
                if (this.wKg == null) {
                    return 0;
                }
                aVar.fW(7, this.wKg.bke());
                this.wKg.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vLy != null) {
                r0 += e.a.a.a.fT(2, this.vLy.bke());
            }
            if (this.vLR != null) {
                r0 += e.a.a.a.fT(3, this.vLR.bke());
            }
            if (this.vLS != null) {
                r0 += e.a.a.a.fT(4, this.vLS.bke());
            }
            if (this.vLx != null) {
                r0 += e.a.a.b.b.a.h(5, this.vLx);
            }
            r0 += e.a.a.a.fR(6, this.wKf);
            if (this.wKg != null) {
                r0 += e.a.a.a.fT(7, this.wKg.bke());
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
            } else if (this.vLy == null) {
                throw new b("Not all required fields were included: Contact");
            } else if (this.vLR == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.vLS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: HardDeviceAttr");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            beu com_tencent_mm_protocal_c_beu = (beu) objArr[1];
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
                        com_tencent_mm_protocal_c_beu.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new arp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_beu.vLy = feVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new ajr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_beu.vLR = feVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new ajs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_beu.vLS = feVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_beu.vLx = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_beu.wKf = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new ce();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_beu.wKg = feVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
