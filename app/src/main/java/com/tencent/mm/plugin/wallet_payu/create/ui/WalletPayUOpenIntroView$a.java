package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a.f;

class WalletPayUOpenIntroView$a extends u {
    final /* synthetic */ WalletPayUOpenIntroView tch;

    private WalletPayUOpenIntroView$a(WalletPayUOpenIntroView walletPayUOpenIntroView) {
        this.tch = walletPayUOpenIntroView;
    }

    public final int getCount() {
        return WalletPayUOpenIntroView.c(this.tch) == null ? 0 : WalletPayUOpenIntroView.c(this.tch).length;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        View view = (View) WalletPayUOpenIntroView.d(this.tch).get(i);
        viewGroup.addView(view);
        d dVar = WalletPayUOpenIntroView.c(this.tch)[i];
        TextView textView = (TextView) view.findViewById(f.uxc);
        TextView textView2 = (TextView) view.findViewById(f.hint);
        ((ImageView) view.findViewById(f.logo)).setImageResource(dVar.tcb);
        textView.setText(dVar.titleRes);
        textView2.setText(dVar.tcc);
        return view;
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) WalletPayUOpenIntroView.d(this.tch).get(i));
    }
}
