package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.widget.g;

class BankRemitBankcardInputUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ BankRemitBankcardInputUI pIo;

    BankRemitBankcardInputUI$12(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.pIo = bankRemitBankcardInputUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.d("MicroMsg.BankRemitBankcardInputUI", "help click");
        BankRemitBankcardInputUI.a(this.pIo, new g(this.pIo.mController.xIM, g.ztp, false));
        BankRemitBankcardInputUI.a(this.pIo).rKC = new c(this) {
            final /* synthetic */ BankRemitBankcardInputUI$12 pIt;

            {
                this.pIt = r1;
            }

            public final void a(n nVar) {
                nVar.add(0, 0, 0, this.pIt.pIo.getString(i.uHL));
                nVar.add(0, 1, 0, this.pIt.pIo.getString(i.uHJ));
            }
        };
        BankRemitBankcardInputUI.a(this.pIo).rKD = new 2(this);
        BankRemitBankcardInputUI.c(this.pIo);
        BankRemitBankcardInputUI.a(this.pIo).bUk();
        com.tencent.mm.plugin.report.service.g.pQN.h(14673, new Object[]{Integer.valueOf(2)});
        return false;
    }
}
