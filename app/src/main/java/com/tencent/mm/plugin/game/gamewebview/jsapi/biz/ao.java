package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ao extends a {
    public static final int CTRL_BYTE = 301;
    public static final String NAME = "reportGamePageTime";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("reportId");
        boolean equals = bh.ou(jSONObject.optString("reportInstantly")).equals("1");
        boolean equals2 = bh.ou(jSONObject.optString("reportTimeBegin")).equals("1");
        String optString2 = jSONObject.optString("reportFormatData");
        String optString3 = jSONObject.optString("reportTabsFormatData");
        if (bh.ov(optString)) {
            x.e("MicroMsg.GameJsApiReportGamePageTime", "reportId is null or nil");
            dVar.E(i, a.e("reportGamePageTime:fail_invalid_reportId", null));
        }
        if (bh.ov(optString2) && bh.ov(optString3)) {
            x.e("MicroMsg.GameJsApiReportGamePageTime", "reportFormatData && reportTabsFormatData is null or nil");
            dVar.E(i, a.e("reportGamePageTime:fail_invalid_reportFormatData_reportTabsFormatData", null));
        }
        x.i("MicroMsg.GameJsApiReportGamePageTime", "reportGamePageTime, reportId:%s, reportInstantly:%b, reportTimeBegin:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[]{optString, Boolean.valueOf(equals), Boolean.valueOf(equals2), optString2, optString3});
        Bundle bundle = new Bundle();
        bundle.putString("game_page_report_id", optString);
        bundle.putBoolean("game_page_report_instantly", equals);
        bundle.putBoolean("game_page_report_time_begin", equals2);
        bundle.putString("game_page_report_format_data", optString2);
        bundle.putString("game_page_report_tabs_format_data", optString3);
        dVar.mZw.tFt.Z(bundle);
        dVar.E(i, a.e("reportGamePageTime:ok", null));
    }
}
