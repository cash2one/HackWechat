package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.sdk.platformtools.x;

class WalletSelectAddrUI$4 implements OnItemClickListener {
    final /* synthetic */ WalletSelectAddrUI iom;

    WalletSelectAddrUI$4(WalletSelectAddrUI walletSelectAddrUI) {
        this.iom = walletSelectAddrUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.WalletSelectAddrUI", "select pos " + i);
        synchronized (WalletSelectAddrUI.c(this.iom)) {
            if (i < WalletSelectAddrUI.d(this.iom).size()) {
                WalletSelectAddrUI.a(this.iom, (b) WalletSelectAddrUI.d(this.iom).get(i));
                if (!WalletSelectAddrUI.e(this.iom) && WalletSelectAddrUI.f(this.iom) != null) {
                    WalletSelectAddrUI.a(this.iom, WalletSelectAddrUI.f(this.iom).id);
                } else if (!(WalletSelectAddrUI.f(this.iom) == null || WalletSelectAddrUI.f(this.iom).id == 0)) {
                    WalletSelectAddrUI.g(this.iom).g(new g(WalletSelectAddrUI.f(this.iom).id));
                }
            }
        }
        WalletSelectAddrUI.h(this.iom).notifyDataSetChanged();
    }
}
