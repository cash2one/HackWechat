package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$ay extends e {
    public int slB;
    public long slC;
    public int zPV;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.slB = aVar.ry();
                    continue;
                case 16:
                    this.slC = aVar.rz();
                    continue;
                case 24:
                    this.zPV = aVar.ry();
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

    public a$ay() {
        this.slB = 0;
        this.slC = 0;
        this.zPV = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.slB != 0) {
            bVar.aB(1, this.slB);
        }
        if (this.slC != 0) {
            bVar.k(2, this.slC);
        }
        if (this.zPV != 0) {
            bVar.aC(3, this.zPV);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.slB != 0) {
            rL += b.aD(1, this.slB);
        }
        if (this.slC != 0) {
            rL += b.m(2, this.slC);
        }
        if (this.zPV != 0) {
            return rL + b.aE(3, this.zPV);
        }
        return rL;
    }
}
