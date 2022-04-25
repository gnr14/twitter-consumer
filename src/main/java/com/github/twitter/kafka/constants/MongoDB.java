package com.github.twitter.kafka.constants;

public class MongoDB {

    public static final String USERNAME = "xxxxx";
    public static final String PASSWORD = "xxxxx";
    public static final String DB_NAME = "twitterDB";
    public static final String TABLE_NAME = "TweetData";
    public static final String URL =
            "mongodb+srv://" + USERNAME + ":" + PASSWORD + "@cluster0.bzzm5.mongodb.net/" + DB_NAME
                    + "?retryWrites=true&w=majority";
}
