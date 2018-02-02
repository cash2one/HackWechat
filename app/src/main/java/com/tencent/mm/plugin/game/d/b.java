package com.tencent.mm.plugin.game.d;

import android.content.Context;
import com.tencent.mm.R;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private static Map<String, List<String>> nwX = new HashMap();
    private static Map<String, List<String>> nwY = new HashMap();
    public static HashMap<Long, Long> nwZ = new HashMap();
    public static HashMap<Long, String> nxa = new HashMap();

    public static String f(Context context, long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        if (nwZ.containsKey(Long.valueOf(j))) {
            if (timeInMillis - ((Long) nwZ.get(Long.valueOf(j))).longValue() >= 60000) {
                nwZ.remove(Long.valueOf(j));
            } else if (nxa.containsKey(Long.valueOf(j))) {
                return (String) nxa.get(Long.valueOf(j));
            }
        }
        int i;
        if ((timeInMillis - j) / 3600000 == 0) {
            i = (int) ((timeInMillis - j) / 60000);
            if (i <= 0) {
                i = 1;
            }
            String quantityString = context.getResources().getQuantityString(R.j.duu, i, new Object[]{Integer.valueOf(i)});
            nxa.put(Long.valueOf(j), quantityString);
            nwZ.put(Long.valueOf(j), Long.valueOf(timeInMillis));
            return quantityString;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
            timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
            if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                i = (int) (((gregorianCalendar2.getTimeInMillis() + 86400000) - j) / 86400000);
                if (i <= 0) {
                    i = 1;
                }
                quantityString = context.getResources().getQuantityString(R.j.duv, i, new Object[]{Integer.valueOf(i)});
                nxa.put(Long.valueOf(j), quantityString);
                nwZ.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                return quantityString;
            }
            quantityString = context.getString(R.l.eiV);
            nxa.put(Long.valueOf(j), quantityString);
            nwZ.put(Long.valueOf(j), Long.valueOf(timeInMillis));
            return quantityString;
        }
        i = (int) ((timeInMillis - j) / 3600000);
        if (i <= 0) {
            i = 1;
        }
        quantityString = context.getResources().getQuantityString(R.j.dut, i, new Object[]{Integer.valueOf(i)});
        nxa.put(Long.valueOf(j), quantityString);
        nwZ.put(Long.valueOf(j), Long.valueOf(timeInMillis));
        return quantityString;
    }
}
