package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.x;

public class e implements a {
    public final void n(Bundle bundle) {
        int i;
        int i2 = bundle.getInt("mm_rpt_fav_id", 0);
        int i3 = bundle.getInt("key_detail_fav_scene", 0);
        int i4 = bundle.getInt("key_detail_fav_sub_scene", 0);
        int i5 = bundle.getInt("key_detail_fav_index", 0);
        long j = bundle.getLong("key_activity_browse_time", -1);
        int i6 = bundle.getBoolean("mm_scroll_bottom") ? 1 : 0;
        int i7 = bundle.getInt("mm_send_friend_count", 0);
        int i8 = bundle.getInt("mm_share_sns_count", 0);
        if (bundle.getBoolean("mm_del_fav", false)) {
            i = 1;
        } else {
            i = 0;
        }
        x.d("MicroMsg.FavWebRptCallback", "FavWebRptCallback uiBrowseTime[%d] isScrollBottom[%b] sendToFriendCount[%d] shareSnsCount[%d]  isDelFav[%b] clickEditFavTagCount[%d] favId[%s]", new Object[]{Long.valueOf(j), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i), Integer.valueOf(bundle.getInt("mm_edit_fav_count", 0)), Integer.valueOf(i2)});
        f dc = ((r) g.k(r.class)).getFavItemInfoStorage().dc((long) i2);
        if (dc == null) {
            x.w("MicroMsg.FavWebRptCallback", "fav web rpt but favitem info is null favid[%d]", new Object[]{Integer.valueOf(i2)});
            return;
        }
        long j2 = dc.field_sourceCreateTime != 0 ? dc.field_sourceCreateTime / 1000 : dc.field_updateTime / 1000;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i3).append(",");
        stringBuffer.append(i5).append(",");
        stringBuffer.append(i2).append(",");
        stringBuffer.append(dc.field_type).append(",");
        stringBuffer.append("0,");
        stringBuffer.append(dc.field_sourceType).append(",");
        stringBuffer.append(j2).append(",");
        stringBuffer.append(j).append(",");
        stringBuffer.append("0,");
        stringBuffer.append("0,");
        stringBuffer.append("0,");
        stringBuffer.append(i7).append(",");
        stringBuffer.append(i8).append(",");
        stringBuffer.append("0,");
        stringBuffer.append(r15).append(",");
        stringBuffer.append(i).append(",");
        stringBuffer.append(i6).append(",");
        stringBuffer.append(i4);
        x.v("MicroMsg.FavWebRptCallback", "FavWebRptCallback rpt id[%d] [%s]", new Object[]{Integer.valueOf(15098), stringBuffer.toString()});
        d.pPH.k(15098, stringBuffer.toString());
    }
}
