package com.tencent.mm.plugin.fts;

import com.tencent.mm.g.a.ry;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;

class PluginFTS$7 extends c<ry> {
    final /* synthetic */ PluginFTS mJM;

    PluginFTS$7(PluginFTS pluginFTS) {
        this.mJM = pluginFTS;
        this.xen = ry.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        PluginFTS.access$500(this.mJM).a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, new a(this) {
            String mJN = "";
            final /* synthetic */ PluginFTS$7 mJO;

            {
                this.mJO = r2;
            }

            public final boolean execute() {
                this.mJN = w.eL(ac.getContext());
                PluginFTS.access$200(this.mJO.mJM).t(-3, (long) this.mJN.hashCode());
                return true;
            }

            public final String toString() {
                return "LanguageUpdate(\"" + this.mJN + "\")";
            }
        });
        return false;
    }
}
