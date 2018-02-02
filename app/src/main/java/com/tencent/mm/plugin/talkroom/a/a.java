package com.tencent.mm.plugin.talkroom.a;

import com.tencent.mm.protocal.c.bnh;
import e.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bq.a {
    public LinkedList<bnh> fAX = new LinkedList();
    public int sceneType;
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
            aVar.d(2, 8, this.fAX);
            aVar.fU(3, this.sceneType);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                r0 = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + e.a.a.a.c(2, 8, this.fAX)) + e.a.a.a.fR(3, this.sceneType);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.fAX.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aVar4.username = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a com_tencent_mm_protocal_c_bnh = new bnh();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bnh.a(aVar5, com_tencent_mm_protocal_c_bnh, com.tencent.mm.bq.a.a(aVar5))) {
                        }
                        aVar4.fAX.add(com_tencent_mm_protocal_c_bnh);
                    }
                    return 0;
                case 3:
                    aVar4.sceneType = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
