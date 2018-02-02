package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.c;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.bsb;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

class g$49 extends c {
    final /* synthetic */ i tIg;
    final /* synthetic */ JsapiPermissionWrapper tIh;
    final /* synthetic */ g tIj;

    g$49(g gVar, JsapiPermissionWrapper jsapiPermissionWrapper, i iVar) {
        this.tIj = gVar;
        this.tIh = jsapiPermissionWrapper;
        this.tIg = iVar;
    }

    public final void a(a aVar, String str, LinkedList<bsb> linkedList, int i, int i2) {
        if (aVar != a.tGC || this.tIh.vAQ == null) {
            if (g.z(this.tIj) != null) {
                Bundle bundle = new Bundle();
                bundle.putByteArray("jsapi_control_bytes", this.tIh.vAQ);
                try {
                    x.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI fail, update controlBytes with default permission");
                    g.z(this.tIj).n(1006, bundle);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", new Object[]{e.getMessage()});
                }
            }
            if (bh.ov(str)) {
                g.a(this.tIj, this.tIg, "pre_verify_jsapi:fail", null);
                return;
            } else {
                g.a(this.tIj, this.tIg, "pre_verify_jsapi:fail_" + str, null);
                return;
            }
        }
        int i3;
        g.b(this.tIj, bh.Wo());
        if (linkedList == null || linkedList.size() <= 0) {
            i3 = 0;
        } else {
            Iterator it = linkedList.iterator();
            i3 = 0;
            while (it.hasNext()) {
                bsb com_tencent_mm_protocal_c_bsb = (bsb) it.next();
                g Tm = com.tencent.mm.protocal.c.Tm(bh.ou(com_tencent_mm_protocal_c_bsb.wsE));
                if (Tm != null) {
                    int i4;
                    if (this.tIh.CF(Tm.cds()) != com_tencent_mm_protocal_c_bsb.state) {
                        this.tIh.a(Tm.cds(), (byte) com_tencent_mm_protocal_c_bsb.state);
                        i4 = 1;
                    } else {
                        i4 = i3;
                    }
                    i3 = i4;
                }
            }
        }
        if (!(i3 == 0 || g.z(this.tIj) == null)) {
            Bundle bundle2 = new Bundle();
            bundle2.putByteArray("jsapi_control_bytes", this.tIh.vAQ);
            try {
                String str2 = "MicroMsg.MsgHandler";
                String str3 = "doPreVerifyJSAPI update controlBytes, %d, jsPerm = %s";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(this.tIh.vAQ == null ? 0 : this.tIh.vAQ.length);
                objArr[1] = this.tIh;
                x.i(str2, str3, objArr);
                g.z(this.tIj).n(1006, bundle2);
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", new Object[]{e2.getMessage()});
            }
        }
        g.a(this.tIj, this.tIg, "pre_verify_jsapi:ok", null);
    }

    public final boolean bUl() {
        return this.tGH;
    }
}
