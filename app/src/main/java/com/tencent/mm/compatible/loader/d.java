package com.tencent.mm.compatible.loader;

import android.content.Context;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static Map<String, String> gGW;

    public static String t(Context context, String str) {
        long Wp = bh.Wp();
        if (gGW == null) {
            try {
                Map UU = r.UU(bh.convertStreamToString(context.getAssets().open("preload/libraries.ini")));
                x.v("MicroMsg.PluginClassLoader", "libraries.ini content\n%s", r0);
                if (UU == null || UU.size() <= 0) {
                    x.e("MicroMsg.PluginClassLoader", "parse libraries.ini failed");
                } else {
                    gGW = new HashMap(UU.size());
                    for (Entry entry : UU.entrySet()) {
                        x.d("MicroMsg.PluginClassLoader", "preload file, plugin=%s, md5=%s", entry.getKey(), entry.getValue());
                        gGW.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable e) {
                x.e("MicroMsg.PluginClassLoader", "load preload libraries failed");
                x.printErrStackTrace("MicroMsg.PluginClassLoader", e, "", new Object[0]);
            }
        }
        String absolutePath = context.getDir("lib", 0).getAbsolutePath();
        if (gGW == null) {
            x.e("MicroMsg.PluginClassLoader", "extractVoipDex preload so files loaded failed");
            return null;
        }
        String str2 = absolutePath + "/" + str;
        absolutePath = (String) gGW.get(str);
        if (absolutePath == null) {
            x.w("MicroMsg.PluginClassLoader", "extractVoipDex not in preloadfiles");
            return null;
        }
        File file = new File(str2);
        if (file.exists()) {
            String i = g.i(file);
            if (i == null || !i.equalsIgnoreCase(absolutePath)) {
                x.e("MicroMsg.PluginClassLoader", "extractVoipDex target file exists, but md5 check failed, target=%s assets=%s", i, absolutePath);
            } else {
                x.d("MicroMsg.PluginClassLoader", "extractVoipDex: targetFilePath:[%s] time:%d", file, Long.valueOf(bh.bz(Wp)));
                return str2;
            }
        }
        b.deleteFile(str2);
        if (k.A(context, "preload/" + str, str2)) {
            x.i("MicroMsg.PluginClassLoader", "extractVoipDex time:%d so:%s md5:%s ", Long.valueOf(bh.bz(Wp)), str, absolutePath);
            return str2;
        }
        x.f("MicroMsg.PluginClassLoader", "extractVoipDex  copyAssets failed");
        return null;
    }
}
