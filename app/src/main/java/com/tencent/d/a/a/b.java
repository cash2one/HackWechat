package com.tencent.d.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build.VERSION;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.f;

@SuppressLint({"NewApi"})
final class b {
    static FingerprintManager ii(Context context) {
        return (FingerprintManager) context.getSystemService("fingerprint");
    }

    public static boolean ig(Context context) {
        if (b(context, "android.permission.USE_FINGERPRINT") != 0) {
            c.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: hasEnrolledFingerprints", new Object[0]);
            return false;
        }
        try {
            FingerprintManager ii = ii(context);
            if (ii != null) {
                return ii.hasEnrolledFingerprints();
            }
            c.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in hasEnrolledFingerprints! Should never happen", new Object[0]);
            return false;
        } catch (SecurityException e) {
            c.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in hasEnrolledFingerprints! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    static int b(Context context, String str) {
        if (context == null) {
            c.e("Soter.FingerprintManagerCompatApi23", "soter: check self permission: context is null", new Object[0]);
            return -1;
        } else if (f.ov(str)) {
            c.e("Soter.FingerprintManagerCompatApi23", "soter: requested permission is null or nil", new Object[0]);
            return -1;
        } else if (VERSION.SDK_INT >= 23) {
            return context.checkSelfPermission(str);
        } else {
            c.d("Soter.FingerprintManagerCompatApi23", "soter: below 23. directly return.", new Object[0]);
            return 0;
        }
    }

    public static boolean ih(Context context) {
        if (b(context, "android.permission.USE_FINGERPRINT") != 0) {
            c.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: isHardwareDetected", new Object[0]);
            return false;
        }
        try {
            FingerprintManager ii = ii(context);
            if (ii != null) {
                return ii.isHardwareDetected();
            }
            c.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
            return false;
        } catch (SecurityException e) {
            c.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }
}
