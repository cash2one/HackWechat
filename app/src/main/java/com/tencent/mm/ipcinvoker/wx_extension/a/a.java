package com.tencent.mm.ipcinvoker.wx_extension.a;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class a {
    public static c fn(String str) {
        if (str.length() == 0) {
            x.i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", new Object[]{str});
            return null;
        } else if (ac.cfw()) {
            return com.tencent.mm.z.c.c.IF().fn(str);
        } else {
            Bundle bundle = (Bundle) f.a("com.tencent.mm", new IPCString(str), a.class);
            if (bundle == null) {
                return null;
            }
            c cVar = new c();
            cVar.field_layerId = bundle.getString("layerId");
            cVar.field_business = bundle.getString("business");
            cVar.field_expId = bundle.getString("expId");
            cVar.field_rawXML = bundle.getString("rawXML");
            cVar.field_startTime = bundle.getLong("startTime");
            cVar.field_endTime = bundle.getLong("endTime");
            cVar.field_sequence = bundle.getLong("sequence");
            cVar.field_prioritylevel = bundle.getInt("prioritylevel");
            cVar.field_needReport = bundle.getBoolean("needReport");
            return cVar;
        }
    }
}
