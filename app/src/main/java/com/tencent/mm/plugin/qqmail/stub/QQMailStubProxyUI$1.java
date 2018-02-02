package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.plugin.qqmail.ui.c;
import com.tencent.mm.plugin.qqmail.ui.c$a;
import com.tencent.mm.sdk.platformtools.x;

class QQMailStubProxyUI$1 extends c$a {
    final /* synthetic */ c pqb;
    final /* synthetic */ QQMailStubProxyUI pqc;

    QQMailStubProxyUI$1(QQMailStubProxyUI qQMailStubProxyUI, c cVar) {
        this.pqc = qQMailStubProxyUI;
        this.pqb = cVar;
    }

    public final void bkv() {
        x.d("MicroMsg.QQMail.QQMailStubProxyUI", "onAfterVerify");
        this.pqb.release();
        this.pqc.setResult(-1);
        this.pqc.finish();
    }

    public final void bkw() {
        x.e("MicroMsg.QQMail.QQMailStubProxyUI", "onVerifyFail, finish self");
        this.pqb.release();
        this.pqc.setResult(0);
        this.pqc.finish();
    }
}
