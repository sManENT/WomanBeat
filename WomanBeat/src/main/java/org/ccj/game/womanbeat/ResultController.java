package org.ccj.game.womanbeat;

import org.ccj.Scheduler;
import org.ccj.d2.Label;
import org.ccj.editor.cce.Bind;
import org.ccj.editor.cce.NodeController;

/**
 * Created by Allen on 2014-9-17.
 */
public class ResultController extends NodeController {

    @Bind("scoreLabel")
    public Label scoreLabel;

    int score = 0;
    int scoreShow = 0;
    @Override
    public void onEnter() {
        super.onEnter();

        score = Global.score;

        owner.scheduleOnce(new Scheduler.SchedulerCallback() {
            @Override
            public void onUpdate(float delta) {
                super.onUpdate(delta);

                if(scoreShow < score) {
                    scoreShow++;
                    scoreLabel.setString(String.valueOf(scoreShow));
                }
            }
        }, 0.3f);
    }

    @Override
    public void onExit() {
        super.onExit();
    }
}
