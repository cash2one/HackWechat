package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class af extends a {
    public String ksM;
    public LinkedList<Long> kuj = new LinkedList();
    public LinkedList<String> kuk = new LinkedList();
    public LinkedList<String> kul = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksM == null) {
                throw new b("Not all required fields were included: BakChatName");
            }
            aVar.d(1, 3, this.kuj);
            aVar.d(2, 1, this.kuk);
            aVar.d(3, 1, this.kul);
            if (this.ksM != null) {
                aVar.g(4, this.ksM);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.c(1, 3, this.kuj) + 0) + e.a.a.a.c(2, 1, this.kuk)) + e.a.a.a.c(3, 1, this.kul);
            if (this.ksM != null) {
                return r0 + e.a.a.b.b.a.h(4, this.ksM);
            }
            return r0;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.kuj.clear();
            this.kuk.clear();
            this.kul.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ksM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BakChatName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            af afVar = (af) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    afVar.kuj.add(Long.valueOf(aVar3.Avy.rz()));
                    return 0;
                case 2:
                    afVar.kuk.add(aVar3.Avy.readString());
                    return 0;
                case 3:
                    afVar.kul.add(aVar3.Avy.readString());
                    return 0;
                case 4:
                    afVar.ksM = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
