package com.example.e176688c.androidmovieproject;


public class Genre {
        int id;
        String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return getName();
        }
}
