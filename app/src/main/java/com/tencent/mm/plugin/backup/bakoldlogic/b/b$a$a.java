package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;

class b$a$a {
    Map<String, String> kmU = null;
    boolean kmV = true;

    public b$a$a(String str) {
        this.kmU = ax.Vo(str);
        if (this.kmU == null) {
            this.kmV = false;
            this.kmU = new HashMap();
        }
    }

    final int getInt(String str) {
        if (this.kmU.containsKey(str)) {
            return bh.getInt((String) this.kmU.get(str), 0);
        }
        return 0;
    }
}
