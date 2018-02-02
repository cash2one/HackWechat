package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    long mStartTime = 0;
    long nlI = 0;
    long nlJ = 0;
    private long tFr = 0;
    Bundle tFs;
    public a tFt = new a(this);

    public static /* synthetic */ void a(c cVar) {
        if (cVar.mStartTime != 0) {
            cVar.tFr = System.currentTimeMillis() - cVar.mStartTime;
            x.i("MicroMsg.GamePageTimeReport", "visit page(%s), stayTime:%sms, foregroundTime:%sms", new Object[]{Integer.valueOf(cVar.hashCode()), Long.valueOf(cVar.tFr), Long.valueOf(cVar.nlI)});
            if (cVar.tFs == null) {
                x.i("MicroMsg.GamePageTimeReport", "report game page time fail. ReportData is null");
                return;
            }
            String string = cVar.tFs.getString("game_page_report_format_data");
            String string2 = cVar.tFs.getString("game_page_report_tabs_format_data");
            if (!bh.ov(string)) {
                cVar.tFs.putString("game_page_report_format_data", string.replace("__ALLSTAYTIME__", String.valueOf(cVar.tFr / 1000)).replace("__FOREGROUNDTIME__", String.valueOf(cVar.nlI / 1000)));
                x.i("MicroMsg.GamePageTimeReport", "visit page(%s), after replace time, reportFormatData:%s", new Object[]{Integer.valueOf(cVar.hashCode()), string});
            } else if (!bh.ov(string2)) {
                string = cVar.PA(string2);
                if (!bh.ov(string)) {
                    cVar.tFs.putString("game_page_report_tabs_format_data", string);
                    x.i("MicroMsg.GamePageTimeReport", "visit page(%s), after replace time, reportTabsFormatdata:%s", new Object[]{Integer.valueOf(cVar.hashCode()), string});
                } else {
                    return;
                }
            } else {
                return;
            }
            if (ac.cfw()) {
                Y(cVar.tFs);
            } else {
                cVar.A(cVar.tFs);
            }
            cVar.tFs = null;
        }
    }

    public static void Y(Bundle bundle) {
        if (bundle != null) {
            Set<String> keySet = bundle.keySet();
            if (keySet != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str : keySet) {
                        jSONObject.put(str, bundle.get(str));
                    }
                    b gnVar = new gn();
                    gnVar.fwD.pK = 4;
                    gnVar.fwD.fwF = jSONObject.toString();
                    a.xef.m(gnVar);
                } catch (JSONException e) {
                }
            }
        }
    }

    public void A(Bundle bundle) {
    }

    private String PA(String str) {
        Matcher matcher = Pattern.compile("\\(.*?\\)").matcher(str);
        while (matcher.find()) {
            try {
                CharSequence ou = bh.ou(matcher.group());
                String replace = ou.replace("(", "").replace(")", "").replace(" ", "");
                CharSequence replace2;
                String[] split;
                if (replace.contains("__ALLSTAYTIME__")) {
                    replace2 = replace.replace("__ALLSTAYTIME__", String.valueOf(this.tFr / 1000));
                    split = replace2.split("\\+");
                    if (split.length == 2) {
                        replace2 = String.valueOf(Long.parseLong(split[0]) + Long.parseLong(split[1]));
                    }
                    str = str.replace(ou, replace2);
                } else if (ou.contains("__FOREGROUNDTIME__")) {
                    replace2 = replace.replace("__FOREGROUNDTIME__", String.valueOf(this.nlI / 1000));
                    split = replace2.split("\\+");
                    if (split.length == 2) {
                        replace2 = String.valueOf(Long.parseLong(split[0]) + Long.parseLong(split[1]));
                    }
                    str = str.replace(ou, replace2);
                }
            } catch (NumberFormatException e) {
                x.i("MicroMsg.GamePageTimeReport", "matchTimeMark, err:%s", new Object[]{e.getMessage()});
                return null;
            }
        }
        return str;
    }
}
