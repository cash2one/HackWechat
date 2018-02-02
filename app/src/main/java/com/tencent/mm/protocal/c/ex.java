package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ex extends a {
    public String nBM;
    public String oZz;
    public String pay;
    public String vKH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vKH != null) {
                aVar.g(1, this.vKH);
            }
            if (this.oZz != null) {
                aVar.g(2, this.oZz);
            }
            if (this.nBM != null) {
                aVar.g(3, this.nBM);
            }
            if (this.pay == null) {
                return 0;
            }
            aVar.g(4, this.pay);
            return 0;
        } else if (i == 1) {
            if (this.vKH != null) {
                r0 = e.a.a.b.b.a.h(1, this.vKH) + 0;
            } else {
                r0 = 0;
            }
            if (this.oZz != null) {
                r0 += e.a.a.b.b.a.h(2, this.oZz);
            }
            if (this.nBM != null) {
                r0 += e.a.a.b.b.a.h(3, this.nBM);
            }
            if (this.pay != null) {
                r0 += e.a.a.b.b.a.h(4, this.pay);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ex exVar = (ex) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    exVar.vKH = aVar3.Avy.readString();
                    return 0;
                case 2:
                    exVar.oZz = aVar3.Avy.readString();
                    return 0;
                case 3:
                    exVar.nBM = aVar3.Avy.readString();
                    return 0;
                case 4:
                    exVar.pay = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
