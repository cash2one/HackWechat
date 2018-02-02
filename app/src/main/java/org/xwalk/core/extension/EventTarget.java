package org.xwalk.core.extension;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class EventTarget extends BindingObject {
    private String TAG = "EventTarget";
    private Map<String, MessageInfo> mEvents = new HashMap();

    public EventTarget() {
        this.mHandler.register("addEventListener", this);
        this.mHandler.register("removeEventListener", this);
    }

    public void startEvent(String str) {
    }

    public void stopEvent(String str) {
    }

    public boolean isEventActive(String str) {
        return this.mEvents.containsKey(str);
    }

    public void dispatchEvent(String str) {
        dispatchEvent(str, null);
    }

    public void dispatchEvent(String str, JSONObject jSONObject) {
        try {
            if (this.mEvents.containsKey(str)) {
                MessageInfo messageInfo = (MessageInfo) this.mEvents.get(str);
                JSONArray jSONArray = new JSONArray();
                if (jSONObject != null) {
                    jSONArray.put(0, jSONObject);
                }
                messageInfo.postResult(jSONArray);
                return;
            }
            Log.w(this.TAG, "Attempt to dispatch to non-existing event :" + str);
        } catch (JSONException e) {
            Log.e(this.TAG, e.toString());
        }
    }

    public void onAddEventListener(MessageInfo messageInfo) {
        try {
            String string = messageInfo.getArgs().getString(0);
            if (this.mEvents.containsKey(string)) {
                Log.w(this.TAG, "Trying to re-add the event :" + string);
                return;
            }
            this.mEvents.put(string, messageInfo);
            startEvent(string);
        } catch (JSONException e) {
            Log.e(this.TAG, e.toString());
        }
    }

    public void onRemoveEventListener(MessageInfo messageInfo) {
        try {
            String string = messageInfo.getArgs().getString(0);
            if (this.mEvents.containsKey(string)) {
                stopEvent(string);
                this.mEvents.remove(string);
                return;
            }
            Log.w(this.TAG, "Attempt to remove non-existing event :" + string);
        } catch (JSONException e) {
            Log.e(this.TAG, e.toString());
        }
    }
}
