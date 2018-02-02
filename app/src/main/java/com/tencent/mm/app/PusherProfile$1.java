package com.tencent.mm.app;

import com.tencent.mm.g.a.gk;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class PusherProfile$1 extends c<gk> {
    final /* synthetic */ PusherProfile ffH;

    PusherProfile$1(PusherProfile pusherProfile) {
        this.ffH = pusherProfile;
        this.xen = gk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = "gcm";
        String str2 = "GCMDoSyncEvent Notify Now Always should be MM_NEWSYNC_DEFAULT_SELECTOR  & SCENE_SYNC_GCM  atapter == null[%b]";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(aa.VS() == null);
        x.i(str, str2, objArr);
        if (aa.VS() != null) {
            aa.VS().onPush(2147480001, new byte[0]);
        } else {
            aa.cf(true);
        }
        return true;
    }
}
