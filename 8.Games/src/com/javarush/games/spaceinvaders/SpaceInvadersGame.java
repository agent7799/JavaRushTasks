package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.*;

public class SpaceInvadersGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private EnemyFleet enemyFleet = new EnemyFleet();


    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    public void onTurn(int step){
        drawScene();
    }

    private void createGame(){
        createStars();
        enemyFleet = new EnemyFleet();
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene(){
        drawField();
        enemyFleet.draw(this);
    }

    private void drawField(){
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }
        for (Star s : stars){
            s.draw(this);
        }
    }

    private List<Star> stars;


    private  void createStars(){
        stars = new ArrayList<Star>();
        int numberOfStars = 8;
        for (int i = 0; i < numberOfStars; i++) {
            stars.add(i, new Star((int)(Math.random()*HEIGHT), (int)(Math.random()*WIDTH)));
        }
    }

}
