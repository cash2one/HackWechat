package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public class BannerActView extends LinearLayout {
    private List<a> ola;
    private TextView olb = ((TextView) LayoutInflater.from(getContext()).inflate(g.uBn, this, true).findViewById(f.upP));

    public BannerActView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnClickListener(new 1(this));
    }
}
