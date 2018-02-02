package com.tencent.mapsdk.rastercore;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.tencent.mapsdk.rastercore.d$a.a;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.d;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

class d$c extends AsyncTask<String, Void, d> {
    private b a;

    public d$c(b bVar) {
        this.a = bVar;
    }

    private d a(String... strArr) {
        String optString;
        String[] b;
        Throwable th;
        boolean z = true;
        d dVar = new d((byte) 0);
        if (strArr != null && strArr.length == 2) {
            byte[] a;
            int i;
            dVar.a = b.e;
            dVar.b = e.v();
            dVar.c = e.t();
            dVar.d = e.s();
            dVar.e = e.w();
            dVar.f = e.x();
            d$a com_tencent_mapsdk_rastercore_d_a = a.a;
            String str = null;
            try {
                a = d$a.a(d$a.c());
                str = a != null ? new String(a, ProtocolPackage.ServerEncoding) : null;
            } catch (Exception e) {
                new StringBuilder("decode frontier.dat to string error:").append(e.toString());
            }
            if (d.a(str)) {
                i = 0;
            } else {
                String[] b2 = d.b(str);
                i = !d.a(b2[0]) ? Integer.parseInt(b2[0]) : 0;
                if (!d.a(b2[1])) {
                    c.a(b2[1]);
                }
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0] + "&frontier=" + i).openConnection();
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                if (httpURLConnection.getResponseCode() == 200) {
                    String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                    boolean z2 = headerField != null && headerField.length() > 0 && headerField.toLowerCase().contains("gzip");
                    JSONObject jSONObject = new JSONObject(new String(d$a.a(z2 ? new GZIPInputStream(httpURLConnection.getInputStream()) : httpURLConnection.getInputStream())));
                    if (jSONObject.optInt("error") != 0) {
                        return dVar;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("info");
                    if (optJSONObject == null) {
                        return dVar;
                    }
                    jSONObject = optJSONObject.optJSONObject("raster");
                    if (jSONObject == null) {
                        return dVar;
                    }
                    dVar.a = jSONObject.optInt("style", 1000);
                    dVar.b = jSONObject.optInt("version", b.a);
                    int optInt = jSONObject.optInt("cur", b.b);
                    int optInt2 = jSONObject.optInt("sat", b.d);
                    a.a.a(dVar.a, 0, dVar.b);
                    a.a.a(strArr[1], dVar.a, false);
                    a.a.a(dVar.a, 3, optInt2);
                    a.a.a(dVar.a, 1, optInt);
                    jSONObject = optJSONObject.optJSONObject("world");
                    if (jSONObject == null) {
                        return dVar;
                    }
                    byte[] a2;
                    boolean z3;
                    dVar.c = jSONObject.optInt("style", 1000);
                    int optInt3 = jSONObject.optInt("version", b.c);
                    String optString2 = jSONObject.optString("logo");
                    boolean z4 = !new File(d$a.b()).exists();
                    if (!z4) {
                        a = d$a.a(d$a.b());
                        if (a != null) {
                            try {
                                dVar.g = BitmapFactory.decodeByteArray(a, 0, a.length);
                            } catch (Exception e2) {
                                new StringBuilder("decode bing logo error :").append(e2.toString());
                                z4 = true;
                            }
                        }
                        if (dVar.g == null) {
                            z4 = true;
                        }
                    }
                    if (z4 && optString2 != null) {
                        if (optString2.trim().length() > 0) {
                            HttpURLConnection httpURLConnection2 = null;
                            try {
                                httpURLConnection = (HttpURLConnection) new URL(optString2).openConnection();
                                try {
                                    httpURLConnection.setRequestMethod("GET");
                                    httpURLConnection.setConnectTimeout(5000);
                                    if (httpURLConnection.getResponseCode() == 200) {
                                        a = d$a.a(httpURLConnection.getInputStream());
                                        dVar.g = BitmapFactory.decodeByteArray(a, 0, a.length);
                                        d$a.a(a, d$a.b());
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                } catch (Exception e3) {
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    jSONObject = optJSONObject.optJSONObject("frontier");
                                    if (jSONObject != null) {
                                        optString = jSONObject.optString("path");
                                        if (!d.a(optString)) {
                                            httpURLConnection = (HttpURLConnection) new URL(optString).openConnection();
                                            httpURLConnection.setRequestMethod("GET");
                                            httpURLConnection.setConnectTimeout(5000);
                                            if (httpURLConnection.getResponseCode() == 200) {
                                                d$a.a(d$a.a(new GZIPInputStream(httpURLConnection.getInputStream())), d$a.c());
                                                com_tencent_mapsdk_rastercore_d_a = a.a;
                                                a2 = d$a.a(d$a.c());
                                                if (a2 != null) {
                                                    str = new String(a2, ProtocolPackage.ServerEncoding);
                                                }
                                                if (!d.a(str)) {
                                                    b = d.b(str);
                                                    if (!d.a(b[1])) {
                                                        c.a(b[1]);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    a.a.a(dVar.c, 2, optInt3);
                                    a.a.a(strArr[1], dVar.c, true);
                                    z3 = optInt != dVar.f;
                                    z4 = optInt3 != dVar.d;
                                    if (optInt2 == dVar.e) {
                                        z = false;
                                    }
                                    new 1(this, z3, z4, z).start();
                                    dVar.f = optInt;
                                    dVar.d = optInt3;
                                    dVar.e = optInt2;
                                    return dVar;
                                } catch (Throwable th2) {
                                    httpURLConnection2 = httpURLConnection;
                                    th = th2;
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    throw th;
                                }
                            } catch (Exception e4) {
                                httpURLConnection = null;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                jSONObject = optJSONObject.optJSONObject("frontier");
                                if (jSONObject != null) {
                                    optString = jSONObject.optString("path");
                                    if (d.a(optString)) {
                                        httpURLConnection = (HttpURLConnection) new URL(optString).openConnection();
                                        httpURLConnection.setRequestMethod("GET");
                                        httpURLConnection.setConnectTimeout(5000);
                                        if (httpURLConnection.getResponseCode() == 200) {
                                            d$a.a(d$a.a(new GZIPInputStream(httpURLConnection.getInputStream())), d$a.c());
                                            com_tencent_mapsdk_rastercore_d_a = a.a;
                                            a2 = d$a.a(d$a.c());
                                            if (a2 != null) {
                                                str = new String(a2, ProtocolPackage.ServerEncoding);
                                            }
                                            if (d.a(str)) {
                                                b = d.b(str);
                                                if (d.a(b[1])) {
                                                    c.a(b[1]);
                                                }
                                            }
                                        }
                                    }
                                }
                                a.a.a(dVar.c, 2, optInt3);
                                a.a.a(strArr[1], dVar.c, true);
                                if (optInt != dVar.f) {
                                }
                                if (optInt3 != dVar.d) {
                                }
                                if (optInt2 == dVar.e) {
                                    z = false;
                                }
                                new 1(this, z3, z4, z).start();
                                dVar.f = optInt;
                                dVar.d = optInt3;
                                dVar.e = optInt2;
                                return dVar;
                            } catch (Throwable th3) {
                                th = th3;
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                throw th;
                            }
                        }
                    }
                    try {
                        jSONObject = optJSONObject.optJSONObject("frontier");
                        if (jSONObject != null) {
                            optString = jSONObject.optString("path");
                            if (d.a(optString)) {
                                httpURLConnection = (HttpURLConnection) new URL(optString).openConnection();
                                httpURLConnection.setRequestMethod("GET");
                                httpURLConnection.setConnectTimeout(5000);
                                if (httpURLConnection.getResponseCode() == 200) {
                                    d$a.a(d$a.a(new GZIPInputStream(httpURLConnection.getInputStream())), d$a.c());
                                    com_tencent_mapsdk_rastercore_d_a = a.a;
                                    a2 = d$a.a(d$a.c());
                                    if (a2 != null) {
                                        str = new String(a2, ProtocolPackage.ServerEncoding);
                                    }
                                    if (d.a(str)) {
                                        b = d.b(str);
                                        if (d.a(b[1])) {
                                            c.a(b[1]);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e22) {
                        new StringBuilder("frontier is already the new:").append(e22.toString());
                    }
                    a.a.a(dVar.c, 2, optInt3);
                    a.a.a(strArr[1], dVar.c, true);
                    if (optInt != dVar.f) {
                    }
                    if (optInt3 != dVar.d) {
                    }
                    if (optInt2 == dVar.e) {
                        z = false;
                    }
                    new 1(this, z3, z4, z).start();
                    dVar.f = optInt;
                    dVar.d = optInt3;
                    dVar.e = optInt2;
                }
            } catch (Exception e222) {
                new StringBuilder("check version got error:").append(e222.getMessage());
            }
        }
        return dVar;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        d dVar = (d) obj;
        if (dVar != null && this.a != null) {
            this.a.a(dVar.a, dVar.b, dVar.c, dVar.d, dVar.e, dVar.f, dVar.g);
        }
    }
}
