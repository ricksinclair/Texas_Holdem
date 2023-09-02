package com.ulrictodman.texas_holdem.model;

import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

public class Player {

    @Id
    private int id;
    private List<Card> hand;
    private String firstName;
    private String lastName;
    private int age;
    private String userName;
    private int chips;


    public Player( String firstName, String lastName, int age, String userName ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.userName = userName;

    }

    public Player(){
        this.hand = new ArrayList<> ();
        clearHand ();
    }

    public List<Card> getHand() {
        return hand;
    }

    public void clearHand(){
        this.hand.clear();
    }
    public void setHand( List<Card> hand ) {
        this.hand = hand;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge( int age ) {
        this.age = age;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public int getChips(){
        return this.chips;
    }


    public void setChips(int chips){
        this.chips = chips;
    }


}
