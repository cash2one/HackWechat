package com.tencent.mm.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.bf.l;
import com.tencent.mm.bl.a;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.z.ar;

class WorkerProfile$7 extends c<kk> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$7(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = kk.class.getName().hashCode();
    }

    @TargetApi(16)
    public final /* synthetic */ boolean a(b bVar) {
        Notification a;
        kk kkVar = (kk) bVar;
        int Tl = l.Tx().Tl();
        int i = kkVar.fBI.type;
        String str = kkVar.fBI.userName;
        String Wj = com.tencent.mm.bx.b.cgX().Wj(kkVar.fBI.bgo);
        if (WorkerProfile.a(this.fgz) == null) {
            WorkerProfile.a(this.fgz, new g(ac.getContext()));
        }
        WorkerProfile.a(this.fgz);
        int bXV = a.bXV();
        Notification notification = new Notification();
        notification.icon = R.g.icon;
        notification.when = System.currentTimeMillis();
        notification.flags = 16;
        Intent intent = new Intent();
        intent.setClassName(ac.getPackageName(), ac.getPackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
        intent.setFlags(335544320);
        PendingIntent activity = PendingIntent.getActivity(ac.getContext(), 0, intent, 134217728);
        if (i == 1) {
            String string = ac.getContext().getString(R.l.eyW);
            Bitmap a2 = com.tencent.mm.ad.b.a(str, false, -1);
            String str2 = Wj + string;
            int i2 = R.g.bEs;
            String string2 = ac.getContext().getString(R.l.eyM);
            int i3 = R.g.bEr;
            String string3 = ac.getContext().getString(R.l.eim);
            Intent intent2 = new Intent();
            intent2.setClassName(ac.getPackageName(), ac.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
            intent2.putExtra("friend_message_transfer_username", str);
            intent2.setAction("friend_message_ignore_" + str);
            PendingIntent activity2 = PendingIntent.getActivity(ac.getContext(), 0, intent2, 134217728);
            intent2 = new Intent();
            intent2.setClassName(ac.getPackageName(), ac.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
            intent2.putExtra("friend_message_transfer_username", str);
            intent2.setAction("friend_message_accept_" + str);
            a = ar.getNotification().a(notification, bXV, activity, Wj, string, str2, a2, i2, string2, activity2, i3, string3, PendingIntent.getActivity(ac.getContext(), 0, intent2, 134217728), str);
        } else {
            String str3;
            String string4 = ac.getContext().getString(R.l.eyV);
            if (Tl > 2) {
                str3 = Wj + ac.getContext().getString(R.l.eyS, new Object[]{Integer.valueOf(Tl)});
            } else {
                str3 = Wj;
            }
            Bitmap decodeResource = BitmapFactory.decodeResource(ac.getContext().getResources(), bXV);
            a = ar.getNotification().a(notification, bXV, 1, activity, str3, string4, str3 + string4, decodeResource, str);
        }
        if (VERSION.SDK_INT >= 16) {
            a.priority = 2;
        }
        if (str != null) {
            WorkerProfile.a(this.fgz, 2130706432 | (str.hashCode() & 16777215));
        } else {
            WorkerProfile.a(this.fgz, 2130706432);
        }
        ar.getNotification().a(WorkerProfile.b(this.fgz), a, false);
        if (Tl == 0) {
            l.hTi = 0;
        } else {
            WorkerProfile.c(this.fgz).append(WorkerProfile.b(this.fgz) + ",");
            ac.getContext().getSharedPreferences("notify_newfriend_prep", 0).edit().putString("notify_newfriend_prep", WorkerProfile.c(this.fgz).toString()).commit();
        }
        return true;
    }
}
