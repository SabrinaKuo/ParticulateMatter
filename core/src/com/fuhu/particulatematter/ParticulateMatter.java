package com.fuhu.particulatematter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fuhu.gdx.game.Game;
import com.fuhu.gdx.viewport.SafeZoneViewport;

public class ParticulateMatter extends Game {
	@Override
	protected void onCreate() {
		setScene(new MainScene());
	}

	@Override
	protected void onResume() {

	}

	@Override
	protected void onResize() {

	}

	@Override
	protected void onPause() {

	}

	@Override
	protected void onDispose() {

	}

	@Override
	protected Viewport createViewport() {
		return new SafeZoneViewport(
				new Vector2(2280, 1440),
				new Vector2(1920, 1128),
				new OrthographicCamera()
		);
	}

	@Override
	protected FileHandleResolver createFileHandleResolver() {
		return null;
	}

}
