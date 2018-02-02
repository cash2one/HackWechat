package android.support.v7.widget;

import android.view.View;

class LinearLayoutManager$a {
    final /* synthetic */ LinearLayoutManager Sq;
    int Sr;
    boolean Ss;
    int mPosition;

    LinearLayoutManager$a(LinearLayoutManager linearLayoutManager) {
        this.Sq = linearLayoutManager;
    }

    final void fb() {
        this.Sr = this.Ss ? this.Sq.Sf.fj() : this.Sq.Sf.fi();
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.Sr + ", mLayoutFromEnd=" + this.Ss + '}';
    }

    public final void aS(View view) {
        if (this.Ss) {
            this.Sr = this.Sq.Sf.aV(view) + this.Sq.Sf.fh();
        } else {
            this.Sr = this.Sq.Sf.aU(view);
        }
        this.mPosition = LinearLayoutManager.bd(view);
    }
}
