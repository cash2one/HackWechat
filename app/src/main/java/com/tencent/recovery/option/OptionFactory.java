package com.tencent.recovery.option;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.recovery.ConstantsRecovery.DefaultProcessOptions;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.util.Util;

public class OptionFactory {
    private static IOptionsCreator zRI;

    public static ProcessOptions dF(String str, int i) {
        ProcessOptions processOptions = null;
        if (zRI != null) {
            processOptions = zRI.createProcessOptions(str, i);
        }
        if (processOptions != null) {
            return processOptions;
        }
        RecoveryLog.i("Recovery.OptionFactory", "not found custom process options, use default %d", Integer.valueOf(i));
        if (i == 1) {
            return DefaultProcessOptions.zRc;
        }
        return DefaultProcessOptions.zRa;
    }

    public static CommonOptions gi(Context context) {
        CommonOptions commonOptions = null;
        if (zRI != null) {
            commonOptions = zRI.createCommonOptions(context);
        }
        if (commonOptions != null) {
            return commonOptions;
        }
        RecoveryLog.i("Recovery.OptionFactory", "not found custom custom options, use default", new Object[0]);
        Builder builder = new Builder();
        builder.zRz = "";
        builder.zRF = false;
        builder.ned = String.valueOf(Util.gk(context));
        try {
            builder.clientVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
        }
        builder.zRG = 600000;
        builder.zRH = 600000;
        return builder.cDm();
    }
}
