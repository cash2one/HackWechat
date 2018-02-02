package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$i extends e {
    public int action;
    public String groupId;
    public int nDx;
    public long nDy;
    public long timestamp;

    public a$i() {
        this.action = 0;
        this.nDx = 0;
        this.nDy = 0;
        this.groupId = "";
        this.timestamp = 0;
        this.bfQ = -1;
    }

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.action = aVar.ry();
                    continue;
                case 16:
                    this.nDx = aVar.ry();
                    continue;
                case 24:
                    this.nDy = aVar.rz();
                    continue;
                case 34:
                    this.groupId = aVar.readString();
                    continue;
                case 40:
                    this.timestamp = aVar.rz();
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
        bVar.aC(1, this.action);
        bVar.aB(2, this.nDx);
        bVar.k(3, this.nDy);
        if (!this.groupId.equals("")) {
            bVar.g(4, this.groupId);
        }
        if (this.timestamp != 0) {
            bVar.j(5, this.timestamp);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = ((super.rL() + b.aE(1, this.action)) + b.aD(2, this.nDx)) + b.m(3, this.nDy);
        if (!this.groupId.equals("")) {
            rL += b.h(4, this.groupId);
        }
        return this.timestamp != 0 ? rL + b.l(5, this.timestamp) : rL;
    }
}
