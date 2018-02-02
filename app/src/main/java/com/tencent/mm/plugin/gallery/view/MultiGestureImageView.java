package com.tencent.mm.plugin.gallery.view;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import java.lang.ref.WeakReference;

public class MultiGestureImageView extends LinearLayout {
    private int VQ;
    private int VR;
    private int count = 0;
    private float fdp;
    private int kDP;
    private int kDQ;
    private MultiTouchImageView mVb;
    private long mVc = 0;
    private long mVd = 0;
    private float mVe = 0.0f;
    private float mVf = 0.0f;
    private long mVg = 0;
    private boolean mVh = false;
    private OverScroller mVi;
    private GestureDetector mVj;
    private RectF mVk = new RectF();
    private a mVl;
    private float mVm;
    private boolean mVn = false;
    private boolean mVo = false;
    private boolean mVp = false;
    private boolean mVq = false;
    private j mVr;
    private j mVs;
    private j mVt;
    private d mVu;
    private b mVv;

    private class f extends a {
        final /* synthetic */ MultiGestureImageView mVw;
        float[] mVx = new float[9];
        MultiTouchImageView mVy;

        public f(MultiGestureImageView multiGestureImageView, MultiTouchImageView multiTouchImageView) {
            this.mVw = multiGestureImageView;
            super(multiGestureImageView);
            this.mVy = multiTouchImageView;
        }

        public final void play() {
            this.mVw.mVb.getHandler().post(new 1(this));
        }
    }

    private class h extends a {
        final /* synthetic */ MultiGestureImageView mVw;
        float[] mVx = new float[9];
        MultiTouchImageView mVy;

        public h(MultiGestureImageView multiGestureImageView, MultiTouchImageView multiTouchImageView) {
            this.mVw = multiGestureImageView;
            super(multiGestureImageView);
            this.mVy = multiTouchImageView;
        }

        public final void play() {
            this.mVw.mVb.getHandler().post(new 1(this));
        }
    }

