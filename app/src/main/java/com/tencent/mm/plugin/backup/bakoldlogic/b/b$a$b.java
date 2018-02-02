package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.plugin.backup.bakoldlogic.b.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;

class b$a$b {
    StringBuffer kmW = new StringBuffer();

    b$a$b() {
    }

    public final void vs(String str) {
        this.kmW.append("<" + str + ">");
    }

    public final void vt(String str) {
        this.kmW.append("</" + str + ">");
    }

    public final void bG(String str, String str2) {
        vs(str);
        if (!bh.ov(str2)) {
            if (str2.contains(a.kmR)) {
                this.kmW.append("<![CDATA[" + bh.VG(str2) + "]]>");
            } else {
                this.kmW.append("<![CDATA[" + str2 + "]]>");
            }
        }
        vt(str);
    }

    public final void aS(String str, int i) {
        vs(str);
        this.kmW.append(i);
        vt(str);
    }

    public final void g(String str, Map<String, String> map) {
        this.kmW.append("<" + str);
        for (String str2 : map.keySet()) {
            this.kmW.append(" " + str2 + " =  \"" + ((String) map.get(str2)) + "\" ");
        }
        this.kmW.append(">");
        map.clear();
    }
}
