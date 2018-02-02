package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h$c;

class WalletSelectAddrUI$5 implements OnItemLongClickListener {
    final /* synthetic */ WalletSelectAddrUI iom;

    WalletSelectAddrUI$5(WalletSelectAddrUI walletSelectAddrUI) {
        this.iom = walletSelectAddrUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
        h.a(this.iom.mController.xIM, null, this.iom.getResources().getStringArray(R.c.brc), null, new h$c(this) {
            final /* synthetic */ WalletSelectAddrUI$5 ioo;

            public final void jl(int i) {
                b bVar;
                synchronized (WalletSelectAddrUI.c(this.ioo.iom)) {
                    if (i < WalletSelectAddrUI.d(this.ioo.iom).size()) {
                        bVar = (b) WalletSelectAddrUI.d(this.ioo.iom).get(i);
                    } else {
                        bVar = null;
                    }
                }
                if (bVar != null) {
                    switch (i) {
                        case 0:
                            WalletSelectAddrUI.a(this.ioo.iom, bVar.id);
                            return;
                        case 1:
                            k fVar = new f(bVar.id);
                            WalletSelectAddrUI.a(this.ioo.iom, null);
                            WalletSelectAddrUI.g(this.ioo.iom).g(fVar);
                            return;
                        case 2:
                            WalletSelectAddrUI.b(this.ioo.iom, bVar);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        return true;
    }
}
