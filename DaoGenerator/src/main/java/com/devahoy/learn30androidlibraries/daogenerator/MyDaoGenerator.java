package com.devahoy.learn30androidlibraries.daogenerator;

import java.io.File;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyDaoGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.devahoy.learn30androidlibraries");
        Entity player = schema.addEntity("Player");

        player.addIdProperty();
        player.addStringProperty("name");
        player.addStringProperty("club");

        File currentDirectory = new File(new File(".").getAbsolutePath());
        System.out.println(currentDirectory.getCanonicalPath());
        System.out.println(currentDirectory.getAbsolutePath());

        new DaoGenerator().generateAll(schema, args[0]);
    }
}
