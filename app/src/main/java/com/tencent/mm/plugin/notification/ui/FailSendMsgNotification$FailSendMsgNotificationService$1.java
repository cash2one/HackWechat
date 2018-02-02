package com.tencent.mm.plugin.notification.ui;

import com.tencent.mm.g.a.ke;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification.FailSendMsgNotificationService;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class FailSendMsgNotification$FailSendMsgNotificationService$1 extends c<ke> {
    final /* synthetic */ FailSendMsgNotificationService oVh;

    FailSendMsgNotification$FailSendMsgNotificationService$1(FailSendMsgNotificationService failSendMsgNotificationService) {
        this.oVh = failSendMsgNotificationService;
        this.xen = ke.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((ke) bVar).fBy.type != this.oVh.bgO()) {
            x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, type mismatch, type:%d, getNotificationType:%d", new Object[]{Integer.valueOf(((ke) bVar).fBy.type), Integer.valueOf(this.oVh.bgO())});
        } else {
            x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, stop service and show notificaiton, type:%d", new Object[]{Integer.valueOf(((ke) bVar).fBy.type)});
            this.oVh.stopForeground(true);
            if (this.oVh.oVg != null) {
                this.oVh.oVg.lzK = false;
                this.oVh.oVg.show();
            }
            this.oVh.stopSelf();
        }
        return false;
    }
}
