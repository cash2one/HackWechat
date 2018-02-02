package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;

public abstract class ab extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fRf = "title".hashCode();
    private static final int fRg = "description".hashCode();
    private static final int fUh = "card_type".hashCode();
    private static final int fUi = "logo_url".hashCode();
    private static final int fUj = "time".hashCode();
    private static final int fUk = "card_id".hashCode();
    private static final int fUl = "card_tp_id".hashCode();
    private static final int fUm = "msg_id".hashCode();
    private static final int fUn = "msg_type".hashCode();
    private static final int fUo = "jump_type".hashCode();
    private static final int fUp = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int fUq = "buttonData".hashCode();
    private static final int fUr = "operData".hashCode();
    private static final int fUs = "report_scene".hashCode();
    private static final int fUt = "read_state".hashCode();
    private static final int fUu = "accept_buttons".hashCode();
    private static final int fUv = "consumed_box_id".hashCode();
    private static final int fUw = "jump_buttons".hashCode();
    private static final int fUx = "logo_color".hashCode();
    private static final int fUy = "unavailable_qr_code_list".hashCode();
    private static final int fUz = "all_unavailable".hashCode();
    private boolean fRb = true;
    private boolean fRc = true;
    private boolean fTO = true;
    private boolean fTP = true;
    private boolean fTQ = true;
    private boolean fTR = true;
    private boolean fTS = true;
    private boolean fTT = true;
    private boolean fTU = true;
    private boolean fTV = true;
    private boolean fTW = true;
    private boolean fTX = true;
    private boolean fTY = true;
    private boolean fTZ = true;
    private boolean fUa = true;
    private boolean fUb = true;
    private boolean fUc = true;
    private boolean fUd = true;
    private boolean fUe = true;
    private boolean fUf = true;
    private boolean fUg = true;
    public String field_accept_buttons;
    public boolean field_all_unavailable;
    public byte[] field_buttonData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_card_type;
    public String field_consumed_box_id;
    public String field_description;
    public String field_jump_buttons;
    public int field_jump_type;
    public String field_logo_color;
    public String field_logo_url;
    public String field_msg_id;
    public int field_msg_type;
    public byte[] field_operData;
    public int field_read_state;
    public int field_report_scene;
    public int field_time;
    public String field_title;
    public String field_unavailable_qr_code_list;
    public String field_url;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fUh == hashCode) {
                    this.field_card_type = cursor.getInt(i);
                } else if (fRf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (fRg == hashCode) {
                    this.field_description = cursor.getString(i);
                } else if (fUi == hashCode) {
                    this.field_logo_url = cursor.getString(i);
                } else if (fUj == hashCode) {
                    this.field_time = cursor.getInt(i);
                } else if (fUk == hashCode) {
                    this.field_card_id = cursor.getString(i);
                } else if (fUl == hashCode) {
                    this.field_card_tp_id = cursor.getString(i);
                } else if (fUm == hashCode) {
                    this.field_msg_id = cursor.getString(i);
                    this.fTT = true;
                } else if (fUn == hashCode) {
                    this.field_msg_type = cursor.getInt(i);
                } else if (fUo == hashCode) {
                    this.field_jump_type = cursor.getInt(i);
                } else if (fUp == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (fUq == hashCode) {
                    this.field_buttonData = cursor.getBlob(i);
                } else if (fUr == hashCode) {
                    this.field_operData = cursor.getBlob(i);
                } else if (fUs == hashCode) {
                    this.field_report_scene = cursor.getInt(i);
                } else if (fUt == hashCode) {
                    this.field_read_state = cursor.getInt(i);
                } else if (fUu == hashCode) {
                    this.field_accept_buttons = cursor.getString(i);
                } else if (fUv == hashCode) {
                    this.field_consumed_box_id = cursor.getString(i);
                } else if (fUw == hashCode) {
                    this.field_jump_buttons = cursor.getString(i);
                } else if (fUx == hashCode) {
                    this.field_logo_color = cursor.getString(i);
                } else if (fUy == hashCode) {
                    this.field_unavailable_qr_code_list = cursor.getString(i);
                } else if (fUz == hashCode) {
                    this.field_all_unavailable = cursor.getInt(i) != 0;
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fTO) {
            contentValues.put("card_type", Integer.valueOf(this.field_card_type));
        }
        if (this.fRb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fRc) {
            contentValues.put("description", this.field_description);
        }
        if (this.fTP) {
            contentValues.put("logo_url", this.field_logo_url);
        }
        if (this.fTQ) {
            contentValues.put("time", Integer.valueOf(this.field_time));
        }
        if (this.fTR) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.fTS) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.fTT) {
            contentValues.put("msg_id", this.field_msg_id);
        }
        if (this.fTU) {
            contentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
        }
        if (this.fTV) {
            contentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
        }
        if (this.fTW) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.fTX) {
            contentValues.put("buttonData", this.field_buttonData);
        }
        if (this.fTY) {
            contentValues.put("operData", this.field_operData);
        }
        if (this.fTZ) {
            contentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
        }
        if (this.fUa) {
            contentValues.put("read_state", Integer.valueOf(this.field_read_state));
        }
        if (this.fUb) {
            contentValues.put("accept_buttons", this.field_accept_buttons);
        }
        if (this.fUc) {
            contentValues.put("consumed_box_id", this.field_consumed_box_id);
        }
        if (this.fUd) {
            contentValues.put("jump_buttons", this.field_jump_buttons);
        }
        if (this.fUe) {
            contentValues.put("logo_color", this.field_logo_color);
        }
        if (this.fUf) {
            contentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
        }
        if (this.fUg) {
            contentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
