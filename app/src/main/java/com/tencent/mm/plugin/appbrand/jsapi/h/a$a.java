package com.tencent.mm.plugin.appbrand.jsapi.h;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

enum a$a {
    YEAR(new SimpleDateFormat("yyyy", Locale.US)),
    MONTH(new SimpleDateFormat("yyyy-MM", Locale.US)),
    DAY(new SimpleDateFormat("yyyy-MM-dd", Locale.US));
    
    final DateFormat jpt;

    private a$a(DateFormat dateFormat) {
        this.jpt = dateFormat;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static a$a sI(String str) {
        int i = 0;
        String toLowerCase = str.substring(0, Math.max(0, Math.min(str.length(), 5))).toLowerCase();
        switch (toLowerCase.hashCode()) {
            case 99228:
                if (toLowerCase.equals("day")) {
                    i = 2;
                    break;
                }
            case 3704893:
                if (toLowerCase.equals("year")) {
                    break;
                }
            case 104080000:
                if (toLowerCase.equals("month")) {
                    i = 1;
                    break;
                }
            default:
                i = -1;
                break;
        }
        switch (i) {
            case 0:
                return YEAR;
            case 1:
                return MONTH;
            case 2:
                return DAY;
            default:
                return MONTH;
        }
    }

    final Date parse(String str) {
        try {
            return this.jpt.parse(str);
        } catch (Exception e) {
            return null;
        }
    }
}
