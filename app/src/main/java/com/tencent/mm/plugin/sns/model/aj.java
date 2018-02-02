package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.bkl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.an.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class aj {
    private static String bvR() {
        Context context = ac.getContext();
        if (context == null) {
            x.e("MicroMsg.SnsItemReportHelper", "ERROR Context is null scene");
            return null;
        }
        String str;
        int i = 0;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            int subtype = activeNetworkInfo.getSubtype();
            if (activeNetworkInfo.getType() == 1) {
                i = 1;
            } else if (subtype == 13 || subtype == 15 || subtype == 14) {
                i = 4;
            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                i = 3;
            } else if (subtype == 1 || subtype == 2) {
                i = 2;
            } else {
                i = 0;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", bh.i(e));
        }
        x.i("MicroMsg.SnsItemReportHelper", "get netType :%d", Integer.valueOf(i));
        String str2 = "";
        String str3 = "";
        String str4 = "";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            int i2 = 0;
            ArrayList arrayList = new ArrayList();
            stringBuffer.append(connectionInfo.getSSID());
            stringBuffer2.append(connectionInfo.getBSSID());
            String bssid = connectionInfo.getBSSID();
            arrayList.add(bssid);
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Collections.sort(scanResults, new 1());
                int i3 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || bh.ov(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(bssid)) {
                            int i4 = i3 - 1;
                            if (i3 <= 0) {
                                break;
                            }
                            stringBuffer.append("|");
                            stringBuffer.append(bh.ou(scanResult.SSID).replace("|", "").replace(" ", ""));
                            stringBuffer2.append("|");
                            stringBuffer2.append(bh.ou(scanResult.BSSID).replace("|", "").replace(" ", ""));
                            arrayList.add(scanResult.BSSID);
                            stringBuffer3.append("|");
                            stringBuffer3.append(scanResult.level);
                            i3 = i4;
                        } else {
                            i2 = scanResult.level;
                        }
                    }
                }
            }
            int i5 = i2;
            str2 = stringBuffer.toString();
            str3 = stringBuffer2.toString();
            str4 = i5 + stringBuffer3.toString();
        } catch (Throwable e2) {
            Throwable th = e2;
            str = str3;
            str3 = str2;
            x.e("MicroMsg.SnsItemReportHelper", "getWifiInfo : %s", bh.i(th));
            str2 = str3;
            str3 = str;
        }
        x.d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", str3, str2, str4);
        String str5 = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getNetworkOperatorName();
            } else {
                str = str5;
            }
            str5 = str;
        } catch (Throwable e22) {
            x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", bh.i(e22));
        }
        x.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str5);
        String str6 = "";
        String str7 = "";
        String str8 = "";
        String str9 = "";
        try {
            List eU = an.eU(context);
            int i6 = 0;
            while (i6 < eU.size()) {
                a aVar = (a) eU.get(i6);
                str6 = bh.az(aVar.xgP, "");
                str7 = bh.az(aVar.xgQ, "");
                if (str8.length() > 0 && !bh.ov(aVar.xgS)) {
                    str8 = str8 + "|";
                }
                if (!bh.ov(aVar.xgS)) {
                    str8 = str8 + aVar.xgS;
                }
                if (str9.length() > 0 && !bh.ov(aVar.xgR)) {
                    str9 = str9 + "|";
                }
                if (bh.ov(aVar.xgR)) {
                    str = str9;
                } else {
                    str = str9 + aVar.xgR;
                }
                i6++;
                str9 = str;
            }
            str = str9;
            str9 = str8;
            str8 = str7;
            str7 = str6;
        } catch (Throwable e222) {
            th = e222;
            str = str9;
            str9 = str8;
            str8 = str7;
            str7 = str6;
            x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", bh.i(th));
        }
        x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str7, str8, str9, str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i).append(",");
        stringBuilder.append(str2.replace(",", " ")).append(",");
        stringBuilder.append(str3.replace(",", " ")).append(",");
        stringBuilder.append(str4.replace(",", " ")).append(",");
        stringBuilder.append(str5.replace(",", " ")).append(",");
        stringBuilder.append(str7.replace(",", " ")).append(",");
        stringBuilder.append(str8.replace(",", " ")).append(",");
        stringBuilder.append(str9.replace(",", " ")).append(",");
        stringBuilder.append(str.replace(",", " "));
        return stringBuilder.toString();
    }

    public static void eH(long j) {
        if (j != 0) {
            m eR = ae.bvv().eR(j);
            if (eR != null && eR.field_type == 1) {
                aqs byi = eR.byi();
                if (byi != null) {
                    List list = byi.wyo;
                    List list2 = eR.bxV().wQo.vYd;
                    int min = Math.min(list.size(), list2.size());
                    String str = "";
                    if (min > 0) {
                        str = bvR();
                        if (bh.ov(str)) {
                            return;
                        }
                    }
                    String str2 = str;
                    for (int i = 0; i < min; i++) {
                        bkl com_tencent_mm_protocal_c_bkl = (bkl) list.get(i);
                        StringBuffer stringBuffer = new StringBuffer();
                        aqr com_tencent_mm_protocal_c_aqr = (aqr) list2.get(i);
                        stringBuffer.append("||index: " + i);
                        stringBuffer.append("||item poi lat " + com_tencent_mm_protocal_c_bkl.wNW + " " + com_tencent_mm_protocal_c_bkl.wNX);
                        stringBuffer.append("||item poi accuracy loctype " + com_tencent_mm_protocal_c_bkl.biF + " " + com_tencent_mm_protocal_c_bkl.rui);
                        stringBuffer.append("||item pic lat " + com_tencent_mm_protocal_c_bkl.wNU + " " + com_tencent_mm_protocal_c_bkl.wNV);
                        stringBuffer.append("||item exitime:" + com_tencent_mm_protocal_c_bkl.wNZ + " filetime: " + com_tencent_mm_protocal_c_bkl.wOa);
                        stringBuffer.append("||item source: " + com_tencent_mm_protocal_c_bkl.wNY);
                        stringBuffer.append("||url" + com_tencent_mm_protocal_c_aqr.nfX);
                        String str3 = com_tencent_mm_protocal_c_aqr.nfX;
                        if (str3.startsWith("http://mmsns.qpic.cn/mmsns/")) {
                            int lastIndexOf = str3.lastIndexOf("/");
                            if (lastIndexOf > 27 && lastIndexOf < str3.length()) {
                                str3 = str3.substring(27, lastIndexOf);
                            }
                        }
                        x.d("MicroMsg.SnsItemReportHelper", "report:%s", str3 + "," + i.eq(j) + "," + i + "," + bh.Wo() + "," + com_tencent_mm_protocal_c_bkl.wNY + "," + com_tencent_mm_protocal_c_bkl.wOa + "," + com_tencent_mm_protocal_c_bkl.wNZ + "," + com_tencent_mm_protocal_c_bkl.wNV + "," + com_tencent_mm_protocal_c_bkl.wNU + "," + com_tencent_mm_protocal_c_bkl.wNX + "," + com_tencent_mm_protocal_c_bkl.wNW + "," + str2 + "," + com_tencent_mm_protocal_c_bkl.biF + "," + com_tencent_mm_protocal_c_bkl.rui);
                        g.pQN.k(11985, str);
                    }
                }
            }
        }
    }
}
