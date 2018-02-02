package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class WalletBalanceFetchResultItemView extends LinearLayout {
    private TextView jJn;
    private TextView lkn;
    private boolean pIz;

    public WalletBalanceFetchResultItemView(Context context) {
        this(context, false);
    }

    public WalletBalanceFetchResultItemView(Context context, boolean z) {
        super(context);
        this.pIz = false;
        this.pIz = z;
        init();
    }

    public WalletBalanceFetchResultItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pIz = false;
        init();
    }

    public WalletBalanceFetchResultItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pIz = false;
        init();
    }

    private void init() {
        if (this.pIz) {
            inflate(getContext(), g.uAZ, this);
        } else {
            inflate(getContext(), g.uAY, this);
        }
        this.jJn = (TextView) findViewById(f.ufY);
        this.lkn = (TextView) findViewById(f.ufX);
    }

    public final void c(int i, CharSequence charSequence) {
        this.jJn.setText(getContext().getString(i));
        this.lkn.setText(charSequence);
    }
}
