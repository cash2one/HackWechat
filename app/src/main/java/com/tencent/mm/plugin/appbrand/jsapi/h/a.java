package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

final class a extends c {
    volatile a jpj;
    volatile Long jpk = null;
    volatile Long jpl = null;
    volatile int jpm = -1;
    volatile int jpn = -1;
    volatile int jpo = -1;

    a() {
    }

    final void r(JSONObject jSONObject) {
        Date parse;
        this.jpj = a.sI(jSONObject.optString("fields"));
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            Date parse2 = this.jpj.parse(optJSONObject.optString("start", ""));
            parse = this.jpj.parse(optJSONObject.optString("end", ""));
            if (parse2 != null) {
                this.jpk = Long.valueOf(parse2.getTime());
            }
            if (parse != null) {
                this.jpl = Long.valueOf(parse.getTime());
            }
        }
        if (this.jpk == null) {
            Calendar instance = Calendar.getInstance(w.xfc);
            instance.set(1900, 0, 1);
            this.jpk = Long.valueOf(instance.getTimeInMillis());
        }
        if (this.jpl == null) {
            instance = Calendar.getInstance(w.xfc);
            instance.set(2100, 11, 31);
            this.jpl = Long.valueOf(instance.getTimeInMillis());
        }
        parse = this.jpj.parse(jSONObject.optString("current", ""));
        if (parse == null) {
            parse = new Date(System.currentTimeMillis());
        }
        this.jpm = parse.getYear() + 1900;
        this.jpn = parse.getMonth() + 1;
        this.jpo = parse.getDate();
        c.runOnUiThread(new 1(this));
    }
}
