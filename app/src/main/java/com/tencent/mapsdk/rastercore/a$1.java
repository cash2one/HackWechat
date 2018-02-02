package com.tencent.mapsdk.rastercore;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.f.a;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.zip.GZIPInputStream;

class a$1 extends Thread {
    a$1() {
    }

    public final void run() {
        String charSequence;
        DisplayMetrics displayMetrics;
        int i;
        int i2;
        int i3;
        StringBuffer stringBuffer;
        HttpURLConnection httpURLConnection;
        String headerField;
        boolean z;
        a.a(true);
        String str = "https://apikey.map.qq.com/mkey/index.php/mkey/check?";
        try {
            String encode = URLEncoder.encode(a.a(e.a()), "UTF-8");
            a.a.append("key=");
            a.a.append(encode);
        } catch (Exception e) {
        }
        a.a.append("&output=json");
        a.a.append("&pf=and_2Dmap");
        a.a.append("&ver=");
        try {
            a.a.append(URLEncoder.encode("1.2.8.29dc259", "UTF-8"));
        } catch (Exception e2) {
        }
        try {
            a.a.append("&hm=");
            a.a.append(URLEncoder.encode(Build.MODEL, "UTF-8"));
            a.a.append("&os=A");
            a.a.append(VERSION.SDK_INT);
            a.a.append("&pid=");
            a.a.append(URLEncoder.encode(e.a().getPackageName(), "UTF-8"));
            a.a.append("&nt=");
            a.a.append(URLEncoder.encode(a.b()));
        } catch (Exception e3) {
        }
        a.a.append("&suid=");
        a.a.append(a.a());
        try {
            PackageManager packageManager = e.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(e.a().getPackageName(), 0);
            charSequence = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            try {
                encode = packageInfo.versionName;
                if (TextUtils.isEmpty(encode)) {
                    encode = null;
                }
            } catch (Exception e4) {
                encode = charSequence;
                charSequence = encode;
                encode = null;
                if (charSequence != null) {
                    a.a.append("&ref=");
                    try {
                        a.a.append(URLEncoder.encode(charSequence, "UTF-8"));
                    } catch (Exception e5) {
                    }
                }
                if (encode != null) {
                    a.a.append("&psv=");
                    try {
                        a.a.append(URLEncoder.encode(encode, "UTF-8"));
                    } catch (Exception e6) {
                    }
                }
                displayMetrics = e.a().getResources().getDisplayMetrics();
                i = displayMetrics.densityDpi;
                i2 = displayMetrics.widthPixels;
                i3 = displayMetrics.heightPixels;
                a.a.append("&dpi=");
                a.a.append(i);
                a.a.append("&scrn=");
                a.a.append(i2);
                a.a.append("*");
                a.a.append(i3);
                stringBuffer = a.a;
                while (i2 < 2) {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(str + a.a.toString()).openConnection();
                        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                        if (httpURLConnection.getResponseCode() != 200) {
                            headerField = httpURLConnection.getHeaderField("Content-Encoding");
                            if (headerField == null) {
                            }
                            a.a(new String(d$a.a(z ? new BufferedInputStream(httpURLConnection.getInputStream()) : new BufferedInputStream(new GZIPInputStream(httpURLConnection.getInputStream())))));
                            break;
                        }
                        continue;
                    } catch (Exception e7) {
                    }
                }
                a.a(false);
            }
        } catch (Exception e8) {
            encode = null;
            charSequence = encode;
            encode = null;
            if (charSequence != null) {
                a.a.append("&ref=");
                a.a.append(URLEncoder.encode(charSequence, "UTF-8"));
            }
            if (encode != null) {
                a.a.append("&psv=");
                a.a.append(URLEncoder.encode(encode, "UTF-8"));
            }
            displayMetrics = e.a().getResources().getDisplayMetrics();
            i = displayMetrics.densityDpi;
            i2 = displayMetrics.widthPixels;
            i3 = displayMetrics.heightPixels;
            a.a.append("&dpi=");
            a.a.append(i);
            a.a.append("&scrn=");
            a.a.append(i2);
            a.a.append("*");
            a.a.append(i3);
            stringBuffer = a.a;
            for (i2 = 0; i2 < 2; i2++) {
                httpURLConnection = (HttpURLConnection) new URL(str + a.a.toString()).openConnection();
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                if (httpURLConnection.getResponseCode() != 200) {
                    headerField = httpURLConnection.getHeaderField("Content-Encoding");
                    if (headerField == null) {
                    }
                    if (z) {
                    }
                    a.a(new String(d$a.a(z ? new BufferedInputStream(httpURLConnection.getInputStream()) : new BufferedInputStream(new GZIPInputStream(httpURLConnection.getInputStream())))));
                    break;
                }
                continue;
            }
            a.a(false);
        }
        if (charSequence != null) {
            a.a.append("&ref=");
            a.a.append(URLEncoder.encode(charSequence, "UTF-8"));
        }
        if (encode != null) {
            a.a.append("&psv=");
            a.a.append(URLEncoder.encode(encode, "UTF-8"));
        }
        try {
            displayMetrics = e.a().getResources().getDisplayMetrics();
            i = displayMetrics.densityDpi;
            i2 = displayMetrics.widthPixels;
            i3 = displayMetrics.heightPixels;
            a.a.append("&dpi=");
            a.a.append(i);
            a.a.append("&scrn=");
            a.a.append(i2);
            a.a.append("*");
            a.a.append(i3);
        } catch (Exception e9) {
        }
        stringBuffer = a.a;
        for (i2 = 0; i2 < 2; i2++) {
            httpURLConnection = (HttpURLConnection) new URL(str + a.a.toString()).openConnection();
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (httpURLConnection.getResponseCode() != 200) {
                headerField = httpURLConnection.getHeaderField("Content-Encoding");
                z = headerField == null && headerField.length() > 0 && headerField.toLowerCase().contains("gzip");
                if (z) {
                }
                a.a(new String(d$a.a(z ? new BufferedInputStream(httpURLConnection.getInputStream()) : new BufferedInputStream(new GZIPInputStream(httpURLConnection.getInputStream())))));
                break;
            }
            continue;
        }
        a.a(false);
    }
}
