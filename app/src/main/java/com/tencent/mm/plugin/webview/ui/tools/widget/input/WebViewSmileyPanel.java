package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.support.v4.view.ViewPager$e;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel extends LinearLayout implements ViewPager$e, a {
    View Iv = null;
    private boolean jYL = false;
    MMActivity kaY;
    private MMDotView kba;
    private boolean kbb = true;
    c tLf;
    a tLi;
    private WebViewSmileyViewPager tLj = null;

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        a bUW = this.tLf.bUW();
        int pageCount = bUW.getPageCount();
        int i2 = i - bUW.kaM;
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
        if (this.tLj != null) {
            this.tLf.kbb = j.aS(getContext());
            b bVar = (b) this.tLj.yE;
            if (bVar != null) {
                bVar.kbl.clear();
                bVar.tLf = this.tLf;
                bVar.notifyDataSetChanged();
            } else {
                u bVar2 = new b();
                bVar2.tLf = this.tLf;
                this.tLj.a(bVar2);
            }
            this.tLj.post(new 1(this));
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        any();
    }

    protected void onMeasure(int i, int i2) {
        if (this.jYL) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
            return;
        }
        j.aS(getContext());
        super.onMeasure(i, i2);
    }

    public WebViewSmileyPanel(Context context) {
        super(context, null);
        init();
    }

    public WebViewSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.kaY = (MMActivity) getContext();
        this.tLf = new c();
        this.tLf.kaK = getContext();
        this.tLf.tLm = this.tLi;
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
            if (this.Iv == null || getChildCount() <= 0) {
                if (this.Iv == null) {
                    this.Iv = View.inflate(ac.getContext(), R.i.dug, null);
                } else if (this.Iv.getParent() != null) {
                    ((ViewGroup) this.Iv.getParent()).removeView(this.Iv);
                }
                this.tLj = (WebViewSmileyViewPager) this.Iv.findViewById(R.h.cOP);
                this.tLj.b(this);
                this.tLj.tLf = this.tLf;
                this.tLj.tLo = this;
                this.kba = (MMDotView) this.Iv.findViewById(R.h.cOO);
                this.kba.EH(1);
                any();
                addView(this.Iv, new LayoutParams(-1, -1));
                return;
            }
            this.Iv.setVisibility(0);
        }
    }

    private void any() {
        if (this.kba != null) {
            boolean aS = j.aS(getContext());
            if (aS != this.kbb) {
                RelativeLayout.LayoutParams layoutParams;
                if (aS) {
                    this.kba.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.f.bvB));
                    layoutParams = (RelativeLayout.LayoutParams) this.kba.getLayoutParams();
                    layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.f.bxh);
                    this.kba.setLayoutParams(layoutParams);
                } else {
                    this.kba.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.f.bvz));
                    layoutParams = (RelativeLayout.LayoutParams) this.kba.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    this.kba.setLayoutParams(layoutParams);
                }
                this.kbb = aS;
            }
        }
    }
}
