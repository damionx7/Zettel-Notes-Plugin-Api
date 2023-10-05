package org.eu.thedoc.zettelnotes.interfaces;

import android.app.Activity;
import android.content.Context;

public abstract class ScanInterface {

  public static final String API_VERSION = BuildConfig.SCAN_API_VERSION;
  public static final String METADATA_API_STRING = "org.eu.thedoc.zettelnotes.interfaces.scan.version";
  public static final String QUERY_INTENT = "org.eu.thedoc.zettelnotes.intent.scan";

  public abstract String getName();

  public abstract Listener getListener();

  public interface Listener {

    boolean onScanText(Context context, String repository, String fileName, String text);

    String onProcessText(Context context, String text);
  }

}