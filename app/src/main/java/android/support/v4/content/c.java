package android.support.v4.content;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class c<D> {
    Context mContext;
    public int mId;
    public boolean oO = false;
    public b<D> tC;
    public a<D> tD;
    public boolean tE = false;
    public boolean tF = true;
    public boolean tG = false;
    public boolean tH = false;

    public interface a<D> {
    }

    public interface b<D> {
        void b(c<D> cVar, D d);
    }

    public c(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public final void deliverResult(D d) {
        if (this.tC != null) {
            this.tC.b(this, d);
        }
    }

    public final void a(b<D> bVar) {
        if (this.tC == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.tC != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.tC = null;
        }
    }

    public final void a(a<D> aVar) {
        if (this.tD == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.tD != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.tD = null;
        }
    }

    public void onStartLoading() {
    }

    public void onStopLoading() {
    }

    public void onReset() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        android.support.v4.e.c.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.mId);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.tC);
        if (this.oO || this.tG || this.tH) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.oO);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.tG);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.tH);
        }
        if (this.tE || this.tF) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.tE);
            printWriter.print(" mReset=");
            printWriter.println(this.tF);
        }
    }
}
