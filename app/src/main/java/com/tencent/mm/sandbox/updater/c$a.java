package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

class c$a extends AsyncTask<String, Integer, Integer> {
    private int bmD;
    private HttpClient poq = null;
    private int size;
    final /* synthetic */ c xcI;
    private HttpPost xcK = null;
    private HttpResponse xcL = null;
    private HttpEntity xcM = null;
    private OutputStream xcN = new 1(this);
    private a xcx;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return E((String[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        this.xcx.a(((Integer) obj).intValue(), 0, null);
    }

    public c$a(c cVar, int i, int i2, a aVar) {
        this.xcI = cVar;
        this.size = i;
        this.bmD = i2;
        this.xcx = aVar;
    }

    private Integer E(String... strArr) {
        String str = strArr[0];
        if (str == null || str.length() == 0) {
            return Integer.valueOf(-1);
        }
        x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + str + ", range=" + this.bmD);
        this.poq = new DefaultHttpClient();
        this.poq.getParams().setIntParameter("http.connection.timeout", 15000);
        this.xcK = new HttpPost(str);
        this.xcK.addHeader("RANGE", "bytes=" + this.bmD + "-" + (this.size - this.bmD > 1048576 ? Integer.valueOf((this.bmD + 1048576) - 1) : ""));
        this.xcx.fD(50);
        this.xcL = this.poq.execute(this.xcK);
        int statusCode = this.xcL.getStatusLine().getStatusCode();
        Integer valueOf;
        if (statusCode == 200 || statusCode == b.CTRL_INDEX) {
            try {
                if (c.g(this.xcI) && r.idi && Math.random() > 0.2d) {
                    x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
                    valueOf = Integer.valueOf(-1);
                    if (this.xcK != null) {
                        this.xcK.abort();
                    }
                    if (this.xcM != null) {
                        try {
                            this.xcM.consumeContent();
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                        }
                    }
                    if (this.poq == null) {
                        return valueOf;
                    }
                    this.poq.getConnectionManager().shutdown();
                    return valueOf;
                }
                this.xcL.getHeaders("Content-Length");
                if (this.bmD > this.size) {
                    x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
                    valueOf = Integer.valueOf(-2);
                    if (this.xcK != null) {
                        this.xcK.abort();
                    }
                    if (this.xcM != null) {
                        try {
                            this.xcM.consumeContent();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2, "", new Object[0]);
                        }
                    }
                    if (this.poq == null) {
                        return valueOf;
                    }
                    this.poq.getConnectionManager().shutdown();
                    return valueOf;
                }
                this.xcM = this.xcL.getEntity();
                this.xcM.writeTo(this.xcN);
                this.xcM.consumeContent();
                valueOf = Integer.valueOf(0);
                if (this.xcK != null) {
                    this.xcK.abort();
                }
                if (this.xcM != null) {
                    try {
                        this.xcM.consumeContent();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e22, "", new Object[0]);
                    }
                }
                if (this.poq == null) {
                    return valueOf;
                }
                this.poq.getConnectionManager().shutdown();
                return valueOf;
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "", new Object[0]);
                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "exception current in download pack", new Object[0]);
                if (this.xcK != null) {
                    this.xcK.abort();
                }
                if (this.xcM != null) {
                    try {
                        this.xcM.consumeContent();
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e32, "", new Object[0]);
                    }
                }
                if (this.poq != null) {
                    this.poq.getConnectionManager().shutdown();
                }
                return Integer.valueOf(-1);
            } catch (Throwable th) {
                if (this.xcK != null) {
                    this.xcK.abort();
                }
                if (this.xcM != null) {
                    try {
                        this.xcM.consumeContent();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e222, "", new Object[0]);
                    }
                }
                if (this.poq != null) {
                    this.poq.getConnectionManager().shutdown();
                }
            }
        } else {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:" + statusCode);
            if (statusCode == 416) {
                valueOf = Integer.valueOf(-2);
                if (this.xcK != null) {
                    this.xcK.abort();
                }
                if (this.xcM != null) {
                    try {
                        this.xcM.consumeContent();
                    } catch (Throwable e2222) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2222, "", new Object[0]);
                    }
                }
                if (this.poq == null) {
                    return valueOf;
                }
                this.poq.getConnectionManager().shutdown();
                return valueOf;
            }
            valueOf = Integer.valueOf(-1);
            if (this.xcK != null) {
                this.xcK.abort();
            }
            if (this.xcM != null) {
                try {
                    this.xcM.consumeContent();
                } catch (Throwable e22222) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e22222, "", new Object[0]);
                }
            }
            if (this.poq == null) {
                return valueOf;
            }
            this.poq.getConnectionManager().shutdown();
            return valueOf;
        }
    }

    protected final void onCancelled() {
        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
        if (this.xcK != null) {
            this.xcK.abort();
        }
        if (this.xcM != null) {
            try {
                this.xcM.consumeContent();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
            }
        }
        if (this.poq != null) {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
            this.poq.getConnectionManager().shutdown();
        }
    }
}
