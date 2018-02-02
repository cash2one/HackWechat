package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.bq.a;
import e.a.a.b;

public class t extends a {
    public int cRJ;
    public String fpP;
    public String fuI;
    public String gBL;
    public double ljg;
    public String ljh;
    public int msgType;
    public int scene;
    public int status;
    public String type;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.fuI == null) {
                throw new b("Not all required fields were included: transactionId");
            } else if (this.fpP == null) {
                throw new b("Not all required fields were included: feeType");
            } else {
                if (this.username != null) {
                    aVar.g(1, this.username);
                }
                if (this.fuI != null) {
                    aVar.g(2, this.fuI);
                }
                aVar.b(3, this.ljg);
                if (this.fpP != null) {
                    aVar.g(4, this.fpP);
                }
                aVar.fU(5, this.cRJ);
                aVar.fU(6, this.scene);
                aVar.fU(7, this.status);
                if (this.gBL != null) {
                    aVar.g(8, this.gBL);
                }
                if (this.ljh != null) {
                    aVar.g(9, this.ljh);
                }
                aVar.fU(10, this.msgType);
                if (this.type == null) {
                    return 0;
                }
                aVar.g(11, this.type);
                return 0;
            }
        } else if (i == 1) {
            if (this.username != null) {
                r0 = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            if (this.fuI != null) {
                r0 += e.a.a.b.b.a.h(2, this.fuI);
            }
            r0 += e.a.a.b.b.a.dX(3) + 8;
            if (this.fpP != null) {
                r0 += e.a.a.b.b.a.h(4, this.fpP);
            }
            r0 = ((r0 + e.a.a.a.fR(5, this.cRJ)) + e.a.a.a.fR(6, this.scene)) + e.a.a.a.fR(7, this.status);
            if (this.gBL != null) {
                r0 += e.a.a.b.b.a.h(8, this.gBL);
            }
            if (this.ljh != null) {
                r0 += e.a.a.b.b.a.h(9, this.ljh);
            }
            r0 += e.a.a.a.fR(10, this.msgType);
            if (this.type != null) {
                r0 += e.a.a.b.b.a.h(11, this.type);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.fuI == null) {
                throw new b("Not all required fields were included: transactionId");
            } else if (this.fpP != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: feeType");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.username = aVar3.Avy.readString();
                    return 0;
                case 2:
                    tVar.fuI = aVar3.Avy.readString();
                    return 0;
                case 3:
                    tVar.ljg = aVar3.Avy.readDouble();
                    return 0;
                case 4:
                    tVar.fpP = aVar3.Avy.readString();
                    return 0;
                case 5:
                    tVar.cRJ = aVar3.Avy.ry();
                    return 0;
                case 6:
                    tVar.scene = aVar3.Avy.ry();
                    return 0;
                case 7:
                    tVar.status = aVar3.Avy.ry();
                    return 0;
                case 8:
                    tVar.gBL = aVar3.Avy.readString();
                    return 0;
                case 9:
                    tVar.ljh = aVar3.Avy.readString();
                    return 0;
                case 10:
                    tVar.msgType = aVar3.Avy.ry();
                    return 0;
                case 11:
                    tVar.type = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
