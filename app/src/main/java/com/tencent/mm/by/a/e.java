package com.tencent.mm.by.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.mm.by.a.f.a;
import com.tencent.wcdb.AbstractCursor;
import java.util.HashMap;

public final class e extends AbstractCursor implements d {
    private DataSetObserver mObserver = new 1(this);
    private d xBQ;
    public d[] xBR;

    public e(f[] fVarArr) {
        int i = 0;
        this.xBR = fVarArr;
        this.xBQ = fVarArr[0];
        while (i < this.xBR.length) {
            if (this.xBR[i] != null) {
                this.xBR[i].registerDataSetObserver(this.mObserver);
            }
            i++;
        }
    }

    public final int getCount() {
        int i = 0;
        int length = this.xBR.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.xBR[i2] != null) {
                i += this.xBR[i2].getCount();
            }
        }
        return i;
    }

    public final boolean onMove(int i, int i2) {
        this.xBQ = null;
        int length = this.xBR.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.xBR[i4] != null) {
                if (i2 < this.xBR[i4].getCount() + i3) {
                    this.xBQ = this.xBR[i4];
                    break;
                }
                i3 += this.xBR[i4].getCount();
            }
        }
        if (this.xBQ != null) {
            return this.xBQ.moveToPosition(i2 - i3);
        }
        return false;
    }

    public final String getString(int i) {
        return this.xBQ.getString(i);
    }

    public final short getShort(int i) {
        return this.xBQ.getShort(i);
    }

    public final int getInt(int i) {
        return this.xBQ.getInt(i);
    }

    public final long getLong(int i) {
        return this.xBQ.getLong(i);
    }

    public final float getFloat(int i) {
        return this.xBQ.getFloat(i);
    }

    public final double getDouble(int i) {
        return this.xBQ.getDouble(i);
    }

    public final boolean isNull(int i) {
        return this.xBQ.isNull(i);
    }

    public final byte[] getBlob(int i) {
        return this.xBQ.getBlob(i);
    }

    public final String[] getColumnNames() {
        if (this.xBQ != null) {
            return this.xBQ.getColumnNames();
        }
        return new String[0];
    }

    public final void deactivate() {
        int length = this.xBR.length;
        for (int i = 0; i < length; i++) {
            if (this.xBR[i] != null) {
                this.xBR[i].deactivate();
            }
        }
        super.deactivate();
    }

    public final void close() {
        int length = this.xBR.length;
        for (int i = 0; i < length; i++) {
            if (this.xBR[i] != null) {
                this.xBR[i].close();
            }
        }
        super.close();
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
        int length = this.xBR.length;
        for (int i = 0; i < length; i++) {
            if (this.xBR[i] != null) {
                this.xBR[i].registerContentObserver(contentObserver);
            }
        }
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
        int length = this.xBR.length;
        for (int i = 0; i < length; i++) {
            if (this.xBR[i] != null) {
                this.xBR[i].unregisterContentObserver(contentObserver);
            }
        }
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.xBR.length;
        for (int i = 0; i < length; i++) {
            if (this.xBR[i] != null) {
                this.xBR[i].registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.xBR.length;
        for (int i = 0; i < length; i++) {
            if (this.xBR[i] != null) {
                this.xBR[i].unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public final boolean requery() {
        int length = this.xBR.length;
        int i = 0;
        while (i < length) {
            if (this.xBR[i] != null && !this.xBR[i].requery()) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final void a(a aVar) {
        int length = this.xBR.length;
        for (int i = 0; i < length; i++) {
            if (this.xBR[i] != null) {
                this.xBR[i].a(aVar);
            }
        }
    }

    public final void lJ(boolean z) {
        int length = this.xBR.length;
        for (int i = 0; i < length; i++) {
            if (this.xBR[i] != null) {
                this.xBR[i].lJ(z);
            }
        }
    }

    public final boolean ckP() {
        int length = this.xBR.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            if (!(this.xBR[i] == null || this.xBR[i].ckP())) {
                z = false;
            }
            i++;
        }
        return z;
    }

    public final a DC(int i) {
        int length = this.xBR.length;
        for (int i2 = 0; i2 < length; i2++) {
            int count = this.xBR[i2].getCount();
            if (i < count) {
                return this.xBR[i2].DC(i);
            }
            i -= count;
        }
        return null;
    }

    public final boolean a(Object obj, a aVar) {
        boolean z = false;
        int length = this.xBR.length;
        int i = 0;
        while (i < length) {
            if (this.xBR[i] != null && this.xBR[i].a(obj, aVar)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public final SparseArray<Object>[] ckN() {
        int length = this.xBR.length;
        SparseArray<Object>[] sparseArrayArr = new SparseArray[length];
        for (int i = 0; i < length; i++) {
            SparseArray[] ckN = this.xBR[i].ckN();
            sparseArrayArr[i] = ckN != null ? ckN[0] : null;
        }
        return sparseArrayArr;
    }

    public final HashMap ckO() {
        return null;
    }

    public final boolean DB(int i) {
        int length = this.xBR.length;
        boolean z = true;
        int i2 = 0;
        while (i2 < length) {
            if (!(this.xBR[i2] == null || this.xBR[i2].DB(i))) {
                z = false;
            }
            i2++;
        }
        return z;
    }

    public final boolean cd(Object obj) {
        boolean z = false;
        int length = this.xBR.length;
        int i = 0;
        while (i < length) {
            if (this.xBR[i] != null && this.xBR[i].cd(obj)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public final a ce(Object obj) {
        return this.xBQ.ce(obj);
    }

    public final void DD(int i) {
        int length = this.xBR.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.xBR[i2] != null) {
                this.xBR[i2].DD(i);
            }
        }
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }
}
