package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class nd extends bcv {
    public String fileid;
    public String fqR;
    public String vVX;
    public int vVY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.fileid == null) {
                throw new b("Not all required fields were included: fileid");
            } else if (this.fqR == null) {
                throw new b("Not all required fields were included: md5");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.fileid != null) {
                    aVar.g(2, this.fileid);
                }
                if (this.fqR != null) {
                    aVar.g(3, this.fqR);
                }
                if (this.vVX != null) {
                    aVar.g(4, this.vVX);
                }
                aVar.fU(5, this.vVY);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fileid != null) {
                r0 += e.a.a.b.b.a.h(2, this.fileid);
            }
            if (this.fqR != null) {
                r0 += e.a.a.b.b.a.h(3, this.fqR);
            }
            if (this.vVX != null) {
                r0 += e.a.a.b.b.a.h(4, this.vVX);
            }
            return r0 + e.a.a.a.fR(5, this.vVY);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fileid == null) {
                throw new b("Not all required fields were included: fileid");
            } else if (this.fqR != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: md5");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nd ndVar = (nd) objArr[1];
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
                        ndVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    ndVar.fileid = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ndVar.fqR = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ndVar.vVX = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ndVar.vVY = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
