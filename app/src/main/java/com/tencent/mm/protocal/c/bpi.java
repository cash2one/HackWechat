package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bpi extends bcv {
    public String devicetype;
    public String gfN;
    public String oWG;
    public int wRw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.devicetype == null) {
                throw new b("Not all required fields were included: devicetype");
            } else if (this.oWG == null) {
                throw new b("Not all required fields were included: deviceid");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.devicetype != null) {
                    aVar.g(2, this.devicetype);
                }
                if (this.oWG != null) {
                    aVar.g(3, this.oWG);
                }
                if (this.gfN != null) {
                    aVar.g(4, this.gfN);
                }
                aVar.fU(5, this.wRw);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.devicetype != null) {
                r0 += e.a.a.b.b.a.h(2, this.devicetype);
            }
            if (this.oWG != null) {
                r0 += e.a.a.b.b.a.h(3, this.oWG);
            }
            if (this.gfN != null) {
                r0 += e.a.a.b.b.a.h(4, this.gfN);
            }
            return r0 + e.a.a.a.fR(5, this.wRw);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.devicetype == null) {
                throw new b("Not all required fields were included: devicetype");
            } else if (this.oWG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: deviceid");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpi com_tencent_mm_protocal_c_bpi = (bpi) objArr[1];
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
                        com_tencent_mm_protocal_c_bpi.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bpi.devicetype = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bpi.oWG = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bpi.gfN = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bpi.wRw = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
