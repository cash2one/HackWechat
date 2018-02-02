package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bq.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class ac extends i<ab> {
    public static final String[] gJN = new String[]{i.a(ab.gJc, "GamePBCache")};

    public ac(e eVar) {
        super(eVar, ab.gJc, "GamePBCache", null);
    }

    public final byte[] BX(String str) {
        if (bh.ov(str) || !w.cfi().equals(com.tencent.mm.sdk.platformtools.ac.getContext().getSharedPreferences("game_center_pref", 0).getString("game_center_pref_lang", w.cfi()))) {
            return null;
        }
        c abVar = new ab();
        abVar.field_key = str;
        if (super.b(abVar, new String[0])) {
            return abVar.field_value;
        }
        return null;
    }

    public final boolean a(String str, a aVar) {
        boolean z = false;
        if (bh.ov(str) || aVar == null) {
            return z;
        }
        try {
            return n(str, aVar.toByteArray());
        } catch (IOException e) {
            x.e("MicroMsg.GamePBCacheStorage", "Saving Failed: %s", new Object[]{e.getMessage()});
            return z;
        }
    }

    public final boolean n(String str, byte[] bArr) {
        boolean z = false;
        if (!(bArr == null || bArr.length == 0)) {
            c abVar = new ab();
            abVar.field_key = str;
            if (super.b(abVar, new String[0])) {
                abVar.field_value = bArr;
                z = super.c(abVar, new String[0]);
            } else {
                abVar.field_value = bArr;
                z = super.b(abVar);
            }
            if (!z) {
                x.e("MicroMsg.GamePBCacheStorage", "Saving cache failed (update or insert)");
            }
        }
        return z;
    }
}
