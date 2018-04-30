package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class GameRunner extends ApplicationAdapter {
    SpaceShip ship;
	SpriteBatch batch;
	Texture background;
	int width;
	int height;
	int enemySpeed = 2; // Speed of the enemy ship
    int shipSpeed = 4; // Speed of the player ship
    long startTime = startTime = System.currentTimeMillis();
    long bulletStartTime = System.currentTimeMillis();
    public final int TOP_OF_WINDOW = 580;

    ArrayList<EnemyShip> enemyList = new ArrayList<EnemyShip>();

    ArrayList<Bullet> bulletList = new ArrayList<Bullet>();

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

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();

        ship.render(batch);

        for(EnemyShip e : enemyList){
                e.render(batch);
        }

        for(Bullet b : bulletList){
            b.render(batch);
        }
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

    public void update(){
        Random rand = new Random();

	    if(System.currentTimeMillis() - startTime >= 1500){ // Algorithm
                int x = rand.nextInt(320);
                enemyList.add(new EnemyShip(x));
                startTime = System.currentTimeMillis();
        }

        for(int i = 0; i < enemyList.size(); i++){
            enemyList.get(i).moveDown(enemySpeed);

            if(enemyList.get(i).getY() == -100)
                enemyList.get(i).setY(TOP_OF_WINDOW);
        }

        for (int i = 0; i < bulletList.size(); i++) {
	        bulletList.get(i).moveUp();

	        for(int j = 0; j < enemyList.size(); j++){
	            if(enemyList.get(j).getBoundingBox().overlaps(bulletList.get(i).getBoundingBox())){
	                enemyList.remove(j);
	                bulletList.remove(i);
	                break;
                }
            }
        }

        boolean isAPressed = Gdx.input.isKeyPressed(Input.Keys.A);
        boolean isDPressed = Gdx.input.isKeyPressed(Input.Keys.D);
        boolean isSpacePressed = Gdx.input.isKeyPressed(Input.Keys.SPACE);

        if(isAPressed)
            ship.moveLeft(shipSpeed);
        if(isDPressed)
            ship.moveRight(shipSpeed);
        if(isSpacePressed && System.currentTimeMillis() - bulletStartTime >= 750){
            Bullet bullet = new Bullet(4);
            bullet.setY(ship.getY() + 40);
            bullet.setX(ship.getX() + 40);
            bulletList.add(bullet);
            bulletStartTime = System.currentTimeMillis();
        }

        Random randPos = new Random();

        for(EnemyShip e : enemyList) {
            int randX = randPos.nextInt(320);

            if (ship.getBoundingBox().overlaps(e.getBoundingBox())) {
                e.setX(randX);
                e.setY(640);
            }
        }
    }
}