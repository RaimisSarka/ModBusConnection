package com.company;

import de.re.easymodbus.exceptions.ModbusException;
import de.re.easymodbus.modbusclient.ModbusClient;

import java.io.IOException;
import java.net.UnknownHostException;


public class Main {

    public static void main(String[] args) {

        ModbusClient mClient = new ModbusClient();
        try {
            mClient.Connect("127.0.0.1", 502);
            int[] input = mClient.ReadHoldingRegisters(499, 6);
            for (int i = 0; i< input.length; i++){
                System.out.println(input[i]);
            }
            mClient.WriteSingleRegister(501, 666);
        } catch (UnknownHostException e){
            System.out.println(e.getMessage().toString());
        } catch (IOException e) {
            System.out.println(e.getCause().toString());
        } catch (ModbusException e) {
            System.out.println(e.getMessage().toString());
        }

    }
}
