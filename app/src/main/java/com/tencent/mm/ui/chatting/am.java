package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o$a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.chatting.b.p;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class am implements aa {
    public static k<aa, Bundle> yya = new 1();
    private p fhr;
    public u yxY;
    public final Set<String> yxZ = new HashSet();

    public am(p pVar) {
        this.yxY = pVar.csq();
        this.fhr = pVar;
    }

    public static void ah(Bundle bundle) {
        yya.ca(bundle);
        yya.doNotify();
    }

    public final void ag(Bundle bundle) {
        int i = 1;
        boolean z = false;
        if (this.fhr.csP()) {
            x.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
            return;
        }
        String string;
        int type;
        String queryParameter = Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        Resp resp = new Resp(bundle);
        WXMediaMessage wXMediaMessage = resp.message;
        if (this.yxZ.size() == 0) {
            Context context = this.yxY.getContext();
            Collection hashSet = new HashSet();
            string = context.getSharedPreferences(ac.cfv(), 0).getString("transactions_array_key", null);
            if (string != null && string.length() > 0) {
                for (Object add : string.split(";")) {
                    hashSet.add(add);
                }
            }
            this.yxZ.addAll(hashSet);
        }
        if (this.yxZ.contains(resp.transaction)) {
            this.yxZ.remove(resp.transaction);
            a(this.yxY.getContext(), this.yxZ);
            f fVar = new f();
            fVar.field_appId = queryParameter;
            x.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = " + queryParameter);
            if (an.bin().b(fVar, new String[0])) {
                type = wXMediaMessage.getType();
                com.tencent.mm.ui.p controller;
                boolean z2;
                i b;
                byte[] bArr;
                int i2;
                String str;
                switch (type) {
                    case 1:
                        controller = this.yxY.getController();
                        queryParameter = wXMediaMessage.description;
                        m(fVar);
                        if (e.a(controller, queryParameter, false, a(wXMediaMessage, fVar)) != null) {
                            z = true;
                        }
                        z2 = z;
                        break;
                    case 2:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                            com.tencent.mm.ui.p controller2;
                            if (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) {
                                controller2 = this.yxY.getController();
                                string = wXImageObject.imagePath;
                                m(fVar);
                                b = e.b(controller2, string, false, a(wXMediaMessage, fVar));
                            } else {
                                controller2 = this.yxY.getController();
                                byte[] bArr2 = wXImageObject.imageData;
                                m(fVar);
                                b = e.a(controller2, bArr2, false, a(wXMediaMessage, fVar));
                            }
                        } else {
                            controller = this.yxY.getController();
                            bArr = wXMediaMessage.thumbData;
                            m(fVar);
                            b = e.a(controller, bArr, false, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            x.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
                        } else {
                            z = true;
                        }
                        z2 = z;
                        break;
                    case 3:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            controller = this.yxY.getController();
                            i2 = R.k.dvn;
                            str = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, i2, str, false, a(wXMediaMessage, fVar));
                        } else {
                            controller = this.yxY.getController();
                            queryParameter = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, queryParameter, false, 2, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i = 0;
                            break;
                        }
                        break;
                    case 4:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            controller = this.yxY.getController();
                            i2 = R.k.dvA;
                            str = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, i2, str, false, a(wXMediaMessage, fVar));
                        } else {
                            controller = this.yxY.getController();
                            queryParameter = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, queryParameter, false, 1, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i = 0;
                            break;
                        }
                        break;
                    case 5:
                        controller = this.yxY.getController();
                        queryParameter = wXMediaMessage.title;
                        str = wXMediaMessage.description;
                        m(fVar);
                        if (e.a(controller, queryParameter, str, false, "", a(wXMediaMessage, fVar)) == null) {
                            i = 0;
                            break;
                        }
                        break;
                    case 7:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            controller = this.yxY.getController();
                            i2 = R.k.dvD;
                            str = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, i2, str, false, a(wXMediaMessage, fVar));
                        } else {
                            controller = this.yxY.getController();
                            queryParameter = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, queryParameter, false, 0, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i = 0;
                            break;
                        }
                        break;
                    case 8:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            controller = this.yxY.getController();
                            i2 = R.k.dvD;
                            str = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, i2, str, false, a(wXMediaMessage, fVar));
                        } else {
                            controller = this.yxY.getController();
                            bArr = wXMediaMessage.thumbData;
                            m(fVar);
                            b = e.a(controller, bArr, false, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i = 0;
                            break;
                        }
                        break;
                    default:
                        x.e("MicroMsg.WXAppMessageReceiver", "unknown type = " + type);
                        i = 0;
                        break;
                }
                if (i == 0) {
                    x.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
                    return;
                }
                return;
            }
            x.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = " + queryParameter);
            return;
        }
        x.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + resp.transaction);
    }

    public final boolean fM(String str, String str2) {
        x.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + str + ", openId = " + str2);
        Req req = new Req();
        req.username = this.fhr.crz();
        req.transaction = g.s((t.Wp()).getBytes());
        req.openId = str2;
        SharedPreferences sharedPreferences = this.yxY.getSharedPreferences(ac.cfs(), 0);
        this.yxY.getContext();
        req.lang = w.d(sharedPreferences);
        ar.Hg();
        req.country = (String) c.CU().get(274436, null);
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        com.tencent.mm.pluginsdk.model.app.p.ae(bundle);
        com.tencent.mm.pluginsdk.model.app.p.af(bundle);
        Args args = new Args();
        args.targetPkgName = str;
        args.bundle = bundle;
        boolean send = MMessageActV2.send(this.yxY.getContext(), args);
        this.yxZ.add(req.transaction);
        a(this.yxY.getContext(), this.yxZ);
        return send;
    }

    private String m(f fVar) {
        return this.yxY.getString(R.l.dUf, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(this.yxY.getContext(), fVar, null)});
    }

    private o$a a(WXMediaMessage wXMediaMessage, f fVar) {
        return new 2(this, wXMediaMessage, fVar);
    }

    @TargetApi(9)
    public static void a(Context context, Set<String> set) {
        String str = null;
        if (set != null && set.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str2 : set) {
                stringBuilder.append(str2);
                stringBuilder.append(";");
            }
            str2 = stringBuilder.toString();
        }
        Editor edit = context.getSharedPreferences(ac.cfv(), 0).edit();
        edit.putString("transactions_array_key", str2);
        if (VERSION.SDK_INT > 8) {
            edit.apply();
        } else {
            edit.commit();
        }
    }
}
