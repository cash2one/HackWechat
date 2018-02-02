package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class wn extends a {
    public String nfT;
    public String nfp;
    public String nfq;
    public String ngo;
    public String vXO;
    public ww wgP;
    public int wgQ;
    public String wgR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ngo == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.nfp == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.vXO == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.nfT == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.wgP == null) {
                throw new b("Not all required fields were included: DownloadInfo");
            } else {
                if (this.ngo != null) {
                    aVar.g(1, this.ngo);
                }
                if (this.nfp != null) {
                    aVar.g(2, this.nfp);
                }
                if (this.vXO != null) {
                    aVar.g(3, this.vXO);
                }
                if (this.nfT != null) {
                    aVar.g(4, this.nfT);
                }
                if (this.nfq != null) {
                    aVar.g(5, this.nfq);
                }
                if (this.wgP != null) {
                    aVar.fW(6, this.wgP.bke());
                    this.wgP.a(aVar);
                }
                aVar.fU(7, this.wgQ);
                if (this.wgR == null) {
                    return 0;
                }
                aVar.g(8, this.wgR);
                return 0;
            }
        } else if (i == 1) {
            if (this.ngo != null) {
                r0 = e.a.a.b.b.a.h(1, this.ngo) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfp);
            }
            if (this.vXO != null) {
                r0 += e.a.a.b.b.a.h(3, this.vXO);
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfT);
            }
            if (this.nfq != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfq);
            }
            if (this.wgP != null) {
                r0 += e.a.a.a.fT(6, this.wgP.bke());
            }
            r0 += e.a.a.a.fR(7, this.wgQ);
            if (this.wgR != null) {
                r0 += e.a.a.b.b.a.h(8, this.wgR);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ngo == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.nfp == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.vXO == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.nfT == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.wgP != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DownloadInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            wn wnVar = (wn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    wnVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 2:
                    wnVar.nfp = aVar3.Avy.readString();
                    return 0;
                case 3:
                    wnVar.vXO = aVar3.Avy.readString();
                    return 0;
                case 4:
                    wnVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 5:
                    wnVar.nfq = aVar3.Avy.readString();
                    return 0;
                case 6:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a wwVar = new ww();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = wwVar.a(aVar4, wwVar, a.a(aVar4))) {
                        }
                        wnVar.wgP = wwVar;
                    }
                    return 0;
                case 7:
                    wnVar.wgQ = aVar3.Avy.ry();
                    return 0;
                case 8:
                    wnVar.wgR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
