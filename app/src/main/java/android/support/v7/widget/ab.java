package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;

public abstract class ab {
    protected final h TG;
    int TH;

    static class AnonymousClass1 extends ab {
        AnonymousClass1(h hVar) {
            super(hVar);
        }

        public final int fj() {
            return this.TG.mWidth - this.TG.getPaddingRight();
        }

        public final int getEnd() {
            return this.TG.mWidth;
        }

        public final void bh(int i) {
            this.TG.bn(i);
        }

        public final int fi() {
            return this.TG.getPaddingLeft();
        }

        public final int aW(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + (h.bf(view) + layoutParams.leftMargin);
        }

        public final int aX(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + (h.bg(view) + layoutParams.topMargin);
        }

        public final int aV(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + h.bj(view);
        }

        public final int aU(View view) {
            return h.bh(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
        }

        public final int fk() {
            return (this.TG.mWidth - this.TG.getPaddingLeft()) - this.TG.getPaddingRight();
        }

        public final int getEndPadding() {
            return this.TG.getPaddingRight();
        }

        public final int getMode() {
            return this.TG.Vf;
        }

        public final int fl() {
            return this.TG.Vg;
        }
    }

    public abstract int aU(View view);

    public abstract int aV(View view);

    public abstract int aW(View view);

    public abstract int aX(View view);

    public abstract void bh(int i);

    public abstract int fi();

    public abstract int fj();

    public abstract int fk();

    public abstract int fl();

    public abstract int getEnd();

    public abstract int getEndPadding();

    public abstract int getMode();

    private ab(h hVar) {
        this.TH = Integer.MIN_VALUE;
        this.TG = hVar;
    }

    public final int fh() {
        return Integer.MIN_VALUE == this.TH ? 0 : fk() - this.TH;
    }
}
