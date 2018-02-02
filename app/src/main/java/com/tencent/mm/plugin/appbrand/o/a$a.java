package com.tencent.mm.plugin.appbrand.o;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.h;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

final class a$a extends c {
    static final a iEJ = c.D(a$a.class);
    @h(cgN = "$$invalid", cgO = 1)
    public String field_key;
    public byte[] field_value;

    a$a() {
    }

    protected final a Ac() {
        return iEJ;
    }

    public final void b(Cursor cursor) {
        this.field_key = cursor.getString(0);
        this.field_value = cursor.getBlob(1);
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("key", this.field_key);
        contentValues.put(DownloadSettingTable$Columns.VALUE, this.field_value);
        return contentValues;
    }
}
