package org.xwalk.core.extension;

import org.json.JSONObject;

public class JsContextInfo {
    private int extInstanceId;
    private XWalkExternalExtension extensionClient;
    private String objectId;
    private Class<?> targetClass;

    JsContextInfo(int i, XWalkExternalExtension xWalkExternalExtension, Class<?> cls, String str) {
        this.extensionClient = xWalkExternalExtension;
        this.extInstanceId = i;
        this.objectId = str;
        this.targetClass = cls;
    }

    public String getTag() {
        return "Extension-" + this.extensionClient.getExtensionName();
    }

    public ReflectionHelper getTargetReflect() {
        return this.extensionClient.getTargetReflect(this.targetClass.getSimpleName());
    }

    public String getObjectId() {
        return this.objectId;
    }

    public XWalkExternalExtension getExtensionClient() {
        return this.extensionClient;
    }

    public String getConstructorName() {
        return this.targetClass.getSimpleName();
    }

    public void postMessage(JSONObject jSONObject) {
        this.extensionClient.postMessage(this.extInstanceId, jSONObject.toString());
    }

    public void postMessage(byte[] bArr) {
        this.extensionClient.postBinaryMessage(this.extInstanceId, bArr);
    }
}
