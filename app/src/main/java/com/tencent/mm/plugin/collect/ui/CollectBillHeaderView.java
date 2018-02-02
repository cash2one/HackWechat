package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class CollectBillHeaderView extends LinearLayout {
    TextView lkn;
    TextView llj;
    WalletTextView llk;
    private TextView lll;

    public CollectBillHeaderView(Context context) {
        super(context);
        init(context);
    }

    public CollectBillHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CollectBillHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = v.fv(context).inflate(g.uBr, this);
        this.llj = (TextView) inflate.findViewById(f.uhZ);
        this.lll = (TextView) inflate.findViewById(f.uhY);
        this.llk = (WalletTextView) inflate.findViewById(f.uib);
        this.lkn = (TextView) inflate.findViewById(f.uia);
    }
}
