package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;

public abstract class b extends c {
    protected final String c(String str, au auVar) {
        if (s.eV(str)) {
            String d = d(str, auVar);
            return String.format(ac.getContext().getString(R.l.eyQ), new Object[]{h.NM(d), Character.valueOf('​'), h.W(auVar).nje});
        }
        return String.format(ac.getContext().getString(R.l.eyR), new Object[]{h.W(auVar).nje});
    }

    protected static String d(String str, au auVar) {
        if (!s.eV(str)) {
            return str;
        }
        int hO = ba.hO(auVar.field_content);
        if (hO == -1) {
            return str;
        }
        String trim = auVar.field_content.substring(0, hO).trim();
        if (trim == null || trim.length() <= 0) {
            return str;
        }
        return trim;
    }
}
