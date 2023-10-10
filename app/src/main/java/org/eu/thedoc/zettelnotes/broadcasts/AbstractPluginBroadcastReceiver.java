package org.eu.thedoc.zettelnotes.broadcasts;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import org.eu.thedoc.zettelnotes.interfaces.BuildConfig;

public abstract class AbstractPluginBroadcastReceiver
    extends BroadcastReceiver {

  protected static final String EXTRAS_URI = "extras-uri";
  protected static final String EXTRAS_REPOSITORY = "extras-repository";

  //intent action to open file uri in repository from Zettel Notes
  private static final String INTENT_ACTION_PLUGIN_OPEN_URI = "org.eu.thedoc.zettelnotes.broadcast.plugins.OPEN_URI";

  @Override
  public void onReceive(Context context, Intent intent) {
    Log.v("PluginBroadcastReceiver", "onReceive");
    if (intent != null) {
      String action = intent.getAction();
      if (action != null && action.equals(INTENT_ACTION_PLUGIN_OPEN_URI)) {
        openUri(intent);
      }
    }
  }

  protected abstract void openUri(Intent intent);

  public static class IntentBuilder {

    private final Intent intent;

    private IntentBuilder() {
      intent = new Intent();
      intent.setComponent(new ComponentName(BuildConfig.ZETTEL_PACKAGE_NAME, "org.eu.thedoc.zettelnotes.common.modules.BroadcastReceiver"));
    }

    public static IntentBuilder getInstance() {
      return new IntentBuilder();
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
