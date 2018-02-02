package android.support.v7.widget.a;

import android.support.v4.view.o;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.j;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

class a$2 implements j {
    final /* synthetic */ a aaZ;

    a$2(a aVar) {
        this.aaZ = aVar;
    }

    public final boolean n(MotionEvent motionEvent) {
        this.aaZ.aaW.onTouchEvent(motionEvent);
        int d = o.d(motionEvent);
        if (d == 0) {
            this.aaZ.fu = o.c(motionEvent, 0);
            this.aaZ.aaE = motionEvent.getX();
            this.aaZ.aaF = motionEvent.getY();
            a aVar = this.aaZ;
            if (aVar.ft != null) {
                aVar.ft.recycle();
            }
            aVar.ft = VelocityTracker.obtain();
            if (this.aaZ.aaD == null) {
                a$c android_support_v7_widget_a_a_c;
                a aVar2 = this.aaZ;
                if (!aVar2.aaP.isEmpty()) {
                    View p = aVar2.p(motionEvent);
                    for (int size = aVar2.aaP.size() - 1; size >= 0; size--) {
                        android_support_v7_widget_a_a_c = (a$c) aVar2.aaP.get(size);
                        if (android_support_v7_widget_a_a_c.Vh.VU == p) {
                            break;
                        }
                    }
                }
                android_support_v7_widget_a_a_c = null;
                if (android_support_v7_widget_a_a_c != null) {
                    a aVar3 = this.aaZ;
                    aVar3.aaE -= android_support_v7_widget_a_a_c.abo;
                    aVar3 = this.aaZ;
                    aVar3.aaF -= android_support_v7_widget_a_a_c.abp;
                    this.aaZ.a(android_support_v7_widget_a_a_c.Vh, true);
                    if (this.aaZ.aaB.remove(android_support_v7_widget_a_a_c.Vh.VU)) {
                        this.aaZ.aaM.c(this.aaZ.Va, android_support_v7_widget_a_a_c.Vh);
                    }
                    this.aaZ.d(android_support_v7_widget_a_a_c.Vh, android_support_v7_widget_a_a_c.aaN);
                    a.a(this.aaZ, motionEvent, this.aaZ.aaO, 0);
                }
            }
        } else if (d == 3 || d == 1) {
            this.aaZ.fu = -1;
            this.aaZ.d(null, 0);
        } else if (this.aaZ.fu != -1) {
            int b = o.b(motionEvent, this.aaZ.fu);
            if (b >= 0) {
                a.a(this.aaZ, d, motionEvent, b);
            }
        }
        if (this.aaZ.ft != null) {
            this.aaZ.ft.addMovement(motionEvent);
        }
        if (this.aaZ.aaD != null) {
            return true;
        }
        return false;
    }

    public final void o(MotionEvent motionEvent) {
        int i = 0;
        this.aaZ.aaW.onTouchEvent(motionEvent);
        if (this.aaZ.ft != null) {
            this.aaZ.ft.addMovement(motionEvent);
        }
        if (this.aaZ.fu != -1) {
            int d = o.d(motionEvent);
            int b = o.b(motionEvent, this.aaZ.fu);
            if (b >= 0) {
                a.a(this.aaZ, d, motionEvent, b);
            }
            RecyclerView$t recyclerView$t = this.aaZ.aaD;
            if (recyclerView$t != null) {
                switch (d) {
                    case 1:
                        break;
                    case 2:
                        if (b >= 0) {
                            a.a(this.aaZ, motionEvent, this.aaZ.aaO, b);
                            a.a(this.aaZ, recyclerView$t);
                            this.aaZ.Va.removeCallbacks(this.aaZ.aaR);
                            this.aaZ.aaR.run();
                            this.aaZ.Va.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        if (this.aaZ.ft != null) {
                            this.aaZ.ft.clear();
                            break;
                        }
                        break;
                    case 6:
                        d = o.e(motionEvent);
                        if (o.c(motionEvent, d) == this.aaZ.fu) {
                            if (d == 0) {
                                i = 1;
                            }
                            this.aaZ.fu = o.c(motionEvent, i);
                            a.a(this.aaZ, motionEvent, this.aaZ.aaO, d);
                            return;
                        }
                        return;
                    default:
                        return;
                }
                this.aaZ.d(null, 0);
                this.aaZ.fu = -1;
            }
        }
    }

    public final void S(boolean z) {
        if (z) {
            this.aaZ.d(null, 0);
        }
    }
}
