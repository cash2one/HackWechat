package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.p;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public abstract class z extends p {
    protected final DecelerateInterpolator Eu = new DecelerateInterpolator();
    protected final LinearInterpolator SD = new LinearInterpolator();
    protected PointF SE;
    private final float SF;
    protected int SG = 0;
    protected int SH = 0;

    public abstract PointF bd(int i);

    public z(Context context) {
        this.SF = a(context.getResources().getDisplayMetrics());
    }

    protected final void a(View view, RecyclerView$p$a recyclerView$p$a) {
        int i = 0;
        int fd = fd();
        h hVar = this.TG;
        if (hVar == null || !hVar.eQ()) {
            fd = 0;
        } else {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            fd = e(h.bh(view) - layoutParams.leftMargin, layoutParams.rightMargin + h.bj(view), hVar.getPaddingLeft(), hVar.mWidth - hVar.getPaddingRight(), fd);
        }
        int i2 = (this.SE == null || this.SE.y == 0.0f) ? 0 : this.SE.y > 0.0f ? 1 : -1;
        h hVar2 = this.TG;
        if (hVar2 != null && hVar2.eR()) {
            layoutParams = (LayoutParams) view.getLayoutParams();
            i = e(h.bi(view) - layoutParams.topMargin, layoutParams.bottomMargin + h.bk(view), hVar2.getPaddingTop(), hVar2.mHeight - hVar2.getPaddingBottom(), i2);
        }
        int ceil = (int) Math.ceil(((double) bg((int) Math.sqrt((double) ((fd * fd) + (i * i))))) / 0.3356d);
        if (ceil > 0) {
            recyclerView$p$a.a(-fd, -i, ceil, this.Eu);
        }
    }

    protected final void a(int i, int i2, RecyclerView$p$a recyclerView$p$a) {
        if (this.Va.TV.getChildCount() == 0) {
            stop();
            return;
        }
        this.SG = O(this.SG, i);
        this.SH = O(this.SH, i2);
        if (this.SG == 0 && this.SH == 0) {
            PointF bd = bd(this.Vv);
            if (bd == null || (bd.x == 0.0f && bd.y == 0.0f)) {
                recyclerView$p$a.VC = this.Vv;
                stop();
                return;
            }
            double sqrt = Math.sqrt((double) ((bd.x * bd.x) + (bd.y * bd.y)));
            bd.x = (float) (((double) bd.x) / sqrt);
            bd.y = (float) (((double) bd.y) / sqrt);
            this.SE = bd;
            this.SG = (int) (bd.x * 10000.0f);
            this.SH = (int) (bd.y * 10000.0f);
            recyclerView$p$a.a((int) (((float) this.SG) * 1.2f), (int) (((float) this.SH) * 1.2f), (int) (((float) bg(10000)) * 1.2f), this.SD);
        }
    }

    protected final void onStop() {
        this.SH = 0;
        this.SG = 0;
        this.SE = null;
    }

    public float a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    public int bg(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.SF));
    }

    public int fd() {
        if (this.SE == null || this.SE.x == 0.0f) {
            return 0;
        }
        return this.SE.x > 0.0f ? 1 : -1;
    }

    private static int O(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    private static int e(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? 0 : i6;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }
}
