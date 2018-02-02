package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bax extends a {
    public int id;
    public bdo wHA;
    public bdo wHB;
    public bdo wHC;
    public bdo wHD;
    public bdo wHE;
    public bdo wHF;
    public bdo wHG;
    public bdo wHy;
    public bdo wHz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wHz == null) {
                throw new b("Not all required fields were included: province");
            } else if (this.wHA == null) {
                throw new b("Not all required fields were included: city");
            } else if (this.wHB == null) {
                throw new b("Not all required fields were included: district");
            } else if (this.wHC == null) {
                throw new b("Not all required fields were included: zipcode");
            } else if (this.wHD == null) {
                throw new b("Not all required fields were included: detail");
            } else if (this.wHE == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.wHF == null) {
                throw new b("Not all required fields were included: phone");
            } else {
                aVar.fU(1, this.id);
                if (this.wHy != null) {
                    aVar.fW(2, this.wHy.bke());
                    this.wHy.a(aVar);
                }
                if (this.wHz != null) {
                    aVar.fW(3, this.wHz.bke());
                    this.wHz.a(aVar);
                }
                if (this.wHA != null) {
                    aVar.fW(4, this.wHA.bke());
                    this.wHA.a(aVar);
                }
                if (this.wHB != null) {
                    aVar.fW(5, this.wHB.bke());
                    this.wHB.a(aVar);
                }
                if (this.wHC != null) {
                    aVar.fW(6, this.wHC.bke());
                    this.wHC.a(aVar);
                }
                if (this.wHD != null) {
                    aVar.fW(7, this.wHD.bke());
                    this.wHD.a(aVar);
                }
                if (this.wHE != null) {
                    aVar.fW(8, this.wHE.bke());
                    this.wHE.a(aVar);
                }
                if (this.wHF != null) {
                    aVar.fW(9, this.wHF.bke());
                    this.wHF.a(aVar);
                }
                if (this.wHG != null) {
                    aVar.fW(10, this.wHG.bke());
                    this.wHG.a(aVar);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.id) + 0;
            if (this.wHy != null) {
                r0 += e.a.a.a.fT(2, this.wHy.bke());
            }
            if (this.wHz != null) {
                r0 += e.a.a.a.fT(3, this.wHz.bke());
            }
            if (this.wHA != null) {
                r0 += e.a.a.a.fT(4, this.wHA.bke());
            }
            if (this.wHB != null) {
                r0 += e.a.a.a.fT(5, this.wHB.bke());
            }
            if (this.wHC != null) {
                r0 += e.a.a.a.fT(6, this.wHC.bke());
            }
            if (this.wHD != null) {
                r0 += e.a.a.a.fT(7, this.wHD.bke());
            }
            if (this.wHE != null) {
                r0 += e.a.a.a.fT(8, this.wHE.bke());
            }
            if (this.wHF != null) {
                r0 += e.a.a.a.fT(9, this.wHF.bke());
            }
            if (this.wHG != null) {
                return r0 + e.a.a.a.fT(10, this.wHG.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wHz == null) {
                throw new b("Not all required fields were included: province");
            } else if (this.wHA == null) {
                throw new b("Not all required fields were included: city");
            } else if (this.wHB == null) {
                throw new b("Not all required fields were included: district");
            } else if (this.wHC == null) {
                throw new b("Not all required fields were included: zipcode");
            } else if (this.wHD == null) {
                throw new b("Not all required fields were included: detail");
            } else if (this.wHE == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.wHF != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: phone");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bax com_tencent_mm_protocal_c_bax = (bax) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bax.id = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bax.wHy = com_tencent_mm_protocal_c_bdo;
                    }
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
                        com_tencent_mm_protocal_c_bax.wHz = com_tencent_mm_protocal_c_bdo;
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
                        com_tencent_mm_protocal_c_bax.wHA = com_tencent_mm_protocal_c_bdo;
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
                        com_tencent_mm_protocal_c_bax.wHB = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bax.wHC = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bax.wHD = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bax.wHE = com_tencent_mm_protocal_c_bdo;
                    }
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
                        com_tencent_mm_protocal_c_bax.wHF = com_tencent_mm_protocal_c_bdo;
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
                        com_tencent_mm_protocal_c_bax.wHG = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
