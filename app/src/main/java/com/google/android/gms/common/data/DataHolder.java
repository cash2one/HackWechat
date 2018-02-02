package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataHolder implements SafeParcelable {
    public static final g CREATOR = new g();
    private static final a aMq = new 1(new String[0]);
    public final int aJD;
    final String[] aMi;
    Bundle aMj;
    final CursorWindow[] aMk;
    final Bundle aMl;
    int[] aMm;
    int aMn;
    Object aMo;
    private boolean aMp;
    boolean mClosed;
    final int mVersionCode;

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.aMp = true;
        this.mVersionCode = i;
        this.aMi = strArr;
        this.aMk = cursorWindowArr;
        this.aJD = i2;
        this.aMl = bundle;
    }

    private DataHolder(a aVar, int i, Bundle bundle) {
        this(aVar.aMi, a(aVar), i, null);
    }

    private DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.aMp = true;
        this.mVersionCode = 1;
        this.aMi = (String[]) w.ag(strArr);
        this.aMk = (CursorWindow[]) w.ag(cursorWindowArr);
        this.aJD = i;
        this.aMl = bundle;
        ox();
    }

    private static CursorWindow[] a(a aVar) {
        int i = 0;
        if (aVar.aMi.length == 0) {
            return new CursorWindow[0];
        }
        List list = aVar.aMr;
        int size = list.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(aVar.aMi.length);
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            try {
                int i4;
                int i5;
                CursorWindow cursorWindow2;
                if (!cursorWindow.allocRow()) {
                    new StringBuilder("Allocating additional cursor window for large data set (row ").append(i2).append(")");
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i2);
                    cursorWindow.setNumColumns(aVar.aMi.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) list.get(i2);
                boolean z = true;
                for (int i6 = 0; i6 < aVar.aMi.length && z; i6++) {
                    String str = aVar.aMi[i6];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i2, i6);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i2, i6);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i2, i6);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i2, i6);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i2, i6);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i2, i6);
                    } else if (obj instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj).doubleValue(), i2, i6);
                    } else if (obj instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i2, i6);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (z) {
                    i4 = i2;
                    i5 = 0;
                    cursorWindow2 = cursorWindow;
                } else if (i3 != 0) {
                    throw new b("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    new StringBuilder("Couldn't populate window data for row ").append(i2).append(" - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i2);
                    cursorWindow3.setNumColumns(aVar.aMi.length);
                    arrayList.add(cursorWindow3);
                    i4 = i2 - 1;
                    cursorWindow2 = cursorWindow3;
                    i5 = 1;
                }
                i3 = i5;
                cursorWindow = cursorWindow2;
                i2 = i4 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                i2 = arrayList.size();
                while (i < i2) {
                    ((CursorWindow) arrayList.get(i)).close();
                    i++;
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder dm(int i) {
        return new DataHolder(aMq, i, null);
    }

    private boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final String c(String str, int i, int i2) {
        m(str, i);
        return this.aMk[i2].getString(i, this.aMj.getInt(str));
    }

    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.aMk) {
                    close.close();
                }
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final int dl(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.aMn;
        w.ar(z);
        while (i2 < this.aMm.length) {
            if (i < this.aMm[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.aMm.length ? i2 - 1 : i2;
    }

    protected final void finalize() {
        try {
            if (this.aMp && this.aMk.length > 0 && !isClosed()) {
                new StringBuilder("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (").append(this.aMo == null ? "internal object: " + toString() : this.aMo.toString()).append(")");
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    final void m(String str, int i) {
        if (this.aMj == null || !this.aMj.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.aMn) {
            throw new CursorIndexOutOfBoundsException(i, this.aMn);
        }
    }

    public final void ox() {
        int i;
        int i2 = 0;
        this.aMj = new Bundle();
        for (i = 0; i < this.aMi.length; i++) {
            this.aMj.putInt(this.aMi[i], i);
        }
        this.aMm = new int[this.aMk.length];
        i = 0;
        while (i2 < this.aMk.length) {
            this.aMm[i2] = i;
            i += this.aMk[i2].getNumRows() - (i - this.aMk[i2].getStartPosition());
            i2++;
        }
        this.aMn = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel, i);
    }
}
