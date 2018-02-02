package com.tencent.mm.plugin.webview.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.plugin.webview.model.c.b;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.protocal.c.apk;
import com.tencent.mm.protocal.c.apm;
import com.tencent.mm.protocal.c.apq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Iterator;
import java.util.Vector;

public final class ac implements e {
    private a hBx = new 1(this);
    private Vector<b> iLA = new Vector();
    private Vector<c.a> iLB = new Vector();

    public final void a(c.a aVar) {
        if (this.iLB != null && aVar != null && !this.iLB.contains(aVar)) {
            this.iLB.add(aVar);
        }
    }

    public final void a(b bVar) {
        if (this.iLA != null && bVar != null) {
            this.iLA.remove(bVar);
        }
    }

    public final void b(c.a aVar) {
        if (this.iLB != null && aVar != null) {
            this.iLB.remove(aVar);
        }
    }

    private void b(boolean z, String str, String str2, String str3) {
        if (this.iLA != null && this.iLA.size() > 0) {
            Iterator it = this.iLA.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(z, str, str2, str3);
            }
        }
    }

    final void b(boolean z, int i, int i2, String str, String str2) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2});
        if (this.iLB != null && this.iLB.size() > 0) {
            Iterator it = this.iLB.iterator();
            while (it.hasNext()) {
                ((c.a) it.next()).a(z, i, i2, str, str2);
            }
        }
    }

    public final boolean a(String str, String str2, b bVar) {
        ad bRB = f.bRB();
        if (!bh.ov(str2)) {
            for (WebViewJSSDKFileItem webViewJSSDKFileItem : bRB.tsw.values()) {
                if (bh.ou(webViewJSSDKFileItem.iLv).equals(str2)) {
                    break;
                }
            }
        }
        x.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
        WebViewJSSDKFileItem webViewJSSDKFileItem2 = null;
        if (webViewJSSDKFileItem2 != null) {
            webViewJSSDKFileItem2.appId = str;
            x.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", new Object[]{str, str2, webViewJSSDKFileItem2.fus});
            bVar.a(true, webViewJSSDKFileItem2.fus, webViewJSSDKFileItem2.iLv, null);
        } else {
            ar.CG().a(1035, this);
            ar.CG().a(new f(str, str2), 0);
            this.iLA.add(bVar);
        }
        return true;
    }

    private void a(WebViewJSSDKFileItem webViewJSSDKFileItem) {
        i iVar = new i();
        iVar.htt = this.hBx;
        iVar.fLH = false;
        iVar.field_mediaId = webViewJSSDKFileItem.mediaId;
        iVar.field_fullpath = webViewJSSDKFileItem.iLu;
        iVar.field_totalLen = webViewJSSDKFileItem.tsu.field_fileLength;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
        iVar.field_fileId = webViewJSSDKFileItem.tsu.field_fileId;
        iVar.field_aesKey = webViewJSSDKFileItem.tsu.field_aesKey;
        iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
        iVar.field_needStorage = false;
        iVar.field_isStreamMedia = false;
        x.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", new Object[]{Boolean.valueOf(g.MJ().b(iVar, -1)), webViewJSSDKFileItem.iLv});
        if (!g.MJ().b(iVar, -1)) {
            b(false, null, null, null);
        }
    }

    public final boolean a(String str, String str2, int i, int i2, int i3, b bVar) {
        WebViewJSSDKFileItem Oo = f.bRB().Oo(str2);
        if (Oo == null) {
            x.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str2});
            return false;
        }
        Oo.appId = str;
        if (bVar != null) {
            this.iLA.add(bVar);
        }
        if (i2 == 202) {
            Oo.iLz = false;
        }
        Oo.iLx = true;
        i iVar = new i();
        iVar.htt = this.hBx;
        iVar.fLH = true;
        iVar.field_mediaId = Oo.mediaId;
        iVar.field_fullpath = Oo.iLu;
        iVar.field_fileType = i;
        iVar.field_talker = "weixin";
        iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
        if (i == com.tencent.mm.modelcdntran.b.hrN) {
            iVar.field_needStorage = true;
        } else {
            iVar.field_needStorage = false;
        }
        iVar.field_isStreamMedia = false;
        iVar.field_appType = i2;
        iVar.field_bzScene = i3;
        iVar.field_force_aeskeycdn = true;
        iVar.field_trysafecdn = false;
        x.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[]{Boolean.valueOf(g.MJ().c(iVar)), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn), str2});
        return g.MJ().c(iVar);
    }

    public final boolean b(String str, String str2, b bVar) {
        return a(str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, bVar);
    }

    public static boolean qh(String str) {
        WebViewJSSDKFileItem Oo = f.bRB().Oo(str);
        if (Oo != null) {
            return g.MJ().kH(Oo.mediaId);
        }
        x.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str});
        return false;
    }

    public static boolean Ok(String str) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", new Object[]{str});
        return g.MJ().kI(str);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType())});
        String str2;
        String str3;
        String str4;
        String str5;
        switch (kVar.getType()) {
            case 1034:
                ar.CG().b(1034, this);
                w wVar = (w) kVar;
                str2 = ((apq) wVar.gJQ.hmh.hmo).wwv;
                str3 = wVar.appId;
                str4 = wVar.fus;
                WebViewJSSDKFileItem Oo = f.bRB().Oo(str4);
                String str6 = "MicroMsg.WebviewFileChooserCdnService";
                str5 = "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b";
                Object[] objArr = new Object[4];
                objArr[0] = str2;
                objArr[1] = str3;
                objArr[2] = str4;
                objArr[3] = Boolean.valueOf(Oo == null);
                x.i(str6, str5, objArr);
                if (i != 0 || i2 != 0) {
                    x.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
                    if (Oo != null) {
                        b(false, Oo.fus, Oo.mediaId, null);
                        return;
                    }
                    return;
                } else if (!bh.ov(str3) && !bh.ov(str2) && Oo != null) {
                    Oo.iLv = str2;
                    b(true, Oo.ftE, 100, Oo.fus, Oo.iLv);
                    b(true, Oo.fus, Oo.iLv, Oo.tsu.field_fileUrl);
                    return;
                } else {
                    return;
                }
            case 1035:
                ar.CG().b(1035, this);
                if (i == 0 && i2 == 0) {
                    f fVar = (f) kVar;
                    str2 = fVar.appId;
                    str3 = fVar.iLv;
                    apk com_tencent_mm_protocal_c_apk = ((apm) fVar.gJQ.hmh.hmo).www;
                    str5 = "MicroMsg.WebviewFileChooserCdnService";
                    String str7 = "appid = %s, serverId = %s, cdninfo == null ? %b";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = str2;
                    objArr2[1] = str3;
                    objArr2[2] = Boolean.valueOf(com_tencent_mm_protocal_c_apk == null);
                    x.i(str5, str7, objArr2);
                    if (!bh.ov(str2) && !bh.ov(str3) && com_tencent_mm_protocal_c_apk != null) {
                        str4 = com_tencent_mm_protocal_c_apk.type;
                        x.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", new Object[]{str4});
                        if (!bh.ov(str4)) {
                            WebViewJSSDKFileItem Om;
                            if (str4.toLowerCase().equals("voice")) {
                                Om = WebViewJSSDKFileItem.Om(ai.Ov(str2));
                            } else if (str4.toLowerCase().equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                                Om = WebViewJSSDKFileItem.On(ai.Op(bh.Wp()));
                            } else {
                                Om = WebViewJSSDKFileItem.Ol(ai.Op(bh.Wp()));
                            }
                            Om.iLx = false;
                            Om.appId = str2;
                            Om.iLv = str3;
                            if (Om.tsu == null) {
                                Om.tsu = new WebViewJSSDKFileItem$a();
                            }
                            if (com_tencent_mm_protocal_c_apk == null) {
                                x.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
                            } else {
                                Om.tsu.field_aesKey = com_tencent_mm_protocal_c_apk.wwt;
                                Om.tsu.field_fileId = com_tencent_mm_protocal_c_apk.wws;
                                Om.tsu.field_fileLength = com_tencent_mm_protocal_c_apk.vUI;
                            }
                            f.bRB().b(Om);
                            a(Om);
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
                b(false, null, null, null);
                return;
            default:
                return;
        }
    }
}
