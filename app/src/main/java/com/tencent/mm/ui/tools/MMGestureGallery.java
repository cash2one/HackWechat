package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Gallery;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.w.a.g;
import java.lang.ref.WeakReference;

public class MMGestureGallery extends Gallery {
    private int VQ;
    private int VR;
    private int count = 0;
    private float fdp;
    private VelocityTracker ft;
    private af handler = new af(Looper.getMainLooper());
    private int kDP;
    private int kDQ;
    private long mVc = 0;
    private long mVd = 0;
    private float mVe = 0.0f;
    private float mVf = 0.0f;
    private long mVg = 0;
    private boolean mVh = false;
    private OverScroller mVi;
    private GestureDetector mVj;
    private RectF mVk = new RectF();
    private float mVm;
    private boolean mVn = false;
    private boolean mVo = false;
    private boolean mVp = false;
    private boolean mVq = false;
    private MultiTouchImageView mVy;
    private float rEA = 0.0f;
    private boolean rEB = false;
    private boolean rEC = false;
    private boolean rED = false;
    private float rEz = 0.0f;
    private final int yeG = 60;
    private final int yeH = 500;
    public boolean yes = false;
    private boolean yet = false;
    private boolean yeu = false;
    private boolean yev = false;
    private boolean yew = false;
    private int yex = 0;
    public l zlb;
    public l zlc;
    public l zld;
    private a zle;
    public f zlf;
    public c zlg;
    public e zlh;
    public boolean zli = true;
    public b zlj;

    static /* synthetic */ void y(MMGestureGallery mMGestureGallery) {
        mMGestureGallery.aOA();
        mMGestureGallery.zlb.i(1, 15, 15);
    }

