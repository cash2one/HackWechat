package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class f$b extends a {
    final /* synthetic */ f mOg;

    private f$b(f fVar) {
        this.mOg = fVar;
    }

    public final boolean execute() {
        StringBuffer stringBuffer = new StringBuffer();
        long length = c.aMP().length();
        e.mKJ.mKK = length / 1048576;
        stringBuffer.append("[DBSize]=" + bh.fK(length));
        stringBuffer.append("\n");
        e.mKJ.mKL = aNi();
        e.mKJ.mKM = aNj();
        e.mKJ.mKO = aNg();
        e.mKJ.mKN = aNh();
        ((m) g.k(m.class)).getFTSIndexDB().t(-301, e.mKJ.mKL);
        ((m) g.k(m.class)).getFTSIndexDB().t(-302, e.mKJ.mKM);
        ((m) g.k(m.class)).getFTSIndexDB().t(-303, e.mKJ.mKO);
        ((m) g.k(m.class)).getFTSIndexDB().t(-304, e.mKJ.mKN);
        stringBuffer.append("[WXContact]=" + e.mKJ.mKL);
        stringBuffer.append("\n");
        stringBuffer.append("[WXChatroom]=" + e.mKJ.mKM);
        stringBuffer.append("\n");
        stringBuffer.append("[Favorite]=" + e.mKJ.mKO);
        stringBuffer.append("\n");
        stringBuffer.append("[Message]=" + e.mKJ.mKN);
        String stringBuffer2 = stringBuffer.toString();
        x.i("MicroMsg.FTS.FTSSearchTestLogic", stringBuffer2);
        File file = new File(com.tencent.mm.plugin.fts.a.c.mKv, "FTS5IndexMicroMsgInfo.txt");
        if (file.exists()) {
            file.delete();
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        int j = FileOp.j(file.getAbsolutePath(), stringBuffer2.getBytes());
        x.i("MicroMsg.FTS.FTSSearchTestLogic", "write fts info %d %s", new Object[]{Integer.valueOf(j), file.getAbsolutePath()});
        return true;
    }

    private static long aNg() {
        Cursor rawQuery = ((m) g.k(m.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE subtype = %d", new Object[]{"FTS5MetaFavorite", Integer.valueOf(9)}), null);
        try {
            if (rawQuery.moveToNext()) {
                long j = rawQuery.getLong(0);
                return j;
            }
            rawQuery.close();
            return 0;
        } finally {
            rawQuery.close();
        }
    }

    private static long aNh() {
        Cursor rawQuery = ((m) g.k(m.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s", new Object[]{"FTS5MetaMessage"}), null);
        try {
            if (rawQuery.moveToNext()) {
                long j = rawQuery.getLong(0);
                return j;
            }
            rawQuery.close();
            return 0;
        } finally {
            rawQuery.close();
        }
    }

    private static long aNi() {
        Cursor rawQuery = ((m) g.k(m.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[]{"FTS5MetaContact", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT), Integer.valueOf(1)}), null);
        try {
            if (rawQuery.moveToNext()) {
                long j = rawQuery.getLong(0);
                return j;
            }
            rawQuery.close();
            return 0;
        } finally {
            rawQuery.close();
        }
    }

    private static long aNj() {
        Cursor rawQuery = ((m) g.k(m.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[]{"FTS5MetaContact", Integer.valueOf(131075), Integer.valueOf(38)}), null);
        try {
            if (rawQuery.moveToNext()) {
                long j = rawQuery.getLong(0);
                return j;
            }
            rawQuery.close();
            return 0;
        } finally {
            rawQuery.close();
        }
    }

    public final String getName() {
        return "FTS5DBInfoTask";
    }
}
