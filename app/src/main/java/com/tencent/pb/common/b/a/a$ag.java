package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.o;
import org.xwalk.core.R$styleable;

public final class a$ag extends e {
    public String groupId;
    public int slB;
    public long slC;
    public at zMO;
    public as zNt;
    public av[] zNx;
    public av[] zOe;
    public o[] zOf;
    public aw[] zOg;
    public int zOh;
    public int[] zOi;

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
                case 34:
                    b = g.b(aVar, 34);
                    rx = this.zOf == null ? 0 : this.zOf.length;
                    obj = new o[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zOf, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new o();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new o();
                    aVar.a(obj[rx]);
                    this.zOf = obj;
                    continue;
                case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                    if (this.zNt == null) {
                        this.zNt = new as();
                    }
                    aVar.a(this.zNt);
                    continue;
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.zOh = aVar.ry();
                    continue;
                case 56:
                    b = g.b(aVar, 56);
                    rx = this.zOi == null ? 0 : this.zOi.length;
                    obj = new int[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zOi, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = aVar.ry();
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = aVar.ry();
                    this.zOi = obj;
                    continue;
                case 58:
                    int dQ = aVar.dQ(aVar.ry());
                    b = aVar.getPosition();
                    rx = 0;
                    while (aVar.rB() > 0) {
                        aVar.ry();
                        rx++;
                    }
                    aVar.dS(b);
                    b = this.zOi == null ? 0 : this.zOi.length;
                    Object obj2 = new int[(rx + b)];
                    if (b != 0) {
                        System.arraycopy(this.zOi, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = aVar.ry();
                        b++;
                    }
                    this.zOi = obj2;
                    aVar.dR(dQ);
                    continue;
                case 1602:
                    b = g.b(aVar, 1602);
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
                case 1610:
                    b = g.b(aVar, 1610);
                    rx = this.zOg == null ? 0 : this.zOg.length;
                    obj = new aw[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zOg, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new aw();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new aw();
                    aVar.a(obj[rx]);
                    this.zOg = obj;
                    continue;
                case 1618:
                    if (this.zMO == null) {
                        this.zMO = new at();
                    }
                    aVar.a(this.zMO);
                    continue;
                case 1626:
                    b = g.b(aVar, 1626);
                    rx = this.zNx == null ? 0 : this.zNx.length;
                    obj = new av[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zNx, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new av();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new av();
                    aVar.a(obj[rx]);
                    this.zNx = obj;
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

    public a$ag() {
        this.groupId = "";
        this.slB = 0;
        this.slC = 0;
        this.zOf = o.cCK();
        this.zNt = null;
        this.zOh = 0;
        this.zOi = g.bfR;
        this.zOe = av.cCQ();
        this.zOg = aw.cCR();
        this.zMO = null;
        this.zNx = av.cCQ();
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
        if (this.zOf != null && this.zOf.length > 0) {
            for (e eVar : this.zOf) {
                if (eVar != null) {
                    bVar.a(4, eVar);
                }
            }
        }
        if (this.zNt != null) {
            bVar.a(5, this.zNt);
        }
        if (this.zOh != 0) {
            bVar.aB(6, this.zOh);
        }
        if (this.zOi != null && this.zOi.length > 0) {
            for (int aB : this.zOi) {
                bVar.aB(7, aB);
            }
        }
        if (this.zOe != null && this.zOe.length > 0) {
            for (e eVar2 : this.zOe) {
                if (eVar2 != null) {
                    bVar.a(200, eVar2);
                }
            }
        }
        if (this.zOg != null && this.zOg.length > 0) {
            for (e eVar22 : this.zOg) {
                if (eVar22 != null) {
                    bVar.a(201, eVar22);
                }
            }
        }
        if (this.zMO != null) {
            bVar.a(202, this.zMO);
        }
        if (this.zNx != null && this.zNx.length > 0) {
            while (i < this.zNx.length) {
                e eVar3 = this.zNx[i];
                if (eVar3 != null) {
                    bVar.a(203, eVar3);
                }
                i++;
            }
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
        if (this.zOf != null && this.zOf.length > 0) {
            i = rL;
            for (e eVar : this.zOf) {
                if (eVar != null) {
                    i += b.b(4, eVar);
                }
            }
            rL = i;
        }
        if (this.zNt != null) {
            rL += b.b(5, this.zNt);
        }
        if (this.zOh != 0) {
            rL += b.aD(6, this.zOh);
        }
        if (this.zOi != null && this.zOi.length > 0) {
            int i3 = 0;
            for (int dV : this.zOi) {
                i3 += b.dV(dV);
            }
            rL = (rL + i3) + (this.zOi.length * 1);
        }
        if (this.zOe != null && this.zOe.length > 0) {
            i = rL;
            for (e eVar2 : this.zOe) {
                if (eVar2 != null) {
                    i += b.b(200, eVar2);
                }
            }
            rL = i;
        }
        if (this.zOg != null && this.zOg.length > 0) {
            i = rL;
            for (e eVar22 : this.zOg) {
                if (eVar22 != null) {
                    i += b.b(201, eVar22);
                }
            }
            rL = i;
        }
        if (this.zMO != null) {
            rL += b.b(202, this.zMO);
        }
        if (this.zNx != null && this.zNx.length > 0) {
            while (i2 < this.zNx.length) {
                e eVar3 = this.zNx[i2];
                if (eVar3 != null) {
                    rL += b.b(203, eVar3);
                }
                i2++;
            }
        }
        return rL;
    }
}
