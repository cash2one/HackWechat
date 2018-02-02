package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.e;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class as extends a {
    public static final int CTRL_BYTE = 77;
    public static final String NAME = "setCloseWindowConfirmDialogInfo";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiSetCloseWindowConfirmDialogInfo", "invoke");
        if (jSONObject == null) {
            x.e("MicroMsg.GameJsApiSetCloseWindowConfirmDialogInfo", "data is null");
            dVar.E(i, a.e("setCloseWindowConfirmDialogInfo:fail_invalid_data", null));
            return;
        }
        Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("switch"));
        String optString = jSONObject.optString("title_cn");
        String optString2 = jSONObject.optString("title_eng");
        String optString3 = jSONObject.optString("ok_cn");
        String optString4 = jSONObject.optString("ok_eng");
        String optString5 = jSONObject.optString("cancel_cn");
        String optString6 = jSONObject.optString("cancel_eng");
        e eVar = dVar.mYI;
        if (eVar != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("close_window_confirm_dialog_switch", valueOf.booleanValue());
            bundle.putString("close_window_confirm_dialog_title_cn", optString);
            bundle.putString("close_window_confirm_dialog_title_eng", optString2);
            bundle.putString("close_window_confirm_dialog_ok_cn", optString3);
            bundle.putString("close_window_confirm_dialog_ok_eng", optString4);
            bundle.putString("close_window_confirm_dialog_cancel_cn", optString5);
            bundle.putString("close_window_confirm_dialog_cancel_eng", optString6);
            eVar.B(bundle);
            dVar.E(i, a.e("setCloseWindowConfirmDialogInfo:ok", null));
        }
    }
}
