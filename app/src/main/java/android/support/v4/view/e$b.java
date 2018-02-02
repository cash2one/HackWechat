package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class e$b implements e$a {
    private static final int wQ = ViewConfiguration.getLongPressTimeout();
    private static final int wR = ViewConfiguration.getTapTimeout();
    private static final int wS = ViewConfiguration.getDoubleTapTimeout();
    private VelocityTracker ft;
    private final Handler mHandler = new a(this);
    private int wM;
    private int wN;
    private int wO;
    private int wP;
    private final OnGestureListener wT;
    private OnDoubleTapListener wU;
    private boolean wV;
    private boolean wW;
    private boolean wX;
    private boolean wY;
    private boolean wZ;
    private MotionEvent xa;
    private MotionEvent xb;
    private boolean xc;
    private float xd;
    private float xe;
    private float xf;
    private float xg;
    private boolean xh;

    static /* synthetic */ void c(e$b android_support_v4_view_e_b) {
        android_support_v4_view_e_b.mHandler.removeMessages(3);
        android_support_v4_view_e_b.wW = false;
        android_support_v4_view_e_b.wX = true;
        android_support_v4_view_e_b.wT.onLongPress(android_support_v4_view_e_b.xa);
    }

    public e$b(Context context, OnGestureListener onGestureListener, Handler handler) {
        this.wT = onGestureListener;
        if (onGestureListener instanceof OnDoubleTapListener) {
            this.wU = (OnDoubleTapListener) onGestureListener;
        }
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        } else if (this.wT == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        } else {
            this.xh = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.wO = viewConfiguration.getScaledMinimumFlingVelocity();
            this.wP = viewConfiguration.getScaledMaximumFlingVelocity();
            this.wM = scaledTouchSlop * scaledTouchSlop;
            this.wN = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        boolean z = (action & 255) == 6;
        int e = z ? o.e(motionEvent) : -1;
        int f = o.f(motionEvent);
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (i = 0; i < f; i++) {
            if (e != i) {
                f3 += o.d(motionEvent, i);
                f2 += o.e(motionEvent, i);
            }
        }
        e = z ? f - 1 : f;
        f3 /= (float) e;
        f2 /= (float) e;
        boolean hasMessages;
        float b;
        float a;
        switch (action & 255) {
            case 0:
                if (this.wU != null) {
                    hasMessages = this.mHandler.hasMessages(3);
                    if (hasMessages) {
                        this.mHandler.removeMessages(3);
                    }
                    if (!(this.xa == null || this.xb == null || !hasMessages)) {
                        MotionEvent motionEvent2 = this.xa;
                        MotionEvent motionEvent3 = this.xb;
                        if (this.wZ && motionEvent.getEventTime() - motionEvent3.getEventTime() <= ((long) wS)) {
                            f = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
                            e = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
                            if ((e * e) + (f * f) < this.wN) {
                                hasMessages = true;
                                if (hasMessages) {
                                    this.xc = true;
                                    e = (this.wU.onDoubleTap(this.xa) | 0) | this.wU.onDoubleTapEvent(motionEvent);
                                    this.xd = f3;
                                    this.xf = f3;
                                    this.xe = f2;
                                    this.xg = f2;
                                    if (this.xa != null) {
                                        this.xa.recycle();
                                    }
                                    this.xa = MotionEvent.obtain(motionEvent);
                                    this.wY = true;
                                    this.wZ = true;
                                    this.wV = true;
                                    this.wX = false;
                                    this.wW = false;
                                    if (this.xh) {
                                        this.mHandler.removeMessages(2);
                                        this.mHandler.sendEmptyMessageAtTime(2, (this.xa.getDownTime() + ((long) wR)) + ((long) wQ));
                                    }
                                    this.mHandler.sendEmptyMessageAtTime(1, this.xa.getDownTime() + ((long) wR));
                                    return e | this.wT.onDown(motionEvent);
                                }
                            }
                        }
                        hasMessages = false;
                        if (hasMessages) {
                            this.xc = true;
                            e = (this.wU.onDoubleTap(this.xa) | 0) | this.wU.onDoubleTapEvent(motionEvent);
                            this.xd = f3;
                            this.xf = f3;
                            this.xe = f2;
                            this.xg = f2;
                            if (this.xa != null) {
                                this.xa.recycle();
                            }
                            this.xa = MotionEvent.obtain(motionEvent);
                            this.wY = true;
                            this.wZ = true;
                            this.wV = true;
                            this.wX = false;
                            this.wW = false;
                            if (this.xh) {
                                this.mHandler.removeMessages(2);
                                this.mHandler.sendEmptyMessageAtTime(2, (this.xa.getDownTime() + ((long) wR)) + ((long) wQ));
                            }
                            this.mHandler.sendEmptyMessageAtTime(1, this.xa.getDownTime() + ((long) wR));
                            return e | this.wT.onDown(motionEvent);
                        }
                    }
                    this.mHandler.sendEmptyMessageDelayed(3, (long) wS);
                }
                e = 0;
                this.xd = f3;
                this.xf = f3;
                this.xe = f2;
                this.xg = f2;
                if (this.xa != null) {
                    this.xa.recycle();
                }
                this.xa = MotionEvent.obtain(motionEvent);
                this.wY = true;
                this.wZ = true;
                this.wV = true;
                this.wX = false;
                this.wW = false;
                if (this.xh) {
                    this.mHandler.removeMessages(2);
                    this.mHandler.sendEmptyMessageAtTime(2, (this.xa.getDownTime() + ((long) wR)) + ((long) wQ));
                }
                this.mHandler.sendEmptyMessageAtTime(1, this.xa.getDownTime() + ((long) wR));
                return e | this.wT.onDown(motionEvent);
            case 1:
                this.wV = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.xc) {
                    hasMessages = this.wU.onDoubleTapEvent(motionEvent) | 0;
                } else if (this.wX) {
                    this.mHandler.removeMessages(3);
                    this.wX = false;
                    hasMessages = false;
                } else if (this.wY) {
                    hasMessages = this.wT.onSingleTapUp(motionEvent);
                    if (this.wW && this.wU != null) {
                        this.wU.onSingleTapConfirmed(motionEvent);
                    }
                } else {
                    VelocityTracker velocityTracker = this.ft;
                    int c = o.c(motionEvent, 0);
                    velocityTracker.computeCurrentVelocity(1000, (float) this.wP);
                    b = y.b(velocityTracker, c);
                    a = y.a(velocityTracker, c);
                    hasMessages = (Math.abs(b) > ((float) this.wO) || Math.abs(a) > ((float) this.wO)) ? this.wT.onFling(this.xa, motionEvent, a, b) : false;
                }
                if (this.xb != null) {
                    this.xb.recycle();
                }
                this.xb = obtain;
                if (this.ft != null) {
                    this.ft.recycle();
                    this.ft = null;
                }
                this.xc = false;
                this.wW = false;
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
                return hasMessages;
            case 2:
                if (this.wX) {
                    return false;
                }
                a = this.xd - f3;
                b = this.xe - f2;
                if (this.xc) {
                    return this.wU.onDoubleTapEvent(motionEvent) | 0;
                }
                if (this.wY) {
                    i = (int) (f3 - this.xf);
                    int i2 = (int) (f2 - this.xg);
                    i = (i * i) + (i2 * i2);
                    if (i > this.wM) {
                        hasMessages = this.wT.onScroll(this.xa, motionEvent, a, b);
                        this.xd = f3;
                        this.xe = f2;
                        this.wY = false;
                        this.mHandler.removeMessages(3);
                        this.mHandler.removeMessages(1);
                        this.mHandler.removeMessages(2);
                    } else {
                        hasMessages = false;
                    }
                    if (i > this.wM) {
                        this.wZ = false;
                    }
                    return hasMessages;
                } else if (Math.abs(a) < 1.0f && Math.abs(b) < 1.0f) {
                    return false;
                } else {
                    boolean onScroll = this.wT.onScroll(this.xa, motionEvent, a, b);
                    this.xd = f3;
                    this.xe = f2;
                    return onScroll;
                }
            case 3:
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
                this.mHandler.removeMessages(3);
                this.ft.recycle();
                this.ft = null;
                this.xc = false;
                this.wV = false;
                this.wY = false;
                this.wZ = false;
                this.wW = false;
                if (!this.wX) {
                    return false;
                }
                this.wX = false;
                return false;
            case 5:
                this.xd = f3;
                this.xf = f3;
                this.xe = f2;
                this.xg = f2;
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
                this.mHandler.removeMessages(3);
                this.xc = false;
                this.wY = false;
                this.wZ = false;
                this.wW = false;
                if (!this.wX) {
                    return false;
                }
                this.wX = false;
                return false;
            case 6:
                this.xd = f3;
                this.xf = f3;
                this.xe = f2;
                this.xg = f2;
                this.ft.computeCurrentVelocity(1000, (float) this.wP);
                int e2 = o.e(motionEvent);
                e = o.c(motionEvent, e2);
                f3 = y.a(this.ft, e);
                float b2 = y.b(this.ft, e);
                for (e = 0; e < f; e++) {
                    if (e != e2) {
                        i = o.c(motionEvent, e);
                        if ((y.b(this.ft, i) * b2) + (y.a(this.ft, i) * f3) < 0.0f) {
                            this.ft.clear();
                            return false;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }
}
