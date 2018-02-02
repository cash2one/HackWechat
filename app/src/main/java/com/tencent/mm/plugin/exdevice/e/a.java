package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class a extends i {
    public String ksY;
    public b lOh;
    public int lOi;
    public int lOj;
    public int lOk;
    public b lOl;
    public b lOm;
    public String lOn;
    public String lOo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.lOH != null) {
                aVar.fW(1, this.lOH.bke());
                this.lOH.a(aVar);
            }
            if (this.lOh != null) {
                aVar.b(2, this.lOh);
            }
            aVar.fU(3, this.lOi);
            aVar.fU(4, this.lOj);
            aVar.fU(5, this.lOk);
            if (this.lOl != null) {
                aVar.b(6, this.lOl);
            }
            if (this.lOm != null) {
                aVar.b(7, this.lOm);
            }
            if (this.lOn != null) {
                aVar.g(10, this.lOn);
            }
            if (this.lOo != null) {
                aVar.g(11, this.lOo);
            }
            if (this.ksY == null) {
                return 0;
            }
            aVar.g(12, this.ksY);
            return 0;
        } else if (i == 1) {
            if (this.lOH != null) {
                r0 = e.a.a.a.fT(1, this.lOH.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.lOh != null) {
                r0 += e.a.a.a.a(2, this.lOh);
            }
            r0 = ((r0 + e.a.a.a.fR(3, this.lOi)) + e.a.a.a.fR(4, this.lOj)) + e.a.a.a.fR(5, this.lOk);
            if (this.lOl != null) {
                r0 += e.a.a.a.a(6, this.lOl);
            }
            if (this.lOm != null) {
                r0 += e.a.a.a.a(7, this.lOm);
            }
            if (this.lOn != null) {
                r0 += e.a.a.b.b.a.h(10, this.lOn);
            }
            if (this.lOo != null) {
                r0 += e.a.a.b.b.a.h(11, this.lOo);
            }
            if (this.ksY != null) {
                r0 += e.a.a.b.b.a.h(12, this.ksY);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = i.a(aVar2); r0 > 0; r0 = i.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a dVar = new d();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar5, dVar, i.a(aVar5))) {
                        }
                        aVar4.lOH = dVar;
                    }
                    return 0;
                case 2:
                    aVar4.lOh = aVar3.cJD();
                    return 0;
                case 3:
                    aVar4.lOi = aVar3.Avy.ry();
                    return 0;
                case 4:
                    aVar4.lOj = aVar3.Avy.ry();
                    return 0;
                case 5:
                    aVar4.lOk = aVar3.Avy.ry();
                    return 0;
                case 6:
                    aVar4.lOl = aVar3.cJD();
                    return 0;
                case 7:
                    aVar4.lOm = aVar3.cJD();
                    return 0;
                case 10:
                    aVar4.lOn = aVar3.Avy.readString();
                    return 0;
                case 11:
                    aVar4.lOo = aVar3.Avy.readString();
                    return 0;
                case 12:
                    aVar4.ksY = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
