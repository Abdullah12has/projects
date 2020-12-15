package GameInheritance;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Burcu
 */
public abstract class Game implements Comparable<Game> {

    protected int gameId;
    protected int publishedYear;
    protected String gameCategory;

   
    public Game(int gameId, int publishedYear, String gameCategory) {
        this.gameId = gameId;
        this.publishedYear = publishedYear;
        this.gameCategory = gameCategory;
    }

    public int getGameId() {
        return gameId;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public String getGameCategory() {
        return gameCategory;
    }

    @Override
    public String toString() {
        return "Game\n"
                + "Game Id= " + gameId
                + "\nPublished Year= " + publishedYear
                + "\nGame Category= " + gameCategory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.gameId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        return true;
    }


   

   
    
}
