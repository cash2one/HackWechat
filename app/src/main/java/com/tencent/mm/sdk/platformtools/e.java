package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.loader.stub.BaseBuildInfo;

public final class e {
    public static String BUILD_TAG = "MicroMessenger_Android_GIT_RELEASE_GRADLE #5972";
    public static String CLIENT_VERSION = "0x26060235";
    public static String COMMAND = "null";
    public static boolean DEBUG = false;
    public static String HOSTNAME = "45ea8765cf33";
    public static String OWNER = "amm_code_helper";
    public static String REV = "cd14426a182a7ea0542613891cdff092cca0e10c";
    public static String SVNPATH = "origin/RB-2017-DEC@git";
    public static String TIME = "2018-02-01 15:59:43";
    public static boolean xew = true;

    private static class a {
        public static String fn(String str, String str2) {
            if (str == null) {
                return null;
            }
            int indexOf = str.indexOf(str2);
            return indexOf >= 0 ? str.substring(indexOf) : str;
        }

        public static String fo(String str, String str2) {
            if (str == null) {
                return null;
            }
            if (str.equals(str2)) {
                return str;
            }
            return String.format("%s(%s)", new Object[]{str, str2});
        }
    }

    public static String asP() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[b.ver] %s\n", new Object[]{a.fo(CLIENT_VERSION, BaseBuildInfo.CLIENT_VERSION)}));
        stringBuilder.append(String.format("[tag  ] %s\n", new Object[]{a.fo(BUILD_TAG, BaseBuildInfo.BUILD_TAG)}));
        stringBuilder.append(String.format("[by   ] %s\n", new Object[]{a.fo(OWNER, BaseBuildInfo.OWNER)}));
        stringBuilder.append(String.format("[host ] %s\n", new Object[]{a.fo(HOSTNAME, BaseBuildInfo.HOSTNAME)}));
        stringBuilder.append(String.format("[time ] %s\n", new Object[]{a.fo(TIME, BaseBuildInfo.TIME)}));
        stringBuilder.append(String.format("[cmd  ] %s\n", new Object[]{a.fo(COMMAND, BaseBuildInfo.COMMAND)}));
        stringBuilder.append(String.format("[path ] %s\n", new Object[]{a.fo(a.fn(SVNPATH, "MicroMsg_proj"), a.fn(BaseBuildInfo.SVNPATH, "MicroMsg_proj"))}));
        stringBuilder.append(String.format("[rev  ] %s\n", new Object[]{a.fo(REV, BaseBuildInfo.REV)}));
        String str = "[p.rev] %s\n";
        Object[] objArr = new Object[1];
        objArr[0] = BaseBuildInfo.patchEnabled() ? BaseBuildInfo.codeRevision() : "disabled";
        stringBuilder.append(String.format(str, objArr));
        return stringBuilder.toString();
    }
}
