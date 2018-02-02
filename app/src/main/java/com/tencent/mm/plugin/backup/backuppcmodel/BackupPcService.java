package com.tencent.mm.plugin.backup.backuppcmodel;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService;
import com.tencent.mm.plugin.backup.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BackupPcService extends Service {
    private boolean kof = false;
    private boolean kog = false;

    public void onCreate() {
        x.i("MicroMsg.BackupPcService", "onCreate.");
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.BackupPcService", "onStartCommand.");
        if (intent == null) {
            x.w("MicroMsg.BackupPcService", "onStartCommand intent is null");
        } else {
            final String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (bh.ov(stringExtra)) {
                x.e("MicroMsg.BackupPcService", "onStartCommand url is null");
                stopSelf();
            } else if (stringExtra.contains("mm.gj.qq.com")) {
                x.i("MicroMsg.BackupPcService", "onStartCommand url from gj stop and start BakOldUSBService");
                startService(new Intent(this, BakOldUSBService.class).putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL)).putExtra("isFromWifi", true));
                stopSelf();
            } else {
                this.kof = intent.getBooleanExtra("isFromWifi", false);
                this.kog = intent.getBooleanExtra("isMove", false);
                x.i("MicroMsg.BackupPcService", "onStartCommand Broadcast url:%s, isFromWifi:%b, isMove:%b", new Object[]{stringExtra, Boolean.valueOf(this.kof), Boolean.valueOf(this.kog)});
                if (this.kog || ar.Hi()) {
                    ag.y(new Runnable(this) {
                        final /* synthetic */ BackupPcService koh;

                        public final void run() {
                            c apt = b.aps().apt();
                            x.w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", new Object[]{stringExtra});
                            d.mA(1);
                            ar.Hg();
                            apt.knJ = ((Integer) c.CU().get(a.xtc, Integer.valueOf(0))).intValue();
                            b.aps();
                            Editor edit = b.aoq().edit();
                            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
                            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
                            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
                            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
                            edit.commit();
                            apt.knK = true;
                            ar.CG().a(595, apt.klp);
                            ar.CG().a(new e(r2), 0);
                        }
                    });
                } else {
                    x.e("MicroMsg.BackupPcService", "onStartCommand onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                }
            }
        }
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.BackupPcService", "onDestroy thread:" + Thread.currentThread().getName());
    }
}
