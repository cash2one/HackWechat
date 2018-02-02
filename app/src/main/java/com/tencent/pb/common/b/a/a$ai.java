package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$ai extends e {
    public int ret;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.ret = aVar.ry();
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

    public a$ai() {
        this.ret = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.ret != 0) {
            bVar.aB(1, this.ret);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.ret != 0) {
            return rL + b.aD(1, this.ret);
        }
        return rL;
    }
}
