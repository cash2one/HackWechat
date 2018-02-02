package com.tencent.mars.mm;

import com.tencent.mm.network.a.b;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.List;

public class MMLogic {
    public static final int MM_STAT_CGI_INFO = 1;
    public static final int MM_STAT_CGI_NETWORK_COST = 7;
    public static final int MM_STAT_DNS = 8;
    public static final int MM_STAT_LONGLINK_BUILD = 3;
    public static final int MM_STAT_LONGLINK_CONNECT = 4;
    public static final int MM_STAT_LONGLINK_DISCONNECT = 5;
    public static final int MM_STAT_LONGLINK_FUNC_CONNECT = 6;
    public static final int MM_STAT_NETWORK_UNREACHABLE = 2;
    public static final int MM_Stat_Local_GetHostByName = 11;
    public static final int MM_Stat_Network_Changed = 10;
    public static final int MM_Stat_Noop_Send = 9;
    private static long lastReportTime = 0;
    private static int totalMobileRecv = 0;
    private static int totalMobileSend = 0;
    private static int totalWifiRecv = 0;
    private static int totalWifiSend = 0;

    private static native void getHostIps(String str, GetDnsReturn getDnsReturn);

    public static native String[] getIPsString(boolean z);

    public static native String getIspId();

    public static native String getNetworkServerIp();

    private static native void getSnsIps(boolean z, GetDnsReturn getDnsReturn);

    private static native void getSnsIpsWithHostName(String str, boolean z, GetDnsReturn getDnsReturn);

    public static native void recoverLinkAddrs();

    public static native void reportCGIServerError(int i, int i2);

    public static native void reportFailIp(String str);

    public static native void saveAuthLongIPs(String str, String[] strArr);

    public static native void saveAuthPorts(int[] iArr, int[] iArr2);

    public static native void saveAuthShortIPs(String str, String[] strArr);

    public static native void setDebugIP(String str, String str2, String str3, String str4);

    public static native void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    public static native void setMmtlsCtrlInfo(boolean z);

    public static native void setNewDnsDebugHost(String str, String str2);

    public static native void uploadFile(String str, String str2, String str3);

    public static native void uploadLog(int[] iArr, boolean z, String str, String str2);

    private static String getCurLanguage() {
        try {
            return w.cfi();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getUserIDCLocale() {
        try {
            return bh.PT() ? "HK" : "CN";
        } catch (Exception e) {
            return null;
        }
    }

    public static int getSnsIpsForScene(List<String> list, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        GetDnsReturn getDnsReturn = new GetDnsReturn(null);
        getSnsIps(z, getDnsReturn);
        for (int i = 0; i < getDnsReturn.length; i++) {
            list.add(getDnsReturn.aryIps[i]);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.actionId = 11;
        reportInfo.beginTime = currentTimeMillis;
        reportInfo.endTime = currentTimeMillis2;
        reportInfo.clientIp = "mmsns.qpic.cn";
        reportInfo.ip = getDnsReturn.length > 0 ? getDnsReturn.aryIps[0] : "0.0.0.0";
        reportStat(reportInfo);
        return getDnsReturn.type;
    }

    public static int getSnsIpsForSceneWithHostName(List<String> list, String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        GetDnsReturn getDnsReturn = new GetDnsReturn(null);
        getSnsIpsWithHostName(str, z, getDnsReturn);
        for (int i = 0; i < getDnsReturn.length; i++) {
            list.add(getDnsReturn.aryIps[i]);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.actionId = 11;
        reportInfo.beginTime = currentTimeMillis;
        reportInfo.endTime = currentTimeMillis2;
        reportInfo.clientIp = str;
        reportInfo.ip = getDnsReturn.length > 0 ? getDnsReturn.aryIps[0] : "0.0.0.0";
        reportStat(reportInfo);
        return getDnsReturn.type;
    }

    public static int getHostByName(String str, List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        GetDnsReturn getDnsReturn = new GetDnsReturn(null);
        getHostIps(str, getDnsReturn);
        for (int i = 0; i < getDnsReturn.length; i++) {
            list.add(getDnsReturn.aryIps[i]);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.actionId = 11;
        reportInfo.beginTime = currentTimeMillis;
        reportInfo.endTime = currentTimeMillis2;
        reportInfo.clientIp = str;
        reportInfo.ip = getDnsReturn.length > 0 ? getDnsReturn.aryIps[0] : "0.0.0.0";
        reportStat(reportInfo);
        return getDnsReturn.type;
    }

    private static int getJavaActionId(long j) {
        switch ((int) j) {
            case 1:
                return 10955;
            case 2:
                return 10104;
            case 3:
                return 10103;
            case 4:
                return 10105;
            case 5:
                return 10102;
            case 6:
                return 10101;
            case 7:
                return TXLiveConstants.PUSH_WARNING_BEAUTYSURFACE_VIEW_INIT_FAIL;
            case 8:
                return 10428;
            case 9:
                return -1;
            case 10:
                return -2;
            case 11:
                return -3;
            default:
                return 0;
        }
    }

    public static void reportStat(ReportInfo reportInfo) {
        try {
            aa.VO().post(new 1(reportInfo));
        } catch (Exception e) {
        }
    }

    private static void reportFlow(int i, int i2, int i3, int i4) {
        totalWifiRecv += i;
        totalWifiSend += i2;
        totalMobileRecv += i3;
        totalMobileSend += i4;
        int i5 = ((totalMobileRecv + totalMobileSend) + totalWifiRecv) + totalWifiSend;
        b bVar = aa.VM().iaW;
        x.i("C2Java", "reportNetFlow time[%d,%d] sum:%d wr[%d,%d] ws[%d,%d] mr[%d,%d] ms[%d,%d] fgbg:%b Moniter:%s", new Object[]{Long.valueOf(lastReportTime), Long.valueOf(bh.by(lastReportTime)), Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(totalWifiRecv), Integer.valueOf(i2), Integer.valueOf(totalWifiSend), Integer.valueOf(i3), Integer.valueOf(totalMobileRecv), Integer.valueOf(i4), Integer.valueOf(totalMobileSend), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground), bVar});
        if (bVar != null) {
            if (i5 >= 102400 || bh.by(lastReportTime) >= 30) {
                lastReportTime = bh.Wo();
                int i6 = totalWifiRecv;
                totalWifiRecv = 0;
                int i7 = totalWifiSend;
                totalWifiSend = 0;
                int i8 = totalMobileRecv;
                totalMobileRecv = 0;
                int i9 = totalMobileSend;
                totalMobileSend = 0;
                try {
                    aa.VO().post(new 2(bVar, i6, i7, i8, i9));
                } catch (Throwable th) {
                    x.e("C2Java", "reportFlowData :%s", new Object[]{bh.i(th)});
                }
            }
        }
    }

    private static void onOOBNotify(String str) {
        x.i("C2Java", "onOOBNotify:" + str);
        if (aa.VS() == null) {
            Assert.assertTrue(false);
            return;
        }
        try {
            aa.VO().post(new 3(str));
        } catch (Throwable e) {
            x.e("C2Java", "onOOBNotify :%s", new Object[]{bh.i(e)});
        }
    }
}
