package models;

import org.sql2o.*;

public class DB {
    static String connectionString = "jdbc:postgresql://ec2-54-221-244-70.compute-1.amazonaws.com:5432/d75nqbrtgkl8pg"; //!
    static Sql2o sql2o = new Sql2o(connectionString, "hfhpieejzofgku", "1966461c5a10e29147dcaf17d56e9f17badd1ec4510e21dc5ca48bc78dc420af");
}