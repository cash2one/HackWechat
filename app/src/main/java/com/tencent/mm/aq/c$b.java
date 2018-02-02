package com.tencent.mm.aq;

import android.graphics.Bitmap;
import com.tencent.mm.aq.c.a;
import com.tencent.mm.aq.c.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class c$b implements Runnable {
    private HashMap<String, c> hzB;
    private String url;

    c$b(String str, HashMap<String, c> hashMap) {
        this.url = str;
        this.hzB = hashMap;
    }

    public final void run() {
        byte[] VM = bh.VM(this.url);
        if (VM == null) {
            x.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", new Object[]{this.url});
            return;
        }
        Bitmap bl;
        try {
            bl = d.bl(VM);
        } catch (Exception e) {
            x.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", new Object[]{this.url, e.getLocalizedMessage()});
            bl = null;
        }
        x.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", new Object[]{this.url});
        ag.y(new a(this.url, bl, this.hzB));
    }
}
