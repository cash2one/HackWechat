package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.c.bmx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

public final class b {
    public static void i(final Context context, final String str, final boolean z) {
        int i = 1;
        com.tencent.mm.sdk.b.b sgVar = new sg();
        sgVar.fJX.fnl = str;
        sgVar.fJX.action = z ? 2 : 1;
        sgVar.fJX.fJZ = 2;
        a.xef.m(sgVar);
        LinkedList linkedList = new LinkedList();
        bmx com_tencent_mm_protocal_c_bmx = new bmx();
        com_tencent_mm_protocal_c_bmx.wPY = str;
        if (!z) {
            i = 0;
        }
        com_tencent_mm_protocal_c_bmx.wPX = i;
        com_tencent_mm_protocal_c_bmx.ktN = 3;
        linkedList.add(com_tencent_mm_protocal_c_bmx);
        ar.CG().a(1176, new e() {
            public final void a(int i, int i2, String str, k kVar) {
                int i3 = 1;
                ar.CG().b(1176, this);
                x.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(true)});
                if (i != 0 || i2 != 0) {
                    u.makeText(context, R.l.ezy, 0).show();
                    com.tencent.mm.sdk.b.b sgVar = new sg();
                    sgVar.fJX.fnl = str;
                    sg.a aVar = sgVar.fJX;
                    if (!z) {
                        i3 = 2;
                    }
                    aVar.action = i3;
                    sgVar.fJX.fJZ = 2;
                    a.xef.m(sgVar);
                }
            }
        });
        ar.CG().a(new com.tencent.mm.modelappbrand.k(linkedList), 0);
    }

    public static String YB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(str);
        if (qK != null && qK.abZ() != null) {
            return qK.abZ().iPu;
        }
        x.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
        return null;
    }

    public static String YC(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(str);
        if (qK != null) {
            return qK.field_nickname;
        }
        x.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
        return null;
    }
}
