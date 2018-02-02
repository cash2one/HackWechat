package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

public final class q {
    private static q Abe = null;
    private File Abd = null;
    public String Abf = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    public String Abg = "http://log.tbs.qq.com/ajax?c=pu&tk=";
    private String Abh = "http://wup.imtt.qq.com:8080";
    public String Abi = "http://log.tbs.qq.com/ajax?c=dl&k=";
    public String Abj = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
    public String Abk = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
    private String Abl = "http://mqqad.html5.qq.com/adjs";
    private String Abm = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
    private Context mContext = null;

    @TargetApi(11)
    private q(Context context) {
        TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.mContext = context.getApplicationContext();
        cFE();
    }

    public static synchronized q cFD() {
        q qVar;
        synchronized (q.class) {
            qVar = Abe;
        }
        return qVar;
    }

    private synchronized void cFE() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Writer stringWriter;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File cFF = cFF();
            if (cFF == null) {
                TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e) {
                    }
                }
            } else {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(cFF));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    String property = properties.getProperty("pv_post_url", "");
                    if (!"".equals(property)) {
                        this.Abf = property;
                    }
                    property = properties.getProperty("wup_proxy_domain", "");
                    if (!"".equals(property)) {
                        this.Abh = property;
                    }
                    property = properties.getProperty("tbs_download_stat_post_url", "");
                    if (!"".equals(property)) {
                        this.Abi = property;
                    }
                    property = properties.getProperty("tbs_downloader_post_url", "");
                    if (!"".equals(property)) {
                        this.Abj = property;
                    }
                    property = properties.getProperty("tbs_log_post_url", "");
                    if (!"".equals(property)) {
                        this.Abk = property;
                    }
                    property = properties.getProperty("tips_url", "");
                    if (!"".equals(property)) {
                        this.Abl = property;
                    }
                    property = properties.getProperty("tbs_cmd_post_url", "");
                    if (!"".equals(property)) {
                        this.Abm = property;
                    }
                    String property2 = properties.getProperty("pv_post_url_tk", "");
                    if (!"".equals(property2)) {
                        this.Abg = property2;
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = bufferedInputStream2;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
        return;
    }

    private File cFF() {
        Throwable th;
        Writer stringWriter;
        File file;
        try {
            if (this.Abd == null) {
                this.Abd = new File(f.ar(this.mContext, 5));
                if (this.Abd == null || !this.Abd.isDirectory()) {
                    return null;
                }
            }
            file = new File(this.Abd, "tbsnet.conf");
            if (file.exists()) {
                try {
                    TbsLog.w("TbsCommonConfig", "pathc:" + file.getCanonicalPath());
                    return file;
                } catch (Throwable th2) {
                    th = th2;
                    stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
                    return file;
                }
            }
            TbsLog.e("TbsCommonConfig", "Get file(" + file.getCanonicalPath() + ") failed!");
            return null;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            file = null;
            th = th4;
            stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
            return file;
        }
    }

    public static synchronized q hZ(Context context) {
        q qVar;
        synchronized (q.class) {
            if (Abe == null) {
                Abe = new q(context);
            }
            qVar = Abe;
        }
        return qVar;
    }
}
