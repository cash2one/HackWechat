package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.network.a.a.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public class WatchDogPushReceiver extends BroadcastReceiver {
    private static String className = "";

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.WatchDogPushReceiver", "onReceive intent == null");
            return;
        }
        int intExtra = intent.getIntExtra(DownloadSettingTable$Columns.TYPE, 0);
        x.d("MicroMsg.WatchDogPushReceiver", "onReceive type:" + intExtra);
        if (intExtra == 1) {
            a aVar = new a();
            aVar.rtType = (long) intent.getIntExtra("rtType", 0);
            aVar.beginTime = intent.getLongExtra("beginTime", 0);
            aVar.endTime = intent.getLongExtra("endTime", 0);
            boolean booleanExtra = intent.getBooleanExtra("isSend", false);
            if (booleanExtra) {
                aVar.ibt = intent.getLongExtra("dataLen", 0);
            } else {
                aVar.ibu = intent.getLongExtra("dataLen", 0);
            }
            aVar.hRA = intent.getLongExtra("cost", 0);
            aVar.ibv = intent.getLongExtra("doSceneCount", 0);
            x.d("MicroMsg.WatchDogPushReceiver", "onRecv: rtType:" + aVar.rtType + " isSend:" + booleanExtra + " tx:" + aVar.ibt + " rx:" + aVar.ibu + " begin:" + aVar.beginTime + " end:" + aVar.endTime);
            if (aVar.ibv == 0 || aVar.rtType == 0 || aVar.beginTime == 0 || aVar.endTime == 0 || aVar.endTime - aVar.beginTime <= 0) {
                x.w("MicroMsg.WatchDogPushReceiver", "onRecv: count:" + aVar.ibv + " rtType:" + aVar.rtType + " begin:" + aVar.beginTime + " end:" + aVar.endTime);
            }
        } else if (intExtra != 2 && intExtra != 3 && intExtra != 4) {
            if (intExtra == 5 && b.ceK()) {
                if (intent.getIntExtra("jni", 1) == 1) {
                    Assert.assertTrue("test errlog push " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
                } else {
                    MMProtocalJni.setClientPackVersion(-1);
                }
            } else if (intExtra == 6) {
                x.cfk();
            }
        }
    }

    private static String getClassName() {
        if (bh.ov(className)) {
            className = ac.getPackageName() + ".modelstat.WatchDogPushReceiver";
        }
        return className;
    }

    public static void a(h hVar) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(ac.getPackageName(), getClassName()));
        intent.putExtra(DownloadSettingTable$Columns.TYPE, 1);
        intent.putExtra("rtType", hVar.rtType);
        intent.putExtra("beginTime", hVar.beginTime);
        intent.putExtra("endTime", hVar.endTime);
        intent.putExtra("rtType", hVar.rtType);
        intent.putExtra("dataLen", hVar.hRy);
        intent.putExtra("isSend", hVar.fLH);
        intent.putExtra("cost", hVar.hRA);
        intent.putExtra("doSceneCount", hVar.hRz);
        ac.getContext().sendBroadcast(intent);
    }

    public static void Th() {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(ac.getPackageName(), getClassName()));
        intent.putExtra(DownloadSettingTable$Columns.TYPE, 3);
        ac.getContext().sendBroadcast(intent);
    }

    public static void iF(int i) {
        if (b.ceK()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.WatchDogPushReceiver");
            intent.setComponent(new ComponentName(ac.getPackageName(), getClassName()));
            intent.putExtra(DownloadSettingTable$Columns.TYPE, 5);
            intent.putExtra("jni", i);
            ac.getContext().sendBroadcast(intent);
        }
    }

    public static void Ti() {
        if (b.ceK()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.WatchDogPushReceiver");
            intent.setComponent(new ComponentName(ac.getPackageName(), getClassName()));
            intent.putExtra(DownloadSettingTable$Columns.TYPE, 7);
            ac.getContext().sendBroadcast(intent);
        }
    }
}
