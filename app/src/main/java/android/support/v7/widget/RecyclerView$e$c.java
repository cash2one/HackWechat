package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;

public class RecyclerView$e$c {
    public int UZ;
    public int bottom;
    public int left;
    public int right;
    public int top;

    public RecyclerView$e$c b(t tVar, int i) {
        View view = tVar.VU;
        this.left = view.getLeft();
        this.top = view.getTop();
        this.right = view.getRight();
        this.bottom = view.getBottom();
        return this;
    }
}
