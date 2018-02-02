package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.lib.d.b;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

public final class e extends b {
    public e(Context context) {
        super(context);
    }

    public final void M(Intent intent) {
        super.M(intent);
        com.tencent.mm.plugin.hp.b.b.L(intent);
    }

    public final void a(File file, List<File> list, Throwable th) {
        super.a(file, (List) list, th);
        com.tencent.mm.plugin.hp.b.b.e(th);
    }

    public final void a(File file, Throwable th) {
        super.a(file, th);
        com.tencent.mm.plugin.hp.b.b.d(th);
    }

    public final void a(File file, String str, String str2) {
        super.a(file, str, str2);
        com.tencent.mm.plugin.hp.b.b.aSw();
    }

    public final void d(File file, int i) {
        super.d(file, i);
        com.tencent.mm.plugin.hp.b.b.rl(i);
    }

    public final void a(File file, boolean z, long j) {
        super.a(file, z, j);
        com.tencent.mm.plugin.hp.b.b.j(j, z);
        x.cfl();
    }

    public final void a(File file, File file2, String str, int i) {
        super.a(file, file2, str, i);
        com.tencent.mm.plugin.hp.b.b.rm(i);
    }

    public final void a(File file, SharePatchInfo sharePatchInfo, String str) {
        super.a(file, sharePatchInfo, str);
        com.tencent.mm.plugin.hp.b.b.aSx();
    }
}
