package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$a extends e {
    public String groupId;
    public int slB;
    public long slC;
    public int[] zMJ;
    public int zMK;
    public String[] zML;

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
                    b = g.b(aVar, 32);
                    rx = this.zMJ == null ? 0 : this.zMJ.length;
                    obj = new int[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zMJ, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = aVar.ry();
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = aVar.ry();
                    this.zMJ = obj;
                    continue;
                case 34:
                    int dQ = aVar.dQ(aVar.ry());
                    b = aVar.getPosition();
                    rx = 0;
                    while (aVar.rB() > 0) {
                        aVar.ry();
                        rx++;
                    }
                    aVar.dS(b);
                    b = this.zMJ == null ? 0 : this.zMJ.length;
                    Object obj2 = new int[(rx + b)];
                    if (b != 0) {
                        System.arraycopy(this.zMJ, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = aVar.ry();
                        b++;
                    }
                    this.zMJ = obj2;
                    aVar.dR(dQ);
                    continue;
                case 40:
                    this.zMK = aVar.ry();
                    continue;
                case 802:
                    b = g.b(aVar, 802);
                    rx = this.zML == null ? 0 : this.zML.length;
                    obj = new String[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zML, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = aVar.readString();
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = aVar.readString();
                    this.zML = obj;
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

    public a$a() {
        this.groupId = "";
        this.slB = 0;
        this.slC = 0;
        this.zMJ = g.bfR;
        this.zMK = 0;
        this.zML = g.EMPTY_STRING_ARRAY;
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
        if (this.zMJ != null && this.zMJ.length > 0) {
            for (int aC : this.zMJ) {
                bVar.aC(4, aC);
            }
        }
        if (this.zMK != 0) {
            bVar.aB(5, this.zMK);
        }
        if (this.zML != null && this.zML.length > 0) {
            while (i < this.zML.length) {
                String str = this.zML[i];
                if (str != null) {
                    bVar.g(100, str);
                }
                i++;
            }
        }
        super.a(bVar);
    }

    protected final int rL() {
        int i;
        int i2;
        int i3 = 0;
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
        if (this.zMJ != null && this.zMJ.length > 0) {
            i = 0;
            for (int dZ : this.zMJ) {
                i += b.dZ(dZ);
            }
            rL = (rL + i) + (this.zMJ.length * 1);
        }
        if (this.zMK != 0) {
            rL += b.aD(5, this.zMK);
        }
        if (this.zML == null || this.zML.length <= 0) {
            return rL;
        }
        i2 = 0;
        i = 0;
        while (i3 < this.zML.length) {
            String str = this.zML[i3];
            if (str != null) {
                i++;
                i2 += b.bm(str);
            }
            i3++;
        }
        return (rL + i2) + (i * 2);
    }
}
