package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class AppBrandSmileyPanelBase extends LinearLayout implements e, b {
    public View Iv = null;
    private boolean jYL = false;
    public c kaL;
    public a kaX;
    public MMActivity kaY;
    private AppBrandSmileyViewPager kaZ = null;
    private MMDotView kba;
    private boolean kbb = true;

    public interface a {
        void amZ();

        void append(String str);
    }

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        a anz = this.kaL.anz();
        int pageCount = anz.getPageCount();
        int i2 = i - anz.kaM;
        if (pageCount <= 1) {
            this.kba.setVisibility(4);
            return;
        }
        this.kba.setVisibility(0);
        this.kba.EH(pageCount);
        this.kba.EI(i2);
    }

    public final void af(int i) {
    }

    public final void anw() {
        if (this.kaZ != null) {
            this.kaL.kbb = j.aS(getContext());
            com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.a aVar = (com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.a) this.kaZ.yE;
            if (aVar != null) {
                aVar.kbl.clear();
                aVar.kaL = this.kaL;
                aVar.notifyDataSetChanged();
            } else {
                u aVar2 = new com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.a();
                aVar2.kaL = this.kaL;
                this.kaZ.a(aVar2);
            }
            this.kaZ.post(new Runnable(this) {
                final /* synthetic */ AppBrandSmileyPanelBase kbc;

                {
                    this.kbc = r1;
                }

                public final void run() {
                    this.kbc.ae(this.kbc.kaZ.yF);
                }
            });
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        any();
    }

    public void onMeasure(int i, int i2) {
        if (this.jYL) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
            return;
        }
        j.aS(getContext());
        super.onMeasure(i, i2);
    }

    @SuppressLint({"WrongCall"})
    public final void bV(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public AppBrandSmileyPanelBase(Context context) {
        super(context, null);
        init();
    }

    public AppBrandSmileyPanelBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void anx() {
        if (this.Iv != null) {
            this.Iv.setVisibility(4);
        }
    }

    private void init() {
        this.kaY = (MMActivity) getContext();
        this.kaL = amR();
        this.kaL.kaK = getContext();
        this.kaL.kbe = this.kaX;
    }

    public c amR() {
        return new c();
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.jYL = false;
        } else {
            this.jYL = true;
        }
        super.setVisibility(i);
        if (!this.jYL) {
            this.kaY.aWs();
            initView();
        }
    }

    public final void mb(int i) {
        super.setVisibility(i);
    }

    public final void initView() {
        if (this.Iv == null || getChildCount() <= 0) {
            if (this.Iv == null) {
                this.Iv = View.inflate(ac.getContext(), h.ixE, null);
            } else if (this.Iv.getParent() != null) {
                ((ViewGroup) this.Iv.getParent()).removeView(this.Iv);
            }
            this.kaZ = (AppBrandSmileyViewPager) this.Iv.findViewById(g.cOP);
            this.kaZ.b(this);
            this.kaZ.kaL = this.kaL;
            this.kaZ.kbk = this;
            this.kba = (MMDotView) this.Iv.findViewById(g.cOO);
            this.kba.EH(1);
            any();
            addView(this.Iv, new LayoutParams(-1, -1));
            return;
        }
        this.Iv.setVisibility(0);
    }

    private void any() {
        if (this.kba != null) {
            boolean aS = j.aS(getContext());
            if (aS != this.kbb) {
                RelativeLayout.LayoutParams layoutParams;
                if (aS) {
                    this.kba.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(q.e.bvB));
                    layoutParams = (RelativeLayout.LayoutParams) this.kba.getLayoutParams();
                    layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(q.e.bxh);
                    this.kba.setLayoutParams(layoutParams);
                } else {
                    this.kba.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(q.e.bvz));
                    layoutParams = (RelativeLayout.LayoutParams) this.kba.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    this.kba.setLayoutParams(layoutParams);
                }
                this.kbb = aS;
            }
        }
    }
}
