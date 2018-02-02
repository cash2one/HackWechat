package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.lang.ref.WeakReference;

public class MMViewPager extends WxViewPager {
    private int VQ;
    private int VR;
    private float fdp;
    private VelocityTracker ft;
    private af handler = new af(Looper.getMainLooper());
    private GestureDetector jtw;
    private int kDP;
    private int kDQ;
    private boolean mVh = false;
    private OverScroller mVi;
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
    private OnTouchListener sqw;
    public c yeA;
    public e yeB = null;
    private float yeC = 0.0f;
    private MotionEvent yeD;
    private long yeE = 0;
    public b yeF;
    private final int yeG = 60;
    private final int yeH = 500;
    private k yer;
    private boolean yes = false;
    private boolean yet = false;
    private boolean yeu = false;
    private boolean yev = false;
    private boolean yew = false;
    private int yex = 0;
    private a yey;
    public e yez;

    public interface c {
        void aJi();
    }

    private class j extends a {
        float[] mVx = new float[9];
        final /* synthetic */ MMViewPager yeI;

        public j(MMViewPager mMViewPager) {
            this.yeI = mMViewPager;
            super(mMViewPager);
        }

        public final void play() {
            this.yeI.handler.post(new 1(this));
        }
    }

    static /* synthetic */ boolean a(MMViewPager mMViewPager, MotionEvent motionEvent) {
        if (mMViewPager.ft == null) {
            mMViewPager.ft = VelocityTracker.obtain();
        }
        mMViewPager.ft.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                mMViewPager.rEz = motionEvent.getX();
                mMViewPager.rEA = motionEvent.getY();
                break;
            case 1:
                mMViewPager.rED = false;
                if (mMViewPager.rEC) {
                    if (mMViewPager.yeF != null) {
                        mMViewPager.yeF.E(0.0f, 0.0f);
                    }
                    mMViewPager.rEB = false;
                    return true;
                } else if (mMViewPager.rEB) {
                    if (mMViewPager.yez != null) {
                        mMViewPager.yez.aOz();
                    }
                    mMViewPager.rEB = false;
                    return true;
                }
                break;
            case 2:
                float x = motionEvent.getX() - mMViewPager.rEz;
                float y = motionEvent.getY() - mMViewPager.rEA;
                VelocityTracker velocityTracker = mMViewPager.ft;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (mMViewPager.yeF != null) {
                    mMViewPager.yeF.F(x, y);
                    if ((Math.abs(x) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || mMViewPager.rED || mMViewPager.yeu) && !mMViewPager.rEB) {
                        mMViewPager.rEB = false;
                    } else {
                        mMViewPager.yeF.E(x, y);
                        mMViewPager.rEB = true;
                    }
                    if (y > 200.0f) {
                        mMViewPager.rEC = false;
                    } else {
                        mMViewPager.rEC = true;
                    }
                }
                if (mMViewPager.ft != null) {
                    mMViewPager.ft.recycle();
                    mMViewPager.ft = null;
                    break;
                }
                break;
        }
        return false;
    }

    static /* synthetic */ boolean a(MMViewPager mMViewPager, MotionEvent motionEvent, MotionEvent motionEvent2, float f) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        float x = motionEvent.getX() - motionEvent2.getX();
        float y = motionEvent.getY() - motionEvent2.getY();
        boolean b = b(motionEvent, motionEvent2);
        x = Math.abs(x);
        y = Math.abs(y);
        if (Math.abs(f) <= 500.0f || x < 60.0f || x < y) {
            return false;
        }
        if (b) {
            mMViewPager.onKeyDown(21, null);
        } else {
            mMViewPager.onKeyDown(22, null);
        }
        return true;
    }

    static /* synthetic */ boolean a(MMViewPager mMViewPager, MultiTouchImageView multiTouchImageView, MotionEvent motionEvent) {
        if (mMViewPager.ft == null) {
            mMViewPager.ft = VelocityTracker.obtain();
        }
        mMViewPager.ft.addMovement(motionEvent);
        float j;
        float sqrt;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x.d("MicroMsg.MMViewPager", "ACTION_DOWN");
                multiTouchImageView.cpW();
                float[] fArr = new float[9];
                multiTouchImageView.getImageMatrix().getValues(fArr);
                if (((float) Math.round(fArr[5])) < mMViewPager.mVk.top) {
                    mMViewPager.yes = true;
                } else {
                    mMViewPager.yes = false;
                }
                mMViewPager.rEz = motionEvent.getX();
                mMViewPager.rEA = motionEvent.getY();
                mMViewPager.fdp = 0.0f;
                mMViewPager.mVm = multiTouchImageView.getScale();
                mMViewPager.mVh = false;
                mMViewPager.yeE = System.currentTimeMillis();
                return false;
            case 1:
                x.d("MicroMsg.MMViewPager", "ACTION_UP");
                mMViewPager.yet = false;
                mMViewPager.yeu = false;
                mMViewPager.rED = false;
                if ((mMViewPager.mVp || mMViewPager.mVq || mMViewPager.yev || mMViewPager.yew) && (mMViewPager.mVn || mMViewPager.mVo)) {
                    mMViewPager.yey = new g(mMViewPager);
                    mMViewPager.aOB();
                    mMViewPager.mVp = false;
                    mMViewPager.mVq = false;
                    mMViewPager.yev = false;
                    mMViewPager.yew = false;
                    mMViewPager.mVn = false;
                    mMViewPager.mVo = false;
                } else {
                    if (mMViewPager.yev || mMViewPager.mVp) {
                        mMViewPager.yev = false;
                        mMViewPager.mVp = false;
                        mMViewPager.yey = new h(mMViewPager);
                        mMViewPager.aOB();
                    }
                    if (mMViewPager.yew || mMViewPager.mVq) {
                        mMViewPager.yew = false;
                        mMViewPager.mVq = false;
                        mMViewPager.yey = new i(mMViewPager);
                        mMViewPager.aOB();
                    }
                    if (mMViewPager.mVn) {
                        mMViewPager.mVn = false;
                        mMViewPager.yey = new j(mMViewPager);
                        mMViewPager.aOB();
                    }
                    if (mMViewPager.mVo) {
                        mMViewPager.mVo = false;
                        mMViewPager.yey = new f(mMViewPager);
                        mMViewPager.aOB();
                    }
                }
                mMViewPager.fdp = 0.0f;
                mMViewPager.mVm = multiTouchImageView.getScale();
                if (mMViewPager.rEC) {
                    if (mMViewPager.yeF != null) {
                        mMViewPager.yeF.E(0.0f, 0.0f);
                    }
                    mMViewPager.rEB = false;
                    return false;
                } else if (!mMViewPager.rEB || mMViewPager.yes) {
                    return false;
                } else {
                    if (mMViewPager.yez != null) {
                        mMViewPager.yez.aOz();
                    }
                    mMViewPager.rEB = false;
                    return true;
                }
            case 2:
                x.d("MicroMsg.MMViewPager", "ACTION_MOVE");
                float i;
                if (g.K(motionEvent) == 2) {
                    mMViewPager.mVh = true;
                    i = g.i(motionEvent, 0) - g.i(motionEvent, 1);
                    j = g.j(motionEvent, 0) - g.j(motionEvent, 1);
                    sqrt = (float) Math.sqrt((double) ((i * i) + (j * j)));
                    if (mMViewPager.fdp == 0.0f) {
                        mMViewPager.fdp = sqrt;
                    } else {
                        sqrt /= mMViewPager.fdp;
                        if (mMViewPager.mVh) {
                            multiTouchImageView.h(sqrt * mMViewPager.mVm, i + g.i(motionEvent, 1), j + g.j(motionEvent, 1));
                        }
                    }
                    return true;
                }
                j = motionEvent.getX() - mMViewPager.rEz;
                sqrt = motionEvent.getY() - mMViewPager.rEA;
                VelocityTracker velocityTracker = mMViewPager.ft;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (!(mMViewPager.yeF == null || mMViewPager.yes || mMViewPager.mVh || mMViewPager.mVm > multiTouchImageView.pXP)) {
                    mMViewPager.yeF.F(j, sqrt);
                    if ((Math.abs(j) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || mMViewPager.rED || mMViewPager.yeu) && !mMViewPager.rEB) {
                        mMViewPager.rEB = false;
                    } else {
                        mMViewPager.yeF.E(j, sqrt);
                        mMViewPager.rEB = true;
                    }
                    if (sqrt > 200.0f) {
                        mMViewPager.rEC = false;
                    } else {
                        mMViewPager.rEC = true;
                    }
                }
                if (mMViewPager.ft != null) {
                    mMViewPager.ft.recycle();
                    mMViewPager.ft = null;
                }
                if (mMViewPager.yeD == null) {
                    return false;
                }
                if (mMViewPager.yeD.getAction() != 0 && mMViewPager.yeD.getAction() != 2 && mMViewPager.yeD.getAction() != 5 && mMViewPager.yeD.getAction() != 261) {
                    return false;
                }
                boolean z;
                float i2 = g.i(mMViewPager.yeD, 0) - g.i(motionEvent, 0);
                j = g.j(mMViewPager.yeD, 0) - g.j(motionEvent, 0);
                if (mMViewPager.mVh || mMViewPager.rEB) {
                    z = true;
                } else if (i2 == 0.0f && j == 0.0f) {
                    z = true;
                } else {
                    View EQ = ((v) mMViewPager.yE).EQ(mMViewPager.yF);
                    float[] fArr2 = new float[9];
                    mMViewPager.mVy.getImageMatrix().getValues(fArr2);
                    float scale = mMViewPager.mVy.getScale() * ((float) mMViewPager.mVy.imageWidth);
                    float scale2 = mMViewPager.mVy.getScale() * ((float) mMViewPager.mVy.imageHeight);
                    float f = fArr2[2];
                    float f2 = f + scale;
                    float f3 = fArr2[5];
                    float f4 = f3 + scale2;
                    if (((int) scale) > mMViewPager.kDP || ((int) scale2) > mMViewPager.kDQ) {
                        if (((int) scale) > mMViewPager.kDP || ((int) scale2) <= mMViewPager.kDQ) {
                            if (((int) scale) <= mMViewPager.kDP || ((int) scale2) > mMViewPager.kDQ) {
                                if (Math.abs(j) > Math.abs(i2)) {
                                    sqrt = 0.0f;
                                    i = 0.0f;
                                    if (i2 != 0.0f) {
                                        mMViewPager.yeu = true;
                                        if (i2 < 0.0f) {
                                            if (f > mMViewPager.mVk.left) {
                                                mMViewPager.mVp = true;
                                            }
                                            if (f <= mMViewPager.mVk.left || f2 < ((float) mMViewPager.kDP)) {
                                                sqrt = i2;
                                            } else if (f > mMViewPager.mVk.left && f < ((float) mMViewPager.kDP) * 0.3f) {
                                                sqrt = 0.3f * i2;
                                            }
                                        } else {
                                            if (f2 < mMViewPager.mVk.right) {
                                                mMViewPager.mVq = true;
                                            }
                                            if (f > 0.0f || f2 >= ((float) mMViewPager.kDP)) {
                                                sqrt = i2;
                                            } else if (f2 > ((float) mMViewPager.kDP) * 0.7f && f2 < ((float) mMViewPager.kDP)) {
                                                sqrt = 0.3f * i2;
                                            }
                                        }
                                    }
                                    if (j != 0.0f) {
                                        mMViewPager.yet = true;
                                        if (j < 0.0f) {
                                            if (f3 > mMViewPager.mVk.top) {
                                                mMViewPager.mVn = true;
                                            }
                                            if (f3 <= mMViewPager.mVk.top || f4 < ((float) mMViewPager.kDQ)) {
                                                i = j;
                                            } else if (f3 > mMViewPager.mVk.top && f3 < ((float) mMViewPager.kDQ) * 0.3f) {
                                                i = 0.3f * j;
                                            }
                                        } else {
                                            if (f4 < mMViewPager.mVk.bottom) {
                                                mMViewPager.mVo = true;
                                            }
                                            if (f3 > 0.0f || f4 >= ((float) mMViewPager.kDQ)) {
                                                i = j;
                                            } else if (f4 > ((float) mMViewPager.kDQ) * 0.7f && f4 < ((float) mMViewPager.kDQ)) {
                                                i = 0.3f * j;
                                            }
                                        }
                                    }
                                    mMViewPager.mVy.K(-sqrt, -i);
                                    z = true;
                                } else if (mMViewPager.a(f, f2, EQ, i2)) {
                                    z = true;
                                } else {
                                    if (i2 > 0.0f) {
                                        if (f2 <= ((float) mMViewPager.kDP)) {
                                            z = mMViewPager.cpL();
                                        }
                                    } else if (f >= 0.0f) {
                                        z = mMViewPager.cpL();
                                    }
                                    if (!mMViewPager.yeu || ((((double) mMViewPager.yeC) < 0.06d && i2 > 0.0f && f2 > ((float) mMViewPager.kDP)) || ((((double) mMViewPager.yeC) > 0.94d || mMViewPager.yeC == 0.0f) && i2 < 0.0f && f < 0.0f))) {
                                        i = -i2;
                                        if (i2 < 0.0f) {
                                            if (f < 0.0f && f - i2 > 0.0f) {
                                                sqrt = -f;
                                            }
                                            sqrt = i;
                                        } else {
                                            if (f2 > ((float) mMViewPager.kDP) && f2 - i2 < ((float) mMViewPager.kDP)) {
                                                sqrt = ((float) mMViewPager.kDP) - f2;
                                            }
                                            sqrt = i;
                                        }
                                        i = -j;
                                        if (j < 0.0f) {
                                            if (f3 < 0.0f && f3 + i > 0.0f) {
                                                i = -f3;
                                            }
                                        } else if (f4 > ((float) mMViewPager.kDQ) && f4 + i < ((float) mMViewPager.kDQ)) {
                                            i = ((float) mMViewPager.kDQ) - f4;
                                        }
                                        mMViewPager.mVy.K(sqrt, i);
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                }
                            } else if (mMViewPager.a(f, f2, EQ, i2)) {
                                z = true;
                            } else {
                                if (i2 > 0.0f) {
                                    if (f2 <= ((float) mMViewPager.kDP)) {
                                        z = mMViewPager.cpL();
                                    }
                                } else if (f >= 0.0f) {
                                    z = mMViewPager.cpL();
                                }
                                if (!mMViewPager.yeu || ((((double) mMViewPager.yeC) < 0.06d && i2 > 0.0f && f2 > ((float) mMViewPager.kDP)) || ((((double) mMViewPager.yeC) > 0.94d || mMViewPager.yeC == 0.0f) && i2 < 0.0f && f < 0.0f))) {
                                    i = -i2;
                                    if (i2 < 0.0f) {
                                        if (f < 0.0f && f - i2 > 0.0f) {
                                            i = -f;
                                        }
                                    } else if (f2 > ((float) mMViewPager.kDP) && f2 - i2 < ((float) mMViewPager.kDP)) {
                                        i = ((float) mMViewPager.kDP) - f2;
                                    }
                                    mMViewPager.mVy.K(i, 0.0f);
                                    z = true;
                                } else {
                                    z = false;
                                }
                            }
                        } else if (Math.abs(j) > Math.abs(i2)) {
                            if (mMViewPager.yeu || mMViewPager.yev || mMViewPager.yew) {
                                z = true;
                            } else {
                                mMViewPager.yet = true;
                                i = 0.0f;
                                if (j < 0.0f) {
                                    if (f3 > mMViewPager.mVk.top) {
                                        mMViewPager.mVn = true;
                                    }
                                    if (f3 <= mMViewPager.mVk.top || f4 < ((float) mMViewPager.kDQ)) {
                                        j = -j;
                                    } else {
                                        if (f3 > mMViewPager.mVk.top && f3 < ((float) mMViewPager.kDQ) * 0.3f) {
                                            j = -(j * 0.3f);
                                        }
                                        j = 0.0f;
                                    }
                                } else {
                                    if (f4 < mMViewPager.mVk.bottom) {
                                        mMViewPager.mVo = true;
                                    }
                                    if (f3 > 0.0f || f4 >= ((float) mMViewPager.kDQ)) {
                                        j = -j;
                                    } else {
                                        if (f4 > ((float) mMViewPager.kDQ) * 0.7f && f4 < ((float) mMViewPager.kDQ)) {
                                            j = -(j * 0.3f);
                                        }
                                        j = 0.0f;
                                    }
                                }
                                if (i2 < 0.0f && f > mMViewPager.mVk.left) {
                                    mMViewPager.mVp = true;
                                    i = -(0.3f * i2);
                                } else if (i2 > 0.0f && f2 < mMViewPager.mVk.right) {
                                    mMViewPager.mVq = true;
                                    i = -(0.3f * i2);
                                }
                                mMViewPager.mVy.K(i, j);
                                z = true;
                            }
                        } else if (mMViewPager.a(f, f2, EQ, i2)) {
                            z = true;
                        } else {
                            if (i2 > 0.0f) {
                                if (f2 <= ((float) mMViewPager.kDP)) {
                                    z = mMViewPager.cpL();
                                }
                            } else if (f >= 0.0f) {
                                z = mMViewPager.cpL();
                            }
                            if (!mMViewPager.yeu) {
                                i = -i2;
                                if (i2 < 0.0f) {
                                    if (f < 0.0f && f - i2 > 0.0f) {
                                        i = -f;
                                    }
                                } else if (f2 > ((float) mMViewPager.kDP) && f2 - i2 < ((float) mMViewPager.kDP)) {
                                    i = ((float) mMViewPager.kDP) - f2;
                                }
                                mMViewPager.mVy.K(i, 0.0f);
                            }
                            z = true;
                        }
                    } else if (mMViewPager.a(f, f2, EQ, i2)) {
                        z = true;
                    } else {
                        if (i2 > 0.0f) {
                            if (f2 <= ((float) mMViewPager.kDP)) {
                                z = mMViewPager.cpL();
                            }
                        } else if (f >= 0.0f) {
                            z = mMViewPager.cpL();
                        }
                        if (!mMViewPager.yeu) {
                            i = -i2;
                            if (i2 < 0.0f) {
                                if (f < 0.0f && f - i2 > 0.0f) {
                                    i = -f;
                                }
                            } else if (f2 > ((float) mMViewPager.kDP) && f2 - i2 < ((float) mMViewPager.kDP)) {
                                i = ((float) mMViewPager.kDP) - f2;
                            }
                            mMViewPager.mVy.K(i, 0.0f);
                        }
                        z = true;
                    }
                }
                if (z) {
                    return z;
                }
                j = g.i(mMViewPager.yeD, 0);
                sqrt = g.j(mMViewPager.yeD, 0);
                mMViewPager.za = j;
                mMViewPager.zb = sqrt;
                return z;
            case 5:
                x.d("MicroMsg.MMViewPager", "ACTION_POINTER_DOWN");
                mMViewPager.fdp = 0.0f;
                mMViewPager.mVm = multiTouchImageView.getScale();
                mMViewPager.mVh = true;
                if (mMViewPager.zg) {
                    return true;
                }
                if (!mMViewPager.iL) {
                    mMViewPager.zg = true;
                    super.ag(1);
                    mMViewPager.za = 0.0f;
                    mMViewPager.xP = 0.0f;
                    if (mMViewPager.ft == null) {
                        mMViewPager.ft = VelocityTracker.obtain();
                    } else {
                        mMViewPager.ft.clear();
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
                    mMViewPager.ft.addMovement(obtain);
                    obtain.recycle();
                    mMViewPager.rmC = uptimeMillis;
                }
                return true;
            case 6:
                x.d("MicroMsg.MMViewPager", "ACTION_POINTER_UP");
                mMViewPager.fdp = 0.0f;
                mMViewPager.mVm = multiTouchImageView.getScale();
                mMViewPager.mVh = true;
                if (mMViewPager.mVm < multiTouchImageView.pXP) {
                    multiTouchImageView.I((g.i(motionEvent, 0) - g.i(motionEvent, 1)) + g.i(motionEvent, 1), (g.j(motionEvent, 0) - g.j(motionEvent, 1)) + g.j(motionEvent, 1));
                }
                if (mMViewPager.mVm <= multiTouchImageView.cpX() * 2.0f) {
                    return false;
                }
                j = g.i(motionEvent, 0) - g.i(motionEvent, 1);
                sqrt = g.j(motionEvent, 0) - g.j(motionEvent, 1);
                multiTouchImageView.aE(multiTouchImageView.cpX() * 2.0f);
                multiTouchImageView.h(multiTouchImageView.cpX() * 2.0f, j + g.i(motionEvent, 1), sqrt + g.j(motionEvent, 1));
                return false;
            default:
                return false;
        }
    }

    public MMViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setStaticTransformationsEnabled(true);
    }

    private void aOA() {
        this.yer.removeMessages(1);
    }

    private void aOB() {
        aOA();
        k kVar = this.yer;
        kVar.mVE = 15;
        kVar.sendEmptyMessageDelayed(1, 15);
    }

    public final void b(e eVar) {
        this.yeB = eVar;
    }

    public MMViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setStaticTransformationsEnabled(true);
        this.yer = new k(new WeakReference(this));
        this.jtw = new GestureDetector(context, new d(this, (byte) 0));
        this.mVi = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.yex = (int) (getResources().getDisplayMetrics().density * 3000.0f);
        super.b(new 1(this));
        super.setOnTouchListener(new 2(this));
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.sqw = onTouchListener;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.kDP = MeasureSpec.getSize(i);
        this.kDQ = MeasureSpec.getSize(i2);
        this.mVk.set(0.0f, 0.0f, (float) this.kDP, (float) this.kDQ);
    }

    private boolean cpL() {
        x.d("MicroMsg.MMViewPager", "dancy scroll left right !!");
        if (this.yet) {
            return true;
        }
        this.yeu = true;
        return false;
    }

    private boolean a(float f, float f2, View view, float f3) {
        boolean z;
        if (this.yE.k(view) == cpN()) {
            if (this.yew) {
                if (f3 > 0.0f) {
                    if (f2 >= ((float) this.kDP)) {
                        this.mVy.K(-f3, 0.0f);
                    } else if (f2 > ((float) this.kDP) * 0.7f && f2 < ((float) this.kDQ)) {
                        this.mVy.K(-(f3 * 0.3f), 0.0f);
                        z = true;
                    }
                }
                z = false;
            } else if (f3 > 0.0f) {
                if (f2 < ((float) this.kDP)) {
                    this.yew = true;
                }
                if (f2 >= ((float) this.kDP)) {
                    this.mVy.K(-f3, 0.0f);
                } else if (f2 > ((float) this.kDP) * 0.7f && f2 < ((float) this.kDQ)) {
                    this.mVy.K(-(f3 * 0.3f), 0.0f);
                    z = true;
                }
            }
            if (z) {
                return true;
            }
            if (this.yE.k(view) == cpM()) {
                if (this.yev) {
                    if (f3 < 0.0f) {
                        if (f > this.mVk.left) {
                            this.mVy.K(-f3, 0.0f);
                        } else if (f > this.mVk.left && f < ((float) this.kDP) * 0.3f) {
                            this.mVy.K(-(f3 * 0.3f), 0.0f);
                            z = true;
                        }
                    }
                    z = false;
                } else if (f3 < 0.0f) {
                    if (f > 0.0f) {
                        this.yev = true;
                    }
                    if (f > this.mVk.left) {
                        this.mVy.K(-f3, 0.0f);
                    } else if (f > this.mVk.left && f < ((float) this.kDP) * 0.3f) {
                        this.mVy.K(-(f3 * 0.3f), 0.0f);
                        z = true;
                    }
                }
                if (z) {
                    return false;
                }
                return true;
            }
            if (!this.yeu || this.yet) {
                z = false;
            } else {
                this.yev = false;
                z = false;
            }
            if (z) {
                return true;
            }
            return false;
        }
        if (this.yeu || this.yet) {
            z = false;
        } else {
            this.yew = false;
            z = false;
        }
        if (z) {
            return true;
        }
        if (this.yE.k(view) == cpM()) {
            if (this.yev) {
                if (f3 < 0.0f) {
                    if (f > this.mVk.left) {
                        this.mVy.K(-(f3 * 0.3f), 0.0f);
                        z = true;
                    } else {
                        this.mVy.K(-f3, 0.0f);
                    }
                }
                z = false;
            } else if (f3 < 0.0f) {
                if (f > 0.0f) {
                    this.yev = true;
                }
                if (f > this.mVk.left) {
                    this.mVy.K(-(f3 * 0.3f), 0.0f);
                    z = true;
                } else {
                    this.mVy.K(-f3, 0.0f);
                }
            }
            if (z) {
                return false;
            }
            return true;
        }
        if (this.yeu) {
        }
        z = false;
        if (z) {
            return true;
        }
        return false;
    }

    public final void a(u uVar) {
        if (uVar instanceof v) {
            super.a(uVar);
            return;
        }
        throw new IllegalArgumentException("must be MMViewPagerAdapter");
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent.getX() - motionEvent2.getX() < 0.0f;
    }

    public void computeScroll() {
        int i = 0;
        super.computeScroll();
        if (this.mVy != null) {
            float scale = this.mVy.getScale() * ((float) this.mVy.imageWidth);
            float scale2 = this.mVy.getScale() * ((float) this.mVy.imageHeight);
            if (this.mVi.computeScrollOffset()) {
                int currX = this.mVi.getCurrX() - this.VQ;
                int currY = this.mVi.getCurrY() - this.VR;
                this.VQ = this.mVi.getCurrX();
                this.VR = this.mVi.getCurrY();
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

    public boolean isFocused() {
        return true;
    }

    public final int cpM() {
        int cpM = ((v) this.yE).cpM();
        return cpM >= 0 ? cpM : super.cpM();
    }

    public final int cpN() {
        int cpN = ((v) this.yE).cpN();
        return cpN >= 0 ? cpN : super.cpN();
    }
}
