package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyMoneyInputView extends LinearLayout implements b {
    private TextWatcher XD = new 1(this);
    private TextView jJn;
    public int mType;
    private c obJ;
    TenpaySecureEditText ohW;
    private TextView ohX;
    private TextView ohY;
    public f ohZ;
    public double oia;
    public double oib;

    public LuckyMoneyMoneyInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a.aWP();
        this.obJ = a.aWQ().aXb();
        View inflate = LayoutInflater.from(context).inflate(g.uCw, this, true);
        this.ohW = (TenpaySecureEditText) inflate.findViewById(f.unA);
        this.ohW.addTextChangedListener(this.XD);
        this.jJn = (TextView) inflate.findViewById(f.unX);
        this.ohY = (TextView) inflate.findViewById(f.unW);
        this.ohX = (TextView) inflate.findViewById(f.umD);
    }

    public final double aXH() {
        return bh.getDouble(this.ohW.getText().toString(), 0.0d);
    }

    public final void setTitle(String str) {
        this.jJn.setText(str);
    }

    public final void gu(boolean z) {
        if (z) {
            this.ohY.setVisibility(0);
        } else {
            this.ohY.setVisibility(8);
        }
    }

    public final void aXI() {
        this.ohW.setFilters(new InputFilter[]{new LengthFilter(12)});
    }

    public final void DZ(String str) {
        this.ohW.setText(str);
    }

    public final int aXG() {
        if (bh.ov(this.ohW.getText().toString())) {
            return 0;
        }
        double d = bh.getDouble(this.ohW.getText().toString(), -1.0d);
        if (d < 0.0d) {
            return 3;
        }
        if (d > this.oia && this.oia > 0.0d) {
            return 1;
        }
        if (d >= this.oib || d <= 0.0d) {
            return 0;
        }
        return 2;
    }

    public final void restore() {
        this.jJn.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.ohW.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.ohX.setTextColor(WebView.NIGHT_MODE_COLOR);
    }

    public final void onError() {
        this.jJn.setTextColor(n.cZ(getContext()));
        this.ohW.setTextColor(n.cZ(getContext()));
        this.ohX.setTextColor(n.cZ(getContext()));
    }

    public final String sg(int i) {
        a.aWP();
        this.obJ = a.aWQ().aXb();
        if (i == 1) {
            if (this.mType == 1) {
                return getContext().getString(i.uKX, new Object[]{Math.round(this.oia), bh.az(this.obJ.obI, "")});
            }
            return getContext().getString(i.uJI, new Object[]{Math.round(this.oia), bh.az(this.obJ.obI, "")});
        } else if (i != 2) {
            return null;
        } else {
            return getContext().getString(i.uJJ, new Object[]{e.t(this.oib), bh.az(this.obJ.obI, "")});
        }
    }
}
