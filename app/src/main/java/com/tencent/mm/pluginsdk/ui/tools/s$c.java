package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.Base64;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.ah.a.h;
import com.tencent.mm.pluginsdk.ui.tools.s.b;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

class s$c implements a {
    private static Pattern vzj = Pattern.compile("image/[A-Za-z0-9]+");
    private static Pattern vzk = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
    private Context context;
    private String hKw;
    private String imagePath;
    private int opType;
    private String vzl;
    private String vzm;
    private boolean vzn;
    private b vzo;

    public s$c(Context context, String str, String str2, boolean z) {
        this(context, str, str2, z, 0, null);
    }

    public s$c(Context context, String str, String str2, boolean z, int i, b bVar) {
        this.context = context;
        this.hKw = str;
        this.vzm = str2;
        this.vzn = z;
        this.opType = i;
        this.vzo = bVar;
    }

    public final boolean JC() {
        if (1 == this.opType) {
            this.vzo.sS(this.imagePath);
        } else if (bh.ov(this.vzl)) {
            Toast.makeText(this.context, this.context.getString(h.sdF), 1).show();
        } else {
            Toast.makeText(this.context, this.vzl, 1).show();
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ccR() {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(this.hKw).openConnection();
            try {
                httpURLConnection3.setRequestMethod("GET");
                httpURLConnection3.setRequestProperty("Cookie", this.vzm);
                httpURLConnection3.setAllowUserInteraction(true);
                int responseCode = httpURLConnection3.getResponseCode();
                String headerField;
                if (responseCode != 200) {
                    if (responseCode == 301 || responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                        headerField = httpURLConnection3.getHeaderField("Location");
                        if (headerField == null) {
                            headerField = httpURLConnection3.getHeaderField("location");
                        }
                        x.i("MicroMsg.WebViewUtil", "redirect url = %s", new Object[]{headerField});
                        if (!bh.ov(headerField)) {
                            this.hKw = headerField;
                            ccR();
                            a(httpURLConnection3, inputStream2);
                            return;
                        }
                    }
                    this.vzl = this.context.getString(h.sdF);
                    a(httpURLConnection3, inputStream2);
                    return;
                }
                headerField = httpURLConnection3.getContentType();
                inputStream2 = httpURLConnection3.getInputStream();
                a(headerField, httpURLConnection3.getHeaderField("Content-Disposition"), inputStream2);
                a(httpURLConnection3, inputStream2);
            } catch (Exception e) {
                Exception exception2 = e;
                inputStream = inputStream2;
                httpURLConnection = httpURLConnection3;
                exception = exception2;
                try {
                    x.e("MicroMsg.WebViewUtil", "init http url connection failed : %s", new Object[]{exception.getMessage()});
                    a(httpURLConnection, inputStream);
                } catch (Throwable th2) {
                    th = th2;
                    InputStream inputStream3 = inputStream;
                    httpURLConnection2 = httpURLConnection;
                    inputStream2 = inputStream3;
                    a(httpURLConnection2, inputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                httpURLConnection2 = httpURLConnection3;
                th = th4;
                a(httpURLConnection2, inputStream2);
                throw th;
            }
        } catch (Exception e2) {
            exception = e2;
            inputStream = inputStream2;
            x.e("MicroMsg.WebViewUtil", "init http url connection failed : %s", new Object[]{exception.getMessage()});
            a(httpURLConnection, inputStream);
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection2 = inputStream2;
            a(httpURLConnection2, inputStream2);
            throw th;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, InputStream inputStream) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebViewUtil", e, "", new Object[0]);
            }
        }
    }

    private void a(String str, String str2, InputStream inputStream) {
        Matcher matcher;
        x.i("MicroMsg.WebViewUtil", "contentType = %s, dispositionType = %s", new Object[]{str, str2});
        String str3 = null;
        if (!bh.ov(str)) {
            matcher = vzj.matcher(str);
            if (matcher.find()) {
                str3 = matcher.group().substring(matcher.group().lastIndexOf(47) + 1);
            }
        }
        if (bh.ov(str3) && !bh.ov(str2)) {
            matcher = vzk.matcher(str2);
            if (matcher.find()) {
                str3 = matcher.group().substring(matcher.group().lastIndexOf(46) + 1);
            }
        }
        if (bh.ov(str3)) {
            q qVar = new q(this.hKw);
            int lastIndexOf = qVar.beo.lastIndexOf(46);
            if (lastIndexOf == -1) {
                str3 = "jpg";
            } else {
                str3 = qVar.beo.substring(lastIndexOf + 1);
            }
        }
        this.imagePath = k.on(str3);
        FileOutputStream fileOutputStream = new FileOutputStream(this.imagePath);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                try {
                    break;
                } catch (Exception e) {
                    x.e("MicroMsg.WebViewUtil", "close os failed : %s", new Object[]{e.getMessage()});
                }
            }
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        if (this.opType == 0) {
            this.vzl = this.context.getString(h.dXO, new Object[]{k.Wc()});
            k.b(this.imagePath, this.context);
        }
    }