    public MMGestureGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setStaticTransformationsEnabled(true);
    }

    private void aOA() {
        this.zlb.removeMessages(1);
    }

    public MMGestureGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setStaticTransformationsEnabled(true);
        this.mVj = new GestureDetector(context, new d(this, (byte) 0));
        this.zlb = new l(new WeakReference(this));
        this.zlc = new l(new WeakReference(this));
        this.zld = new l(new WeakReference(this));
        this.mVi = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.yex = (int) (getResources().getDisplayMetrics().density * 3000.0f);
        setOnTouchListener(new 1(this));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.kDP = MeasureSpec.getSize(i);
        this.kDQ = MeasureSpec.getSize(i2);
        this.mVk.set(0.0f, 0.0f, (float) this.kDP, (float) this.kDQ);
        x.v("MicroMsg.MMGestureGallery", "MMGestureGallery width:" + this.kDP + " height:" + this.kDQ);
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.yet) {
            return true;
        }
        this.yeu = true;
        if (this.zlh != null) {
            this.zlh.bBd();
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    private boolean a(float f, float f2, View view, float f3) {
        boolean z;
        if (this.yeu || this.yet) {
            z = false;
        } else {
            if (getPositionForView(view) == getAdapter().getCount() - 1) {
                if (this.yew) {
                    if (f3 > 0.0f) {
                        if (f2 >= ((float) this.kDP)) {
                            this.mVy.K(-f3, 0.0f);
                        } else if (f2 > ((float) this.kDP) * 0.7f && f2 < ((float) this.kDQ)) {
                            this.mVy.K(-(f3 * 0.3f), 0.0f);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (f3 > 0.0f) {
                    if (f2 < ((float) this.kDP)) {
                        this.yew = true;
                    }
                    if (f2 >= ((float) this.kDP)) {
                        this.mVy.K(-f3, 0.0f);
                    } else if (f2 > ((float) this.kDP) * 0.7f && f2 < ((float) this.kDQ)) {
                        this.mVy.K(-(f3 * 0.3f), 0.0f);
                    }
                    z = true;
                }
            }
            this.yew = false;
            z = false;
        }
        if (z) {
            return true;
        }
        if (this.yeu || this.yet) {
            z = false;
        } else {
            if (getPositionForView(view) == 0) {
                if (this.yev) {
                    if (f3 < 0.0f) {
                        if (f > 0.0f && f < ((float) this.kDP) * 0.3f) {
                            this.mVy.K(-(f3 * 0.3f), 0.0f);
                        } else if (f <= 0.0f) {
                            this.mVy.K(-f3, 0.0f);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (f3 < 0.0f) {
                    if (f > 0.0f) {
                        this.yev = true;
                    }
                    if (f > 0.0f && f < ((float) this.kDP) * 0.3f) {
                        this.mVy.K(-(f3 * 0.3f), 0.0f);
                    } else if (f <= 0.0f) {
                        this.mVy.K(-f3, 0.0f);
                    }
                    z = true;
                }
            }
            this.yev = false;
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mVh || this.rEB) {
            return true;
        }
        View selectedView = getSelectedView();
        if (selectedView instanceof ViewGroup) {
            View findViewById = selectedView.findViewById(g.cpd);
            if (findViewById == null || findViewById.getVisibility() == 8) {
                return a(motionEvent, motionEvent2, f, f2);
            }
            selectedView = findViewById.findViewById(g.image);
            if (selectedView == null) {
                return a(motionEvent, motionEvent2, f, f2);
            }
        }
        if (!(selectedView instanceof MultiTouchImageView)) {
            return a(motionEvent, motionEvent2, f, f2);
        }
        this.mVy = (MultiTouchImageView) selectedView;
        float[] fArr = new float[9];
        this.mVy.getImageMatrix().getValues(fArr);
        float scale = this.mVy.getScale() * ((float) this.mVy.imageWidth);
        float scale2 = this.mVy.getScale() * ((float) this.mVy.imageHeight);
        float f3 = fArr[2];
        float f4 = f3 + scale;
        float f5 = fArr[5];
        float f6 = f5 + scale2;
        this.mVy.getGlobalVisibleRect(new Rect());
        if (((int) scale) > this.kDP || ((int) scale2) > this.kDQ) {
            if (((int) scale) > this.kDP || ((int) scale2) <= this.kDQ) {
                if (((int) scale) <= this.kDP || ((int) scale2) > this.kDQ) {
                    if (Math.abs(f2) > Math.abs(f)) {
                        if (f != 0.0f) {
                            this.yeu = true;
                            if (f < 0.0f) {
                                if (f3 > this.mVk.left) {
                                    this.mVp = true;
                                }
                                if (f3 > this.mVk.left && f4 >= ((float) this.kDP)) {
                                    if (f3 > this.mVk.left && f3 < ((float) this.kDP) * 0.3f) {
                                        f *= 0.3f;
                                    }
                                }
                                if (f2 != 0.0f) {
                                    this.yet = true;
                                    if (f2 < 0.0f) {
                                        if (f5 > this.mVk.top) {
                                            this.mVn = true;
                                        }
                                        if (f5 > this.mVk.top && f6 >= ((float) this.kDQ)) {
                                            if (f5 > this.mVk.top && f5 < ((float) this.kDQ) * 0.3f) {
                                                f2 *= 0.3f;
                                            }
                                        }
                                        this.mVy.K(-f, -f2);
                                        return true;
                                    }
                                    if (f6 < this.mVk.bottom) {
                                        this.mVo = true;
                                    }
                                    if (f5 <= 0.0f && f6 < ((float) this.kDQ)) {
                                        if (f6 > ((float) this.kDQ) * 0.7f && f6 < ((float) this.kDQ)) {
                                            f2 *= 0.3f;
                                        }
                                    }
                                    this.mVy.K(-f, -f2);
                                    return true;
                                }
                                f2 = 0.0f;
                                this.mVy.K(-f, -f2);
                                return true;
                            }
                            if (f4 < this.mVk.right) {
                                this.mVq = true;
                            }
                            if (f3 <= 0.0f && f4 < ((float) this.kDP)) {
                                if (f4 > ((float) this.kDP) * 0.7f && f4 < ((float) this.kDP)) {
                                    f *= 0.3f;
                                }
                            }
                            if (f2 != 0.0f) {
                                this.yet = true;
                                if (f2 < 0.0f) {
                                    if (f6 < this.mVk.bottom) {
                                        this.mVo = true;
                                    }
                                    f2 *= 0.3f;
                                    this.mVy.K(-f, -f2);
                                    return true;
                                }
                                if (f5 > this.mVk.top) {
                                    this.mVn = true;
                                }
                                f2 *= 0.3f;
                                this.mVy.K(-f, -f2);
                                return true;
                            }
                            f2 = 0.0f;
                            this.mVy.K(-f, -f2);
                            return true;
                        }
                        f = 0.0f;
                        if (f2 != 0.0f) {
                            this.yet = true;
                            if (f2 < 0.0f) {
                                if (f5 > this.mVk.top) {
                                    this.mVn = true;
                                }
                                f2 *= 0.3f;
                                this.mVy.K(-f, -f2);
                                return true;
                            }
                            if (f6 < this.mVk.bottom) {
                                this.mVo = true;
                            }
                            f2 *= 0.3f;
                            this.mVy.K(-f, -f2);
                            return true;
                        }
                        f2 = 0.0f;
                        this.mVy.K(-f, -f2);
                        return true;
                    } else if (a(f3, f4, selectedView, f)) {
                        return true;
                    } else {
                        if (f > 0.0f) {
                            if (f4 <= ((float) this.kDP)) {
                                return a(motionEvent, motionEvent2, f, 0.0f);
                            }
                        } else if (f3 >= 0.0f) {
                            return a(motionEvent, motionEvent2, f, 0.0f);
                        }
                        if (!this.yeu) {
                            this.mVy.K(-f, -f2);
                        }
                        return true;
                    }
                } else if (a(f3, f4, selectedView, f)) {
                    return true;
                } else {
                    if (f > 0.0f) {
                        if (f4 <= ((float) this.kDP)) {
                            return a(motionEvent, motionEvent2, f, 0.0f);
                        }
                    } else if (f3 >= 0.0f) {
                        return a(motionEvent, motionEvent2, f, 0.0f);
                    }
                    if (!this.yeu) {
                        this.mVy.K(-f, 0.0f);
                    }
                    return true;
                }
            } else if (Math.abs(f2) > Math.abs(f)) {
                if (this.yeu || this.yev || this.yew) {
                    return true;
                }
                this.yet = true;
                float f7 = 0.0f;
                float f8 = 0.0f;
                if (f2 < 0.0f) {
                    if (f5 > this.mVk.top) {
                        this.mVn = true;
                    }
                    if (f5 <= this.mVk.top || f6 < ((float) this.kDQ)) {
                        f8 = -f2;
                    } else if (f5 > this.mVk.top && f5 < ((float) this.kDQ) * 0.3f) {
                        f8 = -(0.3f * f2);
                    }
                } else {
                    if (f6 < this.mVk.bottom) {
                        this.mVo = true;
                    }
                    if (f5 > 0.0f || f6 >= ((float) this.kDQ)) {
                        f8 = -f2;
                    } else if (f6 > ((float) this.kDQ) * 0.7f && f6 < ((float) this.kDQ)) {
                        f8 = -(0.3f * f2);
                    }
                }
                if (f < 0.0f && f3 > this.mVk.left) {
                    this.mVp = true;
                    f7 = -(0.3f * f);
                } else if (f > 0.0f && f4 < this.mVk.right) {
                    this.mVq = true;
                    f7 = -(0.3f * f);
                }
                this.mVy.K(f7, f8);
                return true;
            } else if (a(f3, f4, selectedView, f)) {
                return true;
            } else {
                if (f > 0.0f) {
                    if (f4 <= ((float) this.kDP)) {
                        if (f4 > ((float) this.kDP) * 0.7f) {
                            return a(motionEvent, motionEvent2, 0.3f * f, 0.0f);
                        }
                        return a(motionEvent, motionEvent2, 0.0f, 0.0f);
                    }
                } else if (f3 >= 0.0f) {
                    if (f3 < ((float) this.kDP) * 0.3f) {
                        return a(motionEvent, motionEvent2, 0.3f * f, 0.0f);
                    }
                    return a(motionEvent, motionEvent2, 0.0f, 0.0f);
                }
                if (!this.yeu) {
                    this.mVy.K(-f, 0.0f);
                }
                return true;
            }
        } else if (a(f3, f4, selectedView, f)) {
            return true;
        } else {
            if (f > 0.0f) {
                if (f4 <= ((float) this.kDP)) {
                    return a(motionEvent, motionEvent2, f, 0.0f);
                }
            } else if (f3 >= 0.0f) {
                return a(motionEvent, motionEvent2, f, 0.0f);
            }
            if (!this.yeu) {
                this.mVy.K(-f, 0.0f);
            }
            return true;
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (this.mVi != null) {
            this.mVi.forceFinished(true);
        }
        return super.onDown(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        View selectedView = getSelectedView();
        if (selectedView instanceof ViewGroup) {
            selectedView = selectedView.findViewById(g.cpd);
            if (selectedView == null || selectedView.getVisibility() == 8) {
                a(motionEvent, motionEvent2, f);
                return false;
            }
            selectedView = selectedView.findViewById(g.image);
            if (selectedView == null) {
                a(motionEvent, motionEvent2, f);
                return false;
            }
        }
        if (selectedView instanceof MultiTouchImageView) {
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) selectedView;
            float scale = multiTouchImageView.getScale() * ((float) multiTouchImageView.imageWidth);
            float scale2 = multiTouchImageView.getScale() * ((float) multiTouchImageView.imageHeight);
            if (multiTouchImageView.yfs || multiTouchImageView.yft || ((int) scale) > this.kDP || ((int) scale2) > this.kDQ) {
                float f3;
                r4 = new float[9];
                multiTouchImageView.getImageMatrix().getValues(r4);
                float f4 = r4[2];
                float f5 = f4 + scale;
                float f6 = r4[5];
                float f7 = f6 + scale2;
                x.d("MicroMsg.MMGestureGallery", "jacks left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", new Object[]{Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(b(motionEvent, motionEvent2)), Float.valueOf(f), Float.valueOf(f2)});
                if (((float) Math.round(f4)) >= this.mVk.left || ((float) Math.round(f5)) <= this.mVk.right) {
                    f3 = 0.0f;
                } else {
                    f3 = f;
                }
                if (((float) Math.round(f6)) >= this.mVk.top || ((float) Math.round(f7)) <= this.mVk.bottom) {
                    f2 = 0.0f;
                }
                if (((float) Math.round(f6)) < this.mVk.top) {
                    this.yes = true;
                } else {
                    this.yes = false;
                }
                int i = (int) (this.mVk.right - scale);
                int i2 = (int) (scale + this.mVk.right);
                int i3 = (int) (this.mVk.bottom - scale2);
                int i4 = (int) (this.mVk.bottom + scale2);
                if (f3 >= 0.0f) {
                    if (Math.abs(f3) >= ((float) this.yex)) {
                        f3 = (float) this.yex;
                    }
                    f6 = f3;
                } else {
                    if (Math.abs(f3) >= ((float) this.yex)) {
                        f3 = (float) (-this.yex);
                    }
                    f6 = f3;
                }
                if (f2 >= 0.0f) {
                    if (Math.abs(f2) >= ((float) this.yex)) {
                        f2 = (float) this.yex;
                    }
                } else if (Math.abs(f2) >= ((float) this.yex)) {
                    f2 = (float) (-this.yex);
                }
                this.mVi.forceFinished(true);
                this.mVi.fling(this.mVi.getCurrX(), this.mVi.getCurrY(), (int) f6, (int) f2, i, i2, i3, i4, 0, 0);
                if ((!b(motionEvent, motionEvent2) || f4 < 0.0f) && (b(motionEvent, motionEvent2) || f5 > ((float) this.kDP))) {
                    return true;
                }
            }
        }
        if (this.mVh) {
            return true;
        }
        a(motionEvent, motionEvent2, f);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.rED = true;
        super.onLongPress(motionEvent);
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent.getX() - motionEvent2.getX() < 0.0f;
    }

    private void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f) {
        float x = motionEvent.getX() - motionEvent2.getX();
        float y = motionEvent.getY() - motionEvent2.getY();
        boolean b = b(motionEvent, motionEvent2);
        x = Math.abs(x);
        y = Math.abs(y);
        if (Math.abs(f) <= 500.0f || x < 60.0f || x < y) {
            return;
        }
        if (b) {
            onKeyDown(21, null);
        } else {
            onKeyDown(22, null);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mVj.onTouchEvent(motionEvent);
        x.d("dktest", "onTouchEvent event.getAction()" + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 1:
                View selectedView = getSelectedView();
                if (selectedView instanceof MultiTouchImageView) {
                    this.mVy = (MultiTouchImageView) selectedView;
                    float scale = this.mVy.getScale() * ((float) this.mVy.imageWidth);
                    float scale2 = this.mVy.getScale() * ((float) this.mVy.imageHeight);
                    if (((int) scale) <= this.kDP && ((int) scale2) <= this.kDQ) {
                        x.i("dktest", "onTouchEvent width:" + scale + "height:" + scale2);
                        break;
                    }
                    float[] fArr = new float[9];
                    this.mVy.getImageMatrix().getValues(fArr);
                    scale = fArr[5];
                    x.d("dktest", "onTouchEvent top:" + scale + " height:" + scale2 + " bottom:" + (scale + scale2));
                    break;
                }
                break;
        }
        computeScroll();
        return super.onTouchEvent(motionEvent);
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            super.onFocusChanged(z, i, rect);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(z);
        }
    }

    public void computeScroll() {
        int i = 0;
        if (this.mVy != null && this.mVi.computeScrollOffset()) {
            int currX = this.mVi.getCurrX() - this.VQ;
            int currY = this.mVi.getCurrY() - this.VR;
            this.VQ = this.mVi.getCurrX();
            this.VR = this.mVi.getCurrY();
            float scale = this.mVy.getScale() * ((float) this.mVy.imageWidth);
            float scale2 = this.mVy.getScale() * ((float) this.mVy.imageHeight);
            float[] fArr = new float[9];
            this.mVy.getImageMatrix().getValues(fArr);
            float f = fArr[2];
            scale += f;
            float f2 = fArr[5];
            float f3 = f2 + scale2;
            if (currX < 0 && ((float) currX) < this.mVk.right - ((float) Math.round(scale))) {
                currX = (int) (this.mVk.right - ((float) Math.round(scale)));
            }
            if (currX > 0 && ((float) currX) > this.mVk.left - ((float) Math.round(f))) {
                currX = (int) (this.mVk.left - ((float) Math.round(f)));
            }
            if (currY < 0 && ((float) currY) < this.mVk.bottom - ((float) Math.round(f3))) {
                currY = (int) (this.mVk.bottom - ((float) Math.round(f3)));
            }
            if (currY > 0 && ((float) currY) > this.mVk.top - ((float) Math.round(f2))) {
                currY = (int) (this.mVk.top - ((float) Math.round(f2)));
            }
            if (((float) Math.round(f)) >= this.mVk.left || ((float) Math.round(scale)) <= this.mVk.right) {
                currX = 0;
            } else if (((float) Math.round(f2)) >= this.mVk.top || ((float) Math.round(f3)) <= this.mVk.bottom) {
                currY = 0;
            }
            if (scale2 >= ((float) this.kDQ)) {
                i = currY;
            }
            this.mVy.K((float) currX, (float) i);
            postInvalidate();
        }
    }

    public boolean isFocused() {
        return true;
    }
}
