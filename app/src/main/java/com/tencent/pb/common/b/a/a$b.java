package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$b extends e {
    public int aAk;
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
                case 16:
                    this.aAk = aVar.ry();
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

    public a$b() {
        this.zMM = "";
        this.aAk = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (!this.zMM.equals("")) {
            bVar.g(1, this.zMM);
        }
        if (this.aAk != 0) {
            bVar.aB(2, this.aAk);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (!this.zMM.equals("")) {
            rL += b.h(1, this.zMM);
        }
        if (this.aAk != 0) {
            return rL + b.aD(2, this.aAk);
        }
        return rL;
    }
}
