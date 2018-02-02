package com.tencent.mm.aq.a.b;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class b implements com.tencent.mm.aq.a.c.b {
    public final com.tencent.mm.aq.a.d.b lA(String str) {
        x.d("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data from url:%s", new Object[]{str});
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            if (httpURLConnection == null) {
                x.i("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
            }
            if (httpURLConnection.getResponseCode() >= 300) {
                httpURLConnection.disconnect();
                x.w("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            String contentType = httpURLConnection.getContentType();
            byte[] i = e.i(inputStream);
            httpURLConnection.disconnect();
            return new com.tencent.mm.aq.a.d.b(i, contentType);
        } catch (Throwable e) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bh.i(e)});
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (Throwable e2) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bh.i(e2)});
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (Throwable e22) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bh.i(e22)});
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (Throwable e222) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bh.i(e222)});
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (Throwable e2222) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bh.i(e2222)});
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (Throwable e22222) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bh.i(e22222)});
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (Throwable e222222) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bh.i(e222222)});
            return new com.tencent.mm.aq.a.d.b(null, null);
        }
    }
}
