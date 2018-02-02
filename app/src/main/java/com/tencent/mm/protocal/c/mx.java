package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class mx extends a {
    public int rYW;
    public LinkedList<uw> vVI = new LinkedList();
    public vh vVJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.vVI);
            aVar.fU(2, this.rYW);
            if (this.vVJ != null) {
                aVar.fW(3, this.vVJ.bke());
                this.vVJ.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.c(1, 8, this.vVI) + 0) + e.a.a.a.fR(2, this.rYW);
            if (this.vVJ != null) {
                return r0 + e.a.a.a.fT(3, this.vVJ.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vVI.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mx mxVar = (mx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a uwVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        uwVar = new uw();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = uwVar.a(aVar4, uwVar, a.a(aVar4))) {
                        }
                        mxVar.vVI.add(uwVar);
                    }
                    return 0;
                case 2:
                    mxVar.rYW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        uwVar = new vh();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = uwVar.a(aVar4, uwVar, a.a(aVar4))) {
                        }
                        mxVar.vVJ = uwVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
