package com.tencent.mm.aq.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.aq.a.c.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class e implements k {
    public final boolean an(String str, String str2) {
        if (bh.ov(str2)) {
            x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: filePath is null. check failed");
            return false;
        } else if (bh.ov(str)) {
            x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        } else {
            String bV = g.bV(str2);
            if (bh.ov(bV) || !bV.equals(str)) {
                x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[]{bV, str});
                return false;
            }
            x.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
            return true;
        }
    }

    public final boolean i(String str, byte[] bArr) {
        if (bh.ov(str)) {
            x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        }
        String bt = ab.bt(bArr);
        if (bh.ov(bt) || !bt.equals(str)) {
            x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[]{bt, str});
            return false;
        }
        x.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
        return true;
    }

    public final boolean b(String str, InputStream inputStream) {
        if (inputStream == null) {
            x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
            return false;
        } else if (bh.ov(str)) {
            x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        } else {
            try {
                String bt = ab.bt(a(inputStream, true));
                if (bh.ov(bt) || !bt.equals(str)) {
                    x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[]{bt, str});
                    return false;
                }
                x.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
                return true;
            } catch (Exception e) {
                x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: exception: " + e.toString());
                return false;
            }
        }
    }

    public static byte[] i(InputStream inputStream) {
        return a(inputStream, false);
    }

    public static byte[] a(InputStream inputStream, boolean z) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        bArr = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        if (!z) {
            inputStream.close();
        }
        return bArr;
    }
}
