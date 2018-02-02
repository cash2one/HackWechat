package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

final class bj$a {
    public String SNGAppId;
    public String actionFlag;
    public String neC;
    public String taskApkId;
    public String taskAppId;
    public String taskPackageName;
    public int taskVersion;
    public String uin;
    public String uinType;
    public String via;

    private bj$a() {
    }

    public final TMQQDownloaderOpenSDKParam Cb(String str) {
        x.i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", new Object[]{str});
        if (bh.ov(str)) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.taskApkId = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_APKID);
                this.via = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_VIA);
                this.taskVersion = jSONObject.optInt(OpenSDKTool4Assistant.EXTRA_TASK_VERSION);
                this.neC = jSONObject.optString("channelID");
                this.uin = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_UIN);
                this.SNGAppId = jSONObject.optString("SNGAppId");
                this.taskAppId = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_APPID);
                this.uinType = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_UINTYPE);
                this.taskPackageName = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_PACKAGENAME);
                this.actionFlag = jSONObject.optString("actionFlag");
            } catch (Exception e) {
                x.e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", new Object[]{e.getMessage()});
            }
        }
        return new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.neC, this.actionFlag);
    }
}
