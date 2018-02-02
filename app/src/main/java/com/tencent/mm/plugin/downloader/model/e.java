package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public static a ce(long j) {
        b Fe = Fe();
        if (Fe == null) {
            return null;
        }
        return Fe.cl(j);
    }

    public static a xE(String str) {
        b Fe = Fe();
        if (Fe == null) {
            return null;
        }
        return Fe.xE(str);
    }

    public static long b(a aVar) {
        if (aVar == null) {
            return -1;
        }
        b Fe = Fe();
        if (Fe == null) {
            return -1;
        }
        x.i("MicroMsg.FileDownloadInfoDBHelper", "insert downloadinfo: " + aVar.field_downloadId + ", ret=" + Fe.b(aVar));
        return aVar.field_downloadId;
    }

    public static long c(a aVar) {
        if (aVar == null) {
            return -1;
        }
        b Fe = Fe();
        if (Fe == null) {
            return -1;
        }
        boolean c = Fe.c(aVar, new String[0]);
        x.d("MicroMsg.FileDownloadInfoDBHelper", "Update Downloadinfo, ID: %d, ret: %b, Status: %d", Long.valueOf(aVar.field_downloadId), Boolean.valueOf(c), Integer.valueOf(aVar.field_status));
        return aVar.field_downloadId;
    }

    public static boolean j(long j, int i) {
        b Fe = Fe();
        if (Fe == null) {
            return false;
        }
        return Fe.fx("FileDownloadInfo", "update FileDownloadInfo set status = " + i + " where downloadId = " + j);
    }

    public static boolean xF(String str) {
        b Fe = Fe();
        if (Fe == null) {
            return false;
        }
        if (bh.ov(str)) {
            x.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, url is null");
            return false;
        }
        return Fe.fx("FileDownloadInfo", "delete from FileDownloadInfo where downloadUrl=\"" + str + "\"");
    }

    public static boolean xG(String str) {
        b Fe = Fe();
        if (Fe == null) {
            return false;
        }
        if (bh.ov(str)) {
            x.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, appId is null");
            return false;
        }
        return Fe.fx("FileDownloadInfo", "delete from FileDownloadInfo where appId=\"" + str + "\"");
    }

    public static a xH(String str) {
        a aVar = null;
        b Fe = Fe();
        if (Fe != null) {
            if (bh.ov(str)) {
                x.e("MicroMsg.FileDownloadInfoStorage", "Null or nil url");
            } else {
                Cursor rawQuery = Fe.rawQuery("select * from FileDownloadInfo where downloadUrlHashCode=" + str.hashCode(), new String[0]);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        aVar = new a();
                        aVar.b(rawQuery);
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            }
        }
        return aVar;
    }

    public static boolean cf(long j) {
        b Fe = Fe();
        if (Fe == null) {
            return false;
        }
        c aVar = new a();
        aVar.field_downloadId = j;
        return Fe.a(aVar, new String[0]);
    }

    public static b Fe() {
        if (g.Dh().Cy()) {
            g.Dh();
            if (!com.tencent.mm.kernel.a.Cs()) {
                if (g.h(com.tencent.mm.plugin.downloader.b.a.class) != null) {
                    return ((com.tencent.mm.plugin.downloader.b.a) g.h(com.tencent.mm.plugin.downloader.b.a.class)).Fe();
                }
                x.e("MicroMsg.FileDownloadInfoDBHelper", "service not ready");
                return null;
            }
        }
        x.e("MicroMsg.FileDownloadInfoDBHelper", "no user login");
        return null;
    }
}
