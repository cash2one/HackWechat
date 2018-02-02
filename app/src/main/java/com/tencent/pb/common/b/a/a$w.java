package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$w extends e {
    private static volatile a$w[] zOb;
    public String zOc;
    public String zOd;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 10:
                    this.zOc = aVar.readString();
                    continue;
                case 18:
                    this.zOd = aVar.readString();
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

    public static a$w[] cCL() {
        if (zOb == null) {
            synchronized (c.bfP) {
                if (zOb == null) {
                    zOb = new a$w[0];
                }
            }
        }
        return zOb;
    }

    public a$w() {
        this.zOc = "";
        this.zOd = "";
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (!this.zOc.equals("")) {
            bVar.g(1, this.zOc);
        }
        if (!this.zOd.equals("")) {
            bVar.g(2, this.zOd);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (!this.zOc.equals("")) {
            rL += b.h(1, this.zOc);
        }
        if (this.zOd.equals("")) {
            return rL;
        }
        return rL + b.h(2, this.zOd);
    }
}
