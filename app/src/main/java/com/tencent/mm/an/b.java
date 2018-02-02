package com.tencent.mm.an;

import android.content.ContentValues;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.FileUtils;

public final class b extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    h hhp;

    public b(h hVar) {
        this.hhp = hVar;
    }

    public final boolean a(a aVar) {
        aVar.fDt = -1;
        ContentValues contentValues = new ContentValues();
        if ((aVar.fDt & 1) != 0) {
            contentValues.put("username", aVar.getUsername());
        }
        if ((aVar.fDt & 2) != 0) {
            contentValues.put("inserttime", Long.valueOf(aVar.hyu));
        }
        if ((aVar.fDt & 4) != 0) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(aVar.type));
        }
        if ((aVar.fDt & 8) != 0) {
            contentValues.put("lastgettime", Integer.valueOf(aVar.hyv));
        }
        if ((aVar.fDt & 16) != 0) {
            contentValues.put("reserved1", Integer.valueOf(aVar.hhl));
        }
        if ((aVar.fDt & 32) != 0) {
            contentValues.put("reserved2", Integer.valueOf(aVar.hwo));
        }
        if ((aVar.fDt & 64) != 0) {
            contentValues.put("reserved3", aVar.HN());
        }
        if ((aVar.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("reserved4", aVar.OU());
        }
        if (((int) this.hhp.replace("getcontactinfov2", "username", contentValues)) == -1) {
            return false;
        }
        Wc(aVar.getUsername());
        return true;
    }

    public final boolean ld(String str) {
        if (this.hhp.delete("getcontactinfov2", "username= ?", new String[]{str}) <= 0) {
            return false;
        }
        Wc(str);
        return true;
    }
}
