package com.tencent.mm.plugin.scanner.util;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.Map;

public class n$a {
    public String field_certification;
    public String field_certificationurl;
    public String field_detailurl;
    public String field_exposeurl;
    public String field_extinfo;
    public String field_feedbackurl;
    public int field_functionType;
    public int field_getaction;
    public String field_headerbackgroundurl;
    public String field_headermask;
    public String field_introlink;
    public String field_introtitle;
    public String field_playurl;
    public String field_productid;
    public String field_shareurl;
    public String field_source;
    public String field_subtitle;
    public String field_thumburl;
    public String field_title;
    public int field_type;
    public String field_xml;
    public int field_xmlType;
    public LinkedList<com.tencent.mm.plugin.scanner.a.a> qbc;
    public a qbd;

    public static class a {
        public LinkedList<a> qbe;
        public LinkedList<b> qbf;
    }

    public final void n(Map<String, String> map, String str) {
        if (map != null) {
            String str2;
            this.qbd = new a();
            this.qbd.qbe = new LinkedList();
            String str3 = str + ".bannerlist.banner";
            int i = 0;
            while (i < 1000) {
                str2 = (String) map.get((str3 + (i > 0 ? Integer.valueOf(i) : "")) + ".link");
                if (bh.ov(str2)) {
                    break;
                }
                a aVar = new a();
                aVar.hOf = str2;
                this.qbd.qbe.add(aVar);
                i++;
            }
            this.qbd.qbf = new LinkedList();
            str3 = str + ".detaillist.detail";
            i = 0;
            while (i < 1000) {
                String str4 = str3 + (i > 0 ? Integer.valueOf(i) : "");
                str2 = (String) map.get(str4 + ".title");
                str4 = (String) map.get(str4 + ".desc");
                if (!bh.ov(str2) || !bh.ov(str4)) {
                    b bVar = new b();
                    bVar.title = str2;
                    bVar.desc = str4;
                    this.qbd.qbf.add(bVar);
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
