package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class jj extends a {
    public int ktN;
    public jd vPF;
    public jc vPG;
    public long vPH;
    public ji vPI;
    public jl vPJ;
    public jh vPK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ktN);
            if (this.vPF != null) {
                aVar.fW(2, this.vPF.bke());
                this.vPF.a(aVar);
            }
            if (this.vPG != null) {
                aVar.fW(3, this.vPG.bke());
                this.vPG.a(aVar);
            }
            aVar.S(4, this.vPH);
            if (this.vPI != null) {
                aVar.fW(5, this.vPI.bke());
                this.vPI.a(aVar);
            }
            if (this.vPJ != null) {
                aVar.fW(6, this.vPJ.bke());
                this.vPJ.a(aVar);
            }
            if (this.vPK != null) {
                aVar.fW(7, this.vPK.bke());
                this.vPK.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.ktN) + 0;
            if (this.vPF != null) {
                r0 += e.a.a.a.fT(2, this.vPF.bke());
            }
            if (this.vPG != null) {
                r0 += e.a.a.a.fT(3, this.vPG.bke());
            }
            r0 += e.a.a.a.R(4, this.vPH);
            if (this.vPI != null) {
                r0 += e.a.a.a.fT(5, this.vPI.bke());
            }
            if (this.vPJ != null) {
                r0 += e.a.a.a.fT(6, this.vPJ.bke());
            }
            if (this.vPK != null) {
                return r0 + e.a.a.a.fT(7, this.vPK.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            jj jjVar = (jj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a jdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jjVar.ktN = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        jdVar = new jd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jdVar.a(aVar4, jdVar, a.a(aVar4))) {
                        }
                        jjVar.vPF = jdVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        jdVar = new jc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jdVar.a(aVar4, jdVar, a.a(aVar4))) {
                        }
                        jjVar.vPG = jdVar;
                    }
                    return 0;
                case 4:
                    jjVar.vPH = aVar3.Avy.rz();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        jdVar = new ji();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jdVar.a(aVar4, jdVar, a.a(aVar4))) {
                        }
                        jjVar.vPI = jdVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        jdVar = new jl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jdVar.a(aVar4, jdVar, a.a(aVar4))) {
                        }
                        jjVar.vPJ = jdVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        jdVar = new jh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jdVar.a(aVar4, jdVar, a.a(aVar4))) {
                        }
                        jjVar.vPK = jdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
