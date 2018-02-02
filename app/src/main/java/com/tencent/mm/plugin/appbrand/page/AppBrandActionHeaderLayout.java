package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;

public class AppBrandActionHeaderLayout extends LinearLayout {
    public AppBrandActionMultipleHeaderView jCA;
    public TextView jCB;
    private int jCC = 1;
    private int jCD = 2;
    public LinearLayout jCu;
    public HorizontalScrollView jCv;
    public AppBrandActionSingleHeaderView jCw;
    public AppBrandActionMultipleHeaderView jCx;
    public AppBrandActionMultipleHeaderView jCy;
    public AppBrandActionMultipleHeaderView jCz;
    public String mAppId;
    public Context mContext;

    public AppBrandActionHeaderLayout(Context context) {
        super(context);
        cd(context);
    }

    public AppBrandActionHeaderLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cd(context);
    }

    @TargetApi(11)
    public AppBrandActionHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cd(context);
    }

    private void cd(Context context) {
        this.mContext = context;
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(h.ixy, this);
        this.jCu = (LinearLayout) findViewById(g.iuX);
        this.jCv = (HorizontalScrollView) findViewById(g.iuW);
        this.jCw = (AppBrandActionSingleHeaderView) findViewById(g.ivh);
        this.jCx = (AppBrandActionMultipleHeaderView) findViewById(g.ivb);
        this.jCy = (AppBrandActionMultipleHeaderView) findViewById(g.ivc);
        this.jCz = (AppBrandActionMultipleHeaderView) findViewById(g.ivd);
        this.jCA = (AppBrandActionMultipleHeaderView) findViewById(g.ive);
        this.jCB = (TextView) findViewById(g.iuY);
        this.jCx.setVisibility(8);
        this.jCy.setVisibility(8);
        this.jCz.setVisibility(8);
        this.jCA.setVisibility(8);
        this.jCB.setVisibility(8);
    }

    public final void lb(int i) {
        this.jCB.setText(i);
        this.jCB.setVisibility(0);
        this.jCu.setVisibility(8);
        this.jCv.setVisibility(8);
    }
}
