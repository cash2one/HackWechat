package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class atk extends a {
    public long lastUpdateTime;
    public LinkedList<kf> vYo = new LinkedList();
    public int vYp;
    public int vYq;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.vYo);
            aVar.fU(2, this.version);
            aVar.fU(3, this.vYp);
            aVar.fU(4, this.vYq);
            aVar.S(5, this.lastUpdateTime);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.c(1, 8, this.vYo) + 0) + e.a.a.a.fR(2, this.version)) + e.a.a.a.fR(3, this.vYp)) + e.a.a.a.fR(4, this.vYq)) + e.a.a.a.R(5, this.lastUpdateTime);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.vYo.clear();
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
                atk com_tencent_mm_protocal_c_atk = (atk) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a kfVar = new kf();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = kfVar.a(aVar4, kfVar, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_atk.vYo.add(kfVar);
                        }
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_atk.version = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_atk.vYp = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_atk.vYq = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_atk.lastUpdateTime = aVar3.Avy.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
