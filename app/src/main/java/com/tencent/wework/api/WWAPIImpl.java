package com.tencent.wework.api;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.wcdb.FileUtils;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.utils.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public final class WWAPIImpl implements IWWAPI {
    private static final String[] Apt = new String[]{"com.tencent.wework", "com.tencent.weworklocal"};
    private String Apu;
    private BroadcastReceiver Apv = new 1(this);
    private Context context;
    private Map<String, Object> qSl = new HashMap();

    public WWAPIImpl(Context context) {
        this.context = context;
    }

    public final boolean cIg() {
        int aci;
        for (String str : Apt) {
            aci = aci(str);
            if (aci != 0) {
                Log.i("WWAPIImpl", "getWWAppSupportAPI, pkg: " + str + ", versioncode: " + aci);
                break;
            }
        }
        aci = 0;
        return aci >= 100;
    }

    public final String cIh() {
        String[] strArr = Apt;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                PackageManager packageManager = this.context.getPackageManager();
                str = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
                if (TextUtils.isEmpty(str)) {
                    return "企业微信";
                }
                return str;
            } catch (Throwable th) {
                Log.w("WWAPIImpl", "getWWAppName failed", th);
                i++;
            }
        }
        return "企业微信";
    }

    public final boolean a(BaseMessage baseMessage) {
        String[] strArr = Apt;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            String ach = ach(str);
            Log.d("WWAPIImpl", "isValidSignature, pkg: " + str + ", signature: " + ach);
            if ("011A40266C8C75D181DDD8E4DDC50075".equals(ach)) {
                Intent intent = new Intent("com.tencent.wework.apihost");
                intent.setClassName(str, "com.tencent.wework.apihost.WWAPIActivity");
                intent.addFlags(411041792);
                try {
                    baseMessage.setContext(this.context);
                    intent.putExtras(BaseMessage.b(baseMessage));
                    intent.putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.Apv.getClass()), 134217728));
                    this.context.startActivity(intent);
                    Log.i("WWAPIImpl", "sendMessage, start WWAPIActivity, pkg: " + str);
                    return true;
                } catch (Throwable th) {
                    Log.w("WWAPIImpl", "sendMessage failed, pkg: " + str, th);
                }
            } else {
                i++;
            }
        }
        return false;
    }

    private String ach(String str) {
        try {
            return bT(this.context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
        } catch (Throwable th) {
            Log.w("WWAPIImpl", "getSignature failed, pkg: " + str, th);
            return "";
        }
    }

    private int aci(String str) {
        int i = 0;
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(str, FileUtils.S_IWUSR);
            if (packageInfo != null) {
                i = packageInfo.versionCode;
            }
        } catch (Throwable th) {
            Log.w("WWAPIImpl", "getVersioncode failed, pkg: " + str, th);
        }
        return i;
    }

    private static String bT(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                stringBuilder.append(Integer.toHexString((b & 240) >>> 4));
                stringBuilder.append(Integer.toHexString(b & 15));
            }
            return stringBuilder.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
