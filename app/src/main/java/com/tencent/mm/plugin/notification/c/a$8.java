package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class a$8 implements a {
    final /* synthetic */ long fhh;
    final /* synthetic */ a oUi;

    a$8(a aVar, long j) {
        this.oUi = aVar;
        this.fhh = j;
    }

    public final boolean uF() {
        if (!(this.oUi.oUc.contains(Long.valueOf(this.fhh)) || this.oUi.oUd.contains(Long.valueOf(this.fhh)) || !this.oUi.oTZ.dW(this.fhh))) {
            x.i("MicroMsg.AbstractSendMsgFailNotification", "msg:%d send timeout, move this message to fail list, continue send next message", new Object[]{Long.valueOf(this.fhh)});
            this.oUi.oUd.add(Long.valueOf(this.fhh));
            this.oUi.oUe.add(Long.valueOf(this.fhh));
            if (this.oUi.oUc.size() + this.oUi.oUd.size() >= this.oUi.oTZ.oUk.size()) {
                a.d(this.oUi);
            } else {
                this.oUi.dS(this.oUi.oTZ.bgB());
            }
        }
        return true;
    }
}
