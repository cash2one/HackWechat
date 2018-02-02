package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.m;
import com.tencent.pb.common.b.a.a.s;
import org.xwalk.core.R$styleable;

public final class a$e extends e {
    public String groupId;
    public int netType;
    public int slB;
    public long slC;
    public int zMK;
    public at zMO;
    public ba zMQ;
    public int zMS;
    public String[] zMV;
    public m[] zMW;
    public int zMX;
    public int zMY;
    public s zMZ;
    public int zNa;

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
                    if (this.zMQ == null) {
                        this.zMQ = new ba();
                    }
                    aVar.a(this.zMQ);
                    continue;
                case 40:
                    this.zMY = aVar.ry();
                    continue;
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.zMS = aVar.ry();
                    continue;
                case 56:
                    this.zMK = aVar.ry();
                    continue;
                case 64:
                    this.netType = aVar.ry();
                    continue;
                case 1602:
                    if (this.zMO == null) {
                        this.zMO = new at();
                    }
                    aVar.a(this.zMO);
                    continue;
                case 1610:
                    b = g.b(aVar, 1610);
                    rx = this.zMV == null ? 0 : this.zMV.length;
                    obj = new String[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zMV, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = aVar.readString();
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = aVar.readString();
                    this.zMV = obj;
                    continue;
                case 1618:
                    b = g.b(aVar, 1618);
                    rx = this.zMW == null ? 0 : this.zMW.length;
                    obj = new m[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zMW, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new m();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new m();
                    aVar.a(obj[rx]);
                    this.zMW = obj;
                    continue;
                case 1626:
                    if (this.zMZ == null) {
                        this.zMZ = new s();
                    }
                    aVar.a(this.zMZ);
                    continue;
                case 1632:
                    this.zNa = aVar.ry();
                    continue;
                case 1920:
                    this.zMX = aVar.ry();
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

    public a$e() {
        this.groupId = "";
        this.slB = 0;
        this.slC = 0;
        this.zMQ = null;
        this.zMY = 0;
        this.zMS = 0;
        this.zMK = 0;
        this.netType = 0;
        this.zMO = null;
        this.zMV = g.EMPTY_STRING_ARRAY;
        this.zMW = m.cCI();
        this.zMZ = null;
        this.zNa = 0;
        this.zMX = 0;
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
        if (this.zMQ != null) {
            bVar.a(4, this.zMQ);
        }
        if (this.zMY != 0) {
            bVar.aB(5, this.zMY);
        }
        if (this.zMS != 0) {
            bVar.aC(6, this.zMS);
        }
        if (this.zMK != 0) {
            bVar.aB(7, this.zMK);
        }
        if (this.netType != 0) {
            bVar.aC(8, this.netType);
        }
        if (this.zMO != null) {
            bVar.a(200, this.zMO);
        }
        if (this.zMV != null && this.zMV.length > 0) {
            for (String str : this.zMV) {
                if (str != null) {
                    bVar.g(201, str);
                }
            }
        }
        if (this.zMW != null && this.zMW.length > 0) {
            while (i < this.zMW.length) {
                e eVar = this.zMW[i];
                if (eVar != null) {
                    bVar.a(202, eVar);
                }
                i++;
            }
        }
        if (this.zMZ != null) {
            bVar.a(203, this.zMZ);
        }
        if (this.zNa != 0) {
            bVar.aC(d.CTRL_INDEX, this.zNa);
        }
        if (this.zMX != 0) {
            bVar.aC(240, this.zMX);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int i = 0;
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
        if (this.zMQ != null) {
            rL += b.b(4, this.zMQ);
        }
        if (this.zMY != 0) {
            rL += b.aD(5, this.zMY);
        }
        if (this.zMS != 0) {
            rL += b.aE(6, this.zMS);
        }
        if (this.zMK != 0) {
            rL += b.aD(7, this.zMK);
        }
        if (this.netType != 0) {
            rL += b.aE(8, this.netType);
        }
        if (this.zMO != null) {
            rL += b.b(200, this.zMO);
        }
        if (this.zMV != null && this.zMV.length > 0) {
            int i2 = 0;
            int i3 = 0;
            for (String str : this.zMV) {
                if (str != null) {
                    i3++;
                    i2 += b.bm(str);
                }
            }
            rL = (rL + i2) + (i3 * 2);
        }
        if (this.zMW != null && this.zMW.length > 0) {
            while (i < this.zMW.length) {
                e eVar = this.zMW[i];
                if (eVar != null) {
                    rL += b.b(202, eVar);
                }
                i++;
            }
        }
        if (this.zMZ != null) {
            rL += b.b(203, this.zMZ);
        }
        if (this.zNa != 0) {
            rL += b.aE(d.CTRL_INDEX, this.zNa);
        }
        if (this.zMX != 0) {
            return rL + b.aE(240, this.zMX);
        }
        return rL;
    }
}
