package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.at;

public final class a$ac extends e {
    public String groupId;
    public at zMO;
    public int zOr;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 10:
                    this.groupId = aVar.readString();
                    continue;
                case 18:
                    if (this.zMO == null) {
                        this.zMO = new at();
                    }
                    aVar.a(this.zMO);
                    continue;
                case 24:
                    this.zOr = aVar.ry();
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

    public a$ac() {
        this.groupId = "";
        this.zMO = null;
        this.zOr = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (!this.groupId.equals("")) {
            bVar.g(1, this.groupId);
        }
        if (this.zMO != null) {
            bVar.a(2, this.zMO);
        }
        if (this.zOr != 0) {
            bVar.aB(3, this.zOr);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (!this.groupId.equals("")) {
            rL += b.h(1, this.groupId);
        }
        if (this.zMO != null) {
            rL += b.b(2, this.zMO);
        }
        if (this.zOr != 0) {
            return rL + b.aD(3, this.zOr);
        }
        return rL;
    }
}
