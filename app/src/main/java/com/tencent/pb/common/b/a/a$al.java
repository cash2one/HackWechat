package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$al extends e {
    public byte[] buffer;
    public int wJB;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.wJB = aVar.ry();
                    continue;
                case 18:
                    this.buffer = aVar.readBytes();
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

    public a$al() {
        this.wJB = 0;
        this.buffer = g.bfX;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        bVar.aC(1, this.wJB);
        if (!Arrays.equals(this.buffer, g.bfX)) {
            bVar.a(2, this.buffer);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL() + b.aE(1, this.wJB);
        if (Arrays.equals(this.buffer, g.bfX)) {
            return rL;
        }
        return rL + b.b(2, this.buffer);
    }
}
