package com.tencent.mm.ag;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes$WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d$b {
    private String hoA;
    private List<f> hoB = null;
    private d hoC = null;
    private c hoD = null;
    private e hoE = null;
    a hoF = null;
    private boolean hoG = false;
    boolean hoH = false;
    int hoI;
    public boolean hoJ = false;
    public int hoK = 0;
    private int hoL = 0;
    private String hoM;
    private b hoN = null;
    private int hoO = 0;
    private int hoP = d.hon;
    private String hoQ;
    private boolean hoR = false;
    public int hoS;
    private g hoT;
    private String hoU;
    private String hoV;
    private boolean hoW = false;
    public a hoX;
    private List<WxaAttributes$WxaEntryInfo> hoY;
    public JSONObject hou = null;
    private boolean hov = true;
    public boolean how = false;
    public boolean hox = false;
    public boolean hoy = false;
    private String hoz;

    public static class e {
        public int hpp;
        public String hpq;
        public List<String> hpr;
        public String hps;

        public static e jI(String str) {
            if (bh.ov(str)) {
                return null;
            }
            try {
                e eVar = new e();
                JSONObject jSONObject = new JSONObject(str);
                eVar.hpp = jSONObject.optInt("reputation_level", -1);
                eVar.hpq = jSONObject.optString("scope_of_business");
                eVar.hps = jSONObject.optString("guarantee_detail_h5_url");
                JSONArray optJSONArray = jSONObject.optJSONArray("guarantee_info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    if (length > 0) {
                        eVar.hpr = new ArrayList();
                        for (int i = 0; i < length; i++) {
                            String string = optJSONArray.getString(i);
                            if (!bh.ov(string)) {
                                eVar.hpr.add(string);
                            }
                        }
                    }
                }
                return eVar;
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bh.i(e)});
                return null;
            }
        }
    }

    public final List<WxaAttributes$WxaEntryInfo> Lo() {
        if (this.hoY == null) {
            this.hoY = new LinkedList();
            if (this.hou != null) {
                JSONObject jSONObject;
                JSONArray optJSONArray;
                int i;
                JSONObject optJSONObject;
                Object optString;
                Object optString2;
                Object optString3;
                String optString4;
                WxaAttributes$WxaEntryInfo wxaAttributes$WxaEntryInfo;
                Object optString5 = this.hou.optString("BindWxaInfo");
                if (!TextUtils.isEmpty(optString5)) {
                    try {
                        jSONObject = new JSONObject(optString5);
                    } catch (JSONException e) {
                    }
                    if (jSONObject == null) {
                        optJSONArray = jSONObject.optJSONArray("wxaEntryInfo");
                    } else {
                        optJSONArray = null;
                    }
                    if (optJSONArray != null) {
                        for (i = 0; i < optJSONArray.length(); i++) {
                            optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                optString = optJSONObject.optString("username");
                                optString2 = optJSONObject.optString("title");
                                optString3 = optJSONObject.optString("title_key");
                                optString4 = optJSONObject.optString("icon_url");
                                if (!(TextUtils.isEmpty(optString) || (TextUtils.isEmpty(optString2) && TextUtils.isEmpty(optString3)))) {
                                    wxaAttributes$WxaEntryInfo = new WxaAttributes$WxaEntryInfo();
                                    wxaAttributes$WxaEntryInfo.username = optString;
                                    wxaAttributes$WxaEntryInfo.title = optString2;
                                    wxaAttributes$WxaEntryInfo.iPE = optString3;
                                    wxaAttributes$WxaEntryInfo.iconUrl = optString4;
                                    this.hoY.add(wxaAttributes$WxaEntryInfo);
                                }
                            }
                        }
                    }
                }
                jSONObject = null;
                if (jSONObject == null) {
                    optJSONArray = null;
                } else {
                    optJSONArray = jSONObject.optJSONArray("wxaEntryInfo");
                }
                if (optJSONArray != null) {
                    for (i = 0; i < optJSONArray.length(); i++) {
                        optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            optString = optJSONObject.optString("username");
                            optString2 = optJSONObject.optString("title");
                            optString3 = optJSONObject.optString("title_key");
                            optString4 = optJSONObject.optString("icon_url");
                            wxaAttributes$WxaEntryInfo = new WxaAttributes$WxaEntryInfo();
                            wxaAttributes$WxaEntryInfo.username = optString;
                            wxaAttributes$WxaEntryInfo.title = optString2;
                            wxaAttributes$WxaEntryInfo.iPE = optString3;
                            wxaAttributes$WxaEntryInfo.iconUrl = optString4;
                            this.hoY.add(wxaAttributes$WxaEntryInfo);
                        }
                    }
                }
            }
        }
        return this.hoY;
    }

    public final boolean Lp() {
        if (!(this.hou == null || this.hou.optJSONObject("WifiBizInfo") == null || this.hou.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") != 1)) {
            this.hoW = true;
        }
        return this.hoW;
    }

    public final boolean Lq() {
        if (this.hou != null) {
            this.hoP = bh.getInt(this.hou.optString("NotifyManage"), d.hon);
        }
        return this.hoP == d.hom;
    }

    public final String Lr() {
        if (this.hou != null) {
            this.hoz = this.hou.optString("VerifyContactPromptTitle");
        }
        return this.hoz;
    }

    public final String Ls() {
        if (this.hou != null) {
            this.hoU = this.hou.optString("TrademarkUrl");
        }
        return this.hoU;
    }

    public final String Lt() {
        if (this.hou != null) {
            this.hoV = this.hou.optString("TrademarkName");
        }
        return this.hoV;
    }

    public final String Lu() {
        if (this.hou != null) {
            this.hoA = this.hou.optString("ConferenceContactExpireTime");
        }
        return this.hoA;
    }

    public final List<f> Lv() {
        if (this.hou != null && this.hoB == null) {
            this.hoB = f.b(this.hou.optJSONArray("Privilege"));
        }
        return this.hoB;
    }

    public final int Lw() {
        if (this.hou != null) {
            this.hoO = this.hou.optInt("InteractiveMode");
        }
        return this.hoO;
    }

    public final e Lx() {
        if (this.hou != null && this.hoE == null) {
            this.hoE = e.jI(this.hou.optString("PayShowInfo"));
        }
        return this.hoE;
    }

    public final b Ly() {
        if (this.hou != null && this.hoN == null) {
            String optString = this.hou.optString("HardwareBizInfo");
            if (optString != null) {
                this.hoN = b.jE(optString);
            }
        }
        return this.hoN;
    }

    public final d Lz() {
        if (this.hou != null && this.hoC == null) {
            this.hoC = d.jH(this.hou.optString("VerifySource"));
        }
        return this.hoC;
    }

    public final g LA() {
        if (this.hou != null && this.hoT == null) {
            String optString = this.hou.optString("RegisterSource");
            if (optString != null) {
                this.hoT = g.jJ(optString);
            }
        }
        return this.hoT;
    }

    public final boolean La() {
        boolean z = false;
        if (this.hou != null) {
            if (bh.getInt(this.hou.optString("ReportLocationType"), 0) > 0) {
                z = true;
            }
            this.hoG = z;
        }
        return this.hoG;
    }

    public final boolean LB() {
        boolean z = true;
        if (this.hou != null) {
            if (bh.getInt(this.hou.optString("IsTrademarkProtection"), 0) != 1) {
                z = false;
            }
            this.hoR = z;
        }
        return this.hoR;
    }

    public final int LC() {
        if (this.hou != null) {
            this.hoL = this.hou.optInt("ServiceType", 0);
        }
        return this.hoL;
    }

    public final String LD() {
        if (this.hou != null) {
            this.hoM = this.hou.optString("SupportEmoticonLinkPrefix");
        }
        return this.hoM;
    }

    public final c LE() {
        if (this.hou != null && this.hoD == null) {
            String optString = this.hou.optString("MMBizMenu");
            if (optString != null) {
                this.hoD = c.jF(optString);
            }
        }
        return this.hoD;
    }

    public final String LF() {
        if (this.hou != null) {
            this.hoQ = this.hou.optString("ServicePhone");
        }
        return this.hoQ;
    }

    private d$b() {
    }

    static d$b jC(String str) {
        d$b com_tencent_mm_ag_d_b = new d$b();
        if (!bh.ov(str)) {
            try {
                System.currentTimeMillis();
                com_tencent_mm_ag_d_b.hou = new JSONObject(str);
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        return com_tencent_mm_ag_d_b;
    }

    public final a LG() {
        if (this.hou != null && this.hoF == null) {
            String optString = this.hou.optString("EnterpriseBizInfo");
            if (optString != null) {
                this.hoF = a.jG(optString);
            }
        }
        return this.hoF;
    }
}
