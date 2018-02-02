package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.av;

public final class a$bb extends e {
    public String groupId;
    public int slB;
    public long slC;
    public int zMR;
    public av[] zOe;
    public String zPs;
    public int zQc;
    public String zQd;
    public String[] zQe;
    public long zQf;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            int b;
            Object obj;
            switch (rx) {
                case 0:
                    break;
                case 10:
                    this.groupId = aVar.readString();
                    continue;
                case 16:
                    this.slB = aVar.ry();
                    continue;
                case 24:
                    this.slC = aVar.rz();
                    continue;
                case 32:
                    this.zMR = aVar.ry();
                    continue;
                case 40:
                    this.zQc = aVar.ry();
                    continue;
                case 50:
                    this.zPs = aVar.readString();
                    continue;
                case 58:
                    b = g.b(aVar, 58);
                    rx = this.zOe == null ? 0 : this.zOe.length;
                    obj = new av[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zOe, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new av();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new av();
                    aVar.a(obj[rx]);
                    this.zOe = obj;
                    continue;
                case 66:
                    this.zQd = aVar.readString();
                    continue;
                case 74:
                    b = g.b(aVar, 74);
                    rx = this.zQe == null ? 0 : this.zQe.length;
                    obj = new String[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zQe, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = aVar.readString();
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = aVar.readString();
                    this.zQe = obj;
                    continue;
                case 80:
                    this.zQf = aVar.rz();
                    continue;
                default:
                    if (!g.a(aVar, rx)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public a$bb() {
        this.groupId = "";
        this.slB = 0;
        this.slC = 0;
        this.zMR = 0;
        this.zQc = 0;
        this.zPs = "";
        this.zOe = av.cCQ();
        this.zQd = "";
        this.zQe = g.EMPTY_STRING_ARRAY;
        this.zQf = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        int i = 0;
        if (!this.groupId.equals("")) {
            bVar.g(1, this.groupId);
        }
        if (this.slB != 0) {
            bVar.aB(2, this.slB);
        }
        if (this.slC != 0) {
            bVar.k(3, this.slC);
        }
        if (this.zMR != 0) {
            bVar.aC(4, this.zMR);
        }
        if (this.zQc != 0) {
            bVar.aB(5, this.zQc);
        }
        if (!this.zPs.equals("")) {
            bVar.g(6, this.zPs);
        }
        if (this.zOe != null && this.zOe.length > 0) {
            for (e eVar : this.zOe) {
                if (eVar != null) {
                    bVar.a(7, eVar);
                }
            }
        }
        if (!this.zQd.equals("")) {
            bVar.g(8, this.zQd);
        }
        if (this.zQe != null && this.zQe.length > 0) {
            while (i < this.zQe.length) {
                String str = this.zQe[i];
                if (str != null) {
                    bVar.g(9, str);
                }
                i++;
            }
        }
        if (this.zQf != 0) {
            bVar.j(10, this.zQf);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int i;
        int i2 = 0;
        int rL = super.rL();
        if (!this.groupId.equals("")) {
            rL += b.h(1, this.groupId);
        }
        if (this.slB != 0) {
            rL += b.aD(2, this.slB);
        }
        if (this.slC != 0) {
            rL += b.m(3, this.slC);
        }
        if (this.zMR != 0) {
            rL += b.aE(4, this.zMR);
        }
        if (this.zQc != 0) {
            rL += b.aD(5, this.zQc);
        }
        if (!this.zPs.equals("")) {
            rL += b.h(6, this.zPs);
        }
        if (this.zOe != null && this.zOe.length > 0) {
            i = rL;
            for (e eVar : this.zOe) {
                if (eVar != null) {
                    i += b.b(7, eVar);
                }
            }
            rL = i;
        }
        if (!this.zQd.equals("")) {
            rL += b.h(8, this.zQd);
        }
        if (this.zQe != null && this.zQe.length > 0) {
            i = 0;
            int i3 = 0;
            while (i2 < this.zQe.length) {
                String str = this.zQe[i2];
                if (str != null) {
                    i3++;
                    i += b.bm(str);
                }
                i2++;
            }
            rL = (rL + i) + (i3 * 1);
        }
        if (this.zQf != 0) {
            return rL + b.l(10, this.zQf);
        }
        return rL;
    }
}
