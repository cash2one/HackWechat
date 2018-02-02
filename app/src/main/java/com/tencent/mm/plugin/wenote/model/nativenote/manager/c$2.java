package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class c$2 implements Runnable {
    final /* synthetic */ c tSK;
    final /* synthetic */ ArrayList tSL;

    public c$2(c cVar, ArrayList arrayList) {
        this.tSK = cVar;
        this.tSL = arrayList;
    }

    public final void run() {
        ArrayList a = h.a(c.d(this.tSK), this.tSL, false);
        x.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, start mNotifyListener.setUpNoteData(dataItems, true)");
        c.e(this.tSK).l(a, true);
    }
}
