package com.tencent.mm.u.c;

import android.content.Context;
import android.util.Log;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.b;
import com.tencent.mm.u.d.a;

public final class c {
    public a gOG;
    private a gOH;
    public d gOI;
    public b gOJ;

    public c(Context context, e eVar, a aVar, b bVar) {
        this.gOG = new a(context, eVar);
        this.gOH = aVar;
        this.gOJ = bVar;
    }

    public final String b(String str, String str2, int i) {
        try {
            b bVar = bh.ov(str) ? null : (b) this.gOI.gOO.get(str);
            if (bVar == null) {
                return this.gOJ.fr(str);
            }
            return this.gOJ.a(this.gOG, this.gOH, bVar, str2, new 1(this, i));
        } catch (Throwable e) {
            x.e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", new Object[]{str, Log.getStackTraceString(e)});
            throw e;
        }
    }
}
