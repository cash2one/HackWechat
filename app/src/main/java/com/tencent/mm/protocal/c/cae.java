package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cae extends a {
    public String vNd;
    public String vZL;
    public String wYs;
    public int wZI;
    public int wZJ;
    public String wZN;
    public bzx wZO;
    public cad wZP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wZN == null) {
                throw new b("Not all required fields were included: EntranceDomain");
            } else if (this.wYs == null) {
                throw new b("Not all required fields were included: Charset");
            } else {
                if (this.wZN != null) {
                    aVar.g(4, this.wZN);
                }
                if (this.wYs != null) {
                    aVar.g(12, this.wYs);
                }
                if (this.wZO != null) {
                    aVar.fW(9, this.wZO.bke());
                    this.wZO.a(aVar);
                }
                if (this.wZP != null) {
                    aVar.fW(10, this.wZP.bke());
                    this.wZP.a(aVar);
                }
                if (this.vZL != null) {
                    aVar.g(5, this.vZL);
                }
                if (this.vNd != null) {
                    aVar.g(6, this.vNd);
                }
                aVar.fU(7, this.wZI);
                aVar.fU(8, this.wZJ);
                return 0;
            }
        } else if (i == 1) {
            if (this.wZN != null) {
                r0 = e.a.a.b.b.a.h(4, this.wZN) + 0;
            } else {
                r0 = 0;
            }
            if (this.wYs != null) {
                r0 += e.a.a.b.b.a.h(12, this.wYs);
            }
            if (this.wZO != null) {
                r0 += e.a.a.a.fT(9, this.wZO.bke());
            }
            if (this.wZP != null) {
                r0 += e.a.a.a.fT(10, this.wZP.bke());
            }
            if (this.vZL != null) {
                r0 += e.a.a.b.b.a.h(5, this.vZL);
            }
            if (this.vNd != null) {
                r0 += e.a.a.b.b.a.h(6, this.vNd);
            }
            return (r0 + e.a.a.a.fR(7, this.wZI)) + e.a.a.a.fR(8, this.wZJ);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wZN == null) {
                throw new b("Not all required fields were included: EntranceDomain");
            } else if (this.wYs != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Charset");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cae com_tencent_mm_protocal_c_cae = (cae) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bzx;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 4:
                    com_tencent_mm_protocal_c_cae.wZN = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_cae.vZL = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_cae.vNd = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_cae.wZI = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_cae.wZJ = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bzx = new bzx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bzx.a(aVar4, com_tencent_mm_protocal_c_bzx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_cae.wZO = com_tencent_mm_protocal_c_bzx;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bzx = new cad();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bzx.a(aVar4, com_tencent_mm_protocal_c_bzx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_cae.wZP = com_tencent_mm_protocal_c_bzx;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_cae.wYs = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
