package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ai.a;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class n {
    private static final byte[] iEA = new byte[0];

    public static void ae(String str, int i) {
        if (!bh.ov(str)) {
            String qQ = q.qQ(str);
            if (!bh.ov(qQ)) {
                t tVar = (t) f.u(t.class);
                if (tVar != null) {
                    synchronized (iEA) {
                        c sVar = new s();
                        sVar.field_appId = qQ;
                        sVar.field_type = i;
                        if (tVar.b(sVar, s.iEI)) {
                            sVar.field_hit++;
                            sVar.field_hitTimeMS = bh.Wp();
                            tVar.c(sVar, s.iEI);
                        } else {
                            sVar.field_hit = 1;
                            sVar.field_hitTimeMS = bh.Wp();
                            tVar.b(sVar);
                        }
                    }
                }
            }
        }
    }

    public static a bC(long j) {
        if (j <= 0) {
            return a.iEB;
        }
        StatFs statFs = new StatFs(aa.ZZ());
        long blockSize = (long) (statFs.getBlockSize() * statFs.getAvailableBlocks());
        if (blockSize < 0 || blockSize > j) {
            return a.iEB;
        }
        t tVar = (t) f.u(t.class);
        if (tVar == null) {
            x.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", new Object[]{Long.valueOf(j)});
            return a.iED;
        }
        String format = String.format(Locale.US, " %s, %s ASC", new Object[]{"hit", "hitTimeMS"});
        LinkedList linkedList = new LinkedList();
        synchronized (iEA) {
            Cursor a = tVar.gJP.a("PkgUsageLRURecord", new String[]{"appId", DownloadSettingTable$Columns.TYPE}, null, null, null, null, format, 2);
            a aVar;
            if (a == null) {
                aVar = a.iED;
                return aVar;
            } else if (a.moveToFirst()) {
                while (true) {
                    try {
                        linkedList.add(Pair.create(a.getString(0), Integer.valueOf(a.getInt(1))));
                        if (!a.moveToNext()) {
                            break;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy, read from cursor e = %s", new Object[]{e});
                        r4 = f.Zo();
                        ai Zo;
                        if (Zo == null) {
                            x.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", new Object[]{Long.valueOf(j)});
                            return a.iED;
                        }
                        long j2 = 0;
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            for (ae aeVar : Zo.a((String) pair.first, ((Integer) pair.second).intValue(), a.iGv, "pkgPath")) {
                                j2 += (long) e.bN(aeVar.field_pkgPath);
                                b.deleteFile(aeVar.field_pkgPath);
                                if (j2 >= j) {
                                    return a.iEC;
                                }
                            }
                        }
                        return a.iED;
                    } finally {
                        a.close();
                    }
                }
            } else {
                a.close();
                aVar = a.iED;
                return aVar;
            }
        }
    }
}
