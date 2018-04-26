package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class EnemyShip {

    private Vector2 position;
    private Texture enemy;

    public EnemyShip(int x){
        this.position = new Vector2();
        this.enemy = new Texture(Gdx.files.internal("enemyship.gif"));
        position.x = x;
        position.y = 580;
    }

    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(enemy, position.x, position.y);
        batch.end();
    }

    public void moveDown(int amount){
        position.y -= amount;
    }

    public float getY(){ return position.y; }

    public void setY(int amount){ position.y = amount; }

    public float getX(){ return position.x; }

    public void setX(int amount){ position.x = amount; }

}