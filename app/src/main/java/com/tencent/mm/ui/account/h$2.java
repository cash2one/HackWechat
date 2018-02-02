package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f.a.a.a;
import com.tencent.mm.ui.f.a.e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class h$2 implements a {
    final /* synthetic */ h xPS;

    h$2(h hVar) {
        this.xPS = hVar;
    }

    public final void Yv(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.RefreshTokenRunner", "response is null or nil");
            h.a(this.xPS, 1, "response is null or nil");
        } else if (!str.contains("access_token") || str.length() <= 12) {
            try {
                e.ZM(str);
            } catch (Throwable e) {
                x.e("MicroMsg.RefreshTokenRunner", "parseJson exception : " + e.getMessage());
                x.printErrStackTrace("MicroMsg.RefreshTokenRunner", e, "", new Object[0]);
            } catch (Throwable e2) {
                String str2 = "errCode = " + e2.mErrorCode + ", errType = " + e2.zca + ", errMsg = " + e2.getMessage();
                x.e("MicroMsg.RefreshTokenRunner", "parseJson facebookerror, " + str2);
                x.printErrStackTrace("MicroMsg.RefreshTokenRunner", e2, "", new Object[0]);
                h.a(this.xPS, 3, str2);
                return;
            }
            h.a(this.xPS, 2, "parseJson error");
        } else {
            try {
                JSONObject ZM = e.ZM(str);
                if (ZM.has("access_token")) {
                    Bundle bundle = new Bundle();
                    Iterator keys = ZM.keys();
                    while (keys.hasNext()) {
                        String str3 = (String) keys.next();
                        JSONArray optJSONArray = ZM.optJSONArray(str3);
                        Double valueOf = Double.valueOf(ZM.optDouble(str3));
                        String optString = ZM.optString(str3);
                        if (optJSONArray == null || optJSONArray.length() > 0) {
                            int i;
                            if (optJSONArray != null) {
                                if (!Double.isNaN(optJSONArray.optDouble(0))) {
                                    double[] dArr = new double[optJSONArray.length()];
                                    for (i = 0; i < optJSONArray.length(); i++) {
                                        dArr[i] = optJSONArray.optDouble(i);
                                    }
                                    bundle.putDoubleArray(str3, dArr);
                                }
                            }
                            if (optJSONArray != null && optJSONArray.optString(0) != null) {
                                String[] strArr = new String[optJSONArray.length()];
                                for (i = 0; i < optJSONArray.length(); i++) {
                                    strArr[i] = optJSONArray.optString(i);
                                }
                                bundle.putStringArray(str3, strArr);
                            } else if (!valueOf.isNaN()) {
                                bundle.putDouble(str3, valueOf.doubleValue());
                            } else if (optString != null) {
                                bundle.putString(str3, optString);
                            } else {
                                System.err.println("unable to transform json to bundle " + str3);
                            }
                        } else {
                            bundle.putStringArray(str3, new String[0]);
                        }
                    }
                    h hVar = this.xPS;
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.setData(bundle);
                    hVar.handler.sendMessage(obtain);
                    return;
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.RefreshTokenRunner", e22, "", new Object[0]);
            }
            h.a(this.xPS, 2, "decodeUrl fail");
        }
    }

    public final void b(IOException iOException) {
        x.e("MicroMsg.RefreshTokenRunner", "onIOException");
        h.a(this.xPS, 2, iOException.getMessage());
    }

    public final void a(FileNotFoundException fileNotFoundException) {
        x.e("MicroMsg.RefreshTokenRunner", "onFileNotFoundException");
        h.a(this.xPS, 2, fileNotFoundException.getMessage());
    }

    public final void a(MalformedURLException malformedURLException) {
        x.e("MicroMsg.RefreshTokenRunner", "onMalformedURLException");
        h.a(this.xPS, 2, malformedURLException.getMessage());
    }
}
