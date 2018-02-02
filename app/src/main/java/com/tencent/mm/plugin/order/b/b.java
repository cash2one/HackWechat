package com.tencent.mm.plugin.order.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b extends i<a> {
    public static final String[] gJN = new String[]{i.a(a.gJc, "OrderCommonMsgXml")};
    private e gJP;

    public final /* bridge */ /* synthetic */ boolean b(c cVar) {
        return super.b((a) cVar);
    }

    public final /* bridge */ /* synthetic */ boolean c(c cVar, String[] strArr) {
        return super.c((a) cVar, strArr);
    }

    public b(e eVar) {
        super(eVar, a.gJc, "OrderCommonMsgXml", null);
        this.gJP = eVar;
    }

    public final Cursor Tj() {
        return this.gJP.rawQuery("select * from OrderCommonMsgXml order by msgId desc", null);
    }

    public final boolean a(a aVar) {
        return super.b((c) aVar);
    }
}
