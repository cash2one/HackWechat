package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.3;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.4.1;
import com.tencent.mm.plugin.webview.ui.tools.widget.h.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.b;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class g$4$1$1 implements a {
    final /* synthetic */ 1 tIn;

    g$4$1$1(1 1) {
        this.tIn = 1;
    }

    public final void d(int i, Bundle bundle) {
        x.i("MicroMsg.MsgHandler", "stev onRevMsg resultCode %d", Integer.valueOf(i));
        switch (i) {
            case 1:
            case 2:
                g gVar = this.tIn.tIm.tIj;
                String str = this.tIn.tIm.fgU;
                i iVar = this.tIn.tIm.tIg;
                g$a com_tencent_mm_plugin_webview_ui_tools_jsapi_g_a = this.tIn.tIm.tIk;
                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                LinkedList linkedList = new LinkedList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedList.add((String) it.next());
                }
                ar.CG().a(new b(str, linkedList, 0, i, new 3(gVar, iVar, com_tencent_mm_plugin_webview_ui_tools_jsapi_g_a, i)), 0);
                if (i == 2) {
                    g.a(this.tIn.tIm.tIj, this.tIn.tIm.tIg, "authorize:fail auth deny", null);
                    this.tIn.tIm.tIk.afC();
                    return;
                }
                return;
            default:
                x.d("MicroMsg.MsgHandler", "press back button!");
                g.a(this.tIn.tIm.tIj, this.tIn.tIm.tIg, "authorize:fail auth cancel", null);
                this.tIn.tIm.tIk.afC();
                return;
        }
    }
}
