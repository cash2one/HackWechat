package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.am;

public final class a$r extends e {
    public am[] zNz;

    public a$r() {
        this.zNz = am.cCM();
        this.bfQ = -1;
    }

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 10:
                    int b = g.b(aVar, 10);
                    rx = this.zNz == null ? 0 : this.zNz.length;
                    Object obj = new am[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zNz, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new am();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new am();
                    aVar.a(obj[rx]);
                    this.zNz = obj;
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

    public final void a(b bVar) {
        if (this.zNz != null && this.zNz.length > 0) {
            for (e eVar : this.zNz) {
                if (eVar != null) {
                    bVar.a(1, eVar);
                }
            }
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.zNz != null && this.zNz.length > 0) {
            for (e eVar : this.zNz) {
                if (eVar != null) {
                    rL += b.b(1, eVar);
                }
            }
        }
        return rL;
    }
}
