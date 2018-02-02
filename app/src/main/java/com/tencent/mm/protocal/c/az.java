package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class az extends bcv {
    public String bssid;
    public int cOY;
    public String hOt;
    public int hOx;
    public int scene;
    public String ssid;
    public String vGc;
    public long vGd;
    public bk vGe;
    public int vGf;
    public int vGg;
    public String vGh;
    public int vGi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.hOt != null) {
                aVar.g(2, this.hOt);
            }
            aVar.fU(3, this.hOx);
            if (this.vGc != null) {
                aVar.g(4, this.vGc);
            }
            aVar.fU(5, this.scene);
            if (this.ssid != null) {
                aVar.g(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.g(7, this.bssid);
            }
            aVar.S(8, this.vGd);
            if (this.vGe != null) {
                aVar.fW(9, this.vGe.bke());
                this.vGe.a(aVar);
            }
            aVar.fU(10, this.vGf);
            aVar.fU(11, this.vGg);
            aVar.fU(12, this.cOY);
            if (this.vGh != null) {
                aVar.g(13, this.vGh);
            }
            aVar.fU(14, this.vGi);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.hOt != null) {
                r0 += e.a.a.b.b.a.h(2, this.hOt);
            }
            r0 += e.a.a.a.fR(3, this.hOx);
            if (this.vGc != null) {
                r0 += e.a.a.b.b.a.h(4, this.vGc);
            }
            r0 += e.a.a.a.fR(5, this.scene);
            if (this.ssid != null) {
                r0 += e.a.a.b.b.a.h(6, this.ssid);
            }
            if (this.bssid != null) {
                r0 += e.a.a.b.b.a.h(7, this.bssid);
            }
            r0 += e.a.a.a.R(8, this.vGd);
            if (this.vGe != null) {
                r0 += e.a.a.a.fT(9, this.vGe.bke());
            }
            r0 = ((r0 + e.a.a.a.fR(10, this.vGf)) + e.a.a.a.fR(11, this.vGg)) + e.a.a.a.fR(12, this.cOY);
            if (this.vGh != null) {
                r0 += e.a.a.b.b.a.h(13, this.vGh);
            }
            return r0 + e.a.a.a.fR(14, this.vGi);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            az azVar = (az) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        azVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    azVar.hOt = aVar3.Avy.readString();
                    return 0;
                case 3:
                    azVar.hOx = aVar3.Avy.ry();
                    return 0;
                case 4:
                    azVar.vGc = aVar3.Avy.readString();
                    return 0;
                case 5:
                    azVar.scene = aVar3.Avy.ry();
                    return 0;
                case 6:
                    azVar.ssid = aVar3.Avy.readString();
                    return 0;
                case 7:
                    azVar.bssid = aVar3.Avy.readString();
                    return 0;
                case 8:
                    azVar.vGd = aVar3.Avy.rz();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        azVar.vGe = fdVar;
                    }
                    return 0;
                case 10:
                    azVar.vGf = aVar3.Avy.ry();
                    return 0;
                case 11:
                    azVar.vGg = aVar3.Avy.ry();
                    return 0;
                case 12:
                    azVar.cOY = aVar3.Avy.ry();
                    return 0;
                case 13:
                    azVar.vGh = aVar3.Avy.readString();
                    return 0;
                case 14:
                    azVar.vGi = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
