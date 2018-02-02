package com.tencent.smtt.sdk;

import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.utils.TbsLog;

public class v$b implements Cloneable {
    int mErrorCode;
    private String zYA;
    long zYB;
    long zYm;
    String zYn;
    String zYo;
    int zYp;
    int zYq;
    int zYr;
    int zYs;
    String zYt;
    int zYu;
    int zYv;
    long zYw;
    long zYx;
    int zYy;
    private String zYz;

    private v$b() {
        cDZ();
    }

    public final void abk(String str) {
        setErrorCode(108);
        this.zYz = str;
    }

    public final void abl(String str) {
        if (str != null) {
            if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            this.zYA = str;
        }
    }

    public final void cDZ() {
        this.zYm = 0;
        this.zYn = null;
        this.zYo = null;
        this.zYp = 0;
        this.zYq = 0;
        this.zYr = 0;
        this.zYs = 2;
        this.zYt = "unknown";
        this.zYu = 0;
        this.zYv = 2;
        this.zYw = 0;
        this.zYx = 0;
        this.zYy = 1;
        this.mErrorCode = 0;
        this.zYz = null;
        this.zYA = null;
        this.zYB = 0;
    }

    protected final Object clone() {
        Object clone;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return clone;
    }

    public final void m(Throwable th) {
        if (th == null) {
            this.zYA = "";
            return;
        }
        String stackTraceString = Log.getStackTraceString(th);
        if (stackTraceString.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            stackTraceString = stackTraceString.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.zYA = stackTraceString;
    }

    public final void setErrorCode(int i) {
        if (!(i == 100 || i == 110 || i == 120 || i == 111 || i >= 400)) {
            TbsLog.i("TbsDownload", "error occured, errorCode:" + i, true);
        }
        if (i == 111) {
            TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
        }
        this.mErrorCode = i;
    }
}
