package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class ar extends d {
    ar() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        FileStructStat fileStructStat = new FileStructStat();
        com.tencent.mm.plugin.appbrand.appstorage.j a = jVar.irP.iqz.a(str, fileStructStat);
        switch (1.jjG[a.ordinal()]) {
            case 1:
                return new a("ok", new Object[0]).s("mode", Integer.valueOf(fileStructStat.st_mode)).s("size", Long.valueOf(fileStructStat.st_size)).s("lastAccessedTime", Long.valueOf(fileStructStat.st_atime)).s("lastModifiedTime", Long.valueOf(fileStructStat.st_mtime));
            case 2:
            case 3:
                return new a("fail no such file or directory \"%s\"", new Object[]{str});
            case 4:
                return new a("fail permission denied, open \"%s\"", new Object[]{str});
            default:
                return new a("fail " + a.name(), new Object[0]);
        }
    }
}
