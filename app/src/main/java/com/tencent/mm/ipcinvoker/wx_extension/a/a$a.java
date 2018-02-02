package com.tencent.mm.ipcinvoker.wx_extension.a;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

class a$a implements j<IPCString, Bundle> {
    private a$a() {
    }

    public final /* synthetic */ Object at(Object obj) {
        IPCString iPCString = (IPCString) obj;
        if (g.Dk().gQE.gQX && g.Dh().gPy) {
            c fn = com.tencent.mm.z.c.c.IF().fn(iPCString.value);
            Object bundle = new Bundle();
            bundle.putString("layerId", fn.field_layerId);
            bundle.putString("business", fn.field_business);
            bundle.putString("expId", fn.field_expId);
            bundle.putString("rawXML", fn.field_rawXML);
            bundle.putLong("startTime", fn.field_startTime);
            bundle.putLong("endTime", fn.field_endTime);
            bundle.putLong("sequence", fn.field_sequence);
            bundle.putInt("prioritylevel", fn.field_prioritylevel);
            bundle.putBoolean("needReport", fn.field_needReport);
            return bundle;
        }
        x.i("MicroMsg.IPCInvokeTask_GetABTestItem", "kernel or account not ready.");
        return null;
    }
}
