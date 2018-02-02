package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class bb extends i<ba> {
    public static final String[] gJN = new String[]{i.a(ba.gJc, "OpenMsgListener")};
    public e gJP;

    public final /* synthetic */ boolean a(c cVar) {
        ba baVar = (ba) cVar;
        if (baVar == null || bh.ov(baVar.field_appId)) {
            x.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
            return false;
        }
        x.d("MicroMsg.OpenMsgListenerStorage", "replace: id=%s, ret=%s ", new Object[]{baVar.field_appId, Boolean.valueOf(this.gJP.replace("OpenMsgListener", ba.gJc.xjz, baVar.vI()) > 0)});
        return this.gJP.replace("OpenMsgListener", ba.gJc.xjz, baVar.vI()) > 0;
    }

    public bb(e eVar) {
        super(eVar, ba.gJc, "OpenMsgListener", null);
        this.gJP = eVar;
        eVar.fx("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerAppIdIndex ON OpenMsgListener ( appId )");
        eVar.fx("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerStatusIndex ON OpenMsgListener ( status )");
    }

    public final ba XC(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor a = this.gJP.a("OpenMsgListener", null, "appId=?", new String[]{bh.ot(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            ba baVar = new ba();
            baVar.b(a);
            a.close();
            return baVar;
        }
        x.w("MicroMsg.OpenMsgListenerStorage", "get null with appId:" + str);
        a.close();
        return null;
    }

    public final Cursor cjO() {
        return rawQuery("select * from OpenMsgListener where (status = ?) ", new String[]{"1"});
    }
}
