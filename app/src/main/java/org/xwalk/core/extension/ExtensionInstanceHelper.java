package org.xwalk.core.extension;

public class ExtensionInstanceHelper {
    XWalkExternalExtension mExtension;
    MessageHandler mHandler = new MessageHandler(this.mExtension.getMessageHandler());
    int mId;
    private BindingObjectStore mStore;

    public ExtensionInstanceHelper(XWalkExternalExtension xWalkExternalExtension, int i) {
        this.mId = i;
        this.mExtension = xWalkExternalExtension;
        if (this.mExtension.isAutoJS()) {
            ReflectionHelper.registerHandlers(this.mExtension.getReflection(), this.mHandler, this.mExtension);
        }
        this.mStore = new BindingObjectStore(this.mHandler, this);
    }

    public int getId() {
        return this.mId;
    }

    public XWalkExternalExtension getExtension() {
        return this.mExtension;
    }

    public BindingObject getBindingObject(String str) {
        return this.mStore.getBindingObject(str);
    }

    public boolean addBindingObject(String str, BindingObject bindingObject) {
        return this.mStore.addBindingObject(str, bindingObject);
    }

    public BindingObject removeBindingObject(String str) {
        return this.mStore.removeBindingObject(str);
    }

    public Object handleMessage(String str) {
        return this.mHandler.handleMessage(new MessageInfo(this.mExtension, this.mId, str));
    }

    public Object handleMessage(byte[] bArr) {
        return this.mHandler.handleMessage(new MessageInfo(this.mExtension, this.mId, bArr));
    }
}
