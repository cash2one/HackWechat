package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class be extends bcv {
    public String bssid;
    public int cOY;
    public String hOt;
    public int scene;
    public String ssid;
    public int type;
    public String vGc;
    public long vGd;
    public int vGf;
    public String vGh;
    public int vGi;
    public int vGr;
    public bd vGs;
    public bg vGt;
    public int vGu;
    public int vGv;
    public int vGw;

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
            aVar.fU(3, this.scene);
            aVar.fU(4, this.type);
            aVar.fU(5, this.vGr);
            if (this.ssid != null) {
                aVar.g(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.g(7, this.bssid);
            }
            aVar.S(8, this.vGd);
            if (this.vGs != null) {
                aVar.fW(9, this.vGs.bke());
                this.vGs.a(aVar);
            }
            if (this.vGt != null) {
                aVar.fW(10, this.vGt.bke());
                this.vGt.a(aVar);
            }
            aVar.fU(11, this.vGf);
            if (this.vGc != null) {
                aVar.g(12, this.vGc);
            }
            aVar.fU(13, this.cOY);
            if (this.vGh != null) {
                aVar.g(14, this.vGh);
            }
            aVar.fU(15, this.vGu);
            aVar.fU(16, this.vGv);
            aVar.fU(17, this.vGw);
            aVar.fU(18, this.vGi);
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
            r0 = ((r0 + e.a.a.a.fR(3, this.scene)) + e.a.a.a.fR(4, this.type)) + e.a.a.a.fR(5, this.vGr);
            if (this.ssid != null) {
                r0 += e.a.a.b.b.a.h(6, this.ssid);
            }
            if (this.bssid != null) {
                r0 += e.a.a.b.b.a.h(7, this.bssid);
            }
            r0 += e.a.a.a.R(8, this.vGd);
            if (this.vGs != null) {
                r0 += e.a.a.a.fT(9, this.vGs.bke());
            }
            if (this.vGt != null) {
                r0 += e.a.a.a.fT(10, this.vGt.bke());
            }
            r0 += e.a.a.a.fR(11, this.vGf);
            if (this.vGc != null) {
                r0 += e.a.a.b.b.a.h(12, this.vGc);
            }
            r0 += e.a.a.a.fR(13, this.cOY);
            if (this.vGh != null) {
                r0 += e.a.a.b.b.a.h(14, this.vGh);
            }
            return (((r0 + e.a.a.a.fR(15, this.vGu)) + e.a.a.a.fR(16, this.vGv)) + e.a.a.a.fR(17, this.vGw)) + e.a.a.a.fR(18, this.vGi);
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
            be beVar = (be) objArr[1];
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
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        beVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    beVar.hOt = aVar3.Avy.readString();
                    return 0;
                case 3:
                    beVar.scene = aVar3.Avy.ry();
                    return 0;
                case 4:
                    beVar.type = aVar3.Avy.ry();
                    return 0;
                case 5:
                    beVar.vGr = aVar3.Avy.ry();
                    return 0;
                case 6:
                    beVar.ssid = aVar3.Avy.readString();
                    return 0;
                case 7:
                    beVar.bssid = aVar3.Avy.readString();
                    return 0;
                case 8:
                    beVar.vGd = aVar3.Avy.rz();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        beVar.vGs = fdVar;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        beVar.vGt = fdVar;
                    }
                    return 0;
                case 11:
                    beVar.vGf = aVar3.Avy.ry();
                    return 0;
                case 12:
                    beVar.vGc = aVar3.Avy.readString();
                    return 0;
                case 13:
                    beVar.cOY = aVar3.Avy.ry();
                    return 0;
                case 14:
                    beVar.vGh = aVar3.Avy.readString();
                    return 0;
                case 15:
                    beVar.vGu = aVar3.Avy.ry();
                    return 0;
                case 16:
                    beVar.vGv = aVar3.Avy.ry();
                    return 0;
                case 17:
                    beVar.vGw = aVar3.Avy.ry();
                    return 0;
                case 18:
                    beVar.vGi = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