    public final boolean JB() {
        Exception e;
        FileOutputStream fileOutputStream;
        Throwable th;
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th2;
        InputStream inputStream = null;
        if (!this.vzn) {
            this.vzl = this.context.getString(h.sdG);
            return true;
        } else if (bh.ov(this.hKw)) {
            return false;
        } else {
            int indexOf;
            if (URLUtil.isDataUrl(this.hKw)) {
                this.imagePath = k.on("jpg");
                try {
                    indexOf = this.hKw.indexOf("base64");
                    if (indexOf > 0) {
                        this.hKw = this.hKw.substring(indexOf + 7);
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(this.imagePath);
                    try {
                        byte[] decode = Base64.decode(this.hKw, 0);
                        if (decode != null) {
                            fileOutputStream2.write(decode);
                        }
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        this.vzl = this.context.getString(h.dXO, new Object[]{k.Wc()});
                        k.b(this.imagePath, this.context);
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e2) {
                            x.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", new Object[]{e2.getMessage()});
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        fileOutputStream = fileOutputStream2;
                        try {
                            x.e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", new Object[]{e2.getMessage()});
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e22) {
                                    x.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", new Object[]{e22.getMessage()});
                                }
                            }
                            return true;
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                    x.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", new Object[]{e4.getMessage()});
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e22 = e5;
                    x.e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", new Object[]{e22.getMessage()});
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return true;
                }
            } else if (URLUtil.isHttpsUrl(this.hKw)) {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpsURLConnection) new URL(this.hKw).openConnection();
                    try {
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.setRequestProperty("Cookie", this.vzm);
                        httpURLConnection2.setAllowUserInteraction(true);
                        indexOf = httpURLConnection2.getResponseCode();
                        String headerField;
                        if (indexOf != 200) {
                            if (indexOf == 301 || indexOf == HardCoderJNI.SCENE_QUIT_CHATTING) {
                                headerField = httpURLConnection2.getHeaderField("Location");
                                if (headerField == null) {
                                    headerField = httpURLConnection2.getHeaderField("location");
                                }
                                x.i("MicroMsg.WebViewUtil", "redirect url = %s", new Object[]{headerField});
                                if (!bh.ov(headerField)) {
                                    this.hKw = headerField;
                                    ccR();
                                    a(httpURLConnection2, null);
                                }
                            }
                            this.vzl = this.context.getString(h.sdF);
                            a(httpURLConnection2, null);
                        } else {
                            headerField = httpURLConnection2.getContentType();
                            inputStream = httpURLConnection2.getInputStream();
                            a(headerField, httpURLConnection2.getHeaderField("Content-Disposition"), inputStream);
                            a(httpURLConnection2, inputStream);
                        }
                    } catch (Exception e222) {
                        Exception exception2 = e222;
                        httpURLConnection = httpURLConnection2;
                        exception = exception2;
                        try {
                            x.e("MicroMsg.WebViewUtil", "download https resource failed : %s", new Object[]{exception.getMessage()});
                            a(httpURLConnection, inputStream);
                            return true;
                        } catch (Throwable th5) {
                            th2 = th5;
                            a(httpURLConnection, inputStream);
                            throw th2;
                        }
                    } catch (Throwable th6) {
                        httpURLConnection = httpURLConnection2;
                        th2 = th6;
                        a(httpURLConnection, inputStream);
                        throw th2;
                    }
                } catch (Exception e6) {
                    exception = e6;
                    httpURLConnection = null;
                    x.e("MicroMsg.WebViewUtil", "download https resource failed : %s", new Object[]{exception.getMessage()});
                    a(httpURLConnection, inputStream);
                    return true;
                } catch (Throwable th7) {
                    th2 = th7;
                    httpURLConnection = null;
                    a(httpURLConnection, inputStream);
                    throw th2;
                }
            } else {
                ccR();
            }
            return true;
        }
    }
}
