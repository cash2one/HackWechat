package com.tencent.d.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.d;
import com.tencent.d.a.c.e;
import com.tencent.d.a.c.f;
import com.tencent.d.a.c.g;
import com.tencent.d.a.c.h;
import com.tencent.d.a.c.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import org.xwalk.core.XWalkAppVersion;

public final class a implements com.tencent.d.a.c.a {
    private static boolean AbG = false;

    @SuppressLint({"PrivateApi"})
    public static void setUp() {
        try {
            Method method = Class.forName("android.security.keystore.SoterKeyStoreProvider").getMethod("install", new Class[0]);
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
        } catch (ClassNotFoundException e) {
            c.i("Soter.SoterCore", "soter: no SoterProvider found", new Object[0]);
        } catch (NoSuchMethodException e2) {
            c.i("Soter.SoterCore", "soter: function not found", new Object[0]);
        } catch (IllegalAccessException e3) {
            c.i("Soter.SoterCore", "soter: cannot access", new Object[0]);
        } catch (InvocationTargetException e4) {
            c.i("Soter.SoterCore", "soter: InvocationTargetException", new Object[0]);
        } finally {
            AbG = true;
        }
    }

    public static boolean cFI() {
        if (!AbG) {
            setUp();
        }
        if (g.cFU()) {
            c.w("Soter.SoterCore", "hy: the device has already triggered OOM. mark as not support", new Object[0]);
            return false;
        }
        Provider[] providers = Security.getProviders();
        if (providers == null) {
            c.e("Soter.SoterCore", "soter: no provider supported", new Object[0]);
            return false;
        }
        for (Provider name : providers) {
            if ("SoterKeyStore".equals(name.getName())) {
                c.i("Soter.SoterCore", "soter: found soter provider", new Object[0]);
                return true;
            }
        }
        c.i("Soter.SoterCore", "soter: soter provider not found", new Object[0]);
        return false;
    }

