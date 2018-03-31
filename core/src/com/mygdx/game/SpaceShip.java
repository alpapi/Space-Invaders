package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class SpaceShip {

    private Vector2 vector;
    private Texture ship;

    public SpaceShip(){
        this.vector = new Vector2();
        ship = new Texture(Gdx.files.internal("spaceship.png"));
    }

    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(ship, vector.x, vector.y);
        batch.end();
    }

    public float getX(){
        return vector.x;
    }

    public float getY(){
        return vector.y;
    }

    public void moveRight(float amount){
        vector.x += amount;
    }

    public void moveLeft(float amount){
        vector.x -= amount;
    }

    public void moveUp(float amount){
        vector.y += amount;
    }

    public void moveDown(float amount){
        vector.y -= amount;
    }

}
