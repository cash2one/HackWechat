package com.tencent.mm.plugin.music.model.a;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;

class c$2 implements ISoLibraryLoader {
    c$2() {
    }

    public final boolean load(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg..Audio.AudioPlayerUtils", "LoadLibrary lib_name is null");
            return false;
        } else if (k.eL(str)) {
            return true;
        } else {
            x.i("MicroMsg..Audio.AudioPlayerUtils", "load library %s", str);
            ClassLoader classLoader = c.class.getClassLoader();
            if (TextUtils.isEmpty(k.eM(str))) {
                x.e("MicroMsg..Audio.AudioPlayerUtils", "LoadLibrary can't find the lib %s so", str);
                return false;
            }
            x.i("MicroMsg..Audio.AudioPlayerUtils", "LoadLibrary find and load the lib %s so", k.eM(str));
            k.b(str, classLoader);
            return true;
        }
    }
}
