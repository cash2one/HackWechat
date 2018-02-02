package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.aq.a.b.e;
import com.tencent.mm.aq.a.c.b;
import com.tencent.mm.aq.q;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class n$j$b implements b {
    public final com.tencent.mm.aq.a.d.b lA(String str) {
        x.d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", new Object[]{str});
        try {
            com.tencent.mm.aq.a.d.b bVar;
            long currentTimeMillis = System.currentTimeMillis();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            if (q.lx(str)) {
                httpURLConnection.setRequestProperty("Referer", q.hZ(d.vAz));
            }
            if (httpURLConnection.getResponseCode() >= 300) {
                httpURLConnection.disconnect();
                x.w("MicroMsg.ChattingBizImgDownloader.HttpClientFactory", "httpURLConnectionGet 300");
                bVar = null;
            } else {
                InputStream inputStream = httpURLConnection.getInputStream();
                bVar = new com.tencent.mm.aq.a.d.b(e.i(inputStream), httpURLConnection.getContentType(), (byte) 0);
            }
            if (bVar == null) {
                return bVar;
            }
            boolean z;
            long currentTimeMillis2 = System.currentTimeMillis();
            if (q.PE() && !bh.ov(bVar.aBD) && q.lx(str) && bVar.aBD.equals("image/webp")) {
                z = true;
            } else {
                z = false;
            }
            x.d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b", new Object[]{Boolean.valueOf(z)});
            long j = currentTimeMillis2 - currentTimeMillis;
            x.d("MicroMsg.ChattingBizImgDownloader", "download used %d ms", new Object[]{Long.valueOf(j)});
            g.pQN.a(86, 4, j, false);
            if (!z) {
                return bVar;
            }
            g.pQN.a(86, 17, j, false);
            return bVar;
        } catch (Exception e) {
            x.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", new Object[]{e.toString()});
            return new com.tencent.mm.aq.a.d.b(null, null, (byte) 0);
        }
    }
}
