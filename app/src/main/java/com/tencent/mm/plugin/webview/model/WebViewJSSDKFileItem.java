package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public abstract class WebViewJSSDKFileItem implements Parcelable {
    public String appId;
    public String fileName;
    public int ftE;
    public String fus;
    public String iLu;
    public String iLv;
    public boolean iLx;
    public boolean iLy = true;
    public boolean iLz = true;
    public String jip;
    public String mediaId;
    public a tsu;

    public abstract WebViewJSSDKFileItem bQM();

    public abstract String bQN();

    public abstract String bQO();

    public static WebViewJSSDKFileItem Ol(String str) {
        WebViewJSSDKFileItem webViewJSSDKImageItem = new WebViewJSSDKImageItem();
        webViewJSSDKImageItem.iLu = str;
        webViewJSSDKImageItem.bQM();
        webViewJSSDKImageItem.mediaId = d.a("jsupimg", bh.Wp(), webViewJSSDKImageItem.fus, webViewJSSDKImageItem.fus);
        return webViewJSSDKImageItem;
    }

    public static WebViewJSSDKFileItem Om(String str) {
        WebViewJSSDKFileItem webViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
        webViewJSSDKVoiceItem.fileName = str;
        webViewJSSDKVoiceItem.bQM();
        webViewJSSDKVoiceItem.mediaId = d.a("jsupvoice", bh.Wp(), webViewJSSDKVoiceItem.fus, webViewJSSDKVoiceItem.fus);
        return webViewJSSDKVoiceItem;
    }

    public static WebViewJSSDKFileItem x(int i, String str, String str2) {
        WebViewJSSDKFileItem webViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
        webViewJSSDKUpFileItem.fileType = i;
        webViewJSSDKUpFileItem.mXT = str;
        webViewJSSDKUpFileItem.iLu = str2;
        webViewJSSDKUpFileItem.bQM();
        webViewJSSDKUpFileItem.mediaId = d.a("jsupfile", bh.Wp(), webViewJSSDKUpFileItem.fus, webViewJSSDKUpFileItem.fus);
        x.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[]{Integer.valueOf(i), str2, webViewJSSDKUpFileItem.fus});
        return webViewJSSDKUpFileItem;
    }

    public static WebViewJSSDKVideoItem On(String str) {
        WebViewJSSDKVideoItem webViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
        webViewJSSDKVideoItem.iLu = str;
        webViewJSSDKVideoItem.bQM();
        webViewJSSDKVideoItem.mediaId = d.a("jsvideofile", bh.Wp(), webViewJSSDKVideoItem.fus, webViewJSSDKVideoItem.fus);
        x.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[]{str, webViewJSSDKVideoItem.fus, webViewJSSDKVideoItem.mediaId});
        return webViewJSSDKVideoItem;
    }

    public void c(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (this.tsu == null) {
            this.tsu = new a();
        }
        if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            x.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
            return;
        }
        this.tsu.field_aesKey = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
        this.tsu.field_fileId = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        this.tsu.field_fileUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
        this.tsu.field_fileLength = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
    }

    protected WebViewJSSDKFileItem(Parcel parcel) {
        this.appId = parcel.readString();
        this.fus = parcel.readString();
        this.jip = parcel.readString();
        this.iLu = parcel.readString();
        this.ftE = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.fus);
        parcel.writeString(this.jip);
        parcel.writeString(this.iLu);
        parcel.writeInt(this.ftE);
    }
}
