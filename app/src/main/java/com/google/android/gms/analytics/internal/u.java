package com.google.android.gms.analytics.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

final class u extends o implements Closeable {
    private static final String aGA = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private static final String aGB = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    private final a aGC;
    private final j aGD = new j(this.aFo.aFD);
    private final j aGE = new j(this.aFo.aFD);

    u(q qVar) {
        super(qVar);
        this.aGC = new a(this, qVar.mContext, nf());
    }

    private List<Long> W(long j) {
        Cursor query;
        Object e;
        Throwable th;
        Cursor cursor = null;
        q.mY();
        mQ();
        if (j <= 0) {
            return Collections.emptyList();
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        List<Long> arrayList = new ArrayList();
        try {
            query = writableDatabase.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Long.toString(j));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(Long.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    e("Error selecting hit ids", e);
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            e("Error selecting hit ids", e);
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    private Map<String, String> aA(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = "?" + str;
            }
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI(str), "UTF-8");
            Map<String, String> hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            f("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    private Map<String, String> aB(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI("?" + str), "UTF-8");
            Map<String, String> hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            f("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    private long az(String str) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, null);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            d("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private long b(String str, String[] strArr) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            try {
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery == null) {
                        return j;
                    }
                    rawQuery.close();
                    return j;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return 0;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = rawQuery;
                try {
                    d("Database error", str, e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            d("Database error", str, e);
            throw e;
        }
    }

    private SQLiteDatabase getWritableDatabase() {
        try {
            return this.aGC.getWritableDatabase();
        } catch (SQLiteException e) {
            e("Error opening database", e);
            throw e;
        }
    }

    private long nb() {
        q.mY();
        mQ();
        return az("SELECT COUNT(*) FROM hits2");
    }

    private String nf() {
        return !f.aNs ? "google_analytics_v4.db" : this.aFo.aFW.nu() ? "google_analytics_v4.db" : "google_analytics2_v4.db";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<c> X(long j) {
        Throwable th;
        boolean z = true;
        Cursor cursor = null;
        if (j < 0) {
            z = false;
        }
        w.as(z);
        q.mY();
        mQ();
        try {
            cursor = getWritableDatabase().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Long.toString(j));
            List<c> arrayList = new ArrayList();
            if (cursor.moveToFirst()) {
                do {
                    long j2 = cursor.getLong(0);
                    long j3 = cursor.getLong(1);
                    String string = cursor.getString(2);
                    String string2 = cursor.getString(3);
                    int i = cursor.getInt(4);
                    arrayList.add(new c(this, aA(string), j3, k.at(string2), j2, i));
                } while (cursor.moveToNext());
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            Object e2 = e;
            Cursor cursor2 = cursor;
            try {
                f("Error loading hits from the database", e2);
                throw e2;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursor2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void Y(long j) {
        q.mY();
        mQ();
        List arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        c("Deleting hit, id", Long.valueOf(j));
        s(arrayList);
    }

    public final long a(long j, String str, String str2) {
        w.aM(str);
        w.aM(str2);
        mQ();
        q.mY();
        return b("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2});
    }

    public final void b(long j, String str) {
        w.aM(str);
        mQ();
        q.mY();
        int delete = getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(j), str});
        if (delete > 0) {
            c("Deleted property records", Integer.valueOf(delete));
        }
    }

    public final void b(s sVar) {
        w.ag(sVar);
        mQ();
        q.mY();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Map map = sVar.aFb;
        w.ag(map);
        Builder builder = new Builder();
        for (Entry entry : map.entrySet()) {
            builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String encodedQuery = builder.build().getEncodedQuery();
        if (encodedQuery == null) {
            encodedQuery = "";
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_uid", Long.valueOf(sVar.aGl));
        contentValues.put("cid", sVar.aGm);
        contentValues.put("tid", sVar.aGn);
        contentValues.put("adid", Integer.valueOf(sVar.aGo ? 1 : 0));
        contentValues.put("hits_count", Long.valueOf(sVar.aGp));
        contentValues.put("params", encodedQuery);
        try {
            if (writableDatabase.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                ay("Failed to insert/update a property (got -1)");
            }
        } catch (SQLiteException e) {
            f("Error storing a property", e);
        }
    }

    public final void beginTransaction() {
        mQ();
        getWritableDatabase().beginTransaction();
    }

    public final void close() {
        try {
            this.aGC.close();
        } catch (SQLiteException e) {
            f("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            f("Error closing database", e2);
        }
    }

    public final void e(c cVar) {
        String str;
        w.ag(cVar);
        q.mY();
        mQ();
        w.ag(cVar);
        Builder builder = new Builder();
        for (Entry entry : cVar.aFb.entrySet()) {
            str = (String) entry.getKey();
            if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str))) {
                builder.appendQueryParameter(str, (String) entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        str = encodedQuery == null ? "" : encodedQuery;
        if (str.length() > 8192) {
            this.aFo.mS().a(cVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = ((Integer) aj.aHx.get()).intValue();
        long nb = nb();
        if (nb > ((long) (intValue - 1))) {
            List W = W((nb - ((long) intValue)) + 1);
            e("Store full, deleting hits to make room, count", Integer.valueOf(W.size()));
            s(W);
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", str);
        contentValues.put("hit_time", Long.valueOf(cVar.aFe));
        contentValues.put("hit_app_id", Integer.valueOf(cVar.aFf));
        contentValues.put("hit_url", cVar.aFg ? ac.nB() : ac.nC());
        try {
            long insert = writableDatabase.insert("hits2", null, contentValues);
            if (insert == -1) {
                ay("Failed to insert a hit (got -1)");
            } else {
                b("Hit saved to database. db-id, hit", Long.valueOf(insert), cVar);
            }
        } catch (SQLiteException e) {
            f("Error storing a hit", e);
        }
    }

    public final void endTransaction() {
        mQ();
        getWritableDatabase().endTransaction();
    }

    final boolean isEmpty() {
        return nb() == 0;
    }

    protected final void mf() {
    }

    public final int nc() {
        q.mY();
        mQ();
        if (!this.aGD.V(86400000)) {
            return 0;
        }
        this.aGD.start();
        au("Deleting stale hits (if any)");
        int delete = getWritableDatabase().delete("hits2", "hit_time < ?", new String[]{Long.toString(this.aFo.aFD.currentTimeMillis() - 2592000000L)});
        c("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public final long nd() {
        q.mY();
        mQ();
        return b(aGB, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<s> ne() {
        Cursor cursor = null;
        mQ();
        q.mY();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            String[] strArr = new String[]{"cid", "tid", "adid", "hits_count", "params"};
            int intValue = ((Integer) aj.aHz.get()).intValue();
            String str = "properties";
            cursor = writableDatabase.query(str, strArr, "app_uid=?", new String[]{"0"}, null, null, null, String.valueOf(intValue));
            List<s> arrayList = new ArrayList();
            if (cursor.moveToFirst()) {
                do {
                    Object string = cursor.getString(0);
                    Object string2 = cursor.getString(1);
                    boolean z = cursor.getInt(2) != 0;
                    long j = (long) cursor.getInt(3);
                    Map aB = aB(cursor.getString(4));
                    if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                        c("Read property with empty client id or tracker id", string, string2);
                    } else {
                        arrayList.add(new s(0, string, string2, z, j, aB));
                    }
                } while (cursor.moveToNext());
            }
            if (arrayList.size() >= intValue) {
                ax("Sending hits to too many properties. Campaign report might be incorrect");
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            Object e2 = e;
            Cursor cursor2 = cursor;
        } catch (Throwable th) {
            Throwable th2 = th;
        }
    }

    public final void s(List<Long> list) {
        w.ag(list);
        q.mY();
        mQ();
        if (!list.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("hit_id");
            stringBuilder.append(" in (");
            for (int i = 0; i < list.size(); i++) {
                Long l = (Long) list.get(i);
                if (l == null || l.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(l);
            }
            stringBuilder.append(")");
            String stringBuilder2 = stringBuilder.toString();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                c("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                int delete = writableDatabase.delete("hits2", stringBuilder2, null);
                if (delete != list.size()) {
                    a(5, "Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), stringBuilder2);
                }
            } catch (SQLiteException e) {
                f("Error deleting hits", e);
                throw e;
            }
        }
    }

    public final void setTransactionSuccessful() {
        mQ();
        getWritableDatabase().setTransactionSuccessful();
    }
}
