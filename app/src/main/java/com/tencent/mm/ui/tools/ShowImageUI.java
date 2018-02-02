package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.u;

public class ShowImageUI extends MMActivity {
    private MMGestureGallery kRW;
    private boolean zmV;
    private a zmW;
    private boolean zmX;

    static /* synthetic */ void b(ShowImageUI showImageUI) {
        String stringExtra = showImageUI.getIntent().getStringExtra("key_image_path");
        int intExtra = showImageUI.getIntent().getIntExtra("key_compress_type", 0);
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", longExtra);
        ar.Hg();
        cf dH = c.Fa().dH(longExtra);
        g$a fT = g$a.fT(dH.field_content);
        if (p.UR(stringExtra) || (dH.aNc() && fT != null && fT.type == 2)) {
            intent.putExtra("Retr_Msg_Type", 2);
            intent.putExtra("Retr_Msg_content", dH.field_content);
            if (fT != null && fT.type == 2) {
                stringExtra = u.hz("msg_" + dH.field_msgSvrId);
                u.GK().t(stringExtra, true).o("prePublishId", "msg_" + dH.field_msgSvrId);
                intent.putExtra("reportSessionId", stringExtra);
            }
        } else {
            intent.putExtra("Retr_Msg_Type", 0);
        }
        intent.putExtra("Retr_Compress_Type", intExtra);
        showImageUI.startActivity(intent);
    }

    static /* synthetic */ void d(ShowImageUI showImageUI) {
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", longExtra);
        showImageUI.startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.dsE;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (!bh.ov(stringExtra)) {
            setMMTitle(stringExtra);
        }
        this.zmV = getIntent().getBooleanExtra("key_favorite", false);
        this.zmX = getIntent().getBooleanExtra("show_menu", true);
        this.kRW = (MMGestureGallery) findViewById(R.h.ckt);
        this.kRW.setVerticalFadingEdgeEnabled(false);
        this.kRW.setHorizontalFadingEdgeEnabled(false);
        this.zmW = new a(this, (byte) 0);
        this.zmW.imagePath = getIntent().getStringExtra("key_image_path");
        this.kRW.setAdapter(this.zmW);
        setBackBtn(new 1(this));
        if (this.zmX) {
            addIconOptionMenu(0, R.k.dzQ, new 2(this));
        }
    }
}
