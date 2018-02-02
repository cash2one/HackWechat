package com.tencent.mm.plugin.emoji.d;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.a.o;
import com.tencent.mm.aq.a.b.e;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.network.b.b;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.InputStream;

class a$a {
    private static u b(String str, b bVar) {
        u a = com.tencent.mm.network.b.a(str, bVar);
        String str2 = "";
        if (ar.Hj()) {
            r2 = new Object[4];
            ar.Hg();
            r2[1] = o.getString(c.Cg());
            r2[2] = Integer.valueOf(an.getNetTypeForStat(ac.getContext()));
            r2[3] = Integer.valueOf(an.getStrength(ac.getContext()));
            str2 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r2);
        }
        x.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "referer %s ", str2);
        a.setRequestMethod("GET");
        a.setRequestProperty("referer", str2);
        a.setConnectTimeout(15000);
        a.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
        return a;
    }

    public static com.tencent.mm.aq.a.d.b c(String str, b bVar) {
        Throwable th;
        InputStream inputStream;
        String contentType;
        byte[] a;
        u b = b(str, bVar);
        if (b == null) {
            x.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "open connection failed.");
        }
        if (b.getResponseCode() == HardCoderJNI.SCENE_QUIT_CHATTING) {
            try {
                x.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "302 redirect: %s", str);
                String headerField = b.getHeaderField("location");
                if (!bh.ov(headerField)) {
                    b bVar2 = new b(headerField);
                    try {
                        b.aBw.disconnect();
                        b = b(headerField, bVar2);
                        bVar = bVar2;
                    } catch (Throwable e) {
                        bVar = bVar2;
                        th = e;
                        x.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", th, "httpURLConnectionGet 302 redirect", new Object[0]);
                        if (com.tencent.mm.network.b.a(b) != 0) {
                            inputStream = b.getInputStream();
                            if (inputStream == null) {
                                contentType = b.aBw.getContentType();
                                a = e.a(inputStream, false);
                                b.aBw.disconnect();
                                return new com.tencent.mm.aq.a.d.b(a, contentType);
                            }
                            x.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", str);
                            return null;
                        }
                        x.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", str, bVar.ip, bVar.ip, Integer.valueOf(bVar.hZy), Integer.valueOf(b.getResponseCode()));
                        switch (b.getResponseCode()) {
                            case TencentLocation.ERROR_UNKNOWN /*404*/:
                                g.pQN.a(315, 8, 1, false);
                                break;
                            case 502:
                                g.pQN.a(315, 9, 1, false);
                                break;
                            case 503:
                                g.pQN.a(315, 10, 1, false);
                                break;
                            case 504:
                                g.pQN.a(315, 11, 1, false);
                                break;
                            default:
                                g.pQN.a(315, 12, 1, false);
                                break;
                        }
                        return null;
                    }
                }
            } catch (Exception e2) {
                th = e2;
                x.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", th, "httpURLConnectionGet 302 redirect", new Object[0]);
                if (com.tencent.mm.network.b.a(b) != 0) {
                    x.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", str, bVar.ip, bVar.ip, Integer.valueOf(bVar.hZy), Integer.valueOf(b.getResponseCode()));
                    switch (b.getResponseCode()) {
                        case TencentLocation.ERROR_UNKNOWN /*404*/:
                            g.pQN.a(315, 8, 1, false);
                            break;
                        case 502:
                            g.pQN.a(315, 9, 1, false);
                            break;
                        case 503:
                            g.pQN.a(315, 10, 1, false);
                            break;
                        case 504:
                            g.pQN.a(315, 11, 1, false);
                            break;
                        default:
                            g.pQN.a(315, 12, 1, false);
                            break;
                    }
                    return null;
                }
                inputStream = b.getInputStream();
                if (inputStream == null) {
                    x.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", str);
                    return null;
                }
                contentType = b.aBw.getContentType();
                a = e.a(inputStream, false);
                b.aBw.disconnect();
                return new com.tencent.mm.aq.a.d.b(a, contentType);
            }
        }
        if (com.tencent.mm.network.b.a(b) != 0) {
            x.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", str, bVar.ip, bVar.ip, Integer.valueOf(bVar.hZy), Integer.valueOf(b.getResponseCode()));
            switch (b.getResponseCode()) {
                case TencentLocation.ERROR_UNKNOWN /*404*/:
                    g.pQN.a(315, 8, 1, false);
                    break;
                case 502:
                    g.pQN.a(315, 9, 1, false);
                    break;
                case 503:
                    g.pQN.a(315, 10, 1, false);
                    break;
                case 504:
                    g.pQN.a(315, 11, 1, false);
                    break;
                default:
                    g.pQN.a(315, 12, 1, false);
                    break;
            }
            return null;
        }
        inputStream = b.getInputStream();
        if (inputStream == null) {
            x.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", str);
            return null;
        }
        contentType = b.aBw.getContentType();
        a = e.a(inputStream, false);
        b.aBw.disconnect();
        return new com.tencent.mm.aq.a.d.b(a, contentType);
    }
}
