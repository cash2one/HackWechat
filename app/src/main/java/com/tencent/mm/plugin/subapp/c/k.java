package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.a.g;
import com.tencent.mm.g.b.dp;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class k extends i<g> {
    public static final String[] gJN = new String[]{i.a(g.gJc, "VoiceRemindInfo")};
    private static long hVS = 0;
    e gJP;
    Map<String, c> rWI = new HashMap();

    public k(e eVar) {
        super(eVar, g.gJc, "VoiceRemindInfo", dp.fMK);
        this.gJP = eVar;
    }

    public static String ns(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + g.s(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = hVS;
        hVS = 1 + currentTimeMillis;
        return append.append(currentTimeMillis).toString();
    }

    public final boolean iF(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.gJP.delete("VoiceRemindInfo", "filename= ?", new String[]{str}) <= 0) {
            x.w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:" + str);
        }
        return true;
    }

    public final void nU(String str) {
        c cVar = (c) this.rWI.get(str);
        if (cVar != null) {
            cVar.Uu();
            this.rWI.remove(str);
        }
    }
}
