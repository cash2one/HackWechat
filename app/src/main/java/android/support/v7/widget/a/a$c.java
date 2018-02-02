package android.support.v7.widget.a;

import android.support.v4.a.a;
import android.support.v4.a.b;
import android.support.v4.a.g;
import android.support.v7.widget.RecyclerView$t;

class a$c implements b {
    final RecyclerView$t Vh;
    final int aaN;
    final /* synthetic */ a aaZ;
    final float abh;
    final float abi;
    final float abj;
    final float abk;
    final g abl;
    final int abm;
    public boolean abn;
    float abo;
    float abp;
    boolean abq = false;
    float oN;
    boolean oP = false;

    public a$c(a aVar, RecyclerView$t recyclerView$t, int i, int i2, float f, float f2, float f3, float f4) {
        this.aaZ = aVar;
        this.aaN = i2;
        this.abm = i;
        this.Vh = recyclerView$t;
        this.abh = f;
        this.abi = f2;
        this.abj = f3;
        this.abk = f4;
        this.abl = a.aL();
        this.abl.a(new 1(this, aVar));
        this.abl.w(recyclerView$t.VU);
        this.abl.a(this);
        this.oN = 0.0f;
    }

    public void a(g gVar) {
        if (!this.oP) {
            this.Vh.T(true);
        }
        this.oP = true;
    }

    public final void aM() {
        this.oN = 1.0f;
    }
}
