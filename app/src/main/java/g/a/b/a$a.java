package g.a.b;

import g.a.c.a;
import g.a.c.b;

class a$a {
    short[] Azq = new short[2];
    a[] Azr = new a[16];
    a[] Azs = new a[16];
    a Azt = new a(8);
    int Azu = 0;
    final /* synthetic */ a Azv;

    a$a(a aVar) {
        this.Azv = aVar;
    }

    public final void Jp(int i) {
        while (this.Azu < i) {
            this.Azr[this.Azu] = new a(3);
            this.Azs[this.Azu] = new a(3);
            this.Azu++;
        }
    }

    public final void cKt() {
        b.b(this.Azq);
        for (int i = 0; i < this.Azu; i++) {
            b.b(this.Azr[i].AzC);
            b.b(this.Azs[i].AzC);
        }
        b.b(this.Azt.AzC);
    }

    public final int a(b bVar, int i) {
        if (bVar.d(this.Azq, 0) == 0) {
            return this.Azr[i].a(bVar);
        }
        if (bVar.d(this.Azq, 1) == 0) {
            return this.Azs[i].a(bVar) + 8;
        }
        return (this.Azt.a(bVar) + 8) + 8;
    }
}
