package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;

public class MMADFlipper extends ViewGroup {
    private VelocityTracker ft;
    private int iN;
    private Context mContext;
    private int xYH;
    private Interpolator xYI;
    private int xYJ;
    private int xYK;
    private boolean xYL;
    private boolean xYM;
    private Scroller yJ;
    private float za;
    private float zb;

    public MMADFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMADFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xYH = 0;
        this.xYL = false;
        this.xYM = true;
        this.mContext = context;
        this.xYI = new LinearInterpolator();
        this.yJ = new Scroller(this.mContext, this.xYI);
        this.iN = ViewConfiguration.get(this.mContext).getScaledDoubleTapSlop();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        MeasureSpec.getSize(i);
        MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
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
                if (action > 600) {
                    if (coR()) {
                        this.xYJ--;
                        Eu(this.xYJ);
                    }
                    this.xYL = true;
                } else if (action < -600) {
                    if (coR()) {
                        this.xYJ++;
                        Eu(this.xYJ);
                    }
                    this.xYL = true;
                } else {
                    action = getWidth();
                    Eu((getScrollX() + (action / 2)) / action);
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

    private boolean coR() {
        if (getChildCount() > 1) {
            return true;
        }
        return false;
    }

    private void Eu(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (max * getWidth()) - getScrollX();
            this.yJ.startScroll(getScrollX(), 0, width, 0, a.ad(getContext(), Math.abs(width) * 2));
            invalidate();
        }
        x.d("MicroMsg.MMFlipper", "mCurScreen:%d, mLastScreen:%d, whichScreen:%d", Integer.valueOf(this.xYJ), Integer.valueOf(this.xYK), Integer.valueOf(i));
        this.xYK = i;
    }

    public void computeScroll() {
        if (this.yJ.computeScrollOffset()) {
            scrollTo(this.yJ.getCurrX(), this.yJ.getCurrY());
            postInvalidate();
        } else if (this.xYL) {
            this.xYL = false;
            if (this.xYJ <= 0) {
                this.xYJ = getChildCount() > 1 ? getChildCount() - 2 : getChildCount();
                Ev(this.xYJ * getWidth());
            } else if (this.xYJ >= getChildCount() - 1) {
                this.xYJ = 1;
                Ev(this.xYJ * getWidth());
            }
        }
    }

    @TargetApi(14)
    private void Ev(int i) {
        if (VERSION.SDK_INT >= 14) {
            setScrollX(i);
        } else if (this.yJ != null) {
            this.yJ.setFinalX(i);
        }
    }
}
