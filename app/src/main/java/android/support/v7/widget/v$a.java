package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.t;

class v$a {
    public t Rl;
    public t Rm;
    public int Rn;
    public int Ro;
    public int Rp;
    public int Rq;

    private v$a(t tVar, t tVar2) {
        this.Rl = tVar;
        this.Rm = tVar2;
    }

    private v$a(t tVar, t tVar2, int i, int i2, int i3, int i4) {
        this(tVar, tVar2);
        this.Rn = i;
        this.Ro = i2;
        this.Rp = i3;
        this.Rq = i4;
    }

    public final String toString() {
        return "ChangeInfo{oldHolder=" + this.Rl + ", newHolder=" + this.Rm + ", fromX=" + this.Rn + ", fromY=" + this.Ro + ", toX=" + this.Rp + ", toY=" + this.Rq + '}';
    }
}
