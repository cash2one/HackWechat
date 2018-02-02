package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.g.b.du;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.lang.reflect.Field;
import org.json.JSONObject;

public final class x extends du {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_tpa_country";
        aVar.xjA.put("wallet_tpa_country", "TEXT PRIMARY KEY ");
        stringBuilder.append(" wallet_tpa_country TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "wallet_tpa_country";
        aVar.columns[1] = "wallet_type";
        aVar.xjA.put("wallet_type", "INTEGER");
        stringBuilder.append(" wallet_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "wallet_name";
        aVar.xjA.put("wallet_name", "TEXT");
        stringBuilder.append(" wallet_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "wallet_selected";
        aVar.xjA.put("wallet_selected", "INTEGER");
        stringBuilder.append(" wallet_selected INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "wallet_balance";
        aVar.xjA.put("wallet_balance", "INTEGER");
        stringBuilder.append(" wallet_balance INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "wallet_tpa_country_mask";
        aVar.xjA.put("wallet_tpa_country_mask", "INTEGER");
        stringBuilder.append(" wallet_tpa_country_mask INTEGER");
        aVar.columns[6] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public static x ab(JSONObject jSONObject) {
        if (jSONObject == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WalletKindInfo", "json is null");
            return null;
        }
        x xVar = new x();
        xVar.field_wallet_tpa_country = jSONObject.optString("wallet_tpa_country");
        xVar.field_wallet_name = jSONObject.optString("wallet_name");
        xVar.field_wallet_selected = jSONObject.optInt("wallet_selected");
        xVar.field_wallet_type = jSONObject.optInt("wallet_type");
        xVar.field_wallet_balance = jSONObject.optInt("wallet_balance");
        xVar.field_wallet_tpa_country_mask = jSONObject.optInt("wallet_tpa_country_mask");
        if (!bh.ov(xVar.field_wallet_tpa_country)) {
            return xVar;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WalletKindInfo", "wallet_id is illegal");
        return null;
    }
}
