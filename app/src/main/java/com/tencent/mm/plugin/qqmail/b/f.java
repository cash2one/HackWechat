package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.plugin.qqmail.b.h.a;
import com.tencent.mm.plugin.qqmail.b.h.b;
import com.tencent.mm.plugin.qqmail.b.h.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.security.InvalidParameterException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public final class f extends h {
    private static final String BOUNDARY = ("WEIXIN" + System.currentTimeMillis());
    private HttpPost pom;

    public final c a(String str, String str2, b bVar, a aVar) {
        c cVar;
        int i = 0;
        x.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + bVar);
        HttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            String a = a(bVar);
            String str3 = bVar.poz.filePath;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\r\n");
            stringBuilder.append("------" + BOUNDARY + "--\r\n");
            HttpEntity aVar2 = new a(this, a, str3, stringBuilder.toString());
            this.pom = new HttpPost(h.b(str, str2, bVar.pox));
            this.pom.setHeader("User-Agent", aBs);
            this.pom.setHeader("Host", host);
            this.pom.setHeader("Connection", "Keep-Alive");
            this.pom.setHeader("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.pom.setHeader("Cookie", h.M(bVar.poy));
            this.pom.setEntity(aVar2);
            HttpResponse execute = defaultHttpClient.execute(this.pom);
            i = execute.getStatusLine().getStatusCode();
            HttpEntity entity = execute.getEntity();
            str3 = execute.getFirstHeader("set-cookie").getValue();
            cVar = new c(i, h.HI(str3), EntityUtils.toString(entity));
            x.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + cVar);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.HttpClientUtil", e, "", new Object[0]);
            if (i == 0) {
                i = 503;
            }
            cVar = new c(i, null, null);
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
        return cVar;
    }

    public final void cancel() {
        x.d("MicroMsg.HttpClientUtil", "cancel conection.");
        if (this.pom != null && !this.pom.isAborted()) {
            this.pom.abort();
        }
    }

    private static String a(b bVar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : bVar.pox.keySet()) {
            String str2;
            stringBuilder.append("------" + BOUNDARY + "\r\n");
            stringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n");
            stringBuilder.append("\r\n");
            stringBuilder.append((String) bVar.pox.get(str2));
            stringBuilder.append("\r\n");
        }
        File file = new File(bVar.poz.filePath);
        if (file.isFile()) {
            str2 = file.getName();
            stringBuilder.append("------" + BOUNDARY + "\r\n");
            stringBuilder.append("Content-Disposition: form-data; name=\"" + bVar.poz.fwF + "\"; filename=\"" + str2 + "\"\r\n");
            stringBuilder.append("\r\n");
            return stringBuilder.toString();
        }
        throw new InvalidParameterException("The path to upload isnot a file.");
    }
}
