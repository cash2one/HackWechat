package c.t.m.g;

import android.location.Location;
import android.os.Bundle;

public final class db {
    public static final Location a = new Location("EMPTY");

    public static String a(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http" + (cl.a().d("https") ? "s" : "") + "://lbs.map.qq.com/loc");
        stringBuilder.append("?");
        stringBuilder.append("c=1");
        stringBuilder.append("&mars=").append(i);
        stringBuilder.append("&obs=").append(i2);
        return stringBuilder.toString();
    }

    static {
        Bundle bundle = new Bundle();
    }
}
