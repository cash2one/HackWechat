package org.xwalk.core.extension;

public class BindingObject {
    private String TAG = "BindingObject";
    protected MessageHandler mHandler = new MessageHandler();
    protected ExtensionInstanceHelper mInstanceHelper;
    protected String mObjectId;

    public Object handleMessage(MessageInfo messageInfo) {
        return this.mHandler.handleMessage(messageInfo);
    }

    public void initBindingInfo(String str, ExtensionInstanceHelper extensionInstanceHelper) {
        this.mObjectId = str;
        this.mInstanceHelper = extensionInstanceHelper;
    }

    public void onJsDestroyed() {
    }

    public void onJsBound() {
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
}
