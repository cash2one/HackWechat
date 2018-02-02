package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;

class ComposeUI$19 implements a {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$19(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final void b(final MailAddrsViewControl mailAddrsViewControl) {
        h.a(this.prr.mController.xIM, this.prr.getString(R.l.eAE), "", new 1(this, mailAddrsViewControl), new OnClickListener(this) {
            final /* synthetic */ ComposeUI$19 prA;

            public final void onClick(DialogInterface dialogInterface, int i) {
                ComposeUI.i(this.prA.prr).postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 prC;

                    {
                        this.prC = r1;
                    }

                    public final void run() {
                        ComposeUI.h(this.prC.prA.prr);
                        mailAddrsViewControl.requestFocus();
                        this.prC.prA.prr.showVKB();
                    }
                }, 150);
            }
        });
    }

    public final void bkJ() {
        u.a(this.prr, this.prr.getString(R.l.eAE), 1500);
    }
}
