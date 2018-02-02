package org.xwalk.core.extension;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.xwalk.core.Log;

public class BindingObjectStore {
    private String TAG = "BindingObjectStore";
    private Map<String, BindingObject> mBindingObjects = new HashMap();
    private ExtensionInstanceHelper mInstance;

    public BindingObjectStore(MessageHandler messageHandler, ExtensionInstanceHelper extensionInstanceHelper) {
        this.mInstance = extensionInstanceHelper;
        messageHandler.register("JSObjectCollected", "onJSObjectCollected", this);
        messageHandler.register(JsStubGenerator.MSG_TO_OBJECT, "onPostMessageToObject", this);
        messageHandler.register(JsStubGenerator.MSG_TO_CLASS, "onPostMessageToClass", this);
    }

    public boolean addBindingObject(String str, BindingObject bindingObject) {
        if (this.mBindingObjects.containsKey(str)) {
            Log.w(this.TAG, "Existing binding object:\n" + str);
            return false;
        }
        bindingObject.initBindingInfo(str, this.mInstance);
        this.mBindingObjects.put(str, bindingObject);
        bindingObject.onJsBound();
        return true;
    }

    public BindingObject getBindingObject(String str) {
        return (BindingObject) this.mBindingObjects.get(str);
    }

    public BindingObject removeBindingObject(String str) {
        BindingObject bindingObject = (BindingObject) this.mBindingObjects.remove(str);
        if (bindingObject != null) {
            bindingObject.onJsDestroyed();
        }
        return bindingObject;
    }

    public void onJSObjectCollected(MessageInfo messageInfo) {
        removeBindingObject(messageInfo.getObjectId());
    }

    public Object onPostMessageToClass(MessageInfo messageInfo) {
        Object obj = null;
        JSONArray args = messageInfo.getArgs();
        try {
            MessageInfo messageInfo2 = new MessageInfo(messageInfo);
            String string = args.getString(0);
            args = args.getJSONArray(1);
            String string2 = args.getString(0);
            args = args.getJSONArray(1);
            messageInfo2.setJsName(string);
            messageInfo2.setArgs(args);
            obj = messageInfo.getExtension().getTargetReflect(string2).handleMessage(messageInfo2, null);
        } catch (JSONException e) {
            Log.e(this.TAG, e.toString());
        } catch (Exception e2) {
            Log.e(this.TAG, e2.toString());
        }
        return obj;
    }

    public Object onPostMessageToObject(MessageInfo messageInfo) {
        Exception e;
        try {
            BindingObject bindingObject = getBindingObject(messageInfo.getObjectId());
            MessageInfo messageInfo2 = new MessageInfo(messageInfo);
            if (messageInfo.getArgs() != null) {
                JSONArray args = messageInfo.getArgs();
                String string = args.getString(0);
                args = args.getJSONArray(1);
                messageInfo2.setJsName(string);
                messageInfo2.setArgs(args);
            } else {
                ByteBuffer binaryArgs = messageInfo.getBinaryArgs();
                binaryArgs.order(ByteOrder.LITTLE_ENDIAN);
                int position = binaryArgs.position();
                int i = binaryArgs.getInt(position);
                position += 4;
                int i2 = (4 - (i % 4)) + i;
                String str = new String(binaryArgs.array(), position, i);
                position += i2;
                binaryArgs = ByteBuffer.wrap(binaryArgs.array(), position, binaryArgs.array().length - position);
                messageInfo2.setJsName(str);
                messageInfo2.setBinaryArgs(binaryArgs);
            }
            if (bindingObject != null) {
                return bindingObject.handleMessage(messageInfo2);
            }
            return null;
        } catch (JSONException e2) {
            e = e2;
            Log.e(this.TAG, e.toString());
            return null;
        } catch (IndexOutOfBoundsException e3) {
            e = e3;
            Log.e(this.TAG, e.toString());
            return null;
        } catch (NullPointerException e4) {
            e = e4;
            Log.e(this.TAG, e.toString());
            return null;
        }
    }

    public void onStart() {
        for (Entry value : this.mBindingObjects.entrySet()) {
            ((BindingObject) value.getValue()).onStart();
        }
    }

    public void onResume() {
        for (Entry value : this.mBindingObjects.entrySet()) {
            ((BindingObject) value.getValue()).onResume();
        }
    }

    public void onPause() {
        for (Entry value : this.mBindingObjects.entrySet()) {
            ((BindingObject) value.getValue()).onPause();
        }
    }

    public void onStop() {
        for (Entry value : this.mBindingObjects.entrySet()) {
            ((BindingObject) value.getValue()).onStop();
        }
    }

    public void onDestroy() {
        for (Entry value : this.mBindingObjects.entrySet()) {
            ((BindingObject) value.getValue()).onDestroy();
        }
    }
}
