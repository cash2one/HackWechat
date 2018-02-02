package com.tencent.mm.plugin.wallet_core.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;

class WalletSelectBankcardUI$a extends BaseAdapter {
    final /* synthetic */ WalletSelectBankcardUI sWl;

    class a {
        TextView sWo;
        final /* synthetic */ WalletSelectBankcardUI$a sWp;

        a(WalletSelectBankcardUI$a walletSelectBankcardUI$a) {
            this.sWp = walletSelectBankcardUI$a;
        }
    }

    private WalletSelectBankcardUI$a(WalletSelectBankcardUI walletSelectBankcardUI) {
        this.sWl = walletSelectBankcardUI;
    }

    public final int getCount() {
        return WalletSelectBankcardUI.a(this.sWl) ? WalletSelectBankcardUI.b(this.sWl) == null ? 1 : WalletSelectBankcardUI.b(this.sWl).size() + 1 : WalletSelectBankcardUI.b(this.sWl) == null ? 0 : WalletSelectBankcardUI.b(this.sWl).size();
    }

    public final Object getItem(int i) {
        if (WalletSelectBankcardUI.b(this.sWl) == null || WalletSelectBankcardUI.b(this.sWl).size() <= i) {
            return null;
        }
        return WalletSelectBankcardUI.b(this.sWl).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        Bankcard bankcard = (Bankcard) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(this.sWl).inflate(g.uFO, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.sWo = (TextView) view.findViewById(f.uff);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (bankcard != null) {
            aVar.sWo.setText(bankcard.field_desc);
        } else {
            aVar.sWo.setText(i.uWx);
        }
        return view;
    }
}
