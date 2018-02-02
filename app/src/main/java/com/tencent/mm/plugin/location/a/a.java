package com.tencent.mm.plugin.location.a;

import e.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bq.a {
    public LinkedList<String> fAX = new LinkedList();
    public double latitude;
    public double longitude;
    public String nQt;
    public long timestamp;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            }
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.d(2, 1, this.fAX);
            aVar.b(3, this.longitude);
            aVar.b(4, this.latitude);
            if (this.nQt != null) {
                aVar.g(5, this.nQt);
            }
            aVar.S(6, this.timestamp);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                r0 = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.c(2, 1, this.fAX)) + (e.a.a.b.b.a.dX(3) + 8)) + (e.a.a.b.b.a.dX(4) + 8);
            if (this.nQt != null) {
                r0 += e.a.a.b.b.a.h(5, this.nQt);
            }
            return r0 + e.a.a.a.R(6, this.timestamp);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.fAX.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.username != null) {
                return 0;
            }
            throw new b("Not all required fields were included: username");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.username = aVar3.Avy.readString();
                    return 0;
                case 2:
                    aVar4.fAX.add(aVar3.Avy.readString());
                    return 0;
                case 3:
                    aVar4.longitude = aVar3.Avy.readDouble();
                    return 0;
                case 4:
                    aVar4.latitude = aVar3.Avy.readDouble();
                    return 0;
                case 5:
                    aVar4.nQt = aVar3.Avy.readString();
                    return 0;
                case 6:
                    aVar4.timestamp = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
