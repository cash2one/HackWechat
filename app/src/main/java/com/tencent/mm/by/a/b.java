package com.tencent.mm.by.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a> extends SQLiteClosable {
    int mStartPos = 0;
    SparseArray<Object> xBG = new SparseArray();
    int xBH;
    HashMap<Object, T> xBI = new HashMap();
    ArrayList<Object> xBJ;
    T xBK;

    public abstract ArrayList<T> ah(ArrayList<Object> arrayList);

    public abstract T ckX();

    final void b(Object obj, T t) {
        this.xBI.put(obj, t);
    }

    public final boolean DE(int i) {
        return this.xBG.indexOfKey(i) >= 0;
    }

    public final void eJ(int i, int i2) {
        if (i2 != 0) {
            x.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", Integer.valueOf(i2), Integer.valueOf(i));
            this.xBG.remove(i);
        } else if (this.xBK != null) {
            Object key = this.xBK.getKey();
            b(key, this.xBK);
            this.xBG.put(i, key);
        }
    }

    public final void aaS() {
        x.i("MicroMsg.CursorDataWindow", "clearData");
        this.xBG.clear();
        this.xBI.clear();
    }

    protected void onAllReferencesReleased() {
        aaS();
    }

    final void r(Object[] objArr) {
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (int i2 = 0; i2 < this.xBG.size(); i2++) {
            int keyAt = this.xBG.keyAt(i2);
            Object valueAt = this.xBG.valueAt(i2);
            Object obj = 1;
            for (Object equals : objArr) {
                if (equals.equals(valueAt)) {
                    i++;
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                sparseArray.put(keyAt - i, valueAt);
            } else {
                x.i("MicroMsg.CursorDataWindow", "newcursor delete index : " + i2 + " obj : " + valueAt);
            }
        }
        if (this.xBG.size() != sparseArray.size()) {
            x.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.xBG.size() + " newposistion Size : " + sparseArray.size());
        }
        this.xBG = sparseArray;
    }

    public final boolean cd(Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1) {
                if (this.xBI == null || !this.xBI.containsKey(objArr[0])) {
                    return false;
                }
                return true;
            }
        }
        return this.xBI != null && this.xBI.containsKey(obj);
    }
}
