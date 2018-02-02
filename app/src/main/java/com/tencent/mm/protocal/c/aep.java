package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aep extends bdf {
    public String nfe;
    public String nfp;
    public bdn vHG;
    public LinkedList<rw> vLk = new LinkedList();
    public String vLr;
    public String waN;
    public LinkedList<so> wkI = new LinkedList();
    public String wmG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wmG == null) {
                throw new b("Not all required fields were included: BannerUrl");
            } else if (this.nfp == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.nfe == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.waN == null) {
                throw new b("Not all required fields were included: HeadUrl");
            } else if (this.vLr == null) {
                throw new b("Not all required fields were included: BizName");
            } else if (this.vHG == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.wmG != null) {
                    aVar.g(2, this.wmG);
                }
                if (this.nfp != null) {
                    aVar.g(3, this.nfp);
                }
                if (this.nfe != null) {
                    aVar.g(4, this.nfe);
                }
                if (this.waN != null) {
                    aVar.g(5, this.waN);
                }
                if (this.vLr != null) {
                    aVar.g(6, this.vLr);
                }
                aVar.d(7, 8, this.wkI);
                if (this.vHG != null) {
                    aVar.fW(8, this.vHG.bke());
                    this.vHG.a(aVar);
                }
                aVar.d(9, 8, this.vLk);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wmG != null) {
                r0 += e.a.a.b.b.a.h(2, this.wmG);
            }
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfp);
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfe);
            }
            if (this.waN != null) {
                r0 += e.a.a.b.b.a.h(5, this.waN);
            }
            if (this.vLr != null) {
                r0 += e.a.a.b.b.a.h(6, this.vLr);
            }
            r0 += e.a.a.a.c(7, 8, this.wkI);
            if (this.vHG != null) {
                r0 += e.a.a.a.fT(8, this.vHG.bke());
            }
            return r0 + e.a.a.a.c(9, 8, this.vLk);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wkI.clear();
            this.vLk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wmG == null) {
                throw new b("Not all required fields were included: BannerUrl");
            } else if (this.nfp == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.nfe == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.waN == null) {
                throw new b("Not all required fields were included: HeadUrl");
            } else if (this.vLr == null) {
                throw new b("Not all required fields were included: BizName");
            } else if (this.vHG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aep com_tencent_mm_protocal_c_aep = (aep) objArr[1];
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
                        com_tencent_mm_protocal_c_aep.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aep.wmG = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aep.nfp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aep.nfe = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aep.waN = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aep.vLr = aVar3.Avy.readString();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new so();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aep.wkI.add(feVar);
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aep.vHG = feVar;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new rw();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aep.vLk.add(feVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
