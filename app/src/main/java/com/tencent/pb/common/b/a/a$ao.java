package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$ao extends e {
    private static volatile a$ao[] zOF;
    public int fps;
    public int nEd;
    public int zOG;
    public int zOs;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.nEd = aVar.ry();
                    continue;
                case 16:
                    this.zOG = aVar.ry();
                    continue;
                case 24:
                    this.fps = aVar.ry();
                    continue;
                case 32:
                    this.zOs = aVar.ry();
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

    public static a$ao[] cCN() {
        if (zOF == null) {
            synchronized (c.bfP) {
                if (zOF == null) {
                    zOF = new a$ao[0];
                }
            }
        }
        return zOF;
    }

    public a$ao() {
        this.nEd = 0;
        this.zOG = 0;
        this.fps = 0;
        this.zOs = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.nEd != 0) {
            bVar.aB(1, this.nEd);
        }
        if (this.zOG != 0) {
            bVar.aB(2, this.zOG);
        }
        if (this.fps != 0) {
            bVar.aB(3, this.fps);
        }
        if (this.zOs != 0) {
            bVar.aB(4, this.zOs);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.nEd != 0) {
            rL += b.aD(1, this.nEd);
        }
        if (this.zOG != 0) {
            rL += b.aD(2, this.zOG);
        }
        if (this.fps != 0) {
            rL += b.aD(3, this.fps);
        }
        if (this.zOs != 0) {
            return rL + b.aD(4, this.zOs);
        }
        return rL;
    }
}
