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
    EnemyShip enemy;
	SpriteBatch batch;
	Texture background;
	int width;
	int height;
	int speed = 4; // Speed of the ship
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		ship = new SpaceShip();
		enemy = new EnemyShip();
		background = new Texture(Gdx.files.internal("spacebackground.jpg"));
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

		/*Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);*/
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();

		ship.render(batch);
		enemy.render(batch);

		if(isWPressed)
            ship.moveUp(speed);
		if(isAPressed)
		    ship.moveLeft(speed);
		if(isSPressed)
            ship.moveDown(speed);
		if(isDPressed)
		    ship.moveRight(speed);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

    public void update(){
            enemy.moveDown(speed);
    }
}
