package com.tencent.mm.by.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.wcdb.AbstractCursor;

public final class c extends AbstractCursor {
    final int columnCount;
    private final String[] columnNames;
    SparseArray<Object[]> xBL;
    public int xBM;
    int xBN;

    public class a {
        final int endIndex;
        int index;
        Object[] xBO;
        final /* synthetic */ c xBP;

        a(c cVar, int i, int i2, Object[] objArr) {
            this.xBP = cVar;
            this.index = i;
            this.endIndex = i2;
            this.xBO = objArr;
        }
    }

    private c(String[] strArr) {
        this.xBM = 3000;
        this.columnNames = strArr;
        this.columnCount = strArr.length;
        this.xBL = new SparseArray();
    }

    public c(String[] strArr, byte b) {
        this(strArr);
    }

    private Object get(int i) {
        if (i < 0 || i >= this.columnCount) {
            throw new CursorIndexOutOfBoundsException("Requested column: " + i + ", # of columns: " + this.columnCount);
        } else if (this.mPos < 0) {
            throw new CursorIndexOutOfBoundsException("Before first row.");
        } else if (this.mPos >= this.xBN) {
            throw new CursorIndexOutOfBoundsException("After last row.");
        } else {
            return ((Object[]) this.xBL.get(this.mPos / this.xBM))[((this.mPos % this.xBM) * this.columnCount) + i];
        }
    }

    public final int getCount() {
        return this.xBN;
    }

    public final String[] getColumnNames() {
        return this.columnNames;
    }

    public final String getString(int i) {
        Object obj = get(i);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public final short getShort(int i) {
        Object obj = get(i);
        if (obj == null) {
            return (short) 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).shortValue();
        }
        return Short.parseShort(obj.toString());
    }

    public final int getInt(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return Integer.parseInt(obj.toString());
    }

    public final long getLong(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        return Long.parseLong(obj.toString());
    }

    public final float getFloat(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0.0f;
        }
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        return Float.parseFloat(obj.toString());
    }

    public final double getDouble(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0.0d;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        return Double.parseDouble(obj.toString());
    }

    public final boolean isNull(int i) {
        return get(i) == null;
    }

    public final byte[] getBlob(int i) {
        Object obj = get(i);
        if (obj == null) {
            return null;
        }
        return (byte[]) obj;
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
