package com.tencent.mm.plugin.zero;

import android.app.Service;
import com.tencent.mm.cd.a;

public final class PluginZero$a extends a<com.tencent.mm.plugin.zero.a.a> implements com.tencent.mm.plugin.zero.a.a {
    public final void a(Service service) {
        a(new 1(this, service));
    }

    public final void b(final Service service) {
        a(new a.a<com.tencent.mm.plugin.zero.a.a>(this) {
            final /* synthetic */ PluginZero$a vaK;

            public final /* synthetic */ void az(Object obj) {
                ((com.tencent.mm.plugin.zero.a.a) obj).b(service);
            }
        });
    }
}
