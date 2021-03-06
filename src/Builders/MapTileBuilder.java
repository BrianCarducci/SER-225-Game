package Builders;

import GameObject.Frame;
import Scene.Map;
import Scene.MapTile;
import Scene.TileType;

public class MapTileBuilder extends GameObjectBuilder {

    private TileType tileType = TileType.PASSABLE;
    private int tileIndex = -1;

    public MapTileBuilder(Frame frame) {
        super(frame);
    }

    public MapTileBuilder(Frame[] frames) {
        super(frames);
    }

    public MapTileBuilder withTileType(TileType tileType) {
        this.tileType = tileType;
        return this;
    }

    public MapTileBuilder withTileIndex(int tileIndex) {
        this.tileIndex = tileIndex;
        return this;
    }

    public MapTile build(float x, float y, Map map) {
        return new MapTile(x, y, cloneAnimations(), startingAnimationName, tileIndex, tileType, map);
    }
}
