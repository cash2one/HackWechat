package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.contact.d;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.o;
import com.tencent.wcdb.FileUtils;
import java.util.Arrays;
import org.xwalk.core.R$styleable;

public final class a$z extends e {
    public String groupId;
    public int slB;
    public long slC;
    public String zMM;
    public at zMO;
    public int zMR;
    public int zNm;
    public av[] zNs;
    public a$as zNt;
    public av[] zNx;
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
                case 32:
                    this.zMR = aVar.ry();
                    continue;
                case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                    b = g.b(aVar, 42);
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
                case 50:
                    b = g.b(aVar, 50);
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
                case 58:
                    if (this.zNt == null) {
                        this.zNt = new a$as();
                    }
                    aVar.a(this.zNt);
                    continue;
                case 66:
                    this.zMM = aVar.readString();
                    continue;
                case 74:
                    b = g.b(aVar, 74);
                    rx = this.zNs == null ? 0 : this.zNs.length;
                    obj = new av[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zNs, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new av();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new av();
                    aVar.a(obj[rx]);
                    this.zNs = obj;
                    continue;
                case 80:
                    this.zOh = aVar.ry();
                    continue;
                case R$styleable.AppCompatTheme_colorButtonNormal /*88*/:
                    b = g.b(aVar, 88);
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
                case 90:
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
                case 98:
                    if (this.zMO == null) {
                        this.zMO = new at();
                    }
                    aVar.a(this.zMO);
                    continue;
                case 104:
                    this.zNm = aVar.ry();
                    continue;
                case 114:
                    b = g.b(aVar, 114);
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
                case 120:
                    this.zOk = aVar.ry();
                    continue;
                case FileUtils.S_IWUSR /*128*/:
                    this.zOl = aVar.ry();
                    continue;
                case 138:
                    b = g.b(aVar, 138);
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
                case f.CTRL_INDEX /*146*/:
                    b = g.b(aVar, f.CTRL_INDEX);
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
                case d.CTRL_INDEX /*152*/:
                    this.zOn = aVar.ry();
                    continue;
                case JsApiSetBackgroundAudioState.CTRL_INDEX /*160*/:
                    this.zOo = aVar.ry();
                    continue;
                case JsApiSetClipboardData.CTRL_INDEX /*168*/:
                    this.zOp = aVar.ry();
                    continue;
                case 178:
                    this.zOq = aVar.readBytes();
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

    public a$z() {
        this.groupId = "";
        this.slB = 0;
        this.slC = 0;
        this.zMR = 0;
        this.zOf = o.cCK();
        this.zOg = aw.cCR();
        this.zNt = null;
        this.zMM = "";
        this.zNs = av.cCQ();
        this.zOh = 0;
        this.zOi = g.bfR;
        this.zMO = null;
        this.zNm = 0;
        this.zOj = o.cCK();
        this.zOk = 0;
        this.zOl = 0;
        this.zNx = av.cCQ();
        this.zOm = o.cCK();
        this.zOn = 0;
        this.zOo = 0;
        this.zOp = 0;
        this.zOq = g.bfX;
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
        if (this.zOf != null && this.zOf.length > 0) {
            for (e eVar : this.zOf) {
                if (eVar != null) {
                    bVar.a(5, eVar);
                }
            }
        }
        if (this.zOg != null && this.zOg.length > 0) {
            for (e eVar2 : this.zOg) {
                if (eVar2 != null) {
                    bVar.a(6, eVar2);
                }
            }
        }
        if (this.zNt != null) {
            bVar.a(7, this.zNt);
        }
        if (!this.zMM.equals("")) {
            bVar.g(8, this.zMM);
        }
        if (this.zNs != null && this.zNs.length > 0) {
            for (e eVar22 : this.zNs) {
                if (eVar22 != null) {
                    bVar.a(9, eVar22);
                }
            }
        }
        if (this.zOh != 0) {
            bVar.aB(10, this.zOh);
        }
        if (this.zOi != null && this.zOi.length > 0) {
            for (int aB : this.zOi) {
                bVar.aB(11, aB);
            }
        }
        if (this.zMO != null) {
            bVar.a(12, this.zMO);
        }
        if (this.zNm != 0) {
            bVar.aC(13, this.zNm);
        }
        if (this.zOj != null && this.zOj.length > 0) {
            for (e eVar222 : this.zOj) {
                if (eVar222 != null) {
                    bVar.a(14, eVar222);
                }
            }
        }
        if (this.zOk != 0) {
            bVar.aC(15, this.zOk);
        }
        if (this.zOl != 0) {
            bVar.aC(16, this.zOl);
        }
        if (this.zNx != null && this.zNx.length > 0) {
            for (e eVar2222 : this.zNx) {
                if (eVar2222 != null) {
                    bVar.a(17, eVar2222);
                }
            }
        }
        if (this.zOm != null && this.zOm.length > 0) {
            while (i < this.zOm.length) {
                e eVar3 = this.zOm[i];
                if (eVar3 != null) {
                    bVar.a(18, eVar3);
                }
                i++;
            }
        }
        if (this.zOn != 0) {
            bVar.aB(19, this.zOn);
        }
        if (this.zOo != 0) {
            bVar.aB(20, this.zOo);
        }
        if (this.zOp != 0) {
            bVar.aB(21, this.zOp);
        }
        if (!Arrays.equals(this.zOq, g.bfX)) {
            bVar.a(22, this.zOq);
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
        if (this.zOf != null && this.zOf.length > 0) {
            i = rL;
            for (e eVar : this.zOf) {
                if (eVar != null) {
                    i += b.b(5, eVar);
                }
            }
            rL = i;
        }
        if (this.zOg != null && this.zOg.length > 0) {
            i = rL;
            for (e eVar2 : this.zOg) {
                if (eVar2 != null) {
                    i += b.b(6, eVar2);
                }
            }
            rL = i;
        }
        if (this.zNt != null) {
            rL += b.b(7, this.zNt);
        }
        if (!this.zMM.equals("")) {
            rL += b.h(8, this.zMM);
        }
        if (this.zNs != null && this.zNs.length > 0) {
            i = rL;
            for (e eVar22 : this.zNs) {
                if (eVar22 != null) {
                    i += b.b(9, eVar22);
                }
            }
            rL = i;
        }
        if (this.zOh != 0) {
            rL += b.aD(10, this.zOh);
        }
        if (this.zOi != null && this.zOi.length > 0) {
            int i3 = 0;
            for (int dV : this.zOi) {
                i3 += b.dV(dV);
            }
            rL = (rL + i3) + (this.zOi.length * 1);
        }
        if (this.zMO != null) {
            rL += b.b(12, this.zMO);
        }
        if (this.zNm != 0) {
            rL += b.aE(13, this.zNm);
        }
        if (this.zOj != null && this.zOj.length > 0) {
            i = rL;
            for (e eVar222 : this.zOj) {
                if (eVar222 != null) {
                    i += b.b(14, eVar222);
                }
            }
            rL = i;
        }
        if (this.zOk != 0) {
            rL += b.aE(15, this.zOk);
        }
        if (this.zOl != 0) {
            rL += b.aE(16, this.zOl);
        }
        if (this.zNx != null && this.zNx.length > 0) {
            i = rL;
            for (e eVar2222 : this.zNx) {
                if (eVar2222 != null) {
                    i += b.b(17, eVar2222);
                }
            }
            rL = i;
        }
        if (this.zOm != null && this.zOm.length > 0) {
            while (i2 < this.zOm.length) {
                e eVar3 = this.zOm[i2];
                if (eVar3 != null) {
                    rL += b.b(18, eVar3);
                }
                i2++;
            }
        }
        if (this.zOn != 0) {
            rL += b.aD(19, this.zOn);
        }
        if (this.zOo != 0) {
            rL += b.aD(20, this.zOo);
        }
        if (this.zOp != 0) {
            rL += b.aD(21, this.zOp);
        }
        if (Arrays.equals(this.zOq, g.bfX)) {
            return rL;
        }
        return rL + b.b(22, this.zOq);
    }
}
