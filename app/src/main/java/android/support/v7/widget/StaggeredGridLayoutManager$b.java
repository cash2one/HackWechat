package android.support.v7.widget;

import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import java.util.ArrayList;

class StaggeredGridLayoutManager$b {
    final /* synthetic */ StaggeredGridLayoutManager Yb;
    ArrayList<View> Yo;
    int Yp;
    int Yq;
    int Yr;
    final int mIndex;

    final int bJ(int i) {
        if (this.Yp != Integer.MIN_VALUE) {
            return this.Yp;
        }
        if (this.Yo.size() == 0) {
            return i;
        }
        gL();
        return this.Yp;
    }

    private void gL() {
        View view = (View) this.Yo.get(0);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        this.Yp = this.Yb.XN.aU(view);
        if (layoutParams.Ye) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem bH = this.Yb.XS.bH(layoutParams.Vh.gd());
            if (bH != null && bH.Yg == -1) {
                this.Yp -= bH.bI(this.mIndex);
            }
        }
    }

    final int gM() {
        if (this.Yp != Integer.MIN_VALUE) {
            return this.Yp;
        }
        gL();
        return this.Yp;
    }

    final int bK(int i) {
        if (this.Yq != Integer.MIN_VALUE) {
            return this.Yq;
        }
        if (this.Yo.size() == 0) {
            return i;
        }
        gN();
        return this.Yq;
    }

    private void gN() {
        View view = (View) this.Yo.get(this.Yo.size() - 1);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        this.Yq = this.Yb.XN.aV(view);
        if (layoutParams.Ye) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem bH = this.Yb.XS.bH(layoutParams.Vh.gd());
            if (bH != null && bH.Yg == 1) {
                this.Yq = bH.bI(this.mIndex) + this.Yq;
            }
        }
    }

    final int gO() {
        if (this.Yq != Integer.MIN_VALUE) {
            return this.Yq;
        }
        gN();
        return this.Yq;
    }

    final void bp(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.Yd = this;
        this.Yo.add(0, view);
        this.Yp = Integer.MIN_VALUE;
        if (this.Yo.size() == 1) {
            this.Yq = Integer.MIN_VALUE;
        }
        if (layoutParams.Vh.isRemoved() || layoutParams.Vh.gr()) {
            this.Yr += this.Yb.XN.aW(view);
        }
    }

    final void bq(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.Yd = this;
        this.Yo.add(view);
        this.Yq = Integer.MIN_VALUE;
        if (this.Yo.size() == 1) {
            this.Yp = Integer.MIN_VALUE;
        }
        if (layoutParams.Vh.isRemoved() || layoutParams.Vh.gr()) {
            this.Yr += this.Yb.XN.aW(view);
        }
    }

    final void clear() {
        this.Yo.clear();
        this.Yp = Integer.MIN_VALUE;
        this.Yq = Integer.MIN_VALUE;
        this.Yr = 0;
    }

    final void bL(int i) {
        this.Yp = i;
        this.Yq = i;
    }

    final void gP() {
        int size = this.Yo.size();
        View view = (View) this.Yo.remove(size - 1);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.Yd = null;
        if (layoutParams.Vh.isRemoved() || layoutParams.Vh.gr()) {
            this.Yr -= this.Yb.XN.aW(view);
        }
        if (size == 1) {
            this.Yp = Integer.MIN_VALUE;
        }
        this.Yq = Integer.MIN_VALUE;
    }

    final void gQ() {
        View view = (View) this.Yo.remove(0);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.Yd = null;
        if (this.Yo.size() == 0) {
            this.Yq = Integer.MIN_VALUE;
        }
        if (layoutParams.Vh.isRemoved() || layoutParams.Vh.gr()) {
            this.Yr -= this.Yb.XN.aW(view);
        }
        this.Yp = Integer.MIN_VALUE;
    }

    final void bM(int i) {
        if (this.Yp != Integer.MIN_VALUE) {
            this.Yp += i;
        }
        if (this.Yq != Integer.MIN_VALUE) {
            this.Yq += i;
        }
    }

    public final View ak(int i, int i2) {
        View view = null;
        int size;
        View view2;
        if (i2 == -1) {
            size = this.Yo.size();
            int i3 = 0;
            while (i3 < size) {
                view2 = (View) this.Yo.get(i3);
                if (!view2.isFocusable()) {
                    break;
                }
                boolean z;
                if (StaggeredGridLayoutManager.bd(view2) > i) {
                    z = true;
                } else {
                    z = false;
                }
                if (z != StaggeredGridLayoutManager.b(this.Yb)) {
                    break;
                }
                i3++;
                view = view2;
            }
            return view;
        }
        for (size = this.Yo.size() - 1; size >= 0; size--) {
            view2 = (View) this.Yo.get(size);
            if (!view2.isFocusable()) {
                break;
            }
            Object obj;
            if (StaggeredGridLayoutManager.bd(view2) > i) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != (!StaggeredGridLayoutManager.b(this.Yb) ? 1 : null)) {
                break;
            }
            view = view2;
        }
        return view;
    }
}
