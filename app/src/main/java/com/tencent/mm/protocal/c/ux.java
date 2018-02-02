package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ux extends a {
    public String fDu;
    public int fzv;
    public String label;
    public double lat;
    public double lng;
    public boolean weG = false;
    public boolean weH = false;
    public boolean weI = false;
    public boolean weJ = false;
    public boolean weK = false;

    public final ux r(double d) {
        this.lng = d;
        this.weG = true;
        return this;
    }

    public final ux s(double d) {
        this.lat = d;
        this.weH = true;
        return this;
    }

    public final ux CO(int i) {
        this.fzv = i;
        this.weI = true;
        return this;
    }

    public final ux TZ(String str) {
        this.label = str;
        this.weJ = true;
        return this;
    }

    public final ux Ua(String str) {
        this.fDu = str;
        this.weK = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.weG) {
                aVar.b(1, this.lng);
            }
            if (this.weH) {
                aVar.b(2, this.lat);
            }
            if (this.weI) {
                aVar.fU(3, this.fzv);
            }
            if (this.label != null) {
                aVar.g(4, this.label);
            }
            if (this.fDu == null) {
                return 0;
            }
            aVar.g(5, this.fDu);
            return 0;
        } else if (i == 1) {
            if (this.weG) {
                r0 = (e.a.a.b.b.a.dX(1) + 8) + 0;
            } else {
                r0 = 0;
            }
            if (this.weH) {
                r0 += e.a.a.b.b.a.dX(2) + 8;
            }
            if (this.weI) {
                r0 += e.a.a.a.fR(3, this.fzv);
            }
            if (this.label != null) {
                r0 += e.a.a.b.b.a.h(4, this.label);
            }
            if (this.fDu != null) {
                r0 += e.a.a.b.b.a.h(5, this.fDu);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ux uxVar = (ux) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uxVar.lng = aVar3.Avy.readDouble();
                    uxVar.weG = true;
                    return 0;
                case 2:
                    uxVar.lat = aVar3.Avy.readDouble();
                    uxVar.weH = true;
                    return 0;
                case 3:
                    uxVar.fzv = aVar3.Avy.ry();
                    uxVar.weI = true;
                    return 0;
                case 4:
                    uxVar.label = aVar3.Avy.readString();
                    uxVar.weJ = true;
                    return 0;
                case 5:
                    uxVar.fDu = aVar3.Avy.readString();
                    uxVar.weK = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
