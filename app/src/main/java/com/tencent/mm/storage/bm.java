package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;

public final class bm extends i<bl> implements a {
    public static final String[] gJN = new String[]{i.a(bl.gJc, "VoiceTransText")};
    public e gJP;

    public final /* synthetic */ boolean b(c cVar) {
        return a((bl) cVar);
    }

    public bm(e eVar) {
        this(eVar, bl.gJc, "VoiceTransText");
    }

    private bm(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gJP = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final boolean a(bl blVar) {
        if (blVar == null) {
            return false;
        }
        if (this.gJP.replace("VoiceTransText", "msgId", blVar.vI()) >= 0) {
            return true;
        }
        return false;
    }

    public final bl XO(String str) {
        if (bh.ov(str)) {
            return null;
        }
        bl blVar = new bl();
        Cursor a = this.gJP.a("VoiceTransText", null, "cmsgId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            blVar.b(a);
        }
        a.close();
        return blVar;
    }
}
