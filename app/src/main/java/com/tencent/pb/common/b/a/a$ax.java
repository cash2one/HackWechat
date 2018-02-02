package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$ax extends e {
    public int zPU;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.zPU = aVar.ry();
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

    public a$ax() {
        this.zPU = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.zPU != 0) {
            bVar.aC(1, this.zPU);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.zPU != 0) {
            return rL + b.aE(1, this.zPU);
        }
        return rL;
    }
}
