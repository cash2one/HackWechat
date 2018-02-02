package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;
import com.tencent.mm.z.u.b;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

class URISpanHandlerSet {
    Context mContext = null;

    @a
    class AAUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fhe;

        AAUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fhe = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final k cH(String str) {
            if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/opendetail")) {
                return new k(str, 35, null);
            }
            if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeurgenotify")) {
                return new k(str, 36, null);
            }
            return str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeaa") ? new k(str, 37, null) : null;
        }

        final int[] uC() {
            return new int[]{35, 36, 37};
        }

        final boolean a(k kVar, f fVar) {
            if (kVar.type == 35) {
                try {
                    String queryParameter = Uri.parse(kVar.url).getQueryParameter("billno");
                    if (bh.ov(queryParameter)) {
                        x.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                        return true;
                    }
                    String string;
                    if (kVar.data instanceof Bundle) {
                        string = ((Bundle) kVar.data).getString("chatroom_name");
                    } else if (kVar.data instanceof String) {
                        string = kVar.data.toString();
                    } else {
                        x.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", new Object[]{kVar});
                        return true;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("bill_no", queryParameter);
                    intent.putExtra("enter_scene", 3);
                    intent.putExtra("chatroom", string);
                    d.b(this.fhe.mContext, "aa", ".ui.PaylistAAUI", intent);
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", new Object[]{e.getMessage(), kVar.url});
                }
            } else {
                String queryParameter2;
                Bundle bundle;
                String string2;
                long j;
                if (kVar.type == 37) {
                    try {
                        queryParameter2 = Uri.parse(kVar.url).getQueryParameter("billno");
                        if (bh.ov(queryParameter2)) {
                            x.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            return true;
                        } else if (kVar.data instanceof Bundle) {
                            bundle = (Bundle) kVar.data;
                            string2 = bundle.getString("chatroom_name");
                            if (bh.ov(string2)) {
                                x.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                                return true;
                            }
                            j = bundle.getLong("msg_id", -1);
                            if (j < 0) {
                                x.e("MicroMsg.URISpanHandlerSet", "msgId is null");
                                return true;
                            }
                            h.a(this.fhe.mContext, R.l.eQc, -1, R.l.eQf, R.l.cancel, new 1(this, queryParameter2, string2, j), null);
                        } else {
                            x.e("MicroMsg.URISpanHandlerSet", "error data!");
                            return true;
                        }
                    } catch (Exception e2) {
                        x.e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", new Object[]{e2.getMessage(), kVar.url});
                    }
                } else if (kVar.type == 36) {
                    try {
                        queryParameter2 = Uri.parse(kVar.url).getQueryParameter("billno");
                        if (bh.ov(queryParameter2)) {
                            x.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            return true;
                        }
                        bundle = null;
                        if (kVar.data instanceof Bundle) {
                            bundle = (Bundle) kVar.data;
                        }
                        if (bundle == null || bh.ov(bundle.getString("chatroom_name"))) {
                            x.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                            return true;
                        }
                        string2 = bundle.getString("chatroom_name");
                        j = bundle.getLong("msg_id", -1);
                        h.a(this.fhe.mContext, R.l.eQd, -1, R.l.eQe, R.l.cancel, new 2(this, queryParameter2, string2, j), null);
                    } catch (Exception e22) {
                        x.e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", new Object[]{e22.getMessage(), kVar.url});
                    }
                }
                return false;
            }
        }

        final boolean a(String str, boolean z, t tVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class BizMsgMenuUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fhe;

        BizMsgMenuUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fhe = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final k cH(String str) {
            if (str.trim().startsWith("weixin://bizmsgmenu")) {
                return new k(str, 43, null);
            }
            return null;
        }

        final int[] uC() {
            return new int[]{43};
        }

        final boolean a(k kVar, f fVar) {
            if (43 != kVar.type) {
                return false;
            }
            if (bh.ov(kVar.username)) {
                x.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
                return true;
            }
            x.d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", new Object[]{kVar.url});
            Uri parse = Uri.parse(kVar.url.trim());
            String queryParameter = parse.getQueryParameter("msgmenuid");
            String queryParameter2 = parse.getQueryParameter("msgmenucontent");
            g.pQN.h(14522, new Object[]{bh.ou(queryParameter), kVar.username});
            if (bh.ov(queryParameter) || bh.ov(queryParameter2)) {
                x.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
                return true;
            }
            try {
                String decode = URLDecoder.decode(queryParameter2, "UTF-8");
                HashMap hashMap = new HashMap();
                hashMap.put("bizmsgmenuid", queryParameter);
                ar.CG().a(new j(kVar.username, decode, s.hp(kVar.username), JsApiCreateAudioInstance.CTRL_INDEX, hashMap), 0);
            } catch (UnsupportedEncodingException e) {
                x.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler exp, msg = %s", new Object[]{e.getMessage()});
            }
            return true;
        }

        final boolean a(String str, boolean z, t tVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class ContactUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fhe;

        ContactUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fhe = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final k cH(String str) {
            if (str.trim().equals("weixin://contacts/all/")) {
                return new k(str, 23, new aq("@all.android", null, this.fhe.mContext.getString(R.l.enE), null, true, true));
            } else if (str.trim().equals("weixin://contacts/microblog/")) {
                return new k(str, 22, com.tencent.mm.z.x.hC(this.fhe.mContext.getString(R.l.enH)));
            } else {
                if (str.trim().equals("weixin://contacts/micromessenger/")) {
                    return new k(str, 2, new aq("@micromsg.qq.com", null, this.fhe.mContext.getString(R.l.enI), null, true, true));
                } else if (!str.trim().startsWith("weixin://contacts/")) {
                    return null;
                } else {
                    String substring = str.trim().substring(0, str.trim().length() - 1);
                    int lastIndexOf = substring.lastIndexOf("/");
                    if (lastIndexOf == -1) {
                        return null;
                    }
                    return new k(str, 21, com.tencent.mm.z.x.P("@" + substring.substring(lastIndexOf + 1), this.fhe.mContext.getString(R.l.enG)));
                }
            }
        }

        final int[] uC() {
            return new int[]{23, 21, 22, 2};
        }

        final boolean a(k kVar, f fVar) {
            boolean z = false;
            int i = kVar.type;
            if (i != 23 && i != 21 && i != 22 && i != 2) {
                return false;
            }
            aq aqVar = (aq) kVar.A(aq.class);
            if (fVar != null) {
                fVar.a(kVar);
            }
            if (aqVar == null) {
                h.b(this.fhe.mContext, this.fhe.mContext.getString(R.l.esU), this.fhe.mContext.getString(R.l.dGO), true);
                return false;
            }
            if (aqVar.getType().equals("@t.qq.com")) {
                ar.Hg();
                if (!(c.Fg().EY("@t.qq.com") != null)) {
                    h.b(this.fhe.mContext, this.fhe.mContext.getString(R.l.esU), this.fhe.mContext.getString(R.l.dGO), true);
                }
            }
            if (aqVar.getType().equals("@domain.android")) {
                ar.Hg();
                List aZx = c.Fg().aZx();
                if (aZx.size() > 0) {
                    for (int i2 = 0; i2 < aZx.size(); i2++) {
                        if (((bc) aZx.get(i2)).isEnable()) {
                            z = true;
                            break;
                        }
                    }
                }
                if (!z) {
                    h.b(this.fhe.mContext, this.fhe.mContext.getString(R.l.esU), this.fhe.mContext.getString(R.l.dGO), true);
                }
            }
            Intent intent = new Intent();
            intent.setClass(this.fhe.mContext, SelectContactUI.class);
            intent.putExtra("Contact_GroupFilter_Type", aqVar.getType()).putExtra("Contact_GroupFilter_Str", aqVar.ciU()).putExtra("Contact_GroupFilter_DisplayName", aqVar.AP());
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.fhe.mContext.startActivity(intent);
            if (fVar != null) {
                fVar.b(kVar);
            }
            return true;
        }

        final boolean a(String str, boolean z, t tVar, Bundle bundle) {
            if (!str.equals("weixin://contacts/microblog/") && !str.equals("weixin://contacts/micromessenger/") && !str.equals("weixin://contacts/all/")) {
                return false;
            }
            aq hC = com.tencent.mm.z.x.hC(this.fhe.mContext.getString(R.l.enI));
            if (str.equals("weixin://contacts/microblog/")) {
                hC = com.tencent.mm.z.x.hC(this.fhe.mContext.getString(R.l.enH));
            }
            if (str.equals("weixin://contacts/micromessenger/")) {
                hC = com.tencent.mm.z.x.hC(this.fhe.mContext.getString(R.l.enI));
            }
            if (str.equals("weixin://contacts/all/")) {
                hC = com.tencent.mm.z.x.hC(this.fhe.mContext.getString(R.l.enE));
            }
            Intent intent = new Intent();
            intent.setClass(this.fhe.mContext, SelectContactUI.class);
            intent.putExtra("Contact_GroupFilter_Type", hC.getType()).putExtra("Contact_GroupFilter_Str", hC.ciU()).putExtra("Contact_GroupFilter_DisplayName", hC.AP());
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            return true;
        }
    }

    @a
    class FeedbackUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fhe;

        FeedbackUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fhe = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final k cH(String str) {
            if (str.trim().startsWith("weixin://feedback/next/")) {
                return new k(str, 34, null);
            }
            return null;
        }

        final int[] uC() {
            return new int[]{34};
        }

        final boolean a(k kVar, f fVar) {
            if (kVar.type != 34) {
                return false;
            }
            x.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", new Object[]{kVar.url, kVar.url.trim().replace("weixin://feedback/next/", "")});
            ar.CG().a(new n(q.yT(), r2, 8), 0);
            return true;
        }

        final boolean a(String str, boolean z, t tVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class HttpUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fhe;

        HttpUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fhe = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final k cH(String str) {
            if (str.trim().toLowerCase().startsWith("http")) {
                return new k(str, 1, null);
            }
            return null;
        }

        final int[] uC() {
            return new int[]{1};
        }

        final boolean a(k kVar, f fVar) {
            if (kVar.type != 1) {
                return false;
            }
            String str;
            kVar.A(aq.class);
            aq P = com.tencent.mm.z.x.P("@" + kVar.url, this.fhe.mContext.getString(R.l.enG));
            if (fVar != null) {
                str = (String) fVar.a(kVar);
            } else {
                str = null;
            }
            if (P == null || !P.fqP) {
                String str2 = kVar.url;
                if (!str2.toLowerCase().startsWith("http")) {
                    str2 = "http://" + str2;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                if (kVar.data != null && (kVar.data instanceof Integer)) {
                    intent.putExtra("geta8key_scene", ((Integer) kVar.data).intValue());
                }
                str2 = kVar.iKB;
                if (!bh.ov(str2)) {
                    b hy = u.GK().hy(str2);
                    if (hy != null) {
                        String string = hy.getString("prePublishId", null);
                        String string2 = hy.getString("preUsername", null);
                        String string3 = hy.getString("preChatName", null);
                        intent.putExtra("reportSessionId", str2);
                        intent.putExtra("KPublisherId", string);
                        intent.putExtra("geta8key_username", string3);
                        intent.putExtra("pre_username", string2);
                        intent.putExtra("prePublishId", string);
                        intent.putExtra("preUsername", string2);
                        intent.putExtra("preChatName", string3);
                        intent.putExtra("preChatTYPE", com.tencent.mm.z.t.N(string2, string3));
                    }
                }
                intent.putExtra("geta8key_username", bh.ov(str) ? null : str);
                d.b(this.fhe.mContext, "webview", ".ui.tools.WebViewUI", intent);
            }
            if (fVar != null) {
                fVar.b(kVar);
            }
            return true;
        }

        final boolean a(String str, boolean z, t tVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class SettingPluginQQMsgUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fhe;

        SettingPluginQQMsgUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fhe = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final k cH(String str) {
            if (str.trim().startsWith("weixin://setting/plugin/qqmsg")) {
                return new k(str, 13, null);
            }
            return null;
        }

        final int[] uC() {
            return new int[]{13};
        }

        final boolean a(k kVar, f fVar) {
            return false;
        }

        final boolean a(String str, boolean z, t tVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class VerifyContactUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fhe;

        VerifyContactUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fhe = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final k cH(String str) {
            if (str.trim().startsWith("weixin://findfriend/verifycontact")) {
                return new k(str, 4, null);
            }
            return null;
        }

        final int[] uC() {
            return new int[]{4};
        }

        final boolean a(k kVar, f fVar) {
            if (kVar.type != 4) {
                return false;
            }
            if (fVar != null) {
                fVar.a(kVar);
                fVar.b(kVar);
            }
            return true;
        }

        final boolean a(String str, boolean z, t tVar, Bundle bundle) {
            return false;
        }
    }

    public URISpanHandlerSet(Context context) {
        this.mContext = context == null ? ac.getContext() : this.mContext;
    }
}
