package com.tencent.mm.network;

import com.tencent.mm.hardcoder.HardCoderJNI;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class u {
    private Map<String, List<String>> aBF = null;
    public HttpURLConnection aBw;
    public int hZy;
    public String iav;
    public URL url;

    public u(URL url, int i) {
        this.url = url;
        this.hZy = i;
        this.aBw = (HttpURLConnection) this.url.openConnection();
        if (1 == this.hZy) {
            this.aBw.setInstanceFollowRedirects(false);
        }
    }

    public final int getResponseCode() {
        int responseCode;
        while (true) {
            if (1 == this.hZy && this.aBF == null) {
                this.aBF = this.aBw.getRequestProperties();
            }
            responseCode = this.aBw.getResponseCode();
            if (1 != this.hZy || HardCoderJNI.SCENE_QUIT_CHATTING != responseCode) {
                break;
            }
            String headerField = this.aBw.getHeaderField("Location");
            if (headerField == null) {
                break;
            }
            this.url = new URL(this.url, headerField);
            this.aBw = (HttpURLConnection) this.url.openConnection();
            this.aBw.setInstanceFollowRedirects(false);
            if (this.aBF != null) {
                for (String str : this.aBF.keySet()) {
                    if (!(str.equals("Host") || str.equals("X-Online-Host"))) {
                        List list = (List) this.aBF.get(str);
                        for (int i = 0; i < list.size(); i++) {
                            this.aBw.setRequestProperty(str, (String) list.get(i));
                        }
                    }
                }
            }
            this.aBw.setRequestProperty("Host", this.url.getHost());
            this.aBw.setRequestProperty("X-Online-Host", this.url.getHost());
        }
        return responseCode;
    }

    public final void setRequestMethod(String str) {
        this.aBw.setRequestMethod(str);
    }

    public final void connect() {
        if (1 == this.hZy && this.aBF == null) {
            this.aBF = this.aBw.getRequestProperties();
        }
        this.aBw.connect();
    }

    public final Map<String, List<String>> getHeaderFields() {
        if (1 == this.hZy && this.aBF == null) {
            this.aBF = this.aBw.getRequestProperties();
        }
        return this.aBw.getHeaderFields();
    }

    public final String getHeaderField(String str) {
        if (1 == this.hZy && this.aBF == null) {
            this.aBF = this.aBw.getRequestProperties();
        }
        return this.aBw.getHeaderField(str);
    }

    public final InputStream getInputStream() {
        if (1 == this.hZy) {
            if (this.aBF == null) {
                this.aBF = this.aBw.getRequestProperties();
            }
            getResponseCode();
        }
        return this.aBw.getInputStream();
    }

    public final OutputStream getOutputStream() {
        if (1 == this.hZy) {
            if (this.aBF == null) {
                this.aBF = this.aBw.getRequestProperties();
            }
            getResponseCode();
        }
        return this.aBw.getOutputStream();
    }

    public final void Vz() {
        this.aBw.setDoInput(true);
    }

    public final void VA() {
        this.aBw.setDoOutput(true);
    }

    public final void setRequestProperty(String str, String str2) {
        this.aBw.setRequestProperty(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.aBw.setUseCaches(z);
    }

    public final void setConnectTimeout(int i) {
        this.aBw.setConnectTimeout(i);
    }

    public final void setReadTimeout(int i) {
        this.aBw.setReadTimeout(i);
    }

    public final void oi(String str) {
        this.aBw.setRequestProperty("Referer", str);
    }

    public final String toString() {
        return this.aBw.toString();
    }
}
