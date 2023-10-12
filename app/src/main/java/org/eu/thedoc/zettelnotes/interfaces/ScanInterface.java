package org.eu.thedoc.zettelnotes.interfaces;

import android.content.Context;
import java.util.List;

public abstract class ScanInterface {

  public static final String API_VERSION = BuildConfig.SCAN_API_VERSION;
  public static final String METADATA_API_STRING = "org.eu.thedoc.zettelnotes.interfaces.scan.version";
  public static final String QUERY_INTENT = "org.eu.thedoc.zettelnotes.intent.scan";

  public abstract String getName();

  public abstract Listener getListener();

  public interface Listener {

    boolean onScanText(Context context, String category, String fileUri, String fileTitle, String text);

    void onDeleteUris(Context context, String category, List<String> fileUris);

    String onProcessText(Context context, String text);
  }

}