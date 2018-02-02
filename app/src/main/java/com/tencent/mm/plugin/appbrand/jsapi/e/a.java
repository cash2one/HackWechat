package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.widget.input.b.b;
import com.tencent.mm.plugin.appbrand.widget.input.b.d;
import com.tencent.mm.plugin.appbrand.widget.input.b.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

abstract class a<P extends f> extends com.tencent.mm.plugin.appbrand.jsapi.a {
    a() {
    }

    protected boolean a(P p, JSONObject jSONObject, p pVar, int i) {
        JSONObject jSONObject2;
        Throwable e;
        JSONObject jSONObject3;
        try {
            jSONObject2 = new JSONObject(jSONObject.getString("style"));
            try {
                p.kbI = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "width"));
                try {
                    p.kbJ = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "height"));
                } catch (Exception e2) {
                }
                p.kbK = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "top"));
                p.kbL = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "left"));
            } catch (Exception e3) {
                e = e3;
                if (!agk()) {
                    x.e("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", new Object[]{bh.i(e)});
                    pVar.E(i, e("fail:invalid data", null));
                    return false;
                }
                if (jSONObject2 == null) {
                    p.kbS = jSONObject2.optString("fontWeight", null);
                    try {
                        p.kbM = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "minHeight"));
                    } catch (Exception e4) {
                    }
                    try {
                        p.kbN = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "maxHeight"));
                    } catch (Exception e5) {
                    }
                    p.kbO = jSONObject2.optString("textAlign", null);
                    try {
                        p.kbQ = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
                    } catch (Exception e6) {
                    }
                    try {
                        p.kbP = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
                    } catch (Exception e7) {
                    }
                    try {
                        p.kbR = Float.valueOf(com.tencent.mm.plugin.appbrand.p.f.e(jSONObject2, "fontSize"));
                    } catch (Exception e8) {
                    }
                    try {
                        p.kce = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "marginBottom"));
                    } catch (Exception e9) {
                        p.kce = null;
                    }
                    p.kci = d.bn(jSONObject2.opt("lineSpace"));
                    if (p.kci != null) {
                        p.kci = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.lI(p.kci.intValue()));
                    }
                    p.kcj = d.bn(jSONObject2.opt("lineHeight"));
                    if (p.kcj != null) {
                        p.kcj = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.lI(p.kcj.intValue()));
                    }
                } else if (!agk()) {
                    x.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
                    pVar.E(i, e("fail:invalid data", null));
                    return false;
                }
                p.kcc = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
                p.kbH = jSONObject.optString("defaultValue", jSONObject.optString(DownloadSettingTable$Columns.VALUE, null));
                p.kbT = Integer.valueOf(jSONObject.getInt("maxLength"));
                p.kbU = jSONObject.optString("placeholder");
                jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
                p.kbX = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
                p.kbW = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject3, "fontSize"));
                p.kbV = jSONObject3.optString("fontWeight", "normal");
                p.kbZ = Boolean.valueOf(jSONObject.getBoolean("hidden"));
                p.kbY = Boolean.valueOf(jSONObject.getBoolean("disabled"));
                p.kcd = Boolean.valueOf(jSONObject.getBoolean("fixed"));
                p.kcf = b.uZ(jSONObject.optString("confirmType"));
                p.kcg = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
                p.kch = g.bl(jSONObject.opt("adjustPosition"));
                return true;
            }
        } catch (Exception e10) {
            e = e10;
            jSONObject2 = null;
            if (agk()) {
                x.e("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", new Object[]{bh.i(e)});
                pVar.E(i, e("fail:invalid data", null));
                return false;
            }
            if (jSONObject2 == null) {
                p.kbS = jSONObject2.optString("fontWeight", null);
                p.kbM = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "minHeight"));
                p.kbN = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "maxHeight"));
                p.kbO = jSONObject2.optString("textAlign", null);
                p.kbQ = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
                p.kbP = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
                p.kbR = Float.valueOf(com.tencent.mm.plugin.appbrand.p.f.e(jSONObject2, "fontSize"));
                p.kce = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "marginBottom"));
                p.kci = d.bn(jSONObject2.opt("lineSpace"));
                if (p.kci != null) {
                    p.kci = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.lI(p.kci.intValue()));
                }
                p.kcj = d.bn(jSONObject2.opt("lineHeight"));
                if (p.kcj != null) {
                    p.kcj = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.lI(p.kcj.intValue()));
                }
            } else if (agk()) {
                x.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
                pVar.E(i, e("fail:invalid data", null));
                return false;
            }
            p.kcc = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
            p.kbH = jSONObject.optString("defaultValue", jSONObject.optString(DownloadSettingTable$Columns.VALUE, null));
            p.kbT = Integer.valueOf(jSONObject.getInt("maxLength"));
            p.kbU = jSONObject.optString("placeholder");
            jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            p.kbX = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
            p.kbW = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject3, "fontSize"));
            p.kbV = jSONObject3.optString("fontWeight", "normal");
            p.kbZ = Boolean.valueOf(jSONObject.getBoolean("hidden"));
            p.kbY = Boolean.valueOf(jSONObject.getBoolean("disabled"));
            p.kcd = Boolean.valueOf(jSONObject.getBoolean("fixed"));
            p.kcf = b.uZ(jSONObject.optString("confirmType"));
            p.kcg = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
            p.kch = g.bl(jSONObject.opt("adjustPosition"));
            return true;
        }
        if (jSONObject2 == null) {
            p.kbS = jSONObject2.optString("fontWeight", null);
            p.kbM = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "minHeight"));
            p.kbN = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "maxHeight"));
            p.kbO = jSONObject2.optString("textAlign", null);
            p.kbQ = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
            p.kbP = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
            p.kbR = Float.valueOf(com.tencent.mm.plugin.appbrand.p.f.e(jSONObject2, "fontSize"));
            p.kce = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject2, "marginBottom"));
            p.kci = d.bn(jSONObject2.opt("lineSpace"));
            if (p.kci != null) {
                p.kci = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.lI(p.kci.intValue()));
            }
            p.kcj = d.bn(jSONObject2.opt("lineHeight"));
            if (p.kcj != null) {
                p.kcj = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.lI(p.kcj.intValue()));
            }
        } else if (agk()) {
            x.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
            pVar.E(i, e("fail:invalid data", null));
            return false;
        }
        try {
            p.kcc = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
        } catch (Exception e11) {
        }
        p.kbH = jSONObject.optString("defaultValue", jSONObject.optString(DownloadSettingTable$Columns.VALUE, null));
        try {
            p.kbT = Integer.valueOf(jSONObject.getInt("maxLength"));
        } catch (Exception e12) {
        }
        p.kbU = jSONObject.optString("placeholder");
        try {
            jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            p.kbX = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
            p.kbW = Integer.valueOf(com.tencent.mm.plugin.appbrand.p.f.c(jSONObject3, "fontSize"));
            p.kbV = jSONObject3.optString("fontWeight", "normal");
        } catch (Exception e13) {
        }
        try {
            p.kbZ = Boolean.valueOf(jSONObject.getBoolean("hidden"));
        } catch (JSONException e14) {
            p.kbZ = null;
        }
        try {
            p.kbY = Boolean.valueOf(jSONObject.getBoolean("disabled"));
        } catch (Exception e15) {
            p.kbY = null;
        }
        try {
            p.kcd = Boolean.valueOf(jSONObject.getBoolean("fixed"));
        } catch (Exception e16) {
            p.kcd = null;
        }
        p.kcf = b.uZ(jSONObject.optString("confirmType"));
        try {
            p.kcg = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
        } catch (Exception e17) {
            p.kcg = null;
        }
        p.kch = g.bl(jSONObject.opt("adjustPosition"));
        return true;
    }

    protected boolean agk() {
        return false;
    }

    protected static void J(int i, String str) {
        u.GK().t("AppBrandJsInput@" + i, true).O("passing_data", str);
    }

    protected static void a(int i, p pVar) {
        if (pVar != null) {
            u.GK().t("AppBrandJsInput@" + i, true).o("webview_reference", new WeakReference(pVar));
        }
    }

    protected static p kx(int i) {
        u.b hx = u.GK().hx("AppBrandJsInput@" + i);
        if (hx == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) hx.get("webview_reference", null);
        return weakReference == null ? null : (p) weakReference.get();
    }
}
