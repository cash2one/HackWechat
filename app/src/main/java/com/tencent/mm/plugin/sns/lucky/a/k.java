package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.nio.charset.Charset;

public final class k {
    public static i h(a aVar) {
        i iVar;
        Exception exception;
        i iVar2 = new i();
        g.Dk();
        String str = (String) g.Dj().CU().get(aVar, null);
        if (str == null) {
            x.i("MicroMsg.RedDotUtil", "load: redDotList data empty");
            return iVar2;
        }
        try {
            iVar = (i) new i().aF(str.getBytes(Charset.forName("ISO-8859-1")));
            if (iVar == null) {
                try {
                    iVar = new i();
                } catch (Exception e) {
                    Exception exception2 = e;
                    iVar2 = iVar;
                    exception = exception2;
                    x.e("MicroMsg.RedDotUtil", "getRedDotList " + exception.getMessage());
                    iVar = iVar2;
                    if (iVar == null) {
                        return new i();
                    }
                    return iVar;
                }
            }
        } catch (Exception e2) {
            exception = e2;
            x.e("MicroMsg.RedDotUtil", "getRedDotList " + exception.getMessage());
            iVar = iVar2;
            if (iVar == null) {
                return iVar;
            }
            return new i();
        }
        if (iVar == null) {
            return new i();
        }
        return iVar;
    }
}
