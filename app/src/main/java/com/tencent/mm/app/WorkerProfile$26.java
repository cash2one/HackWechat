package com.tencent.mm.app;

import android.content.Context;
import com.tencent.mm.l.a.a;
import java.util.HashMap;
import java.util.Map;

class WorkerProfile$26 implements a {
    final Map<String, Integer> fgJ = new HashMap();
    final Map<String, Integer> map = new HashMap();
    final /* synthetic */ Context val$context;

    WorkerProfile$26(Context context) {
        this.val$context = context;
    }

    public final String cE(String str) {
        if (this.map.containsKey(str)) {
            return this.val$context.getString(((Integer) this.map.get(str)).intValue());
        }
        return null;
    }

    public final String cF(String str) {
        if (this.fgJ.containsKey(str)) {
            return this.val$context.getString(((Integer) this.fgJ.get(str)).intValue());
        }
        return null;
    }
}
