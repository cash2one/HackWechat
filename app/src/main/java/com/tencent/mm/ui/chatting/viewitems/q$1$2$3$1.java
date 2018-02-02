package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.m.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.viewitems.q.1.2.3;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class q$1$2$3$1 implements a {
    final /* synthetic */ String xFA;
    final /* synthetic */ 3 yLM;

    q$1$2$3$1(3 3, String str) {
        this.yLM = 3;
        this.xFA = str;
    }

    public final void b(WxaAttributes wxaAttributes) {
        if (wxaAttributes == null) {
            u.makeText(this.yLM.yLL.jLA.getContext(), R.l.ezy, 0).show();
            return;
        }
        if (TextUtils.isEmpty(wxaAttributes.field_appId) || TextUtils.isEmpty(this.xFA)) {
            x.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", new Object[]{r0, this.xFA});
            u.makeText(this.yLM.yLL.jLA.getContext(), R.l.ezy, 0).show();
            return;
        }
        try {
            x.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[]{this.xFA, r0, String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{URLEncoder.encode(r0, ProtocolPackage.ServerEncoding), URLEncoder.encode(this.xFA, ProtocolPackage.ServerEncoding), Integer.valueOf(1), Integer.valueOf(this.yLM.yLL.yLK), Integer.valueOf(this.yLM.yLL.iSi)})});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", r1);
            d.b(this.yLM.yLL.yLJ.yLH.yqa.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
            u.makeText(this.yLM.yLL.jLA.getContext(), R.l.ezy, 0).show();
        }
    }
}
