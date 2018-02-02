package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.plugin.gif.MMGIFException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public final class a {
    static Map<String, a> aQS = new HashMap();
    public static e aQT;
    private static d aQU;
    public static String aQY;
    KeyPair aQV;
    public String aQW = "";
    long aQX;
    Context mContext;

    private a(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.aQW = str;
    }

    static int L(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            new StringBuilder("Never happens: can't find own package ").append(e);
            return i;
        }
    }

    public static a M(Context context) {
        return a(context, null);
    }

    public static synchronized a a(Context context, Bundle bundle) {
        a aVar;
        synchronized (a.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (aQT == null) {
                aQT = new e(applicationContext);
                aQU = new d(applicationContext);
            }
            aQY = Integer.toString(L(applicationContext));
            aVar = (a) aQS.get(str);
            if (aVar == null) {
                aVar = new a(applicationContext, str);
                aQS.put(str, aVar);
            }
        }
        return aVar;
    }

    static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + MMGIFException.D_GIF_ERR_IMAGE_DEFECT) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    static String i(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    static e pp() {
        return aQT;
    }

    static d pq() {
        return aQU;
    }

    public static boolean pr() {
        String str = aQT.get("appVersion");
        if (str == null || !str.equals(aQY)) {
            return true;
        }
        str = aQT.get("lastToken");
        if (str == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str)).longValue() > 604800;
    }

    public final String b(String str, String str2, Bundle bundle) {
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        String str3 = "".equals(this.aQW) ? str : this.aQW;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        d dVar = aQU;
        if (this.aQV == null) {
            this.aQV = aQT.aV(this.aQW);
        }
        if (this.aQV == null) {
            this.aQX = System.currentTimeMillis();
            this.aQV = aQT.c(this.aQW, this.aQX);
        }
        KeyPair keyPair = this.aQV;
        Intent a = dVar.a(bundle, keyPair);
        if (a != null && a.hasExtra("google.messenger")) {
            a = dVar.a(bundle, keyPair);
        }
        return d.g(a);
    }
}
