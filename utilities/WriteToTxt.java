package com.gmibank.utilities;

import com.gmibank.pojos.Country1;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {

    public static void saveDataInFileWithCountry1Id(String fileName, Country1[] countries) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < countries.length; i++)
                writer.append(countries[i].getId() + "\n");
            writer.close();
        } catch (Exception e) {
        }
    }

}
