package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends i<f> {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS  shakemessage_status_index ON shakemessage ( status )", "CREATE INDEX IF NOT EXISTS shakemessage_type_index ON shakemessage ( type )"};
    public static final String[] gJN = new String[]{i.a(f.gJc, "shakemessage")};
    public e gJP;

    public final /* synthetic */ boolean b(c cVar) {
        return a((f) cVar);
    }

    public g(e eVar) {
        super(eVar, f.gJc, "shakemessage", fMK);
        this.gJP = eVar;
    }

    public final boolean a(f fVar) {
        if (fVar == null) {
            x.e("MicroMsg.ShakeMessageStorage", "insert fail, shakeMsg is null");
            return false;
        } else if (!super.b((c) fVar)) {
            return false;
        } else {
            Wc(fVar.xjy);
            return true;
        }
    }

    public final int Tq() {
        int i;
        Cursor a = this.gJP.a("select count(*) from " + getTableName() + " where status != 1", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        return i > 0 ? i : 0;
    }
}
