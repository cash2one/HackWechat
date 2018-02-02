package com.tencent.mm.plugin.qmessage.a;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;
import junit.framework.Assert;

public final class e extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS qcontact ( username text  PRIMARY KEY , qq long  , extinfo text  , needupdate int  , extupdateseq long  , imgupdateseq long  , reserved1 int  , reserved2 int  , reserved3 int  , reserved4 int  , reserved5 text  , reserved6 text  , reserved7 text  , reserved8 text  ) "};
    private h hhp;

    public e(h hVar) {
        this.hhp = hVar;
    }

    public final boolean a(d dVar) {
        dVar.fDt = -1;
        return ((int) this.hhp.insert("qcontact", "username", dVar.vI())) != -1;
    }

    public final boolean a(String str, d dVar) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (dVar == null) {
            return false;
        }
        if (this.hhp.update("qcontact", dVar.vI(), "username=?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public final d HD(String str) {
        d dVar = null;
        Cursor a = this.hhp.a("select qcontact.username,qcontact.qq,qcontact.extinfo,qcontact.needupdate,qcontact.extupdateseq,qcontact.imgupdateseq,qcontact.reserved1,qcontact.reserved2,qcontact.reserved3,qcontact.reserved4,qcontact.reserved5,qcontact.reserved6,qcontact.reserved7,qcontact.reserved8 from qcontact   where qcontact.username = \"" + bh.ot(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                dVar = new d();
                dVar.username = a.getString(0);
                dVar.hwR = a.getLong(1);
                dVar.extInfo = a.getString(2);
                dVar.pnt = a.getInt(3);
                dVar.pnu = a.getLong(4);
                dVar.pnv = a.getLong(5);
                dVar.hhl = a.getInt(6);
                dVar.hwo = a.getInt(7);
                dVar.hlu = a.getInt(8);
                dVar.hlv = a.getInt(9);
                dVar.pnw = a.getString(10);
                dVar.pnx = a.getString(11);
                dVar.pny = a.getString(12);
                dVar.pnz = a.getString(13);
            }
            a.close();
        }
        return dVar;
    }
}
