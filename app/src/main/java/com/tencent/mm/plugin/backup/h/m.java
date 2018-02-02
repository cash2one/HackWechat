package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class m extends a {
    public String ksX;
    public String ksY;
    public String ksZ;
    public String kta;
    public String ktb;
    public int ktc;
    public long ktd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksX == null) {
                throw new b("Not all required fields were included: DeviceID");
            } else if (this.ksY == null) {
                throw new b("Not all required fields were included: DeviceName");
            } else if (this.ksZ == null) {
                throw new b("Not all required fields were included: Model");
            } else if (this.kta == null) {
                throw new b("Not all required fields were included: SystemName");
            } else if (this.ktb == null) {
                throw new b("Not all required fields were included: SystemVersion");
            } else {
                if (this.ksX != null) {
                    aVar.g(1, this.ksX);
                }
                if (this.ksY != null) {
                    aVar.g(2, this.ksY);
                }
                if (this.ksZ != null) {
                    aVar.g(3, this.ksZ);
                }
                if (this.kta != null) {
                    aVar.g(4, this.kta);
                }
                if (this.ktb != null) {
                    aVar.g(5, this.ktb);
                }
                aVar.fU(6, this.ktc);
                aVar.S(7, this.ktd);
                return 0;
            }
        } else if (i == 1) {
            if (this.ksX != null) {
                r0 = e.a.a.b.b.a.h(1, this.ksX) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksY != null) {
                r0 += e.a.a.b.b.a.h(2, this.ksY);
            }
            if (this.ksZ != null) {
                r0 += e.a.a.b.b.a.h(3, this.ksZ);
            }
            if (this.kta != null) {
                r0 += e.a.a.b.b.a.h(4, this.kta);
            }
            if (this.ktb != null) {
                r0 += e.a.a.b.b.a.h(5, this.ktb);
            }
            return (r0 + e.a.a.a.fR(6, this.ktc)) + e.a.a.a.R(7, this.ktd);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ksX == null) {
                throw new b("Not all required fields were included: DeviceID");
            } else if (this.ksY == null) {
                throw new b("Not all required fields were included: DeviceName");
            } else if (this.ksZ == null) {
                throw new b("Not all required fields were included: Model");
            } else if (this.kta == null) {
                throw new b("Not all required fields were included: SystemName");
            } else if (this.ktb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SystemVersion");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.ksX = aVar3.Avy.readString();
                    return 0;
                case 2:
                    mVar.ksY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    mVar.ksZ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    mVar.kta = aVar3.Avy.readString();
                    return 0;
                case 5:
                    mVar.ktb = aVar3.Avy.readString();
                    return 0;
                case 6:
                    mVar.ktc = aVar3.Avy.ry();
                    return 0;
                case 7:
                    mVar.ktd = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
