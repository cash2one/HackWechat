package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.a;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.p.e;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

final class an extends d {
    an() {
    }

    final f$a a(j jVar, String str, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.appstorage.j jVar2;
        Uri parse = Uri.parse(str);
        List<h> linkedList = new LinkedList();
        if (parse.getScheme().equals("wxfile") && bh.ov(parse.getAuthority())) {
            com.tencent.mm.plugin.appbrand.p.h hVar = new com.tencent.mm.plugin.appbrand.p.h();
            ((a) jVar.irP.iqz.x(a.class)).b("", hVar);
            if (!bh.cA((List) hVar.jRK)) {
                for (h hVar2 : (List) hVar.jRK) {
                    hVar2.fileName = hVar2.fileName.replaceFirst(Pattern.quote(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX), "");
                }
            }
            e.e(linkedList, (List) hVar.jRK);
            hVar = new com.tencent.mm.plugin.appbrand.p.h();
            ((com.tencent.mm.plugin.appbrand.appstorage.e) jVar.irP.iqz.x(com.tencent.mm.plugin.appbrand.appstorage.e.class)).b("wxfile://usr", hVar);
            e.e(linkedList, (List) hVar.jRK);
            jVar2 = com.tencent.mm.plugin.appbrand.appstorage.j.iIt;
        } else {
            com.tencent.mm.plugin.appbrand.p.h hVar3 = new com.tencent.mm.plugin.appbrand.p.h();
            com.tencent.mm.plugin.appbrand.appstorage.j b = jVar.irP.iqz.b(str, hVar3);
            e.e(linkedList, (List) hVar3.jRK);
            jVar2 = b;
        }
        switch (1.jjG[jVar2.ordinal()]) {
            case 1:
            case 2:
                return new f$a("fail no such file or directory \"%s\"", str);
            case 3:
                return new f$a("fail not a directory \"%s\"", str);
            case 4:
                return new f$a("fail permission denied, open \"%s\"", str);
            case 5:
                return new f$a("fail \"%s\" is not a regular file", str);
            case 6:
                JSONArray jSONArray = new JSONArray();
                for (h hVar22 : linkedList) {
                    jSONArray.put(hVar22.fileName);
                }
                return new f$a("ok", new Object[0]).s("files", jSONArray);
            default:
                return new f$a("fail " + jVar2.name(), new Object[0]);
        }
    }
}
