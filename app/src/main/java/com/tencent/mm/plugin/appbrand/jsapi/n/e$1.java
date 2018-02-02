package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.webview.ui.tools.widget.g;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class e$1 extends g {
    final /* synthetic */ e jvd;

    e$1(e eVar) {
        this.jvd = eVar;
    }

    public final Bundle e(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_webview_container_env", "miniProgram");
        switch (i) {
            case 101:
                bundle.setClassLoader(e.class.getClassLoader());
                d.b(e.f(this.jvd), bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")));
                break;
            case v.CTRL_INDEX /*139*/:
                try {
                    e.b(this.jvd).t(new JSONObject(bundle.getString("info")));
                    break;
                } catch (Exception e) {
                    break;
                }
            case b.CTRL_INDEX /*140*/:
                bundle2.putInt("key_webview_preverify_info_scene", 1);
                bundle2.putString("key_webview_preverify_info_source_appid", e.b(this.jvd).getAppId());
                break;
            case c.CTRL_INDEX /*145*/:
                bundle2.putStringArray("key_webview_apbrand_jsapi_report_args", e.b(this.jvd).ahD());
                break;
        }
        return bundle2;
    }

    public final void e(String str, String str2, int i, int i2) {
        x.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: " + str2);
        if (this.jvd.juW != null && str != null && str.equals(this.jvd.juW.tvd) && i == 22) {
            if (this.jvd.juW != null) {
                this.jvd.juW.bRG();
            }
            this.jvd.juU = i;
            this.jvd.juV = i2;
            if (str2 != null && e.g(this.jvd) != null) {
                e.b(this.jvd).runOnUiThread(new 1(this, str2));
            }
        }
    }
}
