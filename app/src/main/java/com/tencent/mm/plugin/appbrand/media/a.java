package com.tencent.mm.plugin.appbrand.media;

import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private static Map<String, h> jzl = new ConcurrentHashMap();

    public static void onCreate() {
        x.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
        jzl.clear();
    }

    public static void onDestroy() {
        x.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
        jzl.clear();
    }

    public static void a(String str, h hVar) {
        jzl.put(str, hVar);
    }

    public static h te(String str) {
        return (h) jzl.get(str);
    }
}
