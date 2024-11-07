package com.pluralsight.contracts;

import com.pluralsight.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {

    public static ArrayList<Contract> getFromCSV(String filename){

        ArrayList<Contract> results = new ArrayList<>();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            String line;

            while((line = bufferedReader.readLine()) != null){
                String[] newLine = line.split("\\|");
                if(newLine.length >= 16) {
                    if (newLine[0].equalsIgnoreCase("SALE")) {

                        SalesContract contract = new SalesContract(
                                newLine[1], // date
                                newLine[2], // name
                                newLine[3], //email
                                new Vehicle(
                                        Integer.parseInt(newLine[4]), //vin
                                        Integer.parseInt(newLine[5]), //year
                                        newLine[6], //make
                                        newLine[7], //model
                                        newLine[8], //vehicleType
                                        newLine[9], //color
                                        Integer.parseInt(newLine[10]), //miles
                                        Double.parseDouble(newLine[11]) //price
                                ),
                                Boolean.parseBoolean(newLine[12])
                        );
                        results.add(contract);

                    } else if (newLine[0].equalsIgnoreCase("LEASE")) {
                        LeaseContract contract = new LeaseContract(
                                newLine[1], // date
                                newLine[2], // name
                                newLine[3], //email
                                new Vehicle(
                                        Integer.parseInt(newLine[4]), //vin
                                        Integer.parseInt(newLine[5]), //year
                                        newLine[6], //make
                                        newLine[7], //model
                                        newLine[8], //vehicleType
                                        newLine[9], //color
                                        Integer.parseInt(newLine[10]), //miles
                                        Double.parseDouble(newLine[11]) //price
                                )
                        );
                        results.add(contract);
                    }

                }
            }
            bufferedReader.close();

            return results;

        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void saveToCSV(ArrayList<Contract> contracts, String filename){
        try {
            //Creating a file writer and assigning the file writer to the buffered writer.
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Contract contract : contracts){
                bw.write(getEncodedContracts(contract));
            }
            bw.close(); // Close the BufferedWriter

        } catch (IOException e) {
        }

    }

    private static String getEncodedContracts(Contract contract){
        return new StringBuilder()
                .append(contract.getDateOfContract()).append("|")
                .append(contract.getCustomerName()).append("|")
                .append(contract.getCustomerEmail()).append("|")
                .append(contract.getVehicleSold()).append("|")
                .append(contract.getTotalPrice()).append("|")
                .append(contract.getMonthlyPayment()).append("\n").toString();
    }




}