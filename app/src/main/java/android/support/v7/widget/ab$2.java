package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;

class ab$2 extends ab {
    ab$2(h hVar) {
        super(hVar, (byte) 0);
    }

    public final int fj() {
        return this.TG.mHeight - this.TG.getPaddingBottom();
    }

    public final int getEnd() {
        return this.TG.mHeight;
    }

    public final void bh(int i) {
        this.TG.bo(i);
    }

    public final int fi() {
        return this.TG.getPaddingTop();
    }

    public final int aW(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (h.bg(view) + layoutParams.topMargin);
    }

    public final int aX(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (h.bf(view) + layoutParams.leftMargin);
    }

    public final int aV(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + h.bk(view);
    }

    public final int aU(View view) {
        return h.bi(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
    }

    public final int fk() {
        return (this.TG.mHeight - this.TG.getPaddingTop()) - this.TG.getPaddingBottom();
    }

    public final int getEndPadding() {
        return this.TG.getPaddingBottom();
    }

    public final int getMode() {
        return this.TG.Vg;
    }

    public final int fl() {
        return this.TG.Vf;
    }
}
