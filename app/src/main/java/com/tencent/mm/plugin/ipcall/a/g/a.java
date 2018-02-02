package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class a {
    private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
    public String fon = "";
    public int ktN = 0;
    public String nGE = "";
    public String nGF = "";
    public String nfe = "";

    public static a CB(String str) {
        x.d(TAG, "getIPCallActivityMsgInfoFromXML:" + str);
        a aVar = new a();
        int indexOf = str.indexOf("<ActivityInfo");
        if (indexOf == -1) {
            x.e(TAG, "msgContent not start with <ActivityInfo");
            return aVar;
        }
        Map y = bi.y(str.substring(indexOf), "ActivityInfo");
        if (y == null) {
            x.e(TAG, "XmlParser values is null, xml %s", new Object[]{str});
            return null;
        }
        if (y.containsKey(".ActivityInfo.Title")) {
            aVar.fon = (String) y.get(".ActivityInfo.Title");
        }
        if (y.containsKey(".ActivityInfo.Desc")) {
            aVar.nfe = (String) y.get(".ActivityInfo.Desc");
        }
        if (y.containsKey(".ActivityInfo.ImgUrl")) {
            aVar.nGE = (String) y.get(".ActivityInfo.ImgUrl");
        }
        if (y.containsKey(".ActivityInfo.StartBtnText")) {
            aVar.nGF = (String) y.get(".ActivityInfo.StartBtnText");
        }
        if (y.containsKey(".ActivityInfo.ActivityType")) {
            aVar.ktN = bh.getInt((String) y.get(".ActivityInfo.ActivityType"), 0);
        }
        x.d(TAG, "msgInfo:", new Object[]{aVar.toString()});
        return aVar;
    }
}
