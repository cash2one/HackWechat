package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.plugin.notification.ui.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements a {
    final /* synthetic */ a oUi;

    a$2(a aVar) {
        this.oUi = aVar;
    }

    public final void bgy() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
        ag.y(new Runnable(this) {
            final /* synthetic */ a$2 oUj;

            {
                this.oUj = r1;
            }

            public final void run() {
                g.pQN.h(11425, new Object[]{Integer.valueOf(this.oUj.oUi.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0)});
                this.oUj.oUi.bgv();
                a.a(this.oUj.oUi);
                this.oUj.oUi.bgo();
            }
        });
    }

    public final void bgz() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
        ag.y(new Runnable(this) {
            final /* synthetic */ a$2 oUj;

            {
                this.oUj = r1;
            }

            public final void run() {
                g.pQN.h(11425, new Object[]{Integer.valueOf(this.oUj.oUi.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
                this.oUj.oUi.bgv();
                this.oUj.oUi.bgr();
                a.b(this.oUj.oUi);
                this.oUj.oUi.oUa.dismiss();
            }
        });
    }
}
