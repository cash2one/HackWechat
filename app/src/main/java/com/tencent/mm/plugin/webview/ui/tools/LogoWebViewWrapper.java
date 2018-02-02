package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

public class LogoWebViewWrapper extends LinearLayout {
    private Context context;
    private int iN;
    private int lZh;
    WebView lbq;
    FrameLayout twc;
    private boolean twd = false;
    private int twe;
    private int twf;
    private c twg;
    private int twh = 0;
    boolean twi = false;
    boolean twj = false;
    int twk = 0;
    a twl;
    b twm;
    private boolean twn = false;
    private boolean two = false;
    private boolean twp = false;
    private int twq = -1;

    public interface b {
        void S(int i, boolean z);
    }

    public LogoWebViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    @TargetApi(11)
    public LogoWebViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        setOrientation(1);
        this.iN = ViewConfiguration.get(this.context).getScaledTouchSlop();
    }

    public final FrameLayout bSg() {
        if (this.twc == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getId() == R.h.cuy) {
                    this.twc = (FrameLayout) childAt;
                    break;
                }
            }
        }
        return this.twc;
    }

    public final void kr(boolean z) {
        this.twi = z;
        if (this.twi) {
            this.twd = false;
            this.twh = 0;
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.twi && !this.twn) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.twd = false;
            this.twh = 0;
            this.two = false;
            return false;
        } else if (action == 2 && this.twd) {
            return true;
        } else {
            switch (action) {
                case 0:
                    if (this.lbq.isOverScrollStart()) {
                        this.twe = (int) motionEvent.getY();
                        this.lZh = (int) motionEvent.getY();
                        this.twf = (int) motionEvent.getX();
                        this.twd = false;
                        this.twh = 0;
                        this.twn = true;
                        this.two = true;
                        break;
                    }
                    break;
                case 2:
                    if (this.lbq.isOverScrollStart()) {
                        if (this.two) {
                            action = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            int i = action - this.twe;
                            int i2 = x - this.twf;
                            if (Math.abs(i) > this.iN && Math.abs(i) > Math.abs(i2) && i > 0) {
                                this.twe = action;
                                this.twf = x;
                                if (this.twh != 1) {
                                    this.twh++;
                                    break;
                                }
                                this.twd = true;
                                this.two = false;
                                x.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
                                if (this.twl != null) {
                                    this.twl.bSh();
                                    break;
                                }
                            }
                        }
                        this.twe = (int) motionEvent.getY();
                        this.lZh = (int) motionEvent.getY();
                        this.twf = (int) motionEvent.getX();
                        this.twd = false;
                        this.twh = 0;
                        this.twn = true;
                        this.two = true;
                        return this.twd;
                    }
                    break;
            }
            return this.twd;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.twi && !this.twn) {
            return false;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        int i;
        switch (motionEvent.getAction()) {
            case 0:
                this.twn = true;
                if (!this.lbq.isOverScrollStart()) {
                    return false;
                }
                this.twe = (int) motionEvent.getY();
                this.lZh = (int) motionEvent.getY();
                this.twf = (int) motionEvent.getX();
                this.twp = true;
                return true;
            case 1:
            case 3:
                this.twp = false;
                if (!this.twd && !this.twn) {
                    return false;
                }
                this.twd = false;
                i = -this.twk;
                long abs = (long) Math.abs(getScrollY());
                long abs2 = Math.abs(abs - ((long) Math.abs(this.twk)));
                if (abs2 >= abs) {
                    abs = 300;
                } else {
                    abs = (long) ((((float) abs2) / ((float) abs)) * 300.0f);
                }
                O(i, abs);
                post(new 1(this));
                return true;
            case 2:
                if (!this.twd) {
                    return false;
                }
                if (this.twp) {
                    this.twe = (int) motionEvent.getY();
                    this.twf = (int) motionEvent.getX();
                    int min = Math.min(this.lZh - this.twe, 0) >> 1;
                    int height = getHeight();
                    if (this.twq < 0) {
                        this.twq = (int) TypedValue.applyDimension(1, 60.0f, this.context.getResources().getDisplayMetrics());
                    }
                    i = ((int) Math.sqrt((double) ((this.twq >> 1) * Math.abs(min)))) << 1;
                    if (i <= Math.abs(min)) {
                        min = -i;
                    } else if (Math.abs(min) > height) {
                        min = -height;
                    }
                    AA(min);
                    if (this.twm != null) {
                        this.twm.S(min, true);
                    }
                    return true;
                }
                this.twe = (int) motionEvent.getY();
                this.lZh = (int) motionEvent.getY();
                this.twf = (int) motionEvent.getX();
                this.twp = true;
                return true;
            default:
                return false;
        }
    }

    public final void AA(int i) {
        int height = getHeight();
        scrollTo(0, Math.min(height, Math.max(-height, i)));
    }

    public final void O(int i, long j) {
        if (this.twg != null) {
            Runnable runnable = this.twg;
            runnable.twv = false;
            runnable.twr.removeCallbacks(runnable);
        }
        int scrollY = getScrollY();
        x.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[]{Integer.valueOf(scrollY), Integer.valueOf(i)});
        if (scrollY != i) {
            this.twg = new c(this, scrollY, i, j);
            post(this.twg);
        }
    }
}
