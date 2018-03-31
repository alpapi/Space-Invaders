package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameRunner extends ApplicationAdapter {
    SpaceShip ship;
	SpriteBatch batch;
	int width;
	int height;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		ship = new SpaceShip();
	}

	@Override
	public void render () {
	    update();
		this.width = Gdx.graphics.getWidth();
		this.height = Gdx.graphics.getHeight();

        boolean isWPressed = Gdx.input.isKeyPressed(Input.Keys.W);
        boolean isAPressed = Gdx.input.isKeyPressed(Input.Keys.A);
        boolean isSPressed = Gdx.input.isKeyPressed(Input.Keys.S);
        boolean isDPressed = Gdx.input.isKeyPressed(Input.Keys.D);

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ship.render(batch);

		if(isWPressed)
            ship.moveUp(1);
		else if(isAPressed)
		    ship.moveLeft(1);
		else if(isSPressed)
		    ship.moveDown(1);
		else if(isDPressed)
		    ship.moveRight(1);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

    public void update(){

    }
}
