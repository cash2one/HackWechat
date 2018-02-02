package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.e;

class WalletCardImportUI$9 extends BaseAdapter {
    final /* synthetic */ WalletCardImportUI sSH;

    WalletCardImportUI$9(WalletCardImportUI walletCardImportUI) {
        this.sSH = walletCardImportUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return zo(i);
    }

    public final int getCount() {
        return WalletCardImportUI.c(this.sSH).bLc() != null ? WalletCardImportUI.c(this.sSH).bLc().size() : 0;
    }

    private Integer zo(int i) {
        return (Integer) WalletCardImportUI.c(this.sSH).bLc().get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.sSH, a$g.uFe, null);
        checkedTextView.setText(o.bLy().O(this.sSH, zo(i).intValue()));
        if (WalletCardImportUI.f(this.sSH) == zo(i).intValue()) {
            checkedTextView.setChecked(true);
        } else {
            checkedTextView.setChecked(false);
        }
        checkedTextView.setBackgroundResource(e.bBx);
        return checkedTextView;
    }
}
