package com.tencent.mm.plugin.music.model.notification;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.tencent.mm.av.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.music.model.g.c;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.music.model.notification.a.2;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class MMMusicPlayerService extends Service {
    a oMb;
    Runnable oMc = new 1(this);

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.Music.MMMusicPlayerService", "onCreate");
        x.i("MicroMsg.Music.MMMusicPlayerService", "init");
        this.oMb = new a();
        a aVar = this.oMb;
        x.i("MicroMsg.Music.MMMusicNotification", "init");
        aVar.oLT = this;
        aVar.oLU = (NotificationManager) getSystemService("notification");
        aVar.oLW = new 2(aVar);
        registerReceiver(aVar.oLW, new IntentFilter("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK"));
        aVar.isInit = true;
        refresh();
    }

    final void refresh() {
        x.i("MicroMsg.Music.MMMusicPlayerService", "initNotification");
        a bdo = h.bdz().bdo();
        if (bdo == null) {
            x.e("MicroMsg.Music.MMMusicPlayerService", "initNotification music is null, return");
        } else if (bh.ov(bdo.field_protocol)) {
            c bdn = h.bdz().bdn();
            if (bdn == null) {
                x.e("MicroMsg.Music.MMMusicPlayerService", "musicPlayer is null, return");
            } else if (bdn.Qq()) {
                k(bdo);
            } else if (bdn.bdO()) {
                l(bdo);
            }
        } else {
            x.e("MicroMsg.Music.MMMusicPlayerService", "exoplayer play audio, ingore");
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public final void k(a aVar) {
        x.i("MicroMsg.Music.MMMusicPlayerService", "play");
        if (aVar == null) {
            x.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
            return;
        }
        ag.K(this.oMc);
        a aVar2 = this.oMb;
        if (!aVar2.isInit) {
            x.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, play err");
        } else if (aVar2.oLT == null) {
            x.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
        } else {
            x.i("MicroMsg.Music.MMMusicNotification", "play");
            ag.K(aVar2.oLV);
            aVar2.oLT.startForeground(JsApiCreateAudioInstance.CTRL_INDEX, aVar2.a(aVar2.oLT, aVar, true));
        }
    }

    public final void l(a aVar) {
        x.i("MicroMsg.Music.MMMusicPlayerService", "pause");
        if (aVar == null) {
            x.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
            return;
        }
        ag.K(this.oMc);
        a aVar2 = this.oMb;
        if (!aVar2.isInit) {
            x.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, pause err");
        } else if (aVar2.oLT == null) {
            x.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
        } else {
            x.i("MicroMsg.Music.MMMusicNotification", "pause");
            ag.K(aVar2.oLV);
            aVar2.oLU.notify(JsApiCreateAudioInstance.CTRL_INDEX, aVar2.a(aVar2.oLT, aVar, false));
        }
    }

    public final void stop() {
        x.i("MicroMsg.Music.MMMusicPlayerService", "stop");
        a aVar = this.oMb;
        if (!aVar.isInit) {
            x.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
        } else if (aVar.oLT == null) {
            x.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
        } else {
            x.i("MicroMsg.Music.MMMusicNotification", "close");
            ag.K(aVar.oLV);
            ag.h(aVar.oLV, 1000);
        }
        ag.K(this.oMc);
        ag.h(this.oMc, 60000);
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.Music.MMMusicPlayerService", "onDestroy");
        a aVar = this.oMb;
        x.i("MicroMsg.Music.MMMusicNotification", "uninit");
        aVar.oLT.unregisterReceiver(aVar.oLW);
        aVar.oLW = null;
        aVar.oLT = null;
        aVar.oLU = null;
        aVar.isInit = false;
    }

    public IBinder onBind(Intent intent) {
        return new a(this);
    }
}
