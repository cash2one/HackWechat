package android.support.v7.widget;

import android.view.animation.Interpolator;

public class RecyclerView$p$a {
    private int VA;
    private int VB;
    int VC;
    private boolean VD;
    private int VE;
    private int mDuration;
    private Interpolator mInterpolator;

    static /* synthetic */ void a(RecyclerView$p$a recyclerView$p$a, RecyclerView recyclerView) {
        if (recyclerView$p$a.VC >= 0) {
            int i = recyclerView$p$a.VC;
            recyclerView$p$a.VC = -1;
            RecyclerView.d(recyclerView, i);
            recyclerView$p$a.VD = false;
        } else if (!recyclerView$p$a.VD) {
            recyclerView$p$a.VE = 0;
        } else if (recyclerView$p$a.mInterpolator != null && recyclerView$p$a.mDuration <= 0) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else if (recyclerView$p$a.mDuration <= 0) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        } else {
            if (recyclerView$p$a.mInterpolator != null) {
                RecyclerView.x(recyclerView).b(recyclerView$p$a.VA, recyclerView$p$a.VB, recyclerView$p$a.mDuration, recyclerView$p$a.mInterpolator);
            } else if (recyclerView$p$a.mDuration == Integer.MIN_VALUE) {
                RecyclerView.x(recyclerView).smoothScrollBy(recyclerView$p$a.VA, recyclerView$p$a.VB);
            } else {
                RecyclerView.x(recyclerView).o(recyclerView$p$a.VA, recyclerView$p$a.VB, recyclerView$p$a.mDuration);
            }
            recyclerView$p$a.VE++;
            recyclerView$p$a.VD = false;
        }
    }

    public RecyclerView$p$a() {
        this(0, 0);
    }

    private RecyclerView$p$a(int i, int i2) {
        this.VC = -1;
        this.VD = false;
        this.VE = 0;
        this.VA = 0;
        this.VB = 0;
        this.mDuration = Integer.MIN_VALUE;
        this.mInterpolator = null;
    }

    public final void a(int i, int i2, int i3, Interpolator interpolator) {
        this.VA = i;
        this.VB = i2;
        this.mDuration = i3;
        this.mInterpolator = interpolator;
        this.VD = true;
    }
}
