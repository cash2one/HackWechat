package com.tencent.mm.ui.chatting.f.a;

import android.text.Spannable;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.chatting.f.a.a$b.b;
import com.tencent.mm.ui.chatting.f.a.a$b.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONException;
import org.json.JSONObject;

class a$b$a$a implements b {
    private a$b$a$a() {
    }

    public final c a(Object obj, Spannable spannable) {
        String az;
        String substring = spannable.toString().substring(spannable.getSpanStart(obj), spannable.getSpanEnd(obj));
        try {
            az = bh.az(new JSONObject(obj.toString()).optString(DownloadSettingTable$Columns.TYPE), obj.getClass().getName());
        } catch (JSONException e) {
            az = obj.getClass().getName();
        }
        return new c(substring, az);
    }
}
