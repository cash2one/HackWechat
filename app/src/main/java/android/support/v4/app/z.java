package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.aa.a;
import android.widget.RemoteViews;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;

public final class z {
    private static final i rR;

    protected static class e {
        protected e() {
        }
    }

    static class j extends q {
        j() {
        }

        public Notification b(d dVar) {
            y aVar = new a(dVar.mContext, dVar.sx, dVar.rY, dVar.rZ, dVar.sf, dVar.sd, dVar.sg, dVar.sa, dVar.sc, dVar.se, dVar.sl, dVar.sm, dVar.sn, dVar.sh, dVar.si, dVar.mPriority, dVar.sk, dVar.ss, dVar.sy, dVar.mExtras, dVar.so, dVar.sp, dVar.sq);
            z.a((x) aVar, dVar.sr);
            z.a(aVar, dVar.sj);
            return aVar.build();
        }
    }

    static class n extends l {
        n() {
        }

        public final Notification b(d dVar) {
            Context context = dVar.mContext;
            Notification notification = dVar.sx;
            CharSequence charSequence = dVar.rY;
            CharSequence charSequence2 = dVar.rZ;
            CharSequence charSequence3 = dVar.sf;
            RemoteViews remoteViews = dVar.sd;
            int i = dVar.sg;
            PendingIntent pendingIntent = dVar.sa;
            return new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.sc, (notification.flags & FileUtils.S_IWUSR) != 0).setLargeIcon(dVar.se).setNumber(i).getNotification();
        }
    }

    static /* synthetic */ void a(x xVar, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            xVar.a((a) it.next());
        }
    }

    static /* synthetic */ void a(y yVar, r rVar) {
        if (rVar == null) {
            return;
        }
        if (rVar instanceof c) {
            c cVar = (c) rVar;
            ae.a(yVar, cVar.sK, cVar.sM, cVar.sL, cVar.rX);
        } else if (rVar instanceof h) {
            h hVar = (h) rVar;
            ae.a(yVar, hVar.sK, hVar.sM, hVar.sL, hVar.sJ);
        } else if (rVar instanceof b) {
            b bVar = (b) rVar;
            ae.a(yVar, bVar.sK, bVar.sM, bVar.sL, bVar.rU, bVar.rV, bVar.rW);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            rR = new k();
        } else if (VERSION.SDK_INT >= 20) {
            rR = new j();
        } else if (VERSION.SDK_INT >= 19) {
            rR = new q();
        } else if (VERSION.SDK_INT >= 16) {
            rR = new p();
        } else if (VERSION.SDK_INT >= 14) {
            rR = new o();
        } else if (VERSION.SDK_INT >= 11) {
            rR = new n();
        } else if (VERSION.SDK_INT >= 9) {
            rR = new m();
        } else {
            rR = new l();
        }
    }

    public static Bundle a(Notification notification) {
        return rR.a(notification);
    }
}
