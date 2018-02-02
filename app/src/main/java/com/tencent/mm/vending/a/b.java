package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item> extends com.tencent.mm.vending.base.b<_Struct, Cursor> {
    public Cursor BA = null;
    protected Map<Integer, _Item> kIN = null;
    public int mCount;
    public a zAP;
    protected _Item zAQ;

    public abstract _Item a(_Item _Item, Cursor cursor);

    public abstract Cursor bBU();

    protected /* synthetic */ Object prepareVendingDataAsynchronous() {
        if (this.zAP != null) {
            this.zAP.bBP();
        }
        Cursor bBU = bBU();
        if (this.zAP != null) {
            this.zAP.bBQ();
        }
        return bBU;
    }

    public b(_Item _Item) {
        this.zAQ = _Item;
        this.mCount = -1;
        czD();
    }

    private Cursor getCursor() {
        if (this.BA == null || this.BA.isClosed()) {
            Assert.assertNotNull(this.BA);
        }
        return this.BA;
    }

    public void destroyAsynchronous() {
        aUn();
    }

    public final void aUn() {
        if (this.kIN != null) {
            this.kIN.clear();
        }
        if (this.BA != null) {
            this.BA.close();
        }
        this.mCount = -1;
    }

    public final void czD() {
        if (this.kIN == null) {
            this.kIN = new HashMap();
        }
    }

    public final int czE() {
        if (this.mCount < 0) {
            this.mCount = getCursor().getCount();
        }
        return this.mCount;
    }

    public final _Item getItem(int i) {
        _Item _Item;
        if (this.kIN != null) {
            _Item = this.kIN.get(Integer.valueOf(i));
            if (_Item != null) {
                return _Item;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        if (this.kIN == null) {
            return a(this.zAQ, getCursor());
        }
        _Item = a(null, getCursor());
        this.kIN.put(Integer.valueOf(i), _Item);
        return _Item;
    }
}
