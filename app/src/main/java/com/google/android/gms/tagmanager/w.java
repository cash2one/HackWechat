package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class w {
    private static w bbN;
    volatile int bbO = a.bbR;
    volatile String bbP = null;
    private volatile String bbQ = null;
    volatile String bbk = null;

    w() {
    }

    private static String bf(String str) {
        return str.split("&")[0].split("=")[1];
    }

    static w qX() {
        w wVar;
        synchronized (w.class) {
            if (bbN == null) {
                bbN = new w();
            }
            wVar = bbN;
        }
        return wVar;
    }

    final synchronized boolean e(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    new StringBuilder("Container preview url: ").append(decode);
                    m.qG();
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.bbO = a.bbT;
                    } else {
                        this.bbO = a.bbS;
                    }
                    this.bbQ = uri.getQuery().replace("&gtm_debug=x", "");
                    if (this.bbO == a.bbS || this.bbO == a.bbT) {
                        this.bbP = "/r?" + this.bbQ;
                    }
                    this.bbk = bf(this.bbQ);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        new StringBuilder("Invalid preview uri: ").append(decode);
                        m.qE();
                        z = false;
                    } else if (bf(uri.getQuery()).equals(this.bbk)) {
                        new StringBuilder("Exit preview mode for container: ").append(this.bbk);
                        m.qG();
                        this.bbO = a.bbR;
                        this.bbP = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }
}
