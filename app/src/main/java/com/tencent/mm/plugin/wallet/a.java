package com.tencent.mm.plugin.wallet;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public int index = 0;
    public String sxX = "";
    public StringBuffer sxY = new StringBuffer();

    public static a cp(String str, int i) {
        a aVar = new a();
        aVar.sxX = str + "," + i;
        return aVar;
    }

    public final void i(int i, Object... objArr) {
        String str;
        if (objArr.length <= 0) {
            x.w("MicroMsg.PayLogReport", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                stringBuilder.append(String.valueOf(objArr[i2])).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            str = stringBuilder.toString();
        }
        aK(i, str);
    }

    public final void aK(int i, String str) {
        String format = String.format("{%d, %s, %d, %s},", new Object[]{Integer.valueOf(this.index), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), str});
        this.index++;
        x.i("MicroMsg.PayLogReport", "test for log " + format);
        this.sxY.append(format);
    }

    public static boolean a(a aVar, Intent intent) {
        if (aVar == null) {
            return false;
        }
        intent.putExtra("WECHAT_PAY_LOG_REPORT_INDEX", aVar.index);
        intent.putExtra("WECHAT_PAY_LOG_REPORT_DATA", aVar.sxY.toString());
        intent.putExtra("WECHAT_PAY_LOG_REPORT_BASEIFO", aVar.sxX);
        return true;
    }

    public static a X(Intent intent) {
        int intExtra = intent.getIntExtra("WECHAT_PAY_LOG_REPORT_INDEX", -1);
        if (intExtra == -1) {
            return null;
        }
        a aVar = new a();
        aVar.index = intExtra;
        aVar.sxY = new StringBuffer(bh.az(intent.getStringExtra("WECHAT_PAY_LOG_REPORT_DATA"), ""));
        aVar.sxX = bh.az(intent.getStringExtra("WECHAT_PAY_LOG_REPORT_BASEIFO"), "");
        return aVar;
    }
}
