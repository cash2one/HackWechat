package android.support.v7.widget.a;

import android.support.v7.widget.RecyclerView.d;

class a$5 implements d {
    final /* synthetic */ a aaZ;

    a$5(a aVar) {
        this.aaZ = aVar;
    }

    public final int ac(int i, int i2) {
        if (this.aaZ.aaU == null) {
            return i2;
        }
        int i3 = this.aaZ.aaV;
        if (i3 == -1) {
            i3 = this.aaZ.Va.indexOfChild(this.aaZ.aaU);
            this.aaZ.aaV = i3;
        }
        if (i2 == i - 1) {
            return i3;
        }
        return i2 >= i3 ? i2 + 1 : i2;
    }
}
