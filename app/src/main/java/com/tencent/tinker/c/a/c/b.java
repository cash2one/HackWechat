package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.a.c;
import com.tencent.tinker.a.b.a.d;
import com.tencent.tinker.a.b.a.e;
import com.tencent.tinker.a.b.a.f;
import com.tencent.tinker.a.b.a.g;
import com.tencent.tinker.a.b.a.h;

public final class b {
    final a AhI;

    private final class a extends e {
        final /* synthetic */ b AhJ;

        a(b bVar, e eVar) {
            this.AhJ = bVar;
            super(eVar);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j) {
            super.a(i, i2, fP(i3, i4), i4, i5, j);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
            super.a(i, i2, fP(i3, i4), i4, i5, j, i6);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.a(i, i2, fP(i3, i4), i4, i5, j, i6, i7);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
            super.a(i, i2, fP(i3, i4), i4, i5, j, i6, i7, i8);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
            super.a(i, i2, fP(i3, i4), i4, i5, j, i6, i7, i8, i9);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
            super.a(i, i2, fP(i3, i4), i4, i5, j, i6, i7, i8, i9, i10);
        }

        public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.b(i, i2, fP(i3, i4), i4, i5, j, i6, i7);
        }

        private int fP(int i, int i2) {
            switch (i2) {
                case 2:
                    return this.AhJ.AhI.IE(i);
                case 3:
                    return this.AhJ.AhI.ID(i);
                case 4:
                    return this.AhJ.AhI.IH(i);
                case 5:
                    return this.AhJ.AhI.IG(i);
                default:
                    return i;
            }
        }
    }

    public b(a aVar) {
        this.AhI = aVar;
    }

    public final short[] a(short[] sArr) {
        com.tencent.tinker.a.b.a.a hVar = new h(sArr.length);
        e cVar = new c();
        e fVar = new f(hVar, cVar);
        d dVar = new d(new g(sArr));
        try {
            dVar.a(new a(this, cVar));
            dVar.a(new a(this, fVar));
            int i = hVar.AfX;
            if (i == hVar.Agf.length) {
                return hVar.Agf;
            }
            short[] sArr2 = new short[i];
            System.arraycopy(hVar.Agf, 0, sArr2, 0, i);
            return sArr2;
        } catch (Throwable e) {
            throw new j(e);
        }
    }
}
