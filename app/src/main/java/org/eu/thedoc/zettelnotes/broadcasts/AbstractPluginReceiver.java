package org.eu.thedoc.zettelnotes.broadcasts;

import android.content.Intent;
import org.eu.thedoc.zettelnotes.interfaces.BuildConfig;

public class AbstractPluginReceiver {

  //note uri
  public static final String EXTRAS_URI = "arg-uri";
  //repository
  public static final String EXTRAS_REPOSITORY = "arg-repository";
  //start with edit mode
  public static final String EXTRAS_EDIT = "arg-edit";
  //line number in note
  public static final String EXTRAS_LINE_INDEXES = "arg-line-indexes";
  //replacement of the line
  public static final String EXTRAS_REPLACEMENT = "arg-replacement-text";

  //intent action to open file uri
  public static final String INTENT_ACTION_PLUGIN_OPEN_URI = "org.eu.thedoc.zettelnotes.broadcast.plugins.OPEN_URI";
  //intent action to open and replace specific line in file uri
  public static final String INTENT_ACTION_PLUGIN_OPEN_AND_REPLACE_URI = "org.eu.thedoc.zettelnotes.broadcast.plugins.OPEN_AND_REPLACE_URI";

  public static class IntentBuilder {

    private final Intent intent;

    private IntentBuilder() {
      intent = new Intent();
      intent.setPackage(BuildConfig.ZETTEL_PACKAGE_NAME);
    }

    public static IntentBuilder getInstance() {
      return new IntentBuilder();
    }

    public IntentBuilder setActionOpenUri() {
      intent.setAction(INTENT_ACTION_PLUGIN_OPEN_URI);
      return this;
    }

    public IntentBuilder setDebug() {
      intent.setPackage(BuildConfig.ZETTEL_PACKAGE_NAME_DEBUG);
      return this;
    }

    public IntentBuilder setActionOpenAndReplace(String text) {
      intent.setAction(INTENT_ACTION_PLUGIN_OPEN_AND_REPLACE_URI);
      intent.putExtra(EXTRAS_REPLACEMENT, text);
      return this;
    }

    public IntentBuilder setLineIndexes(int[] indexes) {
      intent.putExtra(EXTRAS_LINE_INDEXES, indexes);
      return this;
    }

    public IntentBuilder setUri(String uri) {
      intent.putExtra(EXTRAS_URI, uri);
      return this;
    }

    public IntentBuilder setRepository(String repository) {
      intent.putExtra(EXTRAS_REPOSITORY, repository);
      return this;
    }

    public IntentBuilder setEdit(boolean edit) {
      intent.putExtra(EXTRAS_EDIT, edit);
      return this;
    }

    public Intent build() {
      return intent;
    }
  }

}
