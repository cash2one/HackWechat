package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.wallet.balance.a.a.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aua;

class WalletLqtSaveFetchUI$5 implements TextWatcher {
    final /* synthetic */ WalletLqtSaveFetchUI sBv;

    WalletLqtSaveFetchUI$5(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        this.sBv = walletLqtSaveFetchUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (editable.toString().startsWith(".")) {
            editable.insert(0, "0");
        }
        String obj = editable.toString();
        int indexOf = obj.indexOf(".");
        int length = obj.length();
        if (indexOf >= 0 && length - indexOf > 3) {
            editable.delete(indexOf + 3, length);
        } else if (indexOf > 12) {
            editable.delete(12, indexOf);
        } else if (indexOf == -1 && length > 12) {
            editable.delete(12, length);
        }
        int ez = WalletLqtSaveFetchUI.ez(editable.toString(), "100");
        if (ez <= 0) {
            if (WalletLqtSaveFetchUI.e(this.sBv) != 1 || (WalletLqtSaveFetchUI.j(this.sBv) != null && WalletLqtSaveFetchUI.j(this.sBv).bKP())) {
                WalletLqtSaveFetchUI.k(this.sBv).setText(WalletLqtSaveFetchUI.l(this.sBv));
            } else {
                WalletLqtSaveFetchUI.k(this.sBv).setText("");
            }
            WalletLqtSaveFetchUI.k(this.sBv).setTextColor(Color.parseColor("#888888"));
            WalletLqtSaveFetchUI.b(this.sBv, false);
            WalletLqtSaveFetchUI.a(this.sBv, false);
        } else if (WalletLqtSaveFetchUI.e(this.sBv) == 1) {
            if (WalletLqtSaveFetchUI.j(this.sBv) == null) {
                WalletLqtSaveFetchUI.b(this.sBv, true);
                WalletLqtSaveFetchUI.a(this.sBv, true);
            } else if (WalletLqtSaveFetchUI.j(this.sBv).bKP()) {
                if (WalletLqtSaveFetchUI.b(this.sBv) == null || ez <= WalletLqtSaveFetchUI.ez(WalletLqtSaveFetchUI.b(this.sBv).sLf, "100")) {
                    WalletLqtSaveFetchUI.k(this.sBv).setText(WalletLqtSaveFetchUI.l(this.sBv));
                    WalletLqtSaveFetchUI.k(this.sBv).setTextColor(Color.parseColor("#888888"));
                    WalletLqtSaveFetchUI.b(this.sBv, true);
                    WalletLqtSaveFetchUI.a(this.sBv, true);
                    return;
                }
                WalletLqtSaveFetchUI.k(this.sBv).setText(this.sBv.getString(i.uSU));
                WalletLqtSaveFetchUI.k(this.sBv).setTextColor(-65536);
                WalletLqtSaveFetchUI.b(this.sBv, false);
                WalletLqtSaveFetchUI.a(this.sBv, false);
            } else if (WalletLqtSaveFetchUI.j(this.sBv).field_dayQuotaKind <= 0.0d || ez <= WalletLqtSaveFetchUI.ez(WalletLqtSaveFetchUI.j(this.sBv).field_dayQuotaKind, "100")) {
                WalletLqtSaveFetchUI.k(this.sBv).setText("");
                WalletLqtSaveFetchUI.b(this.sBv, true);
                WalletLqtSaveFetchUI.a(this.sBv, true);
            } else {
                WalletLqtSaveFetchUI.k(this.sBv).setText(this.sBv.getString(i.uSV));
                WalletLqtSaveFetchUI.k(this.sBv).setTextColor(-65536);
                WalletLqtSaveFetchUI.b(this.sBv, false);
                WalletLqtSaveFetchUI.a(this.sBv, false);
            }
        } else if (WalletLqtSaveFetchUI.e(this.sBv) == 2) {
            boolean z;
            if (WalletLqtSaveFetchUI.j(this.sBv) == null || !WalletLqtSaveFetchUI.j(this.sBv).bKP()) {
                aua com_tencent_mm_protocal_c_aua = l.bJn().syE;
                if (com_tencent_mm_protocal_c_aua == null) {
                    length = 0;
                    z = false;
                } else {
                    length = com_tencent_mm_protocal_c_aua.wBU;
                    z = false;
                }
            } else {
                length = this.sBv.getIntent().getIntExtra("lqt_balance", 0);
                z = true;
            }
            if (ez > length) {
                if (z) {
                    WalletLqtSaveFetchUI.k(this.sBv).setText(this.sBv.getString(i.uSw));
                } else {
                    WalletLqtSaveFetchUI.k(this.sBv).setText(this.sBv.getString(i.uSx));
                }
                WalletLqtSaveFetchUI.k(this.sBv).setTextColor(-65536);
                WalletLqtSaveFetchUI.b(this.sBv, false);
                WalletLqtSaveFetchUI.a(this.sBv, false);
            } else if (WalletLqtSaveFetchUI.m(this.sBv) > 0 && ez > WalletLqtSaveFetchUI.m(this.sBv)) {
                WalletLqtSaveFetchUI.k(this.sBv).setText(WalletLqtSaveFetchUI.n(this.sBv));
                WalletLqtSaveFetchUI.k(this.sBv).setTextColor(-65536);
                WalletLqtSaveFetchUI.b(this.sBv, false);
                WalletLqtSaveFetchUI.a(this.sBv, false);
            } else if (WalletLqtSaveFetchUI.j(this.sBv) == null || WalletLqtSaveFetchUI.j(this.sBv).bKP() || WalletLqtSaveFetchUI.j(this.sBv).field_dayQuotaKind <= 0.0d || ez <= WalletLqtSaveFetchUI.ez(WalletLqtSaveFetchUI.j(this.sBv).field_dayQuotaKind, "100")) {
                WalletLqtSaveFetchUI.k(this.sBv).setText(WalletLqtSaveFetchUI.l(this.sBv));
                WalletLqtSaveFetchUI.k(this.sBv).setTextColor(Color.parseColor("#888888"));
                WalletLqtSaveFetchUI.b(this.sBv, true);
                WalletLqtSaveFetchUI.a(this.sBv, true);
            } else {
                WalletLqtSaveFetchUI.k(this.sBv).setText(this.sBv.getString(i.uSy));
                WalletLqtSaveFetchUI.k(this.sBv).setTextColor(-65536);
                WalletLqtSaveFetchUI.b(this.sBv, false);
                WalletLqtSaveFetchUI.a(this.sBv, false);
            }
        }
    }
}
