package com.tencent.mm.plugin.bottle.a;

import android.content.ContentValues;
import com.tencent.mm.by.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.j;
import com.tencent.wcdb.FileUtils;

public final class b extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS bottleinfo1 ( parentclientid text  , childcount int  , bottleid text  PRIMARY KEY , bottletype int  , msgtype int  , voicelen int  , content text  , createtime long  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    public h hhp;

    public b(h hVar) {
        this.hhp = hVar;
    }

    public final boolean a(a aVar) {
        aVar.fDt = -1;
        ContentValues contentValues = new ContentValues();
        if ((aVar.fDt & 1) != 0) {
            contentValues.put("parentclientid", aVar.kAC == null ? "" : aVar.kAC);
        }
        if ((aVar.fDt & 2) != 0) {
            contentValues.put("childcount", Integer.valueOf(aVar.kAD));
        }
        if ((aVar.fDt & 4) != 0) {
            contentValues.put("bottleid", aVar.arx());
        }
        if ((aVar.fDt & 8) != 0) {
            contentValues.put("bottletype", Integer.valueOf(aVar.kAF));
        }
        if ((aVar.fDt & 16) != 0) {
            contentValues.put("msgtype", Integer.valueOf(aVar.msgType));
        }
        if ((aVar.fDt & 32) != 0) {
            contentValues.put("voicelen", Integer.valueOf(aVar.kAG));
        }
        if ((aVar.fDt & 64) != 0) {
            contentValues.put("content", aVar.we());
        }
        if ((aVar.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("createtime", Long.valueOf(aVar.kAH));
        }
        if ((aVar.fDt & 256) != 0) {
            contentValues.put("reserved1", Integer.valueOf(aVar.hhl));
        }
        if ((aVar.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved2", Integer.valueOf(aVar.hwo));
        }
        if ((aVar.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved3", aVar.hhn == null ? "" : aVar.hhn);
        }
        if ((aVar.fDt & 2048) != 0) {
            contentValues.put("reserved4", aVar.hho == null ? "" : aVar.hho);
        }
        if (((int) this.hhp.insert("bottleinfo1", "bottleid", contentValues)) != -1) {
            return true;
        }
        return false;
    }
}
