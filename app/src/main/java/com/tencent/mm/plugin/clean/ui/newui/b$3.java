package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.clean.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$3 implements OnItemClickListener {
    final /* synthetic */ b lhJ;

    b$3(b bVar) {
        this.lhJ = bVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", Integer.valueOf(i));
        a op = this.lhJ.op(i);
        Intent intent = new Intent();
        switch (op.type) {
            case 1:
                intent.putExtra("key_title", b.a(this.lhJ).getString(R.l.dTF));
                intent.putExtra("show_menu", false);
                intent.putExtra("key_image_path", op.filePath);
                d.a(b.a(this.lhJ), ".ui.tools.ShowImageUI", intent);
                return;
            case 3:
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(op.filePath)), "video/*");
                try {
                    b.a(this.lhJ).startActivity(Intent.createChooser(intent, b.a(this.lhJ).getString(R.l.eTt)));
                    return;
                } catch (Exception e) {
                    return;
                }
            case 4:
                intent.putExtra("app_msg_id", op.fpG);
                d.a(b.a(this.lhJ), ".ui.chatting.AppAttachDownloadUI", intent);
                return;
            default:
                return;
        }
    }
}
