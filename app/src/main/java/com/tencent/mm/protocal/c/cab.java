package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cab extends a {
    public caa wZB;
    public String wgp;
    public String wgr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wgp == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.wgr == null) {
                throw new b("Not all required fields were included: MimeType");
            } else if (this.wZB == null) {
                throw new b("Not all required fields were included: DownloadInfo");
            } else {
                if (this.wgp != null) {
                    aVar.g(1, this.wgp);
                }
                if (this.wgr != null) {
                    aVar.g(2, this.wgr);
                }
                if (this.wZB == null) {
                    return 0;
                }
                aVar.fW(3, this.wZB.bke());
                this.wZB.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wgp != null) {
                r0 = e.a.a.b.b.a.h(1, this.wgp) + 0;
            } else {
                r0 = 0;
            }
            if (this.wgr != null) {
                r0 += e.a.a.b.b.a.h(2, this.wgr);
            }
            if (this.wZB != null) {
                r0 += e.a.a.a.fT(3, this.wZB.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wgp == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.wgr == null) {
                throw new b("Not all required fields were included: MimeType");
            } else if (this.wZB != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DownloadInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cab com_tencent_mm_protocal_c_cab = (cab) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_cab.wgp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_cab.wgr = aVar3.Avy.readString();
                    return 0;
                case 3:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_caa = new caa();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_caa.a(aVar4, com_tencent_mm_protocal_c_caa, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_cab.wZB = com_tencent_mm_protocal_c_caa;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
