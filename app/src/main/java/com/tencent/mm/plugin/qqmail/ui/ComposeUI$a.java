package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.webkit.ConsoleMessage;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.j;
import java.net.URLDecoder;

class ComposeUI$a extends j {
    final /* synthetic */ ComposeUI prr;

    private ComposeUI$a(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    @Deprecated
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        x.i("MicroMsg.ComposeUI", "console, consoleMessage: %s", new Object[]{consoleMessage});
        String SU = s.SU(consoleMessage != null ? consoleMessage.message() : null);
        String[] split;
        if (SU.startsWith(ComposeUI.m(this.prr))) {
            this.prr.aWs();
            try {
                String[] split2 = URLDecoder.decode(SU.substring(ComposeUI.m(this.prr).length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(":");
                String str = split2[0];
                String str2 = split2[1];
                x.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[]{split[1], str, str2});
                ar.Hg();
                cf dH = c.Fa().dH((long) Integer.valueOf(str).intValue());
                Intent intent = new Intent(this.prr, MailImageDownloadUI.class);
                intent.putExtra("img_msg_id", dH.field_msgId);
                intent.putExtra("img_server_id", dH.field_msgSvrId);
                intent.putExtra("img_download_compress_type", 0);
                intent.putExtra("img_download_username", dH.field_talker);
                this.prr.startActivity(intent);
                return true;
            } catch (Exception e) {
                x.w("MicroMsg.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", new Object[]{e.getMessage()});
            }
        } else if (SU.startsWith(ComposeUI.n(this.prr))) {
            try {
                ComposeUI.a(this.prr, URLDecoder.decode(SU.substring(ComposeUI.n(this.prr).length()), ProtocolPackage.ServerEncoding));
            } catch (Exception e2) {
                x.w("MicroMsg.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", new Object[]{e2.getMessage()});
            }
            if (ComposeUI.o(this.prr)) {
                if (ComposeUI.p(this.prr).indexOf("<img") == -1) {
                    ComposeUI.q(this.prr).clear();
                    ComposeUI.r(this.prr);
                    return true;
                }
                s.a(ComposeUI.s(this.prr), ComposeUI.t(this.prr), ComposeUI.u(this.prr));
            }
            return true;
        } else {
            if (SU.startsWith(ComposeUI.t(this.prr))) {
                ComposeUI.q(this.prr).clear();
                try {
                    String[] split3 = URLDecoder.decode(SU.substring(ComposeUI.t(this.prr).length()), ProtocolPackage.ServerEncoding).split("&&");
                    for (String SU2 : split3) {
                        split = SU2.split("@@");
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
                    return true;
                } catch (Exception e22) {
                    x.w("MicroMsg.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", new Object[]{e22.getMessage()});
                    return true;
                }
            }
            return super.onConsoleMessage(consoleMessage);
        }
    }
}
