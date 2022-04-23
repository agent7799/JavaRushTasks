package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public Snake(int x, int y) {
        isAlive = true;
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x ,y));
    }

    int getX(){
       return sections.get(0).getX();
    }

    int getY(){
       return sections.get(0).getY();
    }

    void move(){
        if (isAlive){
            switch (direction) {
                case UP :
                    move(0, -1);
                    break;
                case RIGHT:
                    move(1, 0);
                    break;
                case DOWN:
                    move(0, 1);
                    break;
                case LEFT:
                    move(-1, 0);
                    break;
            }
        }


    }


    void move(int x, int y){
    }

    void checkBorders(SnakeSection head){
        if (head.getX() < 0 || head.getX() >= Room.game.getWidth()){
            isAlive = false;
        }
        if (head.getY() < 0 || head.getY() >= Room.game.getHeight()){
            isAlive = false;
        }
    }

    void checkBody(SnakeSection head){
        if (sections.contains(head)){
            isAlive = false;
        }
    }
}
