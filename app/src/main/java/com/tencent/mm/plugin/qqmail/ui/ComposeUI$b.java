package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import java.net.URLDecoder;

class ComposeUI$b extends p {
    private boolean prD;
    final /* synthetic */ ComposeUI prr;

    private ComposeUI$b(ComposeUI composeUI) {
        this.prr = composeUI;
        this.prD = false;
    }

    public final boolean b(WebView webView, String str) {
        x.d("MicroMsg.ComposeUI", "shouldOverrideUrlLoading, url = %s", new Object[]{str});
        String[] split;
        String str2;
        if (str.startsWith(ComposeUI.m(this.prr))) {
            this.prr.aWs();
            try {
                split = URLDecoder.decode(str.substring(ComposeUI.m(this.prr).length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(":");
                String str3 = split[0];
                str2 = split[1];
                x.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[]{r0[1], str3, str2});
                ar.Hg();
                cf dH = c.Fa().dH((long) Integer.valueOf(str3).intValue());
                Intent intent = new Intent(this.prr, MailImageDownloadUI.class);
                intent.putExtra("img_msg_id", dH.field_msgId);
                intent.putExtra("img_server_id", dH.field_msgSvrId);
                intent.putExtra("img_download_compress_type", 0);
                intent.putExtra("img_download_username", dH.field_talker);
                this.prr.startActivity(intent);
            } catch (Exception e) {
                x.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", new Object[]{e.getMessage()});
            }
        } else if (str.startsWith(ComposeUI.n(this.prr))) {
            try {
                ComposeUI.a(this.prr, URLDecoder.decode(str.substring(ComposeUI.n(this.prr).length()), ProtocolPackage.ServerEncoding));
            } catch (Exception e2) {
                x.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", new Object[]{e2.getMessage()});
            }
            if (ComposeUI.o(this.prr)) {
                if (ComposeUI.p(this.prr).indexOf("<img") == -1) {
                    ComposeUI.q(this.prr).clear();
                    ComposeUI.r(this.prr);
                } else {
                    s.a(ComposeUI.s(this.prr), ComposeUI.t(this.prr), ComposeUI.u(this.prr));
                }
            }
        } else if (str.startsWith(ComposeUI.t(this.prr))) {
            ComposeUI.q(this.prr).clear();
            try {
                String[] split2 = URLDecoder.decode(str.substring(ComposeUI.t(this.prr).length()), ProtocolPackage.ServerEncoding).split("&&");
                for (String str22 : split2) {
                    split = str22.split("@@");
                    Object obj = split[0].split(":")[1];
                    Object obj2 = split[1];
                    if (obj2.startsWith("file://")) {
                        obj2 = obj2.replaceFirst("file://", "");
                    }
                    x.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[]{obj, obj2});
                    ComposeUI.q(this.prr).put(obj, obj2);
                }
                if (ComposeUI.o(this.prr)) {
                    ComposeUI.r(this.prr);
                }
            } catch (Exception e22) {
                x.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", new Object[]{e22.getMessage()});
            }
        }
        return true;
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        super.b(webView, str, bitmap);
        if (!ComposeUI.v(this.prr)) {
            s.a(ComposeUI.s(this.prr));
            ComposeUI.w(this.prr);
        }
    }

    public final void a(WebView webView, String str) {
        x.d("MicroMsg.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[]{str, Boolean.valueOf(this.prD)});
        if (!this.prD) {
            this.prD = true;
            s.a(ComposeUI.s(this.prr), ComposeUI.n(this.prr), ComposeUI.x(this.prr));
        }
        super.a(webView, str);
    }
}
