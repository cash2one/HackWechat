package org.xwalk.core.extension;

import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class BindingObjectAutoJS extends BindingObject {
    public Object handleMessage(MessageInfo messageInfo) {
        Object obj = null;
        try {
            obj = this.mInstanceHelper.getExtension().getReflection().getReflectionByBindingClass(getClass().getName()).handleMessage(messageInfo, this);
        } catch (Exception e) {
            Log.e("BindingObjectAutoJs", e.toString());
        }
        return obj;
    }

    public JsContextInfo getJsContextInfo() {
        return new JsContextInfo(this.mInstanceHelper.getId(), this.mInstanceHelper.getExtension(), getClass(), this.mObjectId);
    }

    public static void invokeJsCallback(JsContextInfo jsContextInfo, String str, Object... objArr) {
        Object[] objArr2 = objArr;
        if (objArr2.length == 1 && (objArr2[0] instanceof JSONArray)) {
            Object obj = (JSONArray) objArr2[0];
        } else {
            JSONArray jSONArray = (JSONArray) ReflectionHelper.toSerializableObject(objArr);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "invokeCallback");
            jSONObject.put("callbackId", str);
            jSONObject.put("args", obj);
            jsContextInfo.postMessage(jSONObject);
        } catch (Exception e) {
        }
    }

    public void invokeJsCallback(String str, Object... objArr) {
        invokeJsCallback(getJsContextInfo(), str, objArr);
    }

    public static void invokeJsCallback(JsContextInfo jsContextInfo, byte[] bArr) {
        jsContextInfo.postMessage(bArr);
    }

    public void invokeJsCallback(byte[] bArr) {
        getJsContextInfo().postMessage(bArr);
    }

    public static void dispatchEvent(JsContextInfo jsContextInfo, String str, Object obj) {
        if (jsContextInfo.getTargetReflect().isEventSupported(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cmd", "dispatchEvent");
                jSONObject.put("constructorName", jsContextInfo.getConstructorName());
                jSONObject.put("objectId", jsContextInfo.getObjectId());
                jSONObject.put(DownloadSettingTable$Columns.TYPE, str);
                jSONObject.put("event", ReflectionHelper.toSerializableObject(obj));
                jsContextInfo.postMessage(jSONObject);
                return;
            } catch (Exception e) {
                return;
            }
        }
        Log.w(jsContextInfo.getTag(), "Unsupport event in extension: " + str);
    }

    public void dispatchEvent(String str, Object obj) {
        dispatchEvent(getJsContextInfo(), str, obj);
    }

    public static void sendEvent(JsContextInfo jsContextInfo, String str, Object obj) {
        jsContextInfo.getExtensionClient().sendEvent(str, obj);
    }

    public void sendEvent(String str, Object obj) {
        sendEvent(getJsContextInfo(), str, obj);
    }

    public static void updateProperty(JsContextInfo jsContextInfo, String str) {
        ReflectionHelper targetReflect = jsContextInfo.getTargetReflect();
        if (targetReflect.hasProperty(str).booleanValue()) {
            boolean z = targetReflect.getMemberInfo(str).isStatic;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cmd", "updateProperty");
                jSONObject.put("objectId", z ? "0" : jsContextInfo.getObjectId());
                jSONObject.put("constructorName", jsContextInfo.getConstructorName());
                jSONObject.put("name", str);
                jsContextInfo.postMessage(jSONObject);
                return;
            } catch (Exception e) {
                return;
            }
        }
        Log.w(jsContextInfo.getTag(), "Unexposed property in extension: " + str);
    }

    public void updateProperty(String str) {
        updateProperty(getJsContextInfo(), str);
    }
}
