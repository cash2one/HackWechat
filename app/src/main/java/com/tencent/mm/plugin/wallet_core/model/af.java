package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.g.b.dy;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.lang.reflect.Field;

public final class af extends dy {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = OpenSDKTool4Assistant.EXTRA_UIN;
        aVar.xjA.put(OpenSDKTool4Assistant.EXTRA_UIN, "TEXT PRIMARY KEY ");
        stringBuilder.append(" uin TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = OpenSDKTool4Assistant.EXTRA_UIN;
        aVar.columns[1] = "is_reg";
        aVar.xjA.put("is_reg", "INTEGER");
        stringBuilder.append(" is_reg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "true_name";
        aVar.xjA.put("true_name", "TEXT");
        stringBuilder.append(" true_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "card_num";
        aVar.xjA.put("card_num", "INTEGER");
        stringBuilder.append(" card_num INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isDomesticUser";
        aVar.xjA.put("isDomesticUser", "INTEGER");
        stringBuilder.append(" isDomesticUser INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "cre_type";
        aVar.xjA.put("cre_type", "INTEGER");
        stringBuilder.append(" cre_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "main_card_bind_serialno";
        aVar.xjA.put("main_card_bind_serialno", "TEXT");
        stringBuilder.append(" main_card_bind_serialno TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "ftf_pay_url";
        aVar.xjA.put("ftf_pay_url", "TEXT");
        stringBuilder.append(" ftf_pay_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "switchConfig";
        aVar.xjA.put("switchConfig", "INTEGER");
        stringBuilder.append(" switchConfig INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "reset_passwd_flag";
        aVar.xjA.put("reset_passwd_flag", "TEXT");
        stringBuilder.append(" reset_passwd_flag TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "find_passwd_url";
        aVar.xjA.put("find_passwd_url", "TEXT");
        stringBuilder.append(" find_passwd_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "is_open_touch";
        aVar.xjA.put("is_open_touch", "INTEGER");
        stringBuilder.append(" is_open_touch INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "lct_wording";
        aVar.xjA.put("lct_wording", "TEXT");
        stringBuilder.append(" lct_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "lct_url";
        aVar.xjA.put("lct_url", "TEXT");
        stringBuilder.append(" lct_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "cre_name";
        aVar.xjA.put("cre_name", "TEXT");
        stringBuilder.append(" cre_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "lqt_state";
        aVar.xjA.put("lqt_state", "INTEGER");
        stringBuilder.append(" lqt_state INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "paymenu_use_new";
        aVar.xjA.put("paymenu_use_new", "INTEGER");
        stringBuilder.append(" paymenu_use_new INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "is_show_lqb";
        aVar.xjA.put("is_show_lqb", "INTEGER");
        stringBuilder.append(" is_show_lqb INTEGER");
        stringBuilder.append(", ");
        aVar.columns[18] = "is_open_lqb";
        aVar.xjA.put("is_open_lqb", "INTEGER");
        stringBuilder.append(" is_open_lqb INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "lqb_open_url";
        aVar.xjA.put("lqb_open_url", "TEXT");
        stringBuilder.append(" lqb_open_url TEXT");
        aVar.columns[20] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final boolean bLJ() {
        return this.field_is_reg == 0;
    }

    public final boolean bLK() {
        return this.field_is_reg == -1;
    }
}
