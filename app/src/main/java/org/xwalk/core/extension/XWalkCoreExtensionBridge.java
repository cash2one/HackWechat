package org.xwalk.core.extension;

import android.content.Intent;
import org.xwalk.core.XWalkExtension;

class XWalkCoreExtensionBridge extends XWalkExtension implements XWalkExternalExtensionBridge {
    private XWalkExternalExtension mExtension;

    public XWalkCoreExtensionBridge(XWalkExternalExtension xWalkExternalExtension) {
        super(xWalkExternalExtension.getExtensionName(), xWalkExternalExtension.getJsApi(), xWalkExternalExtension.getEntryPoints());
        this.mExtension = xWalkExternalExtension;
    }

    public void onMessage(int i, String str) {
        this.mExtension.onMessage(i, str);
    }

    public void onBinaryMessage(int i, byte[] bArr) {
        this.mExtension.onBinaryMessage(i, bArr);
    }

    public String onSyncMessage(int i, String str) {
        return this.mExtension.onSyncMessage(i, str);
    }

    public void onInstanceCreated(int i) {
        this.mExtension.onInstanceCreated(i);
    }

    public void onInstanceDestroyed(int i) {
        this.mExtension.onInstanceDestroyed(i);
    }

    public void onDestroy() {
        this.mExtension.onDestroy();
    }

    public void onResume() {
        this.mExtension.onResume();
    }

    public void onPause() {
        this.mExtension.onPause();
    }

    public void onStart() {
        this.mExtension.onStart();
    }

    public void onStop() {
        this.mExtension.onStop();
    }

    public void onNewIntent(Intent intent) {
        this.mExtension.onNewIntent(intent);
    }

    public void postMessage(int i, String str) {
        super.postMessage(i, str);
    }

    public void postBinaryMessage(int i, byte[] bArr) {
        super.postBinaryMessage(i, bArr);
    }

    public void broadcastMessage(String str) {
        super.broadcastMessage(str);
    }
}
