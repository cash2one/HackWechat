package com.tencent.mm.plugin.wallet_core.d;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ae.k;
import com.tencent.mm.az.r;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    private static final String kLD = (e.bnF + "wallet");
    private static Map<String, String> sQT = null;

    private static boolean Ne(String str) {
        try {
            sQT = new HashMap();
            x.d("MicroMsg.WalletBankLogoStorage", "bank logo:" + str);
            Editor edit = ac.getContext().getSharedPreferences("bank_logo", 0).edit();
            JSONArray jSONArray = new JSONObject(str).getJSONArray("bank_urls_list");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (q.Gf()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                String jSONObject2 = jSONObject.toString();
                if (bh.ov(optString) || bh.ov(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                sQT.put(optString, jSONObject2);
            }
            edit.commit();
            x.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean al(LinkedList<String> linkedList) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            sQT = new HashMap();
            Editor edit = ac.getContext().getSharedPreferences("bank_logo", 0).edit();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                String optString;
                JSONObject jSONObject = new JSONObject((String) linkedList.get(i));
                if (q.Gf()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                jSONObject.put("timestamp", currentTimeMillis);
                String jSONObject2 = jSONObject.toString();
                if (bh.ov(optString) || bh.ov(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                sQT.put(optString, jSONObject2);
            }
            edit.commit();
            x.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            return false;
        }
    }

    public static com.tencent.mm.plugin.wallet_core.model.e h(Context context, String str, boolean z) {
        if (!z) {
            return aH(context, str);
        }
        if (!"CITIC_CREDIT".equals(str)) {
            return null;
        }
        com.tencent.mm.plugin.wallet_core.model.e eVar = new com.tencent.mm.plugin.wallet_core.model.e();
        eVar.sLx = a$e.udN;
        eVar.sLy = a$e.udO;
        com.tencent.mm.plugin.wallet_core.model.e aH = aH(context, str);
        if (aH == null) {
            return eVar;
        }
        eVar.oPH = aH.oPH;
        return eVar;
    }

    private static com.tencent.mm.plugin.wallet_core.model.e aH(Context context, String str) {
        String string;
        String str2;
        boolean z;
        com.tencent.mm.plugin.wallet_core.model.e eVar;
        boolean z2 = true;
        if (sQT == null) {
            string = ac.getContext().getSharedPreferences("bank_logo", 0).getString(str, "");
        } else {
            string = (String) sQT.get(str);
        }
        if (bh.ov(string)) {
            g.Dk();
            if (g.Dj().isSDCardAvailable()) {
                r.QH().ij(11);
                k kVar = new com.tencent.mm.az.k(11);
                g.Dk();
                g.Di().gPJ.a(kVar, 0);
            }
            Ne(aI(context, "config/bank_logo.xml"));
            if (sQT != null) {
                str2 = (String) sQT.get(str);
                z = true;
            } else {
                str2 = string;
                z = true;
            }
        } else {
            str2 = string;
            z = false;
        }
        if (bh.ov(str2)) {
            eVar = null;
        } else {
            com.tencent.mm.plugin.wallet_core.model.e eVar2 = new com.tencent.mm.plugin.wallet_core.model.e();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                long optLong = jSONObject.optLong("timestamp", 0);
                eVar2.oPH = jSONObject.getString("logo2x_url");
                eVar2.sLu = jSONObject.getString("bg2x_url");
                eVar2.sLv = jSONObject.getString("wl2x_url");
                if (!z && (System.currentTimeMillis() / 1000) - optLong <= 7200) {
                    z2 = false;
                }
                eVar2.sLz = z2;
                eVar2.timestamp = optLong;
                eVar = eVar2;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
                return null;
            }
        }
        return eVar;
    }

    private static String aI(Context context, String str) {
        String str2 = "";
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = EncodingUtils.getString(bArr, "UTF-8");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e, "close", new Object[0]);
                }
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e2, "getFromAssets", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e22, "close", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.WalletBankLogoStorage", e222, "close", new Object[0]);
                }
            }
        }
        return str2;
    }

    public static String bMk() {
        return kLD;
    }

    public static String Hu(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.WalletBankLogoStorage", "getStoragePath: but url is null");
            return null;
        }
        return String.format("%s/%s", new Object[]{kLD, com.tencent.mm.a.g.s(str.getBytes())});
    }
}
