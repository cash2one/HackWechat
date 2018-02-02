package com.tencent.mm.plugin.webview.wepkg.a;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;

public class b extends i<a> {
    public static final String[] gJN = new String[]{i.a(a.iGc, "WepkgPreloadFiles")};
    private static volatile b tLC = null;
    private final h hhp;
    public final boolean iYd;

    public static b bUZ() {
        if (!ar.Hj()) {
            return new b(null);
        }
        if (tLC == null) {
            synchronized (b.class) {
                if (tLC == null || !tLC.iYd) {
                    ar.Hg();
                    tLC = new b(c.EV());
                }
            }
        }
        return tLC;
    }

    private b(h hVar) {
        super(hVar, a.iGc, "WepkgPreloadFiles", a.fMK);
        this.hhp = hVar;
        this.iYd = hVar != null;
        if (!this.iYd) {
            x.e("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "storage can not work!!!");
        }
    }

    public final a eU(String str, String str2) {
        if (!this.iYd || bh.ov(str) || bh.ov(str2)) {
            return null;
        }
        String eY = d.eY(str, str2);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgPreloadFiles", "key"}), new String[]{eY});
        if (rawQuery.moveToFirst()) {
            a aVar = new a();
            aVar.b(rawQuery);
            rawQuery.close();
            x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid exist record in DB, pkgid:%s, rid:%s, version:%s", new Object[]{aVar.field_pkgId, aVar.field_rid, aVar.field_version});
            return aVar;
        }
        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid pkgid:%s, rid:%s, no record in DB", new Object[]{str, str2});
        rawQuery.close();
        return null;
    }

    public final List<WepkgPreloadFile> PP(String str) {
        List<WepkgPreloadFile> list = null;
        if (this.iYd && !bh.ov(str)) {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgPreloadFiles", "pkgId"}), new String[]{str});
            x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getPreLoadFileList queryStr:%s", new Object[]{r1});
            if (rawQuery == null) {
                x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                    a aVar = new a();
                    aVar.b(rawQuery);
                    wepkgPreloadFile.a(aVar);
                    list.add(wepkgPreloadFile);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[]{Integer.valueOf(list.size())});
            } else {
                rawQuery.close();
                x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
            }
        }
        return list;
    }

    public final boolean PQ(String str) {
        if (!this.iYd || bh.ov(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c aVar = new a();
        aVar.field_pkgId = str;
        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.a(aVar, new String[]{"pkgId"}))});
        return super.a(aVar, new String[]{"pkgId"});
    }

    public final boolean f(String str, String str2, String str3, boolean z) {
        if (!this.iYd || bh.ov(str) || bh.ov(str2)) {
            return false;
        }
        com.tencent.mm.sdk.e.c eU = eU(str, str2);
        if (eU == null) {
            return false;
        }
        eU.field_completeDownload = z;
        eU.field_filePath = str3;
        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "updateDownloadCompleteState pkgid:%s, rid:%s, completeDownload:%s, filePath:%s, ret:%s", new Object[]{str, str2, Boolean.valueOf(z), str3, Boolean.valueOf(super.c(eU, new String[0]))});
        return super.c(eU, new String[0]);
    }
}
