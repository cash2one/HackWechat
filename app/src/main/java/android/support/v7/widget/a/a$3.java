package android.support.v7.widget.a;

import android.support.v4.a.g;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.a.a.4;

class a$3 extends a$c {
    final /* synthetic */ a aaZ;
    final /* synthetic */ int aba;
    final /* synthetic */ RecyclerView$t abb;

    a$3(a aVar, RecyclerView$t recyclerView$t, int i, int i2, float f, float f2, float f3, float f4, int i3, RecyclerView$t recyclerView$t2) {
        this.aaZ = aVar;
        this.aba = i3;
        this.abb = recyclerView$t2;
        super(aVar, recyclerView$t, i, i2, f, f2, f3, f4);
    }

    public final void a(g gVar) {
        super.a(gVar);
        if (!this.abq) {
            if (this.aba <= 0) {
                this.aaZ.aaM.c(this.aaZ.Va, this.abb);
            } else {
                this.aaZ.aaB.add(this.abb.VU);
                this.abn = true;
                if (this.aba > 0) {
                    a aVar = this.aaZ;
                    aVar.Va.post(new 4(aVar, this, this.aba));
                }
            }
            if (this.aaZ.aaU == this.abb.VU) {
                this.aaZ.bx(this.abb.VU);
            }
        }
    }
}
