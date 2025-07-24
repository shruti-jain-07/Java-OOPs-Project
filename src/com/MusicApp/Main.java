package com.MusicApp;
import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Barfi!", "Pritam");

        album.addSong("Ala Barfi", 3.2);
        album.addSong("Main Kya Karoon", 3.5);
        album.addSong("Phir Le Aya Dil", 4.2);
        album.addSong("Aashiyan", 3.8);
        album.addSong("Saawali Si Raat", 2.7);
        albums.add(album);

        album = new Album("Rockstar", "A.R. Rahman");
        album.addSong("Phir Se Ud Chala", 3.6);
        album.addSong("Jo Bhi Main", 4.5);
        album.addSong("Katiyan Karun", 4.8);
        album.addSong("Kun Faya Kun", 3.1);
        album.addSong("Sheher Mein", 3.7);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Ala Barfi", playList_1);
        albums.get(0).addToPlayList("Main Kya Karoon", playList_1);
        albums.get(1).addToPlayList("Phir Se Ud Chala", playList_1);
        albums.get(1).addToPlayList("Sheher Mein", playList_1);
        albums.get(1).addToPlayList("Kun Faya Kun", playList_1);

        play(playList_1);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("This PlayList Have No Song\n");
        } else {
            System.out.println("Now Playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("PlayList Is Complete\n");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now Playing " + listIterator.next().toString());
                    } else {
                        System.out.println("No Song Available, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now Playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We Are The First Song");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We Are At The Start Of The List\n");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now Playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We Have Reached To The End Of The Playlist\n");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing  "+ listIterator.next().toString());
                        }
                        else{
                            if(listIterator.hasPrevious()) {
                                System.out.println("Now Playing "+ listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available Options \n Press");
        System.out.println("0- Quit\n" + "1- To Play Next Song\n" + "2- To Play Previous Song\n" + "3- To Replay The Current Song\n" + "4- List Of All The Songs\n" + "5- Print All Available Options\n" + "6- Delete The Current Song FRom Playlist\n");

    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("----------------");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("------------------");
    }
}

