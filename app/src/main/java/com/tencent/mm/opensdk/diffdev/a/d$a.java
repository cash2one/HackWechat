package com.tencent.mm.opensdk.diffdev.a;

import android.util.Base64;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

class d$a {
    public OAuthErrCode o;
    public String p;
    public String q;
    public String r;
    public int s;
    public String t;
    public byte[] u;

    private d$a() {
    }

    public static d$a a(byte[] bArr) {
        d$a com_tencent_mm_opensdk_diffdev_a_d_a = new d$a();
        if (bArr == null || bArr.length == 0) {
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
            com_tencent_mm_opensdk_diffdev_a_d_a.o = OAuthErrCode.WechatAuth_Err_NetworkErr;
        } else {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, ProtocolPackage.ServerEncoding));
                    int i = jSONObject.getInt("errcode");
                    if (i != 0) {
                        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", new Object[]{Integer.valueOf(i)}));
                        com_tencent_mm_opensdk_diffdev_a_d_a.o = OAuthErrCode.WechatAuth_Err_NormalErr;
                        com_tencent_mm_opensdk_diffdev_a_d_a.s = i;
                        com_tencent_mm_opensdk_diffdev_a_d_a.t = jSONObject.optString("errmsg");
                    } else {
                        String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (string == null || string.length() == 0) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                            com_tencent_mm_opensdk_diffdev_a_d_a.o = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        } else {
                            byte[] decode = Base64.decode(string, 0);
                            if (decode == null || decode.length == 0) {
                                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                                com_tencent_mm_opensdk_diffdev_a_d_a.o = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            } else if (d.b()) {
                                File file = new File(d.c());
                                file.mkdirs();
                                if (file.exists()) {
                                    file.delete();
                                }
                                if (a(d.c(), decode)) {
                                    com_tencent_mm_opensdk_diffdev_a_d_a.o = OAuthErrCode.WechatAuth_Err_OK;
                                    com_tencent_mm_opensdk_diffdev_a_d_a.r = d.c();
                                    com_tencent_mm_opensdk_diffdev_a_d_a.p = jSONObject.getString("uuid");
                                    com_tencent_mm_opensdk_diffdev_a_d_a.q = jSONObject.getString("appname");
                                    Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in external storage, uuid = %s, appname = %s, imgPath = %s", new Object[]{com_tencent_mm_opensdk_diffdev_a_d_a.p, com_tencent_mm_opensdk_diffdev_a_d_a.q, com_tencent_mm_opensdk_diffdev_a_d_a.r}));
                                } else {
                                    Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("writeToFile fail, qrcodeBuf length = %d", new Object[]{Integer.valueOf(decode.length)}));
                                    com_tencent_mm_opensdk_diffdev_a_d_a.o = OAuthErrCode.WechatAuth_Err_NormalErr;
                                }
                            } else {
                                com_tencent_mm_opensdk_diffdev_a_d_a.o = OAuthErrCode.WechatAuth_Err_OK;
                                com_tencent_mm_opensdk_diffdev_a_d_a.u = decode;
                                com_tencent_mm_opensdk_diffdev_a_d_a.p = jSONObject.getString("uuid");
                                com_tencent_mm_opensdk_diffdev_a_d_a.q = jSONObject.getString("appname");
                                Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[]{com_tencent_mm_opensdk_diffdev_a_d_a.p, com_tencent_mm_opensdk_diffdev_a_d_a.q, Integer.valueOf(com_tencent_mm_opensdk_diffdev_a_d_a.u.length)}));
                            }
                        }
                    }
                } catch (Exception e) {
                    Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse json fail, ex = %s", new Object[]{e.getMessage()}));
                    com_tencent_mm_opensdk_diffdev_a_d_a.o = OAuthErrCode.WechatAuth_Err_NormalErr;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse fail, build String fail, ex = %s", new Object[]{e2.getMessage()}));
                com_tencent_mm_opensdk_diffdev_a_d_a.o = OAuthErrCode.WechatAuth_Err_NormalErr;
            }
        }
        return com_tencent_mm_opensdk_diffdev_a_d_a;
    }

    private static boolean a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    Log.e("MicroMsg.SDK.GetQRCodeResult", "fout.close() exception:" + e2.getMessage());
                }
                Log.d("MicroMsg.SDK.GetQRCodeResult", "writeToFile ok!");
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    Log.w("MicroMsg.SDK.GetQRCodeResult", "write to file error, exception:" + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", "fout.close() exception:" + e22.getMessage());
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", "fout.close() exception:" + e4.getMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            Log.w("MicroMsg.SDK.GetQRCodeResult", "write to file error, exception:" + e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