    public static e cFJ() {
        c.i("Soter.SoterCore", "soter: start generate ask", new Object[0]);
        if (cFI()) {
            try {
                KeyStore.getInstance("AndroidKeyStore").load(null);
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "SoterKeyStore");
                instance.initialize(com.tencent.d.a.b.a.aby(d.cFS().Acm + ".addcounter.auto_signed_when_get_pubkey_attk").M(new String[]{XWalkAppVersion.XWALK_APK_HASH_ALGORITHM}).N(new String[]{"PSS"}).cFQ());
                long nanoTime = System.nanoTime();
                instance.generateKeyPair();
                long gx = f.gx(nanoTime);
                c.i("Soter.SoterCore", "soter: generate successfully. cost: %d ms", new Object[]{Long.valueOf(gx)});
                return new e(0);
            } catch (Throwable e) {
                Throwable th = e;
                c.e("Soter.SoterCore", "soter: generateAppGlobalSecureKey " + th.toString(), new Object[0]);
                c.a("Soter.SoterCore", th, "soter: generateAppGlobalSecureKey error");
                return new e(4, th.toString());
            } catch (Throwable e2) {
                c.a("Soter.SoterCore", e2, "soter: out of memory when generate ASK!! maybe no attk inside");
                g.cFT();
            }
        } else {
            c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
            return new e(2);
        }
    }

    public static e cFK() {
        c.i("Soter.SoterCore", "soter: start remove app global secure key", new Object[0]);
        if (cFI()) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                instance.deleteEntry(d.cFS().Acm);
                return new e(0);
            } catch (Exception e) {
                Exception exception = e;
                c.e("Soter.SoterCore", "soter: removeAppGlobalSecureKey " + exception.toString(), new Object[0]);
                return new e(5, exception.toString());
            }
        }
        c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
        return new e(2);
    }

    public static boolean cFL() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (instance.getCertificate(d.cFS().Acm) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            c.e("Soter.SoterCore", "soter: hasAppGlobalSecureKey exception: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static boolean cFM() {
        return cFL() && cFN() != null;
    }

    public static h cFN() {
        c.i("Soter.SoterCore", "soter: start get app global secure key pub", new Object[0]);
        if (cFI()) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                try {
                    Key key = instance.getKey(d.cFS().Acm, "from_soter_ui".toCharArray());
                    if (key != null) {
                        return bP(key.getEncoded());
                    }
                    c.e("Soter.SoterCore", "soter: key can not be retrieved", new Object[0]);
                    return null;
                } catch (ClassCastException e) {
                    c.e("Soter.SoterCore", "soter: cast error: " + e.toString(), new Object[0]);
                    return null;
                }
            } catch (Throwable e2) {
                c.a("Soter.SoterCore", e2, "soter: error when get ask");
                return null;
            } catch (Throwable e22) {
                c.a("Soter.SoterCore", e22, "soter: out of memory when getting ask!! maybe no attk inside");
                g.cFT();
                return null;
            }
        }
        c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static e abs(String str) {
        if (f.ov(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return new e(1, "no authKeyName");
        } else if (cFI()) {
            try {
                if (!cFL()) {
                    return new e(3, "app secure key not exist");
                }
                KeyStore.getInstance("AndroidKeyStore").load(null);
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "SoterKeyStore");
                instance.initialize(com.tencent.d.a.b.a.aby(str + String.format(".addcounter.auto_signed_when_get_pubkey(%s).secmsg_and_counter_signed_when_sign", new Object[]{d.cFS().Acm})).M(new String[]{XWalkAppVersion.XWALK_APK_HASH_ALGORITHM}).cFR().N(new String[]{"PSS"}).cFQ());
                long nanoTime = System.nanoTime();
                instance.generateKeyPair();
                long gx = f.gx(nanoTime);
                c.i("Soter.SoterCore", "soter: generate successfully, cost: %d ms", new Object[]{Long.valueOf(gx)});
                return new e(0);
            } catch (Exception e) {
                Exception exception = e;
                c.e("Soter.SoterCore", "soter: cause exception. maybe reflection exception: " + exception.toString(), new Object[0]);
                return new e(5, exception.toString());
            } catch (Throwable e2) {
                c.a("Soter.SoterCore", e2, "soter: out of memory when generate AuthKey!! maybe no attk inside");
                g.cFT();
            }
        } else {
            c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
            return new e(2);
        }
    }

    public static e bs(String str, boolean z) {
        if (f.ov(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return new e(1, "no authKeyName");
        }
        c.i("Soter.SoterCore", "soter: start remove key: " + str, new Object[0]);
        if (cFI()) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                instance.deleteEntry(str);
                if (z) {
                    c.i("Soter.SoterCore", "soter: auto delete ask", new Object[0]);
                    if (cFL()) {
                        cFK();
                    }
                }
                return new e(0);
            } catch (Exception e) {
                Exception exception = e;
                c.e("Soter.SoterCore", "soter: removeAuthKey " + exception.toString(), new Object[0]);
                return new e(6, exception.toString());
            }
        }
        c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
        return new e(2);
    }

    public static boolean abt(String str) {
        if (f.ov(str)) {
            c.e("Soter.SoterCore", "soter: authkey name not correct", new Object[0]);
            return false;
        }
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (instance.getCertificate(str) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            c.e("Soter.SoterCore", "soter: hasAppGlobalSecureKey exception: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static boolean abu(String str) {
        c.i("Soter.SoterCore", String.format("soter: checking key valid: auth key name: %s, autoDelIfNotValid: %b ", new Object[]{str, Boolean.valueOf(true)}), new Object[0]);
        if (f.ov(str)) {
            c.e("Soter.SoterCore", "soter: checking key valid: authkey name not correct", new Object[0]);
            return false;
        }
        try {
            abx(str);
            c.i("Soter.SoterCore", "soter: key valid", new Object[0]);
            return true;
        } catch (UnrecoverableEntryException e) {
            c.e("Soter.SoterCore", "soter: key invalid.", new Object[0]);
            bs(str, false);
            return false;
        } catch (InvalidKeyException e2) {
            c.e("Soter.SoterCore", "soter: key invalid.", new Object[0]);
            bs(str, false);
            return false;
        } catch (Throwable e3) {
            c.e("Soter.SoterCore", "soter: occurs other exceptions: %s", new Object[]{e3.toString()});
            c.a("Soter.SoterCore", e3, "soter: occurs other exceptions");
            return false;
        } catch (Throwable e4) {
            c.a("Soter.SoterCore", e4, "soter: out of memory when isAuthKeyValid!! maybe no attk inside");
            g.cFT();
            return false;
        }
    }

    public static h abv(String str) {
        if (f.ov(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        } else if (cFI()) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                try {
                    Key key = instance.getKey(str, "from_soter_ui".toCharArray());
                    if (key != null) {
                        return bP(key.getEncoded());
                    }
                    c.e("Soter.SoterCore", "soter: key can not be retrieved", new Object[0]);
                    return null;
                } catch (ClassCastException e) {
                    c.e("Soter.SoterCore", "soter: cast error: " + e.toString(), new Object[0]);
                    return null;
                }
            } catch (Throwable e2) {
                c.a("Soter.SoterCore", e2, "soter: error in get auth key model");
                return null;
            } catch (Throwable e22) {
                c.a("Soter.SoterCore", e22, "soter: out of memory when getAuthKeyModel!! maybe no attk inside");
                g.cFT();
                return null;
            }
        } else {
            c.e("Soter.SoterCore", "soter: not support soter AndroidKeyStore", new Object[0]);
            return null;
        }
    }

    public static Signature abw(String str) {
        Signature signature = null;
        if (f.ov(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
        } else if (cFI()) {
            try {
                signature = abx(str);
            } catch (UnrecoverableEntryException e) {
                c.e("Soter.SoterCore", "soter: key invalid. Advice remove the key", new Object[0]);
            } catch (InvalidKeyException e2) {
                c.e("Soter.SoterCore", "soter: key invalid. Advice remove the key", new Object[0]);
            } catch (Throwable e3) {
                c.e("Soter.SoterCore", "soter: exception when getSignatureResult: " + e3.toString(), new Object[0]);
                c.a("Soter.SoterCore", e3, "soter: exception when getSignatureResult");
            } catch (Throwable e32) {
                c.a("Soter.SoterCore", e32, "soter: out of memory when getAuthInitAndSign!! maybe no attk inside");
                g.cFT();
            }
        } else {
            c.e("Soter.SoterCore", "soter: not support soterAndroidKeyStore", new Object[0]);
        }
        return signature;
    }

    private static Signature abx(String str) {
        if (f.ov(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        }
        Signature instance = Signature.getInstance("SHA256withRSA/PSS", "AndroidKeyStoreBCWorkaround");
        KeyStore instance2 = KeyStore.getInstance("SoterKeyStore");
        instance2.load(null);
        PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry) instance2.getEntry(str, null);
        if (privateKeyEntry != null) {
            instance.initSign(privateKeyEntry.getPrivateKey());
            return instance;
        }
        c.e("Soter.SoterCore", "soter: entry not exists", new Object[0]);
        return null;
    }

    public static i bN(byte[] bArr) {
        i iVar = null;
        int i = (bArr == null || bArr.length <= 0) ? 1 : 0;
        if (i != 0) {
            c.e("Soter.SoterCore", "origin is null or nil. abort", new Object[0]);
        } else if (bArr.length < 4) {
            c.e("Soter.SoterCore", "soter: length not correct 1", new Object[0]);
        } else {
            Object obj = new byte[4];
            System.arraycopy(bArr, 0, obj, 0, 4);
            i = bO(obj);
            c.d("Soter", "parsed raw length: " + i, new Object[0]);
            if (i > 1048576) {
                c.e("Soter.SoterCore", "soter: too large signature result!", new Object[0]);
            } else {
                Object obj2 = new byte[i];
                if (bArr.length <= i + 4) {
                    c.e("Soter.SoterCore", "soter: length not correct 2", new Object[0]);
                } else {
                    System.arraycopy(bArr, 4, obj2, 0, i);
                    iVar = i.abz(new String(obj2));
                    int length = bArr.length - (i + 4);
                    c.d("Soter.SoterCore", "soter: signature length: " + length, new Object[0]);
                    Object obj3 = new byte[length];
                    System.arraycopy(bArr, i + 4, obj3, 0, length);
                    if (iVar != null) {
                        iVar.signature = Base64.encodeToString(obj3, 2);
                    }
                }
            }
        }
        return iVar;
    }

    private static int bO(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            i2 += (bArr[i] & 255) << (i * 8);
            i++;
        }
        return i2;
    }

    private static h bP(byte[] bArr) {
        if (bArr == null) {
            c.e("Soter.SoterCore", "soter: raw data is null", new Object[0]);
            return null;
        }
        if (bArr.length < 4) {
            c.e("Soter.SoterCore", "soter: raw data length smaller than RAW_LENGTH_PREFIX", new Object[0]);
        }
        Object obj = new byte[4];
        System.arraycopy(bArr, 0, obj, 0, 4);
        int bO = bO(obj);
        c.d("Soter.SoterCore", "soter: parsed raw length: " + bO, new Object[0]);
        if (bO > 1048576) {
            c.e("Soter.SoterCore", "soter: too large json result!", new Object[0]);
            return null;
        }
        Object obj2 = new byte[bO];
        if (bArr.length <= bO + 4) {
            c.e("Soter.SoterCore", "length not correct 2", new Object[0]);
            return null;
        }
        System.arraycopy(bArr, 4, obj2, 0, bO);
        String str = new String(obj2);
        c.d("Soter.SoterCore", "soter: to convert json: " + str, new Object[0]);
        h hVar = new h(str, "");
        int length = bArr.length - (bO + 4);
        c.d("Soter.SoterCore", "soter: signature length: " + length, new Object[0]);
        Object obj3 = new byte[length];
        System.arraycopy(bArr, bO + 4, obj3, 0, length);
        hVar.signature = Base64.encodeToString(obj3, 2);
        return hVar;
    }

    public static boolean ic(Context context) {
        return com.tencent.d.a.a.a.if(context).isHardwareDetected();
    }

    public static boolean id(Context context) {
        return com.tencent.d.a.a.a.if(context).hasEnrolledFingerprints();
    }

    public static boolean ie(Context context) {
        return (com.tencent.d.a.a.c.in(context) || com.tencent.d.a.a.c.im(context)) ? false : true;
    }

    public static String cFO() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<deviceinfo>");
        stringBuilder.append("<MANUFACTURER name=\"");
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append("\">");
        stringBuilder.append("<MODEL name=\"");
        stringBuilder.append(Build.MODEL);
        stringBuilder.append("\">");
        stringBuilder.append("<VERSION_RELEASE name=\"");
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append("\">");
        stringBuilder.append("<VERSION_INCREMENTAL name=\"");
        stringBuilder.append(VERSION.INCREMENTAL);
        stringBuilder.append("\">");
        stringBuilder.append("<DISPLAY name=\"");
        stringBuilder.append(Build.DISPLAY);
        stringBuilder.append("\">");
        stringBuilder.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        c.d("Soter.SoterCore", "soter: getFingerprint  " + stringBuilder.toString(), new Object[0]);
        return stringBuilder.toString();
    }
}
