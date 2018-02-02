package com.tencent.tinker.lib.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.List;

public class b implements d {
    private static boolean Ais = false;
    protected final Context context;

    public b(Context context) {
        this.context = context;
    }

    public void M(Intent intent) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchServiceStart: patch service start", new Object[0]);
        Ais = false;
        c iu = c.iu(this.context);
        if (!iu.Aje) {
            a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry disabled, just return", new Object[0]);
        } else if (intent == null) {
            a.e("Tinker.UpgradePatchRetry", "onPatchServiceStart intent is null, just return", new Object[0]);
        } else {
            String ao = TinkerPatchService.ao(intent);
            if (ao == null) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch path is null, just return", new Object[0]);
                return;
            }
            File file = new File(ao);
            String ah = SharePatchFileUtil.ah(file);
            if (ah == null) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch md5 is null, just return", new Object[0]);
                return;
            }
            c$a ab;
            if (iu.Ajf.exists()) {
                ab = c$a.ab(iu.Ajf);
                if (ab.fqR == null || ab.Aji == null || !ah.equals(ab.fqR)) {
                    iu.aa(file);
                    ab.fqR = ah;
                    ab.Aji = "1";
                } else {
                    int parseInt = Integer.parseInt(ab.Aji);
                    if (parseInt >= iu.Ajh) {
                        SharePatchFileUtil.ag(iu.Ajg);
                        a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
                        return;
                    }
                    ab.Aji = String.valueOf(parseInt + 1);
                }
            } else {
                iu.aa(file);
                ab = new c$a(ah, "1");
            }
            c$a.a(iu.Ajf, ab);
        }
    }

    public void d(File file, int i) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchPackageCheckFail: package check failed. path: %s, code: %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(i)});
        if (i == -3 || i == -4 || i == -8) {
            com.tencent.tinker.lib.e.a.ip(this.context).Z(file);
        }
    }

    public void a(File file, SharePatchInfo sharePatchInfo, String str) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchVersionCheckFail: patch version exist. path: %s, version: %s", new Object[]{file.getAbsolutePath(), str});
    }

    public void a(File file, File file2, String str, int i) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchTypeExtractFail: file extract fail type: %s, path: %s, extractTo: %s, filename: %s", new Object[]{ShareTinkerInternals.IV(i), file.getPath(), file2.getPath(), str});
        com.tencent.tinker.lib.e.a.ip(this.context).Z(file);
    }

    public void a(File file, List<File> list, Throwable th) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchDexOptFail: dex opt fail path: %s, dex size: %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(list.size())});
        a.printErrStackTrace("Tinker.DefaultPatchReporter", th, "onPatchDexOptFail:", new Object[0]);
        if (th.getMessage().contains("checkDexOptExist failed") || th.getMessage().contains("checkDexOptFormat failed")) {
            Ais = true;
            for (File ag : list) {
                SharePatchFileUtil.ag(ag);
            }
            return;
        }
        com.tencent.tinker.lib.e.a.ip(this.context).Z(file);
    }

    public void a(File file, boolean z, long j) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", new Object[]{file.getAbsolutePath(), Boolean.valueOf(z), Long.valueOf(j)});
        if (!Ais) {
            c iu = c.iu(this.context);
            if (!iu.Aje) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
            } else if (iu.Ajg.exists()) {
                SharePatchFileUtil.ag(iu.Ajg);
            }
        }
    }

    public void a(File file, String str, String str2) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchInfoCorrupted: patch info is corrupted. old: %s, new: %s", new Object[]{str, str2});
        com.tencent.tinker.lib.e.a.ip(this.context).aSE();
    }

    public void a(File file, Throwable th) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchException: patch exception path: %s, throwable: %s", new Object[]{file.getAbsolutePath(), th.getMessage()});
        a.e("Tinker.DefaultPatchReporter", "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        a.printErrStackTrace("Tinker.DefaultPatchReporter", th, "tinker patch exception", new Object[0]);
        com.tencent.tinker.lib.e.a.ip(this.context).tinkerFlags = 0;
        com.tencent.tinker.lib.e.a.ip(this.context).Z(file);
    }
}
