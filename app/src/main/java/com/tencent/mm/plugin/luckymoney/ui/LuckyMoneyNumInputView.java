package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView extends LinearLayout implements b {
    private TextWatcher XD = new TextWatcher(this) {
        final /* synthetic */ LuckyMoneyNumInputView ojl;

        {
            this.ojl = r1;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (this.ojl.ohZ != null) {
                f a = this.ojl.ohZ;
                this.ojl.getId();
                a.aXq();
            }
        }
    };
    private TextView jJn;
    public f ohZ;
    TenpaySecureEditText ojg;
    private TextView ojh;
    private int oji = 1;
    private int ojj = Integer.MAX_VALUE;
    public int ojk = 1;

    public LuckyMoneyNumInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(g.uCD, this, true);
        this.jJn = (TextView) inflate.findViewById(a$f.uoU);
        this.ojg = (TenpaySecureEditText) inflate.findViewById(a$f.unA);
        this.ojh = (TextView) inflate.findViewById(a$f.uoV);
        this.ojg.setText(this.oji);
        this.ojg.addTextChangedListener(this.XD);
    }

    public final void si(int i) {
        int i2 = 3;
        this.ojj = i;
        int i3 = 0;
        while (i > 0) {
            i3++;
            i /= 10;
        }
        if (i3 > 3) {
            i2 = i3;
        }
        this.ojg.setFilters(new InputFilter[]{new LengthFilter(i2)});
    }

    public final int aXO() {
        return bh.getInt(this.ojg.getText().toString(), 0);
    }

    public final void Ea(String str) {
        this.ojg.setText(str);
        this.ojg.setSelection(this.ojg.getText().length());
        this.oji = bh.getInt(str, 0);
    }

    public final int aXG() {
        if (bh.ov(this.ojg.getText().toString())) {
            return 0;
        }
        int i = bh.getInt(this.ojg.getText().toString(), -1);
        if (i < 0) {
            return 3;
        }
        if (i > this.ojj && this.ojj > 0) {
            return 1;
        }
        if (i >= this.ojk || this.ojk <= 0) {
            return 0;
        }
        return 2;
    }

    public final void restore() {
        this.jJn.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.ojg.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.ojh.setTextColor(WebView.NIGHT_MODE_COLOR);
    }

    public final void onError() {
        this.jJn.setTextColor(n.cZ(getContext()));
        this.ojg.setTextColor(n.cZ(getContext()));
        this.ojh.setTextColor(n.cZ(getContext()));
    }

    public final String sg(int i) {
        if (i == 1) {
            return getContext().getString(i.uKy, new Object[]{Integer.valueOf(this.ojj)});
        } else if (i != 2) {
            return null;
        } else {
            return getContext().getString(i.uKx, new Object[]{Integer.valueOf(this.ojk)});
        }
    }
}
