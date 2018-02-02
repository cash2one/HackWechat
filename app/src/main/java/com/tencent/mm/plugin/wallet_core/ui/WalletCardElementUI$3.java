package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$g;

class WalletCardElementUI$3 extends BaseAdapter {
    final /* synthetic */ WalletCardElementUI sSA;

    WalletCardElementUI$3(WalletCardElementUI walletCardElementUI) {
        this.sSA = walletCardElementUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return zo(i);
    }

    public final int getCount() {
        return WalletCardElementUI.d(this.sSA).bLc() != null ? WalletCardElementUI.d(this.sSA).bLc().size() : 0;
    }

    private Integer zo(int i) {
        return (Integer) WalletCardElementUI.d(this.sSA).bLc().get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.sSA, a$g.uFe, null);
        checkedTextView.setText(o.bLy().O(this.sSA, zo(i).intValue()));
        if (WalletCardElementUI.g(this.sSA) == zo(i).intValue()) {
            checkedTextView.setChecked(true);
        } else {
            checkedTextView.setChecked(false);
        }
        return checkedTextView;
    }
}
