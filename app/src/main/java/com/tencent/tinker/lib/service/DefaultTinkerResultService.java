package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class DefaultTinkerResultService extends AbstractResultService {
    public void a(a aVar) {
        if (aVar == null) {
            a.e("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received null result!!!!", new Object[0]);
            return;
        }
        a.i("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received a result:%s ", new Object[]{aVar.toString()});
        b.iq(getApplicationContext());
        if (aVar.fsH) {
            Y(new File(aVar.Ait));
            if (b(aVar)) {
                Process.killProcess(Process.myPid());
            } else {
                a.i("Tinker.DefaultTinkerResultService", "I have already install the newly patch version!", new Object[0]);
            }
        }
    }

    public static void Y(File file) {
        if (SharePatchFileUtil.ae(file)) {
            a.w("Tinker.DefaultTinkerResultService", "deleteRawPatchFile rawFile path: %s", new Object[]{file.getPath()});
            String name = file.getName();
            if (name.startsWith("patch-") && name.endsWith(".apk")) {
                File parentFile = file.getParentFile();
                if (!parentFile.getName().startsWith("patch-")) {
                    SharePatchFileUtil.ag(file);
                    return;
                } else if (!parentFile.getParentFile().getName().equals("tinker")) {
                    SharePatchFileUtil.ag(file);
                    return;
                } else {
                    return;
                }
            }
            SharePatchFileUtil.ag(file);
        }
    }

    public final boolean b(a aVar) {
        com.tencent.tinker.lib.e.a ip = com.tencent.tinker.lib.e.a.ip(getApplicationContext());
        if (ip.AiH) {
            d dVar = ip.AiG;
            if (dVar != null) {
                String str = dVar.AiL;
                if (aVar.Aiu != null && aVar.Aiu.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
