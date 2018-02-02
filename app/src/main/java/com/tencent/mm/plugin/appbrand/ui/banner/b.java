package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.OperateTask;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w.a;
import org.json.JSONArray;
import org.json.JSONException;

final class b {
    b() {
    }

    static boolean x(Intent intent) {
        if (intent == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(a.jOc.Jo());
        int intExtra = intent.getIntExtra(a.jOd.Jo(), 0);
        String stringExtra2 = intent.getStringExtra(a.jOe.Jo());
        String stringExtra3 = intent.getStringExtra(a.jOf.Jo());
        String stringExtra4 = intent.getStringExtra(a.jOg.Jo());
        for (a Jo : a.values()) {
            intent.removeExtra(Jo.Jo());
        }
        if (bh.ov(stringExtra) || bh.ov(stringExtra2)) {
            return false;
        }
        a(stringExtra, intExtra, stringExtra2, stringExtra3, stringExtra4);
        return true;
    }

    static boolean a(OperateTask operateTask) {
        if (operateTask == null || !g.Dh().Cy()) {
            return false;
        }
        BannerModel alm = BannerModel.alm();
        if (alm == null || !alm.appId.equals(operateTask.joe) || alm.iKd != operateTask.jOy) {
            return false;
        }
        a(alm.appId, alm.iKd, alm.appName, alm.iKm, operateTask.jOz);
        return true;
    }

    static void a(Intent intent, String str, int i, String str2, String str3, String str4) {
        if (intent != null) {
            intent.putExtra(a.jOc.Jo(), str);
            intent.putExtra(a.jOd.Jo(), i);
            intent.putExtra(a.jOe.Jo(), str2);
            intent.putExtra(a.jOf.Jo(), str3);
            intent.putExtra(a.jOg.Jo(), str4);
        }
    }

    private static void a(String str, int i, String str2, String str3, String str4) {
        if (g.Dh().Cy()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONArray.put(String.valueOf(i));
            jSONArray.put(str2);
            jSONArray.put(str3);
            jSONArray.put(bh.ou(str4));
            String jSONArray2 = jSONArray.toString();
            synchronized (b.class) {
                g.Dj().CU().a(a.xsd, jSONArray2);
            }
        }
    }

    private static Object[] ale() {
        if (!g.Dh().Cy()) {
            return null;
        }
        synchronized (b.class) {
            String str = (String) g.Dj().CU().get(a.xsd, "");
        }
        if (bh.ov(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != a.jOh) {
                return null;
            }
            Object[] objArr = new Object[a.jOh];
            for (int i = 0; i < a.jOh; i++) {
                objArr[i] = jSONArray.optString(i, "");
            }
            objArr[a.jOd.ordinal()] = Integer.valueOf(bh.getInt((String) objArr[a.jOd.ordinal()], 0));
            return objArr;
        } catch (JSONException e) {
            return null;
        }
    }

    static BannerModel alf() {
        Object[] ale = ale();
        if (ale == null) {
            return null;
        }
        BannerModel bannerModel = new BannerModel();
        bannerModel.appId = (String) ale[a.jOc.ordinal()];
        bannerModel.iKd = ((Integer) ale[a.jOd.ordinal()]).intValue();
        bannerModel.appName = (String) ale[a.jOe.ordinal()];
        bannerModel.iKm = (String) ale[a.jOf.ordinal()];
        bannerModel.jOF = (String) ale[a.jOg.ordinal()];
        return bannerModel;
    }
}
