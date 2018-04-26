package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

public class GameRunner extends ApplicationAdapter {
    SpaceShip ship;
	SpriteBatch batch;
	Texture background;
	int width;
	int height;
	int enemySpeed = 3; // Speed of the enemy ship
    int shipSpeed = 4; // Speed of the player ship
    long startTime = startTime = System.currentTimeMillis();
    public final int TOP_OF_WINDOW = 580;
    ArrayList<EnemyShip> enemyList = new ArrayList<EnemyShip>();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		ship = new SpaceShip();
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

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();

        ship.render(batch);

        for(EnemyShip e : enemyList){
                e.render(batch);
        }

		if(isWPressed)
            ship.moveUp(shipSpeed);
		if(isAPressed)
		    ship.moveLeft(shipSpeed);
		if(isSPressed)
            ship.moveDown(shipSpeed);
		if(isDPressed)
		    ship.moveRight(shipSpeed);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

    public void update(){
        Random rand = new Random();

	    if(System.currentTimeMillis() - startTime >= 3000){
                int x = rand.nextInt(350);
                enemyList.add(new EnemyShip(x));
        }

        for(int i = 0; i < enemyList.size(); i++){
            enemyList.get(i).moveDown(enemySpeed);

            if(enemyList.get(i).getY() == -100)
                enemyList.get(i).setY(TOP_OF_WINDOW);
        }
    }
}
