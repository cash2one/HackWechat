package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.widget.MMEditText;

public class LuckyMoneyTextInputView extends LinearLayout implements b {
    private TextView jJn;
    public f ohZ;
    private MMEditText okl;

    public LuckyMoneyTextInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(g.uCH, this, true);
        this.okl = (MMEditText) inflate.findViewById(f.upD);
        this.jJn = (TextView) inflate.findViewById(f.upE);
        this.okl.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ LuckyMoneyTextInputView okm;

            {
                this.okm = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (this.okm.ohZ != null) {
                    f a = this.okm.ohZ;
                    this.okm.getId();
                    a.aXq();
                }
            }
        });
    }

    public final String getInput() {
        return this.okl.getText().toString();
    }

    public final void Ec(String str) {
        this.okl.setHint(str);
    }

    public final int aXG() {
        return 0;
    }

    public final void restore() {
    }

    public final void onError() {
    }

    public final String sg(int i) {
        return null;
    }
}
