package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bwe extends a {
    public String username;
    public String wXe;
    public bvh wXj;
    public String wXt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wXj == null) {
                throw new b("Not all required fields were included: base_request");
            }
            if (this.wXj != null) {
                aVar.fW(1, this.wXj.bke());
                this.wXj.a(aVar);
            }
            if (this.username != null) {
                aVar.g(2, this.username);
            }
            if (this.wXe != null) {
                aVar.g(3, this.wXe);
            }
            if (this.wXt == null) {
                return 0;
            }
            aVar.g(4, this.wXt);
            return 0;
        } else if (i == 1) {
            if (this.wXj != null) {
                r0 = e.a.a.a.fT(1, this.wXj.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.username != null) {
                r0 += e.a.a.b.b.a.h(2, this.username);
            }
            if (this.wXe != null) {
                r0 += e.a.a.b.b.a.h(3, this.wXe);
            }
            if (this.wXt != null) {
                r0 += e.a.a.b.b.a.h(4, this.wXt);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wXj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: base_request");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bwe com_tencent_mm_protocal_c_bwe = (bwe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bvh = new bvh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bvh.a(aVar4, com_tencent_mm_protocal_c_bvh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bwe.wXj = com_tencent_mm_protocal_c_bvh;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bwe.username = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bwe.wXe = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bwe.wXt = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
