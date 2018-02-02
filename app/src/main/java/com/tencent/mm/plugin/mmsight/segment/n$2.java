package com.tencent.mm.plugin.mmsight.segment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.mmsight.segment.n.a;

class n$2 implements OnTouchListener {
    float iQK;
    float iQL;
    final /* synthetic */ n ozv;
    int ozw = -1;
    int ozx = -1;
    int ozy;
    int ozz;

    n$2(n nVar) {
        this.ozv = nVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!n.h(this.ozv)) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                this.ozz = motionEvent.getActionIndex();
                this.ozy = motionEvent.getPointerId(this.ozz);
                this.iQK = motionEvent.getX(this.ozz);
                this.iQL = motionEvent.getY(this.ozz);
                if (n.a(this.ozv, n.c(this.ozv), this.iQK, this.iQL)) {
                    if (n.a(this.ozv, true)) {
                        return false;
                    }
                    if (n.j(this.ozv) != null) {
                        n.j(this.ozv).bbm();
                    }
                    this.ozw = this.ozy;
                    n.a(this.ozv, (float) n.c(this.ozv).getBounds().left);
                    n.a(this.ozv, true, true);
                    return true;
                } else if (!n.a(this.ozv, n.e(this.ozv), this.iQK, this.iQL) || n.a(this.ozv, false)) {
                    return false;
                } else {
                    if (n.j(this.ozv) != null) {
                        n.j(this.ozv).bbm();
                    }
                    this.ozx = this.ozy;
                    n.b(this.ozv, (float) n.e(this.ozv).getBounds().right);
                    n.a(this.ozv, false, true);
                    return true;
                }
            case 1:
            case 3:
            case 6:
                this.ozy = motionEvent.getPointerId(motionEvent.getActionIndex());
                if (this.ozy != this.ozw && this.ozy != this.ozx) {
                    return false;
                }
                if (n.j(this.ozv) != null) {
                    n.j(this.ozv).bbn();
                }
                n.a(this.ozv, this.ozy == this.ozw, false);
                if (this.ozy == this.ozw) {
                    this.ozw = -1;
                } else {
                    this.ozx = -1;
                }
                return true;
            case 2:
                if (!n.a(this.ozv, true) && !n.a(this.ozv, false)) {
                    return false;
                }
                if (n.i(this.ozv)) {
                    return true;
                }
                this.ozz = 0;
                boolean z = false;
                while (this.ozz < motionEvent.getPointerCount()) {
                    this.ozy = motionEvent.getPointerId(this.ozz);
                    if (this.ozy == this.ozw || this.ozy == this.ozx) {
                        n nVar = this.ozv;
                        if (this.ozy == this.ozw) {
                            z = true;
                        } else {
                            z = false;
                        }
                        n.a(nVar, z, motionEvent.getX(this.ozz));
                        if (n.j(this.ozv) != null) {
                            a j = n.j(this.ozv);
                            if (this.ozy == this.ozw) {
                                z = true;
                            } else {
                                z = false;
                            }
                            j.gG(z);
                        }
                        z = true;
                    }
                    this.ozz++;
                }
                return z;
            default:
                return false;
        }
    }
}
