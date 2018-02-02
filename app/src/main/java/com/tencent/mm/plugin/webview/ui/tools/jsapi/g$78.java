package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class g$78 implements Runnable {
    final /* synthetic */ String hpU;
    final /* synthetic */ g tIj;
    final /* synthetic */ String tJc;
    final /* synthetic */ String tJd;
    final /* synthetic */ String tJe;

    g$78(g gVar, String str, String str2, String str3, String str4) {
        this.tIj = gVar;
        this.tJc = str;
        this.tJd = str2;
        this.hpU = str3;
        this.tJe = str4;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_jsapi_param_type", this.tJc);
        intent.putExtra("free_wifi_ap_key", this.tJd);
        intent.putExtra("free_wifi_jsapi_param_username", this.hpU);
        intent.putExtra("free_wifi_sessionkey", this.tJe);
        intent.putExtra("free_wifi_source", 4);
        intent.addFlags(67108864);
        if (!(bh.ov(this.tJc) || !this.tJc.equalsIgnoreCase("2") || bh.ov(this.tJd))) {
            Uri parse = Uri.parse(this.tJd);
            String host = parse.getHost();
            String query = parse.getQuery();
            if (!bh.ov(host) && "connectToFreeWifi".equals(host) && !bh.ov(query) && query.startsWith("apKey=")) {
                host = parse.getQueryParameter("apKey");
                x.i("[MicroMsg.FreeWifi.MsgHandler]", "apKey value = %s", host);
                query = parse.getQueryParameter("ticket");
                if (!bh.ov(host) && host.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    intent.putExtra("free_wifi_schema_uri", parse.toString());
                    intent.putExtra("free_wifi_ap_key", host);
                    intent.putExtra("free_wifi_source", 5);
                    intent.putExtra("free_wifi_threeone_startup_type", 4);
                    if (!bh.ov(query)) {
                        intent.putExtra("free_wifi_schema_ticket", query);
                    }
                }
            }
        }
        d.b(g.i(this.tIj), "freewifi", ".ui.FreeWifiEntryUI", intent);
    }
}
