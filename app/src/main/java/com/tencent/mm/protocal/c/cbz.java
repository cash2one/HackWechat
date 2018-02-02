package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class cbz extends a {
    public int score;
    public String username;
    public int xaW;
    public int xaX;
    public int xaY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            }
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.fU(2, this.score);
            aVar.fU(3, this.xaW);
            aVar.fU(4, this.xaX);
            aVar.fU(5, this.xaY);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                r0 = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + e.a.a.a.fR(2, this.score)) + e.a.a.a.fR(3, this.xaW)) + e.a.a.a.fR(4, this.xaX)) + e.a.a.a.fR(5, this.xaY);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
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
            cbz com_tencent_mm_protocal_c_cbz = (cbz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_cbz.username = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_cbz.score = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_cbz.xaW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_cbz.xaX = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_cbz.xaY = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
