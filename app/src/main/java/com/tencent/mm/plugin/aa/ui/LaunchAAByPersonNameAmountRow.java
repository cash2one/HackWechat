package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.v;

public class LaunchAAByPersonNameAmountRow extends LinearLayout {
    TextView ihU;
    TextView iiQ;
    View iiS;

    public LaunchAAByPersonNameAmountRow(Context context) {
        super(context);
        init(context);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        v.fv(context).inflate(g.uCe, this, true);
        this.iiQ = (TextView) findViewById(f.cUp);
        this.ihU = (TextView) findViewById(f.nZd);
        this.iiS = findViewById(f.divider);
    }
}
