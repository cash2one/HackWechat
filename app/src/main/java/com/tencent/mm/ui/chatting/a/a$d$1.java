package com.tencent.mm.ui.chatting.a;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.a.c;
import com.tencent.mm.ui.chatting.a.a.d;
import com.tencent.wcdb.database.SQLiteDatabase;

class a$d$1 implements OnClickListener {
    final /* synthetic */ a yys;
    final /* synthetic */ d yyt;

    a$d$1(d dVar, a aVar) {
        this.yyt = dVar;
        this.yys = aVar;
    }

    public final void onClick(View view) {
        c FC = this.yyt.yyk.FC(((Integer) view.getTag()).intValue());
        if (FC != null) {
            a aVar = this.yyt.yyk;
            Intent intent = new Intent();
            intent.putExtra("key_biz_chat_id", aVar.yyg);
            intent.putExtra("key_is_biz_chat", aVar.vnK);
            if (FC == null) {
                x.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
                return;
            }
            cf cfVar = FC.fEJ;
            if (cfVar == null) {
                x.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
                return;
            }
            int width;
            int height;
            int i = aVar.mContext.getResources().getConfiguration().orientation;
            int[] iArr = new int[2];
            if (view != null) {
                width = view.getWidth();
                height = view.getHeight();
                view.getLocationInWindow(iArr);
            } else {
                height = 0;
                width = 0;
            }
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.putExtra("img_gallery_msg_id", cfVar.field_msgId).putExtra("img_gallery_msg_svr_id", cfVar.field_msgSvrId).putExtra("img_gallery_talker", cfVar.field_talker).putExtra("img_gallery_chatroom_name", cfVar.field_talker).putExtra("img_gallery_orientation", i);
            if (view != null) {
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
            } else {
                intent.putExtra("img_gallery_back_from_grid", true);
            }
            com.tencent.mm.bm.d.a(aVar.mContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
            ((Activity) aVar.mContext).overridePendingTransition(0, 0);
        }
    }
}
