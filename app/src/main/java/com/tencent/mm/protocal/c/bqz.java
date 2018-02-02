package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bqz extends bcv {
    public double altitude;
    public int bjj;
    public double latitude;
    public double longitude;
    public double wSr;
    public double wSs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.b(2, this.latitude);
            aVar.b(3, this.longitude);
            aVar.b(4, this.altitude);
            aVar.b(5, this.wSr);
            aVar.b(6, this.wSs);
            aVar.fU(7, this.bjj);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            return (((((r0 + (e.a.a.b.b.a.dX(2) + 8)) + (e.a.a.b.b.a.dX(3) + 8)) + (e.a.a.b.b.a.dX(4) + 8)) + (e.a.a.b.b.a.dX(5) + 8)) + (e.a.a.b.b.a.dX(6) + 8)) + e.a.a.a.fR(7, this.bjj);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqz com_tencent_mm_protocal_c_bqz = (bqz) objArr[1];
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
                        com_tencent_mm_protocal_c_bqz.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqz.latitude = aVar3.Avy.readDouble();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bqz.longitude = aVar3.Avy.readDouble();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bqz.altitude = aVar3.Avy.readDouble();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bqz.wSr = aVar3.Avy.readDouble();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bqz.wSs = aVar3.Avy.readDouble();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bqz.bjj = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
