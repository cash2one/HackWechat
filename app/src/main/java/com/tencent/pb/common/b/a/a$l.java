package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.ao;
import com.tencent.pb.common.b.a.a.az;
import java.util.Arrays;
import org.xwalk.core.R$styleable;

public final class a$l extends e {
    public String groupId;
    public int hTT;
    public int nEd;
    public int slB;
    public long slC;
    public int zNd;
    public byte[] zNe;
    public az[] zNf;
    public ao[] zNg;
    public int zNh;
    public int zNi;

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
                    this.nEd = aVar.ry();
                    continue;
                case 40:
                    this.zNd = aVar.ry();
                    continue;
                case 50:
                    this.zNe = aVar.readBytes();
                    continue;
                case 58:
                    b = g.b(aVar, 58);
                    rx = this.zNf == null ? 0 : this.zNf.length;
                    obj = new az[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zNf, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new az();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new az();
                    aVar.a(obj[rx]);
                    this.zNf = obj;
                    continue;
                case 66:
                    b = g.b(aVar, 66);
                    rx = this.zNg == null ? 0 : this.zNg.length;
                    obj = new ao[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zNg, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new ao();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new ao();
                    aVar.a(obj[rx]);
                    this.zNg = obj;
                    continue;
                case 72:
                    this.zNh = aVar.ry();
                    continue;
                case 80:
                    this.zNi = aVar.ry();
                    continue;
                case R$styleable.AppCompatTheme_colorButtonNormal /*88*/:
                    this.hTT = aVar.ry();
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

    public a$l() {
        this.groupId = "";
        this.slB = 0;
        this.slC = 0;
        this.nEd = -1;
        this.zNd = 0;
        this.zNe = g.bfX;
        this.zNf = az.cCS();
        this.zNg = ao.cCN();
        this.zNh = 0;
        this.zNi = 0;
        this.hTT = 0;
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
        if (this.nEd != -1) {
            bVar.aB(4, this.nEd);
        }
        if (this.zNd != 0) {
            bVar.aB(5, this.zNd);
        }
        if (!Arrays.equals(this.zNe, g.bfX)) {
            bVar.a(6, this.zNe);
        }
        if (this.zNf != null && this.zNf.length > 0) {
            for (e eVar : this.zNf) {
                if (eVar != null) {
                    bVar.a(7, eVar);
                }
            }
        }
        if (this.zNg != null && this.zNg.length > 0) {
            while (i < this.zNg.length) {
                e eVar2 = this.zNg[i];
                if (eVar2 != null) {
                    bVar.a(8, eVar2);
                }
                i++;
            }
        }
        if (this.zNh != 0) {
            bVar.aB(9, this.zNh);
        }
        if (this.zNi != 0) {
            bVar.aB(10, this.zNi);
        }
        if (this.hTT != 0) {
            bVar.aB(11, this.hTT);
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
        if (this.nEd != -1) {
            rL += b.aD(4, this.nEd);
        }
        if (this.zNd != 0) {
            rL += b.aD(5, this.zNd);
        }
        if (!Arrays.equals(this.zNe, g.bfX)) {
            rL += b.b(6, this.zNe);
        }
        if (this.zNf != null && this.zNf.length > 0) {
            int i2 = rL;
            for (e eVar : this.zNf) {
                if (eVar != null) {
                    i2 += b.b(7, eVar);
                }
            }
            rL = i2;
        }
        if (this.zNg != null && this.zNg.length > 0) {
            while (i < this.zNg.length) {
                e eVar2 = this.zNg[i];
                if (eVar2 != null) {
                    rL += b.b(8, eVar2);
                }
                i++;
            }
        }
        if (this.zNh != 0) {
            rL += b.aD(9, this.zNh);
        }
        if (this.zNi != 0) {
            rL += b.aD(10, this.zNi);
        }
        if (this.hTT != 0) {
            return rL + b.aD(11, this.hTT);
        }
        return rL;
    }
}
