package com.tencent.mm.plugin.webview.fts.ui;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.tencent.mm.plugin.webview.fts.c.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;
import java.util.List;

public final class b {
    List<a> jFl;
    public int jFm = -1;
    public float[] jFn;
    View jFo;
    public int jFq = -1;
    private MMWebView juE;
    public af mHandler;
    com.tencent.mm.plugin.webview.fts.c.b.b trA;
    public a trz;

    class AnonymousClass3 extends bc<Boolean> {
        final /* synthetic */ int aar;
        final /* synthetic */ float[] jFt;
        final /* synthetic */ int jhi;
        final /* synthetic */ b trB;

        public AnonymousClass3(b bVar, Boolean bool, int i, float[] fArr, int i2) {
            this.trB = bVar;
            this.jhi = i;
            this.jFt = fArr;
            this.aar = i2;
            super(1000, bool);
        }

        protected final /* synthetic */ Object run() {
            return Boolean.valueOf(this.trB.a(this.jhi, this.jFt, this.aar));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public b(MMWebView mMWebView, com.tencent.mm.plugin.webview.fts.c.b.b bVar) {
        this.juE = mMWebView;
        this.mHandler = new af(Looper.getMainLooper());
        this.jFl = new LinkedList();
        this.jFo = new View(mMWebView.getContext());
        this.trA = bVar;
    }

    final boolean a(View view, int i, int i2, float[] fArr, int i3) {
        int i4 = 0;
        if (view == null || fArr == null || fArr.length < 5) {
            return false;
        }
        ViewGroup lj = lj(i2);
        if (lj == null || lo(i) != null) {
            return false;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        int i5 = (int) fArr[4];
        LayoutParams layoutParams = new LayoutParams((int) fArr[2], (int) fArr[3]);
        int bK = bK(i2, i5);
        if (bK < 0) {
            bK = 0;
        }
        if (bK > lj.getChildCount()) {
            bK = lj.getChildCount();
        }
        if (i3 != Integer.MAX_VALUE && i3 >= 0) {
            if (i3 != 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        lj.addView(view, bK, layoutParams);
        view.setX(f);
        view.setY(f2);
        c(view, i, i2, i5);
        return true;
    }

    final ViewGroup lj(int i) {
        if (i == 0) {
            ViewGroup topView = this.juE.getTopView();
            if (topView instanceof AbsoluteLayout) {
                return topView;
            }
            return null;
        }
        a Ag = Ag(i);
        if (Ag == null) {
            return null;
        }
        View view = (View) Ag.jFA.get();
        return view instanceof ViewGroup ? (ViewGroup) view : null;
    }

    public final boolean a(int i, float[] fArr, int i2) {
        if (lq(i)) {
            return true;
        }
        a Ag = Ag(i);
        if (Ag == null) {
            return false;
        }
        View view = (View) Ag.jFA.get();
        ViewGroup lj = lj(Ag.jFB);
        if (lj == null) {
            return false;
        }
        if (i2 >= 0 && i2 != Integer.MAX_VALUE) {
            view.setVisibility(i2 == 0 ? 0 : 8);
        }
        if (fArr == null || fArr.length < 5) {
            return true;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int i3 = (int) fArr[4];
        this.jFl.remove(Ag);
        if (Ag.z != i3) {
            lj.removeView(view);
            if (a(view, i, Ag.jFB, fArr, i2)) {
                return true;
            }
            a(Ag);
            return false;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (f3 != Float.MAX_VALUE) {
            layoutParams.width = (int) f3;
        }
        if (f4 != Float.MAX_VALUE) {
            layoutParams.height = (int) f4;
        }
        if (f != Float.MAX_VALUE) {
            view.setX(f);
        }
        if (f2 != Float.MAX_VALUE) {
            view.setY(f2);
        }
        view.requestLayout();
        c(view, i, Ag.jFB, i3);
        int indexOfChild = lj.indexOfChild(this.jFo);
        if (lj.indexOfChild(view) == -1 && indexOfChild != -1) {
            lj.addView(view, indexOfChild);
            lj.removeView(this.jFo);
        }
        return true;
    }

    final void a(a aVar) {
        this.jFl.removeAll(b(aVar));
    }

    private List<a> b(a aVar) {
        List<a> linkedList = new LinkedList();
        for (a aVar2 : this.jFl) {
            if (aVar2.jFB == aVar.id) {
                linkedList.addAll(b(aVar2));
            }
        }
        linkedList.add(aVar);
        return linkedList;
    }

    private int bK(int i, int i2) {
        int i3 = 0;
        for (a aVar : this.jFl) {
            int i4;
            if (i != aVar.jFB || i2 < aVar.z) {
                i4 = i3;
            } else {
                i4 = i3 + 1;
            }
            i3 = i4;
        }
        return i3;
    }

    public final a Ag(int i) {
        for (a aVar : this.jFl) {
            if (aVar.id == i) {
                return aVar;
            }
        }
        return null;
    }

    public final View lo(int i) {
        a Ag = Ag(i);
        return Ag == null ? null : (View) Ag.jFA.get();
    }

    private void c(View view, int i, int i2, int i3) {
        this.jFl.add(new a(view, i, i2, i3));
    }

    public final boolean lq(int i) {
        return this.jFq == i || this.jFm == i;
    }

    final boolean ls(int i) {
        if (i != this.jFm || Ag(i) == null) {
            return false;
        }
        this.trA.bQx();
        return true;
    }
}
