package com.tencent.tmassistantsdk.network;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.HttpClientUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.util.TMLog;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class GetHttpRequest$1 implements Runnable {
    final /* synthetic */ GetHttpRequest this$0;
    final /* synthetic */ String val$param;

    GetHttpRequest$1(GetHttpRequest getHttpRequest, String str) {
        this.this$0 = getHttpRequest;
        this.val$param = str;
    }

    public void run() {
        HttpClient createHttpClient;
        Throwable e;
        String str = this.val$param;
        try {
            this.this$0.mHttpGet = new HttpGet();
            this.this$0.mHttpGet.setURI(new URI("http://appicsh.qq.com/cgi-bin/appstage/yyb_get_userapp_info" + str));
            createHttpClient = HttpClientUtil.createHttpClient();
            try {
                HttpClientUtil.setProxy(createHttpClient);
                HttpResponse execute = createHttpClient.execute(this.this$0.mHttpGet);
                if (execute != null && execute.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        byte[] toByteArray = EntityUtils.toByteArray(entity);
                        if (toByteArray == null || toByteArray.length <= 0) {
                            TMLog.i("NetworkTask", "data invalidate");
                            this.this$0.onFinished(null, 704);
                            this.this$0.mHttpGet = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                                return;
                            }
                            return;
                        }
                        Object str2 = new String(toByteArray, ProtocolPackage.ServerEncoding);
                        if (TextUtils.isEmpty(str2)) {
                            TMLog.i("NetworkTask", "failed to convert byte[] to string");
                            this.this$0.onFinished(null, 606);
                            this.this$0.mHttpGet = null;
                            if (createHttpClient != null) {
                                createHttpClient.getConnectionManager().shutdown();
                                return;
                            }
                            return;
                        }
                        JSONObject jSONObject = new JSONObject(str2);
                        TMLog.i("NetworkTask", "success to received data");
                        this.this$0.onFinished(jSONObject, 0);
                        this.this$0.mHttpGet = null;
                        if (createHttpClient != null) {
                            createHttpClient.getConnectionManager().shutdown();
                            return;
                        }
                        return;
                    }
                }
                this.this$0.onFinished(null, 704);
                this.this$0.mHttpGet = null;
                if (createHttpClient != null) {
                    createHttpClient.getConnectionManager().shutdown();
                }
            } catch (ConnectTimeoutException e2) {
                e = e2;
                try {
                    x.printErrStackTrace("NetworkTask", e, "", new Object[0]);
                    this.this$0.onFinished(null, 601);
                    this.this$0.mHttpGet = null;
                    if (createHttpClient != null) {
                        createHttpClient.getConnectionManager().shutdown();
                    }
                } catch (Throwable th) {
                    e = th;
                    this.this$0.mHttpGet = null;
                    if (createHttpClient != null) {
                        createHttpClient.getConnectionManager().shutdown();
                    }
                    throw e;
                }
            } catch (ConnectException e3) {
                e = e3;
                x.printErrStackTrace("NetworkTask", e, "", new Object[0]);
                this.this$0.onFinished(null, 1);
                this.this$0.mHttpGet = null;
                if (createHttpClient != null) {
                    createHttpClient.getConnectionManager().shutdown();
                }
            } catch (SocketTimeoutException e4) {
                e = e4;
                x.printErrStackTrace("NetworkTask", e, "", new Object[0]);
                this.this$0.onFinished(null, 602);
                this.this$0.mHttpGet = null;
                if (createHttpClient != null) {
                    createHttpClient.getConnectionManager().shutdown();
                }
            } catch (Exception e5) {
                e = e5;
                x.printErrStackTrace("NetworkTask", e, "", new Object[0]);
                this.this$0.onFinished(null, 604);
                this.this$0.mHttpGet = null;
                if (createHttpClient != null) {
                    createHttpClient.getConnectionManager().shutdown();
                }
            }
        } catch (ConnectTimeoutException e6) {
            e = e6;
            createHttpClient = null;
            x.printErrStackTrace("NetworkTask", e, "", new Object[0]);
            this.this$0.onFinished(null, 601);
            this.this$0.mHttpGet = null;
            if (createHttpClient != null) {
                createHttpClient.getConnectionManager().shutdown();
            }
        } catch (ConnectException e7) {
            e = e7;
            createHttpClient = null;
            x.printErrStackTrace("NetworkTask", e, "", new Object[0]);
            this.this$0.onFinished(null, 1);
            this.this$0.mHttpGet = null;
            if (createHttpClient != null) {
                createHttpClient.getConnectionManager().shutdown();
            }
        } catch (SocketTimeoutException e8) {
            e = e8;
            createHttpClient = null;
            x.printErrStackTrace("NetworkTask", e, "", new Object[0]);
            this.this$0.onFinished(null, 602);
            this.this$0.mHttpGet = null;
            if (createHttpClient != null) {
                createHttpClient.getConnectionManager().shutdown();
            }
        } catch (Exception e9) {
            e = e9;
            createHttpClient = null;
            x.printErrStackTrace("NetworkTask", e, "", new Object[0]);
            this.this$0.onFinished(null, 604);
            this.this$0.mHttpGet = null;
            if (createHttpClient != null) {
                createHttpClient.getConnectionManager().shutdown();
            }
        } catch (Throwable th2) {
            e = th2;
            createHttpClient = null;
            this.this$0.mHttpGet = null;
            if (createHttpClient != null) {
                createHttpClient.getConnectionManager().shutdown();
            }
            throw e;
        }
    }
}
