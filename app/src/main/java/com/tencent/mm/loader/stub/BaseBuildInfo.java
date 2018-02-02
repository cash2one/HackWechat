package com.tencent.mm.loader.stub;

import android.os.Build.VERSION;

public class BaseBuildInfo {
    public static String BUILD_TAG = "MicroMessenger_Android_GIT_RELEASE_GRADLE #5972";
    public static String CLIENT_VERSION = "0x26060235";
    public static String COMMAND = "null";
    public static String DEVICE_TYPE = ("android-" + VERSION.SDK_INT);
    public static boolean ENABLE_STETHO = false;
    public static String HOSTNAME = "45ea8765cf33";
    public static String OWNER = "amm_code_helper";
    private static String PATCH_ENABLED = "true";
    public static String PATCH_REV = null;
    public static int PATCH_TINKER_FLAG = 7;
    public static String REV = "cd14426a182a7ea0542613891cdff092cca0e10c";
    public static String SVNPATH = "origin/RB-2017-DEC@git";
    public static String TIME = "2018-02-01 15:59:43";

    public static String codeRevision() {
        return PATCH_REV == null ? REV : REV + "." + PATCH_REV;
    }

    public static String baseRevision() {
        return REV;
    }

    public static boolean patchEnabled() {
        return !"false".equalsIgnoreCase(PATCH_ENABLED);
    }
}
