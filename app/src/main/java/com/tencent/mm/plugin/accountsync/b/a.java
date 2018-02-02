package com.tencent.mm.plugin.accountsync.b;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static a ikR = new a();
    private Map<String, String> ikS;

    public final Map<String, String> bI(Context context) {
        try {
            String q = bh.q(context.getAssets().open("config/EmailAddress.xml"));
            if (bh.ov(q)) {
                return null;
            }
            Map y = bi.y(q, "config");
            if (y == null || y.isEmpty()) {
                x.d("MicroMsg.EmailFormater", "values null");
                return null;
            } else if (this.ikS != null) {
                return this.ikS;
            } else {
                this.ikS = new HashMap();
                int i = 0;
                while (true) {
                    q = ".config.format" + (i == 0 ? "" : Integer.valueOf(i));
                    if (y.get(q) == null) {
                        return this.ikS;
                    }
                    String str = q + ".emaildomain";
                    String str2 = q + ".loginpage";
                    q = (String) y.get(str);
                    str = (String) y.get(str2);
                    if (!(bh.ov(q) || bh.ov(str))) {
                        this.ikS.put(q, str);
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.EmailFormater", "parse email failed:[%s]", new Object[]{e.getMessage()});
            return null;
        }
    }
}
