package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.m;

public final class a$d extends e {
    public int netType;
    public String zMM;
    public at zMO;
    public int[] zMP;
    public ba zMQ;
    public int zMR;
    public int zMS;
    public ay zMT;
    public String zMU;
    public String[] zMV;
    public m[] zMW;
    public int zMX;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            int b;
            Object obj;
            switch (rx) {
                case 0:
                    break;
                case 10:
                    if (this.zMO == null) {
                        this.zMO = new at();
                    }
                    aVar.a(this.zMO);
                    continue;
                case 16:
                    b = g.b(aVar, 16);
                    rx = this.zMP == null ? 0 : this.zMP.length;
                    obj = new int[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zMP, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = aVar.ry();
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = aVar.ry();
                    this.zMP = obj;
                    continue;
                case 18:
                    int dQ = aVar.dQ(aVar.ry());
                    b = aVar.getPosition();
                    rx = 0;
                    while (aVar.rB() > 0) {
                        aVar.ry();
                        rx++;
                    }
                    aVar.dS(b);
                    b = this.zMP == null ? 0 : this.zMP.length;
                    Object obj2 = new int[(rx + b)];
                    if (b != 0) {
                        System.arraycopy(this.zMP, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = aVar.ry();
                        b++;
                    }
                    this.zMP = obj2;
                    aVar.dR(dQ);
                    continue;
                case 26:
                    if (this.zMQ == null) {
                        this.zMQ = new ba();
                    }
                    aVar.a(this.zMQ);
                    continue;
                case 32:
                    this.zMR = aVar.ry();
                    continue;
                case 40:
                    this.zMS = aVar.ry();
                    continue;
                case 50:
                    if (this.zMT == null) {
                        this.zMT = new ay();
                    }
                    aVar.a(this.zMT);
                    continue;
                case 58:
                    this.zMM = aVar.readString();
                    continue;
                case 66:
                    this.zMU = aVar.readString();
                    continue;
                case 72:
                    this.netType = aVar.ry();
                    continue;
                case 802:
                    b = g.b(aVar, 802);
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

    public a$d() {
        this.zMO = null;
        this.zMP = g.bfR;
        this.zMQ = null;
        this.zMR = 0;
        this.zMS = 0;
        this.zMT = null;
        this.zMM = "";
        this.zMU = "";
        this.netType = 0;
        this.zMV = g.EMPTY_STRING_ARRAY;
        this.zMW = m.cCI();
        this.zMX = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        int i = 0;
        if (this.zMO != null) {
            bVar.a(1, this.zMO);
        }
        if (this.zMP != null && this.zMP.length > 0) {
            for (int aC : this.zMP) {
                bVar.aC(2, aC);
            }
        }
        if (this.zMQ != null) {
            bVar.a(3, this.zMQ);
        }
        if (this.zMR != 0) {
            bVar.aC(4, this.zMR);
        }
        if (this.zMS != 0) {
            bVar.aC(5, this.zMS);
        }
        if (this.zMT != null) {
            bVar.a(6, this.zMT);
        }
        if (!this.zMM.equals("")) {
            bVar.g(7, this.zMM);
        }
        if (!this.zMU.equals("")) {
            bVar.g(8, this.zMU);
        }
        if (this.netType != 0) {
            bVar.aC(9, this.netType);
        }
        if (this.zMV != null && this.zMV.length > 0) {
            for (String str : this.zMV) {
                if (str != null) {
                    bVar.g(100, str);
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
        if (this.zMX != 0) {
            bVar.aC(240, this.zMX);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int i;
        int i2 = 0;
        int rL = super.rL();
        if (this.zMO != null) {
            rL += b.b(1, this.zMO);
        }
        if (this.zMP != null && this.zMP.length > 0) {
            i = 0;
            for (int dZ : this.zMP) {
                int dZ2;
                i += b.dZ(dZ2);
            }
            rL = (rL + i) + (this.zMP.length * 1);
        }
        if (this.zMQ != null) {
            rL += b.b(3, this.zMQ);
        }
        if (this.zMR != 0) {
            rL += b.aE(4, this.zMR);
        }
        if (this.zMS != 0) {
            rL += b.aE(5, this.zMS);
        }
        if (this.zMT != null) {
            rL += b.b(6, this.zMT);
        }
        if (!this.zMM.equals("")) {
            rL += b.h(7, this.zMM);
        }
        if (!this.zMU.equals("")) {
            rL += b.h(8, this.zMU);
        }
        if (this.netType != 0) {
            rL += b.aE(9, this.netType);
        }
        if (this.zMV != null && this.zMV.length > 0) {
            i = 0;
            dZ2 = 0;
            for (String str : this.zMV) {
                if (str != null) {
                    dZ2++;
                    i += b.bm(str);
                }
            }
            rL = (rL + i) + (dZ2 * 2);
        }
        if (this.zMW != null && this.zMW.length > 0) {
            while (i2 < this.zMW.length) {
                e eVar = this.zMW[i2];
                if (eVar != null) {
                    rL += b.b(202, eVar);
                }
                i2++;
            }
        }
        if (this.zMX != 0) {
            return rL + b.aE(240, this.zMX);
        }
        return rL;
    }
}
