package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class vt extends a {
    public String canvasPageXml;
    public String desc;
    public int hbg;
    public String thumbUrl;
    public String title;
    public boolean wcC = false;
    public boolean wcD = false;
    public boolean wdO = false;
    public boolean weP = false;
    public boolean wfA = false;
    public int wfB;
    public boolean wfC = false;
    public boolean wfD = false;
    public String wfz;

    public final vt Uv(String str) {
        this.title = str;
        this.wcC = true;
        return this;
    }

    public final vt Uw(String str) {
        this.desc = str;
        this.wcD = true;
        return this;
    }

    public final vt Ux(String str) {
        this.wfz = str;
        this.wfA = true;
        return this;
    }

    public final vt Uy(String str) {
        this.thumbUrl = str;
        this.weP = true;
        return this;
    }

    public final vt CT(int i) {
        this.wfB = i;
        this.wfC = true;
        return this;
    }

    public final vt CU(int i) {
        this.hbg = i;
        this.wfD = true;
        return this;
    }

    public final vt Uz(String str) {
        this.canvasPageXml = str;
        this.wdO = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            if (this.wfz != null) {
                aVar.g(3, this.wfz);
            }
            if (this.thumbUrl != null) {
                aVar.g(4, this.thumbUrl);
            }
            if (this.wfC) {
                aVar.fU(5, this.wfB);
            }
            if (this.wfD) {
                aVar.fU(6, this.hbg);
            }
            if (this.canvasPageXml == null) {
                return 0;
            }
            aVar.g(7, this.canvasPageXml);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(2, this.desc);
            }
            if (this.wfz != null) {
                r0 += e.a.a.b.b.a.h(3, this.wfz);
            }
            if (this.thumbUrl != null) {
                r0 += e.a.a.b.b.a.h(4, this.thumbUrl);
            }
            if (this.wfC) {
                r0 += e.a.a.a.fR(5, this.wfB);
            }
            if (this.wfD) {
                r0 += e.a.a.a.fR(6, this.hbg);
            }
            if (this.canvasPageXml != null) {
                r0 += e.a.a.b.b.a.h(7, this.canvasPageXml);
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
            vt vtVar = (vt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vtVar.title = aVar3.Avy.readString();
                    vtVar.wcC = true;
                    return 0;
                case 2:
                    vtVar.desc = aVar3.Avy.readString();
                    vtVar.wcD = true;
                    return 0;
                case 3:
                    vtVar.wfz = aVar3.Avy.readString();
                    vtVar.wfA = true;
                    return 0;
                case 4:
                    vtVar.thumbUrl = aVar3.Avy.readString();
                    vtVar.weP = true;
                    return 0;
                case 5:
                    vtVar.wfB = aVar3.Avy.ry();
                    vtVar.wfC = true;
                    return 0;
                case 6:
                    vtVar.hbg = aVar3.Avy.ry();
                    vtVar.wfD = true;
                    return 0;
                case 7:
                    vtVar.canvasPageXml = aVar3.Avy.readString();
                    vtVar.wdO = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
