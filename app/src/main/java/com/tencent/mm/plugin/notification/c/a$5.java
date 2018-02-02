package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class a$5 implements a {
    final /* synthetic */ a oUi;

    a$5(a aVar) {
        this.oUi = aVar;
    }

    public final boolean uF() {
        if (!this.oUi.oUb) {
            return false;
        }
        x.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[]{Integer.valueOf(this.oUi.oTZ.oUk.size()), Integer.valueOf(this.oUi.oUc.size()), Integer.valueOf(this.oUi.oUd.size())});
        this.oUi.bgp();
        x.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[]{Integer.valueOf(this.oUi.oTZ.oUk.size()), Integer.valueOf(this.oUi.oUc.size()), Integer.valueOf(this.oUi.oUd.size())});
        if (this.oUi.oTZ.oUk.size() > 0) {
            a.c(this.oUi);
            return true;
        }
        a.d(this.oUi);
        return true;
    }
}
