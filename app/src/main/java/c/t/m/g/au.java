package c.t.m.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class au extends SQLiteOpenHelper {
    private static Map<String, au> a = new ConcurrentHashMap();
    private static final Object b = new Object();

    private au(Context context, String str) {
        super(context, str, null, 2);
    }

    private int a(boolean z, boolean z2) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            Cursor query;
            int count;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (z && z2) {
                query = writableDatabase.query("halley_action_tbl", new String[]{"key"}, null, null, null, null, null);
            } else if (z) {
                query = writableDatabase.query("halley_action_tbl", new String[]{"key"}, "state=?", new String[]{"add"}, null, null, null);
            } else {
                query = writableDatabase.query("halley_action_tbl", new String[]{"key"}, "state=?", new String[]{"remove"}, null, null, null);
            }
            if (query != null) {
                try {
                    count = query.getCount();
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            count = 0;
            if (query == null) {
                return count;
            }
            query.close();
            return count;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public static au a(String str) {
        au auVar;
        synchronized (b) {
            auVar = (au) a.get(str);
            if (auVar == null) {
                auVar = new au(m.a(), "HalleyAction_" + m.b() + "_" + m.h() + "_" + str + ".db");
                a.put(str, auVar);
            }
        }
        return auVar;
    }

    public final List<a> a() {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        List<a> arrayList = new ArrayList();
        try {
            query = getWritableDatabase().query("halley_action_tbl", null, "state=?", new String[]{"add"}, null, null, null);
            if (query != null) {
                try {
                    int min = Math.min(query.getCount(), 10);
                    if (query.moveToFirst()) {
                        int i = 0;
                        do {
                            long j = query.getLong(query.getColumnIndex("key"));
                            String string = query.getString(query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DATA));
                            query.getString(query.getColumnIndex("state"));
                            arrayList.add(new a(j, string, (byte) 0));
                            i++;
                            if (i >= min) {
                                break;
                            }
                        } while (query.moveToNext());
                    }
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    public final void a(List<Long> list) {
        if (list.size() > 0) {
            try {
                long longValue;
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "remove");
                for (Long longValue2 : list) {
                    longValue = longValue2.longValue();
                    writableDatabase.update("halley_action_tbl", contentValues, "key=?", new String[]{String.valueOf(longValue)});
                }
                for (Long longValue22 : list) {
                    longValue = longValue22.longValue();
                    writableDatabase.delete("halley_action_tbl", "key=?", new String[]{String.valueOf(longValue)});
                }
                if (a(false, true) > 0 && a(true, false) <= 0) {
                    try {
                        writableDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
                    } catch (SQLException e) {
                    }
                    writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
                }
            } catch (SQLException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public final boolean a(int i) {
        if (a(true, true) > i) {
            try {
                getWritableDatabase().delete("halley_action_tbl", null, null);
                return true;
            } catch (SQLException e) {
                throw e;
            } catch (Exception e2) {
                if (a(true, true) > i) {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    try {
                        writableDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
                    } catch (SQLException e3) {
                    }
                    writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
                }
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public final long b(String str) {
        long j = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(SlookAirButtonFrequentContactAdapter.DATA, str);
                contentValues.put("state", "add");
                j = writableDatabase.insert("halley_action_tbl", null, contentValues);
            } catch (Exception e) {
            }
        }
        return j;
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        try {
            int version = sQLiteDatabase.getVersion();
            if (version == 0) {
                return;
            }
            if (version < 2) {
                onUpgrade(sQLiteDatabase, version, 2);
            } else if (version > 2) {
                onDowngrade(sQLiteDatabase, version, 2);
            }
        } catch (Exception e) {
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        } catch (SQLException e) {
            throw e;
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
        } catch (SQLException e) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        } catch (SQLException e2) {
            throw e2;
        } catch (Exception e3) {
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
        } catch (SQLException e) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        } catch (SQLException e2) {
            throw e2;
        } catch (Exception e3) {
        }
    }
}
