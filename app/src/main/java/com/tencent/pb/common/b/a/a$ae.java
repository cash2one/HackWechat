package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$ae extends e {
    public int nDx;
    public long nDy;

    public a$ae() {
        this.nDx = 0;
        this.nDy = 0;
        this.bfQ = -1;
    }

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.nDx = aVar.ry();
                    continue;
                case 16:
                    this.nDy = aVar.rz();
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
        if (this.nDx != 0) {
            bVar.aB(1, this.nDx);
        }
        if (this.nDy != 0) {
            bVar.k(2, this.nDy);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.nDx != 0) {
            rL += b.aD(1, this.nDx);
        }
        return this.nDy != 0 ? rL + b.m(2, this.nDy) : rL;
    }
}
