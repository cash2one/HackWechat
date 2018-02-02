package com.tencent.smtt.sdk;

import android.text.TextUtils;
import com.tencent.smtt.export.external.TbsCoreSettings;
import java.util.HashMap;
import java.util.Map;

final class s {
    public boolean zXE;
    public boolean zXF;
    private Map<String, String> zXG;

    public s() {
        this.zXE = false;
        this.zXF = false;
        this.zXG = null;
        this.zXG = new HashMap();
    }

    public final synchronized void at(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.zXG.put(str, String.valueOf(j));
        }
    }

    public final synchronized void b(String str, byte b) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "";
            if (b == (byte) 1) {
                str2 = "_begin";
            } else if (b == (byte) 2) {
                str2 = "_end";
            }
            this.zXG.put(str + str2, String.valueOf(System.currentTimeMillis()));
        }
    }

    public final synchronized boolean bb(int i, String str) {
        boolean z = true;
        synchronized (this) {
            af cFg = af.cFg();
            if (!cFg.cFh()) {
                z = false;
            } else if ((this.zXF && this.zXE) || System.currentTimeMillis() % 10 == 0) {
                this.zXF = true;
                this.zXE = true;
                this.zXG.put("is_first_init_tbs", String.valueOf(this.zXF));
                this.zXG.put("is_first_init_x5", String.valueOf(this.zXE));
                this.zXG.put("x5_webview_id", Integer.toString(i));
                this.zXG.put("current_url", str);
                if (QbSdk.zWg != null && QbSdk.zWg.containsKey(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID)) {
                    this.zXG.put(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID, QbSdk.zWg.get(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID));
                }
                cFg.cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[]{Integer.TYPE, Map.class}, Integer.valueOf(i), this.zXG);
            }
        }
        return z;
    }
}
