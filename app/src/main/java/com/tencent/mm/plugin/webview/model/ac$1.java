package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.protocal.c.apk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.ByteArrayOutputStream;

class ac$1 implements a {
    final /* synthetic */ ac tst;

    ac$1(ac acVar) {
        this.tst = acVar;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", str);
    }

    public final byte[] h(String str, byte[] bArr) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", str);
        return null;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        String str2;
        WebViewJSSDKFileItem webViewJSSDKFileItem;
        String str3 = "MicroMsg.WebviewFileChooserCdnService";
        String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo == null ? "null" : com_tencent_mm_modelcdntran_keep_ProgressInfo.toString();
        if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            str2 = "null";
        } else {
            str2 = com_tencent_mm_modelcdntran_keep_SceneResult.toString();
        }
        objArr[3] = str2;
        x.i(str3, str4, objArr);
        ad bRB = f.bRB();
        if (!bh.ov(str)) {
            for (WebViewJSSDKFileItem webViewJSSDKFileItem2 : bRB.tsw.values()) {
                if (bh.ou(webViewJSSDKFileItem2.mediaId).equals(str)) {
                    webViewJSSDKFileItem = webViewJSSDKFileItem2;
                    break;
                }
            }
        }
        x.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
        webViewJSSDKFileItem = null;
        if (webViewJSSDKFileItem == null) {
            x.e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", str);
            return 0;
        } else if (i == -21005) {
            x.i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", str);
            return 0;
        } else if (i != 0) {
            x.e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
            ac.a(this.tst, false, webViewJSSDKFileItem.fus, webViewJSSDKFileItem.mediaId, null);
            return 0;
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            x.i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", com_tencent_mm_modelcdntran_keep_ProgressInfo.toString());
            int i2 = 0;
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength > 0) {
                i2 = (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength * 100) / com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
            }
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > 100) {
                i2 = 100;
            }
            this.tst.b(webViewJSSDKFileItem.iLx, webViewJSSDKFileItem.ftE, i2, webViewJSSDKFileItem.fus, webViewJSSDKFileItem.mediaId);
            return 0;
        } else {
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    x.e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult);
                    ac.a(this.tst, false, webViewJSSDKFileItem.fus, webViewJSSDKFileItem.mediaId, null);
                } else {
                    x.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s", str);
                    if (webViewJSSDKFileItem != null) {
                        webViewJSSDKFileItem.c(com_tencent_mm_modelcdntran_keep_SceneResult);
                        if (webViewJSSDKFileItem.iLx && webViewJSSDKFileItem.iLz) {
                            e eVar = this.tst;
                            if (webViewJSSDKFileItem == null) {
                                x.e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
                            } else {
                                apk com_tencent_mm_protocal_c_apk = new apk();
                                com_tencent_mm_protocal_c_apk.wwt = webViewJSSDKFileItem.tsu.field_aesKey;
                                com_tencent_mm_protocal_c_apk.vUI = webViewJSSDKFileItem.tsu.field_fileLength;
                                com_tencent_mm_protocal_c_apk.wws = webViewJSSDKFileItem.tsu.field_fileId;
                                com_tencent_mm_protocal_c_apk.type = webViewJSSDKFileItem.bQO();
                                x.d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", webViewJSSDKFileItem.appId, webViewJSSDKFileItem.fus, com_tencent_mm_protocal_c_apk.wwt, Integer.valueOf(com_tencent_mm_protocal_c_apk.vUI), com_tencent_mm_protocal_c_apk.wws);
                                com_tencent_mm_protocal_c_apk.wwu = webViewJSSDKFileItem.bQN();
                                ar.CG().a(1034, eVar);
                                ar.CG().a(new w(webViewJSSDKFileItem.appId, webViewJSSDKFileItem.fus, com_tencent_mm_protocal_c_apk), 0);
                            }
                        } else {
                            ac.a(this.tst, true, webViewJSSDKFileItem.fus, webViewJSSDKFileItem.iLv, webViewJSSDKFileItem.tsu.field_fileUrl);
                        }
                    }
                }
            }
            return 0;
        }
    }
}
