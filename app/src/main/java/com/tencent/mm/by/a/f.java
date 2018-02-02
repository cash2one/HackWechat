package com.tencent.mm.by.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCursorDriver;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class f extends AbstractCursor implements d {
    public static final CursorFactory FACTORY = new CursorFactory() {
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            return new f(sQLiteCursorDriver, str, (h) sQLiteProgram);
        }

        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            return new h(sQLiteDatabase, str, cancellationSignal);
        }
    };
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount = -1;
    private final SQLiteCursorDriver mDriver;
    private final String mEditTable;
    private final Throwable mStackTrace;
    private int pageSize = 3000;
    private final h xBT;
    public a xBU;
    private boolean xBV;
    private b<a> xBW;
    c xBX;
    private boolean xBY;

    public interface a {
        ArrayList<a> ah(ArrayList<Object> arrayList);

        a ckX();
    }

    public f(SQLiteCursorDriver sQLiteCursorDriver, String str, h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("query object cannot be null");
        }
        this.mStackTrace = null;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.xBT = hVar;
        this.mColumns = hVar.getColumnNames();
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    }

    public final void DD(int i) {
        if (i <= 15000 && i >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            this.pageSize = i;
        }
    }

    public final void lJ(boolean z) {
        this.xBV = z;
    }

    public final boolean onMove(int i, int i2) {
        if (!this.xBV) {
            boolean z;
            if (this.xBX == null) {
                ckY();
            }
            c cVar = this.xBX;
            int i3 = i2 / cVar.xBM;
            if (cVar.xBL.indexOfKey(i3) >= 0) {
                if (((Object[]) cVar.xBL.get(i3))[(i2 % cVar.xBM) * cVar.columnCount] != null) {
                    z = true;
                    if (!z) {
                        DF((i2 / this.pageSize) * this.pageSize);
                    }
                    this.xBX.moveToPosition(i2);
                }
            }
            z = false;
            if (z) {
                DF((i2 / this.pageSize) * this.pageSize);
            }
            this.xBX.moveToPosition(i2);
        } else if (this.xBW == null || !this.xBW.DE(i2)) {
            DF((i2 / this.pageSize) * this.pageSize);
        }
        return true;
    }

    private void ckY() {
        if (this.xBX == null) {
            this.xBX = new c(this.mColumns, (byte) 0);
        }
    }

    public final int getCount() {
        if (this.mCount == -1) {
            this.mCount = DF(0);
            if (this.xBW != null) {
                boolean z = this.mCount != -1 && this.mCount == this.xBW.xBG.size();
                this.xBY = z;
            }
        }
        if (!this.xBV || !this.xBY) {
            return this.mCount;
        }
        if (this.xBW == null) {
            return 0;
        }
        return this.xBW.xBG.size();
    }

    protected final void checkPosition() {
        super.checkPosition();
    }

    private int DF(int i) {
        if (this.xBV) {
            if (this.xBW == null) {
                this.xBW = new b<a>(this) {
                    final /* synthetic */ f xBZ;

                    {
                        this.xBZ = r1;
                    }

                    public final a ckX() {
                        f fVar = this.xBZ;
                        return fVar.xBU != null ? fVar.xBU.ckX() : null;
                    }

                    public final ArrayList<a> ah(ArrayList<Object> arrayList) {
                        f fVar = this.xBZ;
                        return fVar.xBU != null ? fVar.xBU.ah(arrayList) : null;
                    }
                };
            }
            this.xBW.mStartPos = i;
            return this.xBT.a(this.xBW, i, this.pageSize);
        }
        ckY();
        return this.xBT.a(this.xBX, i, this.pageSize);
    }

    public final int getColumnIndex(String str) {
        int i;
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            Map hashMap = new HashMap(length, 1.0f);
            for (i = 0; i < length; i++) {
                hashMap.put(strArr[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = hashMap;
        }
        i = str.lastIndexOf(46);
        if (i != -1) {
            Exception exception = new Exception();
            Log.e("WCDB.SQLiteNewCursor", "requesting column name with table name -- " + str, exception);
            str = str.substring(i + 1);
        }
        Integer num = (Integer) this.mColumnNameMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public final String[] getColumnNames() {
        return this.mColumns;
    }

    public final void deactivate() {
        super.deactivate();
        this.mDriver.cursorDeactivated();
    }

    public final void close() {
        super.close();
        synchronized (this) {
            this.xBT.close();
            this.mDriver.cursorClosed();
        }
    }

    public final boolean requery() {
        boolean z = false;
        if (!isClosed()) {
            synchronized (this) {
                if (this.xBT.getDatabase().isOpen()) {
                    if (this.xBW != null) {
                        this.xBW.aaS();
                    }
                    this.mPos = -1;
                    this.mCount = -1;
                    this.mDriver.cursorRequeried(this);
                    try {
                        z = super.requery();
                    } catch (IllegalStateException e) {
                        Log.w("WCDB.SQLiteNewCursor", "requery() failed " + e.getMessage(), e);
                    }
                }
            }
        }
        return z;
    }

    protected final void finalize() {
        try {
            if (this.xBW != null) {
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final String getString(int i) {
        if (this.xBV) {
            return null;
        }
        return this.xBX.getString(i);
    }

    public final short getShort(int i) {
        if (this.xBV) {
            return (short) 0;
        }
        return this.xBX.getShort(i);
    }

    public final int getInt(int i) {
        if (this.xBV) {
            return 0;
        }
        return this.xBX.getInt(i);
    }

    public final long getLong(int i) {
        if (this.xBV) {
            return 0;
        }
        return this.xBX.getLong(i);
    }

    public final float getFloat(int i) {
        if (this.xBV) {
            return 0.0f;
        }
        return this.xBX.getFloat(i);
    }

    public final double getDouble(int i) {
        if (this.xBV) {
            return 0.0d;
        }
        return this.xBX.getDouble(i);
    }

    public final boolean isNull(int i) {
        if (this.xBV) {
            return false;
        }
        return this.xBX.isNull(i);
    }

    public final byte[] getBlob(int i) {
        if (this.xBV) {
            return null;
        }
        return this.xBX.getBlob(i);
    }

    public final a DC(int i) {
        a aVar = null;
        int i2 = 0;
        if (this.xBW != null) {
            b bVar = this.xBW;
            if (bVar.DE(i)) {
                Object obj = bVar.xBG.get(i);
                aVar = (a) bVar.xBI.get(obj);
                if (aVar == null) {
                    x.i("MicroMsg.CursorDataWindow", "get data null %s", obj);
                    if (bVar.xBJ.size() != 0) {
                        ArrayList ah = bVar.ah(bVar.xBJ);
                        if (ah != null) {
                            while (i2 < ah.size()) {
                                aVar = (a) ah.get(i2);
                                if (aVar != null) {
                                    bVar.b(aVar.getKey(), aVar);
                                } else {
                                    x.e("MicroMsg.CursorDataWindow", "newcursor obj is null");
                                }
                                i2++;
                            }
                        }
                        bVar.xBJ.clear();
                    }
                    aVar = (a) bVar.xBI.get(obj);
                    if (aVar == null) {
                        x.e("MicroMsg.CursorDataWindow", "newcursor error obj : " + obj + "pos:" + i);
                    }
                }
            } else {
                x.e("MicroMsg.CursorDataWindow", "newcursor cursor getItem error: pos " + i + " loaded num :" + bVar.xBG.size());
            }
        }
        return aVar;
    }

    public final boolean a(Object obj, a aVar) {
        if (this.xBV && this.xBW != null) {
            if (!this.xBY && (obj instanceof Object[]) && this.xBW.cd(obj)) {
                this.mCount -= ((Object[]) obj).length;
                this.pageSize -= ((Object[]) obj).length;
            }
            b bVar = this.xBW;
            if (aVar != null) {
                x.v("MicroMsg.CursorDataWindow", "newcursor cursor update Memory key : " + obj + "values : " + aVar);
                bVar.b(obj, aVar);
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                for (Object remove : objArr) {
                    bVar.xBI.remove(remove);
                }
                bVar.r(objArr);
            } else {
                if (bVar.xBJ == null) {
                    bVar.xBJ = new ArrayList();
                }
                if (!bVar.xBJ.contains(obj)) {
                    bVar.xBJ.add(obj);
                    x.i("MicroMsg.CursorDataWindow", "newcursor cursor clearData : " + obj);
                }
                bVar.xBI.remove(obj);
            }
        } else if (!this.xBV) {
            c cVar = this.xBX;
            cVar.mPos = 0;
            cVar.xBL.clear();
        }
        return false;
    }

    public final boolean ckP() {
        return this.xBY;
    }

    public final boolean DB(int i) {
        if (!this.xBV) {
            return false;
        }
        b bVar = this.xBW;
        if (i > 50) {
            return false;
        }
        if (bVar.xBH < 10) {
            return true;
        }
        if (((double) i) / ((double) bVar.xBH) < 0.1d) {
            return true;
        }
        return false;
    }

    public final boolean cd(Object obj) {
        if (this.xBV && this.xBW != null) {
            return this.xBW.cd(obj);
        }
        return false;
    }

    public final a ce(Object obj) {
        if (!this.xBV) {
            Log.e("WCDB.SQLiteNewCursor", "newcursor getItemByKey error " + obj);
            return null;
        } else if (this.xBW == null) {
            Log.e("WCDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
            return null;
        } else {
            b bVar = this.xBW;
            if (bVar.xBI != null) {
                return (a) bVar.xBI.get(obj);
            }
            return null;
        }
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void a(a aVar) {
        this.xBU = aVar;
    }

    public final SparseArray<Object>[] ckN() {
        if (!this.xBV) {
            return null;
        }
        return new SparseArray[]{this.xBW.xBG};
    }

    public final HashMap ckO() {
        return this.xBW.xBI;
    }
}
