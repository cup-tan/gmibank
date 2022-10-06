package com.gmibank.utilities;

import com.gmibank.pojos.Country1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTxt {
    public static List<String> returnCountry1IdList(String filePath){
        List<String> all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Country1 country6 = new Country1();
                country6.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();
                System.out.println(i++);
                all.add(String.valueOf(country6.getId()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }
}
