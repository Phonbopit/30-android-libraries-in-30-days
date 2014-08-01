package com.devahoy.learn30androidlibraries.day24;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.IResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.bitmap.AssetBitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import java.io.IOException;

public class AndEngineActivity extends SimpleBaseGameActivity {

    private static final int CAMERA_WIDTH = 800;
    private static final int CAMERA_HEIGHT = 480;

    private Camera mCamera;

    private ITextureRegion mTextureRegion;
    private ITexture mTexture;

    private AnimatedSprite mAnimatedSprite;
    private TiledTextureRegion mTiledTextureRegion;
    private BitmapTextureAtlas mBitmapTextureAtlas;

    @Override
    public EngineOptions onCreateEngineOptions() {
        mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        IResolutionPolicy resolutionPolicy =
                new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT);

        return new EngineOptions(true,
                ScreenOrientation.LANDSCAPE_FIXED,
                resolutionPolicy,
                mCamera);
    }

    @Override
    protected void onCreateResources() throws IOException {
        mTexture = new AssetBitmapTexture(getTextureManager(), getAssets(), "player.png");
        mTextureRegion = TextureRegionFactory.extractFromTexture(mTexture);
        mTexture.load();

        mBitmapTextureAtlas = new BitmapTextureAtlas(getTextureManager(), 100, 100, TextureOptions.BILINEAR);
        mTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory
                .createTiledFromAsset(mBitmapTextureAtlas, getAssets(), "npc-oldman1.png", 0, 0, 4, 1);

        mBitmapTextureAtlas.load();
    }

    @Override
    protected Scene onCreateScene() {
        Scene scene = new Scene();
        scene.getBackground().setColor(0.2f, 0.5f, 0.7f);

        Sprite sprite = new Sprite(mCamera.getWidth() / 2, mCamera.getHeight() / 2,
                mTextureRegion, getVertexBufferObjectManager());
        scene.attachChild(sprite);

        mAnimatedSprite = new AnimatedSprite(200, 200, mTiledTextureRegion, this.getVertexBufferObjectManager());
        long[] frameDuration = {500, 500, 500, 500};
        mAnimatedSprite.animate(frameDuration);
        scene.attachChild(mAnimatedSprite);

        return scene;
    }



}
