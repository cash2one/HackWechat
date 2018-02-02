package com.tencent.mm.ipcinvoker.wx_extension;

import android.content.Context;
import com.tencent.mm.ipcinvoker.a.b;
import com.tencent.mm.ipcinvoker.g.1;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class e implements c {

    private static final class a {
        private static final e gNj = new e();
    }

    private e() {
        Context context = ((h) g.Dg().CN()).gSI;
        b 1 = new 1(this);
        Assert.assertNotNull(context);
        com.tencent.mm.ipcinvoker.e.gMy = context;
        1.a(new 1());
        1.a(com.tencent.mm.ipcinvoker.b.Bs());
        x.i("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", new Object[]{com.tencent.mm.ipcinvoker.e.Bu(), Integer.valueOf(context.hashCode())});
        if (ac.cfy()) {
            com.tencent.mm.ipcinvoker.g.fi("com.tencent.mm:tools");
        }
    }
}
