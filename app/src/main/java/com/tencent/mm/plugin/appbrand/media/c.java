package com.tencent.mm.plugin.appbrand.media;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c {
    private static String jzq = "";
    private static Map<String, com.tencent.mm.sdk.b.c> jzr = new HashMap();
    private static ArrayList<String> jzs = new ArrayList();
    private static Map<String, com.tencent.mm.sdk.b.c> jzt = new HashMap();
    private static ArrayList<String> jzu = new ArrayList();
    private static a jzv = null;
    private static boolean jzw = false;

    public static void tf(String str) {
        jzq = str;
    }

    public static void ail() {
        x.i("MicroMsg.Audio.AppBrandAudioService", "clearAudioListener");
        Iterator it = jzs.iterator();
        while (it.hasNext()) {
            com.tencent.mm.sdk.b.c cVar = (com.tencent.mm.sdk.b.c) jzr.remove((String) it.next());
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.xef.c(cVar);
            }
        }
        jzr.clear();
        jzs.clear();
        it = jzu.iterator();
        while (it.hasNext()) {
            cVar = (com.tencent.mm.sdk.b.c) jzt.remove((String) it.next());
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.xef.c(cVar);
            }
        }
        jzt.clear();
        jzu.clear();
    }

    public static void a(String str, com.tencent.mm.sdk.b.c cVar) {
        if (jzr.containsKey(str)) {
            x.e("MicroMsg.Audio.AppBrandAudioService", "appId:%s has add listener", new Object[]{str});
        } else if (cVar == null) {
            x.e("MicroMsg.Audio.AppBrandAudioService", "listener is null");
        } else {
            x.i("MicroMsg.Audio.AppBrandAudioService", "addRecordListener,appId:%s", new Object[]{str});
            jzr.put(str, cVar);
            if (!jzs.contains(str)) {
                jzs.add(str);
            }
            com.tencent.mm.sdk.b.a.xef.a(cVar);
        }
    }

    public static void tg(String str) {
        if (jzr.containsKey(str)) {
            x.i("MicroMsg.Audio.AppBrandAudioService", "removeRecordListener,appId:%s", new Object[]{str});
            jzs.remove(str);
            com.tencent.mm.sdk.b.c cVar = (com.tencent.mm.sdk.b.c) jzr.remove(str);
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.xef.c(cVar);
                return;
            }
            return;
        }
        x.e("MicroMsg.Audio.AppBrandAudioService", "appId:%s not exist the appId for listener", new Object[]{str});
    }

    public static void b(String str, com.tencent.mm.sdk.b.c cVar) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.Audio.AppBrandAudioService", "appId is empty");
        } else if (cVar == null) {
            x.e("MicroMsg.Audio.AppBrandAudioService", "listener is null");
        } else {
            if (jzt.containsKey(str)) {
                th(str);
            }
            x.i("MicroMsg.Audio.AppBrandAudioService", "addAudioPlayerListener,appId:%s", new Object[]{str});
            jzt.put(str, cVar);
            if (!jzu.contains(str)) {
                jzu.add(str);
            }
            com.tencent.mm.sdk.b.a.xef.a(cVar);
        }
    }

    public static void th(String str) {
        if (jzt.containsKey(str)) {
            x.i("MicroMsg.Audio.AppBrandAudioService", "removeAudioPlayerListener,appId:%s", new Object[]{str});
            jzu.remove(str);
            com.tencent.mm.sdk.b.c cVar = (com.tencent.mm.sdk.b.c) jzt.remove(str);
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.xef.c(cVar);
                return;
            }
            return;
        }
        x.e("MicroMsg.Audio.AppBrandAudioService", "appId:%s not exist the appId for listener", new Object[]{str});
    }

    public static void aim() {
        if (jzv == null) {
            jzv = new 1();
        }
        if (!jzw) {
            x.i("MicroMsg.Audio.AppBrandAudioService", "addMainServiceEventListener success");
            jzw = true;
            AppBrandMainProcessService.a(jzv);
        }
    }

    public static void ain() {
        if (jzv != null && jzw) {
            x.i("MicroMsg.Audio.AppBrandAudioService", "removeServiceEventListener success");
            jzw = false;
            AppBrandMainProcessService.b(jzv);
        }
    }
}
