package com.tencent.mm.plugin.notification;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.z.aj;

public class PluginNotification extends f implements a {
    private aj oTY;

    public void execute(g gVar) {
    }

    public void setNotification(aj ajVar) {
        this.oTY = ajVar;
        b.oTM = ajVar;
    }

    public aj getNotification() {
        return this.oTY;
    }
}
