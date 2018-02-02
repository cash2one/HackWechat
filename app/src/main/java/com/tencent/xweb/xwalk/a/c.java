package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.xweb.xwalk.a.a.a;
import com.tencent.xweb.xwalk.a.a.b;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public class c {
    static c AtG;
    static a AtH;

    private c() {
    }

    public static c cJb() {
        if (AtG == null) {
            AtG = new c();
        }
        return AtG;
    }

    public static void Ji(int i) {
        if (NetworkUtil.isNetworkAvailable()) {
            SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
            int i2 = sharedPreferencesForUpdateConfig.getInt("nTryCnt", 0) + 1;
            if (i <= -2 && i >= -5) {
                i2 += 3;
            }
            if (i2 > 3) {
                XWalkInitializer.addXWalkInitializeLog("FailedTooManytimes at this version");
                XWalkInitializer.addXWalkInitializeLog("abandon Current Scheduler");
                a(null);
                return;
            }
            cJh().AtM = i2;
            Editor edit = sharedPreferencesForUpdateConfig.edit();
            edit.putInt("nTryCnt", i2);
            long currentTimeMillis = System.currentTimeMillis() + ((long) (7200000 * i2));
            XWalkInitializer.addXWalkInitializeLog("rescheduler update time after " + ((i2 * 7200000) / 60000) + " minute");
            edit.putLong("nTimeToUpdate", currentTimeMillis);
            edit.commit();
        }
    }

    public static a a(a aVar) {
        if (aVar == null) {
            return null;
        }
        a cJh = cJh();
        if (cJh == null || cJh.Atv == aVar.Atv) {
            return null;
        }
        com.tencent.xweb.xwalk.a.a.c cVar;
        cJh = new a();
        if (aVar == null || aVar.Atw == null || aVar.Atw.length == 0) {
            cVar = null;
        } else {
            int i = VERSION.SDK_INT;
            for (com.tencent.xweb.xwalk.a.a.c cVar2 : aVar.Atw) {
                if (cVar2 != null && cVar2.AtB > XWalkEnvironment.getAvailableVersion() && cVar2.AqK.cIA()) {
                    cVar = cVar2;
                    break;
                }
            }
            XWalkInitializer.addXWalkInitializeLog("no matched version");
            cVar = null;
        }
        if (cVar == null || cVar.AtB <= XWalkEnvironment.getAvailableVersion()) {
            XWalkInitializer.addXWalkInitializeLog("no matched version");
            cJh = null;
        } else {
            XWalkInitializer.addXWalkInitializeLog("got matched version");
            cJh.Atv = aVar.Atv;
            cJh.Atu = cVar.Atu;
            cJh.AtB = cVar.AtB;
            cJh.AtL = cVar.AtE.AtF;
            cJh.AtA = cVar.AtA;
            cJh.bUseCdn = cVar.bUseCdn;
            if (cVar.AtD != null) {
                for (b bVar : cVar.AtD) {
                    if (bVar.Aty == XWalkEnvironment.getAvailableVersion()) {
                        XWalkInitializer.addXWalkInitializeLog("got matched patch");
                        break;
                    }
                }
            }
            XWalkInitializer.addXWalkInitializeLog("no matched patch");
            b bVar2 = null;
            if (bVar2 != null) {
                cJh.AtJ = true;
                cJh.Atz = bVar2.Atz;
                cJh.fel = bVar2.Atu;
                cJh.AtA = bVar2.AtA;
                cJh.bUseCdn = bVar2.bUseCdn;
            } else {
                cJh.AtJ = false;
                cJh.Atz = cVar.Atz;
            }
            i = (int) (Math.random() * ((double) cVar.AtC));
            cJh.AtK = ((long) ((i * 60) * 1000)) + System.currentTimeMillis();
            XWalkInitializer.addXWalkInitializeLog("schedul after " + i + " minute to update");
        }
        if (cJh == null) {
            return null;
        }
        a(cJh);
        return cJh;
    }

    public static boolean cJc() {
        if (!cJd()) {
            return false;
        }
        XWalkInitializer.addXWalkInitializeLog("has scheduler for update");
        return true;
    }

    public static boolean cJd() {
        if (cJh() == null || cJh().Atz == null || cJh().Atz.isEmpty() || cJh().AtB <= XWalkEnvironment.getAvailableVersion()) {
            return false;
        }
        return true;
    }

    public static boolean cJe() {
        if (!cJd()) {
            return false;
        }
        if (System.currentTimeMillis() >= cJh().AtK) {
            XWalkInitializer.addXWalkInitializeLog("time to update");
            return true;
        }
        XWalkInitializer.addXWalkInitializeLog("has scheduler waiting for update, but time is not up");
        return false;
    }

    public static void a(a aVar) {
        AtH = aVar;
        if (aVar == null) {
            AtH = new a();
        }
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putString("strMd5", AtH.Atu);
        edit.putString("strUrl", AtH.Atz);
        edit.putString("strConfigVer", AtH.Atv);
        edit.putBoolean("bIsPatchUpdate", AtH.AtJ);
        edit.putBoolean("bCanUseCellular", AtH.AtA);
        edit.putBoolean("bUseCdn", AtH.bUseCdn);
        edit.putLong("nTimeToUpdate", AtH.AtK);
        edit.putInt("nApkVer", AtH.AtB);
        edit.putInt("nTryCnt", AtH.AtM);
        edit.putString("strPatchMd5", AtH.fel);
        edit.putString("strVersionDetail", AtH.AtL);
        edit.commit();
    }

    public static void cJf() {
        cJh().AtI = System.currentTimeMillis();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", cJh().AtI);
        edit.commit();
    }

    private static boolean L(long j, long j2) {
        if (j > j2 + 7200000 || j + 7200000 < j2) {
            return true;
        }
        XWalkInitializer.addXWalkInitializeLog("the most recent time to fetch config is too close");
        return false;
    }

    public static boolean cJg() {
        if (cJd()) {
            XWalkInitializer.addXWalkInitializeLog("has scheduler , don't need to fetch config");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!L(currentTimeMillis, cJh().AtI)) {
            return false;
        }
        long j = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getLong("nLastFetchConfigTime", 0);
        cJh().AtI = j;
        if (!L(currentTimeMillis, j)) {
            return false;
        }
        XWalkInitializer.addXWalkInitializeLog("enough time after last time fetch config");
        return true;
    }

    public static a cJh() {
        if (AtH != null) {
            return AtH;
        }
        AtH = new a();
        SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
        AtH.AtI = sharedPreferencesForUpdateConfig.getLong("nLastFetchConfigTime", 0);
        if (!sharedPreferencesForUpdateConfig.contains("strUrl")) {
            return AtH;
        }
        AtH.Atu = sharedPreferencesForUpdateConfig.getString("strMd5", null);
        AtH.Atz = sharedPreferencesForUpdateConfig.getString("strUrl", null);
        AtH.Atv = sharedPreferencesForUpdateConfig.getString("strConfigVer", null);
        AtH.AtJ = sharedPreferencesForUpdateConfig.getBoolean("bIsPatchUpdate", false);
        AtH.AtK = sharedPreferencesForUpdateConfig.getLong("nTimeToUpdate", 0);
        AtH.AtB = sharedPreferencesForUpdateConfig.getInt("nApkVer", 0);
        AtH.AtM = sharedPreferencesForUpdateConfig.getInt("nTryCnt", 0);
        AtH.fel = sharedPreferencesForUpdateConfig.getString("strPatchMd5", null);
        AtH.AtL = sharedPreferencesForUpdateConfig.getString("strVersionDetail", null);
        AtH.AtA = sharedPreferencesForUpdateConfig.getBoolean("bCanUseCellular", false);
        AtH.bUseCdn = sharedPreferencesForUpdateConfig.getBoolean("bUseCdn", false);
        return AtH;
    }
}
