package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.storage.ae;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.List;

public final class g {
    static final List<String> ds(List<String> list) {
        List<String> arrayList = new ArrayList();
        Cursor b = ((h) com.tencent.mm.kernel.g.h(h.class)).Fd().b(s.hfk, list, true, null);
        if (b.moveToFirst()) {
            int i = 0;
            do {
                aj aeVar = new ae();
                aeVar.b(b);
                if (Ma(aeVar.field_username)) {
                    arrayList.add(aeVar.field_username);
                    i++;
                    if (i >= 4) {
                        break;
                    }
                }
            } while (b.moveToNext());
        }
        b.close();
        return arrayList;
    }

    private static final boolean Ma(String str) {
        for (Object equals : s.hfr) {
            if (str.equals(equals)) {
                return false;
            }
        }
        if (s.eV(str) || s.gF(str)) {
            return false;
        }
        return true;
    }
}
