package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class ac extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS qqgroup ( grouopid int PRIMARY KEY,membernum int,weixinnum int,insert_time int,lastupdate_time int,needupdate int,updatekey text,groupname text,reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )"};
    public final h hhp;

    public ac(h hVar) {
        this.hhp = hVar;
    }

    public final ab hG(int i) {
        ab abVar = null;
        Cursor a = this.hhp.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup  where grouopid = " + i, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                abVar = new ab();
                abVar.b(a);
            }
            a.close();
        }
        return abVar;
    }

    public final boolean a(ab abVar) {
        Assert.assertTrue(abVar != null);
        ContentValues Or = abVar.Or();
        if (Or.size() <= 0) {
            x.e("MicroMsg.QQGroupStorage", "update failed, no values set");
            return false;
        }
        if (this.hhp.update("qqgroup", Or, "grouopid= ?", new String[]{abVar.hwJ}) <= 0) {
            return false;
        }
        doNotify();
        return true;
    }
}
