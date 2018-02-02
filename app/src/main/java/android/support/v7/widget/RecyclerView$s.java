package android.support.v7.widget;

import android.support.v4.os.e;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

class RecyclerView$s implements Runnable {
    final /* synthetic */ RecyclerView UQ;
    int VQ;
    int VR;
    private boolean VS = false;
    private boolean VT = false;
    q iK;
    private Interpolator mInterpolator = RecyclerView.fN();

    public RecyclerView$s(RecyclerView recyclerView) {
        this.UQ = recyclerView;
        this.iK = q.a(recyclerView.getContext(), RecyclerView.fN());
    }

    public final void run() {
        if (this.UQ.TV == null) {
            stop();
            return;
        }
        this.VT = false;
        this.VS = true;
        RecyclerView.d(this.UQ);
        q qVar = this.iK;
        RecyclerView$p recyclerView$p = this.UQ.TV.Vb;
        if (qVar.computeScrollOffset()) {
            int itemCount;
            int i;
            int currVelocity;
            int i2;
            View view;
            Object obj;
            Object obj2;
            int currX = qVar.getCurrX();
            int currY = qVar.getCurrY();
            int i3 = currX - this.VQ;
            int i4 = currY - this.VR;
            int i5 = 0;
            int i6 = 0;
            this.VQ = currX;
            this.VR = currY;
            int i7 = 0;
            int i8 = 0;
            if (RecyclerView.h(this.UQ) != null) {
                this.UQ.fo();
                RecyclerView.i(this.UQ);
                e.beginSection("RV Scroll");
                if (i3 != 0) {
                    i5 = this.UQ.TV.a(i3, this.UQ.TN, this.UQ.UB);
                    i7 = i3 - i5;
                }
                if (i4 != 0) {
                    i6 = this.UQ.TV.b(i4, this.UQ.TN, this.UQ.UB);
                    i8 = i4 - i6;
                }
                e.endSection();
                RecyclerView.j(this.UQ);
                RecyclerView.k(this.UQ);
                this.UQ.Q(false);
                if (!(recyclerView$p == null || recyclerView$p.Vw || !recyclerView$p.Vx)) {
                    itemCount = this.UQ.UB.getItemCount();
                    if (itemCount == 0) {
                        recyclerView$p.stop();
                        i = i7;
                        i7 = i6;
                        i6 = i;
                        if (!RecyclerView.l(this.UQ).isEmpty()) {
                            this.UQ.invalidate();
                        }
                        if (z.B(this.UQ) != 2) {
                            RecyclerView.a(this.UQ, i3, i4);
                        }
                        if (!(i6 == 0 && i8 == 0)) {
                            currVelocity = (int) qVar.getCurrVelocity();
                            if (i6 == currX) {
                                itemCount = i6 >= 0 ? -currVelocity : i6 <= 0 ? currVelocity : 0;
                                i2 = itemCount;
                            } else {
                                i2 = 0;
                            }
                            if (i8 != currY) {
                                currVelocity = 0;
                            } else if (i8 < 0) {
                                currVelocity = -currVelocity;
                            } else if (i8 <= 0) {
                                currVelocity = 0;
                            }
                            if (z.B(this.UQ) != 2) {
                                view = this.UQ;
                                if (i2 < 0) {
                                    view.fr();
                                    view.Un.ap(-i2);
                                } else if (i2 > 0) {
                                    view.fs();
                                    view.Up.ap(i2);
                                }
                                if (currVelocity < 0) {
                                    view.ft();
                                    view.Uo.ap(-currVelocity);
                                } else if (currVelocity > 0) {
                                    view.fu();
                                    view.Uq.ap(currVelocity);
                                }
                                if (!(i2 == 0 && currVelocity == 0)) {
                                    z.E(view);
                                }
                            }
                            if ((i2 != 0 || i6 == currX || qVar.getFinalX() == 0) && (currVelocity != 0 || i8 == currY || qVar.getFinalY() == 0)) {
                                qVar.abortAnimation();
                            }
                        }
                        if (!(i5 == 0 && i7 == 0)) {
                            this.UQ.T(i5, i7);
                        }
                        if (!RecyclerView.m(this.UQ)) {
                            this.UQ.invalidate();
                        }
                        obj = (i4 == 0 && this.UQ.TV.eR() && i7 == i4) ? 1 : null;
                        obj2 = (i3 == 0 && this.UQ.TV.eQ() && i5 == i3) ? 1 : null;
                        obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                        if (!qVar.isFinished() || obj2 == null) {
                            RecyclerView.c(this.UQ, 0);
                        } else {
                            fZ();
                        }
                    } else {
                        if (recyclerView$p.Vv >= itemCount) {
                            recyclerView$p.Vv = itemCount - 1;
                        }
                        RecyclerView$p.a(recyclerView$p, i3 - i7, i4 - i8);
                    }
                }
            }
            i = i7;
            i7 = i6;
            i6 = i;
            if (RecyclerView.l(this.UQ).isEmpty()) {
                this.UQ.invalidate();
            }
            if (z.B(this.UQ) != 2) {
                RecyclerView.a(this.UQ, i3, i4);
            }
            currVelocity = (int) qVar.getCurrVelocity();
            if (i6 == currX) {
                i2 = 0;
            } else {
                if (i6 >= 0) {
                    if (i6 <= 0) {
                    }
                }
                i2 = itemCount;
            }
            if (i8 != currY) {
                currVelocity = 0;
            } else if (i8 < 0) {
                currVelocity = -currVelocity;
            } else if (i8 <= 0) {
                currVelocity = 0;
            }
            if (z.B(this.UQ) != 2) {
                view = this.UQ;
                if (i2 < 0) {
                    view.fr();
                    view.Un.ap(-i2);
                } else if (i2 > 0) {
                    view.fs();
                    view.Up.ap(i2);
                }
                if (currVelocity < 0) {
                    view.ft();
                    view.Uo.ap(-currVelocity);
                } else if (currVelocity > 0) {
                    view.fu();
                    view.Uq.ap(currVelocity);
                }
                z.E(view);
            }
            qVar.abortAnimation();
            this.UQ.T(i5, i7);
            if (RecyclerView.m(this.UQ)) {
                this.UQ.invalidate();
            }
            if (i4 == 0) {
            }
            if (i3 == 0) {
            }
            if (i3 == 0) {
            }
            if (qVar.isFinished()) {
            }
            RecyclerView.c(this.UQ, 0);
        }
        if (recyclerView$p != null) {
            if (recyclerView$p.Vw) {
                RecyclerView$p.a(recyclerView$p, 0, 0);
            }
            if (!this.VT) {
                recyclerView$p.stop();
            }
        }
        this.VS = false;
        if (this.VT) {
            fZ();
        }
    }

