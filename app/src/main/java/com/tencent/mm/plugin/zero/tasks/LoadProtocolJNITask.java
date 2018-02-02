package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;

public class LoadProtocolJNITask extends a {
    public void execute(g gVar) {
        k.b("MMProtocalJni", getClass().getClassLoader());
        MMProtocalJni.setClientPackVersion(d.vAz);
        MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
        MMProtocalJni.setIsLite(false);
    }

    public String name() {
        return "boot-load-MMProtocalJni-library";
    }
}
