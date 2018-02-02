package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.protocal.c.amg;
import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.protocal.c.ami;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

class a$b implements h<Bundle, Bundle> {
    private static final String[] iSY = new String[]{"scope.userLocation"};

    private a$b() {
    }

    static /* synthetic */ void a(a$b com_tencent_mm_plugin_appbrand_dynamic_d_a_b, String str) {
        View rn = e.acF().rn(str);
        if (rn instanceof com.tencent.mm.plugin.appbrand.dynamic.h) {
            ((com.tencent.mm.plugin.appbrand.dynamic.h) rn).c(str, new 3(com_tencent_mm_plugin_appbrand_dynamic_d_a_b));
            return;
        }
        x.i("MicroMsg.IPCInvoke_DoAuthorize", "authorize failed, view is not a instance of DynamicPageAccessible.(%s)", str);
    }

    static /* synthetic */ void a(a$b com_tencent_mm_plugin_appbrand_dynamic_d_a_b, final String str, String str2, Bundle bundle, final int i) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
        LinkedList linkedList = new LinkedList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            linkedList.add((String) it.next());
        }
        a aVar = new a();
        aVar.hmi = 1158;
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_amg = new amg();
        com_tencent_mm_protocal_c_amg.ngo = str2;
        com_tencent_mm_protocal_c_amg.wta = linkedList;
        com_tencent_mm_protocal_c_amg.wtc = 0;
        com_tencent_mm_protocal_c_amg.wtb = i;
        aVar.hmj = com_tencent_mm_protocal_c_amg;
        aVar.hmk = new amh();
        b.a(aVar.JZ(), new b.a(com_tencent_mm_plugin_appbrand_dynamic_d_a_b) {
            final /* synthetic */ a$b iTa;

            public final void a(int i, int i2, String str, com.tencent.mm.ae.b bVar) {
                x.d("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0 && bVar.hmh.hmo != null && i != 2) {
                    amh com_tencent_mm_protocal_c_amh = (amh) bVar.hmh.hmo;
                    int i3 = com_tencent_mm_protocal_c_amh.wte.fts;
                    String str2 = com_tencent_mm_protocal_c_amh.wte.ftt;
                    x.i("MicroMsg.IPCInvoke_DoAuthorize", "NetSceneJSAuthorizeConfirm jsErrcode[%d], jsErrmsg[%s]", Integer.valueOf(i3), str2);
                    if (i3 == 0) {
                        a$b.a(this.iTa, str);
                    }
                }
            }
        });
    }

    static /* synthetic */ void a(a$b com_tencent_mm_plugin_appbrand_dynamic_d_a_b, String str, String str2, String str3, LinkedList linkedList, a$a com_tencent_mm_plugin_appbrand_dynamic_d_a_a) {
        final String str4 = str;
        final a$a com_tencent_mm_plugin_appbrand_dynamic_d_a_a2 = com_tencent_mm_plugin_appbrand_dynamic_d_a_a;
        final LinkedList linkedList2 = linkedList;
        final String str5 = str2;
        final String str6 = str3;
        ag.y(new Runnable(com_tencent_mm_plugin_appbrand_dynamic_d_a_b) {
            final /* synthetic */ a$b iTa;

            public final void run() {
                int i = 1;
                IPCDynamicPageView rv = com.tencent.mm.plugin.appbrand.dynamic.h.a.ade().rv(str4);
                if (rv == null) {
                    x.e("MicroMsg.IPCInvoke_DoAuthorize", "dynamicPageView not found! widgetid[%s]", str4);
                    return;
                }
                com.tencent.mm.plugin.appbrand.dynamic.widget.b bVar = new com.tencent.mm.plugin.appbrand.dynamic.widget.b(rv.getContext());
                com.tencent.mm.plugin.appbrand.dynamic.widget.b.a 1 = new 1(this);
                if (linkedList2 == null || linkedList2.size() <= 0) {
                    x.e("MicroMsg.IPCInvoke_DoAuthorize", "scopeInfoList is empty!");
                } else {
                    LinkedList linkedList = linkedList2;
                    String str = str5;
                    String str2 = str6;
                    x.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
                    bVar.mAppName = str;
                    bVar.iVz = str2;
                    if (bVar.a(null, linkedList, 1)) {
                        i = 0;
                    }
                }
                if (i != 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("retCode", -2);
                    com_tencent_mm_plugin_appbrand_dynamic_d_a_a2.i(bundle);
                }
            }
        });
    }

    static /* synthetic */ String rs(String str) {
        return str != null ? str : "";
    }

    public final /* synthetic */ void a(Object obj, i iVar) {
        Bundle bundle = (Bundle) obj;
        x.i("MicroMsg.IPCInvoke_DoAuthorize", "widget doOauthAuthorize!");
        String string = bundle.getString("scope");
        final String string2 = bundle.getString("appId");
        final String string3 = bundle.getString("widgetId");
        LinkedList linkedList = new LinkedList();
        try {
            List asList = Arrays.asList(iSY);
            JSONArray jSONArray = new JSONArray(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (asList.contains(optString)) {
                    linkedList.add(optString);
                }
            }
            if (linkedList.size() <= 0) {
                x.w("MicroMsg.IPCInvoke_DoAuthorize", "no valid scope, raw scope[%s]", string);
                return;
            }
            a aVar = new a();
            aVar.hmi = 1157;
            aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_ami = new ami();
            com_tencent_mm_protocal_c_ami.ngo = string2;
            com_tencent_mm_protocal_c_ami.wta = linkedList;
            com_tencent_mm_protocal_c_ami.wtc = 0;
            aVar.hmj = com_tencent_mm_protocal_c_ami;
            aVar.hmk = new amj();
            b.a(aVar.JZ(), new b.a(this) {
                final /* synthetic */ a$b iTa;

                public final void a(int i, int i2, String str, com.tencent.mm.ae.b bVar) {
                    x.i("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd errType[%d], errCode[%d] ,errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
                        amj com_tencent_mm_protocal_c_amj = (amj) bVar.hmh.hmo;
                        int i3 = com_tencent_mm_protocal_c_amj.wte.fts;
                        String str2 = com_tencent_mm_protocal_c_amj.wte.ftt;
                        x.i("MicroMsg.IPCInvoke_DoAuthorize", "NetSceneJSAuthorize jsErrcode[%d], jsErrmsg[%s]", Integer.valueOf(i3), str2);
                        if (i3 == -12000) {
                            a$b.a(this.iTa, string3, a$b.rs(com_tencent_mm_protocal_c_amj.niZ), a$b.rs(com_tencent_mm_protocal_c_amj.vFW), com_tencent_mm_protocal_c_amj.whQ, new a$a(this) {
                                final /* synthetic */ AnonymousClass1 iTb;

                                {
                                    this.iTb = r1;
                                }

                                public final void i(Bundle bundle) {
                                    if (bundle.getInt("retCode") == 0) {
                                        int i = bundle.getInt("resultCode");
                                        a$b.a(this.iTb.iTa, string3, string2, bundle.getBundle("resultData"), i);
                                        return;
                                    }
                                    x.e("MicroMsg.IPCInvoke_DoAuthorize", "authorize fail, retCode[%d]", Integer.valueOf(bundle.getInt("retCode")));
                                }
                            });
                        } else if (i3 == 0) {
                            a$b.a(this.iTa, string3);
                        } else {
                            x.e("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", str2);
                        }
                    }
                }
            });
        } catch (Exception e) {
            x.e("MicroMsg.IPCInvoke_DoAuthorize", "Parse scrope array string Exception[%s]", e.getMessage());
        }
    }
}
