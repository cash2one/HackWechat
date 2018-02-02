package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.q$f;
import com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.a;

public final class AppBrandMultiOptionsPicker extends FrameLayout implements e<int[]> {
    private boolean Ue;
    private boolean Uf;
    private final Drawable kdb;
    public LinearLayout kdc;
    private d kdd;
    public final a kde = new 1(this);

    public final /* synthetic */ Object anJ() {
        int i = 0;
        int anK = anK();
        if (anK <= 0) {
            return new int[0];
        }
        Object obj = new int[anK];
        while (i < anK) {
            obj[i] = ml(i).getValue();
            i++;
        }
        return obj;
    }

    @Keep
    public AppBrandMultiOptionsPicker(Context context) {
        super(context);
        this.kdb = context.getResources().getDrawable(q$f.ite);
        this.kdc = new LinearLayout(context);
        this.kdc.setPadding(com.tencent.mm.bv.a.fromDPToPix(context, 2), 0, com.tencent.mm.bv.a.fromDPToPix(context, 2), 0);
        this.kdc.setOrientation(0);
        addView(this.kdc, new LayoutParams(-1, -1, 17));
        this.kdc.setDividerDrawable(this.kdb);
        this.kdc.setShowDividers(2);
    }

    public final void R(boolean z) {
        if (this.Uf != z) {
            this.Uf = z;
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            } else if (this.Ue) {
                requestLayout();
            }
        }
    }

    public final void requestLayout() {
        if (this.Uf) {
            this.Ue = true;
        } else {
            super.requestLayout();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Uf) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Uf) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final c ml(int i) {
        if (i >= 0 && this.kdc != null) {
            return (c) this.kdc.getChildAt(i);
        }
        return null;
    }

    public final int anK() {
        return this.kdc == null ? 0 : this.kdc.getChildCount();
    }

    public final void mm(int i) {
        if (i > 0) {
            int anK = anK() - 1;
            while (i > 0) {
                this.kdc.removeViewAt(anK);
                anK--;
                i--;
            }
        }
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
        this.kdd = dVar;
    }

    public final void anH() {
        int anK = anK();
        for (int i = 0; i < anK; i++) {
            c ml = ml(i);
            if (ml != null) {
                ml.anV();
            }
        }
    }

    public final void b(d dVar) {
        this.kdd = dVar;
    }

    public final void anI() {
        this.kdd = null;
    }
}
