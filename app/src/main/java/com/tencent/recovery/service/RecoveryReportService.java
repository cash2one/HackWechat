package com.tencent.recovery.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.recovery.util.Util;

public class RecoveryReportService extends IntentService {
    public RecoveryReportService() {
        super(RecoveryReportService.class.getName());
    }

    protected void onHandleIntent(Intent intent) {
        an(intent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void an(Intent intent) {
        Object obj = null;
        synchronized (this) {
            String stringExtra;
            String str = null;
            try {
                stringExtra = intent.getStringExtra("KeyReportType");
            } catch (Exception e) {
                stringExtra = str;
            }
            if (!Util.ov(stringExtra)) {
                RecoveryLog.i("Recovery.RecoveryReportService", "handle report intent %s %s", stringExtra, intent.getStringExtra("KeyReportUploadClassName"));
                switch (stringExtra.hashCode()) {
                    case -1125171110:
                        if (stringExtra.equals("HandleStatus")) {
                            break;
                        }
                    case 2120497953:
                        if (stringExtra.equals("ProcessStatus")) {
                            int i = 1;
                            break;
                        }
                }
                obj = -1;
                switch (obj) {
                    case null:
                        RecoveryReporter.c(this, stringExtra, intent.getParcelableArrayListExtra("KeyReportItem"));
                        break;
                    case 1:
                        RecoveryReporter.a((Context) this, stringExtra, (RecoveryStatusItem) intent.getParcelableExtra("KeyReportItem"));
                        break;
                }
                RecoveryUploadService.startAlarm(this, r4);
                stopSelf();
            }
        }
    }

    public void onDestroy() {
        RecoveryLog.cDj();
        super.onDestroy();
    }
}
