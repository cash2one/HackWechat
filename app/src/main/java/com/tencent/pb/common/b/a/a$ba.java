package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$ba extends e {
    public int type;
    public a$al zQb;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.type = aVar.ry();
                    continue;
                case 18:
                    if (this.zQb == null) {
                        this.zQb = new a$al();
                    }
                    aVar.a(this.zQb);
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

    public a$ba() {
        this.type = 0;
        this.zQb = null;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.type != 0) {
            bVar.aB(1, this.type);
        }
        if (this.zQb != null) {
            bVar.a(2, this.zQb);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.type != 0) {
            rL += b.aD(1, this.type);
        }
        if (this.zQb != null) {
            return rL + b.b(2, this.zQb);
        }
        return rL;
    }
}
