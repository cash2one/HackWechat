package c.t.m.g;

import android.os.SystemClock;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;

public final class ak extends ae {
    boolean A = false;
    private HttpURLConnection B;
    private DataOutputStream C;
    private DataInputStream D;
    private String E;
    private ai F;
    aj o;
    boolean p;
    boolean q;
    String r = "";
    int s;
    long t = 0;
    String u;
    a v = new a((byte) 0);
    long w;
    boolean x = false;
    boolean y = false;
    int z = 0;

    public ak(String str, String str2, boolean z, Map<String, String> map, byte[] bArr, int i, String str3) {
        this.E = str;
        this.b = str2;
        this.c = z;
        this.d = map;
        this.e = bArr;
        int a = p.g() == 2 ? v.a("direct_access_time_out", 1000, 60000, 15000) : v.a("direct_access_time_out", 1000, 60000, 10000);
        if (i >= a) {
            i = a;
        }
        this.f = cg.a(i, 200, 60000, 10000);
        this.g = str3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int i) {
        Object obj = null;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.B.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
            int i2 = 0;
            do {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        int i3 = 1;
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, read);
                        i2 += read;
                    }
                } catch (Exception e) {
                    return;
                } catch (OutOfMemoryError e2) {
                }
            } while (i2 <= i);
            this.o.a = -303;
            this.o.b = "no-content-length";
            if (obj != null) {
                this.o.d = byteArrayOutputStream.toByteArray();
                this.v.f = SystemClock.elapsedRealtime();
            }
            byteArrayOutputStream.close();
        } catch (OutOfMemoryError e22) {
        } catch (Exception e3) {
            this.o.a = -287;
            this.o.b = "read without content-length error";
        }
    }

    private void b() {
        Object obj = null;
        if (this.d != null && this.d.size() > 0) {
            Object obj2 = null;
            for (String str : this.d.keySet()) {
                this.B.addRequestProperty(str, (String) this.d.get(str));
                obj2 = str.toLowerCase().contains("host") ? 1 : obj2;
            }
            obj = obj2;
        }
        if (obj == null) {
            this.B.setRequestProperty("Host", this.E);
        }
        this.B.setRequestProperty("Halley", this.g + "-" + this.z + "-" + System.currentTimeMillis());
        if (this.y) {
            this.B.setRequestProperty("Connection", "close");
        }
        if (this.x) {
            this.B.setRequestProperty("X-Online-Host", this.E);
            this.B.setRequestProperty("x-tx-host", this.E);
        }
    }

    private void c() {
        try {
            if (this.B != null) {
                this.B.disconnect();
            }
            if (this.C != null) {
                this.C.close();
            }
            if (this.D != null) {
                this.D.close();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final aj a() {
        int i = 1;
        this.m = System.currentTimeMillis();
        this.w = SystemClock.elapsedRealtime();
        this.v.a = this.w;
        this.o = new aj(0, "");
        try {
            HttpURLConnection httpURLConnection;
            URL url = new URL(this.b);
            this.p = url.getProtocol().toLowerCase().startsWith("https");
            this.q = cg.d(url.getHost());
            if (this.p) {
                if (!this.x || p.k() == null) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection(Proxy.NO_PROXY);
                } else {
                    httpURLConnection = (HttpsURLConnection) url.openConnection(p.k());
                }
                if (this.q) {
                    this.F = new ai(this.E);
                    httpURLConnection.setSSLSocketFactory(this.F);
                    httpURLConnection.setHostnameVerifier(new ah(this.E));
                }
            } else {
                httpURLConnection = (!this.x || p.k() == null) ? (HttpURLConnection) url.openConnection(Proxy.NO_PROXY) : (HttpURLConnection) url.openConnection(p.k());
            }
            this.B = httpURLConnection;
            this.B.setRequestMethod(this.c ? "GET" : "POST");
            this.B.setConnectTimeout(this.f);
            this.B.setReadTimeout(this.f);
            this.B.setUseCaches(false);
            this.B.setDoInput(true);
            this.B.setInstanceFollowRedirects(false);
            b();
            if (!(this.c || cg.a(this.e))) {
                this.B.setDoOutput(true);
                this.t = (long) this.e.length;
            }
            this.v.b = SystemClock.elapsedRealtime();
            this.B.connect();
            this.v.c = SystemClock.elapsedRealtime();
            if (!(this.c || cg.a(this.e))) {
                this.C = new DataOutputStream(this.B.getOutputStream());
                this.C.write(this.e);
                this.C.flush();
            }
            this.v.d = SystemClock.elapsedRealtime();
            int responseCode = this.B.getResponseCode();
            this.v.e = SystemClock.elapsedRealtime();
            this.o.c = responseCode;
            this.r = this.B.getContentType();
            Map hashMap = new HashMap();
            for (Entry entry : this.B.getHeaderFields().entrySet()) {
                if (entry.getKey() != null) {
                    hashMap.put(entry.getKey(), ((List) entry.getValue()).get(0));
                }
            }
            this.o.a(hashMap);
            if (this.o.c >= 200 && this.o.c < 300) {
                this.s = this.B.getContentLength();
                responseCode = v.a("app_receive_pack_size", SQLiteGlobal.journalSizeLimit, 10485760, 2097152);
                if (this.s < 0) {
                    a(responseCode);
                } else if (this.s == 0) {
                    this.o.d = null;
                    this.v.f = SystemClock.elapsedRealtime();
                } else if (this.s > responseCode) {
                    this.o.a = -303;
                    this.o.b = this.s;
                } else {
                    try {
                        byte[] bArr = new byte[this.s];
                        this.D = new DataInputStream(this.B.getInputStream());
                        this.D.readFully(bArr);
                        this.o.d = bArr;
                        this.v.f = SystemClock.elapsedRealtime();
                    } catch (OutOfMemoryError e) {
                        this.o.a = -306;
                        this.o.b = this.s;
                    }
                }
            } else if (this.o.c < 300 || this.o.c >= 400) {
                this.u = cg.c(this.E);
            } else {
                this.h = this.o.a("location");
            }
            c();
            this.w = SystemClock.elapsedRealtime() - this.w;
            this.v.a();
        } catch (MalformedURLException e2) {
            this.o.a = -300;
        } catch (Throwable th) {
            c();
            this.w = SystemClock.elapsedRealtime() - this.w;
            this.v.a();
        }
        return this.o;
    }

    public final void a(boolean z) {
    }
}
