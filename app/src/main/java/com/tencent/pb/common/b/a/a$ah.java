package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.au;

public final class a$ah extends e {
    public au[] zOA;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 10:
                    int b = g.b(aVar, 10);
                    rx = this.zOA == null ? 0 : this.zOA.length;
                    Object obj = new au[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zOA, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new au();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new au();
                    aVar.a(obj[rx]);
                    this.zOA = obj;
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

    public a$ah() {
        this.zOA = au.cCP();
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.zOA != null && this.zOA.length > 0) {
            for (e eVar : this.zOA) {
                if (eVar != null) {
                    bVar.a(1, eVar);
                }
            }
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.zOA != null && this.zOA.length > 0) {
            for (e eVar : this.zOA) {
                if (eVar != null) {
                    rL += b.b(1, eVar);
                }
            }
        }
        return rL;
    }
}
