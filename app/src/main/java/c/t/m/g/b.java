package c.t.m.g;

import android.content.Context;

public final class b {
    public Context a;
    int b;
    public boolean c;
    public String d = "";
    public String e = "";
    String f = "0M100WJ33N1CQ08O";
    private int g = -1;

    public b(Context context, String str, String str2) {
        this.a = context.getApplicationContext();
        this.b = 100;
        this.c = true;
        this.d = str;
        this.e = str2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append("appid:" + this.b);
        stringBuilder.append(",uuid:" + this.d);
        stringBuilder.append(",channelid:" + this.e);
        stringBuilder.append(",isSDKMode:" + this.c);
        stringBuilder.append(",isTest:false");
        stringBuilder.append(",testAppid:" + this.g);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
