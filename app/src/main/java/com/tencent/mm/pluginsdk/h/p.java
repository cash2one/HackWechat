package com.tencent.mm.pluginsdk.h;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.c.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.c.bns;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.List;

public final class p {
    private static final long[] vfY = new long[]{0, 259200000, 604800000};
    private static String vfZ = "tinker-boots-install-info";
    private static String vga = "tinker-boots-last-show";
    private static String vgb = "tinker-boots-show-time";
    private static String vgc = "";

    public static String bYY() {
        return ac.getContext().getSharedPreferences("update_config_prefs", 4).getString("update_downloaded_pack_md5_key", null);
    }

    public static int bYZ() {
        return ac.getContext().getSharedPreferences("update_config_prefs", 4).getInt("update_downloaded_pack_update_type", 3);
    }

    public static boolean bZa() {
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("update_config_prefs", 4);
        long j = sharedPreferences.getLong("update_downloaded_cancel_ts", 0);
        int i = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        x.i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (i > vfY.length - 1) {
            return true;
        }
        if (System.currentTimeMillis() - j > vfY[i]) {
            return false;
        }
        if (System.currentTimeMillis() - j >= 0) {
            return true;
        }
        x.e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
        ac.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
        x.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
        return true;
    }

    public static boolean bZb() {
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("update_config_prefs", 4);
        long j = sharedPreferences.getLong("update_downloading_in_silence", 0);
        boolean z = sharedPreferences.getBoolean("update_download_start_one_immediate", false);
        x.i("MicroMsg.UpdateUtil", "hasUnfinishDownloadingInSilence unfinish %s", new Object[]{Long.valueOf(j)});
        if (z || (j != 0 && System.currentTimeMillis() - j > 3600000)) {
            return true;
        }
        return false;
    }

    public static String ek(Context context) {
        String el = el(context);
        if (el == null || !new File(el).exists()) {
            return null;
        }
        a cg = a.cg(el);
        return (cg == null || cg.fdP == null) ? g.bV(el) : cg.fdP.apkMd5;
    }

    public static String el(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
            return null;
        }
    }

    public static void ba(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static bns bZc() {
        bns com_tencent_mm_protocal_c_bns;
        Throwable e;
        String string = ac.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString(vfZ, "");
        if (bh.ov(string)) {
            com_tencent_mm_protocal_c_bns = null;
        } else {
            bns com_tencent_mm_protocal_c_bns2;
            try {
                com_tencent_mm_protocal_c_bns2 = new bns();
                try {
                    com_tencent_mm_protocal_c_bns = (bns) com_tencent_mm_protocal_c_bns2.aF(Base64.decode(string, 0));
                } catch (Exception e2) {
                    e = e2;
                    x.printErrStackTrace("MicroMsg.UpdateUtil", e, "parse tinker install failed.", new Object[0]);
                    com_tencent_mm_protocal_c_bns = com_tencent_mm_protocal_c_bns2;
                    if (com_tencent_mm_protocal_c_bns == null) {
                        return com_tencent_mm_protocal_c_bns;
                    }
                    x.i("MicroMsg.UpdateUtil", "update info is null.");
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                com_tencent_mm_protocal_c_bns2 = null;
                x.printErrStackTrace("MicroMsg.UpdateUtil", e, "parse tinker install failed.", new Object[0]);
                com_tencent_mm_protocal_c_bns = com_tencent_mm_protocal_c_bns2;
                if (com_tencent_mm_protocal_c_bns == null) {
                    return com_tencent_mm_protocal_c_bns;
                }
                x.i("MicroMsg.UpdateUtil", "update info is null.");
                return null;
            }
        }
        if (com_tencent_mm_protocal_c_bns == null) {
            return com_tencent_mm_protocal_c_bns;
        }
        x.i("MicroMsg.UpdateUtil", "update info is null.");
        return null;
    }

    public static boolean bZd() {
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("tinker_patch_share_config", 4);
        long j = sharedPreferences.getLong(vga, 0);
        int i = sharedPreferences.getInt(vgb, 0);
        x.d("MicroMsg.UpdateUtil", "isNeedShowTinkerDialog now:%d last:%d time:%d", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(j), Integer.valueOf(i)});
        if (System.currentTimeMillis() - j <= 21600000 || i >= 3) {
            return false;
        }
        return true;
    }

    public static void bZe() {
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("tinker_patch_share_config", 4);
        sharedPreferences.edit().putLong(vga, System.currentTimeMillis()).apply();
        sharedPreferences.edit().putInt(vgb, sharedPreferences.getInt(vgb, 0) + 1).apply();
    }

    public static void a(bns com_tencent_mm_protocal_c_bns) {
        try {
            ac.getContext().getSharedPreferences("tinker_patch_share_config", 4).edit().putString(vfZ, Base64.encodeToString(com_tencent_mm_protocal_c_bns.toByteArray(), 0)).apply();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
        }
        x.d("MicroMsg.UpdateUtil", "save tinker install update info.");
    }

    public static void bZf() {
        x.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("tinker_patch_share_config", 4);
        sharedPreferences.edit().putString(vfZ, "").apply();
        sharedPreferences.edit().putLong(vga, 0).apply();
        sharedPreferences.edit().putInt(vgb, 0).apply();
    }

    public static void bZg() {
        ar.Dm().F(new 1());
    }

    public static String bZh() {
        if (bh.ov(vgc)) {
            vgc = e.gHs + "bsdiff/";
        }
        return vgc;
    }

    public static String RP(String str) {
        return bZh() + str + ".apk";
    }

    public static String[] bZi() {
        int i = 0;
        if (r.idc == null || r.idc.length() <= 0) {
            String string = ac.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List To = n.To(string);
            String[] strArr = new String[To.size()];
            while (i < To.size()) {
                strArr[i] = ((n) To.get(i)).nQt;
                i++;
            }
            return strArr;
        }
        return new String[]{r.idc};
    }
}
