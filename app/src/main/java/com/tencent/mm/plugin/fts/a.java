package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

public final class a extends CursorWrapper {
    private static HashSet<Cursor> mJb = new HashSet();

    public a(Cursor cursor) {
        super(cursor);
        mJb.add(cursor);
        x.v("MicroMsg.FTS.FTSCursor", "add cursor %d", new Object[]{Integer.valueOf(cursor.hashCode())});
    }

    public final void close() {
        super.close();
        mJb.remove(getWrappedCursor());
        x.v("MicroMsg.FTS.FTSCursor", "remove cursor %d", new Object[]{Integer.valueOf(r0.hashCode())});
    }

    public static final void aMN() {
        Iterator it = mJb.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) it.next();
            if (!cursor.isClosed()) {
                try {
                    cursor.close();
                } catch (Exception e) {
                }
                x.e("MicroMsg.FTS.FTSCursor", "not close cursor!!! %d", new Object[]{Integer.valueOf(cursor.hashCode())});
            }
        }
        mJb.clear();
    }
}
