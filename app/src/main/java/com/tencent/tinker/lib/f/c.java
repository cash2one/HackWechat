package com.tencent.tinker.lib.f;

import android.content.Context;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.io.IOException;

public final class c {
    private static c Ajd;
    public boolean Aje = true;
    public File Ajf = null;
    public File Ajg = null;
    public int Ajh = 5;
    private Context context = null;

    private c(Context context) {
        this.context = context;
        this.Ajf = new File(SharePatchFileUtil.iz(context), "patch.retry");
        this.Ajg = new File(SharePatchFileUtil.iz(context), "temp.apk");
    }

    public static c iu(Context context) {
        if (Ajd == null) {
            Ajd = new c(context);
        }
        return Ajd;
    }

    public final boolean cGZ() {
        if (!this.Aje) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry disabled, just return", new Object[0]);
            return false;
        } else if (!a.ip(this.context).rSa) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
            return false;
        } else if (!this.Ajf.exists()) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry info not exist, just return", new Object[0]);
            return false;
        } else if (b.ir(this.context)) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad tinker service is running, just return", new Object[0]);
            return false;
        } else {
            String absolutePath = this.Ajg.getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[]{absolutePath});
                return false;
            }
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is exist, retry to patch", new Object[]{absolutePath});
            com.tencent.tinker.lib.e.c.bU(this.context, absolutePath);
            return true;
        }
    }

    public final boolean abD(String str) {
        if (!this.Aje) {
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry disabled, just return", new Object[0]);
            return true;
        } else if (!this.Ajf.exists()) {
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
            return true;
        } else if (str == null) {
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck md5 is null, just return", new Object[0]);
            return true;
        } else {
            a ab = a.ab(this.Ajf);
            if (!str.equals(ab.fqR) || Integer.parseInt(ab.Aji) < this.Ajh) {
                return true;
            }
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck, retry count %d must exceed than max retry count", new Object[]{Integer.valueOf(Integer.parseInt(ab.Aji))});
            SharePatchFileUtil.ag(this.Ajg);
            return false;
        }
    }

    public final void aa(File file) {
        if (!file.getAbsolutePath().equals(this.Ajg.getAbsolutePath())) {
            a.w("Tinker.UpgradePatchRetry", "try copy file: %s to %s", new Object[]{file.getAbsolutePath(), this.Ajg.getAbsolutePath()});
            try {
                SharePatchFileUtil.m(file, this.Ajg);
            } catch (IOException e) {
                a.e("Tinker.UpgradePatchRetry", "fail to copy file: %s to %s", new Object[]{file.getAbsolutePath(), this.Ajg.getAbsolutePath()});
            }
        }
    }
}
