package com.tencent.mm.plugin.card.a;

import android.database.Cursor;
import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class l {
    private List<WeakReference<a>> kIv = new ArrayList();
    public List<g> kJF = new ArrayList();
    public int kJG = 0;

    public l() {
        loadFromDB();
        ar.Hg();
        Object obj = c.CU().get(139268, null);
        this.kJG = obj == null ? 0 : ((Integer) obj).intValue();
    }

    public final void a(g gVar) {
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.a(gVar);
                    }
                }
            }
        }
    }

    public final void asi() {
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.asi();
                    }
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.kIv == null) {
            this.kIv = new ArrayList();
        }
        if (aVar != null) {
            this.kIv.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.kIv != null && aVar != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.kIv.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }

    public static void c(g gVar) {
        if (!am.auC().b(gVar)) {
            x.e("MicroMsg.CardMsgManager", "insert CardMsgInfo failed! id:" + gVar.field_msg_id);
        }
    }

    private void loadFromDB() {
        Cursor Tj = am.auC().Tj();
        if (Tj != null && Tj.getCount() > 0) {
            Tj.moveToFirst();
            int columnIndex = Tj.getColumnIndex("card_type");
            int columnIndex2 = Tj.getColumnIndex("title");
            int columnIndex3 = Tj.getColumnIndex("description");
            int columnIndex4 = Tj.getColumnIndex("logo_url");
            int columnIndex5 = Tj.getColumnIndex("time");
            int columnIndex6 = Tj.getColumnIndex("card_id");
            int columnIndex7 = Tj.getColumnIndex("card_tp_id");
            int columnIndex8 = Tj.getColumnIndex("msg_id");
            int columnIndex9 = Tj.getColumnIndex("msg_type");
            int columnIndex10 = Tj.getColumnIndex("jump_type");
            int columnIndex11 = Tj.getColumnIndex(SlookSmartClipMetaTag.TAG_TYPE_URL);
            int columnIndex12 = Tj.getColumnIndex("buttonData");
            int columnIndex13 = Tj.getColumnIndex("operData");
            int columnIndex14 = Tj.getColumnIndex("report_scene");
            int columnIndex15 = Tj.getColumnIndex("read_state");
            while (!Tj.isAfterLast()) {
                g gVar = new g();
                gVar.field_card_type = Tj.getInt(columnIndex);
                gVar.field_title = Tj.getString(columnIndex2);
                gVar.field_description = Tj.getString(columnIndex3);
                gVar.field_logo_url = Tj.getString(columnIndex4);
                gVar.field_time = Tj.getInt(columnIndex5);
                gVar.field_card_id = Tj.getString(columnIndex6);
                gVar.field_card_tp_id = Tj.getString(columnIndex7);
                gVar.field_msg_id = Tj.getString(columnIndex8);
                gVar.field_msg_type = Tj.getInt(columnIndex9);
                gVar.field_jump_type = Tj.getInt(columnIndex10);
                gVar.field_url = Tj.getString(columnIndex11);
                gVar.field_buttonData = Tj.getBlob(columnIndex12);
                gVar.field_operData = Tj.getBlob(columnIndex13);
                gVar.field_report_scene = Tj.getInt(columnIndex14);
                gVar.field_read_state = Tj.getInt(columnIndex15);
                Tj.moveToNext();
                this.kJF.add(gVar);
            }
        }
        if (Tj != null) {
            Tj.close();
        }
    }

    public static String h(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 100) {
            String str2 = str + ".jump_buttons" + (i > 0 ? Integer.valueOf(i) : "");
            if (bh.ov((String) map.get(str2 + ".title"))) {
                break;
            }
            stringBuilder.append("<jump_buttons>");
            stringBuilder.append("<title>" + bh.VG(bh.ou((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<description>" + bh.VG(bh.ou((String) map.get(str2 + ".description"))) + "</description>");
            stringBuilder.append("<button_wording>" + bh.VG(bh.ou((String) map.get(str2 + ".button_wording"))) + "</button_wording>");
            stringBuilder.append("<jump_url>" + bh.VG(bh.ou((String) map.get(str2 + ".jump_url"))) + "</jump_url>");
            stringBuilder.append("</jump_buttons>");
            i++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bh.ov(stringBuilder.toString())) {
            stringBuilder2.append("<jump_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</jump_buttons_list>");
        }
        return stringBuilder2.toString();
    }

    public static String i(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 100) {
            String str2 = str + ".accept_buttons" + (i > 0 ? Integer.valueOf(i) : "");
            String str3 = (String) map.get(str2 + ".title");
            if (bh.ov((String) map.get(str2 + ".card_id")) && bh.ov(str3)) {
                break;
            }
            stringBuilder.append("<accept_buttons>");
            stringBuilder.append("<title>" + bh.VG(bh.ou((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<sub_title>" + bh.VG(bh.ou((String) map.get(str2 + ".sub_title"))) + "</sub_title>");
            stringBuilder.append("<card_id>" + bh.VG(bh.ou((String) map.get(str2 + ".card_id"))) + "</card_id>");
            stringBuilder.append("<card_ext>" + bh.VG(bh.ou((String) map.get(str2 + ".card_ext"))) + "</card_ext>");
            stringBuilder.append("<end_time>" + bh.VG(bh.ou((String) map.get(str2 + ".end_time"))) + "</end_time>");
            stringBuilder.append("<action_type>" + bh.VG(bh.ou((String) map.get(str2 + ".action_type"))) + "</action_type>");
            stringBuilder.append("</accept_buttons>");
            i++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bh.ov(stringBuilder.toString())) {
            stringBuilder2.append("<accept_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</accept_buttons_list>");
        }
        return stringBuilder2.toString();
    }

    public static String j(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 100) {
            String str2 = str + ".unavailable_qr_code_list" + (i > 0 ? Integer.valueOf(i) : "");
            if (bh.ov((String) map.get(str2 + ".code_id"))) {
                break;
            }
            stringBuilder.append("<unavailable_qr_codes>");
            stringBuilder.append("<code_id>" + bh.VG(bh.ou((String) map.get(str2 + ".code_id"))) + "</code_id>");
            stringBuilder.append("</unavailable_qr_codes>");
            i++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bh.ov(stringBuilder.toString())) {
            stringBuilder2.append("<unavailable_qr_code_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</unavailable_qr_code_list>");
        }
        return stringBuilder2.toString();
    }

    public final boolean wb(String str) {
        if (this.kJF == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.kJF.size(); i++) {
            g gVar = (g) this.kJF.get(i);
            if (gVar != null && gVar.field_msg_id != null && gVar.field_msg_id.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean wc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        g gVar;
        if (this.kJF == null || TextUtils.isEmpty(str)) {
            gVar = null;
        } else {
            for (int i = 0; i < this.kJF.size(); i++) {
                gVar = (g) this.kJF.get(i);
                if (str.equals(gVar.field_msg_id)) {
                    break;
                }
            }
            gVar = null;
        }
        if (gVar == null) {
            return false;
        }
        this.kJF.remove(gVar);
        d(gVar);
        return true;
    }

    public static boolean d(g gVar) {
        boolean z = false;
        if (gVar != null) {
            z = am.auC().a(gVar, new String[0]);
            if (!z) {
                x.e("MicroMsg.CardMsgManager", "delete CardMsgInfo failed! id:" + gVar.field_msg_id);
            }
        }
        return z;
    }

    public final void aun() {
        this.kJG = 0;
        ar.Hg();
        c.CU().set(139268, Integer.valueOf(this.kJG));
    }

    public static void auo() {
        x.i("MicroMsg.CardMsgManager", "clearRedDotAndWording()");
        e.post(new 1(), "clearRedDotAndWording");
    }
}
