package org.xwalk.core.extension;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class XWalkExternalExtension {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkExternalExtension.class.desiredAssertionStatus());
    private Map<Integer, ExtensionInstanceHelper> instanceHelpers;
    protected String[] mEntryPoints;
    protected XWalkExtensionContextClient mExtensionContext;
    protected MessageHandler mHandler;
    protected String mJsApi;
    protected String mName;
    protected ReflectionHelper mReflection;
    protected boolean useJsStubGeneration;

    public XWalkExternalExtension(String str, String str2, XWalkExtensionContextClient xWalkExtensionContextClient) {
        this(str, str2, null, xWalkExtensionContextClient);
    }

    public XWalkExternalExtension(String str, String str2, String[] strArr, XWalkExtensionContextClient xWalkExtensionContextClient) {
        if ($assertionsDisabled || xWalkExtensionContextClient != null) {
            this.mName = str;
            this.mJsApi = str2;
            this.mEntryPoints = strArr;
            this.mExtensionContext = xWalkExtensionContextClient;
            this.instanceHelpers = new HashMap();
            this.mHandler = new MessageHandler();
            if (this.mJsApi == null || this.mJsApi.length() == 0) {
                this.useJsStubGeneration = true;
                this.mReflection = new ReflectionHelper(getClass());
                this.mJsApi = new JsStubGenerator(this.mReflection).generate();
                if (this.mJsApi == null || this.mJsApi.length() == 0) {
                    Log.e("Extension-" + this.mName, "Can't generate JavaScript stub for this extension.");
                    return;
                }
            }
            this.mReflection = null;
            this.useJsStubGeneration = false;
            this.mExtensionContext.registerExtension(this);
            return;
        }
        throw new AssertionError();
    }

    public final String getExtensionName() {
        return this.mName;
    }

    public final String getJsApi() {
        return this.mJsApi;
    }

    public final String[] getEntryPoints() {
        return this.mEntryPoints;
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onInstanceCreated(int i) {
        this.instanceHelpers.put(Integer.valueOf(i), new ExtensionInstanceHelper(this, i));
    }

    public void onInstanceDestroyed(int i) {
        this.instanceHelpers.remove(Integer.valueOf(i));
    }

    public boolean isAutoJS() {
        return this.useJsStubGeneration;
    }

    public void onMessage(int i, String str) {
        if (this.useJsStubGeneration) {
            getInstanceHelper(i).handleMessage(str);
        }
    }

    public void onBinaryMessage(int i, byte[] bArr) {
        if (this.useJsStubGeneration) {
            getInstanceHelper(i).handleMessage(bArr);
        }
    }

    public String onSyncMessage(int i, String str) {
        Object obj = null;
        if (this.useJsStubGeneration) {
            obj = getInstanceHelper(i).handleMessage(str);
        }
        return obj != null ? ReflectionHelper.objToJSON(obj) : "";
    }

    public ReflectionHelper getReflection() {
        return this.mReflection;
    }

    public MessageHandler getMessageHandler() {
        return this.mHandler;
    }

    public ReflectionHelper getTargetReflect(String str) {
        ReflectionHelper constructorReflection = this.mReflection.getConstructorReflection(str);
        return constructorReflection != null ? constructorReflection : this.mReflection;
    }

    protected ExtensionInstanceHelper getInstanceHelper(int i) {
        return (ExtensionInstanceHelper) this.instanceHelpers.get(Integer.valueOf(i));
    }

    public void sendEvent(String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "onEvent");
            jSONObject.put(DownloadSettingTable$Columns.TYPE, str);
            jSONObject.put("event", ReflectionHelper.objToJSON(obj));
            broadcastMessage(jSONObject.toString());
        } catch (Exception e) {
        }
    }

    public final void postMessage(int i, String str) {
        this.mExtensionContext.postMessage(this, i, str);
    }

    public final void postBinaryMessage(int i, byte[] bArr) {
        this.mExtensionContext.postBinaryMessage(this, i, bArr);
    }

    public final void broadcastMessage(String str) {
        this.mExtensionContext.broadcastMessage(this, str);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        throw new ActivityNotFoundException("This method is no longer supported");
    }
}
