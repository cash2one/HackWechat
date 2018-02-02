package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.h;
import com.tencent.xweb.g.a;
import org.xwalk.core.XWalkEnvironment;

public final class k {
    private static k Aqe = null;
    public Context Aqf;
    c Aqg = c.AqA;
    public boolean Aqh = false;
    public boolean Aqi = false;
    public boolean Aqj = false;
    public a Aqk = a.RT_TYPE_AUTO;
    public boolean Aql = false;
    String Aqm = "";

    public static void iQ(Context context) {
        boolean z = false;
        if (Aqe == null) {
            k kVar = new k();
            Aqe = kVar;
            kVar.Aqf = context;
            XWalkEnvironment.init(context);
            Aqe.Aqi = context.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
            String string = context.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO");
            try {
                Aqe.Aqk = a.valueOf(string);
            } catch (Exception e) {
            }
            Aqe.Aqh = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
            string = XWalkEnvironment.getTestDownLoadUrl(context);
            k kVar2 = Aqe;
            if (!(string == null || string.isEmpty())) {
                z = true;
            }
            kVar2.Aql = z;
        }
    }

    public static k cIo() {
        return Aqe;
    }

    public final c aco(String str) {
        if (this.Aqm.equals(str)) {
            return this.Aqg;
        }
        if (str == null || str.isEmpty() || this.Aqf == null) {
            return c.AqA;
        }
        this.Aqm = str;
        SharedPreferences sharedPreferences = this.Aqf.getSharedPreferences("wcwebview", 0);
        if (sharedPreferences == null) {
            return c.AqA;
        }
        String string = sharedPreferences.getString("HardCodeWebView" + str, "");
        if (string == null || string.isEmpty() || string.equals(c.AqA.toString())) {
            string = sharedPreferences.getString("ABTestWebView" + str, "");
        }
        if (string == null || string.isEmpty()) {
            this.Aqg = c.AqA;
        } else {
            try {
                this.Aqg = c.valueOf(string);
            } catch (Exception e) {
                this.Aqg = c.AqA;
            }
        }
        return this.Aqg;
    }

    public final void a(String str, c cVar) {
        if (this.Aqf != null && str != null && !str.isEmpty()) {
            this.Aqm = str;
            this.Aqg = cVar;
            this.Aqf.getSharedPreferences("wcwebview", 0).edit().putString("HardCodeWebView" + str, cVar.toString()).commit();
        }
    }

    public final void oa(boolean z) {
        if (z != this.Aqh) {
            this.Aqh = z;
            XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", z).commit();
        }
    }

    public final void ob(boolean z) {
        if (z != this.Aqj) {
            this.Aqj = z;
            this.Aqf.getSharedPreferences("wcwebview", 0).edit().putBoolean("m_bShowAbstract", this.Aqj).commit();
        }
    }

    public final void a(a aVar) {
        if (this.Aqk != aVar) {
            this.Aqk = aVar;
            this.Aqf.getSharedPreferences("wcwebview", 0).edit().putString("V8type", aVar.toString()).commit();
        }
    }

    public final void oc(boolean z) {
        if (z != this.Aql) {
            this.Aql = z;
            Editor edit;
            if (this.Aql) {
                XWalkEnvironment.setTestDownLoadUrl(this.Aqf, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
                edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
                edit.putLong("nLastFetchConfigTime", 0);
                edit.commit();
                h.a(c.AqB).excute("STR_CMD_CLEAR_SCHEDULER", null);
                return;
            }
            XWalkEnvironment.setTestDownLoadUrl(this.Aqf, "");
            edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
            edit.putLong("nLastFetchConfigTime", 0);
            edit.commit();
            h.a(c.AqB).excute("STR_CMD_CLEAR_SCHEDULER", null);
        }
    }
}
