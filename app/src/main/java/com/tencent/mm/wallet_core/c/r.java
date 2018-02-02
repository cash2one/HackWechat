package com.tencent.mm.wallet_core.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r {
    private static r zHP;
    public String TAG = "MicroMsg.WalletDigCertManager";
    private int zHJ = 0;
    public String zHK = "";
    public String zHL = "";
    public String zHM = "";
    public String zHN = "";
    public Vector<q> zHO = new Vector();

    public static void aav(String str) {
        g.Dk();
        g.Dj().CU().a(a.xst, str);
    }

    public static String cBy() {
        g.Dk();
        return (String) g.Dj().CU().get(a.xst, "");
    }

    public static r cBz() {
        if (zHP == null) {
            zHP = new r();
        }
        return zHP;
    }

    public final boolean cBA() {
        if (bh.ov(cBy()) || this.zHJ <= 0) {
            return false;
        }
        return true;
    }

    public final void aj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("cert_info");
        if (optJSONObject != null) {
            this.zHO = new Vector();
            int optInt = optJSONObject.optInt("show_crt_info");
            this.zHJ = optJSONObject.optInt("is_crt_install");
            this.zHN = optJSONObject.optString("crt_item_logo_url");
            this.zHK = optJSONObject.optString("crt_entry_desc");
            this.zHL = optJSONObject.optString("crt_entry_title");
            this.zHM = optJSONObject.optString("crt_status_name");
            g.Dk();
            g.Dj().CU().a(a.xsu, Integer.valueOf(optInt));
            String cBy = cBy();
            JSONArray optJSONArray = optJSONObject.optJSONArray("crt_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        q qVar = new q(optJSONArray.getJSONObject(i));
                        if (qVar.zHI == 0) {
                            this.zHO.add(qVar);
                        } else if (bh.ov(cBy)) {
                            x.i(this.TAG, "drop crt list no exist local drop: %s", new Object[]{qVar.wQi});
                        } else if (qVar.wQi.equals(cBy)) {
                            this.zHO.add(qVar);
                        } else {
                            x.i(this.TAG, "drop crt list %s drop: %s", new Object[]{cBy, qVar.wQi});
                        }
                    } catch (Exception e) {
                        x.i(this.TAG, "WalletDigCertManager error %s", new Object[]{e.getMessage()});
                    }
                }
            }
        }
    }

    public final void aaw(String str) {
        if (!bh.ov(str)) {
            if (str.equals(cBy())) {
                this.zHJ = 0;
                aav("");
                x.i(this.TAG, "clean token %s  stack %s ", new Object[]{str, bh.cgy().toString()});
                a.cBn();
                a.clearCert(str);
            }
            Iterator it = this.zHO.iterator();
            if (it.hasNext()) {
                this.zHO.remove((q) it.next());
            }
        }
    }
}
