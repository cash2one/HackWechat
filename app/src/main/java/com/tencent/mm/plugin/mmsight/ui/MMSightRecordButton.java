package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.u.a$b;
import com.tencent.mm.plugin.u.a$c;
import com.tencent.mm.plugin.u.a.d;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;

public class MMSightRecordButton extends FrameLayout {
    private static final float oAV = (((float) ac.getContext().getResources().getDimensionPixelSize(a$b.oEn)) / ((float) ac.getContext().getResources().getDimensionPixelSize(a$b.oEm)));
    private static final int wR = ViewConfiguration.getTapTimeout();
    private boolean fqP = true;
    private af hae = new af(Looper.getMainLooper());
    private boolean isAnimating = false;
    private float kCe = -1.0f;
    private long oAW = -1;
    private View oAX;
    private View oAY;
    View oAZ;
    MMSightCircularProgressBar oBa;
    private boolean oBb = false;
    private boolean oBc = false;
    private ViewPropertyAnimator oBd;
    private ViewPropertyAnimator oBe;
    private ViewPropertyAnimator oBf;
    private ViewPropertyAnimator oBg;
    private boolean oBh = false;
    d oBi;
    b oBj;
    c oBk;
    a oBl;
    private Drawable oBm;
    private Drawable oBn;
    private boolean oBo = false;
    private boolean oBp = false;
    private Runnable oBq = new Runnable(this) {
        final /* synthetic */ MMSightRecordButton oBt;

        {
            this.oBt = r1;
        }

        public final void run() {
            x.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[]{Boolean.valueOf(this.oBt.oBb), Boolean.valueOf(this.oBt.oBc)});
            if (!this.oBt.oBb) {
                this.oBt.oBc = true;
                if (this.oBt.oBj != null) {
                    this.oBt.oBj.bbw();
                }
            }
        }
    };
    private Runnable oBr = new Runnable(this) {
        final /* synthetic */ MMSightRecordButton oBt;

        {
            this.oBt = r1;
        }

        public final void run() {
            x.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[]{Boolean.valueOf(this.oBt.oBh)});
            if (this.oBt.oBh) {
                MMSightRecordButton.f(this.oBt);
            }
        }
    };

    class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ MMSightRecordButton oBt;
        final /* synthetic */ AnimatorListenerAdapter oBv = null;

        AnonymousClass3(MMSightRecordButton mMSightRecordButton, AnimatorListenerAdapter animatorListenerAdapter) {
            this.oBt = mMSightRecordButton;
        }

        public final void onAnimationStart(Animator animator) {
            this.oBt.isAnimating = true;
            if (this.oBv != null) {
                this.oBv.onAnimationStart(animator);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            this.oBt.isAnimating = false;
            if (this.oBv != null) {
                this.oBv.onAnimationEnd(animator);
            }
        }
    }

    static /* synthetic */ void f(MMSightRecordButton mMSightRecordButton) {
        mMSightRecordButton.isAnimating = true;
        if (mMSightRecordButton.oBd != null) {
            mMSightRecordButton.oBd.cancel();
            mMSightRecordButton.oBd = null;
        }
        mMSightRecordButton.oBd = mMSightRecordButton.oAX.animate().scaleX(0.67f).scaleY(0.67f);
        mMSightRecordButton.oBd.setListener(new 2(mMSightRecordButton, null)).setDuration(150).start();
        if (mMSightRecordButton.oBe != null) {
            mMSightRecordButton.oBe.cancel();
            mMSightRecordButton.oBe = null;
        }
        mMSightRecordButton.oBe = mMSightRecordButton.oAY.animate().scaleX(oAV).scaleY(oAV);
        mMSightRecordButton.oBe.setListener(new AnonymousClass3(mMSightRecordButton, null)).setDuration(150).start();
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        x.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[]{Integer.valueOf(500), Integer.valueOf(wR)});
        this.oBm = getContext().getResources().getDrawable(a$c.oEq);
        this.oBn = getContext().getResources().getDrawable(a$c.oEr);
        v.fv(getContext()).inflate(e.oEY, this, true);
        this.oAX = findViewById(d.oED);
        this.oAY = findViewById(d.oEF);
        this.oAZ = findViewById(d.cDY);
        this.oBa = (MMSightCircularProgressBar) findViewById(d.oEt);
        this.oAX.setBackgroundDrawable(this.oBm);
        this.oAY.setBackgroundDrawable(this.oBn);
        this.fqP = true;
    }

    public final void gI(boolean z) {
        x.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[]{Boolean.valueOf(z)});
        this.fqP = z;
    }

    public final void bbt() {
        MMSightCircularProgressBar mMSightCircularProgressBar = this.oBa;
        mMSightCircularProgressBar.oAR = null;
        mMSightCircularProgressBar.oAN = 0;
        mMSightCircularProgressBar.oAO = 0;
        mMSightCircularProgressBar.duration = 0;
        mMSightCircularProgressBar.fAs = false;
        if (mMSightCircularProgressBar.oAQ != null) {
            b bVar = mMSightCircularProgressBar.oAQ;
            bVar.fAs = false;
            bVar.oCc = 0;
            mMSightCircularProgressBar.oAQ = null;
        }
        this.oBa.setVisibility(8);
    }

    private void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        this.isAnimating = true;
        if (this.oBf != null) {
            this.oBf.cancel();
            this.oBf = null;
        }
        this.oBf = this.oAX.animate().scaleX(1.0f).scaleY(1.0f);
        this.oBf.setListener(new 4(this, animatorListenerAdapter)).setDuration(150).start();
        if (this.oBg != null) {
            this.oBg.cancel();
            this.oBg = null;
        }
        this.oBg = this.oAY.animate().scaleX(1.0f).scaleY(1.0f);
        this.oBg.setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ MMSightRecordButton oBt;

            public final void onAnimationStart(Animator animator) {
                this.oBt.isAnimating = true;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
            }

            public final void onAnimationEnd(Animator animator) {
                this.oBt.isAnimating = false;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
            }
        }).setDuration(150).start();
    }

    public void setVisibility(final int i) {
        x.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[]{Boolean.valueOf(this.isAnimating)});
        if (this.isAnimating) {
            postDelayed(new Runnable(this) {
                final /* synthetic */ MMSightRecordButton oBt;

                public final void run() {
                    super.setVisibility(i);
                }
            }, 150);
        } else {
            super.setVisibility(i);
        }
    }

    public final void reset() {
        setClipChildren(false);
        this.fqP = true;
        this.oAX.setScaleX(1.0f);
        this.oAX.setScaleY(1.0f);
        this.oAY.setScaleX(1.0f);
        this.oAY.setScaleY(1.0f);
        this.oAZ.setVisibility(8);
        bbt();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fqP) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.oBh = true;
                    this.oAW = System.currentTimeMillis();
                    this.oBb = false;
                    this.oBc = false;
                    this.kCe = motionEvent.getRawY();
                    if (this.oBj != null) {
                        this.oBj.bbv();
                    }
                    this.hae.postDelayed(this.oBq, 550);
                    this.hae.postDelayed(this.oBr, 250);
                    this.oBp = true;
                    this.oBo = true;
                    break;
                case 1:
                case 3:
                    this.oBh = false;
                    this.hae.removeCallbacks(this.oBr, Integer.valueOf(wR));
                    this.hae.removeCallbacks(this.oBq);
                    if (!(this.oBd == null || this.oBe == null)) {
                        this.oBd.cancel();
                        this.oBe.cancel();
                    }
                    x.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[]{Boolean.valueOf(this.oBc), Boolean.valueOf(this.oBb), Long.valueOf(this.oAW), Long.valueOf(System.currentTimeMillis() - this.oAW)});
                    bbt();
                    a(new 9(this, r2));
                    break;
                case 2:
                    x.d("MicroMsg.MMSightRecordButton", "move, x: %s, y: %s, top: %s", new Object[]{Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()), Integer.valueOf(getTop())});
                    float rawY = motionEvent.getRawY();
                    if (rawY < ((float) getTop()) && this.oBc) {
                        if (this.kCe > 0.0f) {
                            float abs = Math.abs(rawY - this.kCe);
                            int min;
                            c cVar;
                            if (rawY >= this.kCe || abs < 10.0f) {
                                if (rawY > this.kCe && abs >= 10.0f) {
                                    x.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[]{Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.oBp)});
                                    min = Math.min(min, 3);
                                    if (this.oBk != null) {
                                        cVar = this.oBk;
                                        if (this.oBp) {
                                            min = 1;
                                        }
                                        cVar.sZ(min);
                                    }
                                    this.oBp = false;
                                    this.kCe = rawY;
                                    break;
                                }
                            }
                            x.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[]{Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.oBo)});
                            min = Math.min(min, 3);
                            if (this.oBk != null) {
                                cVar = this.oBk;
                                if (this.oBo) {
                                    min = 1;
                                }
                                cVar.sY(min);
                            }
                            this.kCe = rawY;
                            this.oBo = false;
                            break;
                        }
                        this.kCe = motionEvent.getRawY();
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        x.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
        return true;
    }
}
