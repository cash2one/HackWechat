package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import java.util.Map;

public final class l {
    private static i yZU = null;

    public static void fS(Context context) {
        if (bh.cgC()) {
            String value = g.zY().getValue("NewShowRating");
            if (!bh.ov(value)) {
                Map y = bi.y(value, "ShowRatingNode");
                value = (y == null || y.get(".ShowRatingNode.MinVer") == null) ? "0" : (String) y.get(".ShowRatingNode.MinVer");
                int intValue = Integer.decode(value).intValue();
                value = (y == null || y.get(".ShowRatingNode.MaxVer") == null) ? "0" : (String) y.get(".ShowRatingNode.MaxVer");
                int intValue2 = Integer.decode(value).intValue();
                if (y == null || y.get(".ShowRatingNode.WaitDays") == null) {
                    value = "0";
                } else {
                    value = (String) y.get(".ShowRatingNode.WaitDays");
                }
                int intValue3 = Integer.decode(value).intValue();
                if (intValue <= d.vAz && d.vAz <= intValue2) {
                    Object obj;
                    final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
                    int i = sharedPreferences.getInt("show_rating_flag", 0);
                    int i2 = sharedPreferences.getInt("show_rating_version", 0);
                    long j = sharedPreferences.getLong("show_rating_timestamp", 0);
                    boolean z = sharedPreferences.getBoolean("show_rating_again", false);
                    long j2 = ((long) (intValue3 == 0 ? 7 : intValue3)) * 86400000;
                    if (i2 == 0 || intValue > i2 || i2 > intValue2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        sharedPreferences.edit().putInt("show_rating_version", d.vAz).commit();
                        sharedPreferences.edit().putInt("show_rating_flag", 0).commit();
                        i = 0;
                        j = System.currentTimeMillis();
                        sharedPreferences.edit().putLong("show_rating_timestamp", j).commit();
                        sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                        sharedPreferences.edit().putInt("show_rating_wait_days", intValue3).commit();
                        sharedPreferences.edit().putInt("show_rating_first_second_time", (int) (System.currentTimeMillis() / 1000)).commit();
                        x.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", new Object[]{Integer.valueOf(d.vAz), Integer.valueOf(i2), Integer.valueOf(intValue), Integer.valueOf(intValue2), Long.valueOf(j2)});
                    }
                    if (intValue <= d.vAz && d.vAz <= intValue2 && i == 0 && r2 != 0 && System.currentTimeMillis() >= r2 + j2) {
                        x.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
                        final Context context2 = context;
                        yZU = h.a(context, false, context.getString(R.l.ePA), "", context.getString(R.l.ePt), context.getString(R.l.ePs), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                sharedPreferences.edit().putInt("show_rating_flag", 1).commit();
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                                l.yZU = null;
                                l.n(context2, true);
                                x.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
                            }
                        }, new 2(sharedPreferences, context));
                    } else if (z && r2 != 0 && System.currentTimeMillis() >= (r2 + j2) + 345600000) {
                        x.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
                        n(context, false);
                        sharedPreferences.edit().putInt("show_rating_flag", 3).commit();
                    } else if (i == 1) {
                        n(context, true);
                    } else if (i == 2) {
                        fT(context);
                    } else if (i == 3) {
                        n(context, false);
                    }
                }
            }
        }
    }

    private static void n(Context context, boolean z) {
        String string;
        String str;
        String str2;
        SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        boolean z2 = sharedPreferences.getBoolean("show_rating_again", false);
        int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string2;
        String string3;
        if (z) {
            string2 = context.getString(R.l.ePz);
            string3 = context.getString(R.l.ePy);
            string = context.getString(R.l.ePx);
            str = string3;
            str2 = string2;
        } else {
            string2 = context.getString(R.l.ePw);
            string3 = context.getString(R.l.ePv);
            string = context.getString(R.l.ePu);
            str = string3;
            str2 = string2;
        }
        yZU = h.a(context, false, str2, "", str, string, new 3(sharedPreferences, context, z2, i2, i), new 4(sharedPreferences, z2, i2, i));
    }

    private static void fT(final Context context) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string = context.getString(R.l.ePC);
        String string2 = context.getString(R.l.ePB);
        OnClickListener anonymousClass5 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                com.tencent.mm.pluginsdk.d.a(context, (int) System.currentTimeMillis(), new byte[0], "weixin://dl/feedback");
                l.yZU = null;
                com.tencent.mm.plugin.report.service.g.pQN.h(11216, new Object[]{Integer.valueOf(2), Integer.valueOf(i2), Integer.valueOf(i)});
            }
        };
        OnClickListener anonymousClass6 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                l.yZU = null;
                com.tencent.mm.plugin.report.service.g.pQN.h(11216, new Object[]{Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i)});
            }
        };
        yZU = h.a(context, false, context.getString(R.l.ePD), "", string, string2, anonymousClass5, anonymousClass6);
    }

    public static void cwN() {
        if (yZU != null) {
            yZU.dismiss();
            yZU = null;
        }
    }
}
