package com.tencent.tinker.lib.e;

import android.content.Intent;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public final class b {
    public static boolean b(ApplicationLike applicationLike) {
        if (applicationLike != null && applicationLike.getApplication() != null) {
            return ShareTinkerInternals.IT(applicationLike.getTinkerFlags());
        }
        throw new TinkerRuntimeException("tinkerApplication is null");
    }

    public static boolean c(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent != null && ShareIntentUtil.ar(tinkerResultIntent) == 0) {
            return true;
        }
        return false;
    }

    public static String d(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent == null) {
            return null;
        }
        String j = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_old_version");
        String j2 = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_new_version");
        boolean iF = ShareTinkerInternals.iF(applicationLike.getApplication());
        if (j == null || j2 == null) {
            return null;
        }
        if (iF) {
            return j2;
        }
        return j;
    }

    public static void e(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        if (c(applicationLike)) {
            a.e("Tinker.TinkerApplicationHelper", "it is not safety to clean patch when tinker is loaded, you should kill all your process after clean!", new Object[0]);
        }
        SharePatchFileUtil.g(SharePatchFileUtil.iy(applicationLike.getApplication()));
    }
}
