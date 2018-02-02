package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class vr extends a {
    public LinkedList<String> wfi = new LinkedList();
    public LinkedList<String> wfj = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.wfi);
            aVar.d(2, 1, this.wfj);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 1, this.wfi) + 0) + e.a.a.a.c(2, 1, this.wfj);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.wfi.clear();
                this.wfj.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                vr vrVar = (vr) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        vrVar.wfi.add(aVar3.Avy.readString());
                        return 0;
                    case 2:
                        vrVar.wfj.add(aVar3.Avy.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
