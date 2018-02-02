package com.tencent.mm.az;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;
import junit.framework.Assert;

public final class b extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS chattingbginfo ( username text  PRIMARY KEY , bgflag int  , path text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    public h hhp;

    public b(h hVar) {
        this.hhp = hVar;
    }

    public final boolean a(a aVar) {
        aVar.fDt = -1;
        if (((int) this.hhp.insert("chattingbginfo", "username", aVar.vI())) == -1) {
            return false;
        }
        Wc(aVar.getUsername());
        return true;
    }

    public final boolean b(a aVar) {
        Assert.assertTrue(aVar != null);
        ContentValues vI = aVar.vI();
        if (vI.size() > 0) {
            if (this.hhp.update("chattingbginfo", vI, "username= ?", new String[]{aVar.getUsername()}) > 0) {
                Wc(aVar.getUsername());
                return true;
            }
        }
        return false;
    }

    public final a lM(String str) {
        a aVar = null;
        Cursor a = this.hhp.a("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo   where chattingbginfo.username = \"" + bh.ot(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                aVar = new a();
                aVar.b(a);
            }
            a.close();
        }
        return aVar;
    }
}
