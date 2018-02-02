package com.tencent.mm.modelstat;

import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class o$4 implements a {
    o$4() {
    }

    public final boolean uF() {
        try {
            o.Tc();
            if (o.Td() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || o.Td() <= 1000) {
                o.iE(o.Td());
                return false;
            }
            o.iD(o.Td());
            return false;
        } catch (Throwable e) {
            x.e("MicroMsg.NetTypeReporter", "run :%s", bh.i(e));
        }
    }
}
