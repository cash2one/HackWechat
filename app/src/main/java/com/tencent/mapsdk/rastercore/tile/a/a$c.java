package com.tencent.mapsdk.rastercore.tile.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.mapsdk.rastercore.tile.a;
import com.tencent.mapsdk.rastercore.tile.a.a.1;

class a$c extends SQLiteOpenHelper {
    private SQLiteDatabase a;

    public a$c(a aVar, Context context) {
        super(context, "Cache.db", null, 1);
        this.a = null;
        this.a = getReadableDatabase();
        if (VERSION.SDK_INT > 10) {
            this.a.enableWriteAheadLogging();
        } else {
            this.a.setLockingEnabled(true);
        }
    }

    private static void a(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (tile TEXT PRIMARY KEY UNIQUE,version TEXT,style TEXT,md5" + " TEXT,data BLOB )");
    }

    private static String b(MapSource mapSource) {
        switch (1.a[mapSource.ordinal()]) {
            case 1:
                return "wmt";
            case 2:
                return "tct";
            case 3:
                return "stt";
            default:
                return "";
        }
    }

    private static String b(a aVar) {
        switch (1.a[aVar.m().ordinal()]) {
            case 1:
                return aVar.d() + "-" + aVar.b() + "-" + aVar.c() + "-" + e.u() + "-" + e.t();
            case 2:
                return aVar.d() + "-" + aVar.b() + "-" + aVar.c() + "-zh-" + e.y();
            case 3:
                return aVar.d() + "-" + aVar.b() + "-" + aVar.c();
            default:
                return null;
        }
    }

    private static int c(MapSource mapSource) {
        return mapSource == MapSource.BING ? e.t() : mapSource == MapSource.TENCENT ? e.y() : -1;
    }

    private boolean c(a aVar) {
        Cursor cursor = null;
        boolean z = true;
        try {
            cursor = this.a.rawQuery("select count(*) as ct from " + b(aVar.m()) + " where " + "tile" + " = '" + b(aVar) + "'", null);
            if (cursor == null || cursor.getCount() <= 0) {
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            }
            cursor.moveToFirst();
            if (cursor.getInt(cursor.getColumnIndex("ct")) <= 0) {
                z = false;
            }
            if (cursor != null) {
                cursor.close();
            }
            return z;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final c a(a aVar) {
        Throwable th;
        Throwable th2;
        if (this.a == null) {
            return null;
        }
        String str = "select * from " + b(aVar.m()) + " where tile = ?";
        Cursor rawQuery;
        try {
            rawQuery = this.a.rawQuery(str, new String[]{b(aVar)});
            if (rawQuery != null) {
                try {
                    if (rawQuery.getCount() > 0) {
                        rawQuery.moveToFirst();
                        byte[] blob = rawQuery.getBlob(rawQuery.getColumnIndex(SlookAirButtonFrequentContactAdapter.DATA));
                        String string = rawQuery.getString(rawQuery.getColumnIndex("md5"));
                        c cVar = new c(a.a(blob, string), rawQuery.getInt(rawQuery.getColumnIndex("version")), string);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return cVar;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        new StringBuilder("getBitmap error:").append(th.toString());
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return new c(null, e.v(), "");
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw th2;
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Throwable th5) {
            rawQuery = null;
            th2 = th5;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th2;
        }
        return new c(null, e.v(), "");
    }

    public final boolean a(MapSource mapSource) {
        if (this.a == null) {
            return false;
        }
        String str = "delete  from " + b(mapSource);
        if (mapSource == MapSource.BING || mapSource == MapSource.TENCENT) {
            str = str + " where style = '" + c(mapSource) + "'";
        }
        try {
            this.a.execSQL(str);
            return true;
        } catch (Throwable th) {
            new StringBuilder("cleanCache Error:").append(th.toString());
            return false;
        }
    }

    public final boolean a(MapSource mapSource, int i) {
        try {
            StringBuilder stringBuilder = new StringBuilder("delete from ");
            stringBuilder.append(b(mapSource));
            stringBuilder.append(mapSource == MapSource.SATELLITE ? " where version != '" + i + "'" : " where style = '" + c(mapSource) + "' and version != '" + i + "'");
            this.a.execSQL(stringBuilder.toString());
            return true;
        } catch (Throwable th) {
            new StringBuilder("deleteOlderCache error:").append(th.toString());
            return false;
        }
    }

    public final boolean a(a aVar, byte[] bArr) {
        if (this.a == null) {
            return false;
        }
        try {
            String a = a.a(bArr);
            byte[] b = a.b(bArr, a);
            ContentValues contentValues = new ContentValues();
            contentValues.put("tile", b(aVar));
            contentValues.put(SlookAirButtonFrequentContactAdapter.DATA, b);
            contentValues.put("md5", a);
            MapSource m = aVar.m();
            if (m == MapSource.BING) {
                contentValues.put("style", Integer.valueOf(e.t()));
            }
            if (m == MapSource.TENCENT) {
                contentValues.put("style", Integer.valueOf(e.y()));
            }
            contentValues.put("version", Integer.valueOf(aVar.l()));
            return this.a.insert(b(aVar.m()), null, contentValues) != -1;
        } catch (Throwable th) {
            new StringBuilder("putBitmap Error:").append(th.toString());
            return false;
        }
    }

    public final boolean a(a aVar, byte[] bArr, boolean z) {
        if (this.a == null) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            String str = "tile = ? ";
            String[] strArr = new String[]{b(aVar)};
            contentValues.put("version", Integer.valueOf(aVar.l()));
            String a = a.a(bArr);
            if (!(z || bArr == null)) {
                contentValues.put("md5", a);
                contentValues.put(SlookAirButtonFrequentContactAdapter.DATA, bArr);
            }
            return this.a.update(b(aVar.m()), contentValues, str, strArr) > 0;
        } catch (Throwable th) {
            new StringBuilder("updateBitmap Error:").append(th.toString());
            return false;
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        a("tct", sQLiteDatabase);
        a("wmt", sQLiteDatabase);
        a("stt", sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  tct");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  wmt");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  stt");
        onCreate(sQLiteDatabase);
    }
}
