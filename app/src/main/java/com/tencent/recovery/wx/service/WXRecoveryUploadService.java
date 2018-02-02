package com.tencent.recovery.wx.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.recovery.service.RecoveryUploadService;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.util.EncryptUtil;
import com.tencent.recovery.wx.util.PByteArray;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WXRecoveryUploadService extends RecoveryUploadService {
    private static final String TAG = "Recovery.WXRecoveryUploadService";
    private static final String UNIT_REPORT_TAG = "RecoveryHandle";

    protected boolean tryToUploadData() {
        Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.setAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
        sendBroadcast(intent);
        List a = RecoveryReporter.a((Context) this, "HandleStatus", RecoveryHandleItem.class);
        boolean uploadData = uploadData(a);
        if (a.size() == 0 || uploadData) {
            RecoveryReporter.bB(this, "HandleStatus");
        }
        return uploadData;
    }

    protected boolean uploadData(List<RecoveryHandleItem> list) {
        int gk = Util.gk(this);
        JSONArray jSONArray = new JSONArray();
        String str = "0x26060235";
        for (RecoveryHandleItem recoveryHandleItem : list) {
            try {
                String str2;
                jSONArray.put(new JSONObject().put("tag", UNIT_REPORT_TAG).put("info", recoveryHandleItem.aAM).put(OpenSDKTool4Assistant.EXTRA_UIN, recoveryHandleItem.ned).put("deviceUUID", gk).put("time", Util.gt(recoveryHandleItem.timestamp)).put("cver", recoveryHandleItem.clientVersion).put("processName", recoveryHandleItem.processName).put("phoneStatus", recoveryHandleItem.zRB));
                if (compareVersion(recoveryHandleItem.clientVersion, str) > 0) {
                    str2 = recoveryHandleItem.clientVersion;
                } else {
                    str2 = str;
                }
                str = str2;
            } catch (Exception e) {
            }
        }
        RecoveryLog.i(TAG, "upload result %b %d", Boolean.valueOf(pushData(jSONArray, str)), Integer.valueOf(list.size()));
        return pushData(jSONArray, str);
    }

    private boolean pushData(JSONArray jSONArray, String str) {
        try {
            String gp = WXUtil.gp(this);
            String str2 = "android-" + VERSION.SDK_INT;
            byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", Build.MANUFACTURER + "-" + Build.MODEL).put("os_ver", str2).put("report_time", System.currentTimeMillis())).put("items", jSONArray).toString().getBytes();
            String toLowerCase = EncryptUtil.s(String.format("weixin#$()%d%d", new Object[]{Integer.decode(str), Integer.valueOf(bytes.length)}).getBytes()).toLowerCase();
            bytes = EncryptUtil.q(bytes);
            PByteArray pByteArray = new PByteArray();
            EncryptUtil.a(pByteArray, bytes, toLowerCase.getBytes());
            StringBuilder append = new StringBuilder(256).append("http://support.weixin.qq.com/cgi-bin/mmsupport-bin/stackreport?version=").append(str).append("&devicetype=").append(str2).append("&filelength=").append(r5).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=110");
            if (!(gp == null || gp.length() == 0)) {
                append.append("&username=").append(gp);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(append.toString()).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setRequestProperty("content-type", "binary/octet-stream");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(pByteArray.value);
            outputStream.flush();
            outputStream.close();
            if (httpURLConnection.getResponseCode() != 200) {
                String convertStreamToString = convertStreamToString(httpURLConnection.getErrorStream());
                str2 = convertStreamToString(httpURLConnection.getInputStream());
                RecoveryLog.i(TAG, "POST returned: %d %s %s %s", Integer.valueOf(httpURLConnection.getResponseCode()), str, convertStreamToString, str2);
                return false;
            }
            RecoveryLog.i(TAG, "POST returned success %s", str);
            return true;
        } catch (Throwable e) {
            RecoveryLog.printErrStackTrace(TAG, e, "pushData", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String convertStreamToString(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine + "\n");
                } else {
                    try {
                        break;
                    } catch (Throwable e) {
                        RecoveryLog.printErrStackTrace(TAG, e, "", new Object[0]);
                    }
                }
            } catch (Throwable e2) {
                RecoveryLog.printErrStackTrace(TAG, e2, "", new Object[0]);
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    RecoveryLog.printErrStackTrace(TAG, e3, "", new Object[0]);
                }
            }
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    private static int compareVersion(String str, String str2) {
        try {
            int intValue = Integer.decode(str).intValue();
            int intValue2 = Integer.decode(str2).intValue();
            if (intValue > intValue2) {
                return 1;
            }
            if (intValue2 > intValue) {
                return -1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
