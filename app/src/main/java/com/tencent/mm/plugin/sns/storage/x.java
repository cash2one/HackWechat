package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;

public final class x extends i<w> {
    public static final String[] gJN = new String[]{i.a(w.gJc, "UxCanvasInfo")};

    public x(e eVar) {
        this(eVar, w.gJc, "UxCanvasInfo");
    }

    private x(e eVar, a aVar, String str) {
        super(eVar, aVar, str, null);
    }

    public final void a(w wVar) {
        if (wVar != null && !bh.ov(wVar.field_canvasXml)) {
            wVar.field_createTime = System.currentTimeMillis();
            if (!b(wVar)) {
                c(wVar, new String[0]);
            }
        }
    }
}
