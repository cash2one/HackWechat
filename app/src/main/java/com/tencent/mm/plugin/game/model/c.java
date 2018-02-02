package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c {
    LinkedList<String> naN = new LinkedList();
    LinkedList<f> naO = new LinkedList();

    public final void init(Context context) {
        if (this.naO == null) {
            this.naO = new LinkedList();
        } else {
            this.naO.clear();
        }
        if (this.naN == null) {
            this.naN = new LinkedList();
        } else {
            this.naN.clear();
        }
        long currentTimeMillis = System.currentTimeMillis();
        cJ(context);
        long currentTimeMillis2 = System.currentTimeMillis();
        aPS();
        long currentTimeMillis3 = System.currentTimeMillis();
        x.i("MicroMsg.GameAppCacheService", "Init time: %d, %d, %d", new Object[]{Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis)});
    }

    private void cJ(Context context) {
        Cursor bYJ = an.bin().bYJ();
        LinkedList linkedList = new LinkedList();
        if (bYJ == null) {
            x.e("MicroMsg.GameAppCacheService", "getInstalledGame faild: curosr is null");
            return;
        }
        if (bYJ.moveToFirst()) {
            do {
                f fVar = new f();
                fVar.b(bYJ);
                if (g.a(context, fVar) && !this.naN.contains(fVar.field_appId)) {
                    x.i("MicroMsg.GameAppCacheService", "installed game:[%s][%s]", new Object[]{fVar.field_appName, fVar.field_appId});
                    this.naO.add(fVar);
                    this.naN.add(fVar.field_appId);
                }
            } while (bYJ.moveToNext());
        }
        bYJ.close();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            this.naO.add(fVar2);
            this.naN.add(fVar2.field_appId);
        }
    }

    private void aPS() {
        List<String> arrayList = new ArrayList();
        ar.Hg();
        Cursor rawQuery = com.tencent.mm.z.c.Fe().rawQuery("select * from FileDownloadInfo where status=3", new String[0]);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                a aVar = new a();
                aVar.b(rawQuery);
                if (!bh.ov(aVar.field_appId) && aVar.field_appId.startsWith("wx") && aVar.field_status == 3 && !aVar.field_autoDownload && e.bO(aVar.field_filePath) && !arrayList.contains(aVar.field_appId)) {
                    arrayList.add(aVar.field_appId);
                }
            }
            rawQuery.close();
        }
        if (!arrayList.isEmpty()) {
            for (String str : arrayList) {
                if (!(bh.ov(str) || this.naN.contains(str))) {
                    f aZ = g.aZ(str, false);
                    if (!(aZ == null || this.naO.contains(aZ))) {
                        this.naO.add(aZ);
                        this.naN.add(str);
                    }
                }
            }
        }
    }

    public final void clearCache() {
        x.i("MicroMsg.GameAppCacheService", "clear cached apppinfos");
        if (this.naO != null) {
            this.naO.clear();
        }
        if (this.naN != null) {
            this.naN.clear();
        }
    }
}
