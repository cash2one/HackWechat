package com.tencent.mm.plugin.game.model;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.game.model.ao.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public class GameCrossProcessReportReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.GameCrossProcessReportReceiver", "onReceive intent == null");
        } else if ("com.tencent.mm.game.report.GameCrossProcessReportReceiver".equals(intent.getAction())) {
            al(intent.getIntExtra("LOGID_KEY", 0), intent.getStringExtra("LOGEXT_KEY"));
        }
    }

    private static void al(int i, String str) {
        x.i("MicroMsg.GameCrossProcessReportReceiver", "game cross process report, logId:%d, logExt:%s", new Object[]{Integer.valueOf(i), str});
        SubCoreGameCenter.aRf().a(new a(i, str));
    }

    public static void H(int i, String str) {
        if (ac.cfw()) {
            al(i, str);
            return;
        }
        String str2 = ac.getPackageName() + ".plugin.game.model.GameCrossProcessReportReceiver";
        Intent intent = new Intent("com.tencent.mm.game.report.GameCrossProcessReportReceiver");
        intent.setComponent(new ComponentName(ac.getPackageName(), str2));
        intent.putExtra("LOGID_KEY", i);
        intent.putExtra("LOGEXT_KEY", str);
        ac.getContext().sendBroadcast(intent);
    }
}
