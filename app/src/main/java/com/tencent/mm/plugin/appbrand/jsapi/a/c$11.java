package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.12;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.amp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

class c$11 implements a {
    final /* synthetic */ c jgI;

    c$11(c cVar) {
        this.jgI = cVar;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
            x.i("MicroMsg.JsApiGetPhoneNumber", "JsOperateWxData success");
            final amp com_tencent_mm_protocal_c_amp = (amp) bVar.hmh.hmo;
            this.jgI.jgr.getContentView().post(new Runnable(this) {
                final /* synthetic */ c$11 jgP;

                public final void run() {
                    e eVar = this.jgP.jgI;
                    amp com_tencent_mm_protocal_c_amp = com_tencent_mm_protocal_c_amp;
                    x.i("MicroMsg.JsApiGetPhoneNumber", "handleOperateWxData");
                    Object obj = "";
                    if (com_tencent_mm_protocal_c_amp.ksB != null) {
                        obj = com_tencent_mm_protocal_c_amp.ksB.cdp();
                    }
                    x.i("MicroMsg.JsApiGetPhoneNumber", "resp data:%s", new Object[]{obj});
                    if (TextUtils.isEmpty(obj)) {
                        x.e("MicroMsg.JsApiGetPhoneNumber", "resp data is empty");
                        eVar.jgr.E(eVar.jcN, eVar.e("fail:resp data is empty", null));
                        return;
                    }
                    String str;
                    CharSequence charSequence;
                    Object obj2 = com_tencent_mm_protocal_c_amp.vFW;
                    CharSequence charSequence2 = com_tencent_mm_protocal_c_amp.niZ;
                    String str2 = "";
                    String str3 = "";
                    if (com_tencent_mm_protocal_c_amp.wtl != null) {
                        str2 = com_tencent_mm_protocal_c_amp.wtl.nfe;
                        eVar.jgw = com_tencent_mm_protocal_c_amp.wtl.jgw;
                        str = com_tencent_mm_protocal_c_amp.wtl.wsF;
                        charSequence = str2;
                    } else {
                        str = str3;
                        Object obj3 = str2;
                    }
                    x.i("MicroMsg.JsApiGetPhoneNumber", "appName:%s, desc:%s, IconUrl:%s, ext_desc:%s", new Object[]{charSequence2, charSequence, obj2, eVar.jgw});
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = new JSONObject(obj);
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiGetPhoneNumber", "new data json exception:%s", new Object[]{e.getMessage()});
                    }
                    if (jSONObject == null) {
                        x.e("MicroMsg.JsApiGetPhoneNumber", "jsonObj is null");
                        eVar.jgr.E(eVar.jcN, eVar.e("fail:jsonObj is null", null));
                        return;
                    }
                    boolean z;
                    eVar.jgu = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
                    JSONObject optJSONObject = jSONObject.optJSONObject(SlookAirButtonFrequentContactAdapter.DATA);
                    if (optJSONObject == null && !TextUtils.isEmpty(eVar.jgu)) {
                        try {
                            optJSONObject = new JSONObject(eVar.jgu);
                        } catch (JSONException e2) {
                            x.e("MicroMsg.JsApiGetPhoneNumber", "new dataJson exist exception, e:%s", new Object[]{e2.getMessage()});
                        }
                    }
                    if (optJSONObject != null) {
                        eVar.fAf = optJSONObject.optString("mobile");
                        boolean optBoolean = optJSONObject.optBoolean("need_auth", false);
                        eVar.jgx = optJSONObject.optBoolean("allow_send_sms", false);
                        z = optBoolean;
                    } else {
                        z = false;
                    }
                    eVar.signature = jSONObject.optString("signature");
                    eVar.jgv = jSONObject.optString("encryptedData");
                    eVar.atl = jSONObject.optString("iv");
                    x.i("MicroMsg.JsApiGetPhoneNumber", "mobile:%s, need_auth:%b, allow_send_sms:%b", new Object[]{eVar.fAf, Boolean.valueOf(z), Boolean.valueOf(eVar.jgx)});
                    if (eVar.jgE == 0) {
                        if (TextUtils.isEmpty(eVar.fAf)) {
                            eVar.jgE = 3;
                        } else if (z) {
                            eVar.jgE = 2;
                        } else {
                            eVar.jgE = 1;
                        }
                    }
                    if (TextUtils.isEmpty(eVar.fAf)) {
                        x.i("MicroMsg.JsApiGetPhoneNumber", "show the confirm bind phone dialog");
                        h.a(eVar.jgr.mContext, eVar.jgr.getContentView().getResources().getString(j.izi), eVar.jgr.getContentView().getResources().getString(j.izj), eVar.jgr.getContentView().getResources().getString(j.izp), eVar.jgr.getContentView().getResources().getString(j.dEn), false, new c$15(eVar), new c$16(eVar));
                        return;
                    }
                    x.i("MicroMsg.JsApiGetPhoneNumber", "show the confirm login dialog");
                    LayoutInflater layoutInflater = (LayoutInflater) eVar.jgr.mContext.getSystemService("layout_inflater");
                    View inflate = layoutInflater.inflate(q.h.iwT, null);
                    ImageView imageView = (ImageView) inflate.findViewById(g.itQ);
                    TextView textView = (TextView) inflate.findViewById(g.itN);
                    ImageView imageView2 = (ImageView) inflate.findViewById(g.itS);
                    TextView textView2 = (TextView) inflate.findViewById(g.itO);
                    TextView textView3 = (TextView) inflate.findViewById(g.itR);
                    View inflate2 = layoutInflater.inflate(q.h.iwS, null);
                    TextView textView4 = (TextView) inflate2.findViewById(g.itP);
                    if (bh.ov(str)) {
                        str = eVar.jgr.getContentView().getResources().getString(j.izc);
                    }
                    String string = eVar.jgr.getContentView().getResources().getString(j.izd);
                    WxaExposedParams.a aVar = new WxaExposedParams.a();
                    aVar.appId = eVar.jgr.mAppId;
                    aVar.fCp = eVar.jgr.jDS.jET;
                    aVar.fqe = 8;
                    a aVar2 = new a(l.a(aVar.ace()));
                    CharSequence spannableString = new SpannableString(str + string);
                    spannableString.setSpan(aVar2, str.length(), str.length() + string.length(), 18);
                    textView4.setMovementMethod(LinkMovementMethod.getInstance());
                    textView4.setText(spannableString);
                    if (TextUtils.isEmpty(charSequence2)) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(charSequence2);
                        textView.setVisibility(0);
                    }
                    textView2.setText(charSequence);
                    if (TextUtils.isEmpty(eVar.jgw)) {
                        textView3.setVisibility(8);
                    } else {
                        textView3.setText(eVar.jgw);
                        textView3.setVisibility(0);
                    }
                    if (TextUtils.isEmpty(obj2)) {
                        imageView.setImageDrawable(com.tencent.mm.modelappbrand.a.a.Ji());
                    } else {
                        com.tencent.mm.modelappbrand.a.b.Jj().a(imageView, obj2, com.tencent.mm.modelappbrand.a.a.Ji(), f.hkr);
                    }
                    imageView2.setOnClickListener(new 12(eVar, inflate2));
                    h.a(eVar.jgr.mContext, false, eVar.jgr.getContentView().getResources().getString(j.izh), inflate, eVar.jgr.getContentView().getResources().getString(j.izg), eVar.jgr.getContentView().getResources().getString(j.dEn), new c$13(eVar, z), new c$14(eVar));
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber JsOperateWxData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo});
        this.jgI.jgr.E(this.jgI.jcN, this.jgI.e("fail:JsOperateWxData cgi fail", null));
    }
}
