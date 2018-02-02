package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h$c;
import java.util.ArrayList;
import java.util.List;

class WalletWXCreditDetailUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ WalletWXCreditDetailUI uad;

    WalletWXCreditDetailUI$4(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        this.uad = walletWXCreditDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        List arrayList = new ArrayList();
        o.bLq();
        String str = WalletWXCreditDetailUI.a(this.uad).field_bindSerial;
        h.a(this.uad, null, (String[]) arrayList.toArray(new String[arrayList.size()]), this.uad.getString(i.uSc), false, new h$c(this) {
            final /* synthetic */ WalletWXCreditDetailUI$4 uae;

            {
                this.uae = r1;
            }

            public final void jl(int i) {
                switch (i) {
                    case 0:
                        o.bLq();
                        String str = WalletWXCreditDetailUI.a(this.uae.uad).field_bindSerial;
                        WalletWXCreditDetailUI.bXS();
                        return;
                    case 1:
                        WalletWXCreditDetailUI.c(this.uae.uad);
                        return;
                    default:
                        return;
                }
            }
        });
        return true;
    }
}
