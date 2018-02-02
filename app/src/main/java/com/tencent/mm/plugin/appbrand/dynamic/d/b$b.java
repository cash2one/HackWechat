package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.d;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class b$b implements a {
    private b$b() {
    }

    public final void a(Bundle bundle, c cVar) {
        String string = bundle.getString("__session_id");
        com.tencent.mm.plugin.appbrand.collector.c.a((CollectSession) bundle.getParcelable("__cost_time_session"));
        com.tencent.mm.plugin.appbrand.collector.c.aR(string, "after_cross_process_invoke");
        Bundle bundle2 = new Bundle();
        View rn = e.acF().rn(bundle.getString("viewId"));
        if (rn instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a) {
            try {
                JSONObject fy = g.fy(bundle.getString("jsApiInvokeData"));
                JSONArray optJSONArray = fy.optJSONArray("actions");
                boolean optBoolean = fy.optBoolean("reserve");
                com.tencent.mm.plugin.appbrand.collector.c.aR(string, "after_cp_parse_json_end");
                if (rn instanceof d) {
                    d dVar = (d) rn;
                    dVar.qf(string);
                    dVar.setStartTime(fy.optLong("__invoke_jsapi_timestamp"));
                }
                com.tencent.mm.plugin.appbrand.canvas.widget.a aVar = (com.tencent.mm.plugin.appbrand.canvas.widget.a) rn;
                if (optBoolean) {
                    aVar.b(optJSONArray, null);
                } else {
                    aVar.a(optJSONArray, null);
                }
                aVar.abh();
                bundle2.putBoolean("ret", true);
                cVar.i(bundle2);
                return;
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiFunc_DrawCanvas", "drawCanvas failed, IPC parse JSONObject error : %s", new Object[]{e});
                bundle2.putBoolean("ret", false);
                bundle2.putString("reason", "parse json data error");
                cVar.i(bundle2);
                return;
            }
        }
        x.i("MicroMsg.JsApiFunc_DrawCanvas", "drawCanvas failed, view is not a instance of DrawableView.(%s)", new Object[]{r0});
        bundle2.putBoolean("ret", false);
        bundle2.putString("reason", "view is not a instance of DrawableView");
        cVar.i(bundle2);
    }
}
