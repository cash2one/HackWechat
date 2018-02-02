package com.tencent.mm.plugin.game.gamewebview.model;

import android.text.TextUtils;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class h {
    public static void c(d dVar) {
        dVar.BR(GameJsApiSendAppMessage.NAME);
        if (dVar.bq(GameJsApiSendAppMessage.NAME, 89)) {
            dVar.cH("menu:share:appmessage", "");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String RI = dVar.RI();
            jSONObject.put("link", RI);
            jSONObject.put("desc", RI);
            jSONObject.put("title", dVar.getTitle());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameWebViewShareController", e, "", new Object[0]);
        }
        dVar.cI(GameJsApiSendAppMessage.NAME, jSONObject.toString());
    }

    public static void a(d dVar, JSONObject jSONObject) {
        int i;
        String substring;
        String optString = jSONObject.optString("link");
        c.d dVar2 = (c.d) dVar.mZy.get(dVar.aPk());
        if (TextUtils.isEmpty(optString) || dVar2 == null || dVar2.tGI == null || dVar2.tGI.size() <= 0) {
            i = 0;
        } else {
            int i2;
            List<String> linkedList = new LinkedList();
            int indexOf = optString.indexOf("://");
            String substring2 = optString.substring((indexOf == -1 ? 1 : 3) + indexOf);
            for (String substring3 : dVar2.tGI) {
                if (!TextUtils.isEmpty(substring3)) {
                    int indexOf2 = substring3.indexOf("://");
                    if (indexOf2 == -1) {
                        i2 = 1;
                    } else {
                        i2 = 3;
                    }
                    substring3 = substring3.substring(i2 + indexOf2);
                    if (substring2.startsWith(substring3)) {
                        i2 = 0;
                        break;
                    } else if (!substring3.contains("/")) {
                        linkedList.add(substring3);
                    }
                }
            }
            i2 = 1;
            if (!(i2 == 0 || linkedList.isEmpty())) {
                String host = URI.create(optString).getHost();
                for (String substring32 : linkedList) {
                    if (host.endsWith(substring32)) {
                        i = 0;
                        break;
                    }
                }
            }
            i = i2;
        }
        if (i != 0) {
            try {
                substring32 = dVar.RI();
                jSONObject.put("img_url", "");
                jSONObject.put("link", substring32);
                jSONObject.put("desc", substring32);
                jSONObject.put("title", dVar.getTitle());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GameWebViewShareController", e, "", new Object[0]);
            }
        }
    }
}
