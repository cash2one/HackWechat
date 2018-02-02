package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afe extends bcv {
    public int Height;
    public String URL;
    public int Width;
    public String wnd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.URL == null) {
                throw new b("Not all required fields were included: URL");
            } else if (this.wnd == null) {
                throw new b("Not all required fields were included: UserAgent");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.URL != null) {
                    aVar.g(2, this.URL);
                }
                if (this.wnd != null) {
                    aVar.g(3, this.wnd);
                }
                aVar.fU(4, this.Width);
                aVar.fU(5, this.Height);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.URL != null) {
                r0 += e.a.a.b.b.a.h(2, this.URL);
            }
            if (this.wnd != null) {
                r0 += e.a.a.b.b.a.h(3, this.wnd);
            }
            return (r0 + e.a.a.a.fR(4, this.Width)) + e.a.a.a.fR(5, this.Height);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.URL == null) {
                throw new b("Not all required fields were included: URL");
            } else if (this.wnd != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: UserAgent");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afe com_tencent_mm_protocal_c_afe = (afe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afe.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afe.URL = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afe.wnd = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afe.Width = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afe.Height = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
