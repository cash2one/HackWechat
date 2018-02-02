package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ag extends aa {
    public ag(String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("username", str);
        hashMap.put("sendId", str2);
        hashMap.put(DownloadInfoColumns.CHANNELID, "1");
        hashMap.put("ver", str3);
        hashMap.put("sendUserName", q.FS());
        D(hashMap);
    }

    public final int getType() {
        return 1668;
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/sharewxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
