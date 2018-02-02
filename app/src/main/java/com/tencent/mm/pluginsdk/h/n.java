package com.tencent.mm.pluginsdk.h;

import android.content.Context;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.rtmp.sharp.jni.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class n {
    private static long vfT;
    private static boolean vfU = false;
    private static final Locale vfV = w.UX(w.cfi());
    private static final boolean vfW = w.cff();

    public static String ag(String str, long j) {
        return new SimpleDateFormat(str).format(new Date(1000 * j));
    }

    public static String S(Context context, int i) {
        long j = 1000 * ((long) i);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return p(context, timeInMillis) + ";" + ah(context.getString(h.loG), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() - 86400000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(h.eiV) + " " + p(context, timeInMillis) + ";" + ah(context.getString(h.loG), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() - 172800000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(h.loI) + " " + p(context, timeInMillis) + ";" + ah(context.getString(h.loG), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() + 86400000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(h.eiU) + " " + p(context, timeInMillis) + ";" + ah(context.getString(h.loG), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() + 172800000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(h.eiS) + " " + p(context, timeInMillis) + ";" + ah(context.getString(h.loG), j);
        }
        gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j);
        int i2 = gregorianCalendar2.get(11);
        if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) == gregorianCalendar2.get(3)) {
            return T(context, gregorianCalendar2.get(7)) + " " + U(context, i2) + ";" + ah(context.getString(h.loG), j);
        } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) + 1 == gregorianCalendar2.get(3)) {
            String string;
            int i3 = gregorianCalendar2.get(7);
            StringBuilder stringBuilder = new StringBuilder();
            switch (i3) {
                case 1:
                    string = context.getString(h.loM);
                    break;
                case 2:
                    string = context.getString(h.loK);
                    break;
                case 3:
                    string = context.getString(h.loO);
                    break;
                case 4:
                    string = context.getString(h.loP);
                    break;
                case 5:
                    string = context.getString(h.loN);
                    break;
                case 6:
                    string = context.getString(h.loJ);
                    break;
                case 7:
                    string = context.getString(h.loL);
                    break;
                default:
                    string = "";
                    break;
            }
            return stringBuilder.append(string).append(" ").append(U(context, i2)).append(";").append(ah(context.getString(h.loG), j)).toString();
        } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
            return DateFormat.format(context.getString(h.eiw), j) + " " + U(context, i2) + ";" + ah(context.getString(h.loG), j);
        } else {
            return DateFormat.format(context.getString(h.eiK), j) + " " + U(context, i2) + ";" + ah(context.getString(h.loG), j);
        }
    }

    public static String ah(String str, long j) {
        String charSequence = DateFormat.format(str, j).toString();
        if (bh.ov(charSequence)) {
            return "";
        }
        charSequence = charSequence.trim();
        if (charSequence.startsWith("0")) {
            return charSequence.substring(1);
        }
        return charSequence;
    }

    public static String T(Context context, int i) {
        switch (i) {
            case 1:
                return context.getString(h.loT);
            case 2:
                return context.getString(h.loR);
            case 3:
                return context.getString(h.loV);
            case 4:
                return context.getString(h.loW);
            case 5:
                return context.getString(h.loU);
            case 6:
                return context.getString(h.loQ);
            case 7:
                return context.getString(h.loS);
            default:
                return "";
        }
    }

    public static CharSequence n(Context context, long j) {
        return context.getString(h.loY) + DateFormat.format(context.getString(h.loX), j);
    }

    public static CharSequence o(Context context, long j) {
        return context.getString(h.loZ) + DateFormat.format(context.getString(h.loX), j);
    }

    private static CharSequence U(Context context, int i) {
        if (i < 0) {
            return "";
        }
        if (((long) i) < 6) {
            return context.getString(h.loB);
        }
        if (((long) i) < 12) {
            return context.getString(h.loE);
        }
        if (((long) i) < 13) {
            return context.getString(h.loF);
        }
        if (((long) i) < 18) {
            return context.getString(h.loz);
        }
        return context.getString(h.loC);
    }

    public static CharSequence p(Context context, long j) {
        if (j < 0) {
            return "";
        }
        if (j < 21600000) {
            return context.getString(h.loB);
        }
        if (j < 43200000) {
            return context.getString(h.loE);
        }
        if (j < 46800000) {
            return context.getString(h.loF);
        }
        if (j < 64800000) {
            return context.getString(h.loz);
        }
        return context.getString(h.loC);
    }

    public static boolean bYX() {
        if (System.currentTimeMillis() - vfT > 30000) {
            vfU = DateFormat.is24HourFormat(ac.getContext());
        }
        return vfU;
    }

    public static CharSequence c(Context context, long j, boolean z) {
        CharSequence charSequence;
        if (!vfW) {
            Locale locale = vfV;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                return "";
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                long timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                if (timeInMillis2 > 0 && timeInMillis2 <= 86400000) {
                    return z ? context.getString(h.eiV) : context.getString(h.eiV) + " " + java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
                } else {
                    gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(j);
                    if (gregorianCalendar.get(1) != gregorianCalendar2.get(1) || gregorianCalendar.get(3) != gregorianCalendar2.get(3)) {
                        return gregorianCalendar.get(1) == gregorianCalendar2.get(1) ? z ? java.text.DateFormat.getDateInstance(3, locale).format(Long.valueOf(j)) : java.text.DateFormat.getDateTimeInstance(3, 3, locale).format(Long.valueOf(j)) : z ? java.text.DateFormat.getDateInstance(3, locale).format(Long.valueOf(j)) : java.text.DateFormat.getDateTimeInstance(3, 3, locale).format(Long.valueOf(j));
                    } else {
                        charSequence = new SimpleDateFormat(QLog.TAG_REPORTLEVEL_USER, locale).format(Long.valueOf(j));
                        if (z) {
                            return charSequence;
                        }
                        return charSequence + " " + java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
                    }
                }
            }
            return java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
        } else if (j < 3600000) {
            return "";
        } else {
            Time time = new Time();
            Time time2 = new Time();
            time.set(j);
            time2.setToNow();
            if (time.year == time2.year && time.yearDay == time2.yearDay) {
                if (bYX()) {
                    return m.a(context.getString(h.eiQ), time);
                }
                return U(context, time.hour) + m.a(context.getString(h.loG), time);
            } else if (time.year == time2.year && time2.yearDay - time.yearDay == 1) {
                boolean bYX = bYX();
                if (z) {
                    return context.getString(h.eiV);
                }
                Object a;
                StringBuilder append = new StringBuilder().append(context.getString(h.eiV)).append(" ");
                if (bYX) {
                    a = m.a(context.getString(h.eiQ), time);
                } else {
                    a = U(context, time.hour) + m.a(context.getString(h.loG), time);
                }
                return append.append(a).toString();
            } else if (time.year == time2.year && time.getWeekNumber() == time2.getWeekNumber()) {
                charSequence = m.a("E ", time);
                if (z) {
                    return charSequence;
                }
                return charSequence + m.a(context.getString(h.loH), time);
            } else if (time.year == time2.year) {
                if (z) {
                    return m.a(context.getString(h.eiw), time);
                }
                return m.a(context.getString(h.loA, new Object[]{p(context, ((long) time.hour) * 3600000)}).toString(), time);
            } else if (z) {
                return m.a(context.getString(h.eiK), time);
            } else {
                return m.a(context.getString(h.loD, new Object[]{p(context, ((long) time.hour) * 3600000)}).toString(), time);
            }
        }
    }
}
