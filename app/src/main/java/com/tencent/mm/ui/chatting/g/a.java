package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Map;
import junit.framework.Assert;

public abstract class a {
    WeakReference<b> yHV = null;

    abstract CharSequence a(Map<String, String> map, String str, WeakReference<Context> weakReference);

    abstract String cvv();

    public a(b bVar) {
        Assert.assertNotNull(bVar);
        this.yHV = new WeakReference(bVar);
        ((e) g.h(e.class)).a(cvv(), new b(this) {
            final /* synthetic */ a yHW;

            {
                this.yHW = r1;
            }

            public final CharSequence a(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference) {
                String string = bundle.getString("conv_talker_username", "");
                if (map == null) {
                    x.w("MicroMsg.SysMsgHandlerBase", "hy: non map!!");
                    return null;
                } else if (bh.ov(str)) {
                    x.w("MicroMsg.SysMsgHandlerBase", "hy: non header!!");
                    return null;
                } else if (!bh.ov(string)) {
                    return this.yHW.a(map, str, weakReference);
                } else {
                    x.w("MicroMsg.SysMsgHandlerBase", "hy: not resolved talker!!");
                    return null;
                }
            }
        });
    }

    public final void release() {
        ((e) g.h(e.class)).Eo(cvv());
    }
}
