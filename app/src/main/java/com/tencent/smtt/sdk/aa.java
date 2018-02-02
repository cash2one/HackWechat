package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import java.util.Map;

final class aa {
    private Context zYX = null;
    private Context zYY = null;
    private String zYZ = null;
    private String[] zZa = null;
    DexLoader zZb = null;
    private String zZc = "TbsDexOpt";
    private String zZd = null;

    public aa(Context context, Context context2, String str, String str2, String[] strArr, String str3, s sVar) {
        TbsLog.i("TbsWizard", "construction start...");
        if (context == null || ((context2 == null && x.cEQ() == null) || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0)) {
            throw new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
        }
        Object invokeStaticMethod;
        int i;
        this.zYX = context.getApplicationContext();
        this.zYY = context2;
        this.zYZ = str;
        this.zZa = strArr;
        this.zZc = str2;
        if (sVar != null) {
            sVar.b("load_tbs_dex", (byte) 1);
        }
        this.zZb = new DexLoader(str3, this.zYX, this.zZa, str2, QbSdk.zWg);
        if (sVar != null) {
            sVar.b("load_tbs_dex", (byte) 2);
        }
        libwebp.loadWepLibraryIfNeed(context2, this.zYZ);
        if ("com.nd.android.pandahome2".equals(this.zYX.getApplicationInfo().packageName)) {
            this.zZb.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[]{Context.class}, new Object[]{this.zYX});
        }
        if (QbSdk.zWg != null) {
            this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, new Object[]{QbSdk.zWg});
        }
        if (sVar != null) {
            sVar.b("init_tbs", (byte) 1);
        }
        this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "putInfo", new Class[]{Context.class, String.class, String.class, String.class, String.class}, new Object[]{context, c.bjM, c.Aai, c.Aaj, c.bpq});
        if (this.zYY != null || x.cEQ() == null) {
            invokeStaticMethod = this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, new Object[]{context, this.zYY, this.zZb, this.zYZ, this.zZc, "3.6.0.1140", Integer.valueOf(43603), QbSdk.cDR()});
        } else {
            invokeStaticMethod = this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class, String.class}, new Object[]{context, this.zYY, this.zZb, this.zYZ, this.zZc, "3.6.0.1140", Integer.valueOf(43603), QbSdk.cDR(), x.cEQ()});
        }
        if (invokeStaticMethod == null) {
            this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, new Object[]{"3.6.0.1140"});
            this.zZb.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(43603));
            invokeStaticMethod = this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, new Object[]{context, this.zYY, this.zZb, this.zYZ, this.zZc});
        }
        if (invokeStaticMethod == null) {
            i = -3;
        } else if (invokeStaticMethod instanceof Integer) {
            i = ((Integer) invokeStaticMethod).intValue();
        } else if (invokeStaticMethod instanceof Throwable) {
            m.cEf().a(this.zYX, 328, (Throwable) invokeStaticMethod);
            i = -5;
        } else {
            i = -4;
        }
        if (i < 0) {
            Object invokeStaticMethod2 = this.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod2 instanceof Throwable) {
                Throwable th = (Throwable) invokeStaticMethod2;
                this.zZd = "#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + th;
            }
            if (invokeStaticMethod2 instanceof String) {
                this.zZd = (String) invokeStaticMethod2;
            }
        } else {
            this.zZd = null;
        }
        if (sVar != null) {
            sVar.b("init_tbs", (byte) 2);
        }
        if (i < 0) {
            throw new Exception("TbsWizard init error: " + i + "; msg: " + this.zZd);
        }
        TbsLog.i("TbsWizard", "construction end...");
    }
}
