package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$az extends e {
    private static volatile a$az[] zPW;
    public int cRJ;
    public int zPX;
    public int zPY;
    public int zPZ;
    public int zQa;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.cRJ = aVar.ry();
                    continue;
                case 16:
                    this.zPX = aVar.ry();
                    continue;
                case 24:
                    this.zPY = aVar.ry();
                    continue;
                case 32:
                    this.zPZ = aVar.ry();
                    continue;
                case 40:
                    this.zQa = aVar.ry();
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

    public static a$az[] cCS() {
        if (zPW == null) {
            synchronized (c.bfP) {
                if (zPW == null) {
                    zPW = new a$az[0];
                }
            }
        }
        return zPW;
    }

    public a$az() {
        this.cRJ = 0;
        this.zPX = 0;
        this.zPY = 0;
        this.zPZ = 0;
        this.zQa = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.cRJ != 0) {
            bVar.aB(1, this.cRJ);
        }
        if (this.zPX != 0) {
            bVar.aB(2, this.zPX);
        }
        if (this.zPY != 0) {
            bVar.aB(3, this.zPY);
        }
        if (this.zPZ != 0) {
            bVar.aB(4, this.zPZ);
        }
        if (this.zQa != 0) {
            bVar.aB(5, this.zQa);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.cRJ != 0) {
            rL += b.aD(1, this.cRJ);
        }
        if (this.zPX != 0) {
            rL += b.aD(2, this.zPX);
        }
        if (this.zPY != 0) {
            rL += b.aD(3, this.zPY);
        }
        if (this.zPZ != 0) {
            rL += b.aD(4, this.zPZ);
        }
        if (this.zQa != 0) {
            return rL + b.aD(5, this.zQa);
        }
        return rL;
    }
}
