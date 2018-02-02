package com.tencent.mm.plugin.downloader.e;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class b extends i<a> {
    public static final String[] gJN = new String[]{i.a(a.gJc, "FileDownloadInfo"), "CREATE INDEX IF NOT EXISTS filedownloadinfo_appId  on FileDownloadInfo  (  appId )", "CREATE INDEX IF NOT EXISTS filedownloadinfo_status  on FileDownloadInfo  (  status )"};

    public b(e eVar) {
        super(eVar, a.gJc, "FileDownloadInfo", null);
    }

    public final a xE(String str) {
        a aVar = null;
        if (bh.ov(str)) {
            x.e("MicroMsg.FileDownloadInfoStorage", "appId is null");
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where appId=\"" + str + "\"", new String[0]);
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
        return aVar;
    }

    public static String o(ArrayList<String> arrayList) {
        String str = "";
        if (bh.cA(arrayList)) {
            return "1=1";
        }
        String str2 = str;
        int i = 0;
        while (i < arrayList.size() - 1) {
            String str3 = str2 + "appId=\"" + ((String) arrayList.get(i)) + "\" or ";
            i++;
            str2 = str3;
        }
        return str2 + "appId=\"" + ((String) arrayList.get(arrayList.size() - 1)) + "\"";
    }

    public final a cl(long j) {
        a aVar = null;
        if (j < 0) {
            x.e("MicroMsg.FileDownloadInfoStorage", "download id is not avaiable");
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where downloadId=" + j, new String[0]);
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
        return aVar;
    }

    public final boolean aAj() {
        return fx("FileDownloadInfo", "delete from FileDownloadInfo");
    }
}
