package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow extends LinearLayout {
    private ImageView ihQ;
    private TextView iiQ;
    private WalletFormView iiR;
    private View iiS;
    private TextWatcher iiT = null;

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        v.fv(context).inflate(a$g.uCc, this, true);
        this.ihQ = (ImageView) findViewById(f.bLC);
        this.iiQ = (TextView) findViewById(f.cUp);
        this.iiR = (WalletFormView) findViewById(f.urE);
        this.iiS = findViewById(f.divider);
    }
}
