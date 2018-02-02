package c.t.m.g;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public final class ah implements HostnameVerifier {
    private String a;

    public ah(String str) {
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.a) || !(obj instanceof ah)) {
            return false;
        }
        CharSequence charSequence = ((ah) obj).a;
        return !TextUtils.isEmpty(charSequence) ? this.a.equals(charSequence) : false;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, sSLSession);
    }
}
