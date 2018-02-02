package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class af$1 implements Runnable {
    af$1() {
    }

    private static void aam() {
        List list = null;
        if (g.Dh().Cy()) {
            ai Zo = f.Zo();
            Cursor a = Zo.iGs.a(String.format("select distinct %s from %s ", new Object[]{"appId", "AppBrandWxaPkgManifestRecord"}), null, 2);
            List<String> arrayList = new ArrayList();
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            if (!bh.cA(arrayList)) {
                List linkedList = new LinkedList();
                for (String q : arrayList) {
                    Collection q2 = Zo.q(q, 0, 2);
                    if (!bh.cA(q2)) {
                        linkedList.addAll(q2);
                    }
                }
                list = linkedList;
            }
            if (!bh.cA(r0)) {
                for (ae aeVar : r0) {
                    af.ej(aeVar.field_pkgPath);
                    f.Zo().a(aeVar);
                    f.Zu().af(aeVar.field_appId, aeVar.field_version);
                }
            }
        }
    }

    private static void aan() {
        File file = new File(aa.ZZ());
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                boolean z;
                ai Zo = f.Zo();
                String absolutePath = file2.getAbsolutePath();
                Cursor a = Zo.iGs.a("AppBrandWxaPkgManifestRecord", new String[]{"appId"}, String.format("%s=?", new Object[]{"pkgPath"}), new String[]{absolutePath}, null, null, null, 2);
                if (a == null) {
                    z = false;
                } else {
                    z = a.moveToFirst();
                    a.close();
                }
                if (!z) {
                    af.ej(file2.getAbsolutePath());
                }
            }
        }
    }

    public final void run() {
        try {
            ai Zo = f.Zo();
            StringBuilder stringBuilder = new StringBuilder("debugType");
            stringBuilder.append(" in (");
            for (int append : d.iDM) {
                stringBuilder.append(append).append(',');
            }
            stringBuilder.append(-1).append(')');
            Cursor a = Zo.iGs.a("AppBrandWxaPkgManifestRecord", null, stringBuilder.toString(), null, null, null, null, 2);
            List list;
            if (a == null) {
                list = null;
            } else if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    ae aeVar = new ae();
                    aeVar.b(a);
                    list.add(aeVar);
                } while (a.moveToNext());
                a.close();
            } else {
                a.close();
                list = null;
            }
            if (!bh.cA(r0)) {
                long Wo = bh.Wo();
                for (ae aeVar2 : r0) {
                    if (aeVar2.field_endTime > 0 && aeVar2.field_endTime <= Wo) {
                        af.ej(aeVar2.field_pkgPath);
                        f.Zo().a(aeVar2);
                        d.aJ(aeVar2.field_appId, aeVar2.field_debugType);
                    }
                }
            }
            aam();
            aan();
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrand.WxaPkgPruner", "prune running, exp = %s", bh.i(e));
        }
    }
}
