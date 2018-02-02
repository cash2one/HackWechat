package com.tencent.mm.pluginsdk.h;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.format.DateUtils;
import android.text.format.Time;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.xwalk.core.R$styleable;

public final class m {
    public static CharSequence a(CharSequence charSequence, Time time) {
        Object spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a;
            int length2;
            int i2 = 1;
            char charAt = spannableStringBuilder.charAt(i);
            if (charAt == '\'') {
                a = a(spannableStringBuilder, i, length);
                length2 = spannableStringBuilder.length();
            } else {
                Object aMPMString;
                while (i + i2 < length && spannableStringBuilder.charAt(i + i2) == charAt) {
                    i2++;
                }
                switch (charAt) {
                    case 'A':
                        aMPMString = DateUtils.getAMPMString(time.hour < 12 ? 0 : 1);
                        break;
                    case 'E':
                        aMPMString = DateUtils.getDayOfWeekString(time.weekDay + 1, i2 < 4 ? 20 : 10);
                        break;
                    case R$styleable.AppCompatTheme_textAppearanceListItem /*76*/:
                    case 'M':
                        length2 = time.month;
                        if (i2 < 4) {
                            if (i2 != 3) {
                                aMPMString = ew(length2 + 1, i2);
                                break;
                            }
                            aMPMString = DateUtils.getMonthString(length2, 20);
                            break;
                        }
                        aMPMString = DateUtils.getMonthString(length2, 10);
                        break;
                    case 'a':
                        aMPMString = DateUtils.getAMPMString(time.hour < 12 ? 0 : 1);
                        break;
                    case 'd':
                        aMPMString = ew(time.monthDay, i2);
                        break;
                    case 'h':
                        length2 = time.hour;
                        if (length2 == 0) {
                            length2 = 12;
                        }
                        if (length2 > 12) {
                            length2 -= 12;
                        }
                        aMPMString = String.valueOf(length2);
                        break;
                    case 'k':
                        aMPMString = ew(time.hour, i2);
                        break;
                    case 'm':
                        aMPMString = ew(time.minute, i2);
                        break;
                    case 's':
                        aMPMString = ew(time.second, i2);
                        break;
                    case 'y':
                        length2 = time.year;
                        if (i2 > 2) {
                            aMPMString = String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(length2)});
                            break;
                        }
                        aMPMString = ew(length2 % 100, 2);
                        break;
                    case 'z':
                        TimeZone timeZone = TimeZone.getDefault();
                        timeZone.inDaylightTime(new Date(time.toMillis(false)));
                        if (i2 >= 2) {
                            aMPMString = timeZone.getDisplayName(time.isDst != 0, 0);
                            break;
                        }
                        long rawOffset = (((long) timeZone.getRawOffset()) + time.gmtoff) / 1000;
                        StringBuilder stringBuilder = new StringBuilder();
                        if (rawOffset < 0) {
                            stringBuilder.insert(0, "-");
                            rawOffset = -rawOffset;
                        } else {
                            stringBuilder.insert(0, "+");
                        }
                        length2 = (int) ((rawOffset % 3600) / 60);
                        stringBuilder.append(ew((int) (rawOffset / 3600), 2));
                        stringBuilder.append(ew(length2, 2));
                        aMPMString = stringBuilder.toString();
                        break;
                    default:
                        aMPMString = null;
                        break;
                }
                if (aMPMString != null) {
                    spannableStringBuilder.replace(i, i + i2, aMPMString);
                    a = aMPMString.length();
                    length2 = spannableStringBuilder.length();
                } else {
                    length2 = length;
                    a = i2;
                }
            }
            i = a + i;
            length = length2;
        }
        if (charSequence instanceof Spanned) {
            return new SpannedString(spannableStringBuilder);
        }
        return spannableStringBuilder.toString();
    }

    private static int a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        if (i + 1 >= i2 || spannableStringBuilder.charAt(i + 1) != '\'') {
            int i3 = 0;
            spannableStringBuilder.delete(i, i + 1);
            int i4 = i2 - 1;
            while (i < i4) {
                if (spannableStringBuilder.charAt(i) != '\'') {
                    i++;
                    i3++;
                } else if (i + 1 >= i4 || spannableStringBuilder.charAt(i + 1) != '\'') {
                    spannableStringBuilder.delete(i, i + 1);
                    return i3;
                } else {
                    spannableStringBuilder.delete(i, i + 1);
                    i4--;
                    i3++;
                    i++;
                }
            }
            return i3;
        }
        spannableStringBuilder.delete(i, i + 1);
        return 1;
    }

    private static String ew(int i, int i2) {
        return String.format(Locale.getDefault(), "%0" + i2 + "d", new Object[]{Integer.valueOf(i)});
    }
}
