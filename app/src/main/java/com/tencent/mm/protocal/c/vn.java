package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class vn extends a {
    public String desc;
    public String info;
    public String thumbUrl;
    public String title;
    public boolean wcC = false;
    public boolean wcD = false;
    public boolean weP = false;
    public boolean weQ = false;

    public final vn Ur(String str) {
        this.title = str;
        this.wcC = true;
        return this;
    }

    public final vn Us(String str) {
        this.desc = str;
        this.wcD = true;
        return this;
    }

    public final vn Ut(String str) {
        this.thumbUrl = str;
        this.weP = true;
        return this;
    }

    public final vn Uu(String str) {
        this.info = str;
        this.weQ = true;
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
            if (this.thumbUrl != null) {
                aVar.g(3, this.thumbUrl);
            }
            if (this.info == null) {
                return 0;
            }
            aVar.g(4, this.info);
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
            if (this.thumbUrl != null) {
                r0 += e.a.a.b.b.a.h(3, this.thumbUrl);
            }
            if (this.info != null) {
                r0 += e.a.a.b.b.a.h(4, this.info);
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
            vn vnVar = (vn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vnVar.title = aVar3.Avy.readString();
                    vnVar.wcC = true;
                    return 0;
                case 2:
                    vnVar.desc = aVar3.Avy.readString();
                    vnVar.wcD = true;
                    return 0;
                case 3:
                    vnVar.thumbUrl = aVar3.Avy.readString();
                    vnVar.weP = true;
                    return 0;
                case 4:
                    vnVar.info = aVar3.Avy.readString();
                    vnVar.weQ = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
