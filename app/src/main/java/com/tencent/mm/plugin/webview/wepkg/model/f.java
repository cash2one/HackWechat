package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public final class f {
    private String charset = "UTF-8";
    public WepkgVersion tMS;
    private e tNc;
    public Map<String, WepkgPreloadFile> tNd;

    public f(WepkgVersion wepkgVersion, e eVar, Map<String, WepkgPreloadFile> map) {
        this.tMS = wepkgVersion;
        this.tNc = eVar;
        this.tNd = map;
        if (wepkgVersion != null && !bh.ov(wepkgVersion.charset)) {
            this.charset = wepkgVersion.charset;
        }
    }

    public final m Qc(String str) {
        if (bh.ov(str)) {
            return null;
        }
        if (!(this.tNd == null || this.tNd.get(str) == null)) {
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.tNd.get(str);
            if (!bh.ov(wepkgPreloadFile.filePath)) {
                File file = new File(wepkgPreloadFile.filePath);
                if (file.exists() && file.isFile() && file.length() == ((long) wepkgPreloadFile.size)) {
                    try {
                        x.i("MicroMsg.Wepkg.WepkgInterceptor", "rid hit preload file. rid:%s", new Object[]{str});
                        return new m(wepkgPreloadFile.mimeType, this.charset, new FileInputStream(file));
                    } catch (FileNotFoundException e) {
                    }
                }
            }
        }
        return this.tNc != null ? this.tNc.eV(str, this.charset) : null;
    }
}
