package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;

public class q$b {
    public String fLC;
    public String hcc;
    public String heb;
    public String hec;
    public String hed;
    public String hee;
    public String hef;
    public long time;
    public String title;
    public int type;
    public String url;

    public static q$b ay(Map<String, String> map) {
        q$b com_tencent_mm_ui_chatting_viewitems_q_b = new q$b();
        com_tencent_mm_ui_chatting_viewitems_q_b.title = (String) map.get(".msg.appmsg.mmreader.category.item.title");
        com_tencent_mm_ui_chatting_viewitems_q_b.url = (String) map.get(".msg.appmsg.mmreader.category.item.url");
        com_tencent_mm_ui_chatting_viewitems_q_b.fLC = (String) map.get(".msg.appmsg.mmreader.category.item.native_url");
        com_tencent_mm_ui_chatting_viewitems_q_b.heb = (String) map.get(".msg.appmsg.mmreader.category.item.shorturl");
        com_tencent_mm_ui_chatting_viewitems_q_b.hec = (String) map.get(".msg.appmsg.mmreader.category.item.longurl");
        com_tencent_mm_ui_chatting_viewitems_q_b.time = bh.getLong((String) map.get(".msg.appmsg.mmreader.category.item.pub_time"), 0);
        com_tencent_mm_ui_chatting_viewitems_q_b.hed = (String) map.get(".msg.appmsg.mmreader.category.item.cover");
        com_tencent_mm_ui_chatting_viewitems_q_b.hee = (String) map.get(".msg.appmsg.mmreader.category.item.tweetid");
        com_tencent_mm_ui_chatting_viewitems_q_b.hef = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
        com_tencent_mm_ui_chatting_viewitems_q_b.type = bh.getInt((String) map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
        com_tencent_mm_ui_chatting_viewitems_q_b.hcc = (String) map.get(".msg.appmsg.template_id");
        return com_tencent_mm_ui_chatting_viewitems_q_b;
    }
}
