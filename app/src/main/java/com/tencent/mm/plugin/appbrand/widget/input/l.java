package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.z;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.d.a;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class l extends FrameLayout {
    private static final int jau = g.iuT;
    public View jXB;
    private View jXC;
    int jXD = -1;
    private final int[] jXE = new int[2];
    public a jXF;
    private WeakHashMap<View, b> jXG = new WeakHashMap();
    private Runnable jXH = new 1(this);
    private final Runnable jXI = new 2(this);
    public final Set<a> jXJ = new HashSet();

    static /* synthetic */ void bU(View view) {
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static l bS(View view) {
        return (l) view.getRootView().findViewById(jau);
    }

    public static l k(Activity activity) {
        return (l) activity.findViewById(jau);
    }

    public l(Context context, View view) {
        super(context);
        super.setId(jau);
        this.jXC = view;
        super.addView(view);
    }

    protected final void onMeasure(int i, int i2) {
        if (this.jXD > 0) {
            i2 = MeasureSpec.makeMeasureSpec(this.jXD, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            if (this.jXB == null || !this.jXB.isShown()) {
                Activity cg = j.cg(getContext());
                if (MMActivity.class.isInstance(cg) && ((MMActivity) cg).mController.hideVKB()) {
                    return true;
                }
            }
            this.jXB.setVisibility(8);
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        b bVar = (b) this.jXG.get(this.jXB);
        if (bVar != null && bVar.jXL && this.jXB != null && this.jXB.isShown() && motionEvent.getAction() == 0) {
            float rawY = motionEvent.getRawY();
            this.jXB.getLocationOnScreen(this.jXE);
            float f = (float) this.jXE[1];
            float height = ((float) this.jXB.getHeight()) + f;
            if (rawY < f || rawY > height) {
                this.jXB.setVisibility(8);
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void setId(int i) {
    }

    public final void addView(View view) {
        if (view == this.jXC || view == this.jXB) {
            super.addView(view);
        }
    }

    public final void addView(View view, int i) {
        if (view == this.jXC || view == this.jXB) {
            super.addView(view, i);
        }
    }

    public final void addView(View view, int i, int i2) {
        if (view == this.jXC || view == this.jXB) {
            super.addView(view, i, i2);
        }
    }

    public final void addView(View view, LayoutParams layoutParams) {
        if (view == this.jXC || view == this.jXB) {
            super.addView(view, layoutParams);
        }
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        if (view == this.jXC || view == this.jXB) {
            super.addView(view, i, layoutParams);
        }
    }

    protected final boolean addViewInLayout(View view, int i, LayoutParams layoutParams) {
        return false;
    }

    protected final boolean addViewInLayout(View view, int i, LayoutParams layoutParams, boolean z) {
        return false;
    }

    public final void g(View view, boolean z) {
        if (this.jXB != null) {
            this.jXB.setVisibility(8);
            this.jXB = null;
        }
        if (this != view.getParent()) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.jXB = view;
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            super.addView(view, layoutParams);
            b bVar = new b((byte) 0);
            bVar.jXL = z;
            this.jXG.put(view, bVar);
        }
    }

    public final void bT(View view) {
        g(view, false);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z.ai(this)) {
            Object obj = null;
            int i5 = 1;
            int i6 = 0;
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt = getChildAt(i7);
                if (!(childAt == null || childAt == this.jXC)) {
                    b bVar = (b) this.jXG.get(childAt);
                    if (bVar != null) {
                        if (obj == null && bVar.jXM != 0 && childAt.getVisibility() == 0) {
                            this.jXB = childAt;
                            post(this.jXH);
                            obj = 1;
                        }
                        int i8 = (bVar.jXM == 0 ? 1 : 0) | i6;
                        i5 &= childAt.getVisibility() != 0 ? 1 : 0;
                        bVar.jXM = childAt.getVisibility();
                        i6 = i8;
                    }
                }
            }
            if (!(obj == null && (i6 == 0 || i5 == 0))) {
                post(this.jXI);
            }
        }
        super.onLayout(z, i, i2, i3, i4);
        if (this.jXF != null) {
            this.jXF.bV(this);
        }
    }

    public final void a(a aVar) {
        if (aVar != null && this.jXJ.contains(aVar)) {
            this.jXJ.remove(aVar);
        }
    }
}
