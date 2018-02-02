package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$h extends e {
    public String groupId;
    public String ldj;
    public int nDx;
    public long nDy;
    public long timestamp;

    public a$h() {
        this.nDx = 0;
        this.nDy = 0;
        this.ldj = "";
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
                    this.nDx = aVar.ry();
                    continue;
                case 16:
                    this.nDy = aVar.rz();
                    continue;
                case 26:
                    this.ldj = aVar.readString();
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
        bVar.aB(1, this.nDx);
        bVar.k(2, this.nDy);
        bVar.g(3, this.ldj);
        if (!this.groupId.equals("")) {
            bVar.g(4, this.groupId);
        }
        if (this.timestamp != 0) {
            bVar.j(5, this.timestamp);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = ((super.rL() + b.aD(1, this.nDx)) + b.m(2, this.nDy)) + b.h(3, this.ldj);
        if (!this.groupId.equals("")) {
            rL += b.h(4, this.groupId);
        }
        return this.timestamp != 0 ? rL + b.l(5, this.timestamp) : rL;
    }
}
