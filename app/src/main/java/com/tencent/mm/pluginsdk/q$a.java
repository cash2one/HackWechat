package com.tencent.mm.pluginsdk;

import com.tencent.mm.pluginsdk.q.b;
import com.tencent.mm.pluginsdk.q.c;
import com.tencent.mm.pluginsdk.q.e;
import com.tencent.mm.pluginsdk.q.g;
import com.tencent.mm.pluginsdk.q.h;
import com.tencent.mm.pluginsdk.q.i;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.pluginsdk.q.n;
import com.tencent.mm.pluginsdk.q.p;
import com.tencent.mm.pluginsdk.q.r;
import com.tencent.mm.sdk.platformtools.x;

public class q$a {
    public static b vcA;
    public static q$m vcp;
    public static n vcq;
    public static e vcr;
    public static i vcs;
    public static c vct;
    public static j vcu;
    public static p vcv;
    public static r vcw;
    public static g vcx;
    public static q$v vcy;
    public static h vcz;

    public static i bXY() {
        if (vcs == null) {
            x.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
            vcs = new com.tencent.mm.pluginsdk.b.c();
        }
        return vcs;
    }

    public static j bXZ() {
        return vcu;
    }
}
