package android.support.v7.widget;

import android.os.AsyncTask;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class d$e extends AsyncTask<Object, Void, Void> {
    final /* synthetic */ d Or;

    private d$e(d dVar) {
        this.Or = dVar;
    }

    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return b(objArr);
    }

    private Void b(Object... objArr) {
        int i = 0;
        List list = (List) objArr[0];
        try {
            OutputStream openFileOutput = d.a(this.Or).openFileOutput((String) objArr[1], 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                newSerializer.setOutput(openFileOutput, null);
                newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                newSerializer.startTag(null, "historical-records");
                int size = list.size();
                while (i < size) {
                    d$c android_support_v7_widget_d_c = (d$c) list.remove(0);
                    newSerializer.startTag(null, "historical-record");
                    newSerializer.attribute(null, "activity", android_support_v7_widget_d_c.Os.flattenToString());
                    newSerializer.attribute(null, "time", String.valueOf(android_support_v7_widget_d_c.time));
                    newSerializer.attribute(null, "weight", String.valueOf(android_support_v7_widget_d_c.weight));
                    newSerializer.endTag(null, "historical-record");
                    i++;
                }
                newSerializer.endTag(null, "historical-records");
                newSerializer.endDocument();
                d.c(this.Or);
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e) {
                    }
                }
            } catch (IllegalArgumentException e2) {
                d.el();
                new StringBuilder("Error writing historical recrod file: ").append(d.b(this.Or));
                d.c(this.Or);
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IllegalStateException e4) {
                d.el();
                new StringBuilder("Error writing historical recrod file: ").append(d.b(this.Or));
                d.c(this.Or);
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (IOException e6) {
                d.el();
                new StringBuilder("Error writing historical recrod file: ").append(d.b(this.Or));
                d.c(this.Or);
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e7) {
                    }
                }
            } catch (Throwable th) {
                d.c(this.Or);
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e8) {
                    }
                }
            }
        } catch (FileNotFoundException e9) {
            d.el();
        }
        return null;
    }
}
