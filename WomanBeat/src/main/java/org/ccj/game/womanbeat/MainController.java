package org.ccj.game.womanbeat;

import org.ccj.Director;
import org.ccj.Event;
import org.ccj.Touch;
import org.ccj.base.Ref;
import org.ccj.d2.Label;
import org.ccj.d2.Sprite;
import org.ccj.d2.action.ScaleTo;
import org.ccj.d2.action.Sequence;
import org.ccj.editor.cce.Action;
import org.ccj.editor.cce.Bind;
import org.ccj.editor.cce.NodeController;
import org.ccj.editor.cce.NodeReader;

/**
 */
public class MainController extends NodeController {

    @Bind("bgMarket")
    public Sprite bgMarket;

    @Bind("aimGirl")
    public Sprite aimGirl;

    @Bind("scoreLabel")
    public Label scoreLabel;

    @Bind("timeLabel")
    public Label timeLabel;

    public float lastTime = MAXTIME;           // 游戏开始时间

    public static final float MAXTIME = 20;

    @Override
    public boolean onTouchBegan(Touch touch, Event event) {

        aimGirl.runAction(Sequence.create(ScaleTo.create(0,1f),ScaleTo.create(0.2f, 0.9f)));

        return super.onTouchBegan(touch, event);
    }

    @Override
    public void onTouchEnded(Touch touch, Event event) {
        super.onTouchEnded(touch, event);

        Global.score++;
        scoreLabel.setString(String.valueOf(Global.score));
    }

    @Override
    public void onEnter() {
        super.onEnter();

        setTouchEnabled(true);
        setTouchMode(Touch.MODE_ONE_BY_ONE);

        Global.score = 0;
        lastTime = MAXTIME;
    }

    @Override
    public void onExit() {
        super.onExit();
    }

    @Override
    public void onUpdate(float delta) {
        super.onUpdate(delta);

        lastTime = lastTime-delta;
        timeLabel.setString(String.valueOf((int)lastTime));
        if (lastTime < 0) {
            Director.getInstance().replaceScene(NodeReader.create().readScene("layouts/result.cce"));
        }
    }

    @Bind("closeButton")
    @Action(Action.ActionType.WidgetTouchUp)
    public void onCloseClicked(Ref ref) {
        Director.getInstance().end();
    }
}
