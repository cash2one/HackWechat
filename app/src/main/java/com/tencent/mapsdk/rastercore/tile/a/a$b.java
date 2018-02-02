package com.tencent.mapsdk.rastercore.tile.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

class a$b extends ContextWrapper {
    private /* synthetic */ a a;

    public a$b(a aVar, Context context) {
        this.a = aVar;
        super(context);
    }

    public final SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
        String b = this.a.b();
        return (b == null || b.length() == 0) ? super.openOrCreateDatabase(str, i, cursorFactory) : SQLiteDatabase.openOrCreateDatabase(b + str, null);
    }

    public final SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        String b = this.a.b();
        return (b == null || b.length() == 0) ? super.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler) : SQLiteDatabase.openOrCreateDatabase(b + str, null);
    }
}
