package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    private boolean Bt = false;
    private boolean Bu = false;
    private final Runnable Bv = new 1(this);
    private final Runnable Bw = new Runnable(this) {
        final /* synthetic */ ContentLoadingProgressBar Bx;

        {
            this.Bx = r1;
        }

        public final void run() {
            this.Bx.Bu = false;
            if (!this.Bx.qd) {
                this.Bx.mStartTime = System.currentTimeMillis();
                this.Bx.setVisibility(0);
            }
        }
    };
    private long mStartTime = -1;
    private boolean qd = false;

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        cn();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cn();
    }

    private void cn() {
        removeCallbacks(this.Bv);
        removeCallbacks(this.Bw);
    }
}
