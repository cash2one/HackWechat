package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.k.g;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class SubCoreGameCenter$1 implements j {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$1(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
    }

    public final boolean aRk() {
        try {
            boolean z;
            i aQb = i.aQb();
            if (aQb.nbF != null) {
                z = aQb.nbF.nhI;
            } else {
                aQb.XH();
                x.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", new Object[]{w.d(ac.getContext().getSharedPreferences(ac.cfs(), 0))});
                x.i("MicroMsg.GameConfigManager", "hide game center:[%s]", new Object[]{bh.az(g.zY().getValue("HideGameCenter"), "zh_CN".equals(w.d(ac.getContext().getSharedPreferences(ac.cfs(), 0))) ? "0" : "1")});
                z = r0.equalsIgnoreCase("0");
            }
            x.i("MicroMsg.GameConfigManager", "getShowEntrance : " + z);
            return z;
        } catch (Exception e) {
            return true;
        }
    }

    public final void a(String str, String str2, int i, int i2, String str3, int i3) {
        ap.a(str, str2, i, i2, str3, i3);
    }

    public final void a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
        ap.a(context, str, str2, str3, i, str4, i2);
    }

    public final void a(String str, String str2, int i, int i2, String str3, long j) {
        ap.a(str, str2, i, i2, str3, j);
    }

    public final void I(String str, int i, int i2) {
        ap.h(str, 1, i, i2);
    }

    public final void M(String str, String str2, String str3) {
        ap.M(str, str2, str3);
    }

    public final void o(Context context, String str, String str2) {
        ap.o(context, str, str2);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, long j, String str5) {
        ap.a(context, str, str2, str3, i, i2, i3, str4, 0, str5);
    }

    public final void cQ(Context context) {
        context.getSharedPreferences("game_center_pref", 0).edit().putString("notified_game_for_yyb_download_key", "").commit();
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("total_notify_times_for_yyb_download_key", 0).commit();
        context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("delete_message_by_time_key", false).commit();
    }
}
