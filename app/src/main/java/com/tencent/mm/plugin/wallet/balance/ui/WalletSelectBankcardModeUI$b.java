package com.tencent.mm.plugin.wallet.balance.ui;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI.a;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a.f;

@SuppressLint({"ViewHolder"})
class WalletSelectBankcardModeUI$b extends BaseAdapter {
    final /* synthetic */ WalletSelectBankcardModeUI sAn;

    public final /* synthetic */ Object getItem(int i) {
        return (a) WalletSelectBankcardModeUI.b(this.sAn).get(i);
    }

    WalletSelectBankcardModeUI$b(WalletSelectBankcardModeUI walletSelectBankcardModeUI) {
        this.sAn = walletSelectBankcardModeUI;
    }

    public final int getCount() {
        return WalletSelectBankcardModeUI.b(this.sAn).size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = View.inflate(this.sAn, a$g.uFN, null);
        a aVar = (a) WalletSelectBankcardModeUI.b(this.sAn).get(i);
        TextView textView = (TextView) inflate.findViewById(f.ufu);
        ImageView imageView = (ImageView) inflate.findViewById(f.uwt);
        ((TextView) inflate.findViewById(f.ufv)).setText(aVar.title);
        if (TextUtils.isEmpty(aVar.kNs)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(aVar.kNs);
        }
        if (WalletSelectBankcardModeUI.c(this.sAn) == i) {
            imageView.setImageResource(a$h.dAr);
        } else {
            imageView.setImageResource(a$h.dAq);
        }
        return inflate;
    }
}
