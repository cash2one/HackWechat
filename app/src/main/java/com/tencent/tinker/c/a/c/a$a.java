package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.l;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.o;

final class a$a {
    final /* synthetic */ a AhF;
    private final b AhH;

    public a$a(a aVar, b bVar) {
        this.AhF = aVar;
        this.AhH = bVar;
    }

    private void a(m mVar) {
        int i = 0;
        switch (mVar.cGE()) {
            case 0:
                l.a(this.AhH, 0, (long) mVar.readByte());
                return;
            case 2:
                l.a(this.AhH, 2, (long) mVar.readShort());
                return;
            case 3:
                l.b(this.AhH, 3, (long) mVar.readChar());
                return;
            case 4:
                l.a(this.AhH, 4, (long) mVar.readInt());
                return;
            case 6:
                l.a(this.AhH, 6, mVar.readLong());
                return;
            case 16:
                l.c(this.AhH, 16, ((long) Float.floatToIntBits(mVar.readFloat())) << 32);
                return;
            case 17:
                l.c(this.AhH, 17, Double.doubleToLongBits(mVar.readDouble()));
                return;
            case 23:
                l.b(this.AhH, 23, (long) this.AhF.ID(mVar.cGI()));
                return;
            case 24:
                l.b(this.AhH, 24, (long) this.AhF.IE(mVar.cGJ()));
                return;
            case 25:
                l.b(this.AhH, 25, (long) this.AhF.IG(mVar.cGK()));
                return;
            case 26:
                l.b(this.AhH, 26, (long) this.AhF.IH(mVar.cGM()));
                return;
            case 27:
                l.b(this.AhH, 27, (long) this.AhF.IG(mVar.cGL()));
                return;
            case 28:
                fO(28, 0);
                c(mVar);
                return;
            case 29:
                fO(29, 0);
                b(mVar);
                return;
            case 30:
                mVar.cGN();
                fO(30, 0);
                return;
            case 31:
                if (mVar.readBoolean()) {
                    i = 1;
                }
                fO(31, i);
                return;
            default:
                throw new j("Unexpected type: " + Integer.toHexString(mVar.cGE()));
        }
    }

    public final void b(m mVar) {
        int cGG = mVar.cGG();
        o.a(this.AhH, this.AhF.IE(mVar.Afg));
        o.a(this.AhH, cGG);
        for (int i = 0; i < cGG; i++) {
            o.a(this.AhH, this.AhF.ID(mVar.cGH()));
            a(mVar);
        }
    }

    public final void c(m mVar) {
        int cGF = mVar.cGF();
        o.a(this.AhH, cGF);
        for (int i = 0; i < cGF; i++) {
            a(mVar);
        }
    }

    private void fO(int i, int i2) {
        this.AhH.writeByte((i2 << 5) | i);
    }
}
