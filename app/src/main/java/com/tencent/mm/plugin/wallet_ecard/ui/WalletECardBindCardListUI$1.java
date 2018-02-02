package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.x;

class WalletECardBindCardListUI$1 implements OnItemClickListener {
    final /* synthetic */ WalletECardBindCardListUI sZK;

    WalletECardBindCardListUI$1(WalletECardBindCardListUI walletECardBindCardListUI) {
        this.sZK = walletECardBindCardListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.WalletECardBindCardListUI", "position: %d", new Object[]{Integer.valueOf(i)});
        int itemViewType = adapterView.getAdapter().getItemViewType(i);
        Bundle bundle = new Bundle();
        WalletECardBindCardListUI.a(this.sZK).getClass();
        if (itemViewType == 1) {
            x.d("MicroMsg.WalletECardBindCardListUI", "click add item");
            this.sZK.vf.putInt(a.sZb, a.sZr);
            com.tencent.mm.wallet_core.a.j(this.sZK.mController.xIM, bundle);
            return;
        }
        if (((ey) adapterView.getAdapter().getItem(i)) == null) {
            x.w("MicroMsg.WalletECardBindCardListUI", "empty item");
            return;
        }
        this.sZK.cCd().k(new Object[]{r0});
    }
}
