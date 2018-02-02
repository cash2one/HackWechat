package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.g.b.dl;
import com.tencent.mm.sdk.e.i;
import java.util.concurrent.ConcurrentHashMap;

public final class bi extends i<dl> {
    public static final String[] gJN = new String[]{i.a(bh.gJc, "TablesVersion")};
    public h hhp;

    public bi(h hVar) {
        super(hVar, bh.gJc, "TablesVersion", dl.fMK);
        this.hhp = hVar;
    }

    public final ConcurrentHashMap<Integer, String> cjX() {
        Cursor a = this.hhp.a("select * from TablesVersion", new String[0], 0);
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap();
        if (a != null) {
            while (a.moveToNext()) {
                try {
                    concurrentHashMap.putIfAbsent(Integer.valueOf(a.getInt(0)), a.getString(1));
                } finally {
                    a.close();
                }
            }
        }
        return concurrentHashMap;
    }
}
