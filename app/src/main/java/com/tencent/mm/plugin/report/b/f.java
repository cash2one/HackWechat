package com.tencent.mm.plugin.report.b;

import com.tencent.mm.a.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.aq;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class f {
    public static boolean Ix(String str) {
        File file = new File("/sdcard/cov.txt");
        if (file.exists()) {
            String H = aq.hfP.H("login_user_name", "never_login_crash");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("#username=" + H);
            stringBuffer.append("\n");
            stringBuffer.append("#rev=" + e.REV);
            stringBuffer.append("\n");
            stringBuffer.append("#path=" + e.SVNPATH);
            stringBuffer.append("\n");
            if (str.length() > 0) {
                stringBuffer.append("#startrev=" + str);
                stringBuffer.append("\n");
            }
            com.tencent.mm.a.e.d(file.getAbsolutePath(), stringBuffer.toString().getBytes());
            String a = p.a(file, false, "/sdcard/cov/cov_" + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".zip");
            if (a == null) {
                x.e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
                return false;
            }
            file.delete();
            x.i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :" + H);
            q.a(a, H, false, false, 10, 20004);
            return true;
        }
        x.w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
        return false;
    }
}
