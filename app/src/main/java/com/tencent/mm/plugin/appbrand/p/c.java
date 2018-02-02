package com.tencent.mm.plugin.appbrand.p;

import android.webkit.URLUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;

public final class c {
    public static String convertStreamToString(InputStream inputStream) {
        Closeable inputStreamReader = new InputStreamReader(inputStream);
        String str = new char[Downloads.RECV_BUFFER_SIZE];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            try {
                int read = inputStreamReader.read(str);
                if (-1 == read) {
                    break;
                }
                stringWriter.write(str, 0, read);
            } catch (Exception e) {
                stringWriter = "MicroMsg.AppBrandIOUtil";
                x.e(stringWriter, "convertStreamToString: read, %s", new Object[]{e.getMessage()});
                str = "";
                return str;
            } finally {
                bh.d(inputStreamReader);
                bh.d(inputStream);
            }
        }
        return stringWriter.toString();
    }

    public static String uy(String str) {
        InputStream inputStream = null;
        try {
            inputStream = ac.getContext().getAssets().open(str);
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", new Object[]{str, bh.i(e)});
        }
        if (inputStream == null) {
            return "";
        }
        return convertStreamToString(inputStream);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] k(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, Downloads.RECV_BUFFER_SIZE);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandIOUtil", "readPkgCertificate: " + e);
                byte[] bArr2 = new byte[0];
                return bArr2;
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    x.e("MicroMsg.AppBrandIOUtil", "close: " + e2);
                }
            }
        }
        byteArrayOutputStream.flush();
        try {
            inputStream.close();
        } catch (Exception e22) {
            x.e("MicroMsg.AppBrandIOUtil", "close: " + e22);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean uz(String str) {
        return !bh.ov(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str));
    }

    public static byte[] j(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return new byte[0];
        }
        if (!byteBuffer.isDirect()) {
            return byteBuffer.array();
        }
        int position = byteBuffer.position();
        byteBuffer.position(0);
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return bArr;
    }
}
