package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

public abstract class dy extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int guA = "lct_url".hashCode();
    private static final int guB = "cre_name".hashCode();
    private static final int guC = "lqt_state".hashCode();
    private static final int guD = "paymenu_use_new".hashCode();
    private static final int guE = "is_show_lqb".hashCode();
    private static final int guF = "is_open_lqb".hashCode();
    private static final int guG = "lqb_open_url".hashCode();
    private static final int gun = OpenSDKTool4Assistant.EXTRA_UIN.hashCode();
    private static final int guo = "is_reg".hashCode();
    private static final int gup = "true_name".hashCode();
    private static final int guq = "card_num".hashCode();
    private static final int gur = "isDomesticUser".hashCode();
    private static final int gus = "cre_type".hashCode();
    private static final int gut = "main_card_bind_serialno".hashCode();
    private static final int guu = "ftf_pay_url".hashCode();
    private static final int guv = "switchConfig".hashCode();
    private static final int guw = "reset_passwd_flag".hashCode();
    private static final int gux = "find_passwd_url".hashCode();
    private static final int guy = "is_open_touch".hashCode();
    private static final int guz = "lct_wording".hashCode();
    public int field_card_num;
    public String field_cre_name;
    public int field_cre_type;
    public String field_find_passwd_url;
    public String field_ftf_pay_url;
    public boolean field_isDomesticUser;
    public int field_is_open_lqb;
    public int field_is_open_touch;
    public int field_is_reg;
    public int field_is_show_lqb;
    public String field_lct_url;
    public String field_lct_wording;
    public String field_lqb_open_url;
    public int field_lqt_state;
    public String field_main_card_bind_serialno;
    public int field_paymenu_use_new;
    public String field_reset_passwd_flag;
    public int field_switchConfig;
    public String field_true_name;
    public String field_uin;
    private boolean gtT = true;
    private boolean gtU = true;
    private boolean gtV = true;
    private boolean gtW = true;
    private boolean gtX = true;
    private boolean gtY = true;
    private boolean gtZ = true;
    private boolean gua = true;
    private boolean gub = true;
    private boolean guc = true;
    private boolean gud = true;
    private boolean gue = true;
    private boolean guf = true;
    private boolean gug = true;
    private boolean guh = true;
    private boolean gui = true;
    private boolean guj = true;
    private boolean guk = true;
    private boolean gul = true;
    private boolean gum = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gun == hashCode) {
                    this.field_uin = cursor.getString(i);
                    this.gtT = true;
                } else if (guo == hashCode) {
                    this.field_is_reg = cursor.getInt(i);
                } else if (gup == hashCode) {
                    this.field_true_name = cursor.getString(i);
                } else if (guq == hashCode) {
                    this.field_card_num = cursor.getInt(i);
                } else if (gur == hashCode) {
                    this.field_isDomesticUser = cursor.getInt(i) != 0;
                } else if (gus == hashCode) {
                    this.field_cre_type = cursor.getInt(i);
                } else if (gut == hashCode) {
                    this.field_main_card_bind_serialno = cursor.getString(i);
                } else if (guu == hashCode) {
                    this.field_ftf_pay_url = cursor.getString(i);
                } else if (guv == hashCode) {
                    this.field_switchConfig = cursor.getInt(i);
                } else if (guw == hashCode) {
                    this.field_reset_passwd_flag = cursor.getString(i);
                } else if (gux == hashCode) {
                    this.field_find_passwd_url = cursor.getString(i);
                } else if (guy == hashCode) {
                    this.field_is_open_touch = cursor.getInt(i);
                } else if (guz == hashCode) {
                    this.field_lct_wording = cursor.getString(i);
                } else if (guA == hashCode) {
                    this.field_lct_url = cursor.getString(i);
                } else if (guB == hashCode) {
                    this.field_cre_name = cursor.getString(i);
                } else if (guC == hashCode) {
                    this.field_lqt_state = cursor.getInt(i);
                } else if (guD == hashCode) {
                    this.field_paymenu_use_new = cursor.getInt(i);
                } else if (guE == hashCode) {
                    this.field_is_show_lqb = cursor.getInt(i);
                } else if (guF == hashCode) {
                    this.field_is_open_lqb = cursor.getInt(i);
                } else if (guG == hashCode) {
                    this.field_lqb_open_url = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gtT) {
            contentValues.put(OpenSDKTool4Assistant.EXTRA_UIN, this.field_uin);
        }
        if (this.gtU) {
            contentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
        }
        if (this.gtV) {
            contentValues.put("true_name", this.field_true_name);
        }
        if (this.gtW) {
            contentValues.put("card_num", Integer.valueOf(this.field_card_num));
        }
        if (this.gtX) {
            contentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
        }
        if (this.gtY) {
            contentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
        }
        if (this.gtZ) {
            contentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
        }
        if (this.gua) {
            contentValues.put("ftf_pay_url", this.field_ftf_pay_url);
        }
        if (this.gub) {
            contentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
        }
        if (this.guc) {
            contentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
        }
        if (this.gud) {
            contentValues.put("find_passwd_url", this.field_find_passwd_url);
        }
        if (this.gue) {
            contentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
        }
        if (this.guf) {
            contentValues.put("lct_wording", this.field_lct_wording);
        }
        if (this.gug) {
            contentValues.put("lct_url", this.field_lct_url);
        }
        if (this.guh) {
            contentValues.put("cre_name", this.field_cre_name);
        }
        if (this.gui) {
            contentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
        }
        if (this.guj) {
            contentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
        }
        if (this.guk) {
            contentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
        }
        if (this.gul) {
            contentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
        }
        if (this.gum) {
            contentValues.put("lqb_open_url", this.field_lqb_open_url);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
