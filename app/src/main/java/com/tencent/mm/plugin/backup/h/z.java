package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class z extends a {
    public String ksM;
    public LinkedList<String> ktE = new LinkedList();
    public long ktY;
    public long ktZ;
    public String kua;
    public String kub;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksM == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.kua == null) {
                throw new b("Not all required fields were included: MsgDataID");
            } else if (this.kub == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.ksM != null) {
                    aVar.g(1, this.ksM);
                }
                aVar.S(2, this.ktY);
                aVar.S(3, this.ktZ);
                if (this.kua != null) {
                    aVar.g(4, this.kua);
                }
                if (this.kub != null) {
                    aVar.g(5, this.kub);
                }
                aVar.d(6, 1, this.ktE);
                return 0;
            }
        } else if (i == 1) {
            if (this.ksM != null) {
                r0 = e.a.a.b.b.a.h(1, this.ksM) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.R(2, this.ktY)) + e.a.a.a.R(3, this.ktZ);
            if (this.kua != null) {
                r0 += e.a.a.b.b.a.h(4, this.kua);
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(5, this.kub);
            }
            return r0 + e.a.a.a.c(6, 1, this.ktE);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.ktE.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ksM == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.kua == null) {
                throw new b("Not all required fields were included: MsgDataID");
            } else if (this.kub != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            z zVar = (z) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zVar.ksM = aVar3.Avy.readString();
                    return 0;
                case 2:
                    zVar.ktY = aVar3.Avy.rz();
                    return 0;
                case 3:
                    zVar.ktZ = aVar3.Avy.rz();
                    return 0;
                case 4:
                    zVar.kua = aVar3.Avy.readString();
                    return 0;
                case 5:
                    zVar.kub = aVar3.Avy.readString();
                    return 0;
                case 6:
                    zVar.ktE.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
