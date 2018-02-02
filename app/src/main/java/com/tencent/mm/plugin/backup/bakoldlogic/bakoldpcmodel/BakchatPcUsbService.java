package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.protocal.c.abb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BakchatPcUsbService extends Service implements e {
    private boolean kof = false;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        x.i("MicroMsg.BakchatPcUsbService", "onCreate()");
        super.onCreate();
        ar.CG().a(595, this);
        b.a(1, this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        x.i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
        if (intent == null) {
            x.w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
        } else {
            String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (bh.ov(stringExtra)) {
                x.e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
                stopSelf();
            } else {
                this.kof = intent.getBooleanExtra("isFromWifi", false);
                x.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b", new Object[]{stringExtra, Boolean.valueOf(this.kof)});
                a.aql().aqn().HT();
                c aqn = a.aql().aqn();
                if (this.kof) {
                    i3 = 2;
                }
                aqn.kqB = i3;
                if (ar.Hi()) {
                    ar.CG().a(new f(stringExtra), 0);
                } else {
                    x.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                }
            }
        }
        return 2;
    }

    public void onDestroy() {
        ar.CG().b(595, this);
        b.b(1, this);
        super.onDestroy();
        x.i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof b) {
            if (kVar.getType() == 1 && i == 0 && i2 == 0) {
                Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                startActivity(className);
            }
            stopSelf();
        } else if (!(kVar instanceof f)) {
        } else {
            if (i == 0 && i2 == 0) {
                abb aqE = ((f) kVar).aqE();
                if (this.kof) {
                    x.i("MicroMsg.BakchatPcUsbService", "from wifi, reconnect");
                    a.aql().aqo().aqp();
                }
                if (this.kof || aqE.ktN != 1) {
                    a.aql().kiB = aqE.ID;
                    a.aql().kiC = aqE.vJY;
                    a.aql().kiD = aqE.vJZ;
                    a.aql().aqm().bH(aqE.vJQ, aqE.vJR);
                    b.a(a.aql().aqm());
                    b.a(a.aql().aqo());
                    b.mA(1);
                    a.aql().aqo().b(aqE.ktN, aqE.vJP);
                    return;
                }
                x.e("MicroMsg.BakchatPcUsbService", "broast from usb but type is wifi, url may be fake!!!!");
                stopSelf();
                return;
            }
            a.aql().aqn().kqC = 2;
            a.aql().aqn().HT();
            if (i == 4 && i2 == -2011) {
                x.i("MicroMsg.BakchatPcUsbService", "getConnect info: INVALID URL");
            } else {
                x.i("MicroMsg.BakchatPcUsbService", "getConnect info other error");
            }
            a.aql().aqm();
            e.aqv();
            stopSelf();
        }
    }
}
