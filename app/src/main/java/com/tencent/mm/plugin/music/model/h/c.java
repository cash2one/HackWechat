package com.tencent.mm.plugin.music.model.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends i<b> {
    public e gJP;
    public f<String, b> oMR = new f(20);

    public c(e eVar) {
        super(eVar, b.gJc, "PieceMusicInfo", null);
        this.gJP = eVar;
    }

    public final b Gy(String str) {
        if (this.oMR.get(str) != null) {
            return (b) this.oMR.get(str);
        }
        String format = String.format("Select * From PieceMusicInfo Where musicId=?", new Object[0]);
        Cursor a = this.gJP.a(format, new String[]{str}, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            return null;
        }
        b bVar = new b();
        bVar.b(a);
        a.close();
        this.oMR.put(str, bVar);
        return bVar;
    }

    public final void p(String str, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("indexBitData", bArr);
        if (this.gJP.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str}) <= 0) {
            x.i("MicroMsg.PieceMusicInfoStorage", "updateMusicFileIndexBitCache raw=%d musicId=%s", new Object[]{Integer.valueOf(this.gJP.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str})), str});
        }
        b bVar = (b) this.oMR.get(str);
        if (bVar != null) {
            bVar.field_indexBitData = bArr;
        }
    }
}
