package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.d.i;

public class BankRemitDetailItemView extends LinearLayout {
    private TextView jJn;
    private TextView lkn;
    private boolean pIz;

    public BankRemitDetailItemView(Context context) {
        this(context, false);
    }

    public BankRemitDetailItemView(Context context, boolean z) {
        super(context);
        this.pIz = false;
        this.pIz = z;
        init();
    }

    public BankRemitDetailItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pIz = false;
        init();
    }

    public BankRemitDetailItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pIz = false;
        init();
    }

    private void init() {
        if (this.pIz) {
            inflate(getContext(), a$g.uAZ, this);
        } else {
            inflate(getContext(), a$g.uAY, this);
        }
        this.jJn = (TextView) findViewById(f.ufY);
        this.lkn = (TextView) findViewById(f.ufX);
    }

    public final void a(String str, CharSequence charSequence, boolean z) {
        this.jJn.setText(str);
        if (z) {
            this.lkn.setText(i.b(getContext(), charSequence, this.lkn.getTextSize()));
        } else {
            this.lkn.setText(charSequence);
        }
    }

    public final void c(int i, CharSequence charSequence) {
        a(getContext().getString(i), charSequence, false);
    }
}
