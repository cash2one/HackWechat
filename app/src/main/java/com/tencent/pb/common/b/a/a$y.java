package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$y extends e {
    public String zMM;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 10:
                    this.zMM = aVar.readString();
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

    public a$y() {
        this.zMM = "";
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (!this.zMM.equals("")) {
            bVar.g(1, this.zMM);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.zMM.equals("")) {
            return rL;
        }
        return rL + b.h(1, this.zMM);
    }
}
