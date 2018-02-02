package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class b extends a {
    public int nettype;
    public int uin;
    public int vCb;
    public LinkedList<a> vCc = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.uin);
            aVar.fU(2, this.vCb);
            aVar.d(3, 8, this.vCc);
            aVar.fU(4, this.nettype);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fR(1, this.uin) + 0) + e.a.a.a.fR(2, this.vCb)) + e.a.a.a.c(3, 8, this.vCc)) + e.a.a.a.fR(4, this.nettype);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.vCc.clear();
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
                b bVar = (b) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        bVar.uin = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        bVar.vCb = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a aVar4 = new a();
                            e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                            }
                            bVar.vCc.add(aVar4);
                        }
                        return 0;
                    case 4:
                        bVar.nettype = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
