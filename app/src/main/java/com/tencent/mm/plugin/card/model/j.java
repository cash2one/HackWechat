package com.tencent.mm.plugin.card.model;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class j extends i<i> {
    public static final String[] gJN = new String[]{i.a(i.gJc, "CardQrCodeConfi")};
    private e gJP;

    public j(e eVar) {
        super(eVar, i.gJc, "CardQrCodeConfi", null);
        this.gJP = eVar;
    }

    public final i wg(String str) {
        c iVar = new i();
        iVar.field_card_id = str;
        return b(iVar, new String[0]) ? iVar : null;
    }
}
