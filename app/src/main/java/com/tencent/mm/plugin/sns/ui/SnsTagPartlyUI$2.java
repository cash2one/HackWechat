package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.z.q;

class SnsTagPartlyUI$2 implements OnItemClickListener {
    final /* synthetic */ SnsTagPartlyUI rHh;

    SnsTagPartlyUI$2(SnsTagPartlyUI snsTagPartlyUI) {
        this.rHh = snsTagPartlyUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < SnsTagPartlyUI.a(this.rHh).getCount() - 1) {
            Intent intent = new Intent();
            s sVar = (s) SnsTagPartlyUI.a(this.rHh).getItem(i);
            if (sVar != null) {
                intent.putExtra("k_sns_tag_id", sVar.field_tagId);
                intent.setClass(this.rHh, SnsTagDetailUI.class);
                this.rHh.startActivity(intent);
                return;
            }
            return;
        }
        Intent intent2 = new Intent();
        String FS = q.FS();
        intent2.putExtra("titile", this.rHh.getString(j.qJq));
        intent2.putExtra("list_type", 1);
        intent2.putExtra("list_attr", com.tencent.mm.ui.contact.s.p(new int[]{com.tencent.mm.ui.contact.s.yTE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        intent2.putExtra("block_contact", FS);
        d.a(this.rHh, ".ui.contact.SelectContactUI", intent2, 1);
    }
}
