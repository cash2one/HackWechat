package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.w;

public final class a$c extends e {
    public w[] zMN;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 10:
                    int b = g.b(aVar, 10);
                    rx = this.zMN == null ? 0 : this.zMN.length;
                    Object obj = new w[(b + rx)];
                    if (rx != 0) {
                        System.arraycopy(this.zMN, 0, obj, 0, rx);
                    }
                    while (rx < obj.length - 1) {
                        obj[rx] = new w();
                        aVar.a(obj[rx]);
                        aVar.rx();
                        rx++;
                    }
                    obj[rx] = new w();
                    aVar.a(obj[rx]);
                    this.zMN = obj;
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

    public a$c() {
        this.zMN = w.cCL();
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.zMN != null && this.zMN.length > 0) {
            for (e eVar : this.zMN) {
                if (eVar != null) {
                    bVar.a(1, eVar);
                }
            }
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.zMN != null && this.zMN.length > 0) {
            for (e eVar : this.zMN) {
                if (eVar != null) {
                    rL += b.b(1, eVar);
                }
            }
        }
        return rL;
    }
}
