package com.tencent.mm.ag;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

class m$b implements a {
    public byte[] hkS = null;
    private final String hqd;
    private final String url;

    public m$b(String str, String str2) {
        this.hqd = str;
        this.url = str2;
    }

    public final boolean JB() {
        if (bh.ov(this.hqd) || bh.ov(this.url)) {
            return false;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream l = b.l(this.url, 3000, 5000);
            if (l == null) {
                return false;
            }
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (true) {
                int read = l.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            l.close();
            this.hkS = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (bh.bw(this.hkS)) {
                x.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.hqd);
                return false;
            }
            if (g.Dh().Cy()) {
                ak.a.hfM.aV(this.hkS.length, 0);
                m$a Mn = y.Mn();
                String str = this.hqd;
                String str2 = this.url;
                byte[] bArr2 = this.hkS;
                try {
                    str2 = str + str2;
                    Bitmap bl = d.bl(bArr2);
                    d.a(bl, 100, CompressFormat.PNG, m$a.kh(str2), false);
                    Mn.f(str, bl);
                    x.i("MicroMsg.BrandLogic", "update brand icon for  " + str + ", done");
                    Mn.hqa.remove(str);
                } catch (Throwable e) {
                    x.e("MicroMsg.BrandLogic", "exception:%s", new Object[]{bh.i(e)});
                }
            }
            return true;
        } catch (Throwable e2) {
            x.e("MicroMsg.BrandLogic", "exception:%s", new Object[]{bh.i(e2)});
            x.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
            this.hkS = null;
            return false;
        }
    }

    public final boolean JC() {
        m$a Mn = y.Mn();
        String str = this.hqd;
        int i = 0;
        while (i < Mn.hpZ.size()) {
            try {
                ((m$a.a) Mn.hpZ.get(i)).ki(str);
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.BrandLogic", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        return false;
    }
}
