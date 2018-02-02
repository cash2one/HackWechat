package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$ap extends e {
    public int zOH;
    public int zOI;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.zOH = aVar.ry();
                    continue;
                case 16:
                    this.zOI = aVar.ry();
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

    public a$ap() {
        this.zOH = 0;
        this.zOI = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.zOH != 0) {
            bVar.aB(1, this.zOH);
        }
        if (this.zOI != 0) {
            bVar.aB(2, this.zOI);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.zOH != 0) {
            rL += b.aD(1, this.zOH);
        }
        if (this.zOI != 0) {
            return rL + b.aD(2, this.zOI);
        }
        return rL;
    }
}
