package org.ccj.game.womanbeat;

import org.ccj.Director;
import org.ccj.Scheduler;
import org.ccj.editor.cce.NodeController;
import org.ccj.editor.cce.NodeReader;

/**
 * Created by Allen on 2014-9-17.
 */
public class LoadingController extends NodeController {
    @Override
    public void onEnter() {
        super.onEnter();

        owner.scheduleOnce(new Scheduler.SchedulerCallback() {
            @Override
            public void onUpdate(float delta) {
                Director.getInstance().replaceScene(NodeReader.create().readScene("layouts/main.cce"));
            }
        }, 3);
    }
}
