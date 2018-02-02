package com.tencent.mm.modelsimple;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public class b$a {
    private final String TAG = "MicroMsg.BatchOperation";
    ArrayList<ContentProviderOperation> hMA;
    final /* synthetic */ b hMB;
    private final ContentResolver hMz;

    public b$a(b bVar, ContentResolver contentResolver) {
        this.hMB = bVar;
        this.hMz = contentResolver;
        this.hMA = new ArrayList();
    }

    public final void a(ContentProviderOperation contentProviderOperation) {
        this.hMA.add(contentProviderOperation);
    }

    public final void execute() {
        if (this.hMA.size() == 0) {
            x.d("MicroMsg.BatchOperation", "no batch operation");
        } else if (a.aZ(b.a(this.hMB), "android.permission.READ_CONTACTS")) {
            try {
                this.hMz.applyBatch("com.android.contacts", this.hMA);
            } catch (OperationApplicationException e) {
                x.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[]{e.toString()});
            } catch (RemoteException e2) {
                x.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[]{e2.toString()});
            } catch (Exception e3) {
                x.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[]{e3.toString()});
            }
            this.hMA.clear();
        } else {
            x.e("MicroMsg.BatchOperation", "no contact permission");
        }
    }
}
