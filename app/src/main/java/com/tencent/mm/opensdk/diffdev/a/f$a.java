package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import org.json.JSONObject;

class f$a {
    public OAuthErrCode o;
    public String w;
    public int x;

    f$a() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static f$a b(byte[] bArr) {
        f$a com_tencent_mm_opensdk_diffdev_a_f_a = new f$a();
        if (bArr == null || bArr.length == 0) {
            Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
            com_tencent_mm_opensdk_diffdev_a_f_a.o = OAuthErrCode.WechatAuth_Err_NetworkErr;
        } else {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, ProtocolPackage.ServerEncoding));
                    com_tencent_mm_opensdk_diffdev_a_f_a.x = jSONObject.getInt("wx_errcode");
                    Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[]{Integer.valueOf(com_tencent_mm_opensdk_diffdev_a_f_a.x)}));
                    switch (com_tencent_mm_opensdk_diffdev_a_f_a.x) {
                        case e.CTRL_INDEX /*402*/:
                            com_tencent_mm_opensdk_diffdev_a_f_a.o = OAuthErrCode.WechatAuth_Err_Timeout;
                            break;
                        case ap.CTRL_INDEX /*403*/:
                            com_tencent_mm_opensdk_diffdev_a_f_a.o = OAuthErrCode.WechatAuth_Err_Cancel;
                            break;
                        case TencentLocation.ERROR_UNKNOWN /*404*/:
                            com_tencent_mm_opensdk_diffdev_a_f_a.o = OAuthErrCode.WechatAuth_Err_OK;
                            break;
                        case 405:
                            com_tencent_mm_opensdk_diffdev_a_f_a.o = OAuthErrCode.WechatAuth_Err_OK;
                            com_tencent_mm_opensdk_diffdev_a_f_a.w = jSONObject.getString("wx_code");
                            break;
                        case av.CTRL_INDEX /*408*/:
                            com_tencent_mm_opensdk_diffdev_a_f_a.o = OAuthErrCode.WechatAuth_Err_OK;
                            break;
                        case 500:
                            com_tencent_mm_opensdk_diffdev_a_f_a.o = OAuthErrCode.WechatAuth_Err_NormalErr;
                            break;
                        default:
                            com_tencent_mm_opensdk_diffdev_a_f_a.o = OAuthErrCode.WechatAuth_Err_NormalErr;
                            break;
                    }
                } catch (Exception e) {
                    Log.e("MicroMsg.SDK.NoopingResult", String.format("parse json fail, ex = %s", new Object[]{e.getMessage()}));
                    com_tencent_mm_opensdk_diffdev_a_f_a.o = OAuthErrCode.WechatAuth_Err_NormalErr;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SDK.NoopingResult", String.format("parse fail, build String fail, ex = %s", new Object[]{e2.getMessage()}));
                com_tencent_mm_opensdk_diffdev_a_f_a.o = OAuthErrCode.WechatAuth_Err_NormalErr;
            }
        }
        return com_tencent_mm_opensdk_diffdev_a_f_a;
    }
}
