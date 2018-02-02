package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.utils.TbsLog;

public final class m {
    public static volatile int zXe = -1;
    private static m zXf = null;
    a zXb = null;
    boolean zXc = false;
    private final int zXd = 3;

    public class a {
        int[] zXg;
        int zXh;
        int zXi;

        public final String toString() {
            if ((this.zXi == this.zXh ? 1 : null) != null) {
                return "";
            }
            int i;
            StringBuilder stringBuilder = new StringBuilder("[");
            for (i = this.zXh; i < this.zXi; i++) {
                stringBuilder.append(String.valueOf(this.zXg[i]) + ",");
            }
            i = stringBuilder.length();
            return stringBuilder.delete(i - 1, i).append("]").toString();
        }
    }

    private m() {
    }

    public static m cEf() {
        if (zXf == null) {
            zXf = new m();
        }
        return zXf;
    }

    final synchronized void a(Context context, int i, Throwable th) {
        if (zXe == -1) {
            zXe = i;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, "code=%d,desc=%s", new Object[]{Integer.valueOf(i), String.valueOf(th)});
            if (th != null) {
                v hn = v.hn(context);
                String str = "NULL";
                if (th != null) {
                    str = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
                    if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    }
                }
                hn.bd(i, str);
            } else {
                TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + i + "; Check & correct it!");
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder("setLoadErrorCode :: error(");
            stringBuilder.append(zXe);
            stringBuilder.append(") was already reported; ");
            stringBuilder.append(i);
            stringBuilder.append(" is duplicated. Try to remove it!");
            TbsLog.w("TbsCoreLoadStat", stringBuilder.toString());
        }
    }

    final void ao(Context context, int i) {
        a(context, i, null);
        TbsLog.e("loaderror", String.valueOf(i));
    }
}
