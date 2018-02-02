package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c {
    public b a = null;
    public int b = 5;
    private final String c = "http://tcdns.myqcloud.com/queryip";
    private final String d = "forward_stream";
    private final String e = "forward_num";
    private final String f = "request_type";
    private final String g = "sdk_version";
    private Thread h = null;

    c() {
    }

    public void a(final String str, final int i) {
        this.h = new Thread(this, "TXCPushRoute") {
            final /* synthetic */ c c;

            public void run() {
                if (this.c.a != null) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (i < 5) {
                        try {
                            String a = this.c.b(str, i);
                            try {
                                JSONObject jSONObject = new JSONObject(a);
                                if (jSONObject.has("use") && jSONObject.getInt("use") == 0) {
                                    break;
                                }
                            } catch (Exception e) {
                            }
                            arrayList = this.c.a(a);
                            if (arrayList != null && arrayList.size() > 0) {
                                break;
                            }
                            AnonymousClass1.sleep(1000, 0);
                            i++;
                        } catch (Exception e2) {
                        }
                    }
                    this.c.a.onFetchDone(0, arrayList);
                }
            }
        };
        this.h.start();
    }

    private String b(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            InputStream c = c(str, i);
            if (c == null) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(c));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
        }
    }

    private InputStream c(String str, int i) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://tcdns.myqcloud.com/queryip").openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("forward_stream", str);
            httpURLConnection.setRequestProperty("forward_num", "2");
            httpURLConnection.setRequestProperty("sdk_version", TXCCommonUtil.getSDKVersionStr());
            if (i == 1) {
                httpURLConnection.setRequestProperty("request_type", "1");
            } else if (i == 2) {
                httpURLConnection.setRequestProperty("request_type", "2");
            } else {
                httpURLConnection.setRequestProperty("request_type", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            }
            if (this.b > 0) {
                httpURLConnection.setConnectTimeout(this.b * 1000);
                httpURLConnection.setReadTimeout(this.b * 1000);
            }
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return httpURLConnection.getInputStream();
            }
        } catch (Exception e) {
        }
        return null;
    }

    private ArrayList<a> a(String str) {
        int i = 0;
        ArrayList<a> arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("state") != 0) {
                return null;
            }
            JSONArray jSONArray = jSONObject.getJSONObject("content").getJSONArray("list");
            if (jSONArray == null) {
                return null;
            }
            a a;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                a = a((JSONObject) jSONArray.opt(i2));
                if (a != null && a.c) {
                    arrayList.add(a);
                }
            }
            while (i < jSONArray.length()) {
                a = a((JSONObject) jSONArray.opt(i));
                if (!(a == null || a.c)) {
                    arrayList.add(a);
                }
                i++;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a = (a) it.next();
                TXCLog.e("TXCIntelligentRoute", "Nearest IP: " + a.a + " Port: " + a.b + " Q Channel: " + a.c);
            }
            return arrayList;
        } catch (JSONException e) {
        }
    }

    private a a(JSONObject jSONObject) {
        a aVar = new a();
        try {
            aVar.a = jSONObject.getString("ip");
            aVar.b = jSONObject.getString("port");
            aVar.d = 0;
            aVar.c = false;
            if (!jSONObject.has(DownloadSettingTable$Columns.TYPE) || jSONObject.getInt(DownloadSettingTable$Columns.TYPE) != 2) {
                return aVar;
            }
            aVar.c = true;
            return aVar;
        } catch (JSONException e) {
            return null;
        }
    }
}
