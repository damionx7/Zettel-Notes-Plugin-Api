package org.eu.thedoc.zettelnotes.interfaces;

import android.content.Context;
import java.util.List;

public abstract class ScanInterface {

  public abstract String getName();

  public abstract Listener getListener();

  public interface Listener {

    boolean onScanText(Context context, String category, String fileUri, String fileTitle, String text);

    String onProcessText(Context context, String text);

    void onDeleteUris(Context context, String category, List<String> fileUris);
  }

}