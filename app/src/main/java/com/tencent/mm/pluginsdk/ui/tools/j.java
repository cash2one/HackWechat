package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import com.tencent.xweb.WebView;

public final class j {
    private static String vya = null;
    private static final String[] vyb = new String[]{"", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use"};

    public static void pY(int i) {
        eB(i, 0);
    }

    public static void eB(int i, int i2) {
        if (i <= 0 || i > 7) {
            x.e("MicroMsg.TBSReporter", "report invalid scene = %d", new Object[]{Integer.valueOf(i)});
            return;
        }
        x.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", new Object[]{Integer.valueOf(i), vyb[i], Integer.valueOf(i2)});
        Context context = ac.getContext();
        int tbsCoreVersion = WebView.getTbsCoreVersion(context);
        int tbsSDKVersion = WebView.getTbsSDKVersion(context);
        String eq = eq(context);
        g.pQN.a(11633, false, true, new Object[]{Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() / 1000), Integer.valueOf(tbsCoreVersion), Integer.valueOf(tbsSDKVersion), eq, Integer.valueOf(i2)});
    }

    private static String eq(Context context) {
        if (vya != null) {
            return vya;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(ac.getPackageName(), FileUtils.S_IWUSR);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                String string = applicationInfo.metaData.getString("com.tencent.mtt.TBS_CODE");
                if (!bh.ov(string)) {
                    vya = string;
                    return string;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", new Object[]{e.getMessage()});
        }
        return null;
    }
}
