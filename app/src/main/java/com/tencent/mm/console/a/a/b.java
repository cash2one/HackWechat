package com.tencent.mm.console.a.a;

import android.content.Context;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class b implements a {
    public final boolean a(Context context, String[] strArr) {
        if (strArr.length <= 1) {
            return false;
        }
        int i = bh.getInt(strArr[1], 0);
        x.i("MicroMsg.HCSettingCommand", "hardcoder copy[%d] [%s]", new Object[]{Integer.valueOf(i), y(context, HardCoderJNI.SETTING_SP_FILE)});
        String y = y(context, HardCoderJNI.SETTING_SP_FILE);
        String str = e.bnF + "hardcoder_setting.xml";
        String str2 = i > 0 ? y : str;
        if (i <= 0) {
            str = y;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        long x = com.tencent.mm.a.e.x(str2, str);
        x.i("MicroMsg.HCSettingCommand", "hcsetting copy[%d], ret[%d] src[%s] to dest[%s]", new Object[]{Integer.valueOf(i), Long.valueOf(x), str2, str});
        return true;
    }

    private static String y(Context context, String str) {
        File file;
        try {
            file = (File) context.getClass().getMethod("getSharedPrefsFile", new Class[]{String.class}).invoke(context, new Object[]{str});
        } catch (Throwable th) {
            x.w("MicroMsg.HCSettingCommand", "Failed call getSharedPrefsFile", new Object[]{th});
            file = new File(context.getFilesDir().getParent() + "/shared_prefs", str + ".xml");
        }
        if (file == null) {
            file = new File(context.getFilesDir().getParent() + "/shared_prefs", str + ".xml");
        }
        return file.getAbsolutePath();
    }
}