    final void fZ() {
        if (this.VS) {
            this.VT = true;
            return;
        }
        this.UQ.removeCallbacks(this);
        z.a(this.UQ, this);
    }

    public final void smoothScrollBy(int i, int i2) {
        int round;
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        Object obj = abs > abs2 ? 1 : null;
        int sqrt = (int) Math.sqrt(0.0d);
        int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
        int width = obj != null ? this.UQ.getWidth() : this.UQ.getHeight();
        int i3 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i3)) + ((float) i3);
        if (sqrt > 0) {
            round = Math.round(1000.0f * Math.abs(sin / ((float) sqrt))) * 4;
        } else {
            round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
        }
        o(i, i2, Math.min(round, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN));
    }

    public final void o(int i, int i2, int i3) {
        b(i, i2, i3, RecyclerView.fN());
    }

    public final void b(int i, int i2, int i3, Interpolator interpolator) {
        if (this.mInterpolator != interpolator) {
            this.mInterpolator = interpolator;
            this.iK = q.a(this.UQ.getContext(), interpolator);
        }
        RecyclerView.c(this.UQ, 2);
        this.VR = 0;
        this.VQ = 0;
        this.iK.startScroll(0, 0, i, i2, i3);
        fZ();
    }

    public final void stop() {
        this.UQ.removeCallbacks(this);
        this.iK.abortAnimation();
    }
}
