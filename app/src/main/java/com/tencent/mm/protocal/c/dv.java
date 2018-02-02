package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class dv extends a {
    public int lOd;
    public String vFB;
    public rt vIY;
    public bdn vIZ;
    public bdn vJa;
    public int vJb;
    public bdn vJc;
    public bww vJd;
    public cal vJe;
    public bdn vJf;
    public bdn vJg;
    public String vJh;
    public bdn vJi;
    public String vJj;
    public bin vJk;
    public String vJl;
    public int vJm;
    public int vJn;
    public int vJo;
    public int vJp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIY == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.vIZ == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.vJa == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else {
                aVar.fU(1, this.lOd);
                if (this.vIY != null) {
                    aVar.fW(2, this.vIY.bke());
                    this.vIY.a(aVar);
                }
                if (this.vIZ != null) {
                    aVar.fW(3, this.vIZ.bke());
                    this.vIZ.a(aVar);
                }
                if (this.vJa != null) {
                    aVar.fW(4, this.vJa.bke());
                    this.vJa.a(aVar);
                }
                aVar.fU(5, this.vJb);
                if (this.vJc != null) {
                    aVar.fW(6, this.vJc.bke());
                    this.vJc.a(aVar);
                }
                if (this.vJd != null) {
                    aVar.fW(7, this.vJd.bke());
                    this.vJd.a(aVar);
                }
                if (this.vJe != null) {
                    aVar.fW(8, this.vJe.bke());
                    this.vJe.a(aVar);
                }
                if (this.vJf != null) {
                    aVar.fW(9, this.vJf.bke());
                    this.vJf.a(aVar);
                }
                if (this.vJg != null) {
                    aVar.fW(10, this.vJg.bke());
                    this.vJg.a(aVar);
                }
                if (this.vJh != null) {
                    aVar.g(11, this.vJh);
                }
                if (this.vJi != null) {
                    aVar.fW(12, this.vJi.bke());
                    this.vJi.a(aVar);
                }
                if (this.vJj != null) {
                    aVar.g(14, this.vJj);
                }
                if (this.vJk != null) {
                    aVar.fW(15, this.vJk.bke());
                    this.vJk.a(aVar);
                }
                if (this.vJl != null) {
                    aVar.g(16, this.vJl);
                }
                aVar.fU(17, this.vJm);
                aVar.fU(18, this.vJn);
                aVar.fU(19, this.vJo);
                if (this.vFB != null) {
                    aVar.g(20, this.vFB);
                }
                aVar.fU(21, this.vJp);
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.lOd) + 0;
            if (this.vIY != null) {
                r0 += e.a.a.a.fT(2, this.vIY.bke());
            }
            if (this.vIZ != null) {
                r0 += e.a.a.a.fT(3, this.vIZ.bke());
            }
            if (this.vJa != null) {
                r0 += e.a.a.a.fT(4, this.vJa.bke());
            }
            r0 += e.a.a.a.fR(5, this.vJb);
            if (this.vJc != null) {
                r0 += e.a.a.a.fT(6, this.vJc.bke());
            }
            if (this.vJd != null) {
                r0 += e.a.a.a.fT(7, this.vJd.bke());
            }
            if (this.vJe != null) {
                r0 += e.a.a.a.fT(8, this.vJe.bke());
            }
            if (this.vJf != null) {
                r0 += e.a.a.a.fT(9, this.vJf.bke());
            }
            if (this.vJg != null) {
                r0 += e.a.a.a.fT(10, this.vJg.bke());
            }
            if (this.vJh != null) {
                r0 += e.a.a.b.b.a.h(11, this.vJh);
            }
            if (this.vJi != null) {
                r0 += e.a.a.a.fT(12, this.vJi.bke());
            }
            if (this.vJj != null) {
                r0 += e.a.a.b.b.a.h(14, this.vJj);
            }
            if (this.vJk != null) {
                r0 += e.a.a.a.fT(15, this.vJk.bke());
            }
            if (this.vJl != null) {
                r0 += e.a.a.b.b.a.h(16, this.vJl);
            }
            r0 = ((r0 + e.a.a.a.fR(17, this.vJm)) + e.a.a.a.fR(18, this.vJn)) + e.a.a.a.fR(19, this.vJo);
            if (this.vFB != null) {
                r0 += e.a.a.b.b.a.h(20, this.vFB);
            }
            return r0 + e.a.a.a.fR(21, this.vJp);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vIY == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.vIZ == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.vJa != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AutoAuthKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dv dvVar = (dv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a rtVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dvVar.lOd = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        rtVar = new rt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rtVar.a(aVar4, rtVar, a.a(aVar4))) {
                        }
                        dvVar.vIY = rtVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        rtVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rtVar.a(aVar4, rtVar, a.a(aVar4))) {
                        }
                        dvVar.vIZ = rtVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        rtVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rtVar.a(aVar4, rtVar, a.a(aVar4))) {
                        }
                        dvVar.vJa = rtVar;
                    }
                    return 0;
                case 5:
                    dvVar.vJb = aVar3.Avy.ry();
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        rtVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rtVar.a(aVar4, rtVar, a.a(aVar4))) {
                        }
                        dvVar.vJc = rtVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        rtVar = new bww();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rtVar.a(aVar4, rtVar, a.a(aVar4))) {
                        }
                        dvVar.vJd = rtVar;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        rtVar = new cal();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rtVar.a(aVar4, rtVar, a.a(aVar4))) {
                        }
                        dvVar.vJe = rtVar;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        rtVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rtVar.a(aVar4, rtVar, a.a(aVar4))) {
                        }
                        dvVar.vJf = rtVar;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        rtVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rtVar.a(aVar4, rtVar, a.a(aVar4))) {
                        }
                        dvVar.vJg = rtVar;
                    }
                    return 0;
                case 11:
                    dvVar.vJh = aVar3.Avy.readString();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        rtVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rtVar.a(aVar4, rtVar, a.a(aVar4))) {
                        }
                        dvVar.vJi = rtVar;
                    }
                    return 0;
                case 14:
                    dvVar.vJj = aVar3.Avy.readString();
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        rtVar = new bin();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rtVar.a(aVar4, rtVar, a.a(aVar4))) {
                        }
                        dvVar.vJk = rtVar;
                    }
                    return 0;
                case 16:
                    dvVar.vJl = aVar3.Avy.readString();
                    return 0;
                case 17:
                    dvVar.vJm = aVar3.Avy.ry();
                    return 0;
                case 18:
                    dvVar.vJn = aVar3.Avy.ry();
                    return 0;
                case 19:
                    dvVar.vJo = aVar3.Avy.ry();
                    return 0;
                case 20:
                    dvVar.vFB = aVar3.Avy.readString();
                    return 0;
                case 21:
                    dvVar.vJp = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
