package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ae.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.dw;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 208;
    public static final String NAME = "requestAuthUserAutoFillData";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData data is invalid");
            pVar.E(i, e("fail:data is invalid", null));
            return;
        }
        int i2;
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("fields");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList.add(optJSONArray.optString(i2));
            }
        }
        final Object optString = jSONObject.optString("wording");
        final int optInt = jSONObject.optInt("authStatus", 2);
        final LinkedList linkedList2 = new LinkedList();
        optJSONArray = jSONObject.optJSONArray("authGroupList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList2.add("  " + optJSONArray.optString(i2));
            }
        }
        if (linkedList.size() == 0) {
            x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData fields is empty");
            pVar.E(i, e("fail:fields is empty", null));
        } else if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData wording is empty");
            pVar.E(i, e("fail:wording is empty", null));
        } else {
            x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData appId:%s", new Object[]{pVar.mAppId});
            x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "wording:%s, authType:%d, fieldIds:%s", new Object[]{optString, Integer.valueOf(optInt), jSONObject.optJSONArray("fields").toString()});
            if (jSONObject.optJSONArray("authGroupList") != null) {
                x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "authGroupList:%s", new Object[]{jSONObject.optJSONArray("authGroupList").toString()});
            }
            b.a aVar = new b.a();
            aVar.hmj = new dw();
            aVar.hmk = new dx();
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo";
            aVar.hmi = 1183;
            aVar.hml = 0;
            aVar.hmm = 0;
            final b JZ = aVar.JZ();
            final dw dwVar = (dw) JZ.hmg.hmo;
            dwVar.vJq = linkedList;
            dwVar.fFm = r0;
            dwVar.vJs = optInt;
            final p pVar2 = pVar;
            final int i3 = i;
            ag.y(new Runnable(this) {
                final /* synthetic */ f jhc;

                public final void run() {
                    f fVar = this.jhc;
                    p pVar = pVar2;
                    int i = i3;
                    dw dwVar = dwVar;
                    b bVar = JZ;
                    int i2 = optInt;
                    CharSequence charSequence = optString;
                    LinkedList linkedList = linkedList2;
                    String string = i2 == 2 ? pVar.mContext.getString(j.iyy) : pVar.mContext.getString(j.iyz);
                    String string2 = pVar.mContext.getString(j.iyA);
                    String string3 = pVar.mContext.getString(j.iyx);
                    CharSequence string4 = pVar.mContext.getString(j.iyw);
                    LayoutInflater layoutInflater = (LayoutInflater) pVar.mContext.getSystemService("layout_inflater");
                    View inflate = layoutInflater.inflate(h.iwL, null);
                    TextView textView = (TextView) inflate.findViewById(g.itA);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(g.itB);
                    ((TextView) inflate.findViewById(g.itz)).setText(charSequence);
                    textView.setText(string4);
                    textView.setOnClickListener(new 2(fVar, pVar));
                    linearLayout.removeAllViews();
                    if (linkedList == null || linkedList.size() <= 0) {
                        LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
                        layoutParams.leftMargin = 0;
                        textView.setLayoutParams(layoutParams);
                        linearLayout.setVisibility(8);
                    } else {
                        linearLayout.setVisibility(0);
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            textView = (TextView) layoutInflater.inflate(h.iwH, null);
                            textView.setText((String) it.next());
                            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -2);
                            layoutParams2.bottomMargin = pVar.getContentView().getResources().getDimensionPixelOffset(e.isH);
                            textView.setLayoutParams(layoutParams2);
                            linearLayout.addView(textView);
                        }
                    }
                    x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
                    com.tencent.mm.ui.base.h.a(pVar.mContext, false, string, inflate, string2, string3, (OnClickListener) new 3(fVar, dwVar, pVar, i, bVar), (OnClickListener) new 4(fVar, dwVar, pVar, i, bVar));
                }
            });
        }
    }
}
