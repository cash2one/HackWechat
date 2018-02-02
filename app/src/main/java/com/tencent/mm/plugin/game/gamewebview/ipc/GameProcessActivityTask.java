package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GameProcessActivityTask implements Parcelable {
    private static Map<String, WeakReference<GameProcessActivityTask>> jaM = new ConcurrentHashMap();
    static final Set<Object> jbl = new HashSet();
    private int jbm = -1;
    private a jbn = new a(this) {
        final /* synthetic */ GameProcessActivityTask mVT;

        {
            this.mVT = r1;
        }

        public final void b(int i, int i2, Intent intent) {
            if (i == (this.mVT.hashCode() & 65535) && intent != null) {
                GameProcessActivityTask gameProcessActivityTask = (GameProcessActivityTask) intent.getParcelableExtra("task_object");
                GameProcessActivityTask BD = GameProcessActivityTask.BD(intent.getStringExtra("task_id"));
                if (BD == null) {
                    x.e("MicroMsg.GameProcessActivityTask", "task is null");
                    return;
                }
                GameProcessActivityTask.a(gameProcessActivityTask, BD);
                GameProcessActivityTask.jbl.remove(BD);
                BD.Ys();
                this.mVT.mContext = null;
            }
        }
    };
    private String jbo = (Process.myPid() + hashCode());
    Context mContext;

    public abstract void a(Context context, a aVar);

    static /* synthetic */ GameProcessActivityTask BD(String str) {
        if (jaM.containsKey(str)) {
            return ((WeakReference) jaM.get(str)).get() == null ? null : (GameProcessActivityTask) ((WeakReference) jaM.get(str)).get();
        } else {
            return null;
        }
    }

    static /* synthetic */ void a(GameProcessActivityTask gameProcessActivityTask, GameProcessActivityTask gameProcessActivityTask2) {
        Parcel obtain = Parcel.obtain();
        gameProcessActivityTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        gameProcessActivityTask2.f(obtain);
        obtain.recycle();
    }

    public GameProcessActivityTask(Context context) {
        this.mContext = context;
    }

    public void Ys() {
    }

    public void f(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final void aKE() {
        if (this.mContext != null) {
            jaM.put(this.jbo, new WeakReference(this));
            Intent intent = new Intent();
            intent.putExtra("task_object", this);
            intent.putExtra("task_id", this.jbo);
            intent.putExtra("orientation", this.jbm);
            if (this.mContext instanceof MMActivity) {
                jbl.add(this);
                ((MMActivity) this.mContext).jwN = this.jbn;
                d.b(this.mContext, "game", ".gamewebview.ui.GameIpcProxyUI", intent, hashCode() & 65535);
                return;
            }
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            d.b(this.mContext, "game", ".gamewebview.ui.GameIpcProxyUI", intent);
        }
    }
}
