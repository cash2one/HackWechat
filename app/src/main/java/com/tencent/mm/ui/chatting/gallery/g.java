package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Iterator;

public final class g {
    public ArrayList<au> yDd;
    public boolean yEF;
    ArrayList<b> yEG;

    private g() {
        this.yDd = new ArrayList();
        this.yEF = false;
        this.yEG = new ArrayList();
    }

    public final void bm(au auVar) {
        if (auVar != null) {
            x.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[]{Long.valueOf(auVar.field_msgId)});
            this.yDd.remove(auVar);
            this.yDd.remove(gl(auVar.field_msgId));
            this.yDd.add(auVar);
            cuE();
        }
    }

    private au gl(long j) {
        Iterator it = this.yDd.iterator();
        while (it.hasNext()) {
            au auVar = (au) it.next();
            if (auVar.field_msgId == j) {
                return auVar;
            }
        }
        return null;
    }

    public final void bn(au auVar) {
        if (auVar != null) {
            x.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[]{Long.valueOf(auVar.field_msgId)});
            this.yDd.remove(auVar);
            this.yDd.remove(gl(auVar.field_msgId));
            cuE();
        }
    }

    public final void clear() {
        x.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
        this.yDd.clear();
        Iterator it = this.yEG.iterator();
        while (it.hasNext()) {
            ((b) it.next()).clear();
        }
    }

    public final void detach() {
        this.yEG.clear();
        clear();
        this.yEF = false;
    }

    public final boolean bo(au auVar) {
        if (auVar == null) {
            return false;
        }
        Iterator it = this.yDd.iterator();
        while (it.hasNext()) {
            if (((au) it.next()).field_msgId == auVar.field_msgId) {
                return true;
            }
        }
        return false;
    }

    private void cuE() {
        Iterator it = this.yEG.iterator();
        while (it.hasNext()) {
            ((b) it.next()).cuD();
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.yEG.remove(bVar);
            this.yEG.add(bVar);
        }
    }
}
