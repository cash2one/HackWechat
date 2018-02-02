package com.tencent.mm.y;

import com.tencent.mm.bq.a;

public final class m extends a {
    public String heb;
    public String hec;
    public String hed;
    public String hee;
    public String hef;
    public int heg;
    public int heh;
    public String hei;
    public String hej;
    public int hek;
    public int hel;
    public String hem;
    public String hen;
    public String heo;
    public String hep;
    public String heq;
    public String her;
    public int hes;
    public int het;
    public long time;
    public String title;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.heb != null) {
                aVar.g(3, this.heb);
            }
            if (this.hec != null) {
                aVar.g(4, this.hec);
            }
            aVar.S(5, this.time);
            if (this.hed != null) {
                aVar.g(6, this.hed);
            }
            if (this.hee != null) {
                aVar.g(7, this.hee);
            }
            if (this.hef != null) {
                aVar.g(8, this.hef);
            }
            aVar.fU(9, this.type);
            aVar.fU(10, this.heg);
            aVar.fU(11, this.heh);
            if (this.hei != null) {
                aVar.g(12, this.hei);
            }
            if (this.hej != null) {
                aVar.g(13, this.hej);
            }
            aVar.fU(14, this.hek);
            aVar.fU(15, this.hel);
            if (this.hem != null) {
                aVar.g(16, this.hem);
            }
            if (this.hen != null) {
                aVar.g(17, this.hen);
            }
            if (this.heo != null) {
                aVar.g(18, this.heo);
            }
            if (this.hep != null) {
                aVar.g(19, this.hep);
            }
            if (this.heq != null) {
                aVar.g(20, this.heq);
            }
            if (this.her != null) {
                aVar.g(21, this.her);
            }
            aVar.fU(22, this.hes);
            aVar.fU(23, this.het);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(2, this.url);
            }
            if (this.heb != null) {
                r0 += e.a.a.b.b.a.h(3, this.heb);
            }
            if (this.hec != null) {
                r0 += e.a.a.b.b.a.h(4, this.hec);
            }
            r0 += e.a.a.a.R(5, this.time);
            if (this.hed != null) {
                r0 += e.a.a.b.b.a.h(6, this.hed);
            }
            if (this.hee != null) {
                r0 += e.a.a.b.b.a.h(7, this.hee);
            }
            if (this.hef != null) {
                r0 += e.a.a.b.b.a.h(8, this.hef);
            }
            r0 = ((r0 + e.a.a.a.fR(9, this.type)) + e.a.a.a.fR(10, this.heg)) + e.a.a.a.fR(11, this.heh);
            if (this.hei != null) {
                r0 += e.a.a.b.b.a.h(12, this.hei);
            }
            if (this.hej != null) {
                r0 += e.a.a.b.b.a.h(13, this.hej);
            }
            r0 = (r0 + e.a.a.a.fR(14, this.hek)) + e.a.a.a.fR(15, this.hel);
            if (this.hem != null) {
                r0 += e.a.a.b.b.a.h(16, this.hem);
            }
            if (this.hen != null) {
                r0 += e.a.a.b.b.a.h(17, this.hen);
            }
            if (this.heo != null) {
                r0 += e.a.a.b.b.a.h(18, this.heo);
            }
            if (this.hep != null) {
                r0 += e.a.a.b.b.a.h(19, this.hep);
            }
            if (this.heq != null) {
                r0 += e.a.a.b.b.a.h(20, this.heq);
            }
            if (this.her != null) {
                r0 += e.a.a.b.b.a.h(21, this.her);
            }
            return (r0 + e.a.a.a.fR(22, this.hes)) + e.a.a.a.fR(23, this.het);
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
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.title = aVar3.Avy.readString();
                    return 0;
                case 2:
                    mVar.url = aVar3.Avy.readString();
                    return 0;
                case 3:
                    mVar.heb = aVar3.Avy.readString();
                    return 0;
                case 4:
                    mVar.hec = aVar3.Avy.readString();
                    return 0;
                case 5:
                    mVar.time = aVar3.Avy.rz();
                    return 0;
                case 6:
                    mVar.hed = aVar3.Avy.readString();
                    return 0;
                case 7:
                    mVar.hee = aVar3.Avy.readString();
                    return 0;
                case 8:
                    mVar.hef = aVar3.Avy.readString();
                    return 0;
                case 9:
                    mVar.type = aVar3.Avy.ry();
                    return 0;
                case 10:
                    mVar.heg = aVar3.Avy.ry();
                    return 0;
                case 11:
                    mVar.heh = aVar3.Avy.ry();
                    return 0;
                case 12:
                    mVar.hei = aVar3.Avy.readString();
                    return 0;
                case 13:
                    mVar.hej = aVar3.Avy.readString();
                    return 0;
                case 14:
                    mVar.hek = aVar3.Avy.ry();
                    return 0;
                case 15:
                    mVar.hel = aVar3.Avy.ry();
                    return 0;
                case 16:
                    mVar.hem = aVar3.Avy.readString();
                    return 0;
                case 17:
                    mVar.hen = aVar3.Avy.readString();
                    return 0;
                case 18:
                    mVar.heo = aVar3.Avy.readString();
                    return 0;
                case 19:
                    mVar.hep = aVar3.Avy.readString();
                    return 0;
                case 20:
                    mVar.heq = aVar3.Avy.readString();
                    return 0;
                case 21:
                    mVar.her = aVar3.Avy.readString();
                    return 0;
                case 22:
                    mVar.hes = aVar3.Avy.ry();
                    return 0;
                case 23:
                    mVar.het = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