    public MultiGestureImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MultiGestureImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mVb = new MultiTouchImageView(context, attributeSet);
        this.mVj = new GestureDetector(context, new c(this, (byte) 0));
        this.mVi = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.mVb.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.mVb);
        this.mVr = new j(this, new WeakReference(this));
        this.mVs = new j(this, new WeakReference(this));
        this.mVt = new j(this, new WeakReference(this));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.kDP = MeasureSpec.getSize(i);
        this.kDQ = MeasureSpec.getSize(i2);
        this.mVk.set(0.0f, 0.0f, (float) this.kDP, (float) this.kDQ);
        x.v("MicroMsg.MuitlGestureImageView", "MMGestureGallery width:" + this.kDP + " height:" + this.kDQ);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mVj.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.mVi.forceFinished(true);
            this.mVt.removeMessages(2);
            this.mVt.i(2, 500, 0);
            this.mVb.cpW();
            this.count++;
            if (this.count == 1) {
                this.mVc = System.currentTimeMillis();
                this.mVe = g.i(motionEvent, 0);
                this.mVf = g.j(motionEvent, 0);
            } else if (this.count == 2) {
                this.mVg = System.currentTimeMillis();
                if (this.mVg - this.mVd >= 350) {
                    this.count = 1;
                } else if (Math.abs(this.mVe - g.i(motionEvent, 0)) >= 35.0f || Math.abs(this.mVf - g.j(motionEvent, 0)) >= 35.0f) {
                    this.count = 1;
                } else {
                    this.count = 0;
                    x.d("MicroMsg.MuitlGestureImageView", "double click!");
                    if (this.mVb.getScale() <= this.mVb.pXP) {
                        this.mVb.J(g.i(motionEvent, 0), g.j(motionEvent, 0));
                    } else {
                        this.mVb.I(g.i(motionEvent, 0), g.j(motionEvent, 0));
                        this.mVb.cpV();
                    }
                }
            }
        }
        if (motionEvent.getAction() == 6 || motionEvent.getAction() == 262) {
            this.mVt.removeMessages(2);
            this.fdp = 0.0f;
            this.mVm = this.mVb.getScale();
            this.mVh = true;
            if (this.mVm < this.mVb.pXP) {
                this.mVb.I((g.i(motionEvent, 0) - g.i(motionEvent, 1)) + g.i(motionEvent, 1), (g.j(motionEvent, 0) - g.j(motionEvent, 1)) + g.j(motionEvent, 1));
            }
            if (this.mVm > this.mVb.cpX()) {
                this.mVb.J((g.i(motionEvent, 0) - g.i(motionEvent, 1)) + g.i(motionEvent, 1), (g.j(motionEvent, 0) - g.j(motionEvent, 1)) + g.j(motionEvent, 1));
            }
        }
        if (motionEvent.getAction() == 1) {
            this.mVt.removeMessages(2);
            if ((this.mVp || this.mVq) && (this.mVn || this.mVo)) {
                this.mVl = new f(this, this.mVb);
                aOB();
                this.mVp = false;
                this.mVq = false;
                this.mVn = false;
                this.mVo = false;
            } else {
                if (this.mVp) {
                    this.mVp = false;
                    this.mVl = new g(this, this.mVb);
                    aOB();
                }
                if (this.mVq) {
                    this.mVq = false;
                    this.mVl = new h(this, this.mVb);
                    aOB();
                }
                if (this.mVn) {
                    this.mVn = false;
                    this.mVl = new i(this, this.mVb);
                    aOB();
                }
                if (this.mVo) {
                    this.mVo = false;
                    this.mVl = new e(this, this.mVb);
                    aOB();
                }
            }
            this.fdp = 0.0f;
            this.mVm = this.mVb.getScale();
            if (this.count == 1) {
                this.mVd = System.currentTimeMillis();
                if (this.mVd - this.mVc >= 350) {
                    this.count = 0;
                    x.d("MicroMsg.MuitlGestureImageView", "single long click over!");
                } else if (Math.abs(this.mVe - g.i(motionEvent, 0)) < 10.0f && Math.abs(this.mVf - g.j(motionEvent, 0)) < 10.0f) {
                    j jVar = this.mVs;
                    jVar.mVF = false;
                    jVar.i(0, 350, 0);
                }
            }
        }
        if (motionEvent.getAction() == 5 || motionEvent.getAction() == 261) {
            this.fdp = 0.0f;
            this.mVm = this.mVb.getScale();
            this.mVh = true;
        }
        if (motionEvent.getAction() == 2) {
            if (g.K(motionEvent) == 2) {
                this.mVt.removeMessages(2);
                this.mVh = true;
                this.count = 0;
                float i = g.i(motionEvent, 0) - g.i(motionEvent, 1);
                float j = g.j(motionEvent, 0) - g.j(motionEvent, 1);
                float sqrt = (float) Math.sqrt((double) ((i * i) + (j * j)));
                if (this.fdp == 0.0f) {
                    this.fdp = sqrt;
                } else {
                    sqrt /= this.fdp;
                    if (this.mVh) {
                        this.mVb.h(sqrt * this.mVm, i + g.i(motionEvent, 1), j + g.j(motionEvent, 1));
                    }
                }
            } else if (Math.abs(this.mVe - g.i(motionEvent, 0)) > 10.0f || Math.abs(this.mVf - g.j(motionEvent, 0)) > 10.0f) {
                this.mVt.removeMessages(2);
                this.count = 0;
                computeScroll();
            }
        }
        return true;
    }

    public void computeScroll() {
        int i = 0;
        if (this.mVb != null && this.mVi.computeScrollOffset()) {
            int currX = this.mVi.getCurrX() - this.VQ;
            int currY = this.mVi.getCurrY() - this.VR;
            this.VQ = this.mVi.getCurrX();
            this.VR = this.mVi.getCurrY();
            float scale = this.mVb.getScale();
            float f = ((float) this.mVb.imageWidth) * scale;
            scale *= (float) this.mVb.imageHeight;
            float[] fArr = new float[9];
            this.mVb.getImageMatrix().getValues(fArr);
            float f2 = fArr[2];
            f += f2;
            float f3 = fArr[5];
            float f4 = f3 + scale;
            if (currX < 0 && ((float) currX) < this.mVk.right - ((float) Math.round(f))) {
                currX = (int) (this.mVk.right - ((float) Math.round(f)));
            }
            if (currX > 0 && ((float) currX) > this.mVk.left - ((float) Math.round(f2))) {
                currX = (int) (this.mVk.left - ((float) Math.round(f2)));
            }
            if (currY < 0 && ((float) currY) < this.mVk.bottom - ((float) Math.round(f4))) {
                currY = (int) (this.mVk.bottom - ((float) Math.round(f4)));
            }
            if (currY > 0 && ((float) currY) > this.mVk.top - ((float) Math.round(f3))) {
                currY = (int) (this.mVk.top - ((float) Math.round(f3)));
            }
            if (((float) Math.round(f2)) >= this.mVk.left || ((float) Math.round(f)) <= this.mVk.right) {
                currX = 0;
            } else if (((float) Math.round(f3)) >= this.mVk.top || ((float) Math.round(f4)) <= this.mVk.bottom) {
                currY = 0;
            }
            if (scale >= ((float) this.kDQ)) {
                i = currY;
            }
            this.mVb.K((float) currX, (float) i);
            postInvalidate();
        }
    }

    private void aOA() {
        this.mVr.removeMessages(1);
    }

    private void aOB() {
        aOA();
        this.mVr.i(1, 15, 15);
    }
}
