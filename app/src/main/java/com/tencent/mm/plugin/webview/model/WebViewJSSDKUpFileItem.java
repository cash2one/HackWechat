package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WebViewJSSDKUpFileItem extends WebViewJSSDKFileItem {
    public static final Creator<WebViewJSSDKUpFileItem> CREATOR = new 1();
    public int fileType;
    public String mXT;

    public WebViewJSSDKUpFileItem() {
        this.fileType = -1;
        this.ftE = 3;
    }

    public final WebViewJSSDKFileItem bQM() {
        this.fus = ai.Or(this.iLu);
        return this;
    }

    public final void c(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        super.c(com_tencent_mm_modelcdntran_keep_SceneResult);
        List arrayList = new ArrayList();
        arrayList.add(this.fileType);
        arrayList.add(this.mXT);
        arrayList.add(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId);
        arrayList.add(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey);
        arrayList.add(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
        Context context = ac.getContext();
        if (an.isWifi(context)) {
            arrayList.add("1");
        } else if (an.is3G(context)) {
            arrayList.add("4");
        } else if (an.is4G(context)) {
            arrayList.add("5");
        } else if (an.is2G(context)) {
            arrayList.add(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        } else if (an.isWap(context)) {
            arrayList.add("2");
        } else {
            arrayList.add("0");
        }
        x.d("MicroMsg.WebViewJSSDKVoiceItem", "fileType=%d, initUrl=%s, field_fileId=%s", new Object[]{Integer.valueOf(this.fileType), this.mXT, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId});
        g.pQN.d(12018, arrayList);
        String str = this.iLu;
        if (!bh.ov(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final String bQN() {
        return "file";
    }

    public final String bQO() {
        return "nomal";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    private WebViewJSSDKUpFileItem(byte b) {
        this.fileType = -1;
    }
}
