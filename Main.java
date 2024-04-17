package com.anuj;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    //this arraylist stores arraylist of album
    private static ArrayList<Album> albums = new ArrayList<>();//this is defined as property of a class
    public static void main(String[] args) {
        Album album = new Album("album1" , "madhvas"); // object of Album class
        album.addSong("vrindavan dham", 2.5); //function of class
        album.addSong("radhey kishori", 5);
        album.addSong("mere banke bihari" , 8);
        albums.add(album); // add album in ArrayList

        album = new Album("album2" , " yash pratap");  //new album with name album2
        album.addSong("badmosi", 5.5);
        album.addSong("system", 6);
        album.addSong("splendar" , 2.5);
        albums.add(album);
        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("vrindavan dham" , playList_1);// zero is the index of arraylist of alnums
        // because zeroth index contains the album of artist madhvas
        albums.get(0).addToPlayList("radhey kishori" , playList_1);
        albums.get(1).addToPlayList("system" , playList_1);
        albums.get(1).addToPlayList("splendar" , playList_1);
    play(playList_1);
    }
    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size()==0){
            System.out.println("This playlist have no song");
        }else{
            System.out.println("now playing " + listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action = sc.nextInt();
            switch (action){
                case 0:
                    System.out.println("play list is complete");
                    quit = true;
                    break;
                case 1:
                  if(!forward){
                      if(listIterator.hasNext()){
                          listIterator.next();
                      }
                      forward = true;
                  }
                  if(listIterator.hasNext()){
                      System.out.println("now playing " + listIterator.next().toString());
                  }else {
                      System.out.println("No song available, reach to the end of the list");
                      forward = false;
                  }
                  break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("now playing " + listIterator.previous().toString());
                    }else {
                        System.out.println("we are at the first song");
                        //forward = false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("now playing " + listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the first song");
                            //forward = false;
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("now playing " + listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("No song available, reach to the end of the list");
                            forward = false;
                        }
                    }
                    break;
                case 4:
                    System.out.println(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing " + listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious()){
                                System.out.println("now playing " + listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }
    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator= playList.iterator();
        System.out.println("______________");
        while(iterator.hasNext()){ //it means while (iterator.hasNext()==true)
            System.out.println(iterator);
        }
        System.out.println("______________");
    }
}
