package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.net.http.SslError;
import android.util.Base64;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.h;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141210", reviewer = 20, vComment = {EType.HTTPSCHECK})
public final class b {
    Context context;
    private final SimpleDateFormat pIX = new SimpleDateFormat("yyyy-MM-dd HH:mmZ", Locale.getDefault());
    WebView twx;
    Map<String, List<h>> twy;
    Map<String, Boolean> twz;

    public b(Context context, WebView webView) {
        this.context = context;
        this.twx = webView;
        this.twy = new HashMap();
        this.twz = new HashMap();
    }

    public final void a(String str, h hVar, SslError sslError) {
        x.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, currentUrl = %s", str);
        if (this.twx == null) {
            x.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError fail, has been detached");
        } else if (bh.ov(str)) {
            hVar.cancel();
        } else {
            try {
                URL url = new URL(str);
                if (url.getHost().endsWith(".qq.com") || url.getHost().endsWith(".linkedin.com")) {
                    Boolean bool = (Boolean) this.twz.get(str);
                    if (bool != null) {
                        x.v("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, already selected = %b", bool);
                        if (bool.booleanValue()) {
                            hVar.proceed();
                            return;
                        } else {
                            hVar.cancel();
                            return;
                        }
                    }
                    List list = (List) this.twy.get(str);
                    if (list == null || list.size() == 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("1");
                        stringBuilder.append(",");
                        stringBuilder.append(a(str, sslError));
                        x.i("MicroMsg.WebView.MMSslErrorHandler", "reportWebViewSslError, value = %s", stringBuilder.toString());
                        g.pQN.k(11098, r0);
                        list = new ArrayList();
                        list.add(hVar);
                        this.twy.put(str, list);
                        com.tencent.mm.ui.base.h.a(this.context, false, this.context.getString(R.l.eXT, new Object[]{url.getHost()}), this.context.getString(R.l.eXU), this.context.getString(R.l.dEr), this.context.getString(R.l.dDO), new 1(this, str), new 2(this, str));
                        return;
                    }
                    list.add(hVar);
                    return;
                }
                x.d("MicroMsg.WebView.MMSslErrorHandler", "host = " + url.getHost() + ", but it not end with '.qq.com' or '.linkedin.com'");
                hVar.cancel();
            } catch (Exception e) {
                x.e("MicroMsg.WebView.MMSslErrorHandler", "create url fail : " + e.getLocalizedMessage());
            }
        }
    }

    @TargetApi(14)
    private String a(String str, SslError sslError) {
        try {
            Object obj;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<sslerror>");
            stringBuilder.append("<primaryerror>");
            if (sslError == null) {
                obj = "-1";
            } else {
                obj = Integer.valueOf(sslError.getPrimaryError());
            }
            stringBuilder.append(obj);
            stringBuilder.append("</primaryerror>");
            stringBuilder.append("<clienttime>");
            stringBuilder.append(Base64.encodeToString(this.pIX.format(new Date()).getBytes(), 0));
            stringBuilder.append("</clienttime>");
            stringBuilder.append("<currenturl>");
            if (!bh.ov(str)) {
                stringBuilder.append(bh.VG(str));
            }
            stringBuilder.append("</currenturl>");
            SslCertificate certificate = sslError == null ? null : sslError.getCertificate();
            if (certificate != null) {
                DName issuedBy = certificate.getIssuedBy();
                if (issuedBy != null) {
                    stringBuilder.append("<issuedby>");
                    if (issuedBy.getDName() != null) {
                        stringBuilder.append(Base64.encodeToString(issuedBy.getDName().getBytes(), 0));
                    }
                    stringBuilder.append("</issuedby>");
                }
                issuedBy = certificate.getIssuedTo();
                if (issuedBy != null) {
                    stringBuilder.append("<issuedto>");
                    if (issuedBy.getDName() != null) {
                        stringBuilder.append(Base64.encodeToString(issuedBy.getDName().getBytes(), 0));
                    }
                    stringBuilder.append("</issuedto>");
                }
                String validNotAfter = certificate.getValidNotAfter();
                if (validNotAfter != null) {
                    stringBuilder.append("<getvalidnotafter>");
                    stringBuilder.append(Base64.encodeToString(validNotAfter.getBytes(), 0));
                    stringBuilder.append("</getvalidnotafter>");
                }
                String validNotBefore = certificate.getValidNotBefore();
                if (validNotBefore != null) {
                    stringBuilder.append("<getvalidnotbefore>");
                    stringBuilder.append(Base64.encodeToString(validNotBefore.getBytes(), 0));
                    stringBuilder.append("</getvalidnotbefore>");
                }
            }
            stringBuilder.append("</sslerror>");
            return stringBuilder.toString();
        } catch (Exception e) {
            x.w("MicroMsg.WebView.MMSslErrorHandler", "buildXml ex = %s", e.getMessage());
            return "";
        }
    }
}
