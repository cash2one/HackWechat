package com.tencent.mm.plugin.appbrand.page;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

public class q extends FrameLayout {
    View Iv;
    private int iN;
    private boolean jEA = false;
    private boolean jEB = false;
    private boolean jEC = false;
    private int jED;
    private int jEE;
    private int jEF;
    private ObjectAnimator jEG = null;
    View jEv;
    FrameLayout jEw;
    FrameLayout jEx;
    public boolean jEy = true;
    boolean jEz = false;

    public q(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -1));
        this.iN = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public final void dd(boolean z) {
        this.jEy = !z;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.jEy) {
            return this.jEC;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            return false;
        }
        if (this.jEB) {
            return true;
        }
        switch (action) {
            case 0:
                if (ajj()) {
                    this.jED = (int) motionEvent.getX();
                    this.jEE = (int) motionEvent.getY();
                    this.jEF = (int) motionEvent.getY();
                    break;
                }
                break;
            case 2:
                if (ajj()) {
                    action = ((int) motionEvent.getX()) - this.jED;
                    int y = ((int) motionEvent.getY()) - this.jEE;
                    if (Math.abs(y) > this.iN && Math.abs(y) > Math.abs(action) && y > 0) {
                        this.jEB = true;
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jEy) {
            if (this.jEC) {
                ajg();
            }
            return this.jEC;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.jEF = (int) motionEvent.getY();
                return true;
            case 1:
            case 3:
                if (this.jEx.getTranslationY() <= ((float) this.jEv.getHeight()) || !this.jEz) {
                    ajg();
                } else {
                    ajf();
                }
                return true;
            case 2:
                int y = (((int) motionEvent.getY()) - this.jEF) >> 1;
                int height = getHeight();
                if (y <= height) {
                    height = y;
                }
                if (this.jEA) {
                    height += ajk();
                }
                height = Math.max(height, 0);
                x.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[]{Integer.valueOf(r4), Integer.valueOf(height)});
                this.jEx.setTranslationY((float) Math.min(getHeight(), height));
                lg(height);
                return true;
            default:
                return false;
        }
    }

    protected final void ajf() {
        li(ajk());
        if (!this.jEA) {
            ajh();
        }
        this.jEB = true;
        this.jEA = true;
        this.jEC = true;
    }

    protected final void ajg() {
        li(0);
        if (this.jEA) {
            aji();
        }
        this.jEB = false;
        this.jEA = false;
        this.jEC = false;
    }

    protected void ajh() {
    }

    protected void aji() {
    }

    protected void lg(int i) {
    }

    public final void lh(int i) {
        this.jEw.setBackgroundColor(i);
    }

    private boolean ajj() {
        if (this.Iv instanceof WebView) {
            return ((WebView) this.Iv).isOverScrollStart();
        }
        return this.Iv.getScrollY() == 0;
    }

    protected int ajk() {
        return this.jEv.getHeight();
    }

    private void li(int i) {
        int translationY = (int) this.jEx.getTranslationY();
        if (translationY != i) {
            x.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[]{Integer.valueOf(translationY), Integer.valueOf(i)});
            if (this.jEG != null) {
                this.jEG.cancel();
            }
            long abs = (long) ((((float) Math.abs(translationY - i)) / ((float) ajk())) * 250.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.jEx, "translationY", new float[]{(float) translationY, (float) i});
            ofFloat.setDuration(Math.min(abs, 250));
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.start();
            ofFloat.addUpdateListener(new 1(this));
            this.jEG = ofFloat;
        }
    }
}
