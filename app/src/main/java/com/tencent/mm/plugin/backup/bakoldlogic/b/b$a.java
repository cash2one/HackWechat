package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class b$a {
    public static String kmR = "]]>";
    public static String kmS = "<msg>";
    public static String kmT = "</msg>";

    public static String vr(String str) {
        l vL = ((a) g.h(a.class)).vL(str);
        a aVar = new a(str);
        if (aVar.kmV) {
            String str2;
            String str3;
            String str4;
            b bVar = new b();
            List list = vL.hdX;
            Map hashMap = new HashMap();
            bVar.vs("msg");
            hashMap.put("appid", (String) aVar.kmU.get(".msg.appmsg.$appid"));
            hashMap.put("sdkver", (String) aVar.kmU.get(".msg.appmsg.$sdkver"));
            bVar.g("appmsg", hashMap);
            if (list == null) {
                list = new LinkedList();
            }
            if (list.size() == 0) {
                str2 = "";
                str3 = "";
                str4 = "";
            } else {
                str3 = ((m) list.get(0)).title;
                str4 = ((m) list.get(0)).url;
                str2 = ((m) list.get(0)).hed;
                str2 = str3;
                str3 = str4;
                str4 = ((m) list.get(0)).hef;
            }
            bVar.bG("title", str2);
            bVar.bG("des", (String) aVar.kmU.get(".msg.appmsg.des"));
            bVar.bG("action", (String) aVar.kmU.get(".msg.appmsg.action"));
            bVar.aS(DownloadSettingTable$Columns.TYPE, aVar.getInt(".msg.appmsg.type"));
            bVar.aS("showtype", aVar.getInt(".msg.appmsg.showtype"));
            bVar.bG("content", (String) aVar.kmU.get(".msg.appmsg.content"));
            bVar.bG(SlookSmartClipMetaTag.TAG_TYPE_URL, str3);
            bVar.bG("lowurl", (String) aVar.kmU.get(".msg.appmsg.lowurl"));
            bVar.vs("appattach");
            bVar.aS("totallen", aVar.getInt(".msg.appmsg.appattach.totallen"));
            bVar.bG("attachid", (String) aVar.kmU.get(".msg.appmsg.appattach.attachid"));
            bVar.bG("fileext", (String) aVar.kmU.get(".msg.appmsg.appattach.fileext"));
            bVar.vt("appattach");
            bVar.vs("mmreader");
            hashMap.put(DownloadSettingTable$Columns.TYPE, vL.type);
            hashMap.put("convMsgCount", list.size());
            bVar.g("category", hashMap);
            bVar.bG("name", vL.fGA);
            bVar.vs("topnew");
            bVar.bG("cover", (String) aVar.kmU.get(".msg.appmsg.mmreader.category.topnew.cover"));
            bVar.bG("width", (String) aVar.kmU.get(".msg.appmsg.mmreader.category.topnew.width"));
            bVar.bG("height", (String) aVar.kmU.get(".msg.appmsg.mmreader.category.topnew.height"));
            bVar.bG("digest", str4);
            bVar.vt("topnew");
            int i = 0;
            while (i < list.size()) {
                bVar.vs("item");
                if (list.get(i) != null) {
                    str3 = ((m) list.get(i)).title;
                    String str5 = ((m) list.get(i)).url;
                    String str6 = ((m) list.get(i)).heb;
                    String str7 = ((m) list.get(i)).hec;
                    String str8 = ((m) list.get(i)).time;
                    String str9 = ((m) list.get(i)).hed;
                    String str10 = ((m) list.get(i)).hee;
                    str2 = ((m) list.get(i)).hef;
                    bVar.bG("title", str3);
                    bVar.bG(SlookSmartClipMetaTag.TAG_TYPE_URL, str5);
                    bVar.bG("shorturl", str6);
                    bVar.bG("longurl", str7);
                    bVar.bG("pub_time", str8);
                    bVar.bG("cover", str9);
                    bVar.bG("tweetid", str10);
                    bVar.bG("digest", str2);
                    bVar.bG("fileid", (String) aVar.kmU.get((".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i))) + ".fileid"));
                    bVar.vs("source");
                    bVar.vs("source");
                    bVar.bG("name", vL.fGA);
                    bVar.vt("source");
                    bVar.vt("source");
                    bVar.vt("item");
                }
                i++;
            }
            bVar.vt("category");
            bVar.vs(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
            bVar.bG("convName", vL.fGz);
            bVar.bG("nickname", vL.fGA);
            bVar.vt(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
            bVar.vt("mmreader");
            bVar.vt("appmsg");
            bVar.bG("fromusername", vL.fGz);
            bVar.aS("scene", aVar.getInt(".msg.scene"));
            bVar.vs("appinfo");
            bVar.bG("version", (String) aVar.kmU.get(".msg.appinfo.appname"));
            bVar.bG("appname", (String) aVar.kmU.get(".msg.appinfo.version"));
            bVar.vt("appinfo");
            bVar.bG("commenturl", vL.gjD);
            bVar.vt("msg");
            x.d("MicroMsg.AppmsgConvert", "xml " + bVar.kmW.toString());
            return bVar.kmW.toString();
        }
        x.e("MicroMsg.AppmsgConvert", "buffer error");
        return "";
    }
}
