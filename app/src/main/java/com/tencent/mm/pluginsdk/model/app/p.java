package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI$Token;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.plugin.y.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashMap;
import java.util.Map;

public final class p {
    public static String f(Context context, String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            x.e("MicroMsg.AppUtil", "buildSourceUrl fail, invalid arguments");
            return null;
        }
        String d = w.d(context.getSharedPreferences(ac.cfs(), 0));
        if (d == null || d.length() == 0) {
            d = "zh_CN";
        } else if (d.equals("en")) {
            d = "en_US";
        }
        return context.getString(h.lpf, new Object[]{str, Integer.valueOf(d.vAz), d, d.DEVICE_TYPE, str2});
    }

    public static String w(Context context, String str, String str2) {
        if (str == null || str.length() == 0 || str2.length() == 0) {
            x.e("MicroMsg.AppUtil", "buildUnistallUrl fail, invalid arguments");
            return null;
        }
        String d = w.d(context.getSharedPreferences(ac.cfs(), 0));
        if (d == null || d.length() == 0) {
            d = "zh_CN";
        } else if (d.equals("en")) {
            d = "en_US";
        }
        return context.getString(h.lpg, new Object[]{str, Integer.valueOf(d.vAz), d, d.DEVICE_TYPE, str2, Integer.valueOf(0)});
    }

    public static String A(String str, String str2) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppUtil", "buildRedirectUrl fail, invalid arguments");
            return null;
        }
        String str3;
        int indexOf = str.indexOf("#");
        String str4 = "";
        if (indexOf >= 0) {
            str4 = str.substring(indexOf);
            str = str.substring(0, indexOf);
            str3 = str4;
        } else {
            str3 = str4;
        }
        int indexOf2 = str.indexOf("?");
        str4 = "";
        if (indexOf2 >= 0) {
            str4 = str.substring(indexOf2 + 1);
            str = str.substring(0, indexOf2);
        }
        x.v("MicroMsg.AppUtil", "buildRedirectUrl, sharpStr = %s, paramStr = %s, srcUrl = %s", str3, str4, str);
        Map linkedHashMap = new LinkedHashMap();
        if (!bh.ov(str4)) {
            String[] split = str4.split("&");
            if (split != null && split.length > 0) {
                for (String str5 : split) {
                    String str52;
                    if (!bh.ov(str52)) {
                        Object substring;
                        Object substring2;
                        int indexOf3 = str52.indexOf("=");
                        x.v("MicroMsg.AppUtil", "buildRedirectUrl, equalIdx = %d", Integer.valueOf(indexOf3));
                        if (indexOf3 >= 0) {
                            substring = str52.substring(0, indexOf3 + 1);
                            substring2 = str52.substring(indexOf3 + 1);
                        } else {
                            String str6 = str52;
                            str52 = "";
                            str4 = str6;
                        }
                        linkedHashMap.put(substring, substring2);
                    }
                }
            }
        }
        str4 = "from=";
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put(str4, str2);
        x.v("MicroMsg.AppUtil", "buildRedirectUrl, pMap size = %d", Integer.valueOf(linkedHashMap.size()));
        StringBuilder stringBuilder = new StringBuilder();
        for (String str42 : linkedHashMap.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(str42);
            stringBuilder.append((String) linkedHashMap.get(str42));
        }
        str42 = str + "?" + stringBuilder.toString();
        if (!bh.ov(str3)) {
            str42 = str42 + str3;
        }
        x.v("MicroMsg.AppUtil", "buildRedirectUrl, ret url = %s", str42);
        return str42;
    }

    public static boolean m(Context context, String str) {
        return getPackageInfo(context, str) != null;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppUtil", "getPackageInfo, packageName is null");
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (NameNotFoundException e) {
                x.w("MicroMsg.AppUtil", "app not installed, packageName = " + str);
            }
        }
        return packageInfo;
    }

    public static String aW(Context context, String str) {
        Signature[] aX = aX(context, str);
        if (aX != null && aX.length != 0) {
            return RK(g.s(aX[0].toByteArray()));
        }
        x.e("MicroMsg.AppUtil", "signs is null");
        return null;
    }

    public static String RJ(String str) {
        if (str != null && str.length() != 0) {
            return RK(str);
        }
        x.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
        return null;
    }

    public static boolean b(Context context, f fVar, String str) {
        a bis = a.a.bis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppUtil", "isAppValid, packageName is null");
            bis.c(fVar);
            return false;
        } else if (fVar == null) {
            x.i("MicroMsg.AppUtil", "app does not exist");
            return true;
        } else if (fVar.field_packageName == null || fVar.field_packageName.length() == 0) {
            x.e("MicroMsg.AppUtil", "isAppValid fail, local packageName is null");
            bis.c(fVar);
            return false;
        } else if (fVar.field_signature == null || fVar.field_signature.length() == 0) {
            x.e("MicroMsg.AppUtil", "isAppValid fail, local signature is null");
            bis.c(fVar);
            return false;
        } else {
            Signature[] aX = aX(context, str);
            if (aX == null || aX.length == 0) {
                x.e("MicroMsg.AppUtil", "isAppValid, apk signatures is null");
                bis.c(fVar);
                return false;
            } else if (fVar.field_packageName.equals(str)) {
                x.i("MicroMsg.AppUtil", "server signatures:%s", fVar.field_signature);
                int length = aX.length;
                int i = 0;
                while (i < length) {
                    x.i("MicroMsg.AppUtil", "local signatures:%s", RK(g.s(aX[i].toByteArray())));
                    if (fVar.field_signature == null || !fVar.field_signature.equals(r6)) {
                        i++;
                    } else {
                        bis.d(fVar);
                        return true;
                    }
                }
                x.w("MicroMsg.AppUtil", "isAppValid, signature is diff");
                bis.c(fVar);
                return false;
            } else {
                x.e("MicroMsg.AppUtil", "isAppValid, packageName is diff, src:%s,local:%s", fVar.field_packageName, str);
                bis.c(fVar);
                return false;
            }
        }
    }

    public static void ae(Bundle bundle) {
        bundle.putString(ConstantsAPI$Token.WX_TOKEN_KEY, ConstantsAPI$Token.WX_TOKEN_VALUE_MSG);
    }

    public static void af(Bundle bundle) {
        bundle.putString(ConstantsAPI$Token.WX_TOKEN_PLATFORMID_KEY, ConstantsAPI$Token.WX_TOKEN_PLATFORMID_VALUE);
    }

    public static void g(Bundle bundle, String str) {
        bundle.putString(ConstantsAPI$Token.WX_TOKEN_PLATFORMID_KEY, ConstantsAPI$Token.WX_TOKEN_PLATFORMID_VALUE);
        if (!bh.ov(str)) {
            bundle.putString(ConstantsAPI$Token.WX_LAUNCH_PARAM_KEY, str);
        }
    }

    public static Signature[] aX(Context context, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppUtil", "getSignature, packageName is null");
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            x.e("MicroMsg.AppUtil", "info is null, packageName = " + str);
            return null;
        } catch (NameNotFoundException e) {
            x.e("MicroMsg.AppUtil", "NameNotFoundException");
            return null;
        }
    }

    public static String RK(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.toLowerCase());
        stringBuffer.append("mMHc ItnStR");
        return g.s(stringBuffer.toString().getBytes());
    }

    public static boolean b(Context context, f fVar) {
        x.i("MicroMsg.AppUtil", "check the signature of the Application.");
        if (context == null) {
            x.e("MicroMsg.AppUtil", "context is null.");
            return true;
        } else if (fVar == null) {
            x.e("MicroMsg.AppUtil", "appInfo is null.");
            return true;
        } else if (bh.ov(fVar.field_packageName)) {
            x.e("MicroMsg.AppUtil", "packageName is null.");
            return true;
        } else if (bh.ov(fVar.field_signature)) {
            x.e("MicroMsg.AppUtil", "app.field_signature is null. app.field_packageName is %s", fVar.field_packageName);
            return true;
        } else {
            Signature[] aX = aX(context, fVar.field_packageName);
            if (aX == null || aX.length == 0) {
                x.e("MicroMsg.AppUtil", "apk signatures is null");
                return false;
            }
            for (Signature toByteArray : aX) {
                if (fVar.field_signature.equals(RK(g.s(toByteArray.toByteArray())))) {
                    x.i("MicroMsg.AppUtil", "app_name : %s ,signature : %s", fVar.field_appName, fVar.field_signature);
                    return true;
                }
            }
            x.w("MicroMsg.AppUtil", "signature is diff.(app_name:%s)", fVar.field_appName);
            return false;
        }
    }

    public static void RL(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.AppUtil", "appid is null");
            return;
        }
        SharedPreferences cft = ac.cft();
        if (cft != null) {
            String string = cft.getString("key_app_ids_registion_while_not_login", "");
            if (string.contains(str)) {
                x.i("MicroMsg.AppUtil", "this app has been saved : %s in %s", str, string);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(string);
            cft.edit().putString("key_app_ids_registion_while_not_login", stringBuilder.toString()).commit();
        }
    }

    public static void bYM() {
        ap.vfE = null;
        ap.vfF = -1;
    }
}
