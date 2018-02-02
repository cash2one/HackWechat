package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.aqi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static final String[] mDD = new String[]{"ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds"};
    private static final String[] mDE = new String[]{"errcode", "errmsg", "maxApCount", "intervalSeconds"};
    private int mDF;
    private int mDG;
    private long mDH;

    private static class a {
        private static c mDM = new c();
    }

    static /* synthetic */ void a(ew ewVar, MatrixCursor matrixCursor) {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setResult. errorcode=%d, errmsg=%s", new Object[]{Integer.valueOf(1), null});
        ewVar.ftL.ftN = matrixCursor;
        ewVar.ftL.ftr = 1;
        if (ewVar.fqI != null) {
            ewVar.fqI.run();
        }
    }

    private c() {
        this.mDF = 200;
        this.mDG = 180;
        this.mDH = 0;
    }

    public static c aLr() {
        return a.mDM;
    }

    public final synchronized void a(ew ewVar) {
        int i = 0;
        synchronized (this) {
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + aLs() + "; reqIntervalSeconds=" + aLt());
            String[] strArr = ewVar.ftK.ftM;
            if (strArr == null || strArr.length == 0) {
                a(ewVar, TXLiveConstants.PUSH_WARNING_NET_BUSY, "Args is empty.");
            } else {
                int i2;
                StringBuilder stringBuilder = new StringBuilder();
                for (i2 = 0; i2 < strArr.length; i2++) {
                    stringBuilder.append("args[" + i2 + "] = " + strArr[i2]);
                }
                x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + stringBuilder.toString());
                try {
                    if (Integer.valueOf(strArr[0]).intValue() != 1) {
                        a(ewVar, TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL, "Wechant installed currently only supports version 1.");
                    } else if (strArr.length != 3) {
                        a(ewVar, TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_FAIL, "Args.length should be 3, but now it is " + strArr.length + ".");
                    } else {
                        try {
                            i2 = Integer.valueOf(strArr[2]).intValue();
                            if (i2 != 1 && i2 != 2) {
                                a(ewVar, TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_BITRATE_OVERFLOW, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
                            } else if (aLu() != 0 && System.currentTimeMillis() - aLu() < ((long) aLt()) && i2 == 2) {
                                a(ewVar, 1109, "Request frequence is out of limit. The time btween two background request should be more than  " + this.mDG + " seconds.");
                            } else if (m.AA(strArr[1])) {
                                a(ewVar, TXLiveConstants.PUSH_WARNING_BEAUTYSURFACE_VIEW_INIT_FAIL, "Args[1] should be an ap list json string, but now it is empty.");
                            } else {
                                LinkedList linkedList = new LinkedList();
                                try {
                                    JSONArray jSONArray = new JSONArray(strArr[1]);
                                    if (jSONArray.length() > aLs()) {
                                        a(ewVar, 1110, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + aLs() + ".");
                                    } else if (jSONArray.length() == 0) {
                                        a(ewVar, 1110, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + aLs() + ".");
                                    } else {
                                        while (i < jSONArray.length()) {
                                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                                            aqi com_tencent_mm_protocal_c_aqi = new aqi();
                                            com_tencent_mm_protocal_c_aqi.ssid = m.AB(jSONObject.getString("ssid"));
                                            com_tencent_mm_protocal_c_aqi.bssid = jSONObject.getString("bssid");
                                            com_tencent_mm_protocal_c_aqi.ftq = jSONObject.getInt("rssi");
                                            linkedList.add(com_tencent_mm_protocal_c_aqi);
                                            i++;
                                        }
                                        new j(linkedList, i2).b(new 1(this, linkedList, i2, ewVar));
                                    }
                                } catch (Exception e) {
                                    a(ewVar, TXLiveConstants.PUSH_WARNING_BEAUTYSURFACE_VIEW_INIT_FAIL, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
                                }
                            }
                        } catch (Exception e2) {
                            a(ewVar, TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_SW_SWITCH_HW, "Args[2] is not a valid int value.");
                        }
                    }
                } catch (Exception e3) {
                    a(ewVar, TXLiveConstants.PUSH_WARNING_RECONNECT, "Args[0] is not an integer.");
                }
            }
        }
    }

    private void a(ew ewVar, int i, String str) {
        Exception e;
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", new Object[]{Integer.valueOf(i), str});
        MatrixCursor matrixCursor;
        try {
            matrixCursor = new MatrixCursor(mDE);
            try {
                matrixCursor.addRow(new Object[]{Integer.valueOf(i), str, Integer.valueOf(aLs()), Integer.valueOf(aLt())});
                ewVar.ftL.ftN = matrixCursor;
                ewVar.ftL.ftr = 1;
                if (ewVar.fqI != null) {
                    ewVar.fqI.run();
                }
            } catch (Exception e2) {
                e = e2;
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                x.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[]{e});
                ewVar.ftL.ftN = null;
                ewVar.ftL.ftr = 1;
                if (ewVar.fqI != null) {
                    ewVar.fqI.run();
                }
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            x.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[]{e});
            ewVar.ftL.ftN = null;
            ewVar.ftL.ftr = 1;
            if (ewVar.fqI != null) {
                ewVar.fqI.run();
            }
        }
    }

    public final synchronized int aLs() {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.mDF);
        return this.mDF;
    }

    public final synchronized void pU(int i) {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = " + i);
        this.mDF = i;
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.mDF);
    }

    public final synchronized int aLt() {
        return this.mDG;
    }

    public final synchronized void pV(int i) {
        this.mDG = i;
    }

    private synchronized long aLu() {
        return this.mDH;
    }

    public final synchronized void du(long j) {
        this.mDH = j;
    }
}
