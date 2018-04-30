package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet {

    private float speed;
    private Vector2 vector;
    private Texture bullet;
    private SpaceShip ship;


    public Bullet(float speed){
        this.speed = speed;
        this.vector = new Vector2();
        bullet = new Texture(Gdx.files.internal("bullet.png"));
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(bullet, vector.x, vector.y);
        batch.end();
    }

    public void moveUp(){
        vector.y += speed;
    }

    public void setX(float amount){
        vector.x += amount;
    }

    public void setY(float amount){
        vector.y += amount;
    }

    public Rectangle getBoundingBox(){
        Rectangle bulletRect = new Rectangle();

        bulletRect.x = vector.x;
        bulletRect.y = vector.y;
        bulletRect.width = bullet.getWidth();
        bulletRect.height = bullet.getHeight();

        return bulletRect;
    }

}
