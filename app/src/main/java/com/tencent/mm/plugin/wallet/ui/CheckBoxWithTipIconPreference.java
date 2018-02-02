package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public class CheckBoxWithTipIconPreference extends CheckBoxPreference {
    private TextView sHZ;
    private int sIa;
    private String sIb;
    private int sIc;

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sIa = -1;
        this.sIb = "";
        this.sIc = 8;
        setLayoutResource(g.uDh);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.sHZ = (TextView) view.findViewById(a$f.gWA);
        cq(this.sIb, this.sIa);
        zg(this.sIc);
    }

    public final void cq(String str, int i) {
        this.sIa = i;
        this.sIb = str;
        if (this.sHZ != null) {
            if (this.sIa > 0) {
                this.sHZ.setBackgroundResource(this.sIa);
            }
            if (!TextUtils.isEmpty(this.sIb)) {
                this.sHZ.setText(this.sIb);
            }
        }
    }

    public final void zg(int i) {
        this.sIc = i;
        if (this.sHZ != null) {
            this.sHZ.setVisibility(i);
        }
    }
}
