package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.ArrayList;

public class WalletPayUOpenIntroView extends LinearLayout {
    ArrayList<View> Yo;
    Context mContext;
    MMAutoHeightViewPager tcd;
    MMPageControlView tce;
    a tcf;
    d[] tcg;

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(g.uDs, this, true);
        this.tcd = (MMAutoHeightViewPager) inflate.findViewById(a$f.cCl);
        this.tce = (MMPageControlView) inflate.findViewById(a$f.uiZ);
        this.tce.setVisibility(0);
        this.tcd.zo = new 1(this);
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }
}
