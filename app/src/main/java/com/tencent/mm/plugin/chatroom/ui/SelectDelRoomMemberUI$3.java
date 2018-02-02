package com.tencent.mm.plugin.chatroom.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.chatroom.ui.SelectDelRoomMemberUI.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;

class SelectDelRoomMemberUI$3 implements TextWatcher {
    final /* synthetic */ SelectDelRoomMemberUI ldt;

    SelectDelRoomMemberUI$3(SelectDelRoomMemberUI selectDelRoomMemberUI) {
        this.ldt = selectDelRoomMemberUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        a b = SelectDelRoomMemberUI.b(this.ldt);
        Object charSequence2 = charSequence.toString();
        b.ldh = charSequence2;
        List arrayList = new ArrayList();
        if (bh.ov(charSequence2)) {
            a.fAN = a.ldk;
        } else {
            for (x xVar : a.ldk) {
                if (xVar != null) {
                    if (xVar.field_conRemark != null && xVar.field_conRemark.toUpperCase().contains(charSequence2.toUpperCase())) {
                        arrayList.add(xVar);
                    } else if (!bh.ov(SelectDelRoomMemberUI.b(b.kZS, xVar.field_username)) && SelectDelRoomMemberUI.b(b.kZS, xVar.field_username).contains(charSequence2)) {
                        arrayList.add(xVar);
                    } else if (xVar.AP() != null && xVar.AP().toUpperCase().contains(charSequence2.toUpperCase())) {
                        arrayList.add(xVar);
                    } else if (xVar.vQ() != null && xVar.vQ().toUpperCase().contains(charSequence2.toUpperCase())) {
                        arrayList.add(xVar);
                    } else if (xVar.vN() != null && xVar.vN().contains(charSequence2)) {
                        arrayList.add(xVar);
                    } else if (xVar.field_username != null && xVar.field_username.contains(charSequence2)) {
                        arrayList.add(xVar);
                    } else if (!com.tencent.mm.l.a.fZ(xVar.field_type)) {
                        ar.Hg();
                        bf EZ = c.EZ().EZ(xVar.field_username);
                        if (!(EZ == null || EZ.field_conRemark == null || !EZ.field_conRemark.toUpperCase().contains(charSequence2.toUpperCase()))) {
                            arrayList.add(xVar);
                        }
                    }
                }
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SelectDelRoomMemberUI", "--->setMemberListBySearch:search");
            a.fAN = arrayList;
        }
        b.notifyDataSetChanged();
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
