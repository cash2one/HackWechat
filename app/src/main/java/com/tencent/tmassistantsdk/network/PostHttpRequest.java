package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.util.TMLog;
import org.apache.http.client.methods.HttpPost;

public abstract class PostHttpRequest {
    static final String REQUEST_SERVER_URL = "http://masdk.3g.qq.com/";
    static final String TAG = "BaseHttpRequest";
    HttpPost mHttpPost = null;

    public abstract void onFinished(JceStruct jceStruct, JceStruct jceStruct2, int i);

    public synchronized boolean sendRequest(JceStruct jceStruct) {
        if (jceStruct != null) {
            if (this.mHttpPost == null) {
                new Thread(new 1(this, jceStruct)).start();
            }
        }
        return false;
    }

    public synchronized void cancleRequest() {
        if (!(this.mHttpPost == null || this.mHttpPost.isAborted())) {
            TMLog.i(TAG, "BaseHttpRequest:" + this + " cancleRequest");
            try {
                this.mHttpPost.abort();
                this.mHttpPost = null;
            } catch (Throwable e) {
                x.printErrStackTrace(TAG, e, "", new Object[0]);
                this.mHttpPost = null;
            } catch (Throwable th) {
                this.mHttpPost = null;
            }
        }
    }
}
