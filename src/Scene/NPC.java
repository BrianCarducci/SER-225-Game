package Scene;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.Keyboard;
import GameObject.*;
import GameObject.Frame;
import GameObject.Rectangle;
import Utils.Timer;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class NPC extends MapEntity {
    protected boolean talkedTo = false;
    protected SpriteFont message;
    protected int talkedToTime;
    protected Timer timer = new Timer();

    public NPC(float x, float y, SpriteSheet spriteSheet, String startingAnimation, int talkedToTime, Map map) {
        super(x, y, spriteSheet, startingAnimation, map);
        this.message = createMessage();
        this.talkedToTime = talkedToTime;
    }

    public NPC(float x, float y, HashMap<String, Frame[]> animations, String startingAnimation, int talkedToTime, Map map) {
        super(x, y, animations, startingAnimation, map);
        this.message = createMessage();
        this.talkedToTime = talkedToTime;
    }

    public NPC(BufferedImage image, float x, float y, String startingAnimation, int talkedToTime, Map map) {
        super(image, x, y, startingAnimation, map);
        this.message = createMessage();
        this.talkedToTime = talkedToTime;
    }

    public NPC(BufferedImage image, float x, float y, int talkedToTime, Map map) {
        super(image, x, y, map);
        this.message = createMessage();
        this.talkedToTime = talkedToTime;
    }

    public NPC(BufferedImage image, float x, float y, int talkedToTime, float scale, Map map) {
        super(image, x, y, scale, map);
        this.message = createMessage();
        this.talkedToTime = talkedToTime;
    }

    public NPC(BufferedImage image, float x, float y, int talkedToTime, float scale, ImageEffect imageEffect, Map map) {
        super(image, x, y, scale, imageEffect, map);
        this.message = createMessage();
        this.talkedToTime = talkedToTime;
    }

    public NPC(BufferedImage image, float x, float y, int talkedToTime, float scale, ImageEffect imageEffect, Rectangle bounds, Map map) {
        super(image, x, y, scale, imageEffect, bounds, map);
        this.message = createMessage();
        this.talkedToTime = talkedToTime;
    }

    protected SpriteFont createMessage() {
        return null;
    }

    public void update(Keyboard keyboard, Player player) {
        super.update();
        checkTalkedTo(keyboard, player);
    }

    public void checkTalkedTo(Keyboard keyboard, Player player) {
        if (intersects(player) && keyboard.isKeyDown(Key.SPACE)) {
            talkedTo = true;
            timer.setWaitTime(talkedToTime);
        };
        if (talkedTo && timer.isTimeUp()) {
            talkedTo = false;
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        if (message != null && talkedTo) {
            drawMessage(graphicsHandler);
        }
    }

    public void drawMessage(GraphicsHandler graphicsHandler) {}
}
