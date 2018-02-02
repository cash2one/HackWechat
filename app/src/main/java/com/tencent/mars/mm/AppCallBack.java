package com.tencent.mars.mm;

import android.content.Context;
import com.tencent.mars.app.AppLogic$AccountInfo;
import com.tencent.mars.app.AppLogic$ICallBack;
import com.tencent.mars.app.AppLogic.DeviceInfo;
import com.tencent.mm.network.aa;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class AppCallBack implements AppLogic$ICallBack {
    private static final String TAG = "AppCallBack";
    private Context context = null;
    DeviceInfo info = new DeviceInfo(d.vAx, d.DEVICE_TYPE);

    private static String exception2String(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public AppCallBack(Context context) {
        this.context = context;
    }

    public String getAppFilePath() {
        String str = null;
        if (this.context == null) {
            Assert.assertTrue(false);
        } else {
            try {
                File filesDir = this.context.getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.createNewFile();
                }
                str = filesDir.toString();
            } catch (Exception e) {
                x.e(TAG, exception2String(e));
                Assert.assertTrue(e.getClass().getSimpleName() + ":" + e.getStackTrace()[0] + ", " + e.getStackTrace()[1], false);
            }
        }
        return str;
    }

    public AppLogic$AccountInfo getAccountInfo() {
        AppLogic$AccountInfo appLogic$AccountInfo = new AppLogic$AccountInfo();
        if (!(aa.VQ() == null || aa.VQ().hZK == null)) {
            try {
                appLogic$AccountInfo.uin = (long) aa.VQ().hZK.Cg();
                appLogic$AccountInfo.userName = aa.VQ().hZK.KS();
                if (bh.ov(appLogic$AccountInfo.userName)) {
                    appLogic$AccountInfo.userName = aa.VQ().hZK.getUsername();
                }
            } catch (Exception e) {
            }
        }
        return appLogic$AccountInfo;
    }

    public int getClientVersion() {
        return d.vAz;
    }

    public DeviceInfo getDeviceType() {
        return this.info;
    }

    public String getCurLanguage() {
        return w.cfi();
    }
}
