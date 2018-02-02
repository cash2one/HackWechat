package com.tencent.mm.plugin.aj.a;

import android.content.res.AssetManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ae.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    private static e hnN = new 1();
    private static HashMap<String, a> tkn;
    private static e tko;
    private static HashMap<String, Long> tkp;
    private static String tkq = "";

    static {
        HashMap hashMap = new HashMap();
        tkn = hashMap;
        hashMap.put("zh_CN", a.xuz);
        tkn.put("zh_HK", a.xuB);
        tkn.put("zh_TW", a.xuA);
        tkn.put("en", a.xuC);
        tkn.put("ar", a.xuD);
        tkn.put("de", a.xuE);
        tkn.put("de_DE", a.xuF);
        tkn.put("es", a.xuG);
        tkn.put("fr", a.xuH);
        tkn.put("he", a.xuI);
        tkn.put("hi", a.xuJ);
        tkn.put(SlookAirButtonFrequentContactAdapter.ID, a.xuK);
        tkn.put("in", a.xuL);
        tkn.put("it", a.xuM);
        tkn.put("iw", a.xuN);
        tkn.put("ja", a.xuO);
        tkn.put("ko", a.xuP);
        tkn.put("lo", a.xuQ);
        tkn.put("ms", a.xuR);
        tkn.put("my", a.xuS);
        tkn.put("pl", a.xuT);
        tkn.put("pt", a.xuU);
        tkn.put("ru", a.xuV);
        tkn.put("th", a.xuW);
        tkn.put("tr", a.xuX);
        tkn.put("vi", a.xuY);
    }

    public static boolean zW(int i) {
        if (tkp == null) {
            tkp = new HashMap();
        }
        String eL = w.eL(ac.getContext());
        if (tkq == null || tkq.equalsIgnoreCase(eL)) {
            Long l = (Long) tkp.get(eL);
            if (l == null) {
                l = Long.valueOf(0);
            }
            if (System.currentTimeMillis() - l.longValue() < 600000) {
                return false;
            }
            JSONObject jSONObject;
            int i2;
            tkp.put(eL, Long.valueOf(System.currentTimeMillis()));
            x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "startToRequestConfig %s %d %d", new Object[]{eL, Integer.valueOf(i), Long.valueOf(0)});
            String str = (String) g.Dj().CU().get(NS(eL), null);
            try {
                if (!bh.ov(str)) {
                    jSONObject = new JSONObject(str);
                    if (jSONObject != null) {
                        i2 = a.tkt;
                    } else {
                        i2 = (jSONObject.optLong("timevalSec") * 1000) + jSONObject.optLong("updateTime") >= System.currentTimeMillis() ? a.tks : a.tkr;
                    }
                    if (i2 == a.tkr) {
                        return false;
                    }
                }
            } catch (JSONException e) {
            }
            jSONObject = null;
            if (jSONObject != null) {
                if ((jSONObject.optLong("timevalSec") * 1000) + jSONObject.optLong("updateTime") >= System.currentTimeMillis()) {
                }
            } else {
                i2 = a.tkt;
            }
            if (i2 == a.tkr) {
                return false;
            }
        }
        tkq = eL;
        if (tko != null) {
            g.CG().c(tko);
            tko = null;
        }
        tko = new e(null, i, 0, null);
        g.CG().a(1948, hnN);
        g.CG().a(tko, 0);
        return true;
    }

    private static a NS(String str) {
        a aVar = (a) tkn.get(str);
        if (aVar == null) {
            return a.xuC;
        }
        return aVar;
    }

    private static int eF(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jSONObject.put("updateTime", System.currentTimeMillis());
            g.Dj().CU().a(NS(str), jSONObject.toString());
            return a.tkr;
        } catch (JSONException e) {
            return a.tkt;
        }
    }

    public static JSONObject NT(String str) {
        String str2;
        JSONObject jSONObject;
        String str3;
        JSONObject jSONObject2;
        String str4 = "";
        try {
            str2 = (String) g.Dj().CU().get(NS(w.eL(ac.getContext())), null);
            if (bh.ov(str2)) {
                str2 = str4;
                jSONObject = null;
            } else {
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject(SlookAirButtonFrequentContactAdapter.DATA).optJSONObject(str);
                str2 = "Config Storage";
                jSONObject = optJSONObject;
            }
        } catch (Exception e) {
            str2 = str4;
            jSONObject = null;
        }
        if (jSONObject == null) {
            try {
                String bOV = bOV();
                if (bOV != null) {
                    jSONObject = new JSONObject(bOV).optJSONObject(SlookAirButtonFrequentContactAdapter.DATA).optJSONObject(str);
                    str2 = "Asset";
                }
            } catch (Exception e2) {
                str3 = str2;
                jSONObject2 = jSONObject;
                str4 = str3;
            }
        }
        str3 = str2;
        jSONObject2 = jSONObject;
        Object obj = str3;
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigKeyObj %s %s %s", new Object[]{r3, str, obj});
        return jSONObject2;
    }

    public static String NU(String str) {
        String str2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String bOV;
        String str3;
        JSONObject jSONObject3;
        Object obj;
        Object opt;
        JSONObject jSONObject4 = null;
        String str4 = "";
        try {
            str2 = (String) g.Dj().CU().get(NS(w.eL(ac.getContext())), null);
            if (bh.ov(str2)) {
                str2 = str4;
                jSONObject = null;
            } else {
                jSONObject2 = new JSONObject(str2);
                try {
                    str2 = "Config Storage";
                    jSONObject = jSONObject2;
                } catch (Exception e) {
                    jSONObject4 = jSONObject2;
                    str2 = str4;
                    jSONObject2 = jSONObject4;
                    if (jSONObject2 == null) {
                        try {
                            bOV = bOV();
                            if (bOV != null) {
                                jSONObject = new JSONObject(bOV);
                                try {
                                    str2 = "Asset";
                                    str3 = str2;
                                    jSONObject3 = jSONObject;
                                    obj = str3;
                                } catch (Exception e2) {
                                    jSONObject2 = jSONObject;
                                    str4 = str2;
                                    jSONObject3 = jSONObject2;
                                    if (jSONObject3 == null) {
                                        jSONObject3 = new JSONObject();
                                    }
                                    x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                                    opt = jSONObject3.opt(str);
                                    return opt != null ? opt.toString() : "";
                                }
                                if (jSONObject3 == null) {
                                    jSONObject3 = new JSONObject();
                                }
                                x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                                opt = jSONObject3.opt(str);
                                if (opt != null) {
                                }
                            }
                        } catch (Exception e3) {
                            str4 = str2;
                            jSONObject3 = jSONObject2;
                            if (jSONObject3 == null) {
                                jSONObject3 = new JSONObject();
                            }
                            x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                            opt = jSONObject3.opt(str);
                            if (opt != null) {
                            }
                        }
                    }
                    jSONObject = jSONObject2;
                    str3 = str2;
                    jSONObject3 = jSONObject;
                    obj = str3;
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                    opt = jSONObject3.opt(str);
                    if (opt != null) {
                    }
                }
            }
            jSONObject2 = jSONObject;
        } catch (Exception e4) {
            str2 = str4;
            jSONObject2 = jSONObject4;
            if (jSONObject2 == null) {
                bOV = bOV();
                if (bOV != null) {
                    jSONObject = new JSONObject(bOV);
                    str2 = "Asset";
                    str3 = str2;
                    jSONObject3 = jSONObject;
                    obj = str3;
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                    opt = jSONObject3.opt(str);
                    if (opt != null) {
                    }
                }
            }
            jSONObject = jSONObject2;
            str3 = str2;
            jSONObject3 = jSONObject;
            obj = str3;
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
            opt = jSONObject3.opt(str);
            if (opt != null) {
            }
        }
        if (jSONObject2 == null) {
            bOV = bOV();
            if (bOV != null) {
                jSONObject = new JSONObject(bOV);
                str2 = "Asset";
                str3 = str2;
                jSONObject3 = jSONObject;
                obj = str3;
                if (jSONObject3 == null) {
                    jSONObject3 = new JSONObject();
                }
                x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
                opt = jSONObject3.opt(str);
                if (opt != null) {
                }
            }
        }
        jSONObject = jSONObject2;
        str3 = str2;
        jSONObject3 = jSONObject;
        obj = str3;
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
        }
        x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfigMetaKeyObj %s %s %s", new Object[]{r4, str, obj});
        opt = jSONObject3.opt(str);
        if (opt != null) {
        }
    }

    private static String bOV() {
        InputStream open;
        Throwable e;
        InputStream inputStream = null;
        AssetManager assets = ac.getContext().getAssets();
        try {
            open = assets.open("webconfig/default." + w.eL(ac.getContext()));
            try {
                String str = new String(b.d(open));
                com.tencent.mm.a.e.c(open);
                return str;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.c(open);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    inputStream = open;
                    com.tencent.mm.a.e.c(inputStream);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            open = null;
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.c(open);
            return null;
        } catch (Throwable th2) {
            e = th2;
            com.tencent.mm.a.e.c(inputStream);
            throw e;
        }
    }
}
