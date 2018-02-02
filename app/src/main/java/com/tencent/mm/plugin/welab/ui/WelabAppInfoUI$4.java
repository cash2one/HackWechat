package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class WelabAppInfoUI$4 implements OnClickListener {
    final /* synthetic */ WelabAppInfoUI tPR;

    WelabAppInfoUI$4(WelabAppInfoUI welabAppInfoUI) {
        this.tPR = welabAppInfoUI;
    }

    public final void onClick(View view) {
        try {
            String str = "";
            g.Dh();
            int Cg = a.Cg();
            String encode = URLEncoder.encode(d.vAx, ProtocolPackage.ServerEncoding);
            String encode2 = URLEncoder.encode(bh.cgr(), ProtocolPackage.ServerEncoding);
            String encode3 = URLEncoder.encode(q.yE(), ProtocolPackage.ServerEncoding);
            String encode4 = URLEncoder.encode(d.vAs, ProtocolPackage.ServerEncoding);
            String encode5 = URLEncoder.encode(d.vAt, ProtocolPackage.ServerEncoding);
            String encode6 = URLEncoder.encode(d.vAu, ProtocolPackage.ServerEncoding);
            g.Dh();
            String str2 = ("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&from=" + URLEncoder.encode(WelabAppInfoUI.a(this.tPR).field_expId + "|" + WelabAppInfoUI.b(this.tPR)) + "&version=" + d.vAz + "&lang=" + w.eL(ac.getContext()) + "&" + bh.ou(str) + ("&uin=" + Cg + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + URLEncoder.encode(a.CB(), ProtocolPackage.ServerEncoding) + "&signature=" + URLEncoder.encode(bh.fa(ac.getContext()), ProtocolPackage.ServerEncoding) + "&scene=" + (bh.ov(str) ? 0 : 1))) + "#/comment/4134";
            Intent intent = new Intent();
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", str2);
            intent.putExtra("title", "意见反馈");
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
            com.tencent.mm.bm.d.b(this.tPR, "webview", ".ui.tools.WebViewUI", intent);
        } catch (UnsupportedEncodingException e) {
            x.e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", new Object[]{e.getMessage()});
        }
    }
}
