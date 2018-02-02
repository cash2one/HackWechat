package com.tencent.xweb;

import java.io.InputStream;
import java.util.Map;

public class m {
    public String mEncoding;
    public InputStream mInputStream;
    public String mMimeType;
    public String mReasonPhrase;
    public Map<String, String> mResponseHeaders;
    public int mStatusCode;

    public m(String str, String str2, InputStream inputStream) {
        this.mMimeType = str;
        this.mEncoding = str2;
        this.mInputStream = inputStream;
    }

    public m(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        this(str, str2, inputStream);
        setStatusCodeAndReasonPhrase(i, str3);
        this.mResponseHeaders = map;
    }

    public final void setStatusCodeAndReasonPhrase(int i, String str) {
        this.mStatusCode = i;
        this.mReasonPhrase = str;
    }
}
