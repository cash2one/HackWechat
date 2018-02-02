package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.v4.content.a;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public final class e {
    SharedPreferences aRw;
    Context context;

    public e(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    private e(Context context, String str) {
        this.context = context;
        this.aRw = context.getSharedPreferences(str, 4);
        String str2 = str + "-no-backup";
        a aVar = new a();
        Context context2 = this.context;
        File file = new File(VERSION.SDK_INT >= 21 ? context2.getNoBackupFilesDir() : a.e(new File(context2.getApplicationInfo().dataDir, "no_backup")), str2);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    InstanceIDListenerService.a(this.context, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    new StringBuilder("Error creating file in no backup dir: ").append(e.getMessage());
                }
            }
        }
    }

    private synchronized void a(Editor editor, String str, String str2, String str3) {
        editor.putString(str + "|S|" + str2, str3);
    }

    private static String b(String str, String str2, String str3) {
        return str + "|T|" + str2 + "|" + str3;
    }

    private synchronized String get(String str, String str2) {
        return this.aRw.getString(str + "|S|" + str2, null);
    }

    public final synchronized void a(String str, String str2, String str3, String str4, String str5) {
        String b = b(str, str2, str3);
        Editor edit = this.aRw.edit();
        edit.putString(b, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    public final synchronized void aT(String str) {
        Editor edit = this.aRw.edit();
        for (String str2 : this.aRw.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public final void aU(String str) {
        aT(str + "|T|");
    }

    final KeyPair aV(String str) {
        Object e;
        String str2 = get(str, "|P|");
        String str3 = get(str, "|K|");
        if (str3 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str2, 8);
            byte[] decode2 = Base64.decode(str3, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (InvalidKeySpecException e2) {
            e = e2;
            new StringBuilder("Invalid key stored ").append(e);
            InstanceIDListenerService.a(this.context, this);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            new StringBuilder("Invalid key stored ").append(e);
            InstanceIDListenerService.a(this.context, this);
            return null;
        }
    }

    public final synchronized String c(String str, String str2, String str3) {
        return this.aRw.getString(b(str, str2, str3), null);
    }

    final synchronized KeyPair c(String str, long j) {
        KeyPair ps;
        ps = b.ps();
        Editor edit = this.aRw.edit();
        a(edit, str, "|P|", a.i(ps.getPublic().getEncoded()));
        a(edit, str, "|K|", a.i(ps.getPrivate().getEncoded()));
        a(edit, str, "cre", Long.toString(j));
        edit.commit();
        return ps;
    }

    final synchronized String get(String str) {
        return this.aRw.getString(str, null);
    }

    final boolean isEmpty() {
        return this.aRw.getAll().isEmpty();
    }

    public final synchronized void pu() {
        this.aRw.edit().clear().commit();
    }
}
