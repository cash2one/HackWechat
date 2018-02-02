package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.R;
import com.google.android.gms.c.t;
import com.google.android.gms.c.z;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.j.a;
import com.google.android.gms.common.j.aw;
import com.tencent.wcdb.FileUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xwalk.core.R$styleable;

public final class e {
    private static final Object aEw = new Object();
    @Deprecated
    public static final int aJG = 7887000;
    public static boolean aJI = false;
    public static boolean aJJ = false;
    private static int aJK = -1;
    private static String aJL = null;
    private static Integer aJM = null;
    static final AtomicBoolean aJN = new AtomicBoolean();

    @Deprecated
    public static int C(Context context) {
        if (f.aNs) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            Integer num;
            synchronized (aEw) {
                if (aJL == null) {
                    aJL = context.getPackageName();
                    try {
                        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), FileUtils.S_IWUSR).metaData;
                        if (bundle != null) {
                            aJM = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                        } else {
                            aJM = null;
                        }
                    } catch (Throwable e) {
                        Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                    }
                } else if (!aJL.equals(context.getPackageName())) {
                    throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + aJL + "' and this call used package '" + context.getPackageName() + "'.");
                }
                num = aJM;
            }
            if (num == null) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (num.intValue() != aJG) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + aJG + " but found " + num + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            k.po();
            if (!t.dr(packageInfo.versionCode) && !t.P(context)) {
                try {
                    if (k.a(packageManager.getPackageInfo("com.android.vending", 64), aw.aQp) == null) {
                        return 9;
                    }
                    if (k.a(packageInfo, new a[]{k.a(packageManager.getPackageInfo("com.android.vending", 64), aw.aQp)}) == null) {
                        return 9;
                    }
                } catch (NameNotFoundException e2) {
                    if (!f(context, "com.android.vending")) {
                        return 9;
                    }
                    if (k.a(packageInfo, aw.aQp) == null) {
                        return 9;
                    }
                }
            } else if (k.a(packageInfo, aw.aQp) == null) {
                return 9;
            }
            if (t.dq(packageInfo.versionCode) < t.dq(aJG)) {
                new StringBuilder("Google Play services out of date.  Requires ").append(aJG).append(" but found ").append(packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (NameNotFoundException e3) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e4) {
            return 1;
        }
    }

    @Deprecated
    public static void D(Context context) {
        if (!aJN.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    @Deprecated
    public static void E(Context context) {
        int C = C(context);
        if (C != 0) {
            Intent de = de(C);
            if (de == null) {
                throw new c(C);
            }
            throw new d(C, "Google Play Services not available", de);
        }
    }

    public static Context F(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    private static String G(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(int i, Activity activity, Fragment fragment, OnCancelListener onCancelListener) {
        Dialog dialog;
        CharSequence charSequence = null;
        if (i == 0) {
            dialog = null;
        } else {
            Builder builder;
            String G;
            Resources resources;
            boolean z;
            Configuration configuration;
            CharSequence string;
            Intent de;
            OnClickListener iVar;
            Resources resources2;
            CharSequence string2;
            Resources resources3;
            if (t.P(activity) && i == 2) {
                i = 42;
            }
            if (z.ds(14)) {
                TypedValue typedValue = new TypedValue();
                activity.getTheme().resolveAttribute(16843529, typedValue, true);
                if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                    builder = new Builder(activity, 5);
                    if (builder == null) {
                        builder = new Builder(activity);
                    }
                    G = G(activity);
                    resources = activity.getResources();
                    switch (i) {
                        case 1:
                            if (resources != null) {
                                z = (resources.getConfiguration().screenLayout & 15) <= 3;
                                if (!(z.ds(11) && z)) {
                                    configuration = resources.getConfiguration();
                                    if (!z.ds(13)) {
                                        if ((configuration.screenLayout & 15) > 3 && configuration.smallestScreenWidthDp >= 600) {
                                            z = true;
                                            break;
                                        }
                                        z = false;
                                        break;
                                    }
                                    z = false;
                                    break;
                                }
                                z = true;
                                if (z) {
                                    break;
                                }
                                break;
                            }
                            z = false;
                            string = z ? resources.getString(R.string.common_google_play_services_install_text_phone, new Object[]{G}) : resources.getString(R.string.common_google_play_services_install_text_tablet, new Object[]{G});
                            break;
                        case 2:
                            string = resources.getString(R.string.common_google_play_services_update_text, new Object[]{G});
                            break;
                        case 3:
                            string = resources.getString(R.string.common_google_play_services_enable_text, new Object[]{G});
                            break;
                        case 5:
                            string = resources.getString(R.string.common_google_play_services_invalid_account_text);
                            break;
                        case 7:
                            string = resources.getString(R.string.common_google_play_services_network_error_text);
                            break;
                        case 9:
                            string = resources.getString(R.string.common_google_play_services_unsupported_text, new Object[]{G});
                            break;
                        case 16:
                            string = resources.getString(R.string.common_google_play_services_api_unavailable_text, new Object[]{G});
                            break;
                        case 17:
                            string = resources.getString(R.string.common_google_play_services_sign_in_failed_text);
                            break;
                        case 18:
                            string = resources.getString(R.string.common_google_play_services_updating_text, new Object[]{G});
                            break;
                        case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                            string = resources.getString(R.string.common_android_wear_update_text, new Object[]{G});
                            break;
                        default:
                            string = resources.getString(R.string.common_google_play_services_unknown_issue);
                            break;
                    }
                    builder.setMessage(string);
                    if (onCancelListener != null) {
                        builder.setOnCancelListener(onCancelListener);
                    }
                    de = de(i);
                    iVar = fragment != null ? new i(activity, de, 2) : new i(fragment, de, 2);
                    resources2 = activity.getResources();
                    switch (i) {
                        case 1:
                            string2 = resources2.getString(R.string.common_google_play_services_install_button);
                            break;
                        case 2:
                        case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                            string2 = resources2.getString(R.string.common_google_play_services_update_button);
                            break;
                        case 3:
                            string2 = resources2.getString(R.string.common_google_play_services_enable_button);
                            break;
                        default:
                            string2 = resources2.getString(17039370);
                            break;
                    }
                    if (string2 != null) {
                        builder.setPositiveButton(string2, iVar);
                    }
                    resources3 = activity.getResources();
                    switch (i) {
                        case 1:
                            charSequence = resources3.getString(R.string.common_google_play_services_install_title);
                            break;
                        case 2:
                            charSequence = resources3.getString(R.string.common_google_play_services_update_title);
                            break;
                        case 3:
                            charSequence = resources3.getString(R.string.common_google_play_services_enable_title);
                            break;
                        case 5:
                            charSequence = resources3.getString(R.string.common_google_play_services_invalid_account_title);
                            break;
                        case 7:
                            charSequence = resources3.getString(R.string.common_google_play_services_network_error_title);
                            break;
                        case 9:
                            charSequence = resources3.getString(R.string.common_google_play_services_unsupported_title);
                            break;
                        case 17:
                            charSequence = resources3.getString(R.string.common_google_play_services_sign_in_failed_title);
                            break;
                        case 18:
                            charSequence = resources3.getString(R.string.common_google_play_services_updating_title);
                            break;
                        case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                            charSequence = resources3.getString(R.string.common_android_wear_update_title);
                            break;
                    }
                    if (charSequence != null) {
                        builder.setTitle(charSequence);
                    }
                    dialog = builder.create();
                }
            }
            builder = null;
            if (builder == null) {
                builder = new Builder(activity);
            }
            G = G(activity);
            resources = activity.getResources();
            switch (i) {
                case 1:
                    if (resources != null) {
                        if ((resources.getConfiguration().screenLayout & 15) <= 3) {
                        }
                        configuration = resources.getConfiguration();
                        if (!z.ds(13)) {
                            z = false;
                            break;
                        }
                        if ((configuration.screenLayout & 15) > 3) {
                            break;
                        }
                        z = false;
                        break;
                        break;
                    }
                    z = false;
                    if (z) {
                        break;
                    }
                    break;
                case 2:
                    string = resources.getString(R.string.common_google_play_services_update_text, new Object[]{G});
                    break;
                case 3:
                    string = resources.getString(R.string.common_google_play_services_enable_text, new Object[]{G});
                    break;
                case 5:
                    string = resources.getString(R.string.common_google_play_services_invalid_account_text);
                    break;
                case 7:
                    string = resources.getString(R.string.common_google_play_services_network_error_text);
                    break;
                case 9:
                    string = resources.getString(R.string.common_google_play_services_unsupported_text, new Object[]{G});
                    break;
                case 16:
                    string = resources.getString(R.string.common_google_play_services_api_unavailable_text, new Object[]{G});
                    break;
                case 17:
                    string = resources.getString(R.string.common_google_play_services_sign_in_failed_text);
                    break;
                case 18:
                    string = resources.getString(R.string.common_google_play_services_updating_text, new Object[]{G});
                    break;
                case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                    string = resources.getString(R.string.common_android_wear_update_text, new Object[]{G});
                    break;
                default:
                    string = resources.getString(R.string.common_google_play_services_unknown_issue);
                    break;
            }
            builder.setMessage(string);
            if (onCancelListener != null) {
                builder.setOnCancelListener(onCancelListener);
            }
            de = de(i);
            if (fragment != null) {
            }
            resources2 = activity.getResources();
            switch (i) {
                case 1:
                    string2 = resources2.getString(R.string.common_google_play_services_install_button);
                    break;
                case 2:
                case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                    string2 = resources2.getString(R.string.common_google_play_services_update_button);
                    break;
                case 3:
                    string2 = resources2.getString(R.string.common_google_play_services_enable_button);
                    break;
                default:
                    string2 = resources2.getString(17039370);
                    break;
            }
            if (string2 != null) {
                builder.setPositiveButton(string2, iVar);
            }
            resources3 = activity.getResources();
            switch (i) {
                case 1:
                    charSequence = resources3.getString(R.string.common_google_play_services_install_title);
                    break;
                case 2:
                    charSequence = resources3.getString(R.string.common_google_play_services_update_title);
                    break;
                case 3:
                    charSequence = resources3.getString(R.string.common_google_play_services_enable_title);
                    break;
                case 5:
                    charSequence = resources3.getString(R.string.common_google_play_services_invalid_account_title);
                    break;
                case 7:
                    charSequence = resources3.getString(R.string.common_google_play_services_network_error_title);
                    break;
                case 9:
                    charSequence = resources3.getString(R.string.common_google_play_services_unsupported_title);
                    break;
                case 17:
                    charSequence = resources3.getString(R.string.common_google_play_services_sign_in_failed_title);
                    break;
                case 18:
                    charSequence = resources3.getString(R.string.common_google_play_services_updating_title);
                    break;
                case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                    charSequence = resources3.getString(R.string.common_android_wear_update_title);
                    break;
            }
            if (charSequence != null) {
                builder.setTitle(charSequence);
            }
            dialog = builder.create();
        }
        if (dialog == null) {
            return false;
        }
        if (activity instanceof FragmentActivity) {
            f.b(dialog, onCancelListener).a(((FragmentActivity) activity).getSupportFragmentManager(), "GooglePlayServicesErrorDialog");
        } else if (z.ds(11)) {
            a.a(dialog, onCancelListener).show(activity.getFragmentManager(), "GooglePlayServicesErrorDialog");
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        return true;
    }

    public static boolean a(Context context, int i, String str) {
        if (z.ds(19)) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(PackageManager packageManager) {
        synchronized (aEw) {
            if (aJK == -1) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
                    k.po();
                    if (k.a(packageInfo, new a[]{j.aQl[1]}) != null) {
                        aJK = 1;
                    } else {
                        aJK = 0;
                    }
                } catch (NameNotFoundException e) {
                    aJK = 0;
                }
            }
        }
        return aJK != 0;
    }

    public static boolean b(PackageManager packageManager) {
        if (!a(packageManager)) {
            if (aJI ? aJJ : "user".equals(Build.TYPE)) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static Intent de(int i) {
        switch (i) {
            case 1:
            case 2:
                return o.aL("com.google.android.gms");
            case 3:
                return o.aK("com.google.android.gms");
            case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                return o.oR();
            default:
                return null;
        }
    }

    @Deprecated
    public static boolean df(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private static boolean f(Context context, String str) {
        if (z.ds(21)) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            if (context.getPackageManager().getApplicationInfo(str, 8192).enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    @Deprecated
    public static boolean l(Context context, int i) {
        return i == 18 ? true : i == 1 ? f(context, "com.google.android.gms") : false;
    }

    public static boolean m(Context context, int i) {
        if (a(context, i, "com.google.android.gms")) {
            if (k.po().a(context.getPackageManager(), "com.google.android.gms")) {
                return true;
            }
        }
        return false;
    }
}
