package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class v {
    public HttpsURLConnection iaw;

    public v(String str) {
        this(new URL(str));
    }

    private v(URL url) {
        this.iaw = null;
        try {
            this.iaw = (HttpsURLConnection) url.openConnection();
        } catch (Throwable e) {
            x.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", e.getMessage());
            x.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", bh.i(e));
        } catch (Throwable e2) {
            x.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", e2.getMessage());
            x.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", bh.i(e2));
        } catch (Throwable e22) {
            x.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + e22.getMessage());
            x.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", bh.i(e22));
        }
    }

    public final void VB() {
        this.iaw.setConnectTimeout(3000);
    }

    public final void VC() {
        this.iaw.setReadTimeout(3000);
    }

    public final void VD() {
        this.iaw.setUseCaches(true);
    }
}
