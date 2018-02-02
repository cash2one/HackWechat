package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;

class WalletWXCreditChangeAmountUI$2 extends BaseAdapter {
    final /* synthetic */ WalletWXCreditChangeAmountUI tZW;

    WalletWXCreditChangeAmountUI$2(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.tZW = walletWXCreditChangeAmountUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return (l) WalletWXCreditChangeAmountUI.j(this.tZW).get(i);
    }

    public final int getCount() {
        return 2;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.tZW, a$g.uFe, null);
        if (i == 0) {
            checkedTextView.setText(a$i.dHd);
        } else {
            checkedTextView.setText(a$i.dFR);
        }
        if (WalletWXCreditChangeAmountUI.l(this.tZW)) {
            if (WalletWXCreditChangeAmountUI.c(this.tZW).tZx == null || !"Y".equals(WalletWXCreditChangeAmountUI.c(this.tZW).ocF)) {
                if (i == 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            } else {
                if (i != 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            }
        } else if (WalletWXCreditChangeAmountUI.f(this.tZW).tZx == null || !"Y".equals(WalletWXCreditChangeAmountUI.f(this.tZW).ocF)) {
            if (i == 0) {
                z = false;
            }
            checkedTextView.setChecked(z);
        } else {
            if (i != 0) {
                z = false;
            }
            checkedTextView.setChecked(z);
        }
        return checkedTextView;
    }
}
