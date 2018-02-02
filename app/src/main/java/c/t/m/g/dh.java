package c.t.m.g;

import android.content.Context;
import android.os.Bundle;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;

public final class dh implements cj, TencentHttpClient {
    private static d a;

    public dh(Context context, String str) {
        try {
            a = a.a(new b(context, "test_uuid", str));
        } catch (Exception e) {
        }
    }

    public final Bundle postSync(String str, byte[] bArr) {
        if (a == null) {
            throw new IOException("can not init net sdk");
        }
        try {
            e a = a.a(str, bArr);
            a.a("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
            a.b();
            f a2 = a.a(a);
            if (a2.a() != 0 || a2.c() < 200 || a2.c() >= 300) {
                throw new IOException("net sdk error: errCode: " + a2.a() + ", errInfo: " + a2.b() + ", statusCode: " + a2.c() + ", reqKey: " + a.a());
            }
            Bundle bundle = new Bundle();
            bundle.putString("req_key", a.a());
            if (a2.d() == null) {
                bundle.putByteArray("data_bytes", "{}".getBytes());
                bundle.putString("data_charset", ProtocolPackage.ServerEncoding);
            } else {
                String a3 = a(a2.a("content-type"));
                bundle.putByteArray("data_bytes", a2.d());
                bundle.putString("data_charset", a3);
            }
            return bundle;
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public final String a(String str, byte[] bArr) {
        try {
            Bundle postSync = postSync(str, bArr);
            return new String(postSync.getByteArray("data_bytes"), postSync.getString("data_charset"));
        } catch (Throwable th) {
            return "{}";
        }
    }

    private static String a(String str) {
        String str2 = "GBK";
        if (str == null) {
            return str2;
        }
        for (String trim : str.split(";")) {
            String trim2 = trim2.trim();
            int indexOf = trim2.indexOf("charset=");
            if (-1 != indexOf) {
                return trim2.substring(indexOf + 8, trim2.length());
            }
        }
        return str2;
    }
}
