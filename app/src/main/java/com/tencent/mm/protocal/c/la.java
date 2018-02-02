package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class la extends bdf {
    public int pLj;
    public String pLk;
    public String pLl;
    public String sKt;
    public String url;
    public LinkedList<aqz> vTL = new LinkedList();
    public aqz vTM;
    public String vTN;
    public boolean vTO;
    public String vTP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.url == null) {
                throw new b("Not all required fields were included: url");
            } else if (this.vTM == null) {
                throw new b("Not all required fields were included: bottom_item");
            } else {
                if (this.wJr != null) {
                    aVar.fW(1, this.wJr.bke());
                    this.wJr.a(aVar);
                }
                if (this.url != null) {
                    aVar.g(2, this.url);
                }
                aVar.d(3, 8, this.vTL);
                if (this.vTM != null) {
                    aVar.fW(4, this.vTM.bke());
                    this.vTM.a(aVar);
                }
                if (this.sKt != null) {
                    aVar.g(5, this.sKt);
                }
                if (this.vTN != null) {
                    aVar.g(6, this.vTN);
                }
                aVar.al(7, this.vTO);
                aVar.fU(8, this.pLj);
                if (this.vTP != null) {
                    aVar.g(9, this.vTP);
                }
                if (this.pLk != null) {
                    aVar.g(10, this.pLk);
                }
                if (this.pLl == null) {
                    return 0;
                }
                aVar.g(11, this.pLl);
                return 0;
            }
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(2, this.url);
            }
            r0 += e.a.a.a.c(3, 8, this.vTL);
            if (this.vTM != null) {
                r0 += e.a.a.a.fT(4, this.vTM.bke());
            }
            if (this.sKt != null) {
                r0 += e.a.a.b.b.a.h(5, this.sKt);
            }
            if (this.vTN != null) {
                r0 += e.a.a.b.b.a.h(6, this.vTN);
            }
            r0 = (r0 + (e.a.a.b.b.a.dX(7) + 1)) + e.a.a.a.fR(8, this.pLj);
            if (this.vTP != null) {
                r0 += e.a.a.b.b.a.h(9, this.vTP);
            }
            if (this.pLk != null) {
                r0 += e.a.a.b.b.a.h(10, this.pLk);
            }
            if (this.pLl != null) {
                r0 += e.a.a.b.b.a.h(11, this.pLl);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vTL.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.url == null) {
                throw new b("Not all required fields were included: url");
            } else if (this.vTM != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bottom_item");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            la laVar = (la) objArr[1];
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
                        laVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    laVar.url = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new aqz();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        laVar.vTL.add(feVar);
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new aqz();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        laVar.vTM = feVar;
                    }
                    return 0;
                case 5:
                    laVar.sKt = aVar3.Avy.readString();
                    return 0;
                case 6:
                    laVar.vTN = aVar3.Avy.readString();
                    return 0;
                case 7:
                    laVar.vTO = aVar3.cJC();
                    return 0;
                case 8:
                    laVar.pLj = aVar3.Avy.ry();
                    return 0;
                case 9:
                    laVar.vTP = aVar3.Avy.readString();
                    return 0;
                case 10:
                    laVar.pLk = aVar3.Avy.readString();
                    return 0;
                case 11:
                    laVar.pLl = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
