package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.o;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class u extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS voiceinfo ( FileName TEXT PRIMARY KEY, User TEXT, MsgId INT, NetOffset INT, FileNowSize INT, TotalLen INT, Status INT, CreateTime INT, LastModifyTime INT, ClientId TEXT, VoiceLength INT, MsgLocalId INT, Human TEXT, reserved1 INT, reserved2 TEXT, MsgSource TEXT, MsgFlag INT, MsgSeq INT, MasterBufId INT, checksum INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS voiceinfomsgidindex ON voiceinfo ( MsgId ) ", "CREATE UNIQUE INDEX IF NOT EXISTS voiceinfouniqueindex ON voiceinfo ( FileName )"};
    Map<String, a> hXR = new HashMap();
    Map<String, l> hXS = new HashMap();
    Map<String, h> hXT = new HashMap();
    public h hhp;

    public u(h hVar) {
        b(hVar);
        this.hhp = hVar;
    }

    private static void b(h hVar) {
        int i = 0;
        Cursor a = hVar.a("PRAGMA table_info(voiceinfo)", null, 0);
        if (a == null) {
            x.i("MicroMsg.VoiceStorage", "addNewColIfNeed failed, cursor is null.");
            return;
        }
        int columnIndex = a.getColumnIndex("name");
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("MsgSource".equals(string)) {
                    i5 = 1;
                }
                if ("MsgFlag".equals(string)) {
                    i4 = 1;
                }
                if ("MsgSeq".equals(string)) {
                    i3 = 1;
                }
                if ("MasterBufId".equals(string)) {
                    i2 = 1;
                }
                if ("checksum".equals(string)) {
                    i = 1;
                }
            }
        }
        a.close();
        if (i5 == 0) {
            hVar.fx("voiceinfo", "Alter table voiceinfo add MsgSource TEXT");
        }
        if (i4 == 0) {
            hVar.fx("voiceinfo", "Alter table voiceinfo add MsgFlag INT");
        }
        if (i3 == 0) {
            hVar.fx("voiceinfo", "Alter table voiceinfo add MsgSeq INT");
        }
        if (i2 == 0) {
            hVar.fx("voiceinfo", "Alter table voiceinfo add MasterBufId INT");
        }
        if (i == 0) {
            hVar.fx("voiceinfo", "Alter table voiceinfo add checksum INT DEFAULT 0");
        }
    }

    public static String oe(String str) {
        return o.k(str, bh.Wp());
    }

    public final boolean b(p pVar) {
        Assert.assertTrue(pVar != null);
        ContentValues vI = pVar.vI();
        if (vI.size() <= 0) {
            x.e("MicroMsg.VoiceStorage", "insert falied, no values set");
        } else if (this.hhp.insert("voiceinfo", "FileName", vI) != -1) {
            doNotify();
            return true;
        }
        return false;
    }

    public final boolean iF(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.hhp.delete("voiceinfo", "FileName= ?", new String[]{str}) <= 0) {
            x.w("MicroMsg.VoiceStorage", "delete failed, no such file:" + str);
        }
        return true;
    }

    public final boolean a(String str, p pVar) {
        boolean z;
        Assert.assertTrue(str.length() > 0);
        if (pVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues vI = pVar.vI();
        if (vI.size() <= 0) {
            x.e("MicroMsg.VoiceStorage", "update failed, no values set");
        } else {
            if (this.hhp.update("voiceinfo", vI, "FileName= ?", new String[]{str}) > 0) {
                doNotify();
                return true;
            }
        }
        return false;
    }

    public final p bw(long j) {
        p pVar = null;
        Cursor a = this.hhp.a("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE MsgId=" + j, null, 2);
        if (a.moveToFirst()) {
            pVar = new p();
            pVar.b(a);
        }
        a.close();
        return pVar;
    }

    public final p iM(int i) {
        p pVar = null;
        Cursor a = this.hhp.a("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE MsgLocalId=" + i, null, 2);
        if (a.moveToFirst()) {
            pVar = new p();
            pVar.b(a);
        }
        a.close();
        return pVar;
    }

    public final p of(String str) {
        p pVar = null;
        String str2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE FileName= ?";
        Cursor a = this.hhp.a(str2, new String[]{str}, 2);
        if (a.moveToFirst()) {
            pVar = new p();
            pVar.b(a);
        }
        a.close();
        return pVar;
    }
}
