package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonRow extends LinearLayout {
    private ImageView ijr;
    private TextView ijs;
    private TextView ijt;
    private WalletFormView iju;
    private TextView ijv;

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        inflate(getContext(), g.uCf, this);
        this.ijr = (ImageView) findViewById(f.udZ);
        this.ijs = (TextView) findViewById(f.uek);
        this.iju = (WalletFormView) findViewById(f.ulz);
        this.ijt = (TextView) findViewById(f.ulA);
        this.ijv = (TextView) findViewById(f.urL);
    }
}
