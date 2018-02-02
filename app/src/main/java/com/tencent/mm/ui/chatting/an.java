package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.bz.a;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX$Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class an implements aa {
    private static k<aa, Bundle> yya = new 1();
    private Context context;
    private final Map<String, ShowMessageFromWX$Req> yyd = new HashMap();

    public an(Context context) {
        this.context = context;
    }

    public static void ah(Bundle bundle) {
        yya.ca(bundle);
        yya.doNotify();
    }

    public final void ag(Bundle bundle) {
        x.d("MicroMsg.WXAppMessageShower", "handleResp, appid = " + Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid"));
        Resp resp = new Resp(bundle);
        x.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + resp.errCode + ", type = " + resp.getType());
        if (((ShowMessageFromWX$Req) this.yyd.get(resp.transaction)) == null) {
            x.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + resp.transaction);
        } else {
            this.yyd.remove(resp.transaction);
        }
    }

    public final void a(String str, WXMediaMessage wXMediaMessage, String str2, String str3) {
        x.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", new Object[]{str, str3});
        a.post(new 2(this, wXMediaMessage, str3, str, str2));
    }
}
