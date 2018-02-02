package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.z.ar;

class VoipCSMainUI$18 implements a {
    final /* synthetic */ VoipCSMainUI sxP;

    VoipCSMainUI$18(VoipCSMainUI voipCSMainUI) {
        this.sxP = voipCSMainUI;
    }

    public final boolean uF() {
        Notification notification = new Builder(ac.getContext()).setTicker(this.sxP.tickerText).setContentTitle(this.sxP.title).setContentText(this.sxP.fyY).setContentIntent(PendingIntent.getActivity(ac.getContext(), 44, new Intent(ac.getContext(), VoipCSMainUI.class), 134217728)).setOngoing(true).getNotification();
        notification.icon = com.tencent.mm.bl.a.bXV();
        notification.flags |= 32;
        ar.getNotification().a(44, notification, false);
        return true;
    }
}
