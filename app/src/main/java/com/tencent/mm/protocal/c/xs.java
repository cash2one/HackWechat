package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class xs extends bcv {
    public int count;
    public String desc;
    public String fFm;
    public int scene;
    public String sign;
    public int wij;
    public int wik;
    public String wil;
    public String wim;
    public String win;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.fFm == null) {
                throw new b("Not all required fields were included: appid");
            } else if (this.wim == null) {
                throw new b("Not all required fields were included: busi_id");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                aVar.fU(2, this.wij);
                if (this.fFm != null) {
                    aVar.g(3, this.fFm);
                }
                if (this.desc != null) {
                    aVar.g(4, this.desc);
                }
                aVar.fU(5, this.wik);
                if (this.wil != null) {
                    aVar.g(6, this.wil);
                }
                aVar.fU(7, this.count);
                aVar.fU(8, this.scene);
                if (this.wim != null) {
                    aVar.g(9, this.wim);
                }
                if (this.sign != null) {
                    aVar.g(10, this.sign);
                }
                if (this.win == null) {
                    return 0;
                }
                aVar.g(11, this.win);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wij);
            if (this.fFm != null) {
                r0 += e.a.a.b.b.a.h(3, this.fFm);
            }
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(4, this.desc);
            }
            r0 += e.a.a.a.fR(5, this.wik);
            if (this.wil != null) {
                r0 += e.a.a.b.b.a.h(6, this.wil);
            }
            r0 = (r0 + e.a.a.a.fR(7, this.count)) + e.a.a.a.fR(8, this.scene);
            if (this.wim != null) {
                r0 += e.a.a.b.b.a.h(9, this.wim);
            }
            if (this.sign != null) {
                r0 += e.a.a.b.b.a.h(10, this.sign);
            }
            if (this.win != null) {
                r0 += e.a.a.b.b.a.h(11, this.win);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fFm == null) {
                throw new b("Not all required fields were included: appid");
            } else if (this.wim != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: busi_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xs xsVar = (xs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        xsVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    xsVar.wij = aVar3.Avy.ry();
                    return 0;
                case 3:
                    xsVar.fFm = aVar3.Avy.readString();
                    return 0;
                case 4:
                    xsVar.desc = aVar3.Avy.readString();
                    return 0;
                case 5:
                    xsVar.wik = aVar3.Avy.ry();
                    return 0;
                case 6:
                    xsVar.wil = aVar3.Avy.readString();
                    return 0;
                case 7:
                    xsVar.count = aVar3.Avy.ry();
                    return 0;
                case 8:
                    xsVar.scene = aVar3.Avy.ry();
                    return 0;
                case 9:
                    xsVar.wim = aVar3.Avy.readString();
                    return 0;
                case 10:
                    xsVar.sign = aVar3.Avy.readString();
                    return 0;
                case 11:
                    xsVar.win = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
