package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mall.a.b;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aej;
import com.tencent.mm.protocal.c.awh;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MallIndexMenuUI extends MMPreference implements e {
    private f ilB;
    private int okQ;
    private List<awi> ome;
    private HashMap<String, awh> omf = new HashMap();
    private boolean omg;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.omg = getIntent().getBooleanExtra("key_default_show_currency", false);
        g.Dk();
        g.Dj().CU().a(a.xxq, Boolean.valueOf(false));
        setBackBtn(new 1(this));
        this.ilB = this.yjd;
        setMMTitle(i.uLf);
        g.CG().a(1754, this);
        g.CG().a(new b(), 0);
    }

    public final int XB() {
        return -1;
    }

    protected void onDestroy() {
        super.onDestroy();
        g.CG().b(1754, this);
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        x.i("MicroMsg.MallIndexMenuUI", "onPreferenceTreeClick, key: %s", new Object[]{str});
        awh com_tencent_mm_protocal_c_awh = (awh) this.omf.get(str);
        if (com_tencent_mm_protocal_c_awh != null) {
            JSONObject jSONObject;
            boolean z;
            com.tencent.mm.plugin.report.service.g gVar;
            Object[] objArr;
            com.tencent.mm.sdk.b.b qpVar;
            JSONObject jSONObject2 = new JSONObject();
            g.Dk();
            str = (String) g.Dj().CU().get(a.xxp, "");
            if (!bh.ov(str)) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MallIndexMenuUI", e, "parse redDotConfig json failed: %s", new Object[]{e.getMessage()});
                }
                if (jSONObject.optInt(com_tencent_mm_protocal_c_awh.name, 0) != 1) {
                    jSONObject.remove(com_tencent_mm_protocal_c_awh.name);
                    if (jSONObject.length() > 0) {
                        g.Dk();
                        g.Dj().CU().a(a.xxp, "");
                    } else {
                        g.Dk();
                        g.Dj().CU().a(a.xxp, jSONObject.toString());
                    }
                    if (preference instanceof IconPreference) {
                        ((IconPreference) preference).EZ(8);
                        ((IconPreference) preference).EX(8);
                        ((IconPreference) preference).mw(false);
                    }
                    z = true;
                } else {
                    z = false;
                }
                switch (com_tencent_mm_protocal_c_awh.szZ) {
                    case 1:
                        x.i("MicroMsg.MallIndexMenuUI", "jump type h5, url: %s", new Object[]{com_tencent_mm_protocal_c_awh.sAa});
                        if (!bh.ov(com_tencent_mm_protocal_c_awh.sAa)) {
                            com.tencent.mm.wallet_core.ui.e.l(this, com_tencent_mm_protocal_c_awh.sAa, false);
                        }
                        gVar = com.tencent.mm.plugin.report.service.g.pQN;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(1);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = com_tencent_mm_protocal_c_awh.sAa;
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        gVar.h(14872, objArr);
                        return true;
                    case 2:
                        x.i("MicroMsg.MallIndexMenuUI", "jump type tiny app, username: %s, path: %s", new Object[]{com_tencent_mm_protocal_c_awh.sAb, com_tencent_mm_protocal_c_awh.sAb});
                        if (!bh.ov(com_tencent_mm_protocal_c_awh.sAb)) {
                            qpVar = new qp();
                            qpVar.fIi.userName = com_tencent_mm_protocal_c_awh.sAb;
                            qpVar.fIi.fIk = bh.az(com_tencent_mm_protocal_c_awh.sAc, "");
                            qpVar.fIi.scene = 1066;
                            qpVar.fIi.fIl = 0;
                            com.tencent.mm.sdk.b.a.xef.m(qpVar);
                        }
                        gVar = com.tencent.mm.plugin.report.service.g.pQN;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(2);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = com_tencent_mm_protocal_c_awh.sAb;
                        objArr[4] = Integer.valueOf(0);
                        gVar.h(14872, objArr);
                        return true;
                    case 3:
                        x.i("MicroMsg.MallIndexMenuUI", "jump type payment management");
                        d.y(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                        gVar = com.tencent.mm.plugin.report.service.g.pQN;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(3);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        gVar.h(14872, objArr);
                        return true;
                    case 4:
                        x.i("MicroMsg.MallIndexMenuUI", "jump type payment security");
                        d.y(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
                        gVar = com.tencent.mm.plugin.report.service.g.pQN;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(4);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        gVar.h(14872, objArr);
                        return true;
                    case 5:
                        x.i("MicroMsg.MallIndexMenuUI", "jump type wallet switch");
                        d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                        gVar = com.tencent.mm.plugin.report.service.g.pQN;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(5);
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = "";
                        objArr[3] = "";
                        objArr[4] = Integer.valueOf(0);
                        gVar.h(14872, objArr);
                        return true;
                    default:
                        return true;
                }
            }
            jSONObject = jSONObject2;
            if (jSONObject.optInt(com_tencent_mm_protocal_c_awh.name, 0) != 1) {
                z = false;
            } else {
                jSONObject.remove(com_tencent_mm_protocal_c_awh.name);
                if (jSONObject.length() > 0) {
                    g.Dk();
                    g.Dj().CU().a(a.xxp, jSONObject.toString());
                } else {
                    g.Dk();
                    g.Dj().CU().a(a.xxp, "");
                }
                if (preference instanceof IconPreference) {
                    ((IconPreference) preference).EZ(8);
                    ((IconPreference) preference).EX(8);
                    ((IconPreference) preference).mw(false);
                }
                z = true;
            }
            switch (com_tencent_mm_protocal_c_awh.szZ) {
                case 1:
                    x.i("MicroMsg.MallIndexMenuUI", "jump type h5, url: %s", new Object[]{com_tencent_mm_protocal_c_awh.sAa});
                    if (bh.ov(com_tencent_mm_protocal_c_awh.sAa)) {
                        com.tencent.mm.wallet_core.ui.e.l(this, com_tencent_mm_protocal_c_awh.sAa, false);
                    }
                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(1);
                    if (z) {
                    }
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = com_tencent_mm_protocal_c_awh.sAa;
                    objArr[3] = "";
                    objArr[4] = Integer.valueOf(0);
                    gVar.h(14872, objArr);
                    return true;
                case 2:
                    x.i("MicroMsg.MallIndexMenuUI", "jump type tiny app, username: %s, path: %s", new Object[]{com_tencent_mm_protocal_c_awh.sAb, com_tencent_mm_protocal_c_awh.sAb});
                    if (bh.ov(com_tencent_mm_protocal_c_awh.sAb)) {
                        qpVar = new qp();
                        qpVar.fIi.userName = com_tencent_mm_protocal_c_awh.sAb;
                        qpVar.fIi.fIk = bh.az(com_tencent_mm_protocal_c_awh.sAc, "");
                        qpVar.fIi.scene = 1066;
                        qpVar.fIi.fIl = 0;
                        com.tencent.mm.sdk.b.a.xef.m(qpVar);
                    }
                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(2);
                    if (z) {
                    }
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = "";
                    objArr[3] = com_tencent_mm_protocal_c_awh.sAb;
                    objArr[4] = Integer.valueOf(0);
                    gVar.h(14872, objArr);
                    return true;
                case 3:
                    x.i("MicroMsg.MallIndexMenuUI", "jump type payment management");
                    d.y(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(3);
                    if (z) {
                    }
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = "";
                    objArr[3] = "";
                    objArr[4] = Integer.valueOf(0);
                    gVar.h(14872, objArr);
                    return true;
                case 4:
                    x.i("MicroMsg.MallIndexMenuUI", "jump type payment security");
                    d.y(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(4);
                    if (z) {
                    }
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = "";
                    objArr[3] = "";
                    objArr[4] = Integer.valueOf(0);
                    gVar.h(14872, objArr);
                    return true;
                case 5:
                    x.i("MicroMsg.MallIndexMenuUI", "jump type wallet switch");
                    d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(5);
                    if (z) {
                    }
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = "";
                    objArr[3] = "";
                    objArr[4] = Integer.valueOf(0);
                    gVar.h(14872, objArr);
                    return true;
                default:
                    return true;
            }
        } else if ("pay_my_msg".equals(str)) {
            if (o.bLq().bLQ().bLH()) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
                d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            } else {
                com.tencent.mm.wallet_core.a.b(this, "ShowOrdersInfoProcess", null);
            }
            com.tencent.mm.wallet_core.ui.e.HF(20);
            return true;
        } else if ("pay_manage".equals(str)) {
            if (q.Gf()) {
                d.y(this, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
            } else {
                d.y(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
            }
            com.tencent.mm.wallet_core.ui.e.HF(21);
            return true;
        } else {
            if ("pay_security".equals(str)) {
                d.y(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
                com.tencent.mm.wallet_core.ui.e.HF(22);
            } else if ("pay_help_center".equals(str)) {
                String str2;
                Intent intent2 = new Intent();
                if (q.Gf()) {
                    str2 = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl";
                } else {
                    str2 = "https://kf.qq.com/touch/scene_product.html?scene_id=kf1";
                }
                intent2.putExtra("rawUrl", str2);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                com.tencent.mm.wallet_core.ui.e.HF(23);
                return true;
            } else if ("pay_wallet_switch".equals(str)) {
                d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                return true;
            }
            return false;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.MallIndexMenuUI", "onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            aej com_tencent_mm_protocal_c_aej = ((b) kVar).okS;
            String str2 = "MicroMsg.MallIndexMenuUI";
            String str3 = "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s";
            Object[] objArr = new Object[3];
            objArr[0] = com_tencent_mm_protocal_c_aej.title;
            objArr[1] = com_tencent_mm_protocal_c_aej.wmF;
            objArr[2] = Integer.valueOf(com_tencent_mm_protocal_c_aej.wmF != null ? com_tencent_mm_protocal_c_aej.wmF.size() : 0);
            x.i(str2, str3, objArr);
            x.i("MicroMsg.MallIndexMenuUI", "initPayMenuFromResponse: %s", new Object[]{com_tencent_mm_protocal_c_aej});
            if (com_tencent_mm_protocal_c_aej != null) {
                JSONObject jSONObject;
                this.ilB.removeAll();
                if (!bh.ov(com_tencent_mm_protocal_c_aej.title)) {
                    setMMTitle(com_tencent_mm_protocal_c_aej.title);
                }
                JSONObject jSONObject2 = new JSONObject();
                g.Dk();
                String str4 = (String) g.Dj().CU().get(a.xxp, "");
                if (!bh.ov(str4)) {
                    try {
                        jSONObject = new JSONObject(str4);
                    } catch (JSONException e) {
                    }
                    if (com_tencent_mm_protocal_c_aej.wmF != null && com_tencent_mm_protocal_c_aej.wmF.size() > 0) {
                        this.ome = com_tencent_mm_protocal_c_aej.wmF;
                        Iterator it = com_tencent_mm_protocal_c_aej.wmF.iterator();
                        Object obj = 1;
                        int i3 = 0;
                        while (it.hasNext()) {
                            int i4;
                            Object obj2;
                            awi com_tencent_mm_protocal_c_awi = (awi) it.next();
                            if (com_tencent_mm_protocal_c_awi.wDZ == null || com_tencent_mm_protocal_c_awi.wDZ.size() <= 0) {
                                i4 = i3;
                                obj2 = obj;
                            } else {
                                Preference preferenceTitleCategory;
                                if (obj == null && bh.ov(com_tencent_mm_protocal_c_awi.title)) {
                                    this.ilB.a(new PreferenceSmallCategory(this));
                                }
                                if (!bh.ov(com_tencent_mm_protocal_c_awi.title)) {
                                    preferenceTitleCategory = new PreferenceTitleCategory(this);
                                    preferenceTitleCategory.setTitle(com_tencent_mm_protocal_c_awi.title);
                                    this.ilB.a(preferenceTitleCategory);
                                }
                                Iterator it2 = com_tencent_mm_protocal_c_awi.wDZ.iterator();
                                while (it2.hasNext()) {
                                    awh com_tencent_mm_protocal_c_awh = (awh) it2.next();
                                    x.i("MicroMsg.MallIndexMenuUI", "label name: %s", new Object[]{com_tencent_mm_protocal_c_awh.name});
                                    preferenceTitleCategory = new CdnImageIconPreference(this);
                                    if (!bh.ov(com_tencent_mm_protocal_c_awh.title)) {
                                        preferenceTitleCategory.setTitle(com_tencent_mm_protocal_c_awh.title);
                                    }
                                    if (!bh.ov(com_tencent_mm_protocal_c_awh.desc)) {
                                        preferenceTitleCategory.EY(0);
                                        preferenceTitleCategory.ac(com_tencent_mm_protocal_c_awh.desc, -1, Color.parseColor("#999999"));
                                    }
                                    if (!bh.ov(com_tencent_mm_protocal_c_awh.kJP)) {
                                        preferenceTitleCategory.iconUrl = com_tencent_mm_protocal_c_awh.kJP;
                                    }
                                    preferenceTitleCategory.setKey(com_tencent_mm_protocal_c_awh.name);
                                    if (jSONObject.optInt(com_tencent_mm_protocal_c_awh.name, 0) == 1) {
                                        if (com_tencent_mm_protocal_c_awh.wDY != null) {
                                            if ("1".equals(com_tencent_mm_protocal_c_awh.wDY.type)) {
                                                preferenceTitleCategory.EY(0);
                                                preferenceTitleCategory.mw(true);
                                            } else if ("2".equals(com_tencent_mm_protocal_c_awh.wDY.type)) {
                                                preferenceTitleCategory.dh(getString(i.dFP), com.tencent.mm.plugin.wxpay.a.e.bEf);
                                                preferenceTitleCategory.EX(0);
                                            } else if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(com_tencent_mm_protocal_c_awh.wDY.type)) {
                                                preferenceTitleCategory.dh(com_tencent_mm_protocal_c_awh.wDY.number, com.tencent.mm.plugin.wxpay.a.e.bHd);
                                                preferenceTitleCategory.EX(0);
                                            }
                                            if (!bh.ov(com_tencent_mm_protocal_c_awh.wDY.fyY)) {
                                                x.i("MicroMsg.MallIndexMenuUI", "show red dot wording: %s", new Object[]{com_tencent_mm_protocal_c_awh.wDY.fyY});
                                                preferenceTitleCategory.ac(com_tencent_mm_protocal_c_awh.wDY.fyY, -1, Color.parseColor("#999999"));
                                            }
                                        } else {
                                            preferenceTitleCategory.EZ(0);
                                        }
                                    }
                                    preferenceTitleCategory.Fc(8);
                                    if (bh.ov(com_tencent_mm_protocal_c_awh.name)) {
                                        this.omf.put(i3 + com_tencent_mm_protocal_c_awh.name + com_tencent_mm_protocal_c_awh.szZ + com_tencent_mm_protocal_c_awh.title, com_tencent_mm_protocal_c_awh);
                                    } else {
                                        this.omf.put(com_tencent_mm_protocal_c_awh.name, com_tencent_mm_protocal_c_awh);
                                    }
                                    this.ilB.a(preferenceTitleCategory);
                                    int i5 = i3 + 1;
                                    obj2 = jSONObject.optInt(com_tencent_mm_protocal_c_awh.name, 0) == 1 ? 1 : null;
                                    com.tencent.mm.plugin.report.service.g gVar;
                                    Object[] objArr2;
                                    switch (com_tencent_mm_protocal_c_awh.szZ) {
                                        case 1:
                                            gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                            objArr2 = new Object[5];
                                            objArr2[0] = Integer.valueOf(1);
                                            objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                            objArr2[2] = com_tencent_mm_protocal_c_awh.sAa;
                                            objArr2[3] = "";
                                            objArr2[4] = Integer.valueOf(1);
                                            gVar.h(14872, objArr2);
                                            i3 = i5;
                                            break;
                                        case 2:
                                            gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                            objArr2 = new Object[5];
                                            objArr2[0] = Integer.valueOf(2);
                                            objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                            objArr2[2] = "";
                                            objArr2[3] = com_tencent_mm_protocal_c_awh.sAb;
                                            objArr2[4] = Integer.valueOf(1);
                                            gVar.h(14872, objArr2);
                                            i3 = i5;
                                            break;
                                        case 3:
                                            gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                            objArr2 = new Object[5];
                                            objArr2[0] = Integer.valueOf(3);
                                            objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                            objArr2[2] = "";
                                            objArr2[3] = "";
                                            objArr2[4] = Integer.valueOf(1);
                                            gVar.h(14872, objArr2);
                                            i3 = i5;
                                            break;
                                        case 4:
                                            gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                            objArr2 = new Object[5];
                                            objArr2[0] = Integer.valueOf(4);
                                            objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                            objArr2[2] = "";
                                            objArr2[3] = "";
                                            objArr2[4] = Integer.valueOf(1);
                                            gVar.h(14872, objArr2);
                                            i3 = i5;
                                            break;
                                        case 5:
                                            gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                            objArr2 = new Object[5];
                                            objArr2[0] = Integer.valueOf(5);
                                            objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                            objArr2[2] = "";
                                            objArr2[3] = "";
                                            objArr2[4] = Integer.valueOf(1);
                                            gVar.h(14872, objArr2);
                                            i3 = i5;
                                            break;
                                        case 8:
                                            gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                            objArr2 = new Object[5];
                                            objArr2[0] = Integer.valueOf(8);
                                            objArr2[1] = Integer.valueOf(obj2 != null ? 1 : 0);
                                            objArr2[2] = com_tencent_mm_protocal_c_awh.sAa;
                                            objArr2[3] = "";
                                            objArr2[4] = Integer.valueOf(1);
                                            gVar.h(14872, objArr2);
                                            break;
                                    }
                                    i3 = i5;
                                }
                                i4 = i3;
                                obj2 = null;
                            }
                            obj = obj2;
                            i3 = i4;
                        }
                        return;
                    }
                    return;
                }
                jSONObject = jSONObject2;
                if (com_tencent_mm_protocal_c_aej.wmF != null) {
                    return;
                }
                return;
            }
            return;
        }
        x.e("MicroMsg.MallIndexMenuUI", "GetPayMenu error!");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            g.Dk();
            this.okQ = ((Integer) g.Dj().CU().get(a.xrD, Integer.valueOf(0))).intValue();
            if (i2 != -1) {
                return;
            }
            if (q.Gg()) {
                finish();
                return;
            }
            finish();
            com.tencent.mm.sdk.b.b nkVar = new nk();
            nkVar.fFu.context = this.mController.xIM;
            com.tencent.mm.sdk.b.a.xef.m(nkVar);
        }
    }
}
