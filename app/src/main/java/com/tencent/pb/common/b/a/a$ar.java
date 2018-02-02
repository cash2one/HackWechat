package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$ar extends e {
    private static volatile a$ar[] zOJ;
    public int zOK;
    public int zOL;
    public byte[] zOM;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.zOK = aVar.ry();
                    continue;
                case 16:
                    this.zOL = aVar.ry();
                    continue;
                case 26:
                    this.zOM = aVar.readBytes();
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

    public static a$ar[] cCO() {
        if (zOJ == null) {
            synchronized (c.bfP) {
                if (zOJ == null) {
                    zOJ = new a$ar[0];
                }
            }
        }
        return zOJ;
    }

    public a$ar() {
        this.zOK = 0;
        this.zOL = 0;
        this.zOM = g.bfX;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.zOK != 0) {
            bVar.aB(1, this.zOK);
        }
        if (this.zOL != 0) {
            bVar.aB(2, this.zOL);
        }
        if (!Arrays.equals(this.zOM, g.bfX)) {
            bVar.a(3, this.zOM);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.zOK != 0) {
            rL += b.aD(1, this.zOK);
        }
        if (this.zOL != 0) {
            rL += b.aD(2, this.zOL);
        }
        if (Arrays.equals(this.zOM, g.bfX)) {
            return rL;
        }
        return rL + b.b(3, this.zOM);
    }
}
