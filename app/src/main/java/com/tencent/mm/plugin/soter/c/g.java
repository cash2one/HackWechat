package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.sdk.platformtools.x;

public enum g {
    ;
    
    private String appId;
    private int errCode;
    private int errType;

    private g(String str) {
        this.appId = null;
        this.errType = 0;
        this.errCode = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void n(String str, String str2, int i, int i2) {
        int i3;
        x.d("MicroMsg.SoterReportManager", "SoterReportManager functionName: %s, appId: %s, errType: %d, errCode: %d", str, str2, Integer.valueOf(i), Integer.valueOf(i2));
        switch (str.hashCode()) {
            case -1378849968:
                if (str.equals("requireSoterBiometricAuthentication")) {
                    i3 = 0;
                    break;
                }
            case 70807596:
                if (str.equals("getSupportSoter")) {
                    i3 = 1;
                    break;
                }
            default:
                i3 = -1;
                break;
        }
        switch (i3) {
            case 0:
                i3 = 0;
                break;
            case 1:
                i3 = 1;
                break;
            default:
                x.e("MicroMsg.SoterReportManager", "unknown soter jsapi function name");
                i3 = -1;
                break;
        }
        x.i("MicroMsg.SoterReportManager", "functionNameCode: %d", Integer.valueOf(i3));
        if (i3 != -1) {
            com.tencent.mm.plugin.report.service.g.pQN.h(13711, Integer.valueOf(i3), str2, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
