package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.b;
import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.fd;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ac extends bcv {
    public String nfn;
    public String ngx;
    public b ngy;
    public b ngz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.nfn == null) {
                throw new e.a.a.b("Not all required fields were included: AppID");
            } else if (this.ngx == null) {
                throw new e.a.a.b("Not all required fields were included: GroupID");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.nfn != null) {
                    aVar.g(2, this.nfn);
                }
                if (this.ngx != null) {
                    aVar.g(3, this.ngx);
                }
                if (this.ngy != null) {
                    aVar.b(4, this.ngy);
                }
                if (this.ngz == null) {
                    return 0;
                }
                aVar.b(5, this.ngz);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfn != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfn);
            }
            if (this.ngx != null) {
                r0 += e.a.a.b.b.a.h(3, this.ngx);
            }
            if (this.ngy != null) {
                r0 += e.a.a.a.a(4, this.ngy);
            }
            if (this.ngz != null) {
                r0 += e.a.a.a.a(5, this.ngz);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nfn == null) {
                throw new e.a.a.b("Not all required fields were included: AppID");
            } else if (this.ngx != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: GroupID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ac acVar = (ac) objArr[1];
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
                        acVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    acVar.nfn = aVar3.Avy.readString();
                    return 0;
                case 3:
                    acVar.ngx = aVar3.Avy.readString();
                    return 0;
                case 4:
                    acVar.ngy = aVar3.cJD();
                    return 0;
                case 5:
                    acVar.ngz = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
