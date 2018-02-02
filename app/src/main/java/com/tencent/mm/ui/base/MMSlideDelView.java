package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class MMSlideDelView extends ViewGroup {
    private VelocityTracker ft;
    private final int iN;
    public f kBC;
    public c kBD;
    public d kBF;
    private boolean kHG = false;
    public boolean mAK = true;
    private af mHandler = new af();
    private int nXs;
    long time;
    private final Scroller yJ;
    private boolean ydm = false;
    private b ydn;
    private Runnable ydo;
    private long ydp;
    private boolean ydq = false;
    private a ydr = null;
    private float za;
    private float zb;

    public interface e {
        void bo(Object obj);
    }

    public interface f {
        void t(View view, int i);
    }

    public static d cpx() {
        return new 1();
    }

    public MMSlideDelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yJ = new Scroller(context, new LinearInterpolator());
        this.iN = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.ydp = (long) ViewConfiguration.getLongPressTimeout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() >= 2) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    childAt.layout(i5, 0, i5 + measuredWidth, i4 - i2);
                    i5 += measuredWidth;
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (getChildCount() >= 2) {
            int size = MeasureSpec.getSize(i);
            try {
                getChildAt(0).measure(i, i2);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
            int max = Math.max(0, getChildAt(0).getMeasuredHeight());
            LayoutParams layoutParams = getChildAt(1).getLayoutParams();
            View childAt = getChildAt(1);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                try {
                    childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), MeasureSpec.makeMeasureSpec(max, 1073741824));
                } catch (ArrayIndexOutOfBoundsException e2) {
                }
                max = Math.max(max, childAt.getMeasuredHeight());
            }
            setMeasuredDimension(resolveSize(size, i), resolveSize(max, i2));
        }
    }

    public final void setView(View view) {
        if (getChildCount() == 2) {
            removeViewAt(0);
        }
        addView(view, 0, new LayoutParams(-1, -2));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mAK) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.kBF.aUx() && !this.ydm) {
            x.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
            this.ydq = false;
            this.kBF.aUy();
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        if (this.ydq) {
            return false;
        }
        switch (action) {
            case 0:
                if (getContext() instanceof MMActivity) {
                    ((MMActivity) getContext()).aWs();
                }
                this.kHG = false;
                if (!this.yJ.isFinished()) {
                    this.yJ.abortAnimation();
                }
                this.time = System.currentTimeMillis();
                if (this.kBD != null) {
                    this.nXs = this.kBD.ci(this);
                }
                if (this.ydn == null) {
                    this.ydn = new b(this);
                }
                this.mHandler.postDelayed(this.ydn, (long) ViewConfiguration.getTapTimeout());
                this.za = x;
                this.zb = y;
                if (this.ydr == null) {
                    this.ydr = new a(this, (byte) 0);
                }
                g gVar = this.ydr;
                gVar.ydt = gVar.yds.getWindowAttachCount();
                this.mHandler.postDelayed(this.ydr, this.ydp);
                return true;
            case 1:
                cpy();
                if (this.kHG || ((!isPressed() && System.currentTimeMillis() - this.time >= 200) || this.kBC == null || this.ydm)) {
                    setPressed(false);
                } else {
                    setPressed(true);
                    if (this.ydo != null) {
                        removeCallbacks(this.ydo);
                    }
                    this.ydo = new 2(this);
                    this.mHandler.postDelayed(this.ydo, (long) ViewConfiguration.getPressedStateDuration());
                }
                if (this.kHG) {
                    cpz();
                }
                hf();
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.ydr);
                return true;
            case 2:
                int i = (int) (this.za - x);
                action = (int) (this.zb - y);
                int scrollX = getScrollX();
                if (!this.kHG) {
                    boolean z;
                    if (i >= 0 && Math.abs(i) >= this.iN / 3) {
                        if (action == 0) {
                            action = 1;
                        }
                        if (Math.abs(i / action) > 3) {
                            z = true;
                            if (z || this.ydm) {
                                this.kHG = true;
                                ey(true);
                            }
                        }
                    }
                    z = false;
                    this.kHG = true;
                    ey(true);
                }
                if (this.kHG) {
                    View childAt = getChildAt(1);
                    if (!(childAt == null || childAt.isShown())) {
                        childAt.setVisibility(0);
                    }
                    cpy();
                    setPressed(false);
                    ey(true);
                    if (scrollX + i < 0) {
                        action = -scrollX;
                    } else if (scrollX + i > getChildAt(1).getWidth()) {
                        action = getChildAt(1).getWidth() - scrollX;
                    } else {
                        action = i;
                    }
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacks(this.ydr);
                    }
                    scrollBy(action, 0);
                }
                this.za = x;
                this.zb = y;
                return true;
            case 3:
                cpy();
                setPressed(false);
                if (this.kHG) {
                    cpz();
                }
                hf();
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.ydr);
                return true;
            default:
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.ydr);
                return true;
        }
    }

    private void hf() {
        if (this.ft != null) {
            this.ft.clear();
            this.ft = null;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        x.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
        this.ydq = false;
        super.onWindowFocusChanged(z);
    }

    private void cpy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ydn);
        }
    }

    private void cpz() {
        setPressed(false);
        if (this.ydm) {
            cpB();
            return;
        }
        MMSlideDelView mMSlideDelView;
        VelocityTracker velocityTracker = this.ft;
        velocityTracker.computeCurrentVelocity(1000);
        int xVelocity = (int) velocityTracker.getXVelocity();
        int scrollX;
        int width;
        if (xVelocity < -600) {
            scrollX = getScrollX();
            width = getChildAt(1).getWidth() - scrollX;
            this.kBF.a(this, true);
            this.ydm = true;
            this.yJ.startScroll(scrollX, 0, width, 0, 100);
            mMSlideDelView = this;
        } else if (xVelocity > 600) {
            cpB();
            if (this.ft != null) {
                this.ft.recycle();
                this.ft = null;
            }
            this.kHG = false;
            ey(false);
        } else {
            scrollX = getScrollX();
            xVelocity = getChildAt(1).getWidth();
            width = xVelocity - scrollX;
            if (scrollX > xVelocity / 2) {
                this.kBF.a(this, true);
                this.ydm = true;
                this.yJ.startScroll(scrollX, 0, width, 0, 100);
                mMSlideDelView = this;
            } else {
                this.ydm = false;
                this.kBF.a(this, false);
                this.yJ.startScroll(scrollX, 0, -scrollX, 0, 100);
                mMSlideDelView = this;
            }
        }
        mMSlideDelView.invalidate();
        if (this.ft != null) {
            this.ft.recycle();
            this.ft = null;
        }
        this.kHG = false;
        ey(false);
    }

    private void ey(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void cpA() {
        this.kBF.a(this, false);
        this.ydm = false;
        scrollTo(0, 0);
        invalidate();
    }

    public final void cpB() {
        int scrollX = getScrollX();
        this.kBF.a(this, false);
        this.ydm = false;
        this.yJ.startScroll(scrollX, 0, -scrollX, 0, 100);
        invalidate();
    }

    public void computeScroll() {
        if (this.yJ.computeScrollOffset()) {
            scrollTo(this.yJ.getCurrX(), this.yJ.getCurrY());
            postInvalidate();
        }
    }

    public Bitmap getDrawingCache() {
        return null;
    }

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public void buildDrawingCache(boolean z) {
    }

    public void buildDrawingCache() {
    }
}
