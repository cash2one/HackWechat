package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class vy extends a {
    public int ktH;
    public String wgp;
    public long wgq;
    public String wgr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wgp == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.wgr == null) {
                throw new b("Not all required fields were included: MimeType");
            } else {
                if (this.wgp != null) {
                    aVar.g(1, this.wgp);
                }
                aVar.S(2, this.wgq);
                aVar.fU(3, this.ktH);
                if (this.wgr == null) {
                    return 0;
                }
                aVar.g(4, this.wgr);
                return 0;
            }
        } else if (i == 1) {
            if (this.wgp != null) {
                r0 = e.a.a.b.b.a.h(1, this.wgp) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.R(2, this.wgq)) + e.a.a.a.fR(3, this.ktH);
            if (this.wgr != null) {
                r0 += e.a.a.b.b.a.h(4, this.wgr);
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
            } else if (this.wgr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MimeType");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            vy vyVar = (vy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vyVar.wgp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    vyVar.wgq = aVar3.Avy.rz();
                    return 0;
                case 3:
                    vyVar.ktH = aVar3.Avy.ry();
                    return 0;
                case 4:
                    vyVar.wgr = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
