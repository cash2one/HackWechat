package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    public static boolean ag(Context context, String str) {
        String string = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_before_install", "");
        x.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isBeforeDownloadDialogHaveCancel current patchID :%s patchID:%s", new Object[]{string, str});
        if (bh.ov(string) || bh.ov(str) || !string.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static void ah(Context context, String str) {
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_before_install", str).apply();
    }

    public static void cV(Context context) {
        int i = com.tencent.mm.k.g.zY().getInt("TinkerCheckUpdateInterval", 12);
        if (i < 0) {
            x.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours < 0 ");
            return;
        }
        x.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours:%d", new Object[]{Integer.valueOf(i)});
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("check_tinker_update_interval", i).apply();
    }

    public static int cW(Context context) {
        return context.getSharedPreferences("tinker_patch_share_config", 4).getInt("check_tinker_update_interval", 12);
    }

    public static void ai(Context context, String str) {
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_node", str).apply();
    }

    public static void E(Context context, int i) {
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("tinker_node_retry_time", i).apply();
    }

    public static void g(Context context, long j) {
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putLong("tinker_delay_download", j).apply();
    }
}
