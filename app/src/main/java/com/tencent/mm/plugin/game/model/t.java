package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.b.bl;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class t extends bl {
    protected static a gJc;
    public String lBk = "";
    public String mAppName = "";
    public a ncA = new a();
    public String ncB = "";
    public String ncC = "";
    public String ncD = "";
    public String ncE = "";
    public String ncF = "";
    public String ncG = "";
    public String ncH = "";
    public String ncI;
    public String ncJ;
    public String ncK;
    public String ncL;
    public String ncM;
    public f ncN;
    public e ncO = new e();
    public g ncP = new g();
    public i ncQ = new i();
    public int ncR;
    public int ncS;
    public String ncT;
    public int ncU = 0;
    public String ncV = "";
    public boolean ncW = false;
    private boolean nca = false;
    public String ncb = "";
    public String ncc = "";
    public String ncd = "";
    public String nce = "";
    public String ncf = "";
    public int ncg = 0;
    public String nch = "";
    public String nci = "";
    public LinkedList<h> ncj = new LinkedList();
    public boolean nck;
    public c ncl = new c();
    public boolean ncm;
    public b ncn = new b();
    public HashMap<String, d> nco = new HashMap();
    public String ncp = "";
    public int ncq = 0;
    public int ncr = 0;
    public int ncs = 0;
    public String nct = "";
    public String ncu = "";
    public String ncv = "";
    public int ncw = 0;
    public long ncx = 0;
    public long ncy = 0;
    public int ncz = 0;

    public static class b {
        public String gAT;
        public String ncY;
        public String ncZ;
    }

    public static class i {
        public int kOC = 0;
        public String ndl;
        public long ndm = 0;
    }

    public final void aQm() {
        if (!this.nca) {
            if (this.field_msgType != 100) {
                if (this != null) {
                    if (!bh.ov(this.field_rawXML)) {
                        Map y = bi.y(this.field_rawXML, "sysmsg");
                        if (y != null && y.size() != 0) {
                            if ("gamecenter".equalsIgnoreCase((String) y.get(".sysmsg.$type"))) {
                                this.ncw = bh.getInt((String) y.get(".sysmsg.gamecenter.wifi_flag"), 0);
                                this.lBk = v.y(y);
                                this.ncb = bh.az((String) y.get(".sysmsg.gamecenter.url"), "");
                                this.ncp = bh.az((String) y.get(".sysmsg.gamecenter.msg_picture_url"), "");
                                this.ncc = bh.az((String) y.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
                                if (bh.ov(this.ncc)) {
                                    this.ncc = bh.az((String) y.get(".sysmsg.gamecenter.url"), "");
                                }
                                this.ncR = bh.getInt((String) y.get(".sysmsg.gamecenter.notify_type"), 0);
                                this.mAppName = bh.az((String) y.get(".sysmsg.gamecenter.appinfo.appname2"), "");
                                if (bh.ov(this.mAppName)) {
                                    this.mAppName = bh.az((String) y.get(".sysmsg.gamecenter.appinfo.appname"), "");
                                }
                                if (this.field_msgType == 6) {
                                    this.nch = bh.az((String) y.get(".sysmsg.gamecenter.appinfo.groupname"), "");
                                    this.nci = bh.az((String) y.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
                                } else {
                                    this.nch = this.mAppName;
                                }
                                this.ncd = bh.az((String) y.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
                                this.nce = bh.az((String) y.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
                                this.ncf = bh.az((String) y.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
                                this.ncg = bh.getInt((String) y.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
                                v.a(y, this);
                                this.ncT = bh.az((String) y.get(".sysmsg.gamecenter.noticeid"), "");
                                this.ncx = v.z(y);
                                this.ncl.nda = bh.getInt((String) y.get(".sysmsg.gamecenter.badge_display_type"), 0);
                                this.ncl.ncY = bh.az((String) y.get(".sysmsg.gamecenter.showiconurl"), "");
                                this.ncl.jUJ = bh.az((String) y.get(".sysmsg.gamecenter.entrancetext"), "");
                                v.b(y, this);
                                this.ncq = bh.getInt((String) y.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
                                this.ncn.ncY = bh.az((String) y.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
                                this.ncn.gAT = bh.az((String) y.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
                                this.ncU = bh.getInt((String) y.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
                                this.ncV = bh.az((String) y.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
                                switch (this.field_msgType) {
                                    case 2:
                                        this.ncr = bh.getInt((String) y.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
                                        this.ncs = bh.getInt((String) y.get(".sysmsg.game_control_info.display_name_type"), 1);
                                        this.nct = bh.az((String) y.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
                                        this.ncu = bh.az((String) y.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
                                        this.ncv = bh.az((String) y.get(".sysmsg.gameshare.share_message_info.media_url"), "");
                                        this.ncp = bh.az((String) y.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
                                        x.i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", new Object[]{this.field_appId});
                                        break;
                                    case 4:
                                    case 10:
                                    case 11:
                                        break;
                                    case 5:
                                        this.ncF = bh.az((String) y.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
                                        this.ncG = bh.az((String) y.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
                                        this.ncH = bh.az((String) y.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
                                        break;
                                    case 6:
                                        this.ncB = bh.az((String) y.get(".sysmsg.gamecenter.topic.reply_content"), "");
                                        this.ncC = bh.az((String) y.get(".sysmsg.gamecenter.topic.replied_content"), "");
                                        this.ncE = bh.az((String) y.get(".sysmsg.gamecenter.topic.topic_title"), "");
                                        this.ncD = bh.az((String) y.get(".sysmsg.gamecenter.topic.topic_url"), "");
                                        break;
                                    default:
                                        x.e("MicroMsg.GameMessageParser", "error gamecenter type: " + this.field_msgType);
                                        break;
                                }
                            }
                            x.e("MicroMsg.GameMessageParser", "Type not matched");
                        } else {
                            x.e("MicroMsg.GameMessageParser", "Parse failed");
                        }
                    } else {
                        x.e("MicroMsg.GameMessageParser", "msg content is null");
                    }
                } else {
                    x.e("MicroMsg.GameMessageParser", "msg is null");
                }
            } else {
                aa.aQy();
                if (this == null) {
                    x.e("MicroMsg.GameNewMessageParser", "msg is null");
                } else if (bh.ov(this.field_rawXML)) {
                    x.e("MicroMsg.GameNewMessageParser", "msg content is null");
                } else {
                    Map y2 = bi.y(this.field_rawXML, "sysmsg");
                    if (y2 == null || y2.size() == 0) {
                        x.e("MicroMsg.GameNewMessageParser", "Parse failed");
                    } else if ("gamecenter".equalsIgnoreCase((String) y2.get(".sysmsg.$type"))) {
                        this.ncI = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
                        this.ncJ = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
                        this.ncK = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
                        this.ncO.ndc = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
                        this.ncO.ncY = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
                        this.ncO.ncZ = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
                        this.ncL = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
                        this.ncM = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
                        if (y2.get(".sysmsg.gamecenter.msg_center.msg_sender") != null) {
                            this.ncN = new f();
                            this.ncN.ndd = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
                            this.ncN.nde = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
                            this.ncN.ndf = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
                            this.ncN.ncZ = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
                        }
                        this.ncj.clear();
                        String str = ".sysmsg.gamecenter.msg_center.userinfo";
                        int i = 0;
                        while (true) {
                            String str2 = i == 0 ? str : str + i;
                            if (!y2.containsKey(str2)) {
                                break;
                            }
                            h hVar = new h();
                            hVar.userName = bh.az((String) y2.get(str2 + ".username"), "");
                            hVar.bgo = bh.az((String) y2.get(str2 + ".nickname"), "");
                            hVar.ndh = bh.az((String) y2.get(str2 + ".usericon"), "");
                            hVar.ndj = bh.az((String) y2.get(str2 + ".badge_icon"), "");
                            hVar.ndk = bh.az((String) y2.get(str2 + ".$jump_id"), "");
                            this.ncj.add(hVar);
                            i++;
                        }
                        this.ncP.mName = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
                        this.ncP.ndg = bh.getInt((String) y2.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0;
                        this.ncP.ncZ = bh.az((String) y2.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
                        aa.c(y2, this);
                        aa.d(y2, this);
                        this.ncn.ncY = bh.az((String) y2.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
                        this.ncn.gAT = bh.az((String) y2.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
                        this.ncn.ncZ = bh.az((String) y2.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
                        aa.e(y2, this);
                        this.ncl.nda = bh.getInt((String) y2.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
                        this.ncl.ncY = bh.az((String) y2.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                        this.ncl.jUJ = bh.az((String) y2.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
                        this.ncQ.ndl = bh.az((String) y2.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                        this.ncQ.kOC = bh.getInt((String) y2.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                        this.ncQ.ndm = bh.getLong((String) y2.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0);
                        this.ncw = bh.getInt((String) y2.get(".sysmsg.gamecenter.wifi_flag"), 0);
                    } else {
                        x.e("MicroMsg.GameNewMessageParser", "Type not matched");
                    }
                }
            }
            this.nca = true;
        }
    }

    static {
        a aVar = new a();
        aVar.hSY = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xjA.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "msgId";
        aVar.columns[1] = "mergerId";
        aVar.xjA.put("mergerId", "TEXT");
        stringBuilder.append(" mergerId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "gameMsgId";
        aVar.xjA.put("gameMsgId", "TEXT");
        stringBuilder.append(" gameMsgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "msgType";
        aVar.xjA.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.xjA.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "expireTime";
        aVar.xjA.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "showInMsgList";
        aVar.xjA.put("showInMsgList", "INTEGER default 'true' ");
        stringBuilder.append(" showInMsgList INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "isRead";
        aVar.xjA.put("isRead", "INTEGER default 'false' ");
        stringBuilder.append(" isRead INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "label";
        aVar.xjA.put("label", "TEXT default '' ");
        stringBuilder.append(" label TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "isHidden";
        aVar.xjA.put("isHidden", "INTEGER default 'false' ");
        stringBuilder.append(" isHidden INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "weight";
        aVar.xjA.put("weight", "TEXT default '' ");
        stringBuilder.append(" weight TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "rawXML";
        aVar.xjA.put("rawXML", "TEXT default '' ");
        stringBuilder.append(" rawXML TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "receiveTime";
        aVar.xjA.put("receiveTime", "LONG default '0' ");
        stringBuilder.append(" receiveTime LONG default '0' ");
        aVar.columns[14] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
