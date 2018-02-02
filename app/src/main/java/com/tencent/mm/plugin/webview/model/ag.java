package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.webview.modelcache.p;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.m;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ag {
    public List<Integer> tsA = new ArrayList();
    public final Map<String, Boolean> tsB = new HashMap();
    public final Set<String> tsC = new HashSet();
    public String tsD = null;
    private int tsx = -1;
    public ArrayList<String> tsy = new ArrayList();
    public ArrayList<String> tsz = new ArrayList();

    public final m a(String str, boolean z, d dVar) {
        if (bh.ov(str)) {
            x.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
            return null;
        } else if (str.startsWith("weixin://bridge.js")) {
            return b(dVar);
        } else {
            if (str.startsWith("weixin://resourceid/")) {
                x.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
                try {
                    return new m("image/*", ProtocolPackage.ServerEncoding, ai.Ou(dVar.cy(str, 1)));
                } catch (Exception e) {
                    x.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", new Object[]{e.getMessage()});
                    return null;
                }
            }
            if (z) {
                int intValue;
                if (!bh.ov(str) && p.uz(str)) {
                    String toLowerCase = str.toLowerCase();
                    if (toLowerCase.contains("localhost") || toLowerCase.contains("127.0.0.1") || toLowerCase.contains("::1") || toLowerCase.contains(s.ccQ())) {
                        if (this.tsA != null && this.tsA.size() > 0) {
                            for (Integer intValue2 : this.tsA) {
                                intValue = intValue2.intValue();
                                if (!toLowerCase.contains("localhost:" + intValue)) {
                                    if (toLowerCase.contains("127.0.0.1:" + intValue)) {
                                    }
                                }
                                x.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", new Object[]{toLowerCase, Integer.valueOf(intValue)});
                            }
                        }
                        x.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", new Object[]{toLowerCase});
                        intValue = 1;
                    }
                    intValue = 0;
                    break;
                }
                intValue = 0;
                if (intValue != 0) {
                    x.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", new Object[]{str});
                    return new m("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
                }
            }
            if (!b(str, dVar)) {
                return null;
            }
            x.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", new Object[]{str});
            return new m("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
        }
    }

    private boolean b(String str, d dVar) {
        Iterator it;
        if (this.tsx == -1) {
            try {
                Bundle e = dVar.e(31, null);
                if (e != null) {
                    this.tsx = e.getInt("webview_ad_intercept_control_flag");
                    this.tsy = e.getStringArrayList("webview_ad_intercept_whitelist_domins");
                    this.tsz = e.getStringArrayList("webview_ad_intercept_blacklist_domins");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("white domain list :\n");
                    it = this.tsy.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next()).append("\n");
                    }
                    stringBuilder.append("black list domain list : \n");
                    it = this.tsz.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next()).append("\n");
                    }
                    x.i("MicroMsg.WebViewResourceInterrupter", stringBuilder.toString());
                }
            } catch (Exception e2) {
                x.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", new Object[]{e2.getMessage()});
                this.tsx = 0;
            }
        }
        if (this.tsx == 0) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        x.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", new Object[]{host, this.tsB.get(host)});
        if (bh.ov(host)) {
            return false;
        }
        if (this.tsB.containsKey(host)) {
            return ((Boolean) this.tsB.get(host)).booleanValue();
        }
        if (this.tsy != null && this.tsy.size() > 0) {
            it = this.tsy.iterator();
            while (it.hasNext()) {
                if (host.contains((String) it.next())) {
                    this.tsB.put(host, Boolean.valueOf(false));
                    x.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
                    return false;
                }
            }
        }
        if (this.tsz != null && this.tsz.size() > 0) {
            it = this.tsz.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!bh.ov(str2) && host.contains(str2)) {
                    if (this.tsx == 1) {
                        this.tsB.put(host, Boolean.valueOf(true));
                        x.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", new Object[]{str2, str});
                        return true;
                    } else if (this.tsx == 2) {
                        x.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", new Object[]{str2, str});
                        this.tsC.add(host);
                        this.tsB.put(host, Boolean.valueOf(false));
                        return false;
                    }
                }
            }
        }
        this.tsB.put(host, Boolean.valueOf(false));
        return false;
    }

    private m b(d dVar) {
        try {
            if (dVar.e(98, null) == null) {
                return null;
            }
            try {
                String convertStreamToString = bh.convertStreamToString(ac.getContext().getAssets().open("jsapi/wxjs.js"));
                if (!TextUtils.isEmpty(this.tsD)) {
                    convertStreamToString = convertStreamToString.replace("__wx._getDgtVerifyRandomStr()", this.tsD).replace("__wx._isDgtVerifyEnabled()", "true");
                }
                m mVar = new m("application/javascript", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(convertStreamToString.getBytes("UTF-8")));
                Map hashMap = new HashMap();
                hashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
                hashMap.put("Pragma", "no-cache");
                hashMap.put("Expires", "0");
                mVar.mResponseHeaders = hashMap;
                return mVar;
            } catch (Exception e) {
                x.e("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, failed, ", new Object[]{e});
                return null;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
