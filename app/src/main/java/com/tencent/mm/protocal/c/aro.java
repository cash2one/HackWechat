package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aro extends a {
    public bdo vGG;
    public bdo wzb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vGG == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.wzb == null) {
                throw new b("Not all required fields were included: ChatRoomTopic");
            } else {
                if (this.vGG != null) {
                    aVar.fW(1, this.vGG.bke());
                    this.vGG.a(aVar);
                }
                if (this.wzb == null) {
                    return 0;
                }
                aVar.fW(2, this.wzb.bke());
                this.wzb.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.vGG != null) {
                r0 = e.a.a.a.fT(1, this.vGG.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wzb != null) {
                r0 += e.a.a.a.fT(2, this.wzb.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vGG == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.wzb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ChatRoomTopic");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aro com_tencent_mm_protocal_c_aro = (aro) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bdo;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aro.vGG = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        com_tencent_mm_protocal_c_bdo = new bdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aro.wzb = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
