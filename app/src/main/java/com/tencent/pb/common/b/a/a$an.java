package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$an extends e {
    public long hLa;
    public int hOH;
    public int zOE;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.hLa = aVar.rz();
                    continue;
                case 16:
                    this.hOH = aVar.ry();
                    continue;
                case 24:
                    this.zOE = aVar.ry();
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

    public a$an() {
        this.hLa = 0;
        this.hOH = 0;
        this.zOE = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.hLa != 0) {
            bVar.j(1, this.hLa);
        }
        if (this.hOH != 0) {
            bVar.aC(2, this.hOH);
        }
        if (this.zOE != 0) {
            bVar.aC(3, this.zOE);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.hLa != 0) {
            rL += b.l(1, this.hLa);
        }
        if (this.hOH != 0) {
            rL += b.aE(2, this.hOH);
        }
        if (this.zOE != 0) {
            return rL + b.aE(3, this.zOE);
        }
        return rL;
    }
}
