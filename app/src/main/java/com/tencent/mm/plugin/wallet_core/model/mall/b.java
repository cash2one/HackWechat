package com.tencent.mm.plugin.wallet_core.model.mall;

import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static int sQw = -256;
    public static int sQx = 621019136;
    public static int sQy = 637534720;

    public static ArrayList<MallNews> v(JSONArray jSONArray) {
        try {
            ArrayList<MallNews> arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                MallNews mallNews = new MallNews(jSONObject.optString("activity_jump_funcid"));
                mallNews.sQE = jSONObject.optString("activity_icon_link");
                mallNews.sQC = jSONObject.optString("activity_msg_content");
                mallNews.sQG = jSONObject.optString("activity_tips");
                arrayList.add(mallNews);
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
            return null;
        }
    }

    public static ArrayList<a> w(JSONArray jSONArray) {
        try {
            ArrayList<a> arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.sQo = jSONObject.optInt("banner_id");
                aVar.sQp = jSONObject.optString("banner_title");
                aVar.sQq = jSONObject.optString("banner_link");
                arrayList.add(aVar);
            }
            return arrayList;
        } catch (JSONException e) {
            x.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            return null;
        }
    }

    public static SparseArray<String> x(JSONArray jSONArray) {
        try {
            SparseArray<String> sparseArray = new SparseArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int optInt = jSONObject.optInt("type_id", 0);
                if (optInt != 0) {
                    sparseArray.put(optInt, jSONObject.optString("type_name"));
                }
            }
            return sparseArray;
        } catch (JSONException e) {
            x.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            return null;
        }
    }

    public static void cf(List<a> list) {
        if (list == null || list.size() <= 0) {
            x.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
            return;
        }
        int i = ((a) list.get(0)).sQo;
        x.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId" + i);
        g.Dk();
        g.Dj().CU().set(270342, Integer.valueOf(i));
        g.Dk();
        g.Dj().CU().lH(true);
    }

    public static ArrayList<MallFunction> y(JSONArray jSONArray) {
        try {
            ArrayList<MallFunction> arrayList = new ArrayList();
            int length = jSONArray.length();
            x.d("MicroMsg.MallLogic", "functions.jsonArray.length : " + length);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                MallFunction mallFunction = new MallFunction();
                mallFunction.pBK = jSONObject.getString("func_id");
                mallFunction.fII = jSONObject.getString("func_name");
                mallFunction.sQr = jSONObject.optString("func_icon_url");
                mallFunction.olA = jSONObject.optString("hd_icon_url");
                mallFunction.olB = jSONObject.optString("func_foregroud_icon_url");
                mallFunction.fLC = jSONObject.optString("native_url");
                mallFunction.nvp = jSONObject.optString("h5_url");
                mallFunction.type = jSONObject.optInt("property_type", 0);
                mallFunction.sQu = jSONObject.optString("third_party_disclaimer");
                mallFunction.sQv = jSONObject.optInt("download_restrict", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("remark_name_list");
                if (optJSONArray != null) {
                    mallFunction.sQs = new ArrayList();
                    int length2 = optJSONArray.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        mallFunction.sQs.add(optJSONArray.getString(i2));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("activity_info_list");
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    String str = mallFunction.pBK;
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(0);
                    MallNews mallNews = new MallNews(str);
                    mallNews.rVK = jSONObject2.optString("activity_id");
                    mallNews.frP = jSONObject2.optString("activity_ticket");
                    mallNews.sQC = jSONObject2.optString("activity_msg_content");
                    mallNews.sQD = jSONObject2.optString("activity_link");
                    mallNews.sQE = jSONObject2.optString("activity_icon_link");
                    mallNews.sQF = jSONObject2.optInt("activity_expired_time");
                    mallNews.sQG = jSONObject2.optString("activity_tips");
                    mallNews.sOA = jSONObject2.optInt("activity_type");
                    mallNews.sQJ = jSONObject2.optString("activity_url");
                    mallNews.sQH = jSONObject2.optInt("is_msg_reserved");
                    mallFunction.sQt = mallNews;
                }
                arrayList.add(mallFunction);
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallLogic", e, "", new Object[0]);
            return null;
        }
    }

    public static String bMd() {
        TelephonyManager telephonyManager = (TelephonyManager) ac.getContext().getSystemService("phone");
        String str = "";
        if (telephonyManager != null) {
            return telephonyManager.getNetworkCountryIso();
        }
        return str;
    }

    public static void zl(int i) {
        boolean z;
        if ((d.vAz & sQw) == i) {
            g.Dk();
            int intValue = ((Integer) g.Dj().CU().get(270343, Integer.valueOf(0))).intValue();
            if (i != intValue) {
                x.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + i + ", clickedV=" + intValue);
                z = true;
                if (z && q.Gb()) {
                    x.d("MicroMsg.MallLogic", "Show mall entry redot");
                    c.Bq().o(262156, true);
                    g.Dk();
                    g.Dj().CU().set(270343, Integer.valueOf(i));
                    g.Dk();
                    g.Dj().CU().a(a.xvO, Long.valueOf(System.currentTimeMillis()));
                    return;
                }
            }
        }
        z = false;
        if (z) {
        }
    }
}
