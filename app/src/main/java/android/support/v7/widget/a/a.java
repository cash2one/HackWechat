package android.support.v7.widget.a;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.e;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$q;
import android.support.v7.widget.RecyclerView.d;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.t;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.List;

public final class a extends g implements i {
    private d UJ = null;
    RecyclerView Va;
    final List<View> aaB = new ArrayList();
    private final float[] aaC = new float[2];
    t aaD = null;
    float aaE;
    float aaF;
    float aaG;
    float aaH;
    float aaI;
    float aaJ;
    float aaK;
    float aaL;
    a aaM;
    int aaN = 0;
    int aaO;
    List<c> aaP = new ArrayList();
    private int aaQ;
    final Runnable aaR = new 1(this);
    private List<t> aaS;
    private List<Integer> aaT;
    View aaU = null;
    int aaV = -1;
    e aaW;
    private final j aaX = new 2(this);
    long aaY;
    VelocityTracker ft;
    int fu = -1;
    Rect gO;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ a aaZ;
        final /* synthetic */ int aba;
        final /* synthetic */ c abc;

        AnonymousClass4(a aVar, c cVar, int i) {
            this.aaZ = aVar;
            this.abc = cVar;
            this.aba = i;
        }

        public final void run() {
            if (this.aaZ.Va != null && this.aaZ.Va.isAttachedToWindow() && !this.abc.abq && this.abc.Vh.ge() != -1) {
                RecyclerView.e eVar = this.aaZ.Va.Ur;
                if (eVar == null || !eVar.a(null)) {
                    Object obj;
                    a aVar = this.aaZ;
                    int size = aVar.aaP.size();
                    for (int i = 0; i < size; i++) {
                        if (!((c) aVar.aaP.get(i)).oP) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        this.aaZ.aaM.hn();
                        return;
                    }
                }
                this.aaZ.Va.post(this);
            }
        }
    }

    static /* synthetic */ void a(a aVar, t tVar) {
        if (!aVar.Va.isLayoutRequested() && aVar.aaN == 2) {
            float hm = aVar.aaM.hm();
            int i = (int) (aVar.aaK + aVar.aaI);
            int i2 = (int) (aVar.aaL + aVar.aaJ);
            if (((float) Math.abs(i2 - tVar.VU.getTop())) >= ((float) tVar.VU.getHeight()) * hm || ((float) Math.abs(i - tVar.VU.getLeft())) >= hm * ((float) tVar.VU.getWidth())) {
                if (aVar.aaS == null) {
                    aVar.aaS = new ArrayList();
                    aVar.aaT = new ArrayList();
                } else {
                    aVar.aaS.clear();
                    aVar.aaT.clear();
                }
                a.hk();
                int round = Math.round(aVar.aaK + aVar.aaI) + 0;
                int round2 = Math.round(aVar.aaL + aVar.aaJ) + 0;
                int width = (tVar.VU.getWidth() + round) + 0;
                int height = (tVar.VU.getHeight() + round2) + 0;
                int i3 = (round + width) / 2;
                int i4 = (round2 + height) / 2;
                h hVar = aVar.Va.TV;
                int childCount = hVar.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = hVar.getChildAt(i5);
                    if (childAt != tVar.VU && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                        t aP = aVar.Va.aP(childAt);
                        a.hh();
                        int abs = Math.abs(i3 - ((childAt.getLeft() + childAt.getRight()) / 2));
                        int abs2 = Math.abs(i4 - ((childAt.getBottom() + childAt.getTop()) / 2));
                        int i6 = (abs * abs) + (abs2 * abs2);
                        int size = aVar.aaS.size();
                        int i7 = 0;
                        abs = 0;
                        while (abs < size && i6 > ((Integer) aVar.aaT.get(abs)).intValue()) {
                            i7++;
                            abs++;
                        }
                        aVar.aaS.add(i7, aP);
                        aVar.aaT.add(i7, Integer.valueOf(i6));
                    }
                }
                List list = aVar.aaS;
                if (list.size() != 0) {
                    t a = a.a(tVar, list, i, i2);
                    if (a == null) {
                        aVar.aaS.clear();
                        aVar.aaT.clear();
                        return;
                    }
                    a.ge();
                    tVar.ge();
                    aVar.aaM.a(tVar, a);
                }
            }
        }
    }

    static /* synthetic */ void a(a aVar, MotionEvent motionEvent, int i, int i2) {
        float d = o.d(motionEvent, i2);
        float e = o.e(motionEvent, i2);
        aVar.aaI = d - aVar.aaE;
        aVar.aaJ = e - aVar.aaF;
        if ((i & 4) == 0) {
            aVar.aaI = Math.max(0.0f, aVar.aaI);
        }
        if ((i & 8) == 0) {
            aVar.aaI = Math.min(0.0f, aVar.aaI);
        }
        if ((i & 1) == 0) {
            aVar.aaJ = Math.max(0.0f, aVar.aaJ);
        }
        if ((i & 2) == 0) {
            aVar.aaJ = Math.min(0.0f, aVar.aaJ);
        }
    }

    static /* synthetic */ boolean a(a aVar, int i, MotionEvent motionEvent, int i2) {
        t tVar = null;
        if (aVar.aaD != null || i != 2 || aVar.aaN == 2 || !aVar.aaM.hj() || aVar.Va.yi == 1) {
            return false;
        }
        float d;
        h hVar = aVar.Va.TV;
        if (aVar.fu != -1) {
            int b = o.b(motionEvent, aVar.fu);
            d = o.d(motionEvent, b) - aVar.aaE;
            float e = o.e(motionEvent, b) - aVar.aaF;
            d = Math.abs(d);
            e = Math.abs(e);
            if ((d >= ((float) aVar.aaQ) || e >= ((float) aVar.aaQ)) && ((d <= e || !hVar.eQ()) && (e <= d || !hVar.eR()))) {
                View p = aVar.p(motionEvent);
                if (p != null) {
                    tVar = aVar.Va.aP(p);
                }
            }
        }
        if (tVar == null) {
            return false;
        }
        int B = (aVar.aaM.B(aVar.Va) & 65280) >> 8;
        if (B == 0) {
            return false;
        }
        e = o.d(motionEvent, i2);
        e -= aVar.aaE;
        d = o.e(motionEvent, i2) - aVar.aaF;
        float abs = Math.abs(e);
        float abs2 = Math.abs(d);
        if (abs < ((float) aVar.aaQ) && abs2 < ((float) aVar.aaQ)) {
            return false;
        }
        if (abs > abs2) {
            if (e < 0.0f && (B & 4) == 0) {
                return false;
            }
            if (e > 0.0f && (B & 8) == 0) {
                return false;
            }
        } else if (d < 0.0f && (B & 1) == 0) {
            return false;
        } else {
            if (d > 0.0f && (B & 2) == 0) {
                return false;
            }
        }
        aVar.aaJ = 0.0f;
        aVar.aaI = 0.0f;
        aVar.fu = o.c(motionEvent, 0);
        aVar.d(tVar, 1);
        return true;
    }

    public a(a aVar) {
        this.aaM = aVar;
    }

    private static boolean a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    public final void A(RecyclerView recyclerView) {
        if (this.Va != recyclerView) {
            RecyclerView recyclerView2;
            if (this.Va != null) {
                View view = this.Va;
                if (view.TV != null) {
                    view.TV.w("Cannot remove item decoration during a scroll  or layout");
                }
                view.TX.remove(this);
                if (view.TX.isEmpty()) {
                    view.setWillNotDraw(z.B(view) == 2);
                }
                view.fI();
                view.requestLayout();
                recyclerView2 = this.Va;
                j jVar = this.aaX;
                recyclerView2.TY.remove(jVar);
                if (recyclerView2.TZ == jVar) {
                    recyclerView2.TZ = null;
                }
                recyclerView2 = this.Va;
                if (recyclerView2.Uk != null) {
                    recyclerView2.Uk.remove(this);
                }
                for (int size = this.aaP.size() - 1; size >= 0; size--) {
                    this.aaM.c(this.Va, ((c) this.aaP.get(0)).Vh);
                }
                this.aaP.clear();
                this.aaU = null;
                this.aaV = -1;
                hf();
            }
            this.Va = recyclerView;
            if (this.Va != null) {
                Resources resources = recyclerView.getResources();
                this.aaG = resources.getDimension(android.support.v7.d.a.a.Jq);
                this.aaH = resources.getDimension(android.support.v7.d.a.a.Jp);
                this.aaQ = ViewConfiguration.get(this.Va.getContext()).getScaledTouchSlop();
                this.Va.a(this);
                this.Va.TY.add(this.aaX);
                recyclerView2 = this.Va;
                if (recyclerView2.Uk == null) {
                    recyclerView2.Uk = new ArrayList();
                }
                recyclerView2.Uk.add(this);
                if (this.aaW == null) {
                    this.aaW = new e(this.Va.getContext(), new b(this, (byte) 0));
                }
            }
        }
    }

    private void c(float[] fArr) {
        if ((this.aaO & 12) != 0) {
            fArr[0] = (this.aaK + this.aaI) - ((float) this.aaD.VU.getLeft());
        } else {
            fArr[0] = z.Q(this.aaD.VU);
        }
        if ((this.aaO & 3) != 0) {
            fArr[1] = (this.aaL + this.aaJ) - ((float) this.aaD.VU.getTop());
        } else {
            fArr[1] = z.R(this.aaD.VU);
        }
    }

    public final void a(Canvas canvas, RecyclerView recyclerView) {
        float f;
        float f2 = 0.0f;
        if (this.aaD != null) {
            c(this.aaC);
            f = this.aaC[0];
            f2 = this.aaC[1];
        } else {
            f = 0.0f;
        }
        a.a(this.aaM, canvas, recyclerView, this.aaD, this.aaP, this.aaN, f, f2);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView$q recyclerView$q) {
        float f;
        float f2 = 0.0f;
        this.aaV = -1;
        if (this.aaD != null) {
            c(this.aaC);
            f = this.aaC[0];
            f2 = this.aaC[1];
        } else {
            f = 0.0f;
        }
        a.b(this.aaM, canvas, recyclerView, this.aaD, this.aaP, this.aaN, f, f2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void d(t tVar, int i) {
        if (tVar != this.aaD || i != this.aaN) {
            this.aaY = Long.MIN_VALUE;
            int i2 = this.aaN;
            a(tVar, true);
            this.aaN = i;
            if (i == 2) {
                this.aaU = tVar.VU;
                if (VERSION.SDK_INT < 21) {
                    if (this.UJ == null) {
                        this.UJ = new 5(this);
                    }
                    this.Va.a(this.UJ);
                }
            }
            int i3 = (1 << ((i * 8) + 8)) - 1;
            Object obj = null;
            if (this.aaD != null) {
                t tVar2 = this.aaD;
                if (tVar2.VU.getParent() != null) {
                    int bQ;
                    float f;
                    float signum;
                    int i4;
                    c 3;
                    if (!(i2 == 2 || this.aaN == 2)) {
                        int am = (a.am(this.aaM.hg(), z.I(this.Va)) & 65280) >> 8;
                        if (am != 0) {
                            if (Math.abs(this.aaI) > Math.abs(this.aaJ)) {
                                bQ = bQ(am);
                                if (bQ <= 0) {
                                    bQ = bR(am);
                                } else if ((bQ & 0) == 0) {
                                    bQ = a.al(bQ, z.I(this.Va));
                                }
                                hf();
                                switch (bQ) {
                                    case 1:
                                    case 2:
                                        f = 0.0f;
                                        signum = Math.signum(this.aaJ) * ((float) this.Va.getHeight());
                                        break;
                                    case 4:
                                    case 8:
                                    case 16:
                                    case 32:
                                        signum = 0.0f;
                                        f = Math.signum(this.aaI) * ((float) this.Va.getWidth());
                                        break;
                                    default:
                                        f = 0.0f;
                                        signum = 0.0f;
                                        break;
                                }
                                if (i2 != 2) {
                                    i4 = 8;
                                } else if (bQ > 0) {
                                    i4 = 2;
                                } else {
                                    i4 = 4;
                                }
                                c(this.aaC);
                                3 = new 3(this, tVar2, i4, i2, this.aaC[0], this.aaC[1], f, signum, bQ, tVar2);
                                3.abl.setDuration(a.f(this.Va, i4));
                                this.aaP.add(3);
                                3.Vh.T(false);
                                3.abl.start();
                                obj = 1;
                            } else {
                                bQ = bR(am);
                                if (bQ <= 0) {
                                    bQ = bQ(am);
                                    if (bQ > 0) {
                                        if ((bQ & 0) == 0) {
                                            bQ = a.al(bQ, z.I(this.Va));
                                        }
                                    }
                                }
                                hf();
                                switch (bQ) {
                                    case 1:
                                    case 2:
                                        f = 0.0f;
                                        signum = Math.signum(this.aaJ) * ((float) this.Va.getHeight());
                                        break;
                                    case 4:
                                    case 8:
                                    case 16:
                                    case 32:
                                        signum = 0.0f;
                                        f = Math.signum(this.aaI) * ((float) this.Va.getWidth());
                                        break;
                                    default:
                                        f = 0.0f;
                                        signum = 0.0f;
                                        break;
                                }
                                if (i2 != 2) {
                                    i4 = 8;
                                } else if (bQ > 0) {
                                    i4 = 4;
                                } else {
                                    i4 = 2;
                                }
                                c(this.aaC);
                                3 = new 3(this, tVar2, i4, i2, this.aaC[0], this.aaC[1], f, signum, bQ, tVar2);
                                3.abl.setDuration(a.f(this.Va, i4));
                                this.aaP.add(3);
                                3.Vh.T(false);
                                3.abl.start();
                                obj = 1;
                            }
                        }
                    }
                    bQ = 0;
                    hf();
                    switch (bQ) {
                        case 1:
                        case 2:
                            f = 0.0f;
                            signum = Math.signum(this.aaJ) * ((float) this.Va.getHeight());
                            break;
                        case 4:
                        case 8:
                        case 16:
                        case 32:
                            signum = 0.0f;
                            f = Math.signum(this.aaI) * ((float) this.Va.getWidth());
                            break;
                        default:
                            f = 0.0f;
                            signum = 0.0f;
                            break;
                    }
                    if (i2 != 2) {
                        i4 = 8;
                    } else if (bQ > 0) {
                        i4 = 2;
                    } else {
                        i4 = 4;
                    }
                    c(this.aaC);
                    3 = new 3(this, tVar2, i4, i2, this.aaC[0], this.aaC[1], f, signum, bQ, tVar2);
                    3.abl.setDuration(a.f(this.Va, i4));
                    this.aaP.add(3);
                    3.Vh.T(false);
                    3.abl.start();
                    obj = 1;
                } else {
                    bx(tVar2.VU);
                    this.aaM.c(this.Va, tVar2);
                }
                this.aaD = null;
            }
            Object obj2 = obj;
            if (tVar != null) {
                this.aaO = (this.aaM.B(this.Va) & i3) >> (this.aaN * 8);
                this.aaK = (float) tVar.VU.getLeft();
                this.aaL = (float) tVar.VU.getTop();
                this.aaD = tVar;
                if (i == 2) {
                    this.aaD.VU.performHapticFeedback(0);
                }
            }
            ViewParent parent = this.Va.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.aaD != null);
            }
            if (obj2 == null) {
                this.Va.TV.Vc = true;
            }
            this.aaM.e(this.aaD, this.aaN);
            this.Va.invalidate();
        }
    }

    public final void bl(View view) {
        bx(view);
        t aP = this.Va.aP(view);
        if (aP != null) {
            if (this.aaD == null || aP != this.aaD) {
                a(aP, false);
                if (this.aaB.remove(aP.VU)) {
                    this.aaM.c(this.Va, aP);
                    return;
                }
                return;
            }
            d(null, 0);
        }
    }

    final int a(t tVar, boolean z) {
        for (int size = this.aaP.size() - 1; size >= 0; size--) {
            c cVar = (c) this.aaP.get(size);
            if (cVar.Vh == tVar) {
                cVar.abq |= z;
                if (!cVar.oP) {
                    cVar.abl.cancel();
                }
                this.aaP.remove(size);
                return cVar.abm;
            }
        }
        return 0;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView$q recyclerView$q) {
        rect.setEmpty();
    }

    private void hf() {
        if (this.ft != null) {
            this.ft.recycle();
            this.ft = null;
        }
    }

    final View p(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.aaD != null) {
            View view = this.aaD.VU;
            if (a(view, x, y, this.aaK + this.aaI, this.aaL + this.aaJ)) {
                return view;
            }
        }
        for (int size = this.aaP.size() - 1; size >= 0; size--) {
            c cVar = (c) this.aaP.get(size);
            View view2 = cVar.Vh.VU;
            if (a(view2, x, y, cVar.abo, cVar.abp)) {
                return view2;
            }
        }
        return this.Va.j(x, y);
    }

    private int bQ(int i) {
        int i2 = 8;
        if ((i & 12) != 0) {
            int i3 = this.aaI > 0.0f ? 8 : 4;
            if (this.ft != null && this.fu >= 0) {
                this.ft.computeCurrentVelocity(1000, a.J(this.aaH));
                float a = y.a(this.ft, this.fu);
                float b = y.b(this.ft, this.fu);
                if (a <= 0.0f) {
                    i2 = 4;
                }
                float abs = Math.abs(a);
                if ((i2 & i) != 0 && i3 == i2 && abs >= a.I(this.aaG) && abs > Math.abs(b)) {
                    return i2;
                }
            }
            float width = ((float) this.Va.getWidth()) * a.hl();
            if ((i & i3) != 0 && Math.abs(this.aaI) > width) {
                return i3;
            }
        }
        return 0;
    }

    private int bR(int i) {
        int i2 = 2;
        if ((i & 3) != 0) {
            int i3 = this.aaJ > 0.0f ? 2 : 1;
            if (this.ft != null && this.fu >= 0) {
                this.ft.computeCurrentVelocity(1000, a.J(this.aaH));
                float a = y.a(this.ft, this.fu);
                float b = y.b(this.ft, this.fu);
                if (b <= 0.0f) {
                    i2 = 1;
                }
                float abs = Math.abs(b);
                if ((i2 & i) != 0 && i2 == i3 && abs >= a.I(this.aaG) && abs > Math.abs(a)) {
                    return i2;
                }
            }
            float height = ((float) this.Va.getHeight()) * a.hl();
            if ((i & i3) != 0 && Math.abs(this.aaJ) > height) {
                return i3;
            }
        }
        return 0;
    }

    final void bx(View view) {
        if (view == this.aaU) {
            this.aaU = null;
            if (this.UJ != null) {
                this.Va.a(null);
            }
        }
    }
}
