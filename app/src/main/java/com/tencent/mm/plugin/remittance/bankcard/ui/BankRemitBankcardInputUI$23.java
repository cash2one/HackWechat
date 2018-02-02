package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.ag;

class BankRemitBankcardInputUI$23 implements OnEditorActionListener {
    final /* synthetic */ BankRemitBankcardInputUI pIo;

    BankRemitBankcardInputUI$23(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.pIo = bankRemitBankcardInputUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5) {
            this.pIo.aWs();
            if (!BankRemitBankcardInputUI.n(this.pIo)) {
                ag.h(new Runnable(this) {
                    final /* synthetic */ BankRemitBankcardInputUI$23 pIw;

                    {
                        this.pIw = r1;
                    }

                    public final void run() {
                        this.pIw.pIo.cCb();
                    }
                }, 200);
            }
        }
        return false;
    }
}
