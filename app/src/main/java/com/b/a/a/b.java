package com.b.a.a;

import android.content.Context;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Collections;

public class b {
    private static volatile Integer acg;

    public static int t(Context context) {
        int i = 2011;
        int i2 = -1;
        if (acg == null) {
            synchronized (b.class) {
                if (acg == null) {
                    long s = a.s(context);
                    if (s == -1) {
                        ArrayList arrayList = new ArrayList();
                        int hL = a.hL();
                        hL = hL <= 0 ? -1 : hL == 1 ? TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER : hL <= 3 ? 2011 : 2012;
                        b(arrayList, hL);
                        long hM = (long) a.hM();
                        hL = hM == -1 ? -1 : hM <= 528000 ? TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER : hM <= 620000 ? TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION : hM <= 1020000 ? 2010 : hM <= 1220000 ? 2011 : hM <= 1520000 ? 2012 : hM <= 2020000 ? 2013 : 2014;
                        b(arrayList, hL);
                        hM = a.s(context);
                        if (hM <= 0) {
                            i = -1;
                        } else if (hM <= 201326592) {
                            i = TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER;
                        } else if (hM <= 304087040) {
                            i = TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION;
                        } else if (hM <= 536870912) {
                            i = 2010;
                        } else if (hM > 1073741824) {
                            i = hM <= 1610612736 ? 2012 : hM <= 2147483648L ? 2013 : 2014;
                        }
                        b(arrayList, i);
                        if (!arrayList.isEmpty()) {
                            Collections.sort(arrayList);
                            if ((arrayList.size() & 1) == 1) {
                                i2 = ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
                            } else {
                                i = (arrayList.size() / 2) - 1;
                                i2 = ((((Integer) arrayList.get(i + 1)).intValue() - ((Integer) arrayList.get(i)).intValue()) / 2) + ((Integer) arrayList.get(i)).intValue();
                            }
                        }
                    } else {
                        i2 = s <= 805306368 ? a.hL() <= 1 ? TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION : 2010 : s <= 1073741824 ? a.hM() < 1300000 ? 2011 : 2012 : s <= 1610612736 ? a.hM() < 1800000 ? 2012 : 2013 : s <= 2147483648L ? 2013 : s <= 3221225472L ? 2014 : 2015;
                    }
                    acg = Integer.valueOf(i2);
                }
            }
        }
        return acg.intValue();
    }

    private static void b(ArrayList<Integer> arrayList, int i) {
        if (i != -1) {
            arrayList.add(Integer.valueOf(i));
        }
    }
}
