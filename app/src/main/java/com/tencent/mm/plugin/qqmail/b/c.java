package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class c {
    public e pob;

    public c(String str) {
        this.pob = new e(str, 10);
    }

    public final d bS(String str, int i) {
        byte[] readFromFile = e.readFromFile(this.pob.pol + bT(str, i));
        if (readFromFile == null || readFromFile.length == 0) {
            return null;
        }
        try {
            return (d) new d().aF(readFromFile);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
            return null;
        }
    }

    public static String bT(String str, int i) {
        if (str != null && str.length() != 0) {
            return str + "_" + i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(com.tencent.mm.z.c.CU().get(9, null)).toString();
    }
}
