package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$n extends e {
    private static volatile a$n[] zNl;
    public byte[] fyO;
    public int zNm;
    public int zNn;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.zNm = aVar.ry();
                    continue;
                case 18:
                    this.fyO = aVar.readBytes();
                    continue;
                case 24:
                    this.zNn = aVar.ry();
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

    public static a$n[] cCJ() {
        if (zNl == null) {
            synchronized (c.bfP) {
                if (zNl == null) {
                    zNl = new a$n[0];
                }
            }
        }
        return zNl;
    }

    public a$n() {
        this.zNm = 0;
        this.fyO = g.bfX;
        this.zNn = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.zNm != 0) {
            bVar.aB(1, this.zNm);
        }
        if (!Arrays.equals(this.fyO, g.bfX)) {
            bVar.a(2, this.fyO);
        }
        if (this.zNn != 0) {
            bVar.aC(3, this.zNn);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.zNm != 0) {
            rL += b.aD(1, this.zNm);
        }
        if (!Arrays.equals(this.fyO, g.bfX)) {
            rL += b.b(2, this.fyO);
        }
        if (this.zNn != 0) {
            return rL + b.aE(3, this.zNn);
        }
        return rL;
    }
}
