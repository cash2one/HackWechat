package com.tencent.mm.platformtools;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Time;
import com.tencent.mm.bm.a;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.k.f;
import com.tencent.mm.platformtools.l.3;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e$f;
import com.tencent.mm.z.ar;

class l$1 implements a {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ String hMZ;
    final /* synthetic */ String icw;
    final /* synthetic */ String icx;
    final /* synthetic */ int icy;
    final /* synthetic */ String val$jumpUrl;

    public l$1(String str, String str2, Bundle bundle, String str3, String str4, int i) {
        this.val$jumpUrl = str;
        this.icw = str2;
        this.fhp = bundle;
        this.icx = str3;
        this.hMZ = str4;
        this.icy = i;
    }

    public final void onDone() {
        Time time = new Time();
        time.setToNow();
        if (com.tencent.mm.k.a.aN(time.hour, time.minute)) {
            try {
                Context context = ac.getContext();
                boolean zt = f.zt();
                boolean zr = f.zr();
                x.d("MiroMsg.NotificationUtil", "shake " + zt + "sound " + zr);
                if (zt) {
                    x.i("MiroMsg.NotificationUtil", "notification.shake:  notifyEngageRemind isShake~: true");
                    bh.m(context, true);
                }
                if (zr) {
                    String zs = f.zs();
                    Uri defaultUri = zs == e$f.gHY ? RingtoneManager.getDefaultUri(2) : Uri.parse(zs);
                    MediaPlayer jVar = new j();
                    try {
                        jVar.setDataSource(context, defaultUri);
                        jVar.setOnCompletionListener(new 3());
                        if (ar.Hh().getStreamVolume(5) != 0) {
                            if (ar.Hh().xR()) {
                                int streamVolume = ar.Hh().getStreamVolume(8);
                                int streamMaxVolume = ar.Hh().getStreamMaxVolume(8);
                                int streamVolume2 = ar.Hh().getStreamVolume(5);
                                if (streamVolume2 <= streamMaxVolume) {
                                    streamMaxVolume = streamVolume2;
                                }
                                ar.Hh().aM(8, streamMaxVolume);
                                jVar.setAudioStreamType(8);
                                jVar.setLooping(true);
                                jVar.prepare();
                                jVar.setLooping(false);
                                jVar.start();
                                ar.Hh().aM(8, streamVolume);
                                x.d("MiroMsg.NotificationUtil", "oldVolume is %d, toneVolume is %d", new Object[]{Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume)});
                            } else {
                                jVar.setAudioStreamType(5);
                                jVar.setLooping(true);
                                jVar.prepare();
                                jVar.setLooping(false);
                                jVar.start();
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MiroMsg.NotificationUtil", e, "", new Object[0]);
                    }
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MiroMsg.NotificationUtil", e2, "", new Object[0]);
            }
        } else {
            x.i("MiroMsg.NotificationUtil", "no shake & sound notification during background deactive time");
        }
        Intent intent = new Intent();
        intent.setClassName(ac.getPackageName(), ac.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", this.val$jumpUrl);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.setFlags(872415232);
        x.d("MiroMsg.NotificationUtil", "bizFrom: %s, data: %s", new Object[]{this.icw, this.fhp});
        if (!(this.icw == null || this.fhp == null)) {
            intent.putExtra("bizofstartfrom", this.icw);
            intent.putExtra("startwebviewparams", this.fhp);
        }
        Notification notification = new Builder(ac.getContext()).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.icx).setContentText(this.hMZ).setContentIntent(PendingIntent.getActivity(ac.getContext(), 0, intent, 134217728)).getNotification();
        notification.icon = com.tencent.mm.bl.a.bXV();
        notification.flags |= 16;
        ((NotificationManager) ac.getContext().getSystemService("notification")).notify(this.icy, notification);
    }
}
