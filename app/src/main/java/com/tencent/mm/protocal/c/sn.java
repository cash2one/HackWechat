package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class sn extends a {
    public int vGN;
    public String waR;
    public String waS;
    public String waT;
    public String waU;
    public String waV;
    public int waW;
    public int waX;
    public String waY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.waR == null) {
                throw new b("Not all required fields were included: BegWord");
            } else if (this.waS == null) {
                throw new b("Not all required fields were included: BegPicUrl");
            } else if (this.waT == null) {
                throw new b("Not all required fields were included: ThanksPicUrl");
            } else {
                if (this.waR != null) {
                    aVar.g(1, this.waR);
                }
                if (this.waS != null) {
                    aVar.g(2, this.waS);
                }
                if (this.waT != null) {
                    aVar.g(3, this.waT);
                }
                if (this.waU != null) {
                    aVar.g(4, this.waU);
                }
                if (this.waV != null) {
                    aVar.g(5, this.waV);
                }
                aVar.fU(6, this.waW);
                aVar.fU(7, this.waX);
                if (this.waY != null) {
                    aVar.g(8, this.waY);
                }
                aVar.fU(9, this.vGN);
                return 0;
            }
        } else if (i == 1) {
            if (this.waR != null) {
                r0 = e.a.a.b.b.a.h(1, this.waR) + 0;
            } else {
                r0 = 0;
            }
            if (this.waS != null) {
                r0 += e.a.a.b.b.a.h(2, this.waS);
            }
            if (this.waT != null) {
                r0 += e.a.a.b.b.a.h(3, this.waT);
            }
            if (this.waU != null) {
                r0 += e.a.a.b.b.a.h(4, this.waU);
            }
            if (this.waV != null) {
                r0 += e.a.a.b.b.a.h(5, this.waV);
            }
            r0 = (r0 + e.a.a.a.fR(6, this.waW)) + e.a.a.a.fR(7, this.waX);
            if (this.waY != null) {
                r0 += e.a.a.b.b.a.h(8, this.waY);
            }
            return r0 + e.a.a.a.fR(9, this.vGN);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.waR == null) {
                throw new b("Not all required fields were included: BegWord");
            } else if (this.waS == null) {
                throw new b("Not all required fields were included: BegPicUrl");
            } else if (this.waT != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThanksPicUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sn snVar = (sn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    snVar.waR = aVar3.Avy.readString();
                    return 0;
                case 2:
                    snVar.waS = aVar3.Avy.readString();
                    return 0;
                case 3:
                    snVar.waT = aVar3.Avy.readString();
                    return 0;
                case 4:
                    snVar.waU = aVar3.Avy.readString();
                    return 0;
                case 5:
                    snVar.waV = aVar3.Avy.readString();
                    return 0;
                case 6:
                    snVar.waW = aVar3.Avy.ry();
                    return 0;
                case 7:
                    snVar.waX = aVar3.Avy.ry();
                    return 0;
                case 8:
                    snVar.waY = aVar3.Avy.readString();
                    return 0;
                case 9:
                    snVar.vGN = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
