package com.tencent.mm.plugin.appbrand.config;

import android.util.Pair;
import com.tencent.mm.g.b.ej;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class WxaAttributes extends ej {
    public static final a iEJ;
    public static final String iPh;
    private a iPi;
    private c iPj;
    private d iPk;
    private List<WxaEntryInfo> iPl = null;
    private b iPm;

    static {
        a aVar = new a();
        aVar.hSY = new Field[19];
        aVar.columns = new String[20];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "usernameHash";
        aVar.xjA.put("usernameHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "usernameHash";
        aVar.columns[1] = "username";
        aVar.xjA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "nickname";
        aVar.xjA.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "brandIconURL";
        aVar.xjA.put("brandIconURL", "TEXT");
        stringBuilder.append(" brandIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "roundedSquareIconURL";
        aVar.xjA.put("roundedSquareIconURL", "TEXT");
        stringBuilder.append(" roundedSquareIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "bigHeadURL";
        aVar.xjA.put("bigHeadURL", "TEXT");
        stringBuilder.append(" bigHeadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "smallHeadURL";
        aVar.xjA.put("smallHeadURL", "TEXT");
        stringBuilder.append(" smallHeadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "signature";
        aVar.xjA.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "appOpt";
        aVar.xjA.put("appOpt", "INTEGER default '0' ");
        stringBuilder.append(" appOpt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "registerSource";
        aVar.xjA.put("registerSource", "TEXT");
        stringBuilder.append(" registerSource TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "appInfo";
        aVar.xjA.put("appInfo", "TEXT");
        stringBuilder.append(" appInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "versionInfo";
        aVar.xjA.put("versionInfo", "TEXT");
        stringBuilder.append(" versionInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "bindWxaInfo";
        aVar.xjA.put("bindWxaInfo", "TEXT");
        stringBuilder.append(" bindWxaInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "dynamicInfo";
        aVar.xjA.put("dynamicInfo", "TEXT");
        stringBuilder.append(" dynamicInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "reserved";
        aVar.xjA.put("reserved", "TEXT");
        stringBuilder.append(" reserved TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "syncTimeSecond";
        aVar.xjA.put("syncTimeSecond", "LONG default '0' ");
        stringBuilder.append(" syncTimeSecond LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "syncVersion";
        aVar.xjA.put("syncVersion", "TEXT");
        stringBuilder.append(" syncVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "bizMenu";
        aVar.xjA.put("bizMenu", "TEXT");
        stringBuilder.append(" bizMenu TEXT");
        aVar.columns[19] = "rowid";
        aVar.xjB = stringBuilder.toString();
        iEJ = aVar;
        iPh = i.a(aVar, "WxaAttributesTable");
    }

    protected final a Ac() {
        return iEJ;
    }

    public final a abZ() {
        if (this.iPi == null && !bh.ov(this.field_appInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(this.field_appInfo);
                this.iPi = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject("RunningFlagInfo");
                if (optJSONObject != null) {
                    this.iPi.iJK = optJSONObject.optLong("RunningFlag");
                    this.iPi.iPn = optJSONObject.optString("AppOpenForbiddenUrl");
                }
                optJSONObject = jSONObject.optJSONObject("Network");
                if (optJSONObject != null) {
                    this.iPi.iPp = s.f(optJSONObject.optJSONArray("RequestDomain"));
                    this.iPi.iPq = s.f(optJSONObject.optJSONArray("WsRequestDomain"));
                    this.iPi.iPr = s.f(optJSONObject.optJSONArray("UploadDomain"));
                    this.iPi.iPs = s.f(optJSONObject.optJSONArray("DownloadDomain"));
                }
                this.iPi.iPt = jSONObject.optString("Template");
                this.iPi.iPo = jSONObject.optInt("WechatPluginApp", 0);
                this.iPi.hoL = jSONObject.optInt("AppServiceType", 0);
                this.iPi.iPu = jSONObject.optString("fromBusinessUsername");
            } catch (Exception e) {
                this.iPi = null;
            }
        }
        return this.iPi;
    }

    public final c aca() {
        boolean z = true;
        int i = 0;
        if (this.iPj == null) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(this.field_dynamicInfo);
            } catch (Exception e) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.iPj = new c();
            JSONObject optJSONObject = jSONObject.optJSONObject("NewSetting");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.iPj.iPy.iPA = optJSONObject.optInt("MaxLocalstorageSize", 5);
            this.iPj.iPy.iPB = optJSONObject.optInt("MaxCodeSize", 5);
            this.iPj.iPy.iOo = optJSONObject.optInt("ExpendedMaxWebviewDepth", 5);
            this.iPj.iPy.iOp = optJSONObject.optInt("MaxBackgroundLifespan", 600);
            this.iPj.iPy.iOq = optJSONObject.optInt("MaxRequestConcurrent", 5);
            this.iPj.iPy.iOr = optJSONObject.optInt("MaxUploadConcurrent", 5);
            this.iPj.iPy.iOs = optJSONObject.optInt("MaxDownloadConcurrent", 5);
            this.iPj.iPy.iOt = optJSONObject.optInt("MaxWebsocketConnect", 2);
            this.iPj.iPy.iOu = optJSONObject.optInt("MaxWorkerConcurrent", 1);
            this.iPj.iPy.iOv = optJSONObject.optInt("WebsocketSkipPortCheck", 0) != 0;
            this.iPj.iPy.iPC = optJSONObject.optInt("MaxFileStorageSize", 10);
            this.iPj.iPy.iPD = optJSONObject.optInt("BackgroundNetworkInterruptedTimeout", 5);
            a aVar = this.iPj.iPy;
            if (optJSONObject.optInt("CanKeepAliveByAudioPlay", 0) <= 0) {
                z = false;
            }
            aVar.iOE = z;
            this.iPj.iPy.iOF = optJSONObject.optInt("LifeSpanBeforeSuspend", 5);
            this.iPj.iPy.iOG = optJSONObject.optInt("LifeSpanAfterSuspend", 300);
            JSONArray optJSONArray = jSONObject.optJSONArray("NewCategories");
            if (optJSONArray != null) {
                this.iPj.iPz = new LinkedList();
                while (i < optJSONArray.length()) {
                    optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.iPj.iPz.add(new Pair(optJSONObject.optString("first"), optJSONObject.optString("second")));
                    }
                    i++;
                }
            }
        }
        return this.iPj;
    }

    public final d acb() {
        if (this.iPk == null && !bh.ov(this.field_versionInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(this.field_versionInfo);
                this.iPk = new d();
                this.iPk.fIm = jSONObject.optInt("AppVersion", 0);
                this.iPk.iPF = jSONObject.optInt("VersionState", -1);
                this.iPk.iPG = jSONObject.optString("VersionMD5");
                this.iPk.iMG = jSONObject.optString("device_orientation");
                this.iPk.iNU = jSONObject.optString("client_js_ext_info");
                this.iPk.iPH = jSONObject.optInt("code_size");
                JSONArray optJSONArray = jSONObject.optJSONArray("module_list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.iPk.iPI = new LinkedList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            e eVar = new e();
                            eVar.fqR = optJSONObject.optString("md5");
                            eVar.name = optJSONObject.optString("name");
                            this.iPk.iPI.add(eVar);
                        }
                    }
                }
                this.iPk.iPJ = jSONObject.optBoolean("UseModule", false);
                this.iPk.iPK = jSONObject.optString("EntranceModule");
            } catch (Exception e) {
                this.iPk = null;
            }
        }
        return this.iPk;
    }

    public final List<WxaEntryInfo> acc() {
        if (this.iPl == null && !bh.ov(this.field_bindWxaInfo)) {
            try {
                JSONArray optJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
                if (optJSONArray != null) {
                    this.iPl = new LinkedList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("username");
                            if (!bh.ov(optString)) {
                                WxaEntryInfo wxaEntryInfo = new WxaEntryInfo();
                                wxaEntryInfo.username = optString;
                                wxaEntryInfo.title = optJSONObject.optString("title");
                                wxaEntryInfo.iconUrl = optJSONObject.optString("icon_url");
                                this.iPl.add(wxaEntryInfo);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                this.iPl = null;
            }
        }
        return this.iPl;
    }

    public final b acd() {
        if (this.iPm == null && !bh.ov(this.field_bizMenu)) {
            try {
                JSONObject jSONObject = new JSONObject(this.field_bizMenu);
                this.iPm = new b();
                this.iPm.hoO = jSONObject.optInt("interactive_mode", 0);
                this.iPm.type = jSONObject.optInt(DownloadSettingTable$Columns.TYPE, 0);
                this.iPm.iPw = e(jSONObject.optJSONArray("button_list"));
            } catch (Exception e) {
                this.iPm = null;
            }
        }
        return this.iPm;
    }

    private List<a> e(JSONArray jSONArray) {
        List<a> arrayList;
        if (jSONArray != null) {
            arrayList = new ArrayList();
            try {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    a aVar = new a();
                    aVar.name = jSONObject.optString("name", "");
                    aVar.type = jSONObject.optInt(DownloadSettingTable$Columns.TYPE);
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(DownloadSettingTable$Columns.VALUE, ""));
                    aVar.userName = jSONObject2.optString("userName", "");
                    aVar.fnq = jSONObject2.optString("pagePath", "");
                    aVar.version = jSONObject2.optInt("version");
                    aVar.iPx = e(jSONObject.optJSONArray("sub_button_list"));
                    arrayList.add(aVar);
                }
            } catch (JSONException e) {
                return null;
            }
        }
        arrayList = null;
        return arrayList;
    }

    public final String toString() {
        return "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_brandIconURL='" + this.field_brandIconURL + '\'' + ", field_roundedSquareIconURL='" + this.field_roundedSquareIconURL + '\'' + ", field_bigHeadURL='" + this.field_bigHeadURL + '\'' + ", field_smallHeadURL='" + this.field_smallHeadURL + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_appOpt=" + this.field_appOpt + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + ", field_bizMenu='" + this.field_bizMenu + '\'' + '}';
    }
}
