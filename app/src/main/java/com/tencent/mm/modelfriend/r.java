package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;

public final class r extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    private h hhp;

    public r(h hVar) {
        this.hhp = hVar;
    }

    public final boolean a(q qVar) {
        if (la(qVar.getUsername())) {
            qVar.fDt = -1;
            if (this.hhp.update("invitefriendopen", qVar.vI(), "username=?", new String[]{qVar.getUsername()}) > 0) {
                return true;
            }
            return false;
        }
        qVar.fDt = -1;
        if (((int) this.hhp.insert("invitefriendopen", "username", qVar.vI())) == -1) {
            return false;
        }
        return true;
    }

    public final boolean la(String str) {
        Cursor a = this.hhp.a("select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + bh.ot(str) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        return moveToFirst;
    }
}
