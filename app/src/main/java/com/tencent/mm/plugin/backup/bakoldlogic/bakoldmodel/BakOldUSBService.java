package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.protocal.c.abb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BakOldUSBService extends Service implements e {
    private boolean kof = false;
    private int kqj = -1;

    public IBinder onBind(Intent intent) {
        x.i("MicroMsg.BakOldUSBService", "onBind()");
        return null;
    }

    public void onCreate() {
        x.i("MicroMsg.BakOldUSBService", "onCreate()");
        super.onCreate();
        ar.CG().a(595, this);
        b.a(1, (e) this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        x.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", new Object[]{Integer.valueOf(this.kqj)});
        if (intent == null) {
            x.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
        } else {
            String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (bh.ov(stringExtra)) {
                x.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
                stopSelf();
            } else {
                this.kof = intent.getBooleanExtra("isFromWifi", false);
                x.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", new Object[]{stringExtra, Boolean.valueOf(this.kof)});
                a.aql().aqn().HT();
                c aqn = a.aql().aqn();
                if (this.kof) {
                    i3 = 2;
                }
                aqn.kqB = i3;
                if (ar.Hi()) {
                    ar.CG().a(new f(stringExtra), 0);
                } else {
                    x.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
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
        x.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
    }

    private boolean aqj() {
        return this.kqj == 0 || this.kqj == 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.BakOldUSBService";
        String str3 = "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = kVar == null ? "" : kVar.getClass().getSimpleName();
        objArr[4] = Integer.valueOf(this.kqj);
        x.i(str2, str3, objArr);
        if (kVar instanceof b) {
            x.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(this.kqj)});
            if (kVar.getType() == 1 && i == 0 && i2 == 0) {
                boolean z;
                Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                str3 = "newPCBackup";
                if (aqj()) {
                    z = false;
                } else {
                    z = true;
                }
                className.putExtra(str3, z);
                startActivity(className);
            }
            stopSelf();
        } else if (!(kVar instanceof f)) {
        } else {
            if (i == 0 && i2 == 0) {
                abb aqE = ((f) kVar).aqE();
                a.aql().kiB = aqE.ID;
                a.aql().kiC = aqE.vJY;
                a.aql().kiD = aqE.vJZ;
                this.kqj = aqE.rYW;
                x.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", new Object[]{Integer.valueOf(aqE.ktN), Integer.valueOf(aqE.rYW), Boolean.valueOf(this.kof)});
                if (!this.kof && aqE.ktN == 1) {
                    x.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
                    stopSelf();
                    return;
                } else if (aqj()) {
                    a.aql().aqm().bH(aqE.vJQ, aqE.vJR);
                    b.a(a.aql().aqm());
                    b.a(a.aql().aqo());
                    b.mA(1);
                    a.aql().aqo().b(aqE.ktN, aqE.vJP);
                    return;
                } else {
                    x.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", new Object[]{Integer.valueOf(this.kqj)});
                    return;
                }
            }
            a.aql().aqn().kqC = 2;
            a.aql().aqn().HT();
            if (i == 4 && i2 == -2011) {
                x.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
            } else {
                x.i("MicroMsg.BakOldUSBService", "getConnect info other error");
            }
            a.aql().aqm();
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.aqv();
            stopSelf();
        }
    }

    public boolean stopService(Intent intent) {
        x.i("MicroMsg.BakOldUSBService", "stopService.");
        return super.stopService(intent);
    }
}
