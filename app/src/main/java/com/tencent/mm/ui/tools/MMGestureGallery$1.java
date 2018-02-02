package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.tools.MMGestureGallery.h;
import com.tencent.mm.ui.tools.MMGestureGallery.k;
import com.tencent.mm.w.a;

class MMGestureGallery$1 implements OnTouchListener {
    final /* synthetic */ MMGestureGallery zlk;

    MMGestureGallery$1(MMGestureGallery mMGestureGallery) {
        this.zlk = mMGestureGallery;
    }

    private void cxP() {
        cxQ();
        MMGestureGallery.e(this.zlk).i(2, 500, 0);
    }

    private void cxQ() {
        MMGestureGallery.e(this.zlk).removeMessages(2);
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (MMGestureGallery.f(this.zlk) == null) {
            MMGestureGallery.a(this.zlk, VelocityTracker.obtain());
        }
        MMGestureGallery.f(this.zlk).addMovement(motionEvent);
        View selectedView = this.zlk.getSelectedView();
        if (selectedView instanceof ViewGroup) {
            if (motionEvent.getAction() == 0) {
                MMGestureGallery.a(this.zlk, g.i(motionEvent, 0));
                MMGestureGallery.b(this.zlk, g.j(motionEvent, 0));
            }
            View findViewById = selectedView.findViewById(a.g.image);
            if (findViewById == null || findViewById.getVisibility() != 0 || (findViewById instanceof MultiTouchImageView)) {
                selectedView = selectedView.findViewById(a.g.cpd);
                if (selectedView == null || selectedView.getVisibility() == 8) {
                    if (MMGestureGallery.g(this.zlk) && MMGestureGallery.h(this.zlk) != null && motionEvent.getAction() == 1 && Math.abs(MMGestureGallery.i(this.zlk) - g.i(motionEvent, 0)) < 10.0f && Math.abs(MMGestureGallery.j(this.zlk) - g.j(motionEvent, 0)) < 10.0f) {
                        nt(true);
                    }
                    return false;
                }
                selectedView = selectedView.findViewById(a.g.image);
                if (selectedView == null) {
                    return false;
                }
            }
            if (motionEvent.getAction() == 0) {
                cxP();
            }
            if (motionEvent.getAction() == 1) {
                cxQ();
            }
            return false;
        }
        if (selectedView instanceof MultiTouchImageView) {
            float i;
            float j;
            MMGestureGallery.a(this.zlk, (MultiTouchImageView) selectedView);
            x.d("dktest", "MMGestureGallery onTouch event.getAction():" + motionEvent.getAction());
            if (motionEvent.getAction() == 0) {
                cxP();
                MMGestureGallery.a(this.zlk).cpW();
                MMGestureGallery.c(this.zlk, motionEvent.getX());
                MMGestureGallery.d(this.zlk, motionEvent.getY());
                MMGestureGallery.e(this.zlk, 0.0f);
                MMGestureGallery.f(this.zlk, MMGestureGallery.a(this.zlk).getScale());
                x.d("dktest", "originalScale :" + MMGestureGallery.k(this.zlk));
                MMGestureGallery.a(this.zlk, false);
                MMGestureGallery.l(this.zlk);
                if (MMGestureGallery.m(this.zlk) == 1) {
                    MMGestureGallery.a(this.zlk, System.currentTimeMillis());
                    MMGestureGallery.a(this.zlk, g.i(motionEvent, 0));
                    MMGestureGallery.b(this.zlk, g.j(motionEvent, 0));
                } else if (MMGestureGallery.m(this.zlk) == 2) {
                    MMGestureGallery.b(this.zlk, System.currentTimeMillis());
                    if (MMGestureGallery.n(this.zlk) - MMGestureGallery.o(this.zlk) >= 350) {
                        MMGestureGallery.a(this.zlk, 1);
                    } else if (Math.abs(MMGestureGallery.i(this.zlk) - g.i(motionEvent, 0)) >= 35.0f || Math.abs(MMGestureGallery.j(this.zlk) - g.j(motionEvent, 0)) >= 35.0f) {
                        MMGestureGallery.a(this.zlk, 1);
                    } else {
                        MMGestureGallery.a(this.zlk, 0);
                        x.d("MicroMsg.MMGestureGallery", "double click!");
                        if (MMGestureGallery.a(this.zlk).getScale() <= MMGestureGallery.a(this.zlk).pXP) {
                            MMGestureGallery.a(this.zlk).J(g.i(motionEvent, 0), g.j(motionEvent, 0));
                        } else {
                            MMGestureGallery.a(this.zlk).I(g.i(motionEvent, 0), g.j(motionEvent, 0));
                            MMGestureGallery.a(this.zlk).cpV();
                        }
                    }
                }
            }
            if (motionEvent.getAction() == 6 || motionEvent.getAction() == 262) {
                cxQ();
                MMGestureGallery.e(this.zlk, 0.0f);
                MMGestureGallery.f(this.zlk, MMGestureGallery.a(this.zlk).getScale());
                MMGestureGallery.a(this.zlk, true);
                if (MMGestureGallery.k(this.zlk) < MMGestureGallery.a(this.zlk).pXP) {
                    MMGestureGallery.a(this.zlk).I((g.i(motionEvent, 0) - g.i(motionEvent, 1)) + g.i(motionEvent, 1), (g.j(motionEvent, 0) - g.j(motionEvent, 1)) + g.j(motionEvent, 1));
                }
                if (MMGestureGallery.k(this.zlk) > MMGestureGallery.a(this.zlk).cpX() * 2.0f) {
                    i = g.i(motionEvent, 0) - g.i(motionEvent, 1);
                    j = g.j(motionEvent, 0) - g.j(motionEvent, 1);
                    MMGestureGallery.a(this.zlk).aE(MMGestureGallery.a(this.zlk).cpX() * 2.0f);
                    MMGestureGallery.a(this.zlk).h(MMGestureGallery.a(this.zlk).cpX() * 2.0f, i + g.i(motionEvent, 1), j + g.j(motionEvent, 1));
                }
            }
            if (motionEvent.getAction() == 1) {
                cxQ();
                MMGestureGallery.p(this.zlk);
                MMGestureGallery.q(this.zlk);
                MMGestureGallery.r(this.zlk);
                if ((MMGestureGallery.s(this.zlk) || MMGestureGallery.t(this.zlk) || MMGestureGallery.u(this.zlk) || MMGestureGallery.v(this.zlk)) && (MMGestureGallery.w(this.zlk) || MMGestureGallery.x(this.zlk))) {
                    MMGestureGallery.a(this.zlk, new h(this.zlk));
                    MMGestureGallery.y(this.zlk);
                    MMGestureGallery.z(this.zlk);
                    MMGestureGallery.A(this.zlk);
                    MMGestureGallery.B(this.zlk);
                    MMGestureGallery.C(this.zlk);
                    MMGestureGallery.D(this.zlk);
                    MMGestureGallery.E(this.zlk);
                } else {
                    if (MMGestureGallery.u(this.zlk) || MMGestureGallery.s(this.zlk)) {
                        MMGestureGallery.B(this.zlk);
                        MMGestureGallery.z(this.zlk);
                        MMGestureGallery.a(this.zlk, new MMGestureGallery$i(this.zlk));
                        MMGestureGallery.y(this.zlk);
                    }
                    if (MMGestureGallery.v(this.zlk) || MMGestureGallery.t(this.zlk)) {
                        MMGestureGallery.C(this.zlk);
                        MMGestureGallery.A(this.zlk);
                        MMGestureGallery.a(this.zlk, new MMGestureGallery$j(this.zlk));
                        MMGestureGallery.y(this.zlk);
                    }
                    if (MMGestureGallery.w(this.zlk)) {
                        MMGestureGallery.D(this.zlk);
                        MMGestureGallery.a(this.zlk, new k(this.zlk));
                        MMGestureGallery.y(this.zlk);
                    }
                    if (MMGestureGallery.x(this.zlk)) {
                        MMGestureGallery.E(this.zlk);
                        MMGestureGallery.a(this.zlk, new MMGestureGallery.g(this.zlk));
                        MMGestureGallery.y(this.zlk);
                    }
                    if (MMGestureGallery.F(this.zlk)) {
                        if (MMGestureGallery.G(this.zlk) != null) {
                            MMGestureGallery.G(this.zlk).E(0.0f, 0.0f);
                        }
                        MMGestureGallery.b(this.zlk, false);
                    }
                    if (MMGestureGallery.H(this.zlk) && !MMGestureGallery.I(this.zlk)) {
                        MMGestureGallery.J(this.zlk).t(0, true);
                        MMGestureGallery.b(this.zlk, false);
                    }
                }
                MMGestureGallery.e(this.zlk, 0.0f);
                MMGestureGallery.f(this.zlk, MMGestureGallery.a(this.zlk).getScale());
                if (MMGestureGallery.m(this.zlk) == 1) {
                    MMGestureGallery.c(this.zlk, System.currentTimeMillis());
                    if (MMGestureGallery.o(this.zlk) - MMGestureGallery.K(this.zlk) >= 350) {
                        MMGestureGallery.a(this.zlk, 0);
                        x.d("MicroMsg.MMGestureGallery", "single long click over!");
                    } else if (Math.abs(MMGestureGallery.i(this.zlk) - g.i(motionEvent, 0)) < 10.0f && Math.abs(MMGestureGallery.j(this.zlk) - g.j(motionEvent, 0)) < 10.0f) {
                        nt(false);
                    }
                }
            }
            if (motionEvent.getAction() == 5 || motionEvent.getAction() == 261) {
                MMGestureGallery.e(this.zlk, 0.0f);
                MMGestureGallery.f(this.zlk, MMGestureGallery.a(this.zlk).getScale());
                MMGestureGallery.a(this.zlk, true);
            }
            if (motionEvent.getAction() == 2) {
                float sqrt;
                if (g.K(motionEvent) == 2) {
                    cxQ();
                    if (MMGestureGallery.L(this.zlk) || MMGestureGallery.u(this.zlk) || MMGestureGallery.v(this.zlk)) {
                        return true;
                    }
                    MMGestureGallery.a(this.zlk, true);
                    MMGestureGallery.a(this.zlk, 0);
                    i = g.i(motionEvent, 0) - g.i(motionEvent, 1);
                    j = g.j(motionEvent, 0) - g.j(motionEvent, 1);
                    sqrt = (float) Math.sqrt((double) ((i * i) + (j * j)));
                    if (MMGestureGallery.M(this.zlk) == 0.0f) {
                        MMGestureGallery.e(this.zlk, sqrt);
                    } else {
                        sqrt /= MMGestureGallery.M(this.zlk);
                        if (MMGestureGallery.N(this.zlk)) {
                            MMGestureGallery.a(this.zlk).h(sqrt * MMGestureGallery.k(this.zlk), i + g.i(motionEvent, 1), g.j(motionEvent, 1) + j);
                        }
                    }
                } else {
                    VelocityTracker f = MMGestureGallery.f(this.zlk);
                    f.computeCurrentVelocity(1000);
                    int xVelocity = (int) f.getXVelocity();
                    int yVelocity = (int) f.getYVelocity();
                    sqrt = motionEvent.getX() - MMGestureGallery.O(this.zlk);
                    float y = motionEvent.getY() - MMGestureGallery.P(this.zlk);
                    if (!(MMGestureGallery.G(this.zlk) == null || MMGestureGallery.I(this.zlk) || MMGestureGallery.N(this.zlk) || MMGestureGallery.k(this.zlk) > MMGestureGallery.a(this.zlk).pXP)) {
                        MMGestureGallery.G(this.zlk).F(sqrt, y);
                        if ((Math.abs(sqrt) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || MMGestureGallery.Q(this.zlk)) && !MMGestureGallery.H(this.zlk)) {
                            MMGestureGallery.b(this.zlk, false);
                        } else {
                            MMGestureGallery.G(this.zlk).E(sqrt, y);
                            MMGestureGallery.b(this.zlk, true);
                        }
                        if (y > 200.0f) {
                            MMGestureGallery.c(this.zlk, false);
                        } else {
                            MMGestureGallery.c(this.zlk, true);
                        }
                    }
                    if (MMGestureGallery.f(this.zlk) != null) {
                        MMGestureGallery.f(this.zlk).recycle();
                        MMGestureGallery.a(this.zlk, null);
                    }
                    if (Math.abs(MMGestureGallery.i(this.zlk) - g.i(motionEvent, 0)) > 35.0f || Math.abs(MMGestureGallery.j(this.zlk) - g.j(motionEvent, 0)) > 35.0f) {
                        cxQ();
                        MMGestureGallery.a(this.zlk, 0);
                    }
                }
            }
        }
        return false;
    }

    private void nt(boolean z) {
        MMGestureGallery.J(this.zlk).t(350, z);
    }
}
