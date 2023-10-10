package org.eu.thedoc.zettelnotes.broadcasts;

import android.content.ComponentName;
import android.content.Intent;
import org.eu.thedoc.zettelnotes.interfaces.BuildConfig;

public class AbstractPluginReceiver {

  protected static final String EXTRAS_URI = "extras-uri";
  protected static final String EXTRAS_REPOSITORY = "extras-repository";

  //intent action to open file uri in repository from Zettel Notes
  private static final String INTENT_ACTION_PLUGIN_OPEN_URI = "org.eu.thedoc.zettelnotes.broadcast.plugins.OPEN_URI";

  public static class IntentBuilder {

    private static final String CLASS_NAME = "org.eu.thedoc.zettelnotes.common.modules.BroadcastReceiver";
    private final Intent intent;

    private IntentBuilder() {
      intent = new Intent();
      intent.setComponent(new ComponentName(BuildConfig.ZETTEL_PACKAGE_NAME, CLASS_NAME));
    }

    public static IntentBuilder getInstance() {
      return new IntentBuilder();
    }

    public IntentBuilder setDebug() {
      intent.setComponent(new ComponentName(BuildConfig.ZETTEL_PACKAGE_NAME_DEBUG, CLASS_NAME));
      return this;
    }

    public IntentBuilder setActionOpenUri() {
      intent.setAction(INTENT_ACTION_PLUGIN_OPEN_URI);
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

    public Intent build() {
      return intent;
    }
  }

}
