package com.tencent.mm.plugin.card.model;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.g.b.ab;
import com.tencent.mm.protocal.c.ke;
import com.tencent.mm.protocal.c.ki;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g extends ab {
    protected static com.tencent.mm.sdk.e.c.a gJc;
    public String kLh = "";
    public String kLi = "";
    public String kLj;
    public String kLk;
    public String kLl;
    public boolean kLm = false;
    public ke kLn;
    public ki kLo;
    public List<a> kLp = null;
    public List<b> kLq = null;
    public int kLr = 0;
    public int kLs = 0;
    public boolean kLt;
    public List<c> kLu = null;

    public class a {
        public String cardId;
        public String kLv;
        public String kLw;
        public int kLx;
        public int kLy;
        final /* synthetic */ g kLz;
        public String title;

        public a(g gVar) {
            this.kLz = gVar;
        }
    }

    public class c {
        public String kLC;
        final /* synthetic */ g kLz;

        public c(g gVar) {
            this.kLz = gVar;
        }
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_type";
        aVar.xjA.put("card_type", "INTEGER");
        stringBuilder.append(" card_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "title";
        aVar.xjA.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "description";
        aVar.xjA.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "logo_url";
        aVar.xjA.put("logo_url", "TEXT");
        stringBuilder.append(" logo_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "time";
        aVar.xjA.put("time", "INTEGER");
        stringBuilder.append(" time INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "card_id";
        aVar.xjA.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "card_tp_id";
        aVar.xjA.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "msg_id";
        aVar.xjA.put("msg_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msg_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "msg_id";
        aVar.columns[8] = "msg_type";
        aVar.xjA.put("msg_type", "INTEGER");
        stringBuilder.append(" msg_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "jump_type";
        aVar.xjA.put("jump_type", "INTEGER");
        stringBuilder.append(" jump_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.xjA.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "buttonData";
        aVar.xjA.put("buttonData", "BLOB");
        stringBuilder.append(" buttonData BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "operData";
        aVar.xjA.put("operData", "BLOB");
        stringBuilder.append(" operData BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "report_scene";
        aVar.xjA.put("report_scene", "INTEGER");
        stringBuilder.append(" report_scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[14] = "read_state";
        aVar.xjA.put("read_state", "INTEGER default '0' ");
        stringBuilder.append(" read_state INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "accept_buttons";
        aVar.xjA.put("accept_buttons", "TEXT");
        stringBuilder.append(" accept_buttons TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "consumed_box_id";
        aVar.xjA.put("consumed_box_id", "TEXT");
        stringBuilder.append(" consumed_box_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "jump_buttons";
        aVar.xjA.put("jump_buttons", "TEXT");
        stringBuilder.append(" jump_buttons TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "logo_color";
        aVar.xjA.put("logo_color", "TEXT");
        stringBuilder.append(" logo_color TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "unavailable_qr_code_list";
        aVar.xjA.put("unavailable_qr_code_list", "TEXT");
        stringBuilder.append(" unavailable_qr_code_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "all_unavailable";
        aVar.xjA.put("all_unavailable", "INTEGER default 'false' ");
        stringBuilder.append(" all_unavailable INTEGER default 'false' ");
        aVar.columns[21] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }

    public final ke auq() {
        if (this.kLn != null) {
            return this.kLn;
        }
        try {
            this.kLn = (ke) new ke().aF(this.field_buttonData);
            return this.kLn;
        } catch (Throwable e) {
            x.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            return new ke();
        }
    }

    public final ki aur() {
        if (this.kLo != null) {
            return this.kLo;
        }
        try {
            this.kLo = (ki) new ki().aF(this.field_operData);
            return this.kLo;
        } catch (Throwable e) {
            x.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            return new ki();
        }
    }

    public final void aus() {
        if (this.kLp == null) {
            this.kLp = new ArrayList();
            if (!bh.ov(this.field_accept_buttons)) {
                Map y = bi.y(this.field_accept_buttons, "accept_buttons_list");
                if (y != null) {
                    int i = 0;
                    while (i < 100) {
                        String str = ".accept_buttons_list.accept_buttons" + (i > 0 ? Integer.valueOf(i) : "");
                        String str2 = (String) y.get(str + ".title");
                        if (!bh.ov((String) y.get(str + ".card_id")) || !bh.ov(str2)) {
                            int i2 = bh.getInt((String) y.get(str + ".end_time"), 0);
                            if (i2 == 0 || ((long) i2) > bh.Wo()) {
                                a aVar = new a(this);
                                aVar.title = (String) y.get(str + ".title");
                                aVar.kLv = (String) y.get(str + ".sub_title");
                                aVar.kLw = (String) y.get(str + ".card_ext");
                                aVar.cardId = (String) y.get(str + ".card_id");
                                aVar.kLy = bh.getInt((String) y.get(str + ".action_type"), 0);
                                aVar.kLx = i2;
                                this.kLp.add(aVar);
                            }
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void aut() {
        if (this.kLq == null) {
            this.kLq = new ArrayList();
            if (!bh.ov(this.field_jump_buttons)) {
                Map y = bi.y(this.field_jump_buttons, "jump_buttons_list");
                if (y != null) {
                    int i = 0;
                    while (i < 100) {
                        String str = ".jump_buttons_list.jump_buttons" + (i > 0 ? Integer.valueOf(i) : "");
                        if (!bh.ov((String) y.get(str + ".title"))) {
                            b bVar = new b(this);
                            bVar.title = (String) y.get(str + ".title");
                            bVar.description = (String) y.get(str + ".description");
                            bVar.kLA = (String) y.get(str + ".button_wording");
                            bVar.kLB = (String) y.get(str + ".jump_url");
                            this.kLq.add(bVar);
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void auu() {
        if (this.kLu == null) {
            this.kLu = new ArrayList();
            if (!bh.ov(this.field_unavailable_qr_code_list)) {
                Map y = bi.y(this.field_unavailable_qr_code_list, "unavailable_qr_code_list");
                if (y != null) {
                    int i = 0;
                    while (i < 100) {
                        String str = ".unavailable_qr_code_list.unavailable_qr_codes" + (i > 0 ? Integer.valueOf(i) : "");
                        if (!bh.ov((String) y.get(str + ".code_id"))) {
                            c cVar = new c(this);
                            cVar.kLC = (String) y.get(str + ".code_id");
                            this.kLu.add(cVar);
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
