package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class zn extends bcv {
    public String kUf;
    public String sMr;
    public String signature;
    public String vOC;
    public String vYi;
    public String wji;
    public String wjj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vYi == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.wji == null) {
                throw new b("Not all required fields were included: group_id");
            } else if (this.sMr == null) {
                throw new b("Not all required fields were included: time_stamp");
            } else if (this.kUf == null) {
                throw new b("Not all required fields were included: nonce_str");
            } else if (this.signature == null) {
                throw new b("Not all required fields were included: signature");
            } else if (this.vOC == null) {
                throw new b("Not all required fields were included: from_url");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.vYi != null) {
                    aVar.g(2, this.vYi);
                }
                if (this.wji != null) {
                    aVar.g(3, this.wji);
                }
                if (this.sMr != null) {
                    aVar.g(4, this.sMr);
                }
                if (this.kUf != null) {
                    aVar.g(5, this.kUf);
                }
                if (this.signature != null) {
                    aVar.g(6, this.signature);
                }
                if (this.vOC != null) {
                    aVar.g(7, this.vOC);
                }
                if (this.wjj == null) {
                    return 0;
                }
                aVar.g(8, this.wjj);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vYi != null) {
                r0 += e.a.a.b.b.a.h(2, this.vYi);
            }
            if (this.wji != null) {
                r0 += e.a.a.b.b.a.h(3, this.wji);
            }
            if (this.sMr != null) {
                r0 += e.a.a.b.b.a.h(4, this.sMr);
            }
            if (this.kUf != null) {
                r0 += e.a.a.b.b.a.h(5, this.kUf);
            }
            if (this.signature != null) {
                r0 += e.a.a.b.b.a.h(6, this.signature);
            }
            if (this.vOC != null) {
                r0 += e.a.a.b.b.a.h(7, this.vOC);
            }
            if (this.wjj != null) {
                r0 += e.a.a.b.b.a.h(8, this.wjj);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vYi == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.wji == null) {
                throw new b("Not all required fields were included: group_id");
            } else if (this.sMr == null) {
                throw new b("Not all required fields were included: time_stamp");
            } else if (this.kUf == null) {
                throw new b("Not all required fields were included: nonce_str");
            } else if (this.signature == null) {
                throw new b("Not all required fields were included: signature");
            } else if (this.vOC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: from_url");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zn znVar = (zn) objArr[1];
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
                        znVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    znVar.vYi = aVar3.Avy.readString();
                    return 0;
                case 3:
                    znVar.wji = aVar3.Avy.readString();
                    return 0;
                case 4:
                    znVar.sMr = aVar3.Avy.readString();
                    return 0;
                case 5:
                    znVar.kUf = aVar3.Avy.readString();
                    return 0;
                case 6:
                    znVar.signature = aVar3.Avy.readString();
                    return 0;
                case 7:
                    znVar.vOC = aVar3.Avy.readString();
                    return 0;
                case 8:
                    znVar.wjj = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
