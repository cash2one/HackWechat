package com.tencent.mm.e.b;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class g {
    public static final String fln = (e.bnF + "test.wav");
    public static final String flo = (e.bnF + "test.pcm");

    public static int t(String str, int i) {
        try {
            i = bh.getInt(((a) com.tencent.mm.kernel.g.h(a.class)).zY().getValue(str), i);
        } catch (Exception e) {
            x.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: " + str);
        } catch (Error e2) {
            x.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: " + str);
        }
        return i;
    }
}
