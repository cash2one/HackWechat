package com.tencent.mm.plugin.exdevice.e;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class g extends j {
    public String ksZ;
    public String lOA;
    public int lOB;
    public String lOC;
    public int lOD;
    public int lOE;
    public String lOF;
    public int lOv;
    public int lOw;
    public int lOx;
    public int lOy;
    public int lOz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.lOI == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.lOI != null) {
                aVar.fW(1, this.lOI.bke());
                this.lOI.a(aVar);
            }
            aVar.fU(2, this.lOv);
            aVar.fU(3, this.lOw);
            aVar.fU(4, this.lOx);
            aVar.fU(5, this.lOy);
            aVar.fU(6, this.lOz);
            if (this.lOA != null) {
                aVar.g(11, this.lOA);
            }
            aVar.fU(12, this.lOB);
            if (this.ksZ != null) {
                aVar.g(13, this.ksZ);
            }
            if (this.lOC != null) {
                aVar.g(14, this.lOC);
            }
            aVar.fU(15, this.lOD);
            aVar.fU(16, this.lOE);
            if (this.lOF == null) {
                return 0;
            }
            aVar.g(17, this.lOF);
            return 0;
        } else if (i == 1) {
            if (this.lOI != null) {
                r0 = e.a.a.a.fT(1, this.lOI.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + e.a.a.a.fR(2, this.lOv)) + e.a.a.a.fR(3, this.lOw)) + e.a.a.a.fR(4, this.lOx)) + e.a.a.a.fR(5, this.lOy)) + e.a.a.a.fR(6, this.lOz);
            if (this.lOA != null) {
                r0 += e.a.a.b.b.a.h(11, this.lOA);
            }
            r0 += e.a.a.a.fR(12, this.lOB);
            if (this.ksZ != null) {
                r0 += e.a.a.b.b.a.h(13, this.ksZ);
            }
            if (this.lOC != null) {
                r0 += e.a.a.b.b.a.h(14, this.lOC);
            }
            r0 = (r0 + e.a.a.a.fR(15, this.lOD)) + e.a.a.a.fR(16, this.lOE);
            if (this.lOF != null) {
                r0 += e.a.a.b.b.a.h(17, this.lOF);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = j.a(aVar2); r0 > 0; r0 = j.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.lOI != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, j.a(aVar4))) {
                        }
                        gVar.lOI = eVar;
                    }
                    return 0;
                case 2:
                    gVar.lOv = aVar3.Avy.ry();
                    return 0;
                case 3:
                    gVar.lOw = aVar3.Avy.ry();
                    return 0;
                case 4:
                    gVar.lOx = aVar3.Avy.ry();
                    return 0;
                case 5:
                    gVar.lOy = aVar3.Avy.ry();
                    return 0;
                case 6:
                    gVar.lOz = aVar3.Avy.ry();
                    return 0;
                case 11:
                    gVar.lOA = aVar3.Avy.readString();
                    return 0;
                case 12:
                    gVar.lOB = aVar3.Avy.ry();
                    return 0;
                case 13:
                    gVar.ksZ = aVar3.Avy.readString();
                    return 0;
                case 14:
                    gVar.lOC = aVar3.Avy.readString();
                    return 0;
                case 15:
                    gVar.lOD = aVar3.Avy.ry();
                    return 0;
                case 16:
                    gVar.lOE = aVar3.Avy.ry();
                    return 0;
                case 17:
                    gVar.lOF = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
