This repository reproduces a bug where parallax animations are drawn in the wrong z-index order on compose-navigation 8.2.0-beta02 when predictive back animations are enabled

During predictive back press animation, the pop entering fragment is drawn over the pop exiting fragment, resulting in a really janky look.

When disabling `enableOnBackInvokedCallback` in manifest, everything looks as expected

