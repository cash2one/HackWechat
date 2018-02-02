package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ly extends bcv {
    public String fwY;
    public String pLn;
    public String pLr;
    public long pMC;
    public String vUB;
    public String vUk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.fwY == null) {
                throw new b("Not all required fields were included: req_key");
            } else if (this.vUB == null) {
                throw new b("Not all required fields were included: transfer_id");
            } else if (this.pLr == null) {
                throw new b("Not all required fields were included: transaction_id");
            } else if (this.pLn == null) {
                throw new b("Not all required fields were included: receiver_openid");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.fwY != null) {
                    aVar.g(2, this.fwY);
                }
                if (this.vUB != null) {
                    aVar.g(3, this.vUB);
                }
                if (this.pLr != null) {
                    aVar.g(4, this.pLr);
                }
                if (this.pLn != null) {
                    aVar.g(5, this.pLn);
                }
                aVar.S(6, this.pMC);
                if (this.vUk == null) {
                    return 0;
                }
                aVar.g(7, this.vUk);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fwY != null) {
                r0 += e.a.a.b.b.a.h(2, this.fwY);
            }
            if (this.vUB != null) {
                r0 += e.a.a.b.b.a.h(3, this.vUB);
            }
            if (this.pLr != null) {
                r0 += e.a.a.b.b.a.h(4, this.pLr);
            }
            if (this.pLn != null) {
                r0 += e.a.a.b.b.a.h(5, this.pLn);
            }
            r0 += e.a.a.a.R(6, this.pMC);
            if (this.vUk != null) {
                r0 += e.a.a.b.b.a.h(7, this.vUk);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fwY == null) {
                throw new b("Not all required fields were included: req_key");
            } else if (this.vUB == null) {
                throw new b("Not all required fields were included: transfer_id");
            } else if (this.pLr == null) {
                throw new b("Not all required fields were included: transaction_id");
            } else if (this.pLn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: receiver_openid");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ly lyVar = (ly) objArr[1];
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
                        lyVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    lyVar.fwY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    lyVar.vUB = aVar3.Avy.readString();
                    return 0;
                case 4:
                    lyVar.pLr = aVar3.Avy.readString();
                    return 0;
                case 5:
                    lyVar.pLn = aVar3.Avy.readString();
                    return 0;
                case 6:
                    lyVar.pMC = aVar3.Avy.rz();
                    return 0;
                case 7:
                    lyVar.vUk = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
