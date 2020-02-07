package com.twu.biblioteca.model;

// Enum class: Used to define collections of constants

public enum Rating {
    ONE{
        @Override
        public String toString() {
            return "1";
        }
    }, TWO{
        @Override
        public String toString() {
            return "2";
        }
    }, THREE{
        @Override
        public String toString() {
            return "3";
        }
    }, FOUR{
        @Override
        public String toString() {
            return "4";
        }
    }, FIVE{
        @Override
        public String toString() {
            return "5";
        }
    }, SIX{
        @Override
        public String toString() {
            return "6";
        }
    }, SEVEN{
        @Override
        public String toString() {
            return "7";
        }
    }, EIGHT{
        @Override
        public String toString() {
            return "8";
        }
    }, NINE{
        @Override
        public String toString() {
            return "9";
        }
    }, TEN{
        @Override
        public String toString() {
            return "10";
        }
    }, UNRATED{
        @Override
        public String toString() {
            return "Unrated";
        }
    };
}
