package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.HttpClientUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.protocol.jce.Response;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.ByteArrayBuffer;

class PostHttpRequest$1 implements Runnable {
    final /* synthetic */ PostHttpRequest this$0;
    final /* synthetic */ JceStruct val$sendRequest;

    PostHttpRequest$1(PostHttpRequest postHttpRequest, JceStruct jceStruct) {
        this.this$0 = postHttpRequest;
        this.val$sendRequest = jceStruct;
    }

    public void run() {
        HttpClient createHttpClient;
        Throwable e;
        JceStruct buildRequest = ProtocolPackage.buildRequest(this.val$sendRequest);
        byte[] buildPostData = ProtocolPackage.buildPostData(buildRequest);
        this.this$0.mHttpPost = new HttpPost("http://masdk.3g.qq.com/");
        this.this$0.mHttpPost.addHeader("User-Agent", "AssistantDownloader");
        this.this$0.mHttpPost.setEntity(new ByteArrayEntity(buildPostData));
        try {
            createHttpClient = HttpClientUtil.createHttpClient();
            try {
                HttpClientUtil.setProxy(createHttpClient);
                HttpResponse execute = createHttpClient.execute(this.this$0.mHttpPost);
                if (execute != null && execute.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer((int) entity.getContentLength());
                        InputStream content = entity.getContent();
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = content.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayBuffer.append(bArr, 0, read);
                        }
                        buildPostData = byteArrayBuffer.buffer();
                        if (buildPostData != null && buildPostData.length > 4) {
                            Response unpackPackage = ProtocolPackage.unpackPackage(buildPostData);
                            if (!(unpackPackage == null || unpackPackage.body == null)) {
                                JceStruct unpageageJceResponse = ProtocolPackage.unpageageJceResponse(this.val$sendRequest, unpackPackage.body);
                                if (unpageageJceResponse != null) {
                                    this.this$0.onFinished(this.val$sendRequest, unpageageJceResponse, unpackPackage.head.ret);
                                    this.this$0.mHttpPost = null;
                                    if (createHttpClient != null) {
                                        createHttpClient.getConnectionManager().shutdown();
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
                this.this$0.mHttpPost = null;
                if (createHttpClient != null) {
                    createHttpClient.getConnectionManager().shutdown();
                }
            } catch (ConnectTimeoutException e2) {
                e = e2;
                try {
                    x.printErrStackTrace("BaseHttpRequest", e, "", new Object[0]);
                    this.this$0.onFinished(buildRequest, null, 601);
                    this.this$0.mHttpPost = null;
                    if (createHttpClient != null) {
                        createHttpClient.getConnectionManager().shutdown();
                    }
                } catch (Throwable th) {
                    e = th;
                    this.this$0.mHttpPost = null;
                    if (createHttpClient != null) {
                        createHttpClient.getConnectionManager().shutdown();
                    }
                    throw e;
                }
            } catch (ConnectException e3) {
                e = e3;
                x.printErrStackTrace("BaseHttpRequest", e, "", new Object[0]);
                this.this$0.onFinished(buildRequest, null, 1);
                this.this$0.mHttpPost = null;
                if (createHttpClient != null) {
                    createHttpClient.getConnectionManager().shutdown();
                }
            } catch (SocketTimeoutException e4) {
                e = e4;
                x.printErrStackTrace("BaseHttpRequest", e, "", new Object[0]);
                this.this$0.onFinished(buildRequest, null, 602);
                this.this$0.mHttpPost = null;
                if (createHttpClient != null) {
                    createHttpClient.getConnectionManager().shutdown();
                }
            } catch (Exception e5) {
                e = e5;
                x.printErrStackTrace("BaseHttpRequest", e, "", new Object[0]);
                this.this$0.onFinished(this.val$sendRequest, null, 604);
                this.this$0.mHttpPost = null;
                if (createHttpClient != null) {
                    createHttpClient.getConnectionManager().shutdown();
                }
            }
        } catch (ConnectTimeoutException e6) {
            e = e6;
            createHttpClient = null;
            x.printErrStackTrace("BaseHttpRequest", e, "", new Object[0]);
            this.this$0.onFinished(buildRequest, null, 601);
            this.this$0.mHttpPost = null;
            if (createHttpClient != null) {
                createHttpClient.getConnectionManager().shutdown();
            }
        } catch (ConnectException e7) {
            e = e7;
            createHttpClient = null;
            x.printErrStackTrace("BaseHttpRequest", e, "", new Object[0]);
            this.this$0.onFinished(buildRequest, null, 1);
            this.this$0.mHttpPost = null;
            if (createHttpClient != null) {
                createHttpClient.getConnectionManager().shutdown();
            }
        } catch (SocketTimeoutException e8) {
            e = e8;
            createHttpClient = null;
            x.printErrStackTrace("BaseHttpRequest", e, "", new Object[0]);
            this.this$0.onFinished(buildRequest, null, 602);
            this.this$0.mHttpPost = null;
            if (createHttpClient != null) {
                createHttpClient.getConnectionManager().shutdown();
            }
        } catch (Exception e9) {
            e = e9;
            createHttpClient = null;
            x.printErrStackTrace("BaseHttpRequest", e, "", new Object[0]);
            this.this$0.onFinished(this.val$sendRequest, null, 604);
            this.this$0.mHttpPost = null;
            if (createHttpClient != null) {
                createHttpClient.getConnectionManager().shutdown();
            }
        } catch (Throwable th2) {
            e = th2;
            createHttpClient = null;
            this.this$0.mHttpPost = null;
            if (createHttpClient != null) {
                createHttpClient.getConnectionManager().shutdown();
            }
            throw e;
        }
    }
}
