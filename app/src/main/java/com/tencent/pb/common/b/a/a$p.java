package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import java.util.Arrays;

public final class a$p extends e {
    public long fqm;
    public String groupId;
    public int slB;
    public long slC;
    public at zMO;
    public int zMR;
    public a$ay zMT;
    public int zNq;
    public aw[] zNr;
    public av[] zNs;
    public a$as zNt;
    public int zNu;
    public byte[] zNv;
    public byte[] zNw;
    public av[] zNx;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            int b;
            Object obj;
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.zNq = aVar.ry();
                    continue;
                case 18:
                    this.groupId = aVar.readString();
                    continue;
                case 24:
                    this.slB = aVar.ry();
                    continue;
                case 32:
                    this.slC = aVar.rz();
                    continue;
                case 40:
                    this.zMR = aVar.ry();
                    continue;
                case 50:
                    if (this.zMO == null) {
                        this.zMO = new at();
                    }
                    aVar.a(this.zMO);
                    continue;
                case 58:
                    b = g.b(aVar, 58);
                    rx = this.zNr == null ? 0 : this.zNr.length;
                    obj = new aw[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zNr, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new aw();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new aw();
                    aVar.a(obj[rx]);
                    this.zNr = obj;
                    continue;
                case 66:
                    b = g.b(aVar, 66);
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
                case 74:
                    if (this.zNt == null) {
                        this.zNt = new a$as();
                    }
                    aVar.a(this.zNt);
                    continue;
                case 82:
                    if (this.zMT == null) {
                        this.zMT = new a$ay();
                    }
                    aVar.a(this.zMT);
                    continue;
                case 808:
                    this.fqm = aVar.rz();
                    continue;
                case 816:
                    this.zNu = aVar.ry();
                    continue;
                case 826:
                    this.zNv = aVar.readBytes();
                    continue;
                case 1602:
                    this.zNw = aVar.readBytes();
                    continue;
                case 1610:
                    b = g.b(aVar, 1610);
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

    public a$p() {
        this.zNq = 0;
        this.groupId = "";
        this.slB = 0;
        this.slC = 0;
        this.zMR = 0;
        this.zMO = null;
        this.zNr = aw.cCR();
        this.zNs = av.cCQ();
        this.zNt = null;
        this.zMT = null;
        this.fqm = 0;
        this.zNu = 0;
        this.zNv = g.bfX;
        this.zNw = g.bfX;
        this.zNx = av.cCQ();
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        int i = 0;
        if (this.zNq != 0) {
            bVar.aB(1, this.zNq);
        }
        if (!this.groupId.equals("")) {
            bVar.g(2, this.groupId);
        }
        if (this.slB != 0) {
            bVar.aB(3, this.slB);
        }
        if (this.slC != 0) {
            bVar.k(4, this.slC);
        }
        if (this.zMR != 0) {
            bVar.aC(5, this.zMR);
        }
        if (this.zMO != null) {
            bVar.a(6, this.zMO);
        }
        if (this.zNr != null && this.zNr.length > 0) {
            for (e eVar : this.zNr) {
                if (eVar != null) {
                    bVar.a(7, eVar);
                }
            }
        }
        if (this.zNs != null && this.zNs.length > 0) {
            for (e eVar2 : this.zNs) {
                if (eVar2 != null) {
                    bVar.a(8, eVar2);
                }
            }
        }
        if (this.zNt != null) {
            bVar.a(9, this.zNt);
        }
        if (this.zMT != null) {
            bVar.a(10, this.zMT);
        }
        if (this.fqm != 0) {
            bVar.j(101, this.fqm);
        }
        if (this.zNu != 0) {
            bVar.aC(102, this.zNu);
        }
        if (!Arrays.equals(this.zNv, g.bfX)) {
            bVar.a(103, this.zNv);
        }
        if (!Arrays.equals(this.zNw, g.bfX)) {
            bVar.a(200, this.zNw);
        }
        if (this.zNx != null && this.zNx.length > 0) {
            while (i < this.zNx.length) {
                e eVar3 = this.zNx[i];
                if (eVar3 != null) {
                    bVar.a(201, eVar3);
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
        if (this.zNq != 0) {
            rL += b.aD(1, this.zNq);
        }
        if (!this.groupId.equals("")) {
            rL += b.h(2, this.groupId);
        }
        if (this.slB != 0) {
            rL += b.aD(3, this.slB);
        }
        if (this.slC != 0) {
            rL += b.m(4, this.slC);
        }
        if (this.zMR != 0) {
            rL += b.aE(5, this.zMR);
        }
        if (this.zMO != null) {
            rL += b.b(6, this.zMO);
        }
        if (this.zNr != null && this.zNr.length > 0) {
            i = rL;
            for (e eVar : this.zNr) {
                if (eVar != null) {
                    i += b.b(7, eVar);
                }
            }
            rL = i;
        }
        if (this.zNs != null && this.zNs.length > 0) {
            i = rL;
            for (e eVar2 : this.zNs) {
                if (eVar2 != null) {
                    i += b.b(8, eVar2);
                }
            }
            rL = i;
        }
        if (this.zNt != null) {
            rL += b.b(9, this.zNt);
        }
        if (this.zMT != null) {
            rL += b.b(10, this.zMT);
        }
        if (this.fqm != 0) {
            rL += b.l(101, this.fqm);
        }
        if (this.zNu != 0) {
            rL += b.aE(102, this.zNu);
        }
        if (!Arrays.equals(this.zNv, g.bfX)) {
            rL += b.b(103, this.zNv);
        }
        if (!Arrays.equals(this.zNw, g.bfX)) {
            rL += b.b(200, this.zNw);
        }
        if (this.zNx != null && this.zNx.length > 0) {
            while (i2 < this.zNx.length) {
                e eVar3 = this.zNx[i2];
                if (eVar3 != null) {
                    rL += b.b(201, eVar3);
                }
                i2++;
            }
        }
        return rL;
    }
}
