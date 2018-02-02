package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.c.v;
import com.google.android.gms.c.w;
import com.google.android.gms.tagmanager.c.a;
import com.google.android.gms.tagmanager.c.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class ap implements c {
    private static final String bcX = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", DownloadSettingTable$Columns.VALUE, "expires"});
    private v aFD;
    private final Executor bcY;
    private a bcZ;
    private int bda;
    private final Context mContext;

    public ap(Context context) {
        this(context, w.pH(), "google_tagmanager.db", Executors.newSingleThreadExecutor());
    }

    private ap(Context context, v vVar, String str, Executor executor) {
        this.mContext = context;
        this.aFD = vVar;
        this.bda = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
        this.bcY = executor;
        this.bcZ = new a(this, this.mContext, str);
    }

    private void ac(long j) {
        SQLiteDatabase bi = bi("Error opening database for deleteOlderThan.");
        if (bi != null) {
            try {
                new StringBuilder("Deleted ").append(bi.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)})).append(" expired items");
                m.qG();
            } catch (SQLiteException e) {
                m.qE();
            }
        }
    }

    private static byte[] ao(Object obj) {
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private synchronized void b(List<b> list, long j) {
        String[] strArr;
        long currentTimeMillis;
        try {
            currentTimeMillis = this.aFD.currentTimeMillis();
            ac(currentTimeMillis);
            int size = list.size() + (rl() - this.bda);
            if (size > 0) {
                List dM = dM(size);
                new StringBuilder("DataLayer store full, deleting ").append(dM.size()).append(" entries to make room.");
                m.qF();
                strArr = (String[]) dM.toArray(new String[0]);
                if (!(strArr == null || strArr.length == 0)) {
                    SQLiteDatabase bi = bi("Error opening database for deleteEntries.");
                    if (bi != null) {
                        bi.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    }
                }
            }
        } catch (SQLiteException e) {
            new StringBuilder("Error deleting entries ").append(Arrays.toString(strArr));
            m.qE();
        } catch (Throwable th) {
            rm();
        }
        c(list, currentTimeMillis + j);
        rm();
    }

    private SQLiteDatabase bi(String str) {
        try {
            return this.bcZ.getWritableDatabase();
        } catch (SQLiteException e) {
            m.qE();
            return null;
        }
    }

    private void c(List<b> list, long j) {
        SQLiteDatabase bi = bi("Error opening database for writeEntryToDatabase.");
        if (bi != null) {
            for (b bVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", bVar.aXw);
                contentValues.put(DownloadSettingTable$Columns.VALUE, bVar.bdf);
                bi.insert("datalayer", null, contentValues);
            }
        }
    }

    private List<String> dM(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            m.qE();
            return arrayList;
        }
        SQLiteDatabase bi = bi("Error opening database for peekEntryIds.");
        if (bi == null) {
            return arrayList;
        }
        try {
            query = bi.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    new StringBuilder("Error in peekEntries fetching entryIds: ").append(e.getMessage());
                    m.qE();
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            new StringBuilder("Error in peekEntries fetching entryIds: ").append(e.getMessage());
            m.qE();
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private static Object m(byte[] bArr) {
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2;
        try {
            objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream2.readObject();
                try {
                    objectInputStream2.close();
                    byteArrayInputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream2 = objectInputStream;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream2 = objectInputStream;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream2 = objectInputStream;
            th = th4;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private List<a> rj() {
        try {
            ac(this.aFD.currentTimeMillis());
            List<b> rk = rk();
            List<a> arrayList = new ArrayList();
            for (b bVar : rk) {
                arrayList.add(new a(bVar.aXw, m(bVar.bdf)));
            }
            return arrayList;
        } finally {
            rm();
        }
    }

    private List<b> rk() {
        SQLiteDatabase bi = bi("Error opening database for loadSerialized.");
        List<b> arrayList = new ArrayList();
        if (bi == null) {
            return arrayList;
        }
        Cursor query = bi.query("datalayer", new String[]{"key", DownloadSettingTable$Columns.VALUE}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int rl() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase bi = bi("Error opening database for getNumStoredEntries.");
        if (bi != null) {
            try {
                cursor = bi.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                m.qE();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private void rm() {
        try {
            this.bcZ.close();
        } catch (SQLiteException e) {
        }
    }

    public final void a(c.a aVar) {
        this.bcY.execute(new 2(this, aVar));
    }

    public final void a(List<a> list, long j) {
        List arrayList = new ArrayList();
        for (a aVar : list) {
            arrayList.add(new b(aVar.aXw, ao(aVar.bbw)));
        }
        this.bcY.execute(new 1(this, arrayList, j));
    }
}
