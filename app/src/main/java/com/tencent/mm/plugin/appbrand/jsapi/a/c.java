package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ae.b;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.protocal.c.amo;
import com.tencent.mm.protocal.c.amp;
import com.tencent.mm.protocal.c.bgh;
import com.tencent.mm.protocal.c.bgi;
import com.tencent.mm.protocal.c.nt;
import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class c extends a {
    public static final int CTRL_INDEX = 209;
    public static final String NAME = "getPhoneNumber";
    String atl;
    String fAf = "";
    int jcN;
    TextView jgA;
    a jgB;
    com.tencent.mm.plugin.af.a jgC = null;
    private i jgD;
    int jgE = 0;
    int jgF = 0;
    int jgG = 0;
    com.tencent.mm.plugin.af.a.a jgH = new 10(this);
    p jgr;
    private String jgs;
    private boolean jgt;
    String jgu;
    String jgv;
    String jgw = "";
    boolean jgx = false;
    View jgy;
    EditVerifyCodeView jgz;
    String signature;

    static /* synthetic */ void a(c cVar) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "showVerifyMobileDialog");
        LayoutInflater layoutInflater = (LayoutInflater) cVar.jgr.mContext.getSystemService("layout_inflater");
        if (cVar.jgy == null) {
            cVar.jgy = layoutInflater.inflate(h.ixu, null);
            cVar.jgz = (EditVerifyCodeView) cVar.jgy.findViewById(g.iuU);
            cVar.jgA = (TextView) cVar.jgy.findViewById(g.iuR);
        }
        if (cVar.jgy.getParent() != null) {
            ((ViewGroup) cVar.jgy.getParent()).removeAllViews();
        }
        TextView textView = (TextView) cVar.jgy.findViewById(g.iuV);
        if (cVar.jgw == null) {
            cVar.jgw = "";
        }
        textView.setText(cVar.jgr.getContentView().getResources().getString(j.izu, new Object[]{cVar.jgw}));
        cVar.jgz.setText("");
        cVar.afJ();
        OnClickListener anonymousClass18 = new OnClickListener(cVar) {
            final /* synthetic */ c jgI;

            {
                this.jgI = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.JsApiGetPhoneNumber", "to verify sms");
                if (!TextUtils.isEmpty(this.jgI.jgz.mBuilder.toString()) && this.jgI.jgz.mBuilder.toString().length() == 6) {
                    x.e("MicroMsg.JsApiGetPhoneNumber", "code is length is 6");
                    dialogInterface.dismiss();
                    this.jgI.afK();
                    this.jgI.jgy.post(new 1(this));
                    c cVar = this.jgI;
                    String str = this.jgI.jgz.mBuilder.toString().toString();
                    x.i("MicroMsg.JsApiGetPhoneNumber", "doVerifyCode");
                    b.a aVar = new b.a();
                    aVar.hmj = new nt();
                    aVar.hmk = new nu();
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkverifycode";
                    aVar.hmi = HardCoderJNI.FUNC_REG_ANR_CALLBACK;
                    aVar.hml = 0;
                    aVar.hmm = 0;
                    b JZ = aVar.JZ();
                    nt ntVar = (nt) JZ.hmg.hmo;
                    ntVar.fFm = cVar.jgr.mAppId;
                    ntVar.fAf = cVar.fAf;
                    ntVar.sPk = str;
                    com.tencent.mm.ipcinvoker.wx_extension.b.a(JZ, new 5(cVar, com.tencent.mm.ui.base.h.a(cVar.jgr.mContext, "", false, null)));
                } else if (TextUtils.isEmpty(this.jgI.jgz.mBuilder.toString()) || this.jgI.jgz.mBuilder.toString().length() >= 6) {
                    x.e("MicroMsg.JsApiGetPhoneNumber", "code is empty");
                    com.tencent.mm.ui.base.h.bu(this.jgI.jgr.mContext, this.jgI.jgr.getContentView().getResources().getString(j.izr));
                } else {
                    com.tencent.mm.ui.base.h.bu(this.jgI.jgr.mContext, this.jgI.jgr.getContentView().getResources().getString(j.izs));
                    x.e("MicroMsg.JsApiGetPhoneNumber", "code is length is < 6");
                }
            }
        };
        cVar.jgD = com.tencent.mm.ui.base.h.a(cVar.jgr.mContext, false, cVar.jgr.getContentView().getResources().getString(j.izv), cVar.jgy, cVar.jgr.getContentView().getResources().getString(j.dFU), cVar.jgr.getContentView().getResources().getString(j.dEn), anonymousClass18, new OnClickListener(cVar) {
            final /* synthetic */ c jgI;

            {
                this.jgI = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.JsApiGetPhoneNumber", "cancel to verify sms");
                dialogInterface.dismiss();
                this.jgI.jgr.E(this.jgI.jcN, this.jgI.e("fail:cancel to verify sms", null));
                this.jgI.afK();
                this.jgI.jgy.post(new 1(this));
                com.tencent.mm.plugin.report.service.g.pQN.h(14249, new Object[]{this.jgI.jgr.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(this.jgI.jgF), Integer.valueOf(this.jgI.jgG), Integer.valueOf(this.jgI.jgE)});
            }
        });
        cVar.jgD.a(cVar.jgr.getContentView().getResources().getString(j.dFU), false, anonymousClass18);
        cVar.jgy.post(new 3(cVar));
    }

    static /* synthetic */ void b(c cVar) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "doSendVerifyCode");
        b.a aVar = new b.a();
        aVar.hmj = new bgh();
        aVar.hmk = new bgi();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/sendverifycode";
        aVar.hmi = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        bgh com_tencent_mm_protocal_c_bgh = (bgh) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_bgh.fFm = cVar.jgr.mAppId;
        com_tencent_mm_protocal_c_bgh.fAf = cVar.fAf;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(JZ, new 17(cVar, com.tencent.mm.ui.base.h.a(cVar.jgr.mContext, "", false, null)));
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber data is null");
            pVar.E(i, e("fail:data is null", null));
            return;
        }
        this.jgr = pVar;
        this.jcN = i;
        x.i("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber data:%s", new Object[]{jSONObject.toString()});
        Object optString = jSONObject.optString("api_name", "webapi_getuserwxphone");
        boolean optBoolean = jSONObject.optBoolean("with_credentials", true);
        if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber api_name is null");
            pVar.E(i, e("fail:api_name is null", null));
            return;
        }
        com.tencent.mm.plugin.appbrand.c.a(pVar.mAppId, new 1(this, pVar));
        this.jgs = optString;
        this.jgt = optBoolean;
        afH();
    }

    final void afH() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "requestBindPhoneNumber");
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object();
            jSONStringer.key("api_name");
            jSONStringer.value(this.jgs);
            jSONStringer.key("with_credentials");
            jSONStringer.value(this.jgt);
            jSONStringer.endObject();
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiGetPhoneNumber", "JSONException:%s", new Object[]{e.getMessage()});
        }
        x.i("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber appId:%s, api_name:%s, with_credentials:%b", new Object[]{this.jgr.mAppId, this.jgs, Boolean.valueOf(this.jgt)});
        b.a aVar = new b.a();
        aVar.hmj = new amo();
        aVar.hmk = new amp();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-getuserwxphone";
        aVar.hmi = 1141;
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        amo com_tencent_mm_protocal_c_amo = (amo) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_amo.ngo = this.jgr.mAppId;
        com_tencent_mm_protocal_c_amo.ksB = new com.tencent.mm.bq.b(jSONStringer.toString().getBytes());
        com.tencent.mm.ipcinvoker.wx_extension.b.a(JZ, new 11(this));
    }

    final void afI() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "doSuccCallback");
        Map hashMap = new HashMap(5);
        hashMap.put("encryptedData", this.jgv);
        hashMap.put("iv", this.atl);
        this.jgr.E(this.jcN, e("ok", hashMap));
    }

    final void afJ() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "updateSendText()");
        Object string = this.jgr.getContentView().getResources().getString(j.izk);
        Object string2 = this.jgr.getContentView().getResources().getString(j.izm);
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(string);
        spannableStringBuilder.append(string2);
        int length = string.length();
        int length2 = string2.length();
        spannableStringBuilder.setSpan(new ClickableSpan(this) {
            final /* synthetic */ c jgI;

            {
                this.jgI = r1;
            }

            public final void onClick(View view) {
                x.i("MicroMsg.JsApiGetPhoneNumber", "click the resend spanBuilder, do resend sms");
                if (this.jgI.jgx) {
                    c.b(this.jgI);
                    return;
                }
                x.e("MicroMsg.JsApiGetPhoneNumber", "allow_send_sms is false, show send_verify_code_frequent error");
                this.jgI.sh(this.jgI.jgr.getContentView().getResources().getString(j.izo));
            }
        }, length, length + length2, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jgr.mContext.getResources().getColor(d.btd)), length, length2 + length, 17);
        this.jgA.setText(spannableStringBuilder);
        this.jgA.setMovementMethod(LinkMovementMethod.getInstance());
    }

    final void sh(String str) {
        afK();
        com.tencent.mm.ui.base.h.a(this.jgr.mContext, str, "", false, new 7(this));
    }

    final void afK() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "stopSmsListener");
        if (this.jgB != null) {
            this.jgB.cancel();
        }
        if (this.jgC != null) {
            this.jgC.stop();
            this.jgC.qxZ = null;
        }
    }
}
