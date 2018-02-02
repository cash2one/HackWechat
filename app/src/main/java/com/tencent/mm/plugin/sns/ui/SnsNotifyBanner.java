package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.f;

public class SnsNotifyBanner extends RelativeLayout {
    private LayoutInflater DF;
    private View Iv;
    private TextView rEs;
    private ImageView rEt;
    int rEu = 0;

    public SnsNotifyBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SnsNotifyBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.DF = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.Iv = this.DF.inflate(i$g.qHF, this, true);
        this.rEs = (TextView) this.Iv.findViewById(f.qEe);
        this.rEt = (ImageView) this.Iv.findViewById(f.qEd);
        this.rEt.setOnClickListener(new 1(this));
    }
}
