package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class MMFlipper extends ViewGroup {
    private Interpolator fe;
    private VelocityTracker ft;
    private int iN;
    private int xYH;
    protected int xYJ;
    protected int xYK;
    public boolean xYM;
    private Scroller yJ;
    protected int yah;
    private int yai;
    private boolean yaj;
    public b yak;
    public a yal;
    int yam;
    int yan;
    private float za;
    private float zb;

    public MMFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context);
    }

    public MMFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yai = 0;
        this.xYH = 0;
        this.yaj = false;
        this.xYM = true;
        this.yam = -123454321;
        this.yan = -123454321;
        init(context);
    }

    private void init(Context context) {
        this.fe = new c();
        this.yJ = new Scroller(context, this.fe);
        this.xYK = -1;
        int i = this.yai;
        this.xYJ = i;
        this.yah = i;
        this.iN = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        long Wq = bh.Wq();
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                x.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:" + measuredWidth);
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
        x.v("MicroMsg.MMFlipper", "use " + bh.bA(Wq) + " ms, flipper onLayout changed:" + z + " Left,Top,Right,Bottom:" + i + "," + i2 + "," + i3 + "," + i4);
    }

    protected void onMeasure(int i, int i2) {
        long Wq = bh.Wq();
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.yal != null) {
            this.yal.dm(size, size2);
        }
        this.yam = size;
        this.yan = size2;
        int childCount = getChildCount();
        for (size2 = 0; size2 < childCount; size2++) {
            getChildAt(size2).measure(i, i2);
        }
        scrollTo(this.xYJ * size, 0);
        x.v("MicroMsg.MMFlipper", "flipper onMeasure:" + size + "," + MeasureSpec.getSize(i2) + " childCount:" + childCount + ", use " + bh.bA(Wq));
    }

    private void Eu(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (getWidth() * max) - getScrollX();
            this.yJ.startScroll(getScrollX(), 0, width, 0, a.ad(getContext(), (int) (((float) Math.abs(width)) * 1.3f)));
            if (this.xYJ != max) {
                this.yaj = true;
                this.yah += max - this.xYJ;
            }
            this.xYK = this.xYJ;
            this.xYJ = max;
            invalidate();
        }
    }

    public final void EJ(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        this.yaj = false;
        if (!this.yJ.isFinished()) {
            this.yJ.abortAnimation();
        }
        this.xYK = this.xYJ;
        this.xYJ = max;
        scrollTo(max * getWidth(), 0);
    }

    public final void EK(int i) {
        this.yah = i;
    }

    public final void EL(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        this.yaj = false;
        if (!this.yJ.isFinished()) {
            this.yJ.abortAnimation();
        }
        if (this.yak != null) {
            this.yak.vJ(max);
        }
        this.xYK = this.xYJ;
        this.xYJ = max;
        this.yah = max;
        scrollTo(max * getWidth(), 0);
    }

    public final int coY() {
        x.d("MicroMsg.MMFlipper", "cur screen is %d", new Object[]{Integer.valueOf(this.xYJ)});
        return this.xYJ;
    }

    public void computeScroll() {
        this.yJ.getCurrX();
        if (this.yJ.computeScrollOffset()) {
            scrollTo(this.yJ.getCurrX(), this.yJ.getCurrY());
            postInvalidate();
        } else if (this.yaj) {
            this.yaj = false;
            if (this.yak != null) {
                this.yak.vJ(this.yah);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() == 1) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        motionEvent.getY();
        switch (action) {
            case 0:
                if (!this.yJ.isFinished()) {
                    this.yJ.abortAnimation();
                }
                this.za = x;
                return true;
            case 1:
            case 3:
                VelocityTracker velocityTracker = this.ft;
                velocityTracker.computeCurrentVelocity(1000);
                action = (int) velocityTracker.getXVelocity();
                if (action > 600 && this.xYJ > 0) {
                    Eu(this.xYJ - 1);
                } else if (action >= -600 || this.xYJ >= getChildCount() - 1) {
                    action = getWidth();
                    Eu((getScrollX() + (action / 2)) / action);
                } else {
                    Eu(this.xYJ + 1);
                }
                if (this.ft != null) {
                    this.ft.recycle();
                    this.ft = null;
                }
                this.xYH = 0;
                this.za = 0.0f;
                this.zb = 0.0f;
                return true;
            case 2:
                action = (int) (this.za - x);
                this.za = x;
                scrollBy(action, 0);
                return true;
            default:
                return true;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.xYM) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (getChildCount() == 1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.xYH != 0) {
            return true;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.za = x;
                this.zb = y;
                this.xYH = this.yJ.isFinished() ? 0 : 1;
                break;
            case 1:
            case 3:
                this.xYH = 0;
                break;
            case 2:
                boolean z;
                action = (int) Math.abs(this.za - x);
                int abs = (int) Math.abs(this.zb - y);
                x.v("MicroMsg.MMFlipper", "xDif = " + action + ", yDif = " + abs);
                if (action <= this.iN || abs >= this.iN) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    this.xYH = 0;
                    break;
                }
                this.xYH = 1;
                break;
                break;
        }
        if (this.xYH == 0) {
            return false;
        }
        return true;
    }
}
