package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class bk extends i<bj> {
    public static final String[] gJN = new String[]{i.a(bj.gJc, "UserOpenIdInApp")};
    public e gJP;

    public bk(e eVar) {
        super(eVar, bj.gJc, "UserOpenIdInApp", null);
        this.gJP = eVar;
        eVar.fx("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
        eVar.fx("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
    }

    public final bj XM(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor a = this.gJP.a("UserOpenIdInApp", null, "openId=?", new String[]{bh.ot(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bj bjVar = new bj();
            bjVar.b(a);
            a.close();
            return bjVar;
        }
        x.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:" + str);
        a.close();
        return null;
    }

    public final boolean a(bj bjVar) {
        if (bjVar == null || bh.ov(bjVar.field_appId) || bh.ov(bjVar.field_openId) || bh.ov(bjVar.field_username)) {
            x.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
            return false;
        }
        boolean z;
        if (this.gJP.replace("UserOpenIdInApp", bj.gJc.xjz, bjVar.vI()) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", new Object[]{bjVar.field_appId, bjVar.field_username, Boolean.valueOf(z)});
        return z;
    }
}
