package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.g.b.dt;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;

public final class t extends dt {
    public static a gJc;
    public ArrayList<MallFunction> okM = new ArrayList();
    private ArrayList<MallNews> okN = new ArrayList();
    private ArrayList<com.tencent.mm.plugin.wallet_core.model.mall.a> okO = new ArrayList();
    public SparseArray<String> okP = new SparseArray();

    static {
        a aVar = new a();
        aVar.hSY = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_region";
        aVar.xjA.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "wallet_region";
        aVar.columns[1] = "function_list";
        aVar.xjA.put("function_list", "TEXT");
        stringBuilder.append(" function_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "new_list";
        aVar.xjA.put("new_list", "TEXT");
        stringBuilder.append(" new_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "banner_list";
        aVar.xjA.put("banner_list", "TEXT");
        stringBuilder.append(" banner_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "type_name_list";
        aVar.xjA.put("type_name_list", "TEXT");
        stringBuilder.append(" type_name_list TEXT");
        aVar.columns[5] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        String str = this.field_function_list;
        String str2 = this.field_new_list;
        String str3 = this.field_banner_list;
        String str4 = this.field_type_name_list;
        try {
            if (!bh.ov(str)) {
                this.okM = b.y(new JSONArray(str));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e, "", new Object[0]);
        }
        try {
            if (!bh.ov(str2)) {
                this.okN = b.v(new JSONArray(str2));
            }
        } catch (Throwable e2) {
            this.okN = null;
            x.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e2, "", new Object[0]);
        }
        try {
            if (!bh.ov(str3)) {
                this.okO = b.w(new JSONArray(str3));
            }
        } catch (Throwable e22) {
            this.okO = null;
            x.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e22, "", new Object[0]);
        }
        try {
            if (!bh.ov(str4)) {
                this.okP = b.x(new JSONArray(str4));
            }
        } catch (Throwable e222) {
            this.okP = null;
            x.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e222, "", new Object[0]);
        }
    }
}
