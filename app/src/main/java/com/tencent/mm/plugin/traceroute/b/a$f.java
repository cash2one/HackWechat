package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

class a$f extends ConcurrentHashMap<String, ConcurrentHashMap<Integer, StringBuilder>> {
    final /* synthetic */ a seZ;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int sfa;
        final /* synthetic */ String sfb;
        final /* synthetic */ PByteArray sfc;
        final /* synthetic */ a$f sfd;

        AnonymousClass1(a$f com_tencent_mm_plugin_traceroute_b_a_f, int i, String str, PByteArray pByteArray) {
            this.sfd = com_tencent_mm_plugin_traceroute_b_a_f;
            this.sfa = i;
            this.sfb = str;
            this.sfc = pByteArray;
        }

        public final void run() {
            String str = "http://" + ac.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str + "/cgi-bin/mmsupport-bin/stackreport?version=");
            stringBuffer.append(Integer.toHexString(d.vAz));
            stringBuffer.append("&devicetype=");
            stringBuffer.append(d.DEVICE_TYPE);
            stringBuffer.append("&filelength=");
            stringBuffer.append(this.sfa);
            stringBuffer.append("&sum=");
            stringBuffer.append(this.sfb);
            stringBuffer.append("&reporttype=");
            stringBuffer.append(4);
            if (!(this.sfd.seZ.userName == null || this.sfd.seZ.userName.equals(""))) {
                stringBuffer.append("&username=");
                stringBuffer.append(this.sfd.seZ.userName);
            }
            x.d("MicroMsg.MMTraceRoute", "traceroute report url:" + stringBuffer.toString());
            a$f.a(this.sfd, stringBuffer.toString(), this.sfc.value);
        }
    }

    private a$f(a aVar) {
        this.seZ = aVar;
    }

    static /* synthetic */ void a(a$f com_tencent_mm_plugin_traceroute_b_a_f, String str, byte[] bArr) {
        DefaultHttpClient defaultHttpClient;
        HttpUriRequest httpPost;
        int i = 3;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                defaultHttpClient = new DefaultHttpClient();
                httpPost = new HttpPost(str);
                try {
                    break;
                } catch (Throwable e) {
                    x.e("MicroMsg.MMTraceRoute", "http post IllegalStateException: " + e.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                    i = i2;
                } catch (Throwable e2) {
                    x.e("MicroMsg.MMTraceRoute", "http post IOException: " + e2.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                    i = i2;
                }
            } else {
                a.a(com_tencent_mm_plugin_traceroute_b_a_f.seZ);
                return;
            }
        }
        HttpEntity byteArrayEntity = new ByteArrayEntity(bArr);
        byteArrayEntity.setContentType("binary/octet-stream");
        httpPost.setEntity(byteArrayEntity);
        x.i("MicroMsg.MMTraceRoute", "http pose returnContent : " + bh.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()));
        a aVar = com_tencent_mm_plugin_traceroute_b_a_f.seZ;
        if (aVar.seW != null) {
            aVar.seW.bFw();
        }
    }
}
