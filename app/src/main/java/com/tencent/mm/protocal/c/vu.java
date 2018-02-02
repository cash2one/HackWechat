package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class vu extends a {
    public String pKc;
    public LinkedList<vv> vON = new LinkedList();
    public String vUk;
    public String wfE;
    public long wfF;
    public long wfG;
    public String wfH;
    public long wfI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wfE != null) {
                aVar.g(1, this.wfE);
            }
            aVar.d(2, 8, this.vON);
            aVar.S(3, this.wfF);
            aVar.S(4, this.wfG);
            if (this.wfH != null) {
                aVar.g(5, this.wfH);
            }
            if (this.pKc != null) {
                aVar.g(6, this.pKc);
            }
            aVar.S(7, this.wfI);
            if (this.vUk == null) {
                return 0;
            }
            aVar.g(8, this.vUk);
            return 0;
        } else if (i == 1) {
            if (this.wfE != null) {
                r0 = e.a.a.b.b.a.h(1, this.wfE) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.c(2, 8, this.vON)) + e.a.a.a.R(3, this.wfF)) + e.a.a.a.R(4, this.wfG);
            if (this.wfH != null) {
                r0 += e.a.a.b.b.a.h(5, this.wfH);
            }
            if (this.pKc != null) {
                r0 += e.a.a.b.b.a.h(6, this.pKc);
            }
            r0 += e.a.a.a.R(7, this.wfI);
            if (this.vUk != null) {
                r0 += e.a.a.b.b.a.h(8, this.vUk);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vON.clear();
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
            vu vuVar = (vu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    vuVar.wfE = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a vvVar = new vv();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = vvVar.a(aVar4, vvVar, a.a(aVar4))) {
                        }
                        vuVar.vON.add(vvVar);
                    }
                    return 0;
                case 3:
                    vuVar.wfF = aVar3.Avy.rz();
                    return 0;
                case 4:
                    vuVar.wfG = aVar3.Avy.rz();
                    return 0;
                case 5:
                    vuVar.wfH = aVar3.Avy.readString();
                    return 0;
                case 6:
                    vuVar.pKc = aVar3.Avy.readString();
                    return 0;
                case 7:
                    vuVar.wfI = aVar3.Avy.rz();
                    return 0;
                case 8:
                    vuVar.vUk = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
