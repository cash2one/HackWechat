package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;
import junit.framework.Assert;

public final class i extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS facebookfriend ( fbid long  PRIMARY KEY , fbname text  , fbimgkey int  , status int  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , sex int  , personalcard int  , province text  , city text  , signature text  , alias text  , type int  , email text  ) "};
    public h hhp;

    public i(h hVar) {
        this.hhp = hVar;
    }

    public final boolean a(h hVar) {
        Assert.assertTrue("Func Set always conv_flag == flag_all", hVar.fDt == -1);
        Cursor a = this.hhp.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.fbid = \"" + bh.ot(String.valueOf(hVar.fWh)) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            int update = this.hhp.update("facebookfriend", hVar.vI(), "fbid=?", new String[]{hVar.fWh});
            if (update > 0) {
                doNotify();
            }
            if (update <= 0) {
                return false;
            }
            return true;
        }
        hVar.fDt = -1;
        return ((int) this.hhp.insert("facebookfriend", "fbid", hVar.vI())) != -1;
    }

    public final boolean NG() {
        return this.hhp.fx("facebookfriend", "delete from facebookfriend");
    }
}
