package com.tencent.mm.plugin.appbrand.page;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.n;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.o;
import com.tencent.mm.plugin.appbrand.page.z.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.z.u.b;
import java.util.LinkedList;
import java.util.List;

public class u {
    c jEb;
    private ViewGroup jFk;
    List<b> jFl;
    int jFm = -1;
    float[] jFn;
    View jFo;
    y jFp;
    int jFq = -1;
    af mHandler;

    public u(ViewGroup viewGroup) {
        this.jFk = viewGroup;
        this.mHandler = new af(Looper.getMainLooper());
        this.jFl = new LinkedList();
        this.jFo = new View(viewGroup.getContext());
    }

    public final void a(c cVar) {
        this.jEb = cVar;
        this.jEb.a(new 1(this));
    }

    public final boolean a(View view, int i, int i2, float[] fArr, int i3, boolean z) {
        bc 2 = new 2(this, Boolean.valueOf(false), view, i, i2, fArr, i3, z);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) 2.b(null)).booleanValue();
        }
        return ((Boolean) 2.b(this.mHandler)).booleanValue();
    }

    final boolean b(View view, int i, int i2, float[] fArr, int i3, boolean z) {
        if (view == null || fArr == null || fArr.length < 5) {
            return false;
        }
        ViewGroup lj = lj(i2);
        if (lj == null) {
            return false;
        }
        if (lo(i) != null) {
            return false;
        }
        int i4;
        float f;
        float f2;
        float f3 = fArr[0];
        float f4 = fArr[1];
        int i5 = (int) fArr[4];
        LayoutParams layoutParams = new LayoutParams((int) fArr[2], (int) fArr[3]);
        int bK = bK(i2, i5);
        if (bK < 0) {
            i4 = 0;
        } else {
            i4 = bK;
        }
        if (lj instanceof n) {
            bK = ((n) lj).agi();
        } else {
            bK = lj.getChildCount();
        }
        if (i4 > bK) {
            i4 = bK;
        }
        if (i3 >= 0) {
            view.setVisibility(i3 == 0 ? 0 : 4);
        }
        lj.addView(view, i4, layoutParams);
        b bVar = new b(view, i, i2, i5, z);
        this.jFl.add(bVar);
        if (i2 == 0 && (lj instanceof z) && z) {
            Object aVar = new a((byte) 0);
            aVar.view = view;
            aVar.x = f3;
            aVar.y = f4;
            aVar.jFy = (float) this.jFk.getScrollX();
            aVar.jFz = (float) this.jFk.getScrollY();
            float f5 = f3 + aVar.jFy;
            f = aVar.jFz + f4;
            ((z) lj).a(aVar);
            bVar.jFD = aVar;
            f2 = f;
            f = f5;
        } else {
            f2 = f4;
            f = f3;
        }
        view.setX(f);
        view.setY(f2);
        return true;
    }

    final ViewGroup lj(int i) {
        if (i == 0) {
            return this.jFk;
        }
        b lm = lm(i);
        if (lm == null) {
            return null;
        }
        View view = (View) lm.jFA.get();
        return ((view instanceof o) && (view instanceof ViewGroup)) ? (ViewGroup) view : null;
    }

    public final boolean lk(int i) {
        bc 3 = new 3(this, Boolean.valueOf(false), i);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) 3.b(null)).booleanValue();
        }
        return ((Boolean) 3.b(this.mHandler)).booleanValue();
    }

    final boolean ll(int i) {
        b lm = lm(i);
        if (lm == null) {
            return false;
        }
        ls(i);
        a(lm);
        ViewGroup lj = lj(lm.jFB);
        if (lj == null) {
            return false;
        }
        this.jFl.remove(lm);
        lj.removeView((View) lm.jFA.get());
        if (lm.jFB == 0 && (lj instanceof z) && lm.jFC) {
            ((z) lj).b(lm.jFD);
        }
        return true;
    }

    public final boolean a(int i, float[] fArr, int i2, Boolean bool) {
        bc 5 = new 5(this, Boolean.valueOf(false), i, fArr, i2, bool);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) 5.b(null)).booleanValue();
        }
        return ((Boolean) 5.b(this.mHandler)).booleanValue();
    }

    final boolean b(int i, float[] fArr, int i2, Boolean bool) {
        if (lq(i)) {
            return true;
        }
        b lm = lm(i);
        if (lm == null) {
            return false;
        }
        View view = (View) lm.jFA.get();
        ViewGroup lj = lj(lm.jFB);
        if (lj == null) {
            return false;
        }
        if (i2 >= 0) {
            view.setVisibility(i2 == 0 ? 0 : 4);
        }
        if (fArr == null || fArr.length < 5) {
            return true;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int i3 = (int) fArr[4];
        boolean booleanValue = bool != null ? bool.booleanValue() : lm.jFC;
        if (lm.z != i3) {
            this.jFl.remove(lm);
            lj.removeView(view);
            if (b(view, i, lm.jFB, fArr, i2, booleanValue)) {
                return true;
            }
            a(lm);
            return false;
        }
        a aVar;
        float f5;
        float f6;
        LayoutParams layoutParams;
        a aVar2 = lm.jFD;
        if (lm.jFB == 0 && (lj instanceof z) && booleanValue != lm.jFC) {
            if (booleanValue) {
                if (aVar2 == null) {
                    aVar = new a((byte) 0);
                    aVar.view = view;
                    lm.jFD = aVar;
                    aVar2 = aVar;
                }
                ((z) lj).a(aVar2);
                aVar = aVar2;
                if (aVar == null) {
                    aVar.x = f;
                    aVar.y = f2;
                    aVar.jFy = (float) this.jFk.getScrollX();
                    aVar.jFz = (float) this.jFk.getScrollY();
                    f5 = aVar.jFy + f;
                    f6 = aVar.jFz + f2;
                } else {
                    f6 = f2;
                    f5 = f;
                }
                layoutParams = view.getLayoutParams();
                layoutParams.width = (int) f3;
                layoutParams.height = (int) f4;
                view.setX(f5);
                view.setY(f6);
                view.requestLayout();
                i3 = lj.indexOfChild(this.jFo);
                if (lj.indexOfChild(view) == -1 && i3 != -1) {
                    lj.addView(view, i3);
                    lj.removeView(this.jFo);
                }
                return true;
            }
            ((z) lj).b(lm.jFD);
        }
        a aVar3 = aVar2;
        if (aVar == null) {
            f6 = f2;
            f5 = f;
        } else {
            aVar.x = f;
            aVar.y = f2;
            aVar.jFy = (float) this.jFk.getScrollX();
            aVar.jFz = (float) this.jFk.getScrollY();
            f5 = aVar.jFy + f;
            f6 = aVar.jFz + f2;
        }
        layoutParams = view.getLayoutParams();
        layoutParams.width = (int) f3;
        layoutParams.height = (int) f4;
        view.setX(f5);
        view.setY(f6);
        view.requestLayout();
        i3 = lj.indexOfChild(this.jFo);
        lj.addView(view, i3);
        lj.removeView(this.jFo);
        return true;
    }

    private void a(b bVar) {
        this.jFl.removeAll(b(bVar));
    }

    private List<b> b(b bVar) {
        List<b> linkedList = new LinkedList();
        for (b bVar2 : this.jFl) {
            if (bVar2.jFB == bVar.id) {
                linkedList.addAll(b(bVar2));
            }
        }
        linkedList.add(bVar);
        return linkedList;
    }

    private int bK(int i, int i2) {
        int i3 = 0;
        for (b bVar : this.jFl) {
            int i4;
            if (i != bVar.jFB || i2 < bVar.z) {
                i4 = i3;
            } else {
                i4 = i3 + 1;
            }
            i3 = i4;
        }
        return i3;
    }

    public final b lm(int i) {
        for (b bVar : this.jFl) {
            if (bVar.id == i) {
                return bVar;
            }
        }
        return null;
    }

    public final boolean ln(int i) {
        return lm(i) != null;
    }

    public final View lo(int i) {
        b lm = lm(i);
        return lm == null ? null : (View) lm.jFA.get();
    }

    public final b lp(int i) {
        return com.tencent.mm.z.u.GK().hy(hashCode() + "#" + i);
    }

    public final b y(int i, boolean z) {
        return com.tencent.mm.z.u.GK().t(hashCode() + "#" + i, z);
    }

    public final boolean lq(int i) {
        return this.jFq == i || this.jFm == i;
    }

    public final boolean a(int i, y yVar, int i2) {
        bc 6 = new 6(this, Boolean.valueOf(false), i, yVar, i2);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) 6.b(null)).booleanValue();
        }
        return ((Boolean) 6.b(this.mHandler)).booleanValue();
    }

    public final boolean lr(int i) {
        bc 7 = new 7(this, Boolean.valueOf(false), i);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) 7.b(null)).booleanValue();
        }
        return ((Boolean) 7.b(this.mHandler)).booleanValue();
    }

    final boolean ls(int i) {
        if (i != this.jFm || lm(i) == null) {
            return false;
        }
        this.jEb.aiK();
        return true;
    }
}
