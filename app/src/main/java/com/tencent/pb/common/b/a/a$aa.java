package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.o;
import com.tencent.wcdb.FileUtils;
import java.util.Arrays;
import org.xwalk.core.R$styleable;

public final class a$aa extends e {
    public String groupId;
    public int slB;
    public long slC;
    public at zMO;
    public int zMY;
    public int zNm;
    public as zNt;
    public av[] zNx;
    public av[] zOe;
    public o[] zOf;
    public aw[] zOg;
    public int zOh;
    public int[] zOi;
    public o[] zOj;
    public int zOk;
    public int zOl;
    public o[] zOm;
    public int zOn;
    public int zOo;
    public int zOp;
    public byte[] zOq;

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
                    b = g.b(aVar, 42);
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
                case 50:
                    if (this.zNt == null) {
                        this.zNt = new as();
                    }
                    aVar.a(this.zNt);
                    continue;
                case 56:
                    this.zOh = aVar.ry();
                    continue;
                case 64:
                    b = g.b(aVar, 64);
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
                case 66:
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
                case 72:
                    this.zMY = aVar.ry();
                    continue;
                case 82:
                    b = g.b(aVar, 82);
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
                case 90:
                    if (this.zMO == null) {
                        this.zMO = new at();
                    }
                    aVar.a(this.zMO);
                    continue;
                case 96:
                    this.zNm = aVar.ry();
                    continue;
                case 106:
                    b = g.b(aVar, 106);
                    rx = this.zOj == null ? 0 : this.zOj.length;
                    obj = new o[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zOj, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new o();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new o();
                    aVar.a(obj[rx]);
                    this.zOj = obj;
                    continue;
                case 114:
                    b = g.b(aVar, 114);
                    rx = this.zOm == null ? 0 : this.zOm.length;
                    obj = new o[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zOm, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new o();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new o();
                    aVar.a(obj[rx]);
                    this.zOm = obj;
                    continue;
                case 120:
                    this.zOn = aVar.ry();
                    continue;
                case FileUtils.S_IWUSR /*128*/:
                    this.zOo = aVar.ry();
                    continue;
                case h.CTRL_INDEX /*136*/:
                    this.zOp = aVar.ry();
                    continue;
                case f.CTRL_INDEX /*146*/:
                    this.zOq = aVar.readBytes();
                    continue;
                case 800:
                    this.zOk = aVar.ry();
                    continue;
                case 808:
                    this.zOl = aVar.ry();
                    continue;
                case 818:
                    b = g.b(aVar, 818);
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

    public a$aa() {
        this.groupId = "";
        this.slB = 0;
        this.slC = 0;
        this.zOf = o.cCK();
        this.zOe = av.cCQ();
        this.zNt = null;
        this.zOh = 0;
        this.zOi = g.bfR;
        this.zMY = 0;
        this.zOg = aw.cCR();
        this.zMO = null;
        this.zNm = 0;
        this.zOj = o.cCK();
        this.zOm = o.cCK();
        this.zOn = 0;
        this.zOo = 0;
        this.zOp = 0;
        this.zOq = g.bfX;
        this.zOk = 0;
        this.zOl = 0;
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
        if (this.zOe != null && this.zOe.length > 0) {
            for (e eVar2 : this.zOe) {
                if (eVar2 != null) {
                    bVar.a(5, eVar2);
                }
            }
        }
        if (this.zNt != null) {
            bVar.a(6, this.zNt);
        }
        if (this.zOh != 0) {
            bVar.aB(7, this.zOh);
        }
        if (this.zOi != null && this.zOi.length > 0) {
            for (int aB : this.zOi) {
                bVar.aB(8, aB);
            }
        }
        if (this.zMY != 0) {
            bVar.aB(9, this.zMY);
        }
        if (this.zOg != null && this.zOg.length > 0) {
            for (e eVar22 : this.zOg) {
                if (eVar22 != null) {
                    bVar.a(10, eVar22);
                }
            }
        }
        if (this.zMO != null) {
            bVar.a(11, this.zMO);
        }
        if (this.zNm != 0) {
            bVar.aC(12, this.zNm);
        }
        if (this.zOj != null && this.zOj.length > 0) {
            for (e eVar222 : this.zOj) {
                if (eVar222 != null) {
                    bVar.a(13, eVar222);
                }
            }
        }
        if (this.zOm != null && this.zOm.length > 0) {
            for (e eVar2222 : this.zOm) {
                if (eVar2222 != null) {
                    bVar.a(14, eVar2222);
                }
            }
        }
        if (this.zOn != 0) {
            bVar.aB(15, this.zOn);
        }
        if (this.zOo != 0) {
            bVar.aB(16, this.zOo);
        }
        if (this.zOp != 0) {
            bVar.aB(17, this.zOp);
        }
        if (!Arrays.equals(this.zOq, g.bfX)) {
            bVar.a(18, this.zOq);
        }
        if (this.zOk != 0) {
            bVar.aC(100, this.zOk);
        }
        if (this.zOl != 0) {
            bVar.aC(101, this.zOl);
        }
        if (this.zNx != null && this.zNx.length > 0) {
            while (i < this.zNx.length) {
                e eVar3 = this.zNx[i];
                if (eVar3 != null) {
                    bVar.a(102, eVar3);
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
        if (this.zOe != null && this.zOe.length > 0) {
            i = rL;
            for (e eVar2 : this.zOe) {
                if (eVar2 != null) {
                    i += b.b(5, eVar2);
                }
            }
            rL = i;
        }
        if (this.zNt != null) {
            rL += b.b(6, this.zNt);
        }
        if (this.zOh != 0) {
            rL += b.aD(7, this.zOh);
        }
        if (this.zOi != null && this.zOi.length > 0) {
            int i3 = 0;
            for (int dV : this.zOi) {
                i3 += b.dV(dV);
            }
            rL = (rL + i3) + (this.zOi.length * 1);
        }
        if (this.zMY != 0) {
            rL += b.aD(9, this.zMY);
        }
        if (this.zOg != null && this.zOg.length > 0) {
            i = rL;
            for (e eVar22 : this.zOg) {
                if (eVar22 != null) {
                    i += b.b(10, eVar22);
                }
            }
            rL = i;
        }
        if (this.zMO != null) {
            rL += b.b(11, this.zMO);
        }
        if (this.zNm != 0) {
            rL += b.aE(12, this.zNm);
        }
        if (this.zOj != null && this.zOj.length > 0) {
            i = rL;
            for (e eVar222 : this.zOj) {
                if (eVar222 != null) {
                    i += b.b(13, eVar222);
                }
            }
            rL = i;
        }
        if (this.zOm != null && this.zOm.length > 0) {
            i = rL;
            for (e eVar2222 : this.zOm) {
                if (eVar2222 != null) {
                    i += b.b(14, eVar2222);
                }
            }
            rL = i;
        }
        if (this.zOn != 0) {
            rL += b.aD(15, this.zOn);
        }
        if (this.zOo != 0) {
            rL += b.aD(16, this.zOo);
        }
        if (this.zOp != 0) {
            rL += b.aD(17, this.zOp);
        }
        if (!Arrays.equals(this.zOq, g.bfX)) {
            rL += b.b(18, this.zOq);
        }
        if (this.zOk != 0) {
            rL += b.aE(100, this.zOk);
        }
        if (this.zOl != 0) {
            rL += b.aE(101, this.zOl);
        }
        if (this.zNx != null && this.zNx.length > 0) {
            while (i2 < this.zNx.length) {
                e eVar3 = this.zNx[i2];
                if (eVar3 != null) {
                    rL += b.b(102, eVar3);
                }
                i2++;
            }
        }
        return rL;
    }
}
