package com.tencent.mm.sdk.d;

import android.os.Message;
import android.text.TextUtils;
import java.util.Calendar;

public class d$a {
    private d xiT;
    private long xiU;
    private int xiV;
    private String xiW;
    private a xiX;
    private a xiY;
    private a xiZ;

    d$a(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
        a(dVar, message, str, aVar, aVar2, aVar3);
    }

    public final void a(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
        this.xiT = dVar;
        this.xiU = System.currentTimeMillis();
        this.xiV = message != null ? message.what : 0;
        this.xiW = str;
        this.xiX = aVar;
        this.xiY = aVar2;
        this.xiZ = aVar3;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("time=");
        Calendar.getInstance().setTimeInMillis(this.xiU);
        stringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[]{r0, r0, r0, r0, r0, r0}));
        stringBuilder.append(" processed=");
        stringBuilder.append(this.xiX == null ? "<null>" : this.xiX.getName());
        stringBuilder.append(" org=");
        stringBuilder.append(this.xiY == null ? "<null>" : this.xiY.getName());
        stringBuilder.append(" dest=");
        stringBuilder.append(this.xiZ == null ? "<null>" : this.xiZ.getName());
        stringBuilder.append(" what=");
        Object obj = this.xiT != null ? null : "";
        if (TextUtils.isEmpty(obj)) {
            stringBuilder.append(this.xiV);
            stringBuilder.append("(0x");
            stringBuilder.append(Integer.toHexString(this.xiV));
            stringBuilder.append(")");
        } else {
            stringBuilder.append(obj);
        }
        if (!TextUtils.isEmpty(this.xiW)) {
            stringBuilder.append(" ");
            stringBuilder.append(this.xiW);
        }
        return stringBuilder.toString();
    }
}
