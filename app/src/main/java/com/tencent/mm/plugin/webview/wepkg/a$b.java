package com.tencent.mm.plugin.webview.wepkg;

import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.plugin.webview.wepkg.model.f;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.a.a.a.a.b;
import java.io.File;

public class a$b extends b {
    final /* synthetic */ a tLy;

    public a$b(a aVar) {
        this.tLy = aVar;
    }

    public final Object onMiscCallBack(String str, Bundle bundle) {
        boolean z = false;
        String str2 = "MicroMsg.Wepkg.WePkgPlugin";
        String str3 = "method = %s, bundler == null ? %b";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (bundle == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        if (bh.ov(str) || bundle == null || !a.j(this.tLy) || a.k(this.tLy) == null || !str.equalsIgnoreCase("shouldInterceptMediaUrl")) {
            return null;
        }
        String string = bundle.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        x.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:" + string);
        if (bh.ov(string)) {
            return null;
        }
        x.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
        f k = a.k(this.tLy);
        string = d.Qs(string);
        if (!(bh.ov(string) || k.tNd == null || k.tNd.get(string) == null)) {
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) k.tNd.get(string);
            if (!bh.ov(wepkgPreloadFile.filePath)) {
                File file = new File(wepkgPreloadFile.filePath);
                if (file.exists() && file.isFile() && file.length() == ((long) wepkgPreloadFile.size)) {
                    string = wepkgPreloadFile.filePath;
                    if (!bh.ov(string)) {
                        return null;
                    }
                    x.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:" + string);
                    return string;
                }
            }
        }
        string = null;
        if (!bh.ov(string)) {
            return null;
        }
        x.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:" + string);
        return string;
    }
}
