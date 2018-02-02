package com.tencent.mm.aq;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.b;

public final class q {
    private static String[] hCP = null;

    public static boolean PE() {
        boolean z;
        if (hCP == null) {
            PF();
        }
        if (VERSION.SDK_INT < 14 || hCP == null || hCP.length <= 0 || com.tencent.mm.compatible.d.q.gGe.gFz != 1) {
            z = false;
        } else {
            z = true;
        }
        x.d("MicroMsg.WebpUtil", "isSupportWebp: %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    private static void PF() {
        try {
            String value = ((a) g.h(a.class)).zY().getValue("BizEnableWebpUrl");
            x.d("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", new Object[]{value});
            if (!bh.ov(value)) {
                hCP = value.split(";");
                x.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", new Object[]{Integer.valueOf(hCP.length)});
            }
        } catch (b e) {
            x.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
        } catch (Exception e2) {
            x.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", new Object[]{e2.getMessage()});
        }
    }

    private static boolean lv(String str) {
        if (hCP == null || hCP.length <= 0 || bh.ov(str)) {
            return false;
        }
        for (String startsWith : hCP) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static String lw(String str) {
        if (hCP == null || hCP.length == 0) {
            x.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
            PF();
        }
        if (lv(str)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("wxtype");
                if (bh.ov(queryParameter)) {
                    return str;
                }
                queryParameter = queryParameter.toLowerCase();
                x.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, wxtype:%s", new Object[]{queryParameter});
                if (queryParameter.equals("gif") || queryParameter.contains("gif")) {
                    return str;
                }
                String queryParameter2 = parse.getQueryParameter("tp");
                if ((!bh.ov(queryParameter2) && queryParameter2.equals("webp")) || bh.ov(queryParameter)) {
                    return str;
                }
                x.d("MicroMsg.WebpUtil", "webpURL: %s", new Object[]{parse.buildUpon().appendQueryParameter("tp", "webp").build().toString()});
                return parse.buildUpon().appendQueryParameter("tp", "webp").build().toString();
            } catch (Exception e) {
                return str;
            }
        }
        x.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
        return str;
    }

    public static boolean lx(String str) {
        try {
            if (bh.ov(str) || !lv(str)) {
                return false;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("tp");
            if (bh.ov(queryParameter) || !queryParameter.equals("webp")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int PG() {
        Context context = ac.getContext();
        if (an.isWifi(context)) {
            return 1;
        }
        if (an.is4G(context)) {
            return 4;
        }
        if (an.is3G(context)) {
            return 3;
        }
        if (an.is2G(context)) {
            return 2;
        }
        return 0;
    }

    public static String hY(int i) {
        return String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(PG()), Integer.valueOf(2)});
    }

    public static String hZ(int i) {
        return String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(PG()), Integer.valueOf(1)});
    }

    public static String ly(String str) {
        String str2 = null;
        try {
            if (lv(str)) {
                String toLowerCase = Uri.parse(str).getQueryParameter("wxtype").toLowerCase();
                if (!bh.ov(toLowerCase)) {
                    str2 = toLowerCase.toLowerCase();
                }
            }
        } catch (Exception e) {
        }
        return str2;
    }
}
