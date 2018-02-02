package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.mm.app.e.a;
import com.tencent.mm.az.i;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public final class g {
    public static void run() {
        SharedPreferences sharedPreferences;
        int i;
        Context context = ac.getContext();
        a 1 = new 1();
        if (context != null) {
            try {
                sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                String[] split = sharedPreferences.getString("crashlist", "").split(";");
                if (split != null && split.length > 0) {
                    Editor edit = sharedPreferences.edit();
                    edit.putString("crashlist", "");
                    edit.commit();
                    for (i = 0; i < split.length; i++) {
                        String[] split2 = split[i] == null ? null : split[i].split(",");
                        if (split2 != null && split2.length >= 2) {
                            if (split2[1].equals("anr")) {
                                1.eo(10);
                            } else {
                                1.eo(11);
                                if ("com.tencent.mm".equals(split2[0])) {
                                    1.eo(14);
                                }
                                if ("com.tencent.mm:push".equals(split2[0])) {
                                    1.eo(17);
                                }
                                if ("com.tencent.mm:tools".equals(split2[0])) {
                                    1.eo(20);
                                }
                                if (split2[1].equals("java")) {
                                    1.eo(12);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        1.eo(15);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        1.eo(18);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        1.eo(21);
                                    }
                                }
                                if (split2[1].equals("jni")) {
                                    1.eo(13);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        1.eo(16);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        1.eo(19);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        1.eo(22);
                                    }
                                }
                                if (split2[1].equals("first")) {
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        1.eo(23);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        1.eo(24);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        1.eo(25);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        context = ac.getContext();
        i = com.tencent.mm.k.g.zY().getInt("AndroidGooglePlayCrashUploadSizeLimit", 3072);
        if (context != null && i > 0) {
            try {
                sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                if (sharedPreferences.getInt("googleplaysizelimit", 3072) != i) {
                    edit = sharedPreferences.edit();
                    edit.putInt("googleplaysizelimit", i);
                    edit.commit();
                }
            } catch (Throwable th2) {
            }
        }
        ar.Hg();
        if (t.bz(t.d((Long) c.CU().get(w.a.xmJ, null))) > 21600000) {
            com.tencent.mm.plugin.report.service.g.pQN.a(279, (long) (com.tencent.mm.k.g.zY().getInt("AndroidDynamicConfigVer", 0) % 16), 1, false);
            ar.Hg();
            c.CU().a(w.a.xmJ, Long.valueOf(t.Wp()));
        }
        ar.Hg();
        if (t.bz(t.d((Long) c.CU().get(w.a.xmK, null))) > 21600000) {
            ar.Hg();
            c.CU().a(w.a.xmK, Long.valueOf(t.Wp()));
            s TU = o.TU();
            int[] iArr = new int[]{0, 0, 0, 0, 0, 0};
            try {
                x.i("MicroMsg.VideoInfoStorage", "reportVideoMsgCount sql:%s", new Object[]{"select status, videofuncflag, human from videoinfo2 where lastmodifytime > " + (bh.Wo() - 21600)});
                Cursor a = TU.hhp.a(r2, null, 2);
                while (a.moveToNext()) {
                    int i2 = a.getInt(0);
                    int i3 = a.getInt(1);
                    String string = a.getString(2);
                    if (111 == i2) {
                        if (i3 == 3) {
                            i2 = 0;
                        } else {
                            i2 = 3;
                        }
                        iArr[i2] = iArr[i2] + 1;
                    } else if (199 != i2) {
                        continue;
                    } else if (q.FS().equals(string)) {
                        i2 = i3 == 3 ? 1 : 4;
                        iArr[i2] = iArr[i2] + 1;
                    } else {
                        i2 = i3 == 3 ? 2 : 5;
                        iArr[i2] = iArr[i2] + 1;
                    }
                }
                a.close();
                com.tencent.mm.plugin.report.service.g.pQN.h(12696, new Object[]{Integer.valueOf(10010), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]), Integer.valueOf(iArr[3]), Integer.valueOf(iArr[4]), Integer.valueOf(iArr[5])});
            } catch (Exception e) {
            }
        }
        if (bh.Wp() - bh.a((Long) com.tencent.mm.kernel.g.Dj().CU().get(81939, null), 0) > 86400000) {
            i iVar = new i();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ar.Hg();
        boolean booleanValue = ((Boolean) c.CU().get(233475, Boolean.valueOf(false))).booleanValue();
        ar.Hg();
        if (c.EY().cir() <= 0) {
            if (!booleanValue) {
                ar.Hg();
                c.Fd().WX("officialaccounts");
                ar.Hg();
                c.CU().set(233475, Boolean.valueOf(true));
            }
        } else if (booleanValue) {
            ar.Hg();
            c.CU().set(233475, Boolean.valueOf(false));
        }
        com.tencent.mm.plugin.webwx.a.g.bVr().bVt().bVp();
        x.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
