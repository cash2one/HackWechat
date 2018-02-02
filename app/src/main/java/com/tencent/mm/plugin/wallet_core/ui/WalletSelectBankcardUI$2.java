package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class WalletSelectBankcardUI$2 implements OnItemClickListener {
    final /* synthetic */ WalletSelectBankcardUI sWl;

    WalletSelectBankcardUI$2(WalletSelectBankcardUI walletSelectBankcardUI) {
        this.sWl = walletSelectBankcardUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        final Bankcard bankcard = (Bankcard) adapterView.getItemAtPosition(i);
        if (bankcard != null) {
            h.a(this.sWl, true, this.sWl.getString(i.uWt, new Object[]{bankcard.field_desc, bankcard.field_mobile}), this.sWl.getString(i.uWv), this.sWl.getString(i.uWs), this.sWl.getString(i.uWu), new OnClickListener(this) {
                final /* synthetic */ WalletSelectBankcardUI$2 sWn;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.sWn.sWl.vf.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                    WalletSelectBankcardUI.a(this.sWn.sWl, bankcard);
                    g.pQN.h(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
                }
            }, new 2(this, bankcard));
            return;
        }
        this.sWl.vf.putBoolean("key_balance_change_phone_need_confirm_phone", false);
        WalletSelectBankcardUI.a(this.sWl, null);
    }
}
