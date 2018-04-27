package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SpaceShip {

    private Vector2 vector;
    private Texture ship;

    public SpaceShip(){
        this.vector = new Vector2();
        this.ship = new Texture(Gdx.files.internal("spaceship.png"));
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

    public void setY(int amount) {vector.y = amount;}

    public void moveRight(float amount){
        vector.x += amount;
    }

    public void moveLeft(float amount){
        vector.x -= amount;
    }

    public Rectangle getBoundingBox(){
        Rectangle shipRect = new Rectangle();
        shipRect.x = vector.x;
        shipRect.y = vector.y;
        shipRect.width = ship.getWidth();
        shipRect.height = ship.getHeight();

        return shipRect;
    }

}