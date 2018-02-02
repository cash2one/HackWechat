package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<e> raJ = new LinkedList();
    public LinkedList<e> raK = new LinkedList();
    public LinkedList<e> raL = new LinkedList();
    public LinkedList<e> raM = new LinkedList();
    public LinkedList<f> raN = new LinkedList();
    public LinkedList<f> raO = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.raJ);
            aVar.d(2, 8, this.raK);
            aVar.d(3, 8, this.raL);
            aVar.d(4, 8, this.raM);
            aVar.d(5, 8, this.raN);
            aVar.d(6, 8, this.raO);
            return 0;
        } else if (i == 1) {
            return (((((e.a.a.a.c(1, 8, this.raJ) + 0) + e.a.a.a.c(2, 8, this.raK)) + e.a.a.a.c(3, 8, this.raL)) + e.a.a.a.c(4, 8, this.raM)) + e.a.a.a.c(5, 8, this.raN)) + e.a.a.a.c(6, 8, this.raO);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.raJ.clear();
                this.raK.clear();
                this.raL.clear();
                this.raM.clear();
                this.raN.clear();
                this.raO.clear();
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
                d dVar = (d) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList Jl;
                int size;
                a eVar;
                e.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            eVar = new e();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.raJ.add(eVar);
                        }
                        return 0;
                    case 2:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            eVar = new e();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.raK.add(eVar);
                        }
                        return 0;
                    case 3:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            eVar = new e();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.raL.add(eVar);
                        }
                        return 0;
                    case 4:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            eVar = new e();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.raM.add(eVar);
                        }
                        return 0;
                    case 5:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            eVar = new f();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.raN.add(eVar);
                        }
                        return 0;
                    case 6:
                        Jl = aVar3.Jl(intValue);
                        size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            eVar = new f();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.raO.add(eVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
